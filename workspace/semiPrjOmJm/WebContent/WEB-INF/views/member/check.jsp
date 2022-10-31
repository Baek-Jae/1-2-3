<%@page import="com.kh.semi.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/common/header.jsp" %>
<%	String alertMsg = (String)request.getAttribute("alertMsg"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
        grid-template-rows: repeat(3, 1fr);
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
   form{
    margin: 0 auto;
   }
</style>
<script>
	<%if(alertMsg != null){ %>
			alert('<%=alertMsg%>')
	<% } %>
</script>
</head>
<body>
	<div id="mem-header"></div>
    <div id="back">
        <form action="/omjm/member/check" method="post">
            <div id="main">
                
                
                <input type="text" name="checkId" value="<%= loginMember.getId() %>" class="input width-size" readonly>
                <input type="password" name="checkPwd"  class="input width-size">
                <input type="submit" value="비밀번호확인" class="label width-size">
                

            
            </div>
        </form>
    </div>
    <div id="bot"></div>
</body>
</html>
