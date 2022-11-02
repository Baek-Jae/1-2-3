<%@page import="java.util.List"%>
<%@page import="com.kh.semi.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ include file="/WEB-INF/views/admin/memberheader.jsp" %>
        <%
  	    List<MemberVo> restMember = (List<MemberVo>)request.getAttribute("restMember");
        List<MemberVo> voListt = (List<MemberVo>)request.getAttribute("voListt");
        
	
%>
<!DOCTYPE html>
<html>
<head>
<style>
	* {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Noto Sans KR', sans-serif;
    }
	#mannerCheck{

	}

</style>
<body>


	<div class="main-wrap">
		<div class="main-slider">
			<div class="main-slider-content">
				<h2>수 <strong>많은</strong> 사용자들과</h2>
				<h2><strong>관심사</strong>를 같이 공유하며 새로운 <strong>모임</strong>을</h2>
				<h2>다양하게 <strong>생성</strong>하고 <strong>가입</strong>하며</h2>
				<h2>일상의 <strong>달라짐</strong>을 경험해 보세요</h2>
				<span>오목조목 에서는 사용자의 지역과 관심사를 통해 여러분 들에게 최적의 모임을 보여줍니다.</span>
			</div>
		</div>
	</div>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= root %>/css/mainStyle.css" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
</head>
<body>
<br><br>
        <div id="head"></div>
        <div id="header">
            <div id="menuTop">
               
            </div>
        </div>
        <div id="content">
        	<%for(int i =0; i <voListt.size(); ++i){ %>
        	<div id="restmember2">
        		제제 회원이름 :<input type="text" class="userNick" placeholder="내 제제 회원:"  value="<%=voListt.get(i).getNick() %>">
        		<input class="restNo" value="<%=voListt.get(i).getNo() %>" style="visibility: hidden;">
        		제제 시키기 : <button type="button" onclick="btn_click(this)" class = 'clickd'>제제</button>
        		<br>
       		</div>
        	
        	<%} %>
        </div>
        		</body>
        		
        		<script>
        			function btn1_click(obj){
        			const no = $(obj).index(obj);
        			console.log(no);
        			$($('clickd')[no])
        			}
        		
        		</script>
               <script>
               
              function btn_click(obj){
            	  const no = $(obj).index(obj);
//             	  alert(no);
            	  console.log($($('.restNo')[no]).val());
                   $.ajax({
                       url: "/omjm/admin/rest" ,
                       method:"post",			
                       data:{
                    	   "jeje" : $($('.restNo')[no]).val(),
                    	  
   
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
        
	


</html>