<%@page import="com.kh.semi.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/common/header.jsp" %>
<%String alertMsg = (String)request.getAttribute("alertMsg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>
<style>
    body, html {
        margin: 0;
        padding: 0;
    }
    #back{
        width: 100vw;
        height: 780px;
        display: grid;
        align-items: center;
        justify-content: center;
    }
    #mem-header{
    	height : 80px
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
        grid-template-rows: 2fr 1fr;
        align-content: stretch;
        justify-items: center;
        align-items: center;
        padding: 20px;
    }
    input[type=text], input[type=password]{
        color: black;
        opacity: 1;
        padding-left: 20px;
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
        width: 65%;
        padding: 0 10px;
        box-sizing: border-box;
    }
   #title{
    font-size: 2rem;
   }
   div > a{
    color: #FDB930;
   }
   form{
    margin: 0 auto;
   }
   .flex{
    display: flex;
    width: 100%;
    justify-content: space-around;
    align-items: center;
   }
   #submit{
    width: 100%;
   }
</style>
</head>
<body>
	<div id="mem-header"></div>
    <div id="back">
        <form action="/omjm/member/findid" method="post">
            <div id="main">
                
                <div class="flex">휴대전화 번호 : <input type="text" name="fiphone"  class="input width-size" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1')"></div>
                <input type="submit" value="아이디 찾기" class="label width-size" id="submit">

            </div>
        </form>
    </div>
    <div id="bot"></div>

<script>
    <%if(alertMsg != null){ %>
		alert('<%=alertMsg%>');
	<% } %>
</script>
</body>
</html>