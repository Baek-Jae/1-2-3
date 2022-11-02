<%@page import="com.kh.semi.member.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/admin/memberheader.jsp" %>
    <% 
    	List<MemberVo> ListVo = (List<MemberVo>)request.getAttribute("ListVo"); 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./member1.css">
 <style>
/*     html, body{ */
/*         padding: 0; */
/*         margin: 0; */
/*     } */
/*     div{ */
/*         box-sizing: bor; */
/*     } */

/*     /*헤더 부분*/ */
    
/*     #head{ */
/*         border: 1px solid blue; */
/*         width: 1920px; */
/*         height: 100px; */
        
/*     } */
/*     #content{ */
/*         border: 1px solid red; */
        
/*         width: 1920px; */
/*         height: 780px; */
/*     } */
/*     #bot{ */
/*         width: 1920px; */
/*         height: 200px; */
/*         border: 1px solid green; */
/*     } */

/*     #menuTop{ */
/*         width: 100vw; */
/*         height: 50%; */
/*         background-color: white; */
/*         color: black; */
/*         font-size: 1.5rem; */
/*         display: grid; */
/*         grid-template-columns: repeat(4,1fr); */
/*         position: relative; left: 250px; */
/*     } */

/*     #modify1{ */
/*         position: absolute; */
/*         width: 100px; */
/*         height: 30px; */
/*         left: 1700px; */
/*         top: 200px; */
/*         border: 2px solid yellow; */
/*         border-radius: 30%; */
/*         text-align: center; */
/*         background-color: yellow; */

/*     } */
/*     #modify2{ */
/*         position: absolute; */
/*         width: 100px; */
/*         height: 30px; */
/*         left: 1700px; */
/*         top: 240px; */
/*         border: 2px solid yellow; */
/*         border-radius: 30%; */
/*         text-align: center; */
/*         background-color: yellow; */
/*     } */
   
/*     #membersyo{ */
/*         position: absolute; */
/*         width: 200px; */
/*         height: 300px; */
/*         left: 200px; */
/*         top: 200px; */
/*         border: 1px solid black; */
/*         border-radius: 20%; */
/*         text-align: center; */
/*         background-color: whitesmoke; */
/*     } */
    
/*     .box{ */
/*             position: absolute; */
/*             left: 320px; */
/*             top: 0px; */
/*             width: 200px; */
/*             height: 300px; */
/*             border: 1px solid black; */
/*             box-sizing: border-box; */
/*             border-radius: 20%; */
/*             text-align: center; */
/*             background-color: whitesmoke; */
/*         } */


    </style>
</head>
<body>
<br><br><br><br><br><br><br><br><br><br><br>
  <div id="main">
        <div id="head"></div>
        <div id="header">
            <div id="menuTop">
                <div><a> 등급관리</a></div>
                <div><a>회원관리</a> </div>
                <div><a>게시글관리</a> </div>
                <div> <a>문의관리</a> </div>
            </div>
        </div>
        <div id="content">
            
            <div id="membersyo"> 
           
            <button onclick="printOrder();">회원정보 저장</button>
            <br>
            <div id="result" class="box">
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
               <%for(int i =0; i <ListVo.size(); ++i){ %>
            회원이름: <input type="text" id="in1" placeholder="회원이름 " value="<%= ListVo.get(i).getNick() %>">
             <% } %>
            <br><br>
            <br><br>
            회원온도:<input type="text" id="in3" placeholder= "회원온도 를 입력하세요">
            <br><br><br><br>
           
            </div>
        
<!--             <script> -->
<!-- //                 function printOrder(){ -->
<!-- //                 x1=document.querySelector('#in1'); -->
<!-- //                 x2=document.querySelector('#in2'); -->
<!-- //                 x3=document.querySelector('#in3'); -->
            
<!-- //                 console.log(x1.value); -->
<!-- //                 console.log(x2.value); -->
<!-- //                 console.log(x3.value); -->
        
<!-- //                 resultDiv = document.querySelector('#result'); -->
<!-- //                 console.log(resultDiv); -->
                
<!--             </script> -->

            </div>

        

        <div id="modify1"><a>순차적용</a></div>
        
        <div id ="modify2"><a>직접입력</a></div>
        
            
        
        </div>
        <div id="bot"></div>
    </div>
		

</body>
</html>