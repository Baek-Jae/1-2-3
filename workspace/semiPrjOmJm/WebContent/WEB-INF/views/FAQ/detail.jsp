<%@page import="com.kh.semi.faq.vo.FaqVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	FaqVo vo = (FaqVo)request.getAttribute("vo");
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
		border: 1px solid black;
		display: grid;
		grid-template-columns: 4fr 2fr 2fr 1fr;
		grid-template-rows: 30px;
		padding: 100px;
	}
	#main > div{
		border: 1px dashed black;
	}
	#faq-content{
		grid-column: span 4;
		padding: 20px;
	}
	
	#main-bot{
		width : 60vw;
		margin : 0 auto;
		text-align : center;
	}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<h1 align="center">FAQ 상세조회</h1>
	
	<div id="main">

		<div><%= vo.getTitle() %></div>

		<div><%= vo.getWriter() %></div>

		<div><%= vo.getEnrollDate() %></div>

		<div><%= vo.getHit() %></div>

		<div id="faq-content"><%= vo.getContent() %></div>

	</div>
	
	
	<%if(loginMember != null && loginMember.getId().equals("admin")){%>
		<div id="main-bot">
			<a href="/omjm/FAQ/edit?no=<%= vo.getNo() %>">수정하기</a>
			<a href="/omjm/FAQ/delete?no=<%= vo.getNo() %>">삭제하기</a>
		</div>
	<%}%>
	
	
</body>
</html>