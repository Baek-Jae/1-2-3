<%@page import="com.kh.semi.notice.vo.NoticeVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<% List<NoticeVo> voList = (List<NoticeVo>)request.getAttribute("voList"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<style>
    :root{
        --color-main: #fdb930;
        --color-1green: #46a15e;
        --color-2green: #9cb43a;
        --color-3green: #008676;
    }    
    
    body{
        padding: 0;
        margin: 0;
    }

    #list-main{
        width: 100vw;
        margin:auto;
        padding-top: 80px;
    }

    #commu-title{
        height: 100%;
        margin: auto;
        text-align: center;
        display: flex;
        justify-content: center;
        flex-direction: column;
        align-items: center;
    }
    
    #cate-list{
        width: 70%;
        height: 100%;
        margin: auto;
        display: grid;
        grid-template-columns: 1fr 5fr 2fr 3fr 1fr;
        grid-template-rows: repeat(11,40px);
        border-bottom:1px solid var(--semi-green);
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

    .main-slider-content {
    background-color: var(--color-main);
    margin-top: 80px;
    display: flex;
    gap: 10px;
    flex-direction: column;
    height: 45vh;
    width: 100vw;
    justify-content: center;
    align-items: center;
    }

    .main-slider-content h2 {
        font-weight: 400;
        font-size: 2em;
    }

    .main-slider-content h2:nth-child(4) {
        margin-bottom: 50px;
    }

    #notice-h {
        border: 1px solid red;
        display: flex;
    }

/* 공지사항 qna 버튼 */
    input[type="radio"] {display:none;}
    input[type="radio"] :checked + label {display: inline-block; padding: 20px; background: var(--color-main); color: var(--color-2green); font-size: 15px; cursor: pointer;}

    .conbox {width: 100%; background: var(--color-3green); margin: 0 auto; display: none;}
    input[id="tab01"]:checked ~ .con1 {display: block;}
    input[id="tab02"]:checked ~ .con2 {display: block;}

    
</style>
</head>
<body>
    <div class="main-slider">
        <div class="main-slider-content">
            <h1><strong>고객센터</strong></h1>
            <h3>질문 또는 상담을 원하시면 아래 대표 연락처로 연락 주시거나
                <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 고객센터를 통해 문의사항을 남겨주세요.
            </h3>
        </div>
    </div>

    <div id="list-main">
        <div class="tab_content" id="commu-title">
            <input type="radio" name="tabmenu" id="tab01">
            <input type="radio" name="tabmenu" id="tab02">
            <div id="notice-h">
                <div class="notice-btn">
                    <label for="tab01">공지사항</label>
                </div>
                <div class="qna-btn">
                    <label for="tab02">QnA</label>
                </div>
            </div>
            
            <div class="conbox con1">
                <div id="list-area">
                     <div id="cate-list">
                        <div class="first">번호</div>
                        <div class="first">제목</div>
                        <div class="first">작성자</div>
                        <div class="first">일시</div>
                        <div class="first">조회수</div>
         
  				          <% for(int i = 0; i < voList.size(); ++i){ %>
					          <div><%= voList.get(i).getNo() %></div>
					          <div><a href="/omjm/notice/detail?no=<%= voList.get(i).getNo() %>"><%= voList.get(i).getTitle() %></a></div>
					          <div><%= voList.get(i).getWriter() %></div>
					          <div><%= voList.get(i).getEnrollDate() %></div>
					          <div><%= voList.get(i).getHit() %></div>
				          <%}%>
                        
                        
                     </div>
         
                     <div id="write">
                         <input type="button" value="작성하기" onclick="location.href='/omjm/notice/write';">
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

            <div class="conbox con2">
                <div id="list-area">
                    <div id="cate-list">
                       <div class="first">번호</div>
                       <div class="first">제목</div>
                       <div class="first">작성자</div>
                       <div class="first">일시</div>
                       <div class="first">조회수</div>
        
                       <div>1</div>
                       <div>QnA 제목</div>
                       <div>하이염</div>
                       <div>2022/10/15</div>
                       <div>12</div>
        
                       <div>1</div>
                       <div>테스트 제목</div>
                       <div>하이염</div>
                       <div>2022/10/15</div>
                       <div>12</div>
        
        
                       <div>1</div>
                       <div>테스트 제목</div>
                       <div>하이염</div>
                       <div>2022/10/15</div>
                       <div>12</div>
        
        
                       <div>1</div>
                       <div>테스트 제목</div>
                       <div>하이염</div>
                       <div>2022/10/15</div>
                       <div>12</div>
        
        
                       <div>1</div>
                       <div>테스트 제목</div>
                       <div>하이염</div>
                       <div>2022/10/15</div>
                       <div>12</div>
        
        
                       <div>1</div>
                       <div>테스트 제목</div>
                       <div>하이염</div>
                       <div>2022/10/15</div>
                       <div>12</div>
        
        
                       <div>1</div>
                       <div>테스트 제목</div>
                       <div>하이염</div>
                       <div>2022/10/15</div>
                       <div>12</div>
        
                       <div>1</div>
                       <div>테스트 제목</div>
                       <div>하이염</div>
                       <div>2022/10/15</div>
                       <div>12</div>
        
        
                       <div>1</div>
                       <div>테스트 제목</div>
                       <div>하이염</div>
                       <div>2022/10/15</div>
                       <div>12</div>
        
        
                       <div>1</div>
                       <div>테스트 제목</div>
                       <div>하이염</div>
                       <div>2022/10/15</div>
                       <div>12</div>
                       
                    </div>
        
                    <div id="write">
                        <input type="button" value="작성하기" onclick="location.href='/omjm/notice/write';">
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
        </div>
    </div>        
</body>
</html>