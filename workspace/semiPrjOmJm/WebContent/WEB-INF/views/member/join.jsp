<%@page import="com.kh.semi.password.PasswordVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<PasswordVo> pwdQList = (List<PasswordVo>)request.getAttribute("pwdQList"); %>

<%@ include file = "/WEB-INF/views/common/header.jsp" %>
<% String place = (String)request.getAttribute("place");%>
<%
	String alertMsg = (String)request.getAttribute("alertMsg");
%>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
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
       
    }
    #header{
        width: 100vw;
        height: 80px;
    
    }
    #bot{
        width: 100vw ;
        height: 200px;
    }
    #main{
        
        padding-top: 50px;
        display: grid;
        grid-template-rows: repeat(5, 1fr 1fr 0.5fr) repeat(8, 1fr);
        place-content: center center;   
        
    }
    .input{
      
        border: 1px solid #dddddd;
        color: #999999;
        border-radius: 5px;
    
    }
    .label{
        background-color: #fff;
        cursor: pointer;
        border-radius: 5px;
        border: none;
        border-width: 1px;
        border-style: solid;
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
    form > * {
        font-size: 20px;
    }
    .result{
        font-size: 15px;
        color: black;
        padding-left: 20px;
    }
    input[type=submit]{
        margin-top: 30px;
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
</style>
</head>
<body>
	<div id="header">헤더</div>
    <div id="back">
        <form action="/omjm/member/join" method="post" enctype="multipart/form-data" onsubmit="return checkAll();" >
            <div id="main">
                
                <div >아이디</div>
                <div id="check"><input type="text" name="memberId" class="input width-size" placeholder="8 ~ 12글자 영문 대소문자와 숫자"><button type="button" class="label doublecheck yellow" id="idCheckBtn"onclick="idDoubleCheck()">중복체크</button></div>
                <div id="checkIdResult" class="span2 result"></div>
                <div class="span-2">비밀번호</div>
                <div><input type="password" name="memberPwd1" class="input width-size" placeholder="8 글자이상 특수문자포함"></div>
                <div id="checkPwd1Result" class="span2 result"></div>
                <div>비밀번호 확인</div>
                <div><input type="password" name="memberPwd2" class="input width-size" placeholder="비밀번호 한번 더 입력부탁드립니다."></div>
                <div id="checkPwd2Result" class="span2 result"></div>
                <div>닉네임</div>
                <div><input type="text" name="memberNick" class="input width-size"><button class="label doublecheck yellow" type="button">중복체크</button></div>
                <div id="checkNickResult"class="span2 result"></div>
                <div>핸드폰번호</div>
                <div id="check"><input type="text" name="memberPhone" class="input width-size"><button class="label doublecheck yellow" type="button">중복체크</button></div>
                <div id="checkPhoneResult"class="span2 result"></div> 
                <div>관심지역</div>
                <div><input type="text" name="memberPlace" class="input width-size" id="likeplace"></div>
                <div>카테고리</div>
                <div><input type="text" name="memberCate" class="input width-size"></div>
                <div>
                    남자 <input type="radio" name="memberGender" value="M"> &nbsp;
                    여자 <input type="radio" name="memberGender" value="F">
                </div>
                <select name="memberPQ" class="select">
                    <option value="">비밀번호찾기 질문</option>
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
    //비밀번호 질문은 무조건 클릭해야하는데 이걸 어떻게 구현하지?


    // <%if(alertMsg != null){ %>
	// 	Swal.fire({
    //     icon: 'error',
    //     title: '회원가입 실패하셨습니다.',
    //      text: '입력값이 전부 채워지지 않았습니다.',
    //     //footer: '<a href="">Why do I have this issue?</a>'
    // })

	// <% } %>

    //지역을 가져오는 인풋 클릭하면 새 창이뜬다 
    let place = document.querySelector('input[name=memberPlace]');
   
    place.addEventListener('click', function(){
        openSelectPlace();
    })


    function openSelectPlace(){
         // window.name = "부모창 이름";
        window.name = "parentForm";
        // window.open("open할 window", "자식창 이름", "팝업창 옵션"); 
        openWin=window.open("likeplace","childForm","width=600,height=750,resizable=no,scrollbars=no");
        
        }


    let idCheckReturn = false;
    //온서브밋
    function checkAll(){

    if(idCheckReturn = false){
        return flase;
    }




        
    }
    
   
    $('input[name="memberId"]').keyup(function(){

        let idVal = $('input[name="memberId"]').val();
        const idjung = /^[a-z]+[a-z0-9]{5,11}$/g;
        
        
       
        $('#checkIdResult').addClass('red');

        if(idVal == ''){
            $('#checkIdResult').text('아이디를 입력해주세요');
        }else if(!idjung.test(idVal)){
            $('#checkIdResult').text('아이디는 6 ~ 12 영 + 숫 으로 부탁드립니다. ');
            
        }else{
            $('#checkIdResult').text('중복검사가 필요한 아이디 입니다.');
            
        }
        
       
    })
    
    //아이디 에이잭스
    function idDoubleCheck(){
        let idVal = $('input[name="memberId"]').val();

        const idjung = /^[a-z]+[a-z0-9]{5,11}$/g;;
        if(!idjung.test(idVal)) {
            alert('아이디 형식에 맞춰 중복확인을 해주세요')
        }else{
            $.ajax({
            url : "/omjm/member/idDoubleCheck",
            type : "post",
            data : {
                "idVal" : idVal
            },
            success : function(result){

                console.log(result);

                if(result ==0){
                    $('#idCheckBtn').addClass('chekced'); // 성공하면 중복체크 초록으로 바꾸세용~
                    $('#checkIdResult').text('사용가능한 아이디입니다.');
                    $('#checkIdResult').addClass('green');
                    $('#checkIdResult').removeClass('red');
                    idCheckReturn = true;

                }else{
                    $('#checkIdResult').text('중복된 아이디입니다.');   
                    $('#idCheckBtn').addClass('unchekced');
                }

            },
            error : function(){
               alert('에이잭스 에러!!!!!!!!!');
            }
   
        }) //ajax
            
        }

    }



    const pwdjung = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/; // 8 - 16 영 문 특 1개씩


 
    
    
    

    //비밀번호 공백 및 유효성 체크
    // function pwdCheck(){

    //     if(pwdCheck == ''){
    //         alert('비밀번호를 입력해주세요')
    //     }else {
    //         if(!pattern1.test(pwdCheck) || !pattern2.test(pwdCheck) || !pattern3.test(pwdCheck) || pwdCheck.length < 8) {
    //             $('#checkIdResult').text("비밀번호는 8자리 이상 문자, 숫자, 특수문자로 구성하여야 합니다.");
    //             return false;
    //         }else {
    //             return true;
    //         }
    //     }
    // }





</script>
</body>
</html>