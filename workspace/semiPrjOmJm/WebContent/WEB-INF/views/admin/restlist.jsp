<%@page import="java.util.List"%>
<%@page import="com.kh.admin.dao.AdminVo"%>
<%@page import="com.kh.semi.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="/WEB-INF/views/admin/memberheader.jsp" %>
         <%
     MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
    List<MemberVo> voList = (List<MemberVo>)request.getAttribute("voList"); 
    %>
<!-- //     MemberVo restMember = (MemberVo)session.getAtrribute("restMember"); -->

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
            <br><br><br><br><br><br><br><br><br><br><br><br>
                <div><a> 등급관리</a></div>
                <div><a>회원관리</a> </div>
                <div><a>게시글관리</a> </div>
                <div><a>문의관리</a> </div>
            </div>
        </div>
        <form action="omjm/admin/restlist" method="post"onsubmit="return check();">
        <div id="content">
        	<div id="restmembers">
        	
        		현재 관리자 :<input type="text" id="r1" placeholder="로그인 유저 닉네임 : " value="<%=loginMember.getNick() %>">
        		<br>
        		제제된 유저 :
        		<% for(int y =0; y < voList.size(); ++y){ %>
        		<input type="text" value="<%=voList.get(y).getNick() %>">
        		<br>
        		<%}%>
        	</div>
        </div>
        </form>
	

</body>
</html>