<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String root = request.getContextPath(); %>
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
                            회원관리
                            <li><a href="">회원 정보</a></li>
                            <li><a href="">회원 모임</a></li>
                            <li><a href="">회원 온도</a></li>
                            <span></span>
                        </ul>
                        <ul>
                            등급관리
                            <li><a href="">회원 등급</a></li>
                            <li><a href="">불참 횟수</a></li>
                        </ul>
                        <ul>
                            회원제제
                            <li><a href="">제제 내역</a></li>
                            <li><a href="">회원 탈퇴</a></li>
                            <li><a href="">회원제제 투표</a></li>
                        </ul>
                        <ul>
                            카테고리
                            <li><a href="">카테고리 추천</a></li>
                            <li><a href="">카테고리 수정</a></li>
                         
                        </ul>
                    </div>
                    <div id="logout">
                        <a href=""><i class="fa-solid fa-right-from-bracket"></i>관리자 로그아웃</a>
                    </div>
                </div>
            </div>
            <div class="nav_logo steady">
                <a href=""><img src="<%= root %>/resources/오목조목.png" alt="로고임" /></a>
            </div>
            
        </nav>
        
        <footer>
        	<div class="footer-content"></div>
        </footer>
    </body>
</html>
