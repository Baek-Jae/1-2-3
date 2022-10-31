<%@page import="com.kh.semi.faq.vo.FaqVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	FaqVo vo = (FaqVo)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    :root{
        --color-main: #fdb930;
        --color-1green: #46a15e;
        --color-2green: #9cb43a;
        --color-3green: #008676;
    } 
    
	#main{
		width: 60vw;
		height: 60vh;
		margin: 0 auto;
		border: 1px solid black;
		background: #008676;
		display: grid;
		grid-template-columns: 4fr 2fr 2fr 1fr;
		grid-template-rows: 30px;
		padding-top: 100px;
	}
	
	#main > div{
		border: 1px solid black;
	}
	
	#notice-content{
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
	
	<h1 align="center">FAQ 상세조회</h1>
	
	<div id="main">

		<div><%= vo.getTitle() %></div>

		<div><%= vo.getWriter() %></div>

		<div><%= vo.getEnrollDate() %></div>

		<div><%= vo.getHit() %></div>

		<div id="notice-content"><%= vo.getContent() %></div>

	</div>
	
	<%if(loginMember != null && loginMember.getId().equals("admin")){%>
		<div id="main-bot">
			<a href="/omjm/FAQ/edit?no=<%= vo.getNo() %>">수정하기</a>
			<a href="/omjm/FAQ/delete?no=<%= vo.getNo() %>">삭제하기</a>
		</div>
	<%}%>
	
</body>
</html>