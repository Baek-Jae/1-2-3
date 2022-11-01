<%@page import="java.util.List"%>
<%@page import="com.kh.semi.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="/WEB-INF/views/common/header.jsp" %>
        <%
  	    List<MemberVo> restMember = (List<MemberVo>)request.getAttribute("restMember");
        List<MemberVo> voListt = (List<MemberVo>)request.getAttribute("voListt");
        
	
%>
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
        	<div id="restmember2">
        	
        	<%for(int i =0; i <voListt.size(); ++i){ %>
        		제제 회원이름 :<input type="text" id="r1" placeholder="내가 수정해야하는곳 제제 회원:" value="<%=voListt.get(i).getNick() %>">
        		제제 시키기 : <button type="button" onclick="btn_click(this)" class = 'clickd'>제제</button>
        		<br>
        	
        	<%} %>
        	
        		</body>
        		
        		<script>
        			function btn1_click(obj){
        			const no = $(obj).index();
        			console.log(no);
        			$($('clickd')[no])
        			}
        		
        		</script>
               <script>
               
              function btn_click(obj){
            	  const no = $(obj).index();
                   $.ajax({
                       url: "/omjm/admin/rest" ,
                       method:"post",			
                       data:{
                    	   "jeje" : $($('#r1')[no]).val()
                    	   
   
                       } ,
                       success: function(data){
                           alert("회원 제제 완료");
                       } ,
                       error : function(){
                           alert("정보 인식이 안되었습니다.");
                       },
                       complete : function(){
                           alert("수정끝")
                           }
                       })
       		
       		};
              </script> 
        	</div>
        </div>
	


</html>