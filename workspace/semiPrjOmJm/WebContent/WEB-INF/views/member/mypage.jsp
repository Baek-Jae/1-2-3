<%@page import="com.kh.semi.password.PasswordVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/common/header.jsp" %>
<%
	String alertMsg = (String)request.getAttribute("alertMsg");

%>
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
    /* mp-main1 부분 */
    #mem-mp1-info{
        display: grid;
        grid-template-columns: repeat(2, 1fr);
    }
    .material-icons.md-24 { font-size: 24px; }
</style>
</head>
<body>
	<%if(alertMsg != null){ %>	
			alertify.error('<%=alertMsg%>');
	<% } %>
    <div id="mem-header"></div>
    <div id="mem-full">
        
            <input type="radio" id="edit-mypage" name="mem-navi" checked>
            <label for="edit-mypage" ><span id="icon1" class="material-symbols-outlined md-24">person&nbsp;개인정보수정</span>&nbsp;</label>
            <input type="radio" id="like-group" name="mem-navi">
            <label for="like-group" ><span class="material-symbols-outlined md-24" >favorite&nbsp;찜한모임</span></label>
            <input type="radio" id="mem-group" name="mem-navi">
            <label for="mem-group" ><span class="material-symbols-outlined">group&nbsp;가입한모임</span></label>
            <input type="radio" id="mem-manner" name="mem-navi">
            <label for="mem-manner" ><span class="material-symbols-outlined">sentiment_satisfied&nbsp;매너온도</span></label>
            <input type="radio" id="mem-liked-place" name="mem-navi">
            <label for="mem-liked-place" ><span class="material-symbols-outlined">pin_drop&nbsp;관심지역</span></label>
            <input type="radio" id="mem-liked-catg" name="mem-navi">
            <label for="mem-liked-catg" ><span class="material-symbols-outlined">heart_plus&nbsp;관심카테고리</span></label>


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
                                    <select name="mp-memberPQ" class="select">비밀번호 찾기 질문 
					                	<%for(int i = 0; i < pwdQList.size(); i++) {%>
					                	<option value=">"><%=pwdQList.get(i).getQ() %></option>
					                 	 <% } %>

               					  </select>
                                </div>
                                <div>비밀번호 찾기 답</div>
               					<div><input type="text" name="memberPA" value="<%= loginMember.getPa()%>"></div>
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
            <div class="mp-main5 main">
                컨텐츠내용4
            </div>
            <div class="mp-main6 main">
                컨텐츠내용4
            </div>
        
    </div>
    <div id="bot"></div>
    <!-- <script>
		//마이페이지 비밀번호찾기 체크
		const pQArr = document.querySelectorAll('option[name=mp-memberPQ]');
		const pQ = '<%= loginMember.getPq() %>';
        console.log(pQArr);
        console.log(pQ);
        
//		for(let i = 0; i < hobbyArr.length; i++){
//			const v = hobbyArr[i].value;
//			
//			let result = hobbyStr.search(v);
//			if(result >= 0){
//				hobbyArr[i].checked = true;
//			}
//		}
	</script> -->
        <script>
        //비밀번호 찾기 질문 되어있는거 셀렉트하기
        $('#mp-memberPQ').val('3').prop('selected',true);
        </script>
</body>
</html>