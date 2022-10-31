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
        grid-template-rows: repeat(5, 1fr 1fr 0.5fr) repeat(8, 1.2fr);
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
        padding-left: 10px;
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
    #nickCheckBtn{
        height: 100%;
    }
    input[type=submit]{
        background-color: #fdb930;
        color: #fff;
        font-size: 15px;
        height: 100%;
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
                <div>별명</div>
                <div><input type="text" name="memberNick" class="input width-size" placeholder="한글 / 숫자 / 영어 2 ~ 10글자"><button type="button" id="nickCheckBtn" class="label doublecheck yellow"  onclick="nickDoubleCheck()" >중복체크</button></div>
                <div id="checkNickResult"class="span2 result"></div>
                <div>핸드폰번호</div>
                <div id="check"><input type="text" name="memberPhone" class="input width-size"oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1');" ><button id="phoneCheckBtn" class="label doublecheck yellow" type="button" onclick="phoneDoubleCheck()">중복체크</button></div>
                <div id="checkPhoneResult"class="span2 result"></div> 
                <div>관심지역</div>
                <div><input type="text" name="memberPlace" class="input width-size" id="likeplace"></div>
                <div>카테고리</div>
                <div><input type="text" name="memberCate" class="input width-size"></div>
                <div>
                    남자 <input type="radio" name="memberGender" value="M"> &nbsp;
                    여자 <input type="radio" name="memberGender" value="F">
                </div>
                <select name="memberPQ" class="select" id="select">
                    <option value="0">비밀번호찾기 질문</option>
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


    <%if(alertMsg != null){ %>
		Swal.fire({
        icon: 'error',
        title: '회원가입 실패하셨습니다.',
         text: '입력값이 전부 채워지지 않았습니다.',
        //footer: '<a href="">Why do I have this issue?</a>'
    })

	<% } %>

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



    let cate = $('input[name=memberCate]');

    cate.click(function(){

        openSelectCate();
    })

    function openSelectCate(){
        window.name = "parentForm";

        openWin=window.open("likeCate", "child2Form", "width=600,height=750,resizable=no,scrollbars=no");
    }







    //온 서브밋을 위한 변수 선언;
    let idCheckReturn = false;
    let pwd1CheckReturn = false;
    let pwd2CheckReturn = false;
    let nickCheckReturn = false;
    let phoneCheckReturn = false;
    
   //아이디 인풋 키업하면 나온다.
    $('input[name="memberId"]').keyup(function(){

        let idCheckReturn = false;
        let idVal = $('input[name="memberId"]').val();
        const idjung = /^[a-z]+[a-z0-9]{5,11}$/g;
        
        
       
        $('#checkIdResult').addClass('red');
        $('#idCheckBtn').addClass('yellow'); // 다시키업하면 yellow
        $('#idCheckBtn').removeClass('green'); // 다시키업하면 yellow
        $('#idCheckBtn').removeClass('red'); // 다시키업하면 yellow
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
            alert('먼저 아이디 형식을 확인해주세요')
        }else{
            $.ajax({
            url : "/omjm/member/idDoubleCheck",
            type : "post",
            data : {
                "memberId" : idVal
            },
            success : function(result){

                if(result ==0){
                    $('#idCheckBtn').addClass('green'); // 성공하면 중복체크 초록으로 바꾸세용~
                    $('#idCheckBtn').removeClass('yellow'); // 성공하면 중복체크 초록으로 바꾸세용~
                    $('#checkIdResult').text('사용가능한 아이디입니다.');
                    $('#checkIdResult').addClass('green');
                    $('#checkIdResult').removeClass('red');
                    idCheckReturn = true;

                }else{
                    $('#checkIdResult').text('중복된 아이디입니다.');   
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
    
    
    
    //비밀번호 키업하면 나온다
    //패스워드 유효성 검사
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
    

    //닉네임 키업이 되면 
    $('input[name="memberNick"]').keyup(function(){

        let nickCheckReturn = false;
        let nickVal = $('input[name="memberNick"]').val();
        const nickjung = /^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,10}$/; // 한글 숫자 영어 2-16
        $('#checkNickResult').addClass('red');
        $('#nickCheckBtn').addClass('yellow'); // 다시키업하면 yellow
        $('#nickCheckBtn').removeClass('red');
        $('#nickCheckBtn').removeClass('green');

        if(nickVal == ''){
            $('#checkNickResult').text('닉네임을 입력해주세요');
        }else if(!nickjung.test(nickVal)){
            $('#checkNickResult').text('닉네임은 영소문자 한글 숫자 2 ~ 10글자 ');
        }else{
            $('#checkNickResult').text('닉네임을 중복검사를 진행해주세요');
        }
    })

 

    function nickDoubleCheck(){

        let nickVal = $('input[name="memberNick"]').val();
         const nickjung = /^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,10}$/; // 한글 숫자 영어 2-16
        console.log(nickVal);
        
        if(nickVal == ""){
            alert('먼저 닉네임을 입력해주시고 중복검사 진행해주세요');
        }else if(!nickjung.test(nickVal)){
           alert('형식에 맞춰 닉네임을 입력하신 후 중복검사를 진행해주세요')
        }
        else{
            $.ajax({
            url : "/omjm/member/nickDoubleCheck",
            type : "post",
            data : {
                "memberNick" : nickVal
            },
            success : function(result){


                if(result ==0){
                    $('#nickCheckBtn').addClass('green'); // 성공하면 중복체크 초록으로 바꾸세용~
                    $('#nickCheckBtn').removeClass('yellow');
                    $('#checkNickResult').text('사용가능한 별명 입니다.');
                    $('#checkNickResult').addClass('green');
                    $('#checkNickResult').removeClass('red');
                    nickCheckReturn = true;

                }else{
                    $('#checkNickResult').text('사용불가능한 별명입니다.');   
                    $('#nickCheckBtn').addClass('red');
                    $('#nickCheckBtn').removeClass('yellow');
                    $('#nickCheckBtn').removeClass('green');
                    
                }

            },
            error : function(){
                alert('에이잭스 에러!!!!!!!!!');
            }
    
            }) //ajax
        }
       
            
    }


    
    //핸드폰번호는 번호만 입력되게 해놨다!
    $('input[name="memberPhone"]').keyup(function(){
        let phoneCheckReturn = false;

        let phoneVal = $('input[name="memberPhone"]').val();

      
        $('#checkPhoneResult').addClass('red');
        

        if(phoneVal == ''){
            $('#checkPhoneResult').text('휴대전화 번호 10자리 입력해주세요');
        }else if(phoneVal.length < 11){
            $('#checkPhoneResult').text('휴대전화 번호를 덜 입력하셨습니다.');
        }else if(12 <= phoneVal.length){
            $('#checkPhoneResult').text('휴대전화 번호 10자리만 입력해주세요');
        }else{
           
            $('#checkPhoneResult').text('중복 체크 부탁드립니다.');
            
        }


    })

    //핸드폰번호 에이젝스 > 회원님의 아이디는 띄워줄까?

    function phoneDoubleCheck(){
        let phoneVal = $('input[name="memberPhone"]').val();
        console.log(phoneVal);
        if(phoneVal.length < 11 || 12 <= phoneVal.length ){

        alert('휴대전화번호 형식에 맞추신 뒤 중복체크를 눌러주세요')
        }else{
        $.ajax({
            url : "/omjm/member/phoneDoubleCheck",
            type : "post",
            data : {
                "memberPhone" : phoneVal
            },
            success : function(result){


                if(result ==0){
                    $('#phoneCheckBtn').addClass('green'); // 성공하면 중복체크 초록으로 바꾸세용~
                    $('#phoneCheckBtn').removeClass('yellow');
                    $('#checkPhoneResult').text('사용가능한 번호 입니다.');
                    $('#checkPhoneResult').addClass('green');
                    $('#checkPhoneResult').removeClass('red');
                    phoneCheckReturn = true;

                }else{
                   
                    $('#checkPhoneResult').text('이미 가입하신 회원입니다. 아이디 찾기를 이용해주세요'); //말해주고 아이디찾기로 보낼까?   
                    $('#phoneCheckBtn').addClass('red');
                    $('#phoneCheckBtn').removeClass('yellow');
                    $('#phoneCheckBtn').removeClass('green');
                }

            },
            error : function(){
                alert('에이잭스 에러!!!!!!!!!');
            }
    
            }) //ajax
    }
    }
    
    //젠더선택했니?
    function checkGender() {
        let genderVal = $('input[name="memberGender"]').val();

        if(genderVal != null){
            return true;
        }else{
            return false;
        }
    }

    
    function checkPA(){
        let PAVal = $('input[name="memberPA"]').val();

        if(PAVal != null){
            return true;
        }else if(PaVal == ''){
            return false;
         
        }else{
            return false;
        }
    }


    //온서브밋
    function checkAll(){
    
        if(!idCheckReturn){ alert('아이디'); return false;}
        if(!pwd1CheckReturn){ alert('비밀번호1'); return false;}
        if(!pwd2CheckReturn){ alert('비밀번호2'); return false;}
        if(!nickCheckReturn){ alert('닉네임'); return false;}
        if(!phoneCheckReturn){ alert('휴대전화번호') ;return false;}
        if(!checkGender){alert('젠더선택') ;return false; }
        if(!checkPA){ alert('PA를입력'); return false; }

        return true;

    }
</script>
</body>
</html>