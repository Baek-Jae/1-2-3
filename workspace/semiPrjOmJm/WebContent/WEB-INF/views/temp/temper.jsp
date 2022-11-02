<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	 <%@ include file="/WEB-INF/views/admin/memberheader.jsp" %>
	<%
  	  MemberVo ppOff = (MemberVo)session.getAttribute("ppOff");
	  MemberVo nppOff = (MemberVo)session.getAttribute("nppOff");
	  MemberVo manner = (MemberVo)session.getAttribute("manner");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script> -->
<link rel="stylesheet" href="<%= root %>/css/mainStyle.css" />
<link rel="preconnect" href="https://fonts.googleapis.com" />


</head>
<style>
	* {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Noto Sans KR', sans-serif;
    }
	#mannerCheck{

	}

</style>
<body>


	<div class="main-wrap">
		<div class="main-slider">
			<div class="main-slider-content">
				<h2>수 <strong>많은</strong> 사용자들과</h2>
				<h2><strong>관심사</strong>를 같이 공유하며 새로운 <strong>모임</strong>을</h2>
				<h2>다양하게 <strong>생성</strong>하고 <strong>가입</strong>하며</h2>
				<h2>일상의 <strong>달라짐</strong>을 경험해 보세요</h2>
				<span>오목조목 에서는 사용자의 지역과 관심사를 통해 여러분 들에게 최적의 모임을 보여줍니다.</span>
			</div>
		</div>
	</div>
	
	<div id="aclick">
	모임참여<input type="button" id="click" value="클릭"></button>
	
	
	
	
	<br><br><br><br><br><br>
	모임불참<input type="button" id="clicks" value="클릭"></button>
	</div>
<br><br><br><br><br><br><br><br>

	<a href="/omjm/Tempht/index.html"><button id="mannercheck">나의 매너온도 확인</button></a>
	
	
	</body>
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script>

 	//var pp = document.querySelector("#tempclick").value;
	
	
		
		$('#click').click(function(){

			
		$.ajax({
			url: "/omjm/temp/temper" ,
			method:"post",			
			data:{
				 "ppOff" : <%= ppOff %> + 1,
				 "manner" :<%= manner %> + 1
			},
			dataType:'text',
			success: function(){
				alert("온도가 상승했습니다.");
			} ,
			error : function(){
				alert("정보 인식이 안되었습니다.");
			},
			complete : function(){
				alert("수정끝")
				}
			});
		});
	

		$('#clicks').click(function(){
		$.ajax({
			url:"/omjm/temp/temper2",
			method:"post",
			data:{
				"nppOff" :<%= nppOff %> +1 
			,	"manner" : <%= manner %> -1 
			},
			dataType:'text',
			success:function(data){
				alert("온도가 내려갔습니다.");
			},
			error: function(){
				alert("정보인식이 안되었습니다.");
			},
			complete : function(){
				alert("수정끝");
			}
		});
		
		
		
		});
		
	
		$('#mannercheck').click(function(){
			$.ajax({
				url:"/Tempht/index.html",
				method:"post",
				dataType:'html',

				data : {
					"follower" : follower + 1.8
				},
					success:function(data){
					alert("온도 수정 성공");
				},
				error: function(){
					alert("정보 수정 실패.");
				},
				complete: function(){
					alert("수정끝!");
				}
			});
		});
	
	
	</script>
	
	
	
	
	
	


</html>