<%@page import="com.kh.semi.notice.vo.NoticeVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<% List<NoticeVo> voList = (List<NoticeVo>)request.getAttribute("voList"); %>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        :root{
        --color-main: #fdb930;
        --color-1green: #46a15e;
        --color-2green: #9cb43a;
        --color-3green: #008676;
        }

       body {
            margin: 0;
            padding: 0;
       }
    
       a{
            text-decoration: none;
            color: inherit;
       }
    
       .boardlistwrap {
            padding-top: 200px;
            padding-left: 230px;
            padding-right: 230px;
       }
    
       .boardlisthead,
       .boardlistbody .item {
            font-size: 0;
            padding: 10px 0;
       }
    
       .boardlisthead{
            border-top: 2px solid #fdb930;
            border-bottom: 1px solid #ccc;
       }
    
       .boardlistbody .item{
            border-bottom: 1px solid #ccc;
       }
    
       .boardlisthead > div ,
       .boardlistbody .item > div {
            display: inline-block;
            /* background: yellow; */
            text-align: center;
            font-size: 14px;
       }
    
       .boardlisthead > div {
            font-weight: 600;
       }
    
       .boardlist .num {
           width: 10%;
        }
    
        .boardlist .title {
           width: 55%;
        }
    
        .boardlistbody div.title {
           text-align: left;
        }
    
        .boardlistbody div.title a:hover {
           text-decoration: underline;
        }
    
        .boardlist .writer {
           width: 10%;
        }
    
        .boardlist .date {
            width: 15%;
        }
    
        .boardlist .view {
            width: 10%;
        }
    </style>
    </head>
    <body>
        <div class="boardlistwrap">
            <div class="boardlist">
                <div class="boardlisthead">
                    <div class="num">번호</div>
                    <div class="title">제목</div>
                    <div class="writer">글쓴이</div>
                    <div class="date">작성일</div>
                    <div class="view">조회</div>
                </div>
                <div class="boardlistbody">
                    <div class="item">
                        <div class="num">4</div>
                        <div class="title">제목을...</div>
                        <div class="writer">글쓴이를...</div>
                        <div class="date">2022-10-28</div>
                        <div class="view">111</div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    </html>


