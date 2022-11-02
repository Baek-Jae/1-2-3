<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/common/header.jsp" %>
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
    
    body{
        padding: 0;
        margin: 0;
    }

	#main {
		padding-top: 100px;
	}

    #list-main{
        width: 100vw;
        margin:auto;
        padding-top: 80px;
    }

	.outer{
	   background: #fdb930;
	   color: black;
	   width: 60%;
	   height: 550px;
	   margin: auto;
	   padding-top: 50px;
	}
 
	#enroll-form table{border: 1px solid white; margin:auto;}
	#enroll-form input, #enroll-form textarea{
	   width: 100%;
	   box-sizing: border-box;
	}
 
</style>
</head>
<body>
	
	<div id="main">

		<div class="outer">
		  <br>
		  <h2 align="center">QnA 작성하기</h2>
		  <br>
  
		  <form id="enroll-form" action="" method="post" enctype="multipart/form-data">
  
			  <!-- 제목, 내용, 첨부파일 한개 -->
			  <table>
				  <tr>
					  <th width="70px"></th>
					  <td width="500px">

					  </td>
				  </tr>
				  <tr>
					  <th>제목</th>
					  <td><input type="text" name="title" required></td>
				  </tr>
				  <tr>
					  <th>내용</th>
					  <td><textarea name="content" rows="10" style="resize:none;" required></textarea></td>
				  </tr>
				  <tr>
					  <th>첨부파일</th>
					  <td><input type="file" name="f"></td>
				  </tr>
			  </table>
  
			  <div align="center">
				  <button type="submit">작성하기</button>
				  <button type="reset">취소하기</button>
			  </div>
  
		  </form>
		  
  
	  </div>
  
	 </div>
  
</body>
</html>