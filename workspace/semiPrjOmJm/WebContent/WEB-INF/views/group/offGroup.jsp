<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= root %>/css/detailOffGroup.css" />
<script defer src="<%= root %>/javaScript/offGroupMain.js"></script>
</head>
<body>
	 <main class="offGroup_wrap">
            <div class="mainGroup_img">
            	<img src="<%= root %>/${GroupMainPic.filePath}/${GroupMainPic.changeName}" alt="그룹메인사진" />
            </div>
            <div class="offGroup_info">
                <div class="offGroup_header">
                    <div class="offGroup_name"><span>${offGroup.name}</span></div>
                    <div class="offGroup_leader"><span class="material-symbols-outlined"> tsunami </span><span>${offGroup.leaderNo}</span></div>
                </div>

                <div class="offGroup_body">
                    <div class="offGroup_date">
                        <span class="material-symbols-outlined"> today </span>
                        <span>${offGroup.offDate}</span>
                    </div>
                    <button class="offGroup_MemberList">
                        <span class="material-symbols-outlined" id="offGroup_member"> group </span>
                        <span>1 / ${offGroup.userCnt}</span>
                    </button>
                </div>
                <div class="offGroup_content_">
                    <textarea readonly class="addr offGroup_content">${offGroup.content}</textarea>
                    <div class="comment_list">
                        <button class="show_comment_list"><span class="material-symbols-outlined"> sms </span></button>
                        <div class="comment_count"><span>111</span></div>
                    </div>
                </div>
                <div class="close" id="offGroup_comment_list">
                    <div class="comment_user"><span>아이디</span></div>
                    <div class="comment_content">
                        <input text="type" readonly value="댓글내용와아아다다다ㅏ다다다다다다다다다다다다다다" class="comment">
                        <div class="comment_controller">
                            <button class="comment_modify" onclick="readyModify(this)">수 정</button>
                            <button class="complate close" onclick="complateModify(this)">완 료</button>
                            <button class="comment_delete" >삭 제</button>
                        </div>
                    </div>
                </div>
                <div class="my_comment close">
                    <span>${loginMember.nick}</span>
                    <input type="text" id="my_commemt"/>
                    <button class="comment_submit">
                    	<span class="material-symbols-outlined"> add_comment </span>
                    </button>
                </div>
            </div>
            <button class="offGroup_invite">가 입</button>
            <div class="offModal_member_wrap close">
                <div class="offMember_info">
               	<c:if test="${empty offMember}">
               		<div class="off_member_info">
                        <span>첫번째 참여자가 되어보세요!</span>
                    </div>
               	</c:if>
					<c:forEach items="${offMember}" var="i">
                    <div class="off_member_info">
                        <span>${i.userNo}</span>
                        <div class="off_membertemp">매너온도미완성</div>
                    </div>
                    <div class="member_controller">
                        <button class="expulsion">추 방</button>
                        <button class="participation">참 가</button>
                        <button class="absence">불 참</button>
                    </div>
                    </c:forEach>
                </div>
                <button class="memberlist_close"><span class="material-symbols-outlined"> close </span></button>
            </div>
        </main>
        
         <script>
         	$('.comment_submit').click(
       			function addMyComment(){
			        $.ajax({
			        	url: "<%= root %>/offgroup/comment/write",
			            type: "post",
			            data: {
			            	"offNo" : ${offGroup.no},
			                "memberNo" : ${loginMember.no},
			                "content" : $('#my_commemt').val()
			                },
		               	success: function (result) {
				              		const myComment = JSON.parse(result);
				              		let newComment = "<div class=\"comment_user\"><span>"+myComment.gmemberNo+"</span></div>"+
				              		"<div class=\"comment_content\">"+
				              		"<input readonly class=\"comment\" type=\"text\" value="+"'"+myComment.content+"'"+" \>"+ 
					              	"<div class=\"comment_controller\">"+
				              		"<button class=\"comment_modify\" onclick=\"readyModify(this)\">수 정</button>"+
				              		"<button class=\"complate close\">완 료</button>"+
				              		"<button class=\"comment_delete\">삭 제</button></div>"+
				              		"<div class=\"commentNo close\">"+myComment.no+"</div>";
				              		$('#offGroup_comment_list').append(newComment);
								},
	                	error: function () {
	                		alert("댓글작성실패");
						}
	                });//ajax
       			})//event
     			
       			$('.complate').click(function complateModify(e) {
					const no = getIndex(e, this);
					$.ajax({
						url: "<%= root %>/offgroup/comment/update",
						type:"post",
						data:{
							"commentNo": $($('.commentNo').[no]).text(),
							"content": $($('.comment')[no]).val()
						},
						success:(result)=>{
							$($('.comment')[no]).val(result);
							$($('.complate')[no]).addClass('close');
							$($('.comment_modify')[no]).removeClass('close');
							$($('.comment')[no]).attr('readOnly', true);
							$($('.comment')[no]).css('backgroundColor', 'transparent');
						}
						error:()={
							alert("수정실패...");
						}
					});//ajax
				})//event
       			
        </script>
</body>
</html>