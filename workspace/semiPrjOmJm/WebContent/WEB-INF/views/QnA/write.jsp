<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   .outer{
      background: black;
      color: white;
      width: 60%;
      height: 550px;
      margin: auto;
      padding-top: 150px;
   }

   #enroll-form table{border: 1px solid white; margin:auto;}
   #enroll-form input, #enroll-form textarea{
      width: 100%;
      box-sizing: border-box;
   }
</style>
</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   
   
   <div id="main">

      <div class="outer">
        <br>
        <h2 align="center">QnA 작성하기</h2>
        <br>

        <form id="enroll-form" action="/omjm/QnA/write" method="post" enctype="multipart/form-data">

            <!-- 카테고리, 제목, 내용, 첨부파일 한개 -->
            <table>
                <tr>
                    <th width="70px">카테고리</th>
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
                <input type="submit" value="작성하기">
                <input type="reset" value="취소하기">
            </div>

        </form>
        

    </div>

   </div>

</body>
</html>