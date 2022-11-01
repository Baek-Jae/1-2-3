<%@page import="com.kh.semi.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/common/header.jsp" %>
<%	String alertMsg = (String)request.getAttribute("alertMsg"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
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
        align-content: center;
    }
    #mem-header{
    	height : 80px
    }

    #bot{
        width: 100vw;
        height: 200px;
    }
    #main{
        width: 100%;
        height: 100%;
        border: 5px solid #FDB930;
        border-radius: 20px;
        display: grid;
        grid-template-columns: 1fr 3fr;
        grid-template-rows: 1fr 1fr 1fr 5fr 1fr;
        place-items: center center;
        align-items: center;
        padding: 20px;
    }
    .span2{
        grid-column: span 2;
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
        width: 100%;
        padding: 0 10px;
        box-sizing: border-box;
    }
   #title{
    font-size: 2rem;
   }
   form{
    margin: 0 auto;
    width: 700px;
    height: 700px;

   }
   input[type=submit]{
    
    width: 100%;
    font-size: 18px;
    color: red;
    background-color:#fff;
    cursor: pointer;
    height: 50px;
    border-radius: 5px;
   }
   #radioResult{
    display: none;
   }
   textarea {
    width: 100%;
    height: 80%;
    resize: none;
    padding: 10px;
  }
  #radio{
    height: 100%;
    display: grid;
    width: 100%;
    padding: 20px;
    border: 1px solid #FDB930;
    border-radius: 10px;
    
  }
  .red{
    color: red;
    border-color: red;
  }
  .width2{
    width: 100%;
  }
</style>
</head>
<body>
	<div id="mem-header"></div>
    <div id="back">
        <form action="/omjm/member/quit" method="post">
            <div id="main">

                <div>아이디</div>
                <div><input type="text" name="checkId" value="<%= loginMember.getId() %>" class="input width-size" readonly></div>
                <div>비밀번호</div>
                <div><input type="password" name="checkPwd"  class="input width-size"></div>
                <div class="span2 red"> 탈퇴 사유를 알려주세요 사이트 개선에 사용하겠습니다.</div>
                <div id="radio" class="span2">
                        <label><input type="radio" value="1" name="quitReason">원하는 모임이 없어요</label>
                        <br>
                        <label><input type="radio" value="2" name="quitReason">사이트 사용이 불편해요 </label>
                        <br>
                        <label><input type="radio" value="3" name="quitReason">사용빈도가 낮아요</label>
                        <br>
                        <label><input type="radio" value="4" name="quitReason">다른사이트가 더 유용해요</label>
                        <br>
                        <label><input type="radio" value="5" name="quitReason">기타</label>
                        <br>
                        <div id="radioResult"><textarea name="quitcontent"></textarea></div>
                </div>

                <div class="span2 width2" ><input type="submit" value="탈퇴하기" class=" width-size red"></div>
                

            
            </div>
        </form>
    </div>
    <div id="bot"></div>

<script>

    <%if(alertMsg != null){ %>
			alert('<%=alertMsg%>');
	<% } %>

    const btnArray = $('input[type=radio]');

    for (let i = 0; i < btnArray.length; i++) {
        const element = btnArray[i];

        element.addEventListener('click', function(){
            const v = $(element).val();
            if(v==5){
                $('#radioResult').show();
            }else{
                $('#radioResult').hide();
            }
        });
    }

 
    

    
</script>
</body>
</html>
