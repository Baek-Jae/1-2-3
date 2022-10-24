<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file = "/WEB-INF/views/common/header.jsp" %>
	
	<h1 align="centet">공지사항 작성하기</h1>
	<a href="/omjm/notice/write">글쓰기</a>
	<form action="" method="post">
		<div id="main">

			<div>제목</div>
			<div><input type="text" name="title"></div>

			<div>내용</div>
			<div><textarea name="content"></textarea></div>

			<div></div>
			<div><input type="submit" value="작성하기"></div>
			
		</div>
	</form>
</body>
</html>