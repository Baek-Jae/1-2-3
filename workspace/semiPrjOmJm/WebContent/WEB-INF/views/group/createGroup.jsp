<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= root %>/css/createGroup.css" />
</head>
<body>
	<section class="group_wrap">
            <div class="group_outer">
                <div class="group_head">
                    <h2>나만의 그룹 만들기</h2>
                </div>
                <form action="" method="post" enctype="multipart/form-data">
                    <div class="group_top">
                        <div class="group_pic">
                            <div id="group_img"><img src="<%= root %>/resources/testImg.png" alt="프로필사진" /></div>
                            <input type="file" value="사진첨부" name="group_file" />
                        </div>
                        <div class="group_info">
                            <div class="group_profile">
                                <input type="text" name="group_name" required />
                                <label for="group_name">모임명</label>
                            </div>
                            <div class="group_profile">
                                <input type="text" name="group_category" required />
                                <label for="group_category">카테고리</label>
                            </div>
                            <div class="group_profile">
                                <input type="text" name="group_place" required />
                                <label for="group_place">지역</label>
                            </div>
                            <div class="group_cnt">
                                <div class="group_memberCnt">
                                    <span class="material-symbols-outlined"> group </span>
                                    <input type="number" min="0" max="10" step="1" name="userCnt"/>
                                    <label>/ 10</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="group_content">
                        <textarea placeholder="모임소개" name="group_content"></textarea>
                    </div>
                    <div class="group_hashtag">
                        <input type="text" name="group_hash" required />
                        <label for="group_hash">#해시태그</label>
                    </div>
                    <div class="group_check">
                        <input type="submit" value="생 성" />
                        <input type="button" value="취 소" />
                    </div>
                </form>
            </div>
        </section>
</body>
</html>