<%@page import="java.util.List"%>
<%@page import="com.kh.admin.dao.AdminVo"%>
<%@page import="com.kh.semi.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="/WEB-INF/views/admin/memberheader.jsp" %>
         <%
     loginMember = (MemberVo)session.getAttribute("loginMember");
    List<MemberVo> voList = (List<MemberVo>)request.getAttribute("voList"); 
    %>
<!-- //     MemberVo restMember = (MemberVo)session.getAtrribute("restMember"); -->

<!DOCTYPE html>
<html>
<head>
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
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= root %>/css/mainStyle.css" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
</head>
<body>
	<div id="main">
        <div id="head"></div>
        <div id="header">
            <div id="menuTop">
            <br><br>
               
            </div>
        </div>
        <form action="omjm/admin/restlist" method="post"onsubmit="return check();">
        <div id="content">
        	<div id="restmembers">
        	
        		현재 관리자 :<input type="text" id="r1" placeholder="로그인 유저 닉네임 : " value="<%=loginMember.getNick() %>">
        		<br>
        		
        		제제된 유저 :<br>
        		<% for(int y =0; y < voList.size(); ++y){ %>
        		<input type="text" value="<%=voList.get(y).getNick() %>">
        		<br>
        		<%}%>
        	</div>
        </div>
        </form>
	

</body>
</html>