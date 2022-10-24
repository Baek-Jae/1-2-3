<%@page import="kh.semi.omjm.group.vo.GroupVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= root %>/css/groupMain.css" />
</head>
<body>
	<section class="content-wrap">
            <div class="group-profile-pic">
                <img src="/login/login.png" alt="" />
            </div>
            <div class="group-info-wrap">
                <div class="group-name">
                    <h1>${groupInfo.name}</h1>
                    <div class="group-leader">
                        <i class="fa-solid fa-anchor"></i>
                        <h3>${groupInfo.leader}</h3>
                    </div>
                </div>
                <div class="group-content">
                    <div class="group-menu">
                        <ul>
                            <li>
                                <input type="radio" name="off-group" id="off-group" />
                                <label for="off-group" class="off-btn">오프라인</label>
                            </li>
                            <li>
                                <input type="radio" name="board-group" id="board-group" />
                                <label for="board-group" class="board-group-btn">게시판</label>
                            </li>
                        </ul>
                    </div>
                    <div class="group-info">
                        <div class="group-info-detail">
                            <textarea readonly class="addr">${groupInfo.content}</textarea>
                        </div>
                        <script>
                            var txtArea = $('.addr');
                            if (txtArea) {
                                txtArea.each(function () {
                                    $(this).height(this.scrollHeight);
                                });
                            }
                        </script>
                        <div class="menu-title"><h3>오프라인</h3></div>
                        <div class="group-menu-content">
                            <div class="off-group">
                                <div class="off-title">
                                    <span>삼겹살 드실분</span>
                                </div>
                                <div class="off-leader">
                                    <span class="material-symbols-outlined" id="off-leader-icon">workspace_premium</span>
                                    <span>리더</span>
                                </div>
                                <div class="off-date">
                                    <span class="material-symbols-outlined" id="off-date-icon">calendar_month</span>
                                    <span>2022/10/31</span>
                                </div>
                                <div class="off-max-member">
                                    <span class="material-symbols-outlined" id="off-maxMember-icon"> group </span>
                                    <span>10 /10</span>
                                </div>
                                <a href=""> 참여하기 <i class="fa-solid fa-angles-right fa-beat-fade"></i></a>
                            </div>
                            <div class="off-group">
                                <div class="off-title">
                                    <span>삼겹살 드실분</span>
                                </div>
                                <div class="off-leader">
                                    <span class="material-symbols-outlined" id="off-leader-icon">workspace_premium</span>
                                    <span>리더</span>
                                </div>
                                <div class="off-date">
                                    <span class="material-symbols-outlined" id="off-date-icon">calendar_month</span>
                                    <span>2022/10/31</span>
                                </div>
                                <div class="off-max-member">
                                    <span class="material-symbols-outlined" id="off-maxMember-icon"> group </span>
                                    <span>10 /10</span>
                                </div>
                                <a href=""> 참여하기 <i class="fa-solid fa-angles-right fa-beat-fade"></i></a>
                            </div>
                            <div class="off-group">
                                <div class="off-title">
                                    <span>삼겹살 드실분</span>
                                </div>
                                <div class="off-leader">
                                    <span class="material-symbols-outlined" id="off-leader-icon">workspace_premium</span>
                                    <span>리더</span>
                                </div>
                                <div class="off-date">
                                    <span class="material-symbols-outlined" id="off-date-icon">calendar_month</span>
                                    <span>2022/10/31</span>
                                </div>
                                <div class="off-max-member">
                                    <span class="material-symbols-outlined" id="off-maxMember-icon"> group </span>
                                    <span>10 /10</span>
                                </div>
                                <a href=""> 참여하기 <i class="fa-solid fa-angles-right fa-beat-fade"></i></a>
                            </div>
                            <div class="off-group">
                                <div class="off-title">
                                    <span>삼겹살 드실분</span>
                                </div>
                                <div class="off-leader">
                                    <span class="material-symbols-outlined" id="off-leader-icon">workspace_premium</span>
                                    <span>리더</span>
                                </div>
                                <div class="off-date">
                                    <span class="material-symbols-outlined" id="off-date-icon">calendar_month</span>
                                    <span>2022/10/31</span>
                                </div>
                                <div class="off-max-member">
                                    <span class="material-symbols-outlined" id="off-maxMember-icon"> group </span>
                                    <span>10 /10</span>
                                </div>
                                <a href=""> 참여하기 <i class="fa-solid fa-angles-right fa-beat-fade"></i></a>
                            </div>
                        </div>
                        <a href="<%= root %>/offgroup/create"><span class="material-symbols-outlined" id="add-icon"> add </span>오프라인</a>
                    </div>
                </div>
            </div>
        </section>
</body>
</html>