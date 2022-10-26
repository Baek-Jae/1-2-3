<%@page import="com.kh.semi.password.PasswordVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<PasswordVo> pwdQList = (List<PasswordVo>)request.getAttribute("pwdQList"); %>

<%@ include file = "/WEB-INF/views/common/header.jsp" %>
<!-- Jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Noto Sans KR', sans-serif;
    }
    #back{
        height: 1000px;
        display: grid;
        background-color: #fdb930;
    }
    #header{
        width: 100vw;
        height: 80px;
    
    }
    #bot{
        width: 100vw
        ;
        height: 200px;
        border: 1px solid black;
    }
    #main{
        
        padding-top: 50px;
        display: grid;
        grid-template-rows: repeat(23, 1fr);
        place-content: center center;
        
        
    }
    .input{
      
        border: 1px solid #dddddd;
        color: #999999;
        border-radius: 5px;
    
    }
    .label{

        color: #fff;
        background-color: rgba(0, 53, 109, 0.95);
        cursor: pointer;
        border-radius: 5px;
        border: none;
        
    }
    .width-size, select{

        height: 35px;
        width: 75%;
        padding: 0 10px;
        box-sizing: border-box;
    }
    #check{
        display: flex;
        width: 500px;
    }
    .doublecheck{
        padding: 1px 3px 3px 1px;
        margin-left: 15px;
        font-size: 15px;
        width: 100px;
    }
    #main > div{
        padding-top: 5px;
        font-size: 20px;
    }
    .select {
    -o-appearance: none;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    }
    select{
        font-size: 18px;
    }
</style>
</head>
<body>
	<div id="header">헤더</div>
    <div id="back">
        <form action="/omjm/member/join" method="post" enctype="multipart/form-data">
            <div id="main">
                
                <div >아이디</div>
                <div id="check"><input type="text" name="memberId" class="input width-size"><button class="label doublecheck" onclick="idCheck()">중복체크</button></div>
                
                <div class="span-2">비밀번호</div>
                <div><input type="password" name="memberPwd1" class="input width-size"></div>
                <div>비밀번호 확인</div>
                <div><input type="password" name="memberPwd2" class="input width-size"></div>
                <div>닉네임</div>
                <div><input type="text" name="memberNick" class="input width-size"></div>
                <div>첨부파일<input type="file" name="f"></div>
                <div>이름</div>
                <div><input type="text" name="memberName" class="input width-size"></div>
                <div>핸드폰번호</div>
                <div id="check"><input type="text" name="memberPhone" class="input width-size"><button class="label doublecheck">중복체크</button></div>
                <div>관심지역</div>
                <div><input type="text" name="memberPlace" class="input width-size"></div>
                <div>카테고리</div>
                <div><input type="text" name="memberCate" class="input width-size"></div>
                <div>
                    남자 <input type="radio" name="memberGender" value="M"> &nbsp;
                    여자 <input type="radio" name="memberGender" value="F">
                </div>
                <select name="memberPQ" class="select">비밀번호 찾기 질문 
                	<%for(int i = 0; i < pwdQList.size(); i++) { %>
                	<option value="<%= pwdQList.get(i).getNo() %>"><%=pwdQList.get(i).getQ() %></option>
                 	 <% } %>

                 </select>
                <div>비밀번호 찾기 답</div>
                <div><input type="text" name="memberPA" class="input width-size"></div>
                
                <div><input type="submit" value="회원가입"  class="label width-size"></div>
            </div>
        </form>
    </div>
    <div id="bot"></div>

<script>
    function idCheck(){

        $.ajax({
            url : "/omjm/member/idDoubleCheck",
            type : "post",
            data : {
                
            },
            success : funtion(){
                alert('성공');
            } ,
            error : function(){

            },alert(' 실패');
            
            

        });
    }



</script>
</body>
</html>