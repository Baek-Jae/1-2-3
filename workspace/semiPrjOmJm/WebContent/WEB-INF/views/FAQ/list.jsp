<%@page import="com.kh.semi.common.PageVo"%>
<%@page import="com.kh.semi.faq.vo.FaqVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	List<FaqVo> voList = (List<FaqVo>)request.getAttribute("voList");
%>    
<!DOCTYPE html>
<html>
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

    #page-area {
        text-align: center;
    }

    #write {
        text-align: end;
    }
</style>
</head>
<body>
    <div class="boardlistwrap">
        <div class="boardlist">
            <div class="boardlisthead">
                <div class="num">??????</div>
                <div class="title">??????</div>
                <div class="writer">?????????</div>
                <div class="date">?????????</div>
                <div class="view">??????</div>
            </div>
        
        	<div class="boardlistbody">
	        <%for(int i = 0; i < voList.size(); ++i){%>
        	<div class="item">
	                <div class="num"><%= voList.get(i).getNo() %></div>
	                <div class="title"><a href="<%= root %>/FAQ/detail?no=<%= voList.get(i).getNo() %>"><%= voList.get(i).getTitle() %></a></div>
	                <div class="writer"><%= voList.get(i).getWriter() %></div>
	                <div class="date"><%= voList.get(i).getEnrollDate() %></div>
	                <div class="view"><%= voList.get(i).getHit() %></div>
	                </div>
	        <%}%>
	        </div>
	        
	        <%if(loginMember != null && loginMember.getId().equals("admin")){ %>
	            <div id="write">
	       			<input type="button" value="????????????" onclick="location.href='/omjm/FAQ/write';">
	            </div>
            <%}%>
        </div>
    </div>
</body>
</html>