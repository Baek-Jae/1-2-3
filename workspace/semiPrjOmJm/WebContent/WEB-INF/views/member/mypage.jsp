<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/common/header.jsp" %>
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

    label {
        width: 100%;
        height: 100%;
        text-align: center;
        
    }
    
</style>
</head>
<body>
    <div id="mem-header"></div>
    <div id="mem-full">
        
            <input type="radio" id="edit-mypage" name="mem-navi" checked>
            <label for="edit-mypage" ><span id="icon1" class="material-symbols-outlined">person</span>&nbsp;개인정보수정</label>
            <input type="radio" id="like-group" name="mem-navi">
            <label for="like-group" ><span class="material-symbols-outlined md-24" >favorite찜한모임</span></label>
            <input type="radio" id="mem-group" name="mem-navi">
            <label for="mem-group" ><span class="material-symbols-outlined">group</span>&nbsp;가입한모임</label>
            <input type="radio" id="mem-manner" name="mem-navi">
            <label for="mem-manner" ><span class="material-symbols-outlined">sentiment_satisfied</span>&nbsp;매너온도</label>
            <input type="radio" id="mem-liked-place" name="mem-navi">
            <label for="mem-liked-place" >&nbsp;관심지역</label>
            <input type="radio" id="mem-liked-catg" name="mem-navi">
            <label for="mem-liked-catg" >&nbsp;관심카테고리</label>


            <div class="mp-main1 main">
                
                <div id="mem-mp-main">
                    <div id="mem-mp1-info">
                        <form action="/omjm/member/edit" method="post">
	                        <div>로그인 정보</div>
	                    	    <div>아이디 : <%=loginMember.getId()%></div>
	                    	</div>
	                    	<div id="mem-mp1-content">
	                            <div>개인정보 수정</div>
		                        <div>닉네임 : <input type="text" name ="mp-memberNick" value="<%= loginMember.getNick()%>"><button>중복확인</button></div>
	                            <div>패스워드 : <input type="password" name="mp-memberPwd" value="<%= loginMember.getPwd()%>"></div>
	                            <div>전화번호 : <input type="text" name="mp-memberPhone" value="<%=loginMember.getPhone()%>"><button>중복확인</button></div>
	                            
                                <div>
                                    <select>비밀번호 찾기 질문
                                    <option value="1" name = "memberPQ">기억에 남는 추억의 장소는?</option>
                                    <option value="2" name = "memberPQ">인상 깊게 읽은 책 이름은?</option>
                                    <option value="3" name = "memberPQ">자신의 보물 제1호는?</option>
                                    <option value="4" name = "memberPQ">내가 좋아하는 캐릭터는?</option>
                                    </select>
                                </div>
                                <div>비밀번호 찾기 답</div>
               					<div><input type="text" name="memberPA"></div>
	                            <input type="submit" value="수정하기">
                   			</div>
                   		</form>
                </div>
                
            </div>



            <div class="mp-main2 main">
                컨텐츠내용2
            </div>
            <div class="mp-main3 main">
                컨텐츠내용3
            </div>
            <div class="mp-main4 main">
                컨텐츠내용4
            </div>
        
    </div>
    <div id="bot"></div>
</body>
</html>