<%@page import="com.kh.admin.dao.AdminVo"%>
<%@page import="com.kh.semi.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="/WEB-INF/views/admin/memberheader.jsp" %>
        <%
   MemberVo vo = (MemberVo)session.getAttribute("vo");
%>
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
                <div><a href="/omjm/admin/rest">문의관리</a> </div>
            </div>
        </div>
        <form action="omjm/admin/rest" method="post"onsubmit="return check();">
        <div id="content">
        	<div id="restmembers">
        		제제 리스트 :<input type="text" id="r1" placeholder="제제 회원 닉네임 : " value="<%= vo.getNick() %>">
        		
        		
        		
        	</div>
        </div>
        </form>
	

</body>
</html>