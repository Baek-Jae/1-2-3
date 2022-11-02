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
                        <c:if test="${empty offMember}">
                        	<span>1 / ${offGroup.userCnt}</span>
                        </c:if>
                        <c:if test="${not empty offMember}">
                        <span>${offMember.size() + 1} / ${offGroup.userCnt}</span>
                        </c:if>
                    </button>
                </div>
                <div class="offGroup_content_">
                    <textarea readonly class="addr offGroup_content">${offGroup.content}</textarea>
                    <div class="comment_list">
                        <button class="show_comment_list"><span class="material-symbols-outlined"> sms </span></button>
                       	<c:if test="${not empty offCommentCnt}">
                        <div class="comment_count">
                        	<span>${offCommentCnt}</span>
                        </div>
                       	</c:if>
                    </div>
                </div>
                <div class="close" id="offGroup_comment_list">
                <c:forEach items="${offCommentList}" var="i">
                	<div class="offGroup_comment_wrap">
	                    <div class="comment_user"><span>${i.gmemberNo}</span></div>
	                    <div class="comment_content">
	                        <input text="type" readonly value="${i.content}" class="comment">
	                        <c:if test="${i.gmemberNo eq loginMember.nick}">
	                        <div class="comment_controller">
	                            <button class="comment_modify" onclick="readyModify(this)">수 정</button>
	                            <button class="complate close" onclick="modifyComment(this)">완 료</button>
	                            <button class="comment_delete" onclick="deleteComment(this)">삭 제</button>
	                        </div>
	                        </c:if>
	                        <c:if test="${i.gmemberNo ne loginMember.nick}">
	                        <div class="comment_controller hidden">
	                            <button class="comment_modify" onclick="readyModify(this')">수 정</button>
	                            <button class="complate close" onclick="modifyComment(this)">완 료</button>
	                            <button class="comment_delete" onclick="deleteComment(this)">삭 제</button>
	                        </div>
	                        </c:if>
	                        <div class="commentNo close">${i.no}</div>
	                    </div>
                    </div>
                </c:forEach>
                </div>
                <div class="my_comment close">
                    <span>${loginMember.nick}</span>
                    <input type="text" id="my_commemt"/>
                    <button class="comment_submit">
                    	<span class="material-symbols-outlined"> add_comment </span>
                    </button>
                </div>
            </div>
            <c:if test="${offMemberCheck ne 'true' and loginMember.nick ne offGroup.leaderNo}">
           	<button class="offGroup_invite">가 입</button>
           	</c:if>
           	<c:if test="${offMemberCheck eq 'true' and offGroup.leaderNo ne loginMember.nick}">
           	<button class="offGroup_quit">탈 퇴</button>
           	</c:if>
           	<c:if test="${loginMember.nick eq offGroup.leaderNo}">
           	<button class="offGroup_edit">모임 삭제</button>
           	</c:if>
            <div class="offModal_member_wrap close">
                <div class="offMember_info">
              	  	<div class="off_leader_info">
              	  		<span class="material-symbols-outlined"> tsunami </span>
                        <span>${offGroup.leaderNo}</span>
                        <div class="off_membertemp">매너온도미완성</div>
                    </div>
                </div>
               	<c:if test="${empty offMember and offGroup.leaderNo ne loginMember.nick}">
               		<div class="off_member_info">
               			<div id="first_member">
                        	<span >첫번째 참여자가 되어보세요!</span>
               			</div>
                    </div>
               	</c:if>
					<c:forEach items="${offMember}" var="i">
                    <div class="off_member_info">
                        <span>${i.userNo}</span>
                        <div class="off_membertemp">매너온도미완성</div>
                    </div>
                    <c:if test="${offGroup.leaderNo eq loginMember.nick}">
	                    <c:if test="${i.inviteYn eq 'Y'}">
		                    <div class="member_controller">
		                    	<label>참 가
		                        <input type="checkbox" class="participation" onclick="inviteYes(this)" checked>
		                        </label>
		                    </div>
	                    </c:if>
	                    <c:if test="${i.inviteYn eq 'N'}">
		                    <div class="member_controller">
		                    	<label>참 가
		                        <input type="checkbox" class="participation" onclick="inviteYes(this)">
		                        </label>
		                    </div>
	                    </c:if>
                    </c:if>
                    </c:forEach>
                <button class="memberlist_close"><span class="material-symbols-outlined"> close </span></button>
            </div>
        </main>
