<%@page import="com.kh.semi.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/common/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 재설정</title>
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
        grid-template-columns: 1fr 2fr;
        grid-template-rows: 1fr 0.5fr 1fr 0.5fr 1fr;
        padding: 20px;
        align-items: center;
    }
    input[type=password]{
        color: black;
        opacity: 1;
        padding-left: 20px;
        font-size: 15px;
    }
    .input{
      font-size: 15px;
      height: 50px;
      border: 1px solid #dddddd;
      color: #999999;
      background-color: #dddddd;
      opacity: 0.5;
      border-radius: 5px;
    
    }
    .result{
        font-size: 13.5px ;
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
   #submit{
    width: 100%;
    height: 80%;
   grid-column: span 2;
   }
   .red{
    color: red;
    border-color: red;
   }
    .green{
        color: green;
        border-color: green;
    }
</style>
</head>
<body>
	<div id="mem-header"></div>
    <div id="back">
        <form action="/omjm/member/updatepassword" method="post" onsubmit="return checkAll();">
            <div id="main">
                <div class="span-2">비밀번호</div>
                <div><input type="password" name="memberPwd1" class="input width-size" placeholder="8 글자이상 특수문자포함"></div>
                <div><input type="hidden" value="${id}" name="memberId"></div>
                <div id="checkPwd1Result" class=" result"></div>
                <div>비밀번호 확인</div>
                <div><input type="password" name="memberPwd2" class="input width-size" placeholder="비밀번호 한번 더 입력부탁드립니다."></div>
                <div></div>
                <div id="checkPwd2Result" class="span2 result reds"></div>
                <div id="submit"><input type="submit" value="비밀번호 재설정하기" class="label width-size" ></div>

            </div>
        </form>
    </div>
    <div id="bot"></div>

<script>

//비밀번호  재설정 유효성 검사

//비밀번호 키업하면 나온다
    //패스워드 유효성 검사

    let pwd1CheckReturn = false;
    let pwd2CheckReturn = false;

    $('input[name="memberPwd1"]').keyup(function(){
        
        pwd1CheckReturn = false;
        const pwdjung = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/; // 8 - 16 영 문 특 1개씩
        let pwd1Val = $('input[name="memberPwd1"]').val();

        $('#checkPwd1Result').addClass('red');
       
        if(pwd1Val == ''){
            $('#checkPwd1Result').text('비밀번호를 입력해주세요');
        }else if(!pwdjung.test(pwd1Val)){
            $('#checkPwd1Result').text('영문자 + 숫자 + 특수문자 8 ~ 16글자 부탁드립니다.');
            
        }else{
            $('#checkPwd1Result').text('');
            pwd1CheckReturn = true;
        }


    })
    //패스워드 확인2
    $('input[name="memberPwd2"]').keyup(function(){

        pwd2CheckReturn = false;
        pwd1Val = $('input[name="memberPwd1"]').val();
        let pwd2Val = $('input[name="memberPwd2"]').val();
  
        console.log(pwd1Val == pwd2Val);
        $('#checkPwd2Result').addClass('red');
       
        if(pwd2Val != pwd1Val){
            $('#checkPwd2Result').text('비밀번호가 일치하지 않습니다.');
        }else{
            $('#checkPwd2Result').addClass('green');
            $('#checkPwd2Result').removeClass('red');
            $('#checkPwd2Result').text('위의 비밀번호와 일치합니다');
            pwd2CheckReturn = true;
            
        }

    })


    //온서브밋 막아야함 값없을때, 두개의 비밀번호가 다를때
    function checkAll(){
        if(!pwd1CheckReturn) { alert('패스워드 1'); return false;}
        if(!pwd2CheckReturn) { alert('패스워드 2'); return false;}

        return true;
    }
</script>
</body>
</html>
