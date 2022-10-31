<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="/WEB-INF/views/admin/memberheader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="main">
        <div id="head"></div>
        <div id="header">
            <div id="menuTop">
                <div><a> 등급관리</a></div>
                <div><a>회원관리</a> </div>
                <div><a>게시글관리</a> </div>
                <div><a href="./memberstop.jsp">문의관리</a> </div>
            </div>
        </div>
        <div id="content">
        	<div id="restmember">
        		제제 회원이름 :<input type="text" id="r1" placeholder="내가 수정해야하는곳 제제 회원:">
        		제제 사유 : <input type="text" id="r2" placeholder="제제 회원 :" > 
        		제제 기간 : <input type="text" id="r3" placeholder="제제 기간 : ">
        		제제 시키기 : <input type="button" id="clickd">
               <script>
               $('#clickd').click(function(){
                   $.ajax({
                       url: "/WEB-INF/temp/temper" ,
                       method:"post",			
                       data:{
                           "SUP" : SUP = 'O'
                       } ,
                       dataType:'text',
                       success: function(data){
                           alert("온도가 상승했습니다.");
                       } ,
                       error : function(){
                           alert("정보 인식이 안되었습니다.");
                       },
                       complete : function(){
                           alert("수정끝")
                           }
                       })
       		
       		});
               </script>
        	</div>
        </div>
	

</body>
</html>