<%@page import="com.kh.semi.member.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%@ include file="/WEB-INF/views/admin/memberheader.jsp" %>
    <% 
    	List<MemberVo> memberList = (List<MemberVo>)request.getAttribute("memberList"); 
    	List<MemberVo> memberTemp = (List<MemberVo>)request.getAttribute("memberTemp");
    	List<MemberVo> memberGender = (List<MemberVo>)request.getAttribute("memberGender");
    	List<MemberVo> supMemberList = (List<MemberVo>)request.getAttribute("supMemberList");
    	List<MemberVo> normalMember = (List<MemberVo>)request.getAttribute("normalMember");
    	
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
<br>
<div id="memberName">

  <div id="content">
        	<%for(int i =0; i < memberList.size(); ++i){ %>
        	<div id="restmember2">
        		전체 회원이름 ::<input type="text" class="userNick"value="<%=memberList.get(i).getNick() %>">
        		<br>
        		<%} %>
        		<hr>
        		<%for(int i =0; i < memberTemp.size(); ++i){ %>
        		전체 회원온도 :: <input type="text" class="userTemp"value="'<%=memberList.get(i).getNick() %>'의 온도 ::<%= memberTemp.get(i).getManner() %>">
        		<br> 
        		<%} %>
        		<hr>
        		<%for(int i =0; i < memberGender.size(); ++i){ %>
        		전체 회원성별 ::<input type="text" class="userGender" value="'<%=memberList.get(i).getNick() %>' 의 성별 ::<%=memberGender.get(i).getGender() %>">
        		<br>
        		<%} %>
        		<hr>
        		
        		<br>
        		<%for(int i =0; i <supMemberList.size(); ++i){ %>
        		 전체 회원중 제제 회원 ::<input type="text" class="userSup" value="<%=supMemberList.get(i).getNick() %>">
        		<br>
        		<%} %>
        		<hr>
        		
        		<%for(int i=0; i< normalMember.size();++i){%>
        		전체회원 중 정상회원::<input type="text" class="userNormal" value=" <%=normalMember.get(i).getNick() %>">
        		<br>
        		<%} %>
        		<br>
       		</div>
       		</div>
</div>

</body>
</html>