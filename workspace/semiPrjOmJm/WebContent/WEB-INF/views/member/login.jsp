<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/common/header.jsp" %>
<%
	String alertMsg = (String)request.getAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<!-- JavaScript -->
<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
<!-- Default theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>
<!-- Semantic UI theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/semantic.min.css"/>
<!-- Bootstrap theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/bootstrap.min.css"/>
<style>
    body, html {
        margin: 0;
        padding: 0;
    }
    #back{
        width: 100vw;
        height: 90vh;
        display: grid;
        align-items: center;
        justify-content: center;
    }
    #mem-header{
        width: 100vw;
        height: 80px;
    
    }
    #bot{
        width: 100vw;
        height: 200px;
    }
    #main{
        height: 300px;
        width: 500px;
        border: 5px solid #FDB930;
        border-radius: 20px;
        display: grid;
        grid-template-rows: repeat(3, 1fr) repeat(2, 0.5fr);
        justify-items: center;
        align-items: center;
        padding: 20px;
    }
    
    .input{
      font-size: 18px;
      height: 50px;
      border: 1px solid #dddddd;
      color: #999999;
      background-color: #dddddd;
      opacity: 0.5;
      border-radius: 5px;
    
    }
    .label{

      font-size: 18px;
      color: #fff;
     background-color: black;
      cursor: pointer;
      height: 50px;
      border-radius: 5px;
    
    }
    .width-size{
        width: 80%;
        padding: 0 10px;
        box-sizing: border-box;
    }
   #title{
    font-size: 2rem;
   }
   div > a{
    color: #FDB930;
   }
   input[type=text], input[type=password]{
    color: black;
    opacity: 1;
   }
</style>
<script>
	<%if(alertMsg != null){ %>
		alert('<%=alertMsg%>');
	<% } %>
</script>
</head>
<body>
	<div id="mem-header">로그인 화면</div>
    <div id="back">
        <form action= "<%= root %>/member/login" method="post">
            <div id="main">
                
                
                <input type="text" name="memberId" placeholder="아이디를 입력해주세요" class="input width-size" >
                <input type="password" name="memberPwd" placeholder="비밀번호를 입력해주세요" class="input width-size">
                <input type="submit" value="로그인" class="label width-size">
                <div><a href="/omjm/member/findid">아이디 찾기</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/omjm/member/findpwd">비밀번호 찾기</a></div>
                <div><a href="/omjm/member/join">회원가입</a></div>

            
            </div>
        </form>
    </div>
    <div id="bot"></div>
<script>
    console.log(1234);
    console.log('${id}');

    if( '${id}' != '' ){
       $('input[name=memberId]').val('${id}'); 
    }
    
</script>
</body>
</html>