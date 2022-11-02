<%@page import="com.kh.semi.member.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%@ include file="/WEB-INF/views/admin/memberheader.jsp" %>
 <%
 	List<MemberVo> reviveMember = (List<MemberVo>)request.getAttribute("reviveMember");
 	List<MemberVo> supList = (List<MemberVo>)request.getAttribute("supList");
 %>
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



	
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= root %>/css/mainStyle.css" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
</head>
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
<br><br><br><br><br><br><br>
	<div id="main">
        <div id="head"></div>
        <div id="header">
            <div id="menuTop">
              
            </div>
        </div>
        <div id="content">
	<%for(int i =0; i <supList.size(); ++i){ %>
        	<div id="revive">
        		제제 회원 :<input type="text" class="userNick" placeholder=" 제제 회원:"  value="<%=supList.get(i).getNick() %>">
        		<input class="restNo" value="<%=supList.get(i).getNo() %>" style="visibility: hidden;">
        		제제 복구 : <button type="button" onclick="btn_click(this)" class = 'clickd'>복구</button>
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
                       url: "/omjm/admin/resup" ,
                       method:"post",			
                       data:{
                    	   "jeje2" : $($('.restNo')[no]).val(),
                    	  
   
                       } ,
                       success: function(data){
                           alert("회원 복구 완료"); 
                          
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