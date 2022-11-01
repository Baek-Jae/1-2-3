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
            <div class="user_controller">
	            <div class="like">
	            	<i class=" fa-regular fa-heart" id="dontLike"></i>
	            	<i class="fa-solid fa-heart close" id="like" style="color:red;"></i>
	            </div>
	            <div class="showMember">
	            	<span class="material-symbols-outlined" id="groupMember">group</span>
	            </div>
	            <c:if test="${gmemberCheck ne 'true'}">
				<div class="joinGroup">
	            	<i class="fa-solid fa-arrow-right-to-bracket" id="joinGroup"></i>
	            </div>
	            </c:if>
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
                        	<div><h2>Welcome to ${groupInfo.name}</h2></div>
                            <textarea readonly class="addr" id="group_content" >${groupInfo.content}</textarea>
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
                                    <span>${i.userCnt}</span>
                                </div>
                                <a href="<%=root %>/group/off?ono=${i.no}">
                                <span class="material-symbols-outlined">subdirectory_arrow_right</span>
                                 들어가기</a>
                            </div>
						</c:forEach>
                        </div>
                        <c:if test="${gmemberCheck eq 'true'}">
                        <a href="<%= root %>/offgroup/create"><span class="material-symbols-outlined" id="add-icon"> add </span>오프라인</a>
                        </c:if>
                    </div>
                </div>
            </div>
        </section>
        <section class="modal">
        	<div class="gmember_wrap close">
              	  	<div class="gleader_info">
              	  		<i class="fa-solid fa-anchor"></i>
                        <span>${groupInfo.leader}의 ${groupInfo.name}</span>
                        <div class="gmembertemp">매너온도미완성</div>
                    </div>
               	<c:if test="${empty groupMemberList}">
               		<div class="gmember_info">
               			<div id="first_member">
                        	<span >첫번째 참여자가 되어보세요!</span>
               			</div>
                    </div>
               	</c:if>
					<c:forEach items="${groupMemberList}" var="i">
                    <div class="gmember_info">
                        <div class="gMemberNick"><span>${i.userNo}</span></div>
                        <div class="off_membertemp">매너온도미완성</div>
                    </div>
                    <c:if test="${groupInfo.leader eq loginMember.nick}">
                    <div class="member_controller">
                        <button class="expulsion">추 방</button>
                        <button class="participation">참 가</button>
                        <button class="absence">불 참</button>
                    </div>
                    </c:if>
                    </c:forEach>
                <button class="memberlist_close">
                	<span class="material-symbols-outlined"> close </span>
               	</button>
            </div>
        </section>
        <script>
	        $('#like').click(()=>{
	    		$('#dontLike').removeClass("close");
	    		$('#like').addClass("close")
	    		
	    	});
	    	
	    	 $('#dontLike').click(()=>{
	    		$('#like').removeClass("close");
	    		$('#dontLike').addClass("close")
	    		
	    	});
	    	
	        $('.memberlist_close').click(()=>{
	    		$('.gmember_wrap').addClass("close");
	    	});
	        	
	        $('#groupMember').click(()=>{
	        	$('.gmember_wrap').toggleClass("close");	
	        })	
        
       		$('#group-menu-content').click(()=>{
	        	$('.gmember_wrap').removeClass("close");	
	        })
   
      		$('.joinGroup').click(
			function joinGroup() {
				$.ajax({
					url: "<%= root %>/group/joinMember",
					type: "post",
					data:{
						"joinMemberNo": ${loginMember.no},
						"groupNo" : ${groupInfo.no}
					},
					success:(result)=>{
						$('.joinGroup').remove();
					},
					error:()=>{
						alert("가입 실패,...ㄷㄷ");
					}
				})//ajax
			}//event
		);//event
       	
        </script>
</body>
</html>