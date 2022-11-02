<%@page import="com.kh.semi.qna.vo.QnAVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<% 
	QnAVo vo = (QnAVo)request.getAttribute("vo");
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
		width: 80vw;
		height: 60vh;
		margin: 100px auto;
		border: 1px solid black;
		background: #fff;
		display: grid;
		grid-template-columns: 4fr 2fr 2fr 1fr;
		grid-template-rows: 2fr 8fr;
		border: 3px solid #fdb930;
	}
	
	#main > div{
		padding: 30px;
		border-bottom: 1px solid #fdb930;
		border-left: 1px solid #fdb930;
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

	#enrollDate {
		width: 100%;
	}
</style>
</head>
<body>
	
	<h1 align="center">공지사항 상세조회</h1>

	<div id="main">
		<div>
			<div>제목 : </div>
			<div><%= vo.getTitle() %></div>
		</div>
		<div>
			<div>작성자 : </div>
			<div><%= vo.getWriter() %></div>
		</div>
		<div id="enrollDate">
			<div>작성일시 : </div>
			<div><%= vo.getEnrollDate() %></div>
		</div>
		<div>
			<div>조회수 : </div>
			<div><%= vo.getHit() %></div>
		</div>
		<div>
			<div>내용 : </div>
			<div id="notice-content"><%= vo.getContent() %></div>
		</div>

	</div>
		
	<div id="main-bot">
		<%if(loginMember != null && (loginMember.getNick()).equals(vo.getWriter())) { %>
			<a href="/omjm/QnA/edit?no=<%= vo.getNo() %>">수정하기</a>
			<a href="/omjm/QnA/delete?no=<%= vo.getNo() %>">삭제하기</a>
		<%}%>
		<%if(loginMember != null && loginMember.getId().equals("admin")){%>
			<a href="/omjm/reQnA/write?no=<%= vo.getNo() %>">답변작성</a>
			<a href="/omjm/QnA/delete?no=<%= vo.getNo() %>">삭제하기</a>		
		<%}%>
	</div>
	
</body>
</html>