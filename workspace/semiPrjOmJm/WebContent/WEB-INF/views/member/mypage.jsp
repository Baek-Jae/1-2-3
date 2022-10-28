<%@page import="com.kh.semi.password.PasswordVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/common/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String alertMsg = (String)request.getAttribute("alertMsg");%>
<% List<PasswordVo> pwdQList = (List<PasswordVo>)request.getAttribute("pwdQList"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
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
*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Noto Sans KR', sans-serif;
}
    #mem-full{
        width: 100vw;
        height: 780px;
        display: grid;
        grid-template-columns: repeat(6, 1fr);
        grid-template-rows: 1fr 10fr;
        justify-content: center;
        align-items: center;
        margin: 0 auto;
        box-sizing: border-box;
        gap: 0;

    }
   
    #mem-header{
    	height : 80px
    }
    #bot{
        width: 100vw;
        height: 200px;
        border: 1px solid black;
    }

    input[type="radio"]{
        display: none;    
    } 
 
    input[type="radio"] + label{

        padding: 20px;
        cursor: pointer;
        border-bottom: 1px solid black;
       
    }
    input[type="radio"]:checked + label{
        background-color: #fdb930;
        color: white;  
        border-bottom: none;
        border-right: 1px solid black;
        border-left: 1px solid black;
    } 

    .main{
        width: 100%;
        height: 100%;
        grid-column: span 6;
        display: none;
        background-color: #fdb930;
    }
    input[id="edit-mypage"]:checked ~ .mp-main1{display: block; }
    input[id="like-group"]:checked ~ .mp-main2{ display: block;}
    input[id="mem-group"]:checked ~ .mp-main3{display: block;}
    input[id="mem-manner"]:checked ~ .mp-main4{display: block;}
    input[id="mem-liked-place"]:checked ~ .mp-main5{display: block;}
    input[id="mem-liked-catg"]:checked ~ .mp-main6{display: block;}

    label {
        width: 100%;
        height: 100%;
        text-align: center;
   
    }
    .input{
      
      border: 1px solid #dddddd;
      color: black;
      border-radius: 5px;
  
    }
    .span2{
        grid-column: span 2;
    }
    .label{

    color: #fff;
    background-color: #fdb930;
    cursor: pointer;
    border-radius: 5px;
    border: none;

    }
    .doublecheck{
        padding: 1px 3px 3px 1px;
        margin-left: 15px;
        font-size: 15px;
        width: 100px;
    }
    /* mp-main1 부분 */
    
    .back{
        width: 40vw;
        height: 700px;
        background-color: rgba(0, 53, 109, 0.95);
        display: grid;
        grid-template-rows: 2fr 7fr;
        justify-content: center;
        margin: 100px auto;
        border-radius: 30px;
        color: white;
    }
    #mp-id{
        margin: 0 0px 0px 50px;
        padding: 50px;

    }
    #mem-mp1-content{
        display: grid;
        grid-template-columns: 0.5fr 1.5fr;
        border: 1px solid white;
        border-radius: 10px;
        height: 95%;
        padding: 30px;
    }
    #mp-login-info{
        padding: 10px;
        text-align: center;
        margin: 0 auto;
        border-bottom: 1px solid white;
    }
  /* 찜한 모임 부분 css */
  /* 매너온도 부분 css */
  #mem-mp4-content{
    
    background-color: rgb(163, 163, 162);
    width: 800px;
    border-radius: 10px;
    display: grid;
    grid-template-columns: repeat(3,2fr) repeat(3,1fr);
    height: 90%;
    padding: 30px;
    margin: 30px;
  }
  #mem-mp2-content{
    width: 800px;
    background-color: rgb(163, 163, 162);
    border-radius: 10px;
    display: grid;
    justify-content: center;
    grid-template-columns: repeat(4, 1fr);
    height: 90%;
    padding: 30px;
    margin: 30px;
  }
  .back4{
        width: 50vw;
        height: 700px;
        background-color: rgba(0, 53, 109, 0.95);
        display: grid;
        grid-template-rows: 2fr 7fr;
        justify-content: center;
        margin: 100px auto;
        border-radius: 30px;
        color: white;

    }
    /* 관심지역 css */
    #mem-mp5-content{
        display: grid;
        grid-template-columns: repeat(2, 1fr);
    }
