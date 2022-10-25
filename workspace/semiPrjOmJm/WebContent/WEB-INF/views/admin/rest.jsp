<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="/WEB-INF/views/admin/memberheader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="main">
        <div id="head"></div>
        <div id="header">
            <div id="menuTop">
                <div><a> 등급관리</a></div>
                <div><a>회원관리</a> </div>
                <div><a>게시글관리</a> </div>
                <div> <a>문의관리</a> </div>
            </div>
        </div>
        <div id="content">
        	<div id="restmember">
        		제제 회원이름 :<input type="text" id="r1" placeholder="내가 수정해야하는곳 제제 회원:: : ~~~~">
        		제제 사유 : <input type="text" id="r2" placeholder="제제 회원 :" > 
        		제제 기간 : <input type="text" id="r3" placeholder="제제 기간 : ">
        		
        	</div>
        </div>
	

</body>
</html>