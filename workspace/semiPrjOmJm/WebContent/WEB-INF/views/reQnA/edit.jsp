<%@page import="com.kh.semi.qna.vo.TotalQnAVo"%>
<%@page import="com.kh.semi.reQnA.vo.ReQnAVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	TotalQnAVo vo = (TotalQnAVo)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#main{
		width: 60vw;
		height: 60vh;
		margin: 0 auto;
		display: grid;
		grid-template-columns: 1fr 5fr;
		grid-template-rows: 1fr 5fr 1fr;
		text-align: center;
		border: 1px solid black;
		padding-top: 200px;
	}
	#main input , #main textarea{
		width: 80%;
		height: 80%;
		margin: 0 auto;
	}
</style>
</head>
<body>
	
		<h1 align="center">QnA 답글 수정하기</h1>

	<form action="/omjm/reQnA/edit?no=<%= vo.getRno() %>" method="post">
		<div id="main">
			<div>제목</div>
			<div><input type="text" name="title" value="<%= vo.getRetitle() %>"></div>

			<div>내용</div>
			<div><textarea name="content"><%= vo.getRecontent() %></textarea></div>
			
			<div></div>
			<div><input type="submit" value="수정하기"></div>
		</div>
	</form>
</body>
</html>