</style>
</head>
<body>
	<%if(alertMsg != null){ %>	
			alertify.error('<%=alertMsg%>');
	<% } %>
    <div id="mem-header"></div>
    <div id="mem-full">
        
            <input type="radio" id="edit-mypage" name="mem-navi" >
            <label for="edit-mypage" ><span id="icon1" class="material-symbols-outlined">person&nbsp;개인정보수정</span>&nbsp;</label>
            <input type="radio" id="like-group" name="mem-navi">
            <label for="like-group" ><span class="material-symbols-outlined md-24"  >favorite&nbsp;찜한모임</span></label>
            <input type="radio" id="mem-group" name="mem-navi">
            <label for="mem-group" ><span class="material-symbols-outlined">group&nbsp;가입한모임</span></label>
            <input type="radio" id="mem-manner" name="mem-navi">
            <label for="mem-manner" ><span class="material-symbols-outlined">sentiment_satisfied&nbsp;매너온도</span></label>
            <input type="radio" id="mem-liked-place" name="mem-navi">
            <label for="mem-liked-place" ><span class="material-symbols-outlined">pin_drop&nbsp;관심지역</span></label>
            <input type="radio" id="mem-liked-catg" name="mem-navi">
            <label for="mem-liked-catg" ><span class="material-symbols-outlined">heart_plus&nbsp;관심카테고리</span></label>


            
            <div id="mem-mp-main" class="mp-main1 main" >
                    <div class="back">
                        <div class="mem-mp-info">
                            <form action="/omjm/member/edit" method="post">
                                <div id="mp-login-info"><h1>로그인 정보</h1></div>
                                <div id="mp-id">아이디 : <%=loginMember.getId()%></div>
                                                
                        </div>
                        <div id="mem-mp1-content">

                                    <div class="span2" align="center">수정할 값을 입력해주세요</div>
                                    <div>닉네임 </div>
                                    <div>: <input type="text" name ="mp-memberNick" value="<%= loginMember.getNick()%>"  class="input">
                                        <button class="label doublecheck">중복확인</button>
                                    </div>
                                    <div>패스워드 </div>
                                    <div>: <input type="password" name="mp-memberPwd" value="<%= loginMember.getPwd()%>"  class="input"></div>
                                    <div>전화번호 </div>
                                    <div>: <input type="text" name="mp-memberPhone" value="<%=loginMember.getPhone()%>"  class="input">
                                        <button class="label doublecheck">중복확인</button>
                                    </div>
                                    <div>비밀번호  질문</div>
                                    <div>: 
                                        <%-- <select name="mp-memberPQ" class="select">
                                            <%for(int i = 0; i < pwdQList.size(); i++) {%>
                                            <option selected value="<%= pwdQList.get(i).getNo() %>" ><%=pwdQList.get(i).getQ() %></option>
                                                <% } %>
                                        </select> --%>
                                        <select name="mp-memberPQ">
                                            <c:forEach items="${pwdQList}" var="vo">
                                            <option <c:if test="${vo.no == sessionScope.loginMember.pq }">selected</c:if> value="${vo.no}" >${vo.q}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                        <div> 비밀번호 답</div>
                                       
                                       <div>: <input type="text" name="mp-memberPA" value="<%= loginMember.getPa()%>"  class="input"></div>
                                        
                                    <input type="submit" value="수정하기" class="span2 input">
                            </form>
                        </div>
                </div>
            </div>    
           

             <!-- 컨텐츠 2 -->

             <div class="mp-main2 main">
                <div class="back4">
                    <div class="mem-mp-info">
                        
                            <div id="mp-login-info"><h1>찜한모임</h1></div>                       
                    </div>
                    <div id="mem-mp2-content">
                        <!-- 반복 찜한 모임 보이게 해야함 반복문으로--> 
                       	<div>큰 카테고리</div>
                       	<div>작은 카테고리</div>
                        <div>그룹이름</div>
                        <div>찜하기 하트</div>
                       	
                    </div>
                </div>
            </div>




             <!-- 컨텐츠 내용 3 -->
             <div class="mp-main3 main">
                <div class="back4">
                    <div class="mem-mp-info">
                       
                            <div id="mp-login-info"><h1>가입한모임</h1></div>                       
                    </div>
                    <div id="mem-mp2-content">
                        <!-- 반복 가입한 모임 보이게 해야함 반복문으로--> 
                       	<div>큰 카테고리</div>
                       	<div>작은 카테고리</div>
                        <div>그룹이름</div>
                        <div>찜하기 하트</div>
                       	
                    </div>
                </div>
            </div>

            <div class="mp-main4 main">
                <div class="back4">
                    <div class="mem-mp-info">
                            <div id="mp-login-info"><h1>매너온도</h1></div>                       
                    </div>
                    <div id="mem-mp4-content">
                        <!-- 참여 및 불참여 목록 뜨게해야함--> 
                       	<div>일자</div>
                       	<div>그룹이름</div>
                        <div>오프그룹이룸</div>
                        <div>참여 불참 여부</div>
                        <div>+1 -1 </div>
                        <div>매너온도 점수</div>
                       	
                    </div>
                </div>
                
            </div>
            <div class="mp-main5 main">
                <div class="back4">
                    <div class="mem-mp-info">
                            <div id="mp-login-info"><h1>관심지역</h1></div>                       
                    </div>
                    <div id="mem-mp5-content">
                        <div>관심지역</div>
                        <div>
                            <input type="text" id="likeplace" value="<%= loginMember.getPlace()%>"> 입니다
                        </div>
                        
                        <button onclick="editplaceAjax()" >관심지역 수정하기</button>
                        
                    </div>
                </div>
            </div>


            <div class="mp-main6 main">
                컨텐츠내용4
            </div>
        
    </div>
    <div id="bot"></div>
  <script>

    const page = ${x};
    // $('input[type=radio]')
    const btnArr = document.querySelectorAll('input[type=radio]');
    
    for (let i = 0; i < btnArr.length; i++) {
        const element = btnArr[i];

        if(page==i){
            element.click();        
        }
        
    }

    btnArr[0].addEventListener('click', function(){
        location.href = "/omjm/member/check";
    })

    //마이페이지 화면에서 수정하기 하기
    function openSelectPlace(){
         // window.name = "부모창 이름";
        window.name = "parentForm";

        // window.open("open할 window", "자식창 이름", "팝업창 옵션"); 
        openWin=window.open("likeplace","childForm","width=600,height=750,resizable=no,scrollbars=no");
        
    }
   
    const editplace = document.querySelector('#likeplace');

    editplace.addEventListener('click', function(){
        openSelectPlace();
    })

    function editplaceAjax(){
        $.ajax({

            url = "/omjm/member/likeplace",
            type : "post",
            data : {
                "likeplace" : "$('#likeplace').val()"
            },
            success : function(){
                alert('수정성공');
            },
            error : function(){
                alert('실패');
            }


        })
    }
  </script>
</body>
</html>