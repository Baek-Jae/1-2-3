<%@page import="com.kh.semi.qna.vo.TotalQnAVo"%>
<%@page import="com.kh.semi.reQnA.vo.ReQnAVo"%>
<%@page import="com.kh.semi.common.PageVo"%>
<%@page import="com.kh.semi.qna.vo.QnAVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	List<QnAVo> voList = (List<QnAVo>)request.getAttribute("voList");
	List<ReQnAVo> rvoList = (List<ReQnAVo>)request.getAttribute("rvoList");
	List<TotalQnAVo> trvoList = (List<TotalQnAVo>)request.getAttribute("trvoList");
	PageVo pv = (PageVo)request.getAttribute("pv");
%>
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
	        <%for(int i = 0; i < trvoList.size(); ++i){%>
        		<div class="item">
	                <div class="num"><%= trvoList.get(i).getNo() %></div>
	                <div class="title"><a href="<%= root %>/QnA/detail?no=<%= trvoList.get(i).getNo() %>"><%= trvoList.get(i).getTitle() %></a></div>
	                <div class="writer"><%= trvoList.get(i).getWriter() %></div>
	                <div class="date"><%= trvoList.get(i).getEnrollDate() %></div>
	                <div class="view"><%= trvoList.get(i).getHit() %></div>
	            </div>    
	            <% if(trvoList.get(i).getRno() != null){ %>
	             	<div class="item">
		                <div class="num">
		                <%if(trvoList.get(i).getBno() == trvoList.get(i).getRno()) {%>
		                	
		                <%}%>
		                </div>
		                <div class="title"><a href="<%= root %>/reQnA/detail?no=<%= trvoList.get(i).getRno() %>"><%= trvoList.get(i).getRetitle() %></a></div>
		                <div class="writer"><%= trvoList.get(i).getRewriter() %></div>
		                <div class="date"><%= trvoList.get(i).getReenrollDate() %></div>
		                <div class="view"><%= trvoList.get(i).getRehit() %></div>
		            </div>
	            <%}%>
			<%}%>            							
	            
	        </div>
            
            <div id="page-area">
	        
	        	<%if(pv.getStartPage() != 1){%>
	        		<a href="/omjm/QnA/list?qno=<%=pv.getStartPage()-1%>" class = "btn btn-primary">??????</a>
	        	<%}%>		
	
	        	<%for(int i = pv.getStartPage() ; i <= pv.getEndPage() ; ++i){%>
	        		<a href="/omjm/QnA/list?qno=<%=i%>" class="btn btn-primary btn-sm"><%=i%></a>		
	        	<%}%>
	        	
	        	<%if(pv.getEndPage() != pv.getMaxPage()){%>
		        	<a href="/omjm/QnA/list?qno=<%=pv.getEndPage()+1%>" class = "btn btn-primary">??????</a>
	        	<%}%>
	        	
	        </div>
	        
            <div id="write">
       			<input type="button" value="????????????" onclick="location.href='/omjm/QnA/write';">
            </div>
        </div>
    </div>
</body>
</html>