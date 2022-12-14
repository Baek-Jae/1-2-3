<%@page import="kh.semi.omjm.group.vo.GroupVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
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
                	<div class="name">
                    <h1>${groupInfo.name}</h1>
                    <div class="like">
		            	<i class=" fa-regular fa-heart" id="dontLike"></i>
		            	<i class="fa-solid fa-heart close" id="like" style="color:red;"></i>
		            	<span>18.8k</span>
		            </div>
                    </div>
                    <div class="group-leader">
                        <i class="fa-solid fa-anchor"></i>
                        <h3>${groupInfo.leader}</h3>
                    </div>
                </div>
                <div class="group-content">
                    <div class="group-menu">
                        <ul>
                        	<li>
                                <div class="user_controller">
						            
						            <div class="location">
						            	<i class="fa-regular fa-font-awesome"></i>
						            	<span>${groupInfo.place}</span>
						            </div>
						            <div class="category">
						            	<i class="fa-solid fa-bookmark"></i>
						            	<span>${groupInfo.category}</span>
						            </div>
						            <div class="showMember">
						            	<span class="material-symbols-outlined" id="groupMember">group</span>
						            	<span>${groupMemberList.size()+1} /${groupInfo.userCnt}</span>
						            </div>
						            <c:if test="${gmemberCheck ne 'true' and groupInfo.leader ne loginMember.nick and not empty loginMember}">
									<div class="joinGroup">
						            	<i class="fa-solid fa-arrow-right-to-bracket" id="joinGroup"></i>
						            	<span>Join</span>
						            </div>
						            </c:if>
						            <c:if test="${gmemberCheck eq 'true'}">
									<div class="quitGroup">
						            	<i class="fa-solid fa-arrow-right-from-bracket"></i>
						            	<span>Quit</span>
						            </div>
						            </c:if>
						            <c:if test="${groupInfo.leader eq loginMember.nick}">
					            	<div class="deleteGroup">
						            	<i class="fa-solid fa-x"></i>
						            	<span>Delete</span>
						            </div>
						            </c:if>
					            </div>
                            </li>
                        </ul>
                    </div>
                    <div class="group-info">
                        <div class="group-info-detail">
                        	<div class="welcome"><h2>Welcome to ${groupInfo.name}</h2></div>
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
                                    <span>${i.userCnt}명 모집</span>
                                </div>
                                <c:if test="${not empty loginMember or gmemberCheck eq 'true'}">
                                <a href="<%=root %>/group/off?ono=${i.no}">
                                <span class="material-symbols-outlined">subdirectory_arrow_right</span>
                                 들어가기</a>
                                 </c:if>
                            </div>
						</c:forEach>
                        </div>
                        <c:if test="${gmemberCheck eq 'true' or loginMember.nick eq groupInfo.leader}">
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
                        <span>${groupInfo.name}</span>
                    </div>
					<c:forEach items="${groupMemberList}" var="i">
					<div class="gmember_info">
                        <div class="gMemberNick"><span>${i.userNo}</span></div>
                        <div class="off_membertemp">매너온도미완성</div>
                    </div>
                    <c:if test="${groupInfo.leader eq loginMember.nick}">
                    <div class="member_controller">
                        <button class="expulsion" onclick="expulsionMember(this)">추 방</button>
                    </div>
                    </c:if>
                    </c:forEach>
                    
                <button class="memberlist_close">
                	<span class="material-symbols-outlined"> close </span>
               	</button>
            </div>
        </section>
        <c:if test="${not empty loginMember}">
	        <script>
	        //멤버추방
					function expulsionMember(obj){
						const no = $('.expulsion').index(obj);
						let gname = confirm("소중한 멤버를 추방하시겠습니까?");
						if(gname){
							$.ajax({
								url: "<%= root %>/group/member/exclude",
								type: "post",
								data:{
									"gmemberNick" : $($('.gMemberNick > span')[no]).text(),
									"groupNo" : ${groupInfo.no}
								},
								success:(result)=>{
									alert($($('.gMemberNick > span')[no]).text()+"님을 추방하였습니다.");
									location.reload();
								},
								error:()=>{
									alert("추방 실패,...ㄷㄷ");
								}})//ajax
						} else {
							alert("휴... 추방하지 말아주세요..");
						}
						
					}//fn
	        
		        $('.deleteGroup').click(
						function deleteGroup() {
							let gname = prompt("삭제하시려면 모임명을 입력하세요.");
							if(gname == ${groupInfo.name}){
								$.ajax({
									url: "<%= root %>/group/deleteGroup",
									type: "post",
									data:{
										"groupNo" : ${groupInfo.no}
									},
									success:(result)=>{
										alert("다음에 또 만나요 멤버들이 많이 아쉬울거에요");
										location.href="<%=root%>";
									},
									error:()=>{
										alert("삭제 실패,...ㄷㄷ");
									}})//ajax
							} else {
								alert("휴... 삭제하지 말아주세요..");
							}
						}//fn
					);//event
	        
	        
	      		$('.joinGroup').click(
					function joinGroup() {
						if(${groupInfo.userCnt} > ${groupMemberList.size()+1}){
							let checkJoin = confirm(${groupInfo.name}+"에 참여하시겠습니까?");
							if(checkJoin != 'false'){
								$.ajax({
									url: "<%= root %>/group/joinMember",
									type: "post",
									data:{
										"joinMemberNo": ${loginMember.no},
										"groupNo" : ${groupInfo.no}
									},
									success:(result)=>{
										alert(${groupInfo.name}+"에 오신걸 환영합니다");
										location.reload();
									},
									error:()=>{
										alert("가입 실패,...ㄷㄷ");
									}
								})//ajax
							}//if
						}//if
					}//fn
				);//event
				
				//그룹탈퇴
				$('.quitGroup').click(
					function quitGroup() {
						let checkQuit = confirm("한번 탈퇴한 모임에는 참여가 불가능합니다. 신중하게 생각해주세요");
						if(checkQuit != false){ 
							$.ajax({
								url: "<%= root %>/group/quitMember",
								type: "post",
								data:{
									"quitMemberNo": ${loginMember.no},
									"groupNo" : ${groupInfo.no}
								},
								success:(result)=>{
									alert("모임에서 탈퇴하였습니다");
									location.reload();
								},
								error:()=>{
									alert("탈퇴 실패,...ㄷㄷ");
								}
							})//ajax
					}}//event
				);//event
			
	        </script>
        </c:if>
</body>
</html>