<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="com.kh.semi.member.vo.MemberVo"%>
<!DOCTYPE html>
<% String root = request.getContextPath(); %>
<%MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Insert title here</title>
        <link
            href="https://fonts.googleapis.com/css2?family=Dancing+Script&family=Fraunces:opsz,wght@9..144,500;9..144,700&family=Montserrat:wght@500;700&family=Nanum+Brush+Script&family=Nanum+Pen+Script&family=Noto+Sans+KR&family=Oleo+Script+Swash+Caps&family=Permanent+Marker&family=Prata&family=Silkscreen&display=swap"
            rel="stylesheet"
        />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,300,0,0" />
        <script src="https://kit.fontawesome.com/ae846b135b.js" crossorigin="anonymous"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="stylesheet" href="<%= root %>/css/headerStyle.css" />
    </head>
    <body>
        <nav>
            <div class="nav_menu">
                <input type="checkbox" id="menu_icon" />
                <label for="menu_icon">
                    <span></span>
                    <span></span>
                    <span></span>
                </label>
                <div class="sidebar">
                    <div class="sidebar_wrap">
                        <div></div>
                        <ul>
                            모임
                            <c:if test="${not empty loginMember}">
                            <li><a href="<%= root %>/group/create">생성</a></li>
                            </c:if>
                            <li><a href="<%= root %>/member/mypage?x=1&lgpno=1&jgpno=1">찜한 모임</a></li>
                            <li><a href="<%= root %>/member/mypage?x=2&lgpno=1&jgpno=1">가입한 모임</a></li>
                            <li><a href="<%= root %>/search">검색</a></li>
                        </ul>
                        <ul>
                            고객센터
                            <li><a href="<%= root %>/notice/list?nno=1">공지사항</a></li>
                            <li><a href="<%= root %>/QnA/list?qno=1">Q&A</a></li>
                            <li><a href="<%= root %>/FAQ/list?fno=1">FAQ</a></li>
                        </ul>
                        <ul>
                        <%if(loginMember != null) {%>
                            나의 정보
                            <li><a href="<%= root %>/member/mypage?x=0&lgpno=1&jgpno=1">개인정보 변경</a></li>
                            <li><a href="<%= root %>/member/mypage?x=4&lgpno=1&jgpno=1">관심지역 변경</a></li>
                            <%}%>
                        </ul>
                    </div>
                    <div id="logout">
                        <a href="/omjm/member/logout"><i class="fa-solid fa-right-from-bracket"></i> 로그아웃</a>
                    </div>
                </div>
            </div>
            <div class="nav_logo steady">
                <a href="<%= root %>"><img src="<%= root %>/resources/오목조목.png" alt="로고임" /></a>
            </div>
            <div class="nav_user">
            	 <% if(loginMember != null && loginMember.getNick().equals("관리자")){%>
            		
	            		<a href="/omjm/member/mypage" id="mem-nick"><%= loginMember.getNick() %>님</a>
	            		<a href="/omjm/Tempht/index.html" id="mem-temp">매너온도</a>
	            		<a href="/omjm/member/check" id="mem-mypage">마이페이지</a>
	            		<a href="/omjm/admin/rest" id="mem-admin">관리자페이지 </a>
            		
                <%}else if(loginMember != null){%>
                    <a href="/omjm/member/mypage" id="mem-nick"><%= loginMember.getNick() %>님</a>
                    <a href="/omjm/Tempht/index.html" id="mem-temp">매너온도</a>
                    <a href="/omjm/member/check" id="mem-mypage">마이페이지</a>

                <%} else{%>
                    <a href="/omjm/member/login" id="login">로그인</a>
                    <a href="/omjm/member/join" id="join">회원가입</a>

                <%}%>
        </div>
        </nav>
        
        <footer>
        	<div class="footer-content"></div>
        </footer>
    </body>
</html>
