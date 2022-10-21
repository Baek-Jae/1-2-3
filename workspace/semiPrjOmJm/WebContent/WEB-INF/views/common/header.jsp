<%@page import="com.kh.semi.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String root = request.getContextPath(); %>
<%
	MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Insert title here</title>
        <link rel="stylesheet" href="<%= root %>/css/headerStyle.css" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,300,0,0" />
        <script src="https://kit.fontawesome.com/ae846b135b.js" crossorigin="anonymous"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com" />
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
                            <li><a href="">생성</a></li>
                            <li><a href="">가입한 모임</a></li>
                            <li><a href="">찜한 모임</a></li>
                            <span></span>
                        </ul>
                        <ul>
                            고객센터
                            <li><a href="">Q&A</a></li>
                            <li><a href="">FAQ</a></li>
                        </ul>
                        <ul>
                            나의 정보
                            <li><a href="">개인정보 변경</a></li>
                            <li><a href="">카테고리 변경</a></li>
                            <li><a href="">관심지역 변경</a></li>
                        </ul>
                    </div>
                    <div id="logout">
                        <a href="/omjm/member/logout"><i class="fa-solid fa-right-from-bracket"></i> 로그아웃</a>
                    </div>
                </div>
            </div>
            <div class="nav_logo steady">
                <a href=""><img src="<%= root %>/resources/오목조목.png" alt="로고임" /></a>
            </div>
            <div class="nav_user">
            	<%if(loginMember != null) {%>
            		<div id="mem-login">
	            		<a href="/omjm/member/mypage" id="mem-nick"><%= loginMember.getNick() %>님</a>
	            		<div id="mem-temp">매너온도자리</div>
	            		<div id="mem-mypage"><a href="/omjm/member/check" >마이페이지</a></div>
            		</div>
                <%}else {%>
                
                <a href="/omjm/member/login" id="login">로그인</a>
                <a href="/omjm/member/join" id="join">회원가입</a>
                <%} %>
            </div>
        </nav>
        
        <footer>
        	<div class="footer-content"></div>
        </footer>
    </body>
</html>
