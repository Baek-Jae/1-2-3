<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./member1.css">
 <style>
    html, body{
        padding: 0;
        margin: 0;
    }
    div{
        box-sizing: bor;
    }

    
}

    /*헤더 부분*/
    
    #head{
        border: 1px solid blue;
        width: 1920px;
        height: 100px;
        
    }
    #content{
        border: 1px solid red;
        
        width: 1920px;
        height: 780px;
    }
    #bot{
        width: 1920px;
        height: 200px;
        border: 1px solid green;
    }

    #menuTop{
        width: 100vw;
        height: 50%;
        background-color: white;
        color: black;
        font-size: 1.5rem;
        display: grid;
        grid-template-columns: repeat(4,1fr);
        position: relative; left: 250px;
    }

    #modify1{
        position: absolute;
        width: 100px;
        height: 30px;
        left: 1700px;
        top: 200px;
        border: 2px solid yellow;
        border-radius: 30%;
        text-align: center;
        background-color: yellow;

    }
    #modify2{
        position: absolute;
        width: 100px;
        height: 30px;
        left: 1700px;
        top: 240px;
        border: 2px solid yellow;
        border-radius: 30%;
        text-align: center;
        background-color: yellow;
    }

    ul.mylist li, ol.mylist li {
    padding: 5px 0px 5px 5px;
    margin-bottom: 5px;
    border-bottom: 1px solid #efefef;
    font-size: 12px;
   
    }
    .cd1{
       text-align: center;
       position: relative;
       right: 400px;
       top: 100px;
    }
    #modify3{
        position: absolute;
        width: 100px;
        height: 30px;
        left: 1700px;
        top: 640px;
        border: 2px solid yellow;
        border-radius: 30%; 
        text-align: center;
        background-color: yellow;
    }

    </style>
</head>
<body>
  <div id="main">
        <div id="head"></div>
        <div id="header">
            <div id="menuTop">
                <div><a href=""> 등급관리</a></div>
                <div><a href="">회원관리</a> </div>
                <div><a href="">게시글관리</a> </div>
                <div> <a href="">문의관리</a> </div>
            </div>
        </div>
        <div id="content">
       
          <div class="cd1">
            <h2>회원 이름 ::~~ </h2>
            <h3>회원등급 ::~~</h3>
              <h3>회원 가입모임::</h3>
              <ul>
                <li>_____________</li>
                <li>_____________</li>
                <li>_____________</li>
                <li>_____________</li>
              </ul>
              <h3>회원 온도?::</h3>
              <h3><a href="">회원 탈퇴</a></h3>
              <!-- 회원 강제탈퇴시 (탈퇴완료 메시지) -->
              
              
            <!-- <p>내용</p> 
            <p>내용</p> -->
          </div>
          
        </div>

        <div id="modify1"><a href="">순차적용</a></div>
        <div id ="modify2"><a href="">직접입력</a></div>
        <div id ="modify3"><a href="">저장</a></div>
        </div>
        <div id="bot"></div>
    </div>
		

</body>
</html>