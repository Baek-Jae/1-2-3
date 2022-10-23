<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
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
        grid-template-columns: repeat(4, 1fr);
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

        display: inline-block; 
        padding: 20px;
        cursor: pointer;
        border-radius: 10px;
       
    }
    input[type="radio"]:checked +label{
        background-color: #fdb930;
        color: var(--main);  
    } 
    .main{
        width: 100%;
        height: 100%;
        grid-column: span 4;
        display: none;
        background-color: #fdb930;
    }
    input[id="edit-mypage"]:checked ~ .mp-main1{display: block;}
    input[id="like-group"]:checked ~ .mp-main2{ display: block;}
    input[id="mem-group"]:checked ~ .mp-main3{display: block;}
    input[id="mem-manner"]:checked ~ .mp-main4{display: block;}
    label {
    width: 100%;
    height: 100%;
    }
</style>
</head>
<body>
    <div id="mem-header"></div>
    <div id="mem-full">
        
            <input type="radio" id="edit-mypage" name="mem-navi" checked>
            <label for="edit-mypage">정보수정</label>
            <input type="radio" id="like-group" name="mem-navi">
            <label for="like-group">찜한모임</label>
            <input type="radio" id="mem-group" name="mem-navi">
            <label for="mem-group">가입한모임</label>
            <input type="radio" id="mem-manner" name="mem-navi">
            <label for="mem-manner">정보수정</label>


            <div class="mp-main1 main">
                컨텐츠내용1
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