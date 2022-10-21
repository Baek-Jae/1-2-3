<%@page import="com.kh.semi.member.vo.MemberVo"%>
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
<title>Insert title here</title>
<style>
    body, html {
        margin: 0;
        padding: 0;
    }
    #back{
        width: 1920px;
        height: 780px;
        background-color: #FDB930 ;
        display: grid;
        align-items: center;
        justify-content: center;
    }
    #header{
        width: 1920px;
        height: 100px;
    
    }
    #bot{
        width: 1920px;
        height: 200px;
        border: 1px solid black;
    }
    #main{
        height: 300px;
        width: 500px;
        background-color: rgb(163, 163, 162);
        border-radius: 20px;
        display: grid;
        grid-template-rows: repeat(3, 1fr);
        justify-items: center;
        align-items: center;
        padding: 20px;
    }
    
    .input{
      font-size: 18px;
      height: 50px;
      border: 1px solid #dddddd;
      color: #999999;
      border-radius: 5px;
    
    }
    .label{

      font-size: 18px;
      color: #fff;
      background-color: rgba(0, 53, 109, 0.95);
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
</style>
<script>
	<%if(alertMsg != null){ %>
			alert('<%=alertMsg%>')
	<% } %>
</script>
</head>
<body>

    <div id="back">
        <form action="/omjm/member/check" method="post">
            <div id="main">
                
                
                <input type="text" name="checkId" value="<%= loginMember.getId() %>" class="input width-size">
                <input type="password" name="checkPwd"  class="input width-size">
                <input type="submit" value="비밀번호확인" class="label width-size">
                

            
            </div>
        </form>
    </div>
    <div id="bot"></div>
</body>
</html>
