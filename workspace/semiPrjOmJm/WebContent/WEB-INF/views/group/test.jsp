<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>나이 확인</h1>
	<h1>나이 확인</h1>
	<h1>회원가입</h1>
	
	<form action="/omjm/test2" method="post">
		<input type="text" name="memberId">
		<input type="password" name="memberPwd">
		<input type="submit" value="회갑">
	</form>
	<button onclick="check();">날짜</button>
	<script>
	
	    function check(){
	    	
	    	//입력된 나이 가져오기
	    	let age = $('input[name=age]').val();
	    	console.log(age);
	        //ajax 이용해서 서버한테 데이터 보내고 응답하기
	        $.ajax({
	           //k : v
	           url : "/ajax/test2",
	           type : "get",
	           
	           success : function(x){
	              alert(x);
	           },
	           error : function(){
	              alert("에러발생");
	           }
	           
	        });
	     }
	</script>
</body>
</html>