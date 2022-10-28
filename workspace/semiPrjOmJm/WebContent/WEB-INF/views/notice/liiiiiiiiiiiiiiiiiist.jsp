<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   body {
        margin: 0;
        padding: 0;
   }

   a{
        text-decoration: none;
        color: inherit;
   }

   .boardlistwrap {
        padding: 50px;
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
        background: yellow;
        text-align: center;
        font-size: 14px;
   }

   .boardlisthead > div {
        font-weight: 600;
   }

   .boardlist .num {
       width: 10%;
    }

    .boardlist .tit {
       width: 55%;
    }

    .boardlistbody div.tit {
       text-align: left;
    }

    .boardlistbody div.tit a:hover {
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
                <div>번호</div>
                <div>제목</div>
                <div>글쓴이</div>
                <div>작성일</div>
                <div>조회</div>
            </div>
            <div class="boardlistbody">
                <div class="item">
                    <div>5</div>
                    <div>제목</div>
                    <div>글쓴이</div>
                    <div>작성일</div>
                    <div>조회</div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>