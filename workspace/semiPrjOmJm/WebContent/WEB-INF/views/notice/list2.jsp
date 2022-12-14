<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
    #list-main{
        width: 1200px;
        height: 75vh;
        margin:auto;
        padding: 100px;
    }

    #list-area{
       	margin-top:25px;
        width: 100%;
        height: 100%;
        display: grid;
        justify-content: center;
        grid-template-rows: 1fr 1fr 5fr 0.5fr 0.5fr;
        /* border: 1px solid red; */
    }

    #commu-title{
        height: 100%;
        margin: auto;
        display: grid;
        grid-template-rows: 1fr 0.5fr;
    }

    #commu-title div{
        font-family: var(--sans);
        color: var(--semi-green);
        display: flex;
        justify-content: center;
        align-items: center;
    }

    #commu-title div span{
        margin: 10px;
    }

    #commu-title div:nth-child(1){
        width: 100%;
        font-size: 14pt;
        font-weight: 600;  
    }

    #commu-title div:nth-child(2){
        width: 100%;
        font-size: 10pt;
        font-weight: 300;  
    }

    #cate-btn{
        display: flex;
        justify-content: center;
        align-items: center;
    }

    #btn-group{
        width: 400px;
        height: 30px;
        border-radius: 30px;
        background-color: rgb(238, 249, 232);
    }

    #btn-group input{
        display: block;
        float: left;
        width: 25%;
        height: 100%;
        border: none;
        margin: 0;
        background-color: rgb(238, 249, 232);
        border-radius: 30px;
        font-family: var(--sans);
        color: black;
        font-size: 10pt; 
    }

    #btn-group input:hover{
        font-weight: 600;
        color: var(--semi-green);
    }

    #cate-list{
        width: 1000px;
        height: 100%;
        margin: auto;
        display: grid;
        grid-template-columns: 1fr 5fr 2fr 3fr 1fr;
        grid-template-rows: repeat(11,40px);
        border-bottom:1px solid var(--semi-green);
    }

    #cate-list div{
        display: flex;
        justify-content: center;
        align-items: center;
        font-family: var(--sans);
        font-size: 14px;
    }

    #cate-list .first{
        letter-spacing:5px;
        font-size: 12px;
        font-weight: 600;
        color: var(--semi-green);
        border-bottom: 1px solid var(--semi-green)
    }

    #page-area{
        width: 50%;
        display: flex;
        justify-content: center;
        align-items: center;
        margin: auto;
    }

    #page-nation{
        list-style: none;
        display: inline-block;
        padding: 0;
        margin-top: 20px;
    }

    #page-nation li{
        display: inline;
        text-align: center;
        margin:0 10px;
    }

/* ????????? ??????~ */
    #page-nation li a{
        text-decoration: none;
        color: #999999;
        font-size: 15px;
        font-family: var(--sans);
    }

    #page-nation .first:hover,  #page-nation .last:hover,  #page-nation .right:hover,  #page-nation .left:hover{
        color:var(--semi-green)
    }


    #page-nation a:active{
        cursor: default;
        color: white;
    }

    #page-nation .num{
        padding: 0;
        width: 30px;
        height: 30px;
        display: inline-block;
        border-radius: 100%;
        line-height: 30px;
    }

    #page-nation .num:hover{
        background-color: var(--semi-green);
        color: white;
    }

    #page-nation .num:active{
        background-color: var(--semi-green);
        cursor: pointer;
    }


/* ??? ???????????? ?????? */

    #write{
        display: flex;
        flex-direction:row-reverse;
    }

    input[type=button]{
        width: 70px;
        height: 24px;
        margin-top: 10px;
        border: 0.75px solid var(--semi-green);
        border-radius: 100px;
        background-color:white;
        color:var(--semi-green);
    }

    :root{
        --color-main: #fdb930;
        --color-1green: #46a15e;
        --color-2green: #9cb43a;
        --color-3green: #008676;
    }

/* ???????????? qna ?????? */
    input[type="radio"] {display:none;}
    input[type="radio"] :checked + label {display: inline-block;padding: 20px;background: var(--color-main); color: var(--color-2green); font-size: 15px; cursor: pointer;}

    .conbox {width: 500px; height: 600px; background: var(--color-3green); margin: 0 auto; display: none;}
    input[id="tab01"]:checked ~ .con1 {display: block;}
    input[id="tab02"]:checked ~ .con2 {display: block;}

</style>
</head>
<body>

    <div id="list-main">
       <div id="list-area">
            <div class="tab_content" id="commu-title">
                <input type="radio" name="tabmenu" id="tab01">
                <label for="tab01">????????????</label>
                <input type="radio" name="tabmenu" id="tab02">
                <label for="tab02">QnA</label>

                <div class="conbox con1">????????????</div>
                <div class="conbox con2">QnA</div>
                <!-- <div><button id="notice">????????????</button><button id="qna">QnA</button></div> -->
            </div>
            <div id="cate-btn">
                <div id="btn-group">
                    <input type="button" name="category" value="??????">
                    <input type="button" name="category" value="??????">
                    <input type="button" name="category" value="TIP">
                    <input type="button" name="category" value="??????">
                </div>
                
            </div>
            <div id="cate-list">
               <div class="first">??????</div>
               <div class="first">??????</div>
               <div class="first">?????????</div>
               <div class="first">??????</div>
               <div class="first">?????????</div>

               <div>1</div>
               <div>????????? ??????</div>
               <div>?????????</div>
               <div>2022/10/15</div>
               <div>12</div>

               <div>1</div>
               <div>????????? ??????</div>
               <div>?????????</div>
               <div>2022/10/15</div>
               <div>12</div>


               <div>1</div>
               <div>????????? ??????</div>
               <div>?????????</div>
               <div>2022/10/15</div>
               <div>12</div>


               <div>1</div>
               <div>????????? ??????</div>
               <div>?????????</div>
               <div>2022/10/15</div>
               <div>12</div>


               <div>1</div>
               <div>????????? ??????</div>
               <div>?????????</div>
               <div>2022/10/15</div>
               <div>12</div>


               <div>1</div>
               <div>????????? ??????</div>
               <div>?????????</div>
               <div>2022/10/15</div>
               <div>12</div>


               <div>1</div>
               <div>????????? ??????</div>
               <div>?????????</div>
               <div>2022/10/15</div>
               <div>12</div>

               <div>1</div>
               <div>????????? ??????</div>
               <div>?????????</div>
               <div>2022/10/15</div>
               <div>12</div>


               <div>1</div>
               <div>????????? ??????</div>
               <div>?????????</div>
               <div>2022/10/15</div>
               <div>12</div>


               <div>1</div>
               <div>????????? ??????</div>
               <div>?????????</div>
               <div>2022/10/15</div>
               <div>12</div>
               
            </div>

            <div id="write">
                <input type="button" value="????????????" onclick="location.href='/dobby/commu/write';">
            </div>

            <div id="page-area">
                   <ul id="page-nation">
                    <li><a href="#" class="first"><<</a></li>
                    <li><a href="#" class="arrow left"><</a></li>
                    <li><a href="#" class="num">1</a></li>
                    <li><a href="/" class="num">2</a></li>
                    <li><a href="/" class="num">3</a></li>
                    <li><a href="/" class="num">4</a></li>
                    <li><a href="/" class="num">5</a></li>
                    <li><a href="/" class="arrow right">></a></li>
                    <li><a href="/" class="last">>></a></li>
                   </ul>
           </div>
       </div>
    </div>
    
</body>
</html>