<c:if test="${not empty loginMember}">        
	<script>
	
		function inviteYes(obj) {
			const no = $(obj).index(obj);
			$.ajax({
				url:"<%=root%>/offgroup/invite/check",
				data:{
					"offMember" : $($('.off_member_info > span')[no]).text(),
					"offNo" : ${offGroup.no}
				},
				type:"post",
				success:(result)=>{
					if(result==1){
						alert("참가성공!")
					}
				},
				error:(result)=>{
				}
			});//ajax
		}//fn	
			
		
		//오프멤버 참가
		
		//오프그룹 탈퇴
		$('.offGroup_quit').click(()=>{
			$.ajax({
				url:"<%=root%>/offgroup/member/quit",
				data:{
					"offMember" : ${loginMember.no},
					"offNo" : ${offGroup.no}
				},
				type:"post",
				success:(result)=>{
						location.reload();
				},
				error:(result)=>{
					alert(result);
				}
			});//ajax
		});//event
		
		
		function upDateCommentCnt() {
			$.ajax({
				url: "<%= root %>/offgroup/comment/cnt",
				data:{
					"offNo" : ${offGroup.no} 
				},
				type:"post",
				success:(result)=>{
					const totalComment = JSON.parse(result);
					$('.comment_count span').text(totalComment);
					
				},
				error:(result)=>{
					alert("작성실패..");
				}
			});//ajax
		};
		
		
		//댓글기입~
		$('.comment_submit').click(
     			function addMyComment(){
		        $.ajax({
	        	url: "<%= root %>/offgroup/comment/write",
	            type: "post",
	            data: {
	            	"offNo" : ${offGroup.no},
	                "myGMemberNo" : ${myGMemberNo},
	                "content" : $('#my_commemt').val()
		                },
               	success: function (result) {
              		const myComment = JSON.parse(result);
              		let newComment = "<div class=\"offGroup_comment_wrap\">"+ 
              		"<div class=\"comment_user\"><span>"+myComment.gmemberNo+"</span></div>"+
              		"<div class=\"comment_content\">"+
              		"<input readonly class=\"comment\" type=\"text\" value="+"'"+myComment.content+"'"+" \>"+ 
	              	"<div class=\"comment_controller\">"+
              		"<button class=\"comment_modify\" onclick=\"readyModify(this)\">수 정</button>"+
              		"<button class=\"complate close\" onclick=\"modifyComment(this)\">완 료</button>"+
              		"<button class=\"comment_delete\" onclick=\"deleteComment(this)\">삭 제</button></div>"+
              		"<div class=\"commentNo close\">"+myComment.no+"</div></div>";
              		$('#offGroup_comment_list').append(newComment);
              		$('#my_commemt').val("");
              		
              		const checkCommentClass = $('.comment_count').attr('class');
              		const checkComment = checkCommentClass.search('close');
              		console.log(checkComment);
              		if(checkComment != -1){
              			$('.comment_count').removeClass('close');
              		}
              		
              		upDateCommentCnt();
				},
           		error: function () {
           			alert("댓글작성실패");
				}
			});//ajax
				
		});//event

		
      	//댓글 수정~	
 		function modifyComment(obj) {
 			const no = $('.complate').index(obj);
			$.ajax({
				url: "<%= root %>/offgroup/comment/update",
				type:"post",
				data:{
					"commentNo": $($('.commentNo')[no]).text(),
					"content": $($('.comment')[no]).val()
					},
				success:(result)=>{
					$($('.complate')[no]).addClass('close');
					$($('.comment_modify')[no]).removeClass('close');
					$($('.comment')[no]).attr('readOnly', true);
					$($('.comment')[no]).css('backgroundColor', 'transparent');
				},
				error:()=>{
					alert("수정실패...");
				}
			});//ajax
		};//event
			
		//댓글 삭제
		function deleteComment(obj){
			let no = $('.comment_delete').index(obj);
			$.ajax({
				url: "<%= root %>/offgroup/comment/del",
				type: "post",
				data:{
					"commentNo": $($('.commentNo')[no]).text()
				},
				success:(result)=>{
					$($('.offGroup_comment_wrap')[no]).remove();
					upDateCommentCnt();
					const emptyComment = $('.comment_count span').text();
					const emptyNum = "1";
					
					if(emptyComment == emptyNum){
						$('.comment_count').addClass('close');
					}
				},
				error:()=>{
					alert("삭제실패...");
				}
			})//ajax
		};//event
		
		
		
		//그룹 가입
		$('.offGroup_invite').click(
			function joinOffGroup() {
				$.ajax({
					url: "<%= root %>/offgroup/join",
					type: "post",
					data:{
						"loginMemberNo": ${loginMember.no},
						"offNo" : ${offGroup.no}
					},
					success:(result)=>{
						if(result ==1){
							location.reload();
						} else{
							alert("한번 탈퇴한 모임은 재가입이 불가합니다!")
						}
					},
					error:()=>{
						alert("가입 실패...");
					}
				})//ajax
			}//event
		);//event
		
		//선생님 질문할것 
		//1. 프로미스 사용했는데 잘못사용한거 같다 어떻게 쓰는건지 
		//2. 비동기에서 석세스 부분의 데이터를 받아서 완료가된다면 resolve에 담는건이해가 되는데 그럼 저처리방식에서 어디에 쓰는지 
		//3. 트라이캐치문으로 잡아야하는걸까?
		//4. 비동기 컨트롤러에서 setAttribute를 할수있고 그걸 겟으로 받아올수 있는지도 여쭤봐야겠다.
		//5. 질문이 잘 정리가 안되다 보니 머리가 깨질것 같다..
	</script>
	</c:if>
</body>
</html>