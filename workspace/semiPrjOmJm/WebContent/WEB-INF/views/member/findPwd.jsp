<%@page import="com.kh.semi.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/common/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호찾기</title>
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
        grid-template-rows: 1fr 0.5fr 1fr 1fr 1fr;
        padding: 20px;
        align-items: center;
    }
    input[type=text]{
        color: black;
        opacity: 1;
        padding-left: 20px;
        font-size: 15px;
    }
    .input{
      font-size: 15px;
      height: 40px;
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
   #submit{
    width: 100%;
    height: 80%;
   }
   .span2{
    grid-column: span 2;
   }
   #checkPqById{
    font-size: 13px;
   }
   .idInput{
    width: 200px;
   }
   #idCheck{
    width: 78%;
   }
   .flex{
    display: flex;
    justify-content: space-between

   }
   #idCheckBtn{
    border: 2px solid;
    background-color: #fff;
    opacity: 1;
    margin-left: 10px;
    font-size: 13px;
   }
    .green{  
        color: green;
        border-color: green;
    }
    .red {
        color: red;
        border-color: red;
    }
    .yellow {
        color: #fdb930;
        border-color: #fdb930;
    }
    .black {
        color: black;
        border-color: black;
    }
    input[type=fpqNo]{
        display: none;
    }
</style>
</head>
<body>
	<div id="mem-header"></div>
    <div id="back">
        <form action="/omjm/member/findpwd" method="post" onsubmit="return checkAlll();">
            <div id="main">
                <div>아이디</div>
                <div class="flex"><input type="text" id="idCheck" name="fpId"  class="input" placeholder="아이디를 입력해주세요"><button type="button" class="input yellow" id="idCheckBtn" onclick="selectQuestionById()">질문찾기</button></div>
                <div></div>
                <div id="checkPqById" class="result"></div>

                <div>비밀번호 찾기 질문</div>
                <div><input type="text" name="fpq"  class="input width-size" readonly></div>
                <div>비밀번호찾기답</div>
                <div><input type="text" name="fpa"  class="input width-size"></div>
                <!-- 번호 숨기는데 form태그에는 보내야한다. -->
                <input type="hidden" name="fpqNo">
                <input type="submit" value="비밀번호 찾기" class="label width-size span2" id="submit" >

            </div>
        </form>
    </div>
    <div id="bot"></div>

<script>
        let returnPQA = false;
        let returnPwdQ = false;
  

    $('input[name="fpId"]').click(function(){
        $('#checkPqById').addClass('red');
        $('#checkPqById').removeClass('yellow');
        $('#checkPqById').text('아이디를 입력하신 후 질문 찾기를 클릭해주세요');
    })

    //아이디를 다시 새로치면 onsubmit조건에 걸리게한다
    $('input[name="fpId"]').keyup(function(){
        returnPQA = false;
        returnPwdQ = false;

    })


   function selectQuestionById(){

        let id = $('input[name=fpId]').val();

        if(id == ''){
            alert('아이디를 입력해주신 뒤 클릭해주세요');
        }else{
            $.ajax({
            url : "/omjm/member/selectqabyid",
            type : "post",
            data : {
                "memberId" : id
            },
            success : function(data){


                const result = JSON.parse(data);

                if(result != null){

                    $('#idCheckBtn').addClass('green'); // 성공하면 초록으로 바꾸세용~
                    $('#idCheckBtn').removeClass('yellow'); 
                    $('#checkPqById').html('비밀번호 찾기 질문을 불러왔습니다. <br>답을 입력해주세요.');
                    $('input[name=fpq]').val(result.q);
                    $('input[name=fpqNo]').val(result.no)
                    returnPwdQ = true;
                    // $('input[name=fpId]').attr("readonly", true)
                    $('#checkPqById').addClass('green');
                    $('#checkPqById').removeClass('red');
                    console.log(returnPwdQ);

                }else{

                    $('#checkPqById').removeClass('green');
                    $('#checkPqById').removeClass('yellow');
                    $('#checkPqById').addClass('red');
                    $('#checkPqById').text('없는아이디입니다. 아이디찾기를 진행해주세요');   
                    $('#idCheckBtn').addClass('red');
                    $('#idCheckBtn').removeClass('yellow');
                    $('#idCheckBtn').removeClass('green');
                }

            },
            error : function(){
               alert('에이잭스 에러!!!!!!!!!');
            }
   
        }) //ajax
            
        }
        
    }

    // function checkQA(){
    //     let Qanswer = $('input[name=fpa]').val()

    //     console.log(Oanswer);

    //     if(Qanswer == ''){
    //         returnPQA = false;
    //     }else{
    //         returnPQA = true;
    //     }

    // }

    function checkAlll(){

        // alert(returnPQA+"123"+returnPwdQ);
        // checkQA();
        if(!returnPwdQ){ alert('비밀번호 질문을 찾아주세요'); return false;}
        
        let Qanswer = $('input[name=fpa]').val();
        if(Qanswer==''||Qanswer==null){
            alert('질문의 답장을 작성하고 클릭해주세요')
            return false;
        }
        // if(!returnPQA){alert('질문의 답장을 작성하고 클릭해주세요');return false; }


     return true;
    }
    </script>
</body>
</html>
