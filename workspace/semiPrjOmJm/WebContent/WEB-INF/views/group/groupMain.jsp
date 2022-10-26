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
<script defer src="<%= root %>/javaScript/groupMain.js"></script>
</head>
<body>
	<section class="content-wrap">
            <div class="group-profile-pic">
                <img src="<%= root %>/${GroupMainPic.filePath}/${GroupMainPic.changeName}" alt="프로필사진" />
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
                            <textarea readonly class="addr" id="group_content">${groupInfo.content}</textarea>
                        </div>
                        <div class="menu-title"><h3>오프라인</h3></div>
                        <div class="group-menu-content">
                        <c:forEach items="${offList}" var="i">
                            <div class="off-group">
                                <div class="off-title">
                                    <span>${i.name}</span>
                                </div>
                                <div class="off-leader">
                                    <span class="material-symbols-outlined" id="off-leader-icon">workspace_premium</span>
                                    <span>${i.leaderNo}</span>
                                </div>
                                <div class="off-date">
                                    <span class="material-symbols-outlined" id="off-date-icon">calendar_month</span>
                                    <span>${i.offDate}</span>
                                </div>
                                <div class="off-max-member">
                                    <span class="material-symbols-outlined" id="off-maxMember-icon"> group </span>
                                    <span>${i.userCnt} /10</span>
                                </div>
                                <button class="show">참여하기 <i class="fa-solid fa-angles-right fa-beat-fade"></i></button>
                            </div>
						</c:forEach>
                        </div>
                        <a href="<%= root %>/offgroup/create"><span class="material-symbols-outlined" id="add-icon"> add </span>오프라인</a>
                    </div>
                </div>
            </div>
        </section>
        <section class="modal">
        <c:forEach items="${offList}" var="i">
	        <div class="offModal_wrap close">
	            <div class="offGroup_info">
	                <div class="offGroup_header">
	                    <div class="offGroup_name">${i.name}</div>
	                </div>
	                <div class="offGroup_body">
	                    <div class="offGroupDate">
	                        <span class="material-symbols-outlined" id="off-date-icon">calendar_month</span>
	                        <div class="offGroup_date">${i.offDate}</div>
	                    </div>
	                    <div class="offGroup_member">
	                        <button class="OffmemberList">
	                            <span class="material-symbols-outlined" id="offGroup_member"> group </span>
	                            ${i.userCnt}/10
	                        </button>
	                    </div>
	                </div>
	                <div class="offGroup_bottom">
	                    <textarea readonly class="offGroup_content">${i.content}</textarea>
	                </div>
	                <div class="off_comment_header">
	                	<span>Comment</span>
	                </div>
	                
	                
	                
	                <div class="offGroup_comment_bottom">
	                	<span>usernick</span>
	                	<span>댓글내용</span>
	                	<button>수정</button>
	                	<button>삭제</button>
	                </div>
	                
	                <div class="my_comment">
	                
	                </div>
	                
	                <div class="offGroup_comment">
	                	<input type="text" name="off_Comment" id="off_comment">
	                	<button class="comment-submit">작성</button>
	                </div>
	                
	                <c:if test="${ad}"></c:if>
	                <button class="offGroup_invite">가 입</button>
	                <button class="offGroup_close">
	                    <span class="material-symbols-outlined" id="close_modal"> close </span>
	                </button>
	            </div>
	        </div>
	        </c:forEach>
	        
        </section>
        <script>
       		const returnIndex = $('.comment-submit').on('click', function() {
        	  var indexNo = returnIndex.index(this);
        	  console.log(indexNo)
        	  return indexNo;
        	});
	    	function addComent(returnIndex){
	        	console.log($('.comment-submit'));
		        $.ajax({
		        	url: "/offgroup/comment/write",
		            type: "post",
		            data: {
		            	"offNo" : ${offList[returnIndex].no},
		                "member" : ${loginMember.no},
		                "content" : $('#off_comment')[returnIndex].val()
		                },
	               	success: function (result) {
			              		alert("자가보자~");
			              		const myComment = JSON.parse(result);
			              		let newComment = "<span>"+myComment.nick+"</span>";
			              		newComment += "<span>"+myComment.content+"</span>";
			              		newComment += "<button class=\"comment-submit\">수정</button>";
			              		newComment += "<button class=\"comment-submit\">삭제</button>";
			              		$('.my_comment')[returnIndex].append(myComment);
							},
                	error: function () {
                		alert("작성실패...ㅜㅜ");
					}
                })
        </script>
</body>
</html>