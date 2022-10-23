<%@page import="cate.vo.CateVo"%>
<%@page import="place.vo.PlaceVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<%
  List<PlaceVo> placeList = (ArrayList<PlaceVo>)request.getAttribute("placeList");
  List<CateVo> cateVo = (ArrayList<CateVo>)request.getAttribute("cateVo");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="<%= root %>/css/searchCate.css" />
</head>
<body>
	<div id="ca-search">
		<!-- <form action="" id="ca-title"> -->
        <form action="" class="main-search">
   	            <div class="main-search-group">
                	<span class="material-symbols-outlined">search</span>
                    <input type="text" name="search" placeholder="모임을 찾아보세요" />
                </div>
         <input type="submit" value="검  색" />
        </form>
		<!-- <div class="ca-place"></div> -->
		<select name="place" class="ca-option" onchange="javascript:myListener(this)">
               <!-- 지역 테이블로부터 조회해오기 -->
                 <option value="">==지역 선택==</option>
               <% for(int i = 0; i < placeList.size(); ++i){%>
          			<option value="<%= placeList.get(i).getpNo() %>"><%= placeList.get(i).getpName() %></option>
               <%
              
               }%>
               
		<input type="button" value="변  경">
        </select> 
	</div>
	<div id="container">
		
		<div id="box">
			<input type="checkbox" class="" id="collapsible">
			<label for="collapsible">
			<img src="<%= root %>/resources/예술.jpg" alt="카테고리" width="50%" height="20%">문화/예술
			</label>
				<ul class="menuitems">
				 <% for(int i = 0; i < cateVo.size(); ++i){
					String cate = cateVo.get(i).getCaName();
          				if("문화/예술".equals(cate)){ %>
          			<li><%=cateVo.get(i).getDeName() %></li>
               <%}}%>
				</ul>
		</div>

		<div id="box">
			<input type="checkbox" class="" id="collapsible2">
			<label for="collapsible2">
			<img src="<%= root %>/resources/여행3.jpg" alt="카테고리" width="100%" height="50%">아웃도어/여행
			</label>
				<ul class="menuitems">
				 <% for(int i = 0; i < cateVo.size(); ++i){
          				if("아웃도어/여행".equals(cateVo.get(i).getCaName())){ %>
          			<li><%=cateVo.get(i).getDeName() %></li>
               <%}}%>
				</ul>
		</div>
		<div id="box">
			<img src="<%= root %>/resources/운동2.png" alt="카테고리" width="80%"
				height="50%">운동/스포츠
		</div>
		<div id="box">
			<img src="<%= root %>/resources/책.jpg" alt="카테고리" width="80%"
				height="50%">인문학/책/글
		</div>
		<div id="box">
			<img src="<%= root %>/resources/업종직무2.jpg" alt="카테고리" width="80%"
				height="50%">업종/직무
		</div>
		<div id="box">
			<img src="<%= root %>/resources/언어.jpg" alt="카테고리" width="80%"
				height="50%">외국/언어
		</div>
		<div id="box">
			<img src="<%= root %>/resources/음악악기2.jpg" alt="카테고리" width="80%"
				height="50%">음악/악기
		</div>
		<div id="box">
			<img src="<%= root %>/resources/만들기.jpg" alt="카테고리" width="80%"
				height="50%">공예/만들기
		</div>
		
	</div>
	<div class="more">
		<div class="blind"></div>
	</div>
	
	<div id="container2">
		<div id="box">
			<img src="<%= root %>/resources/환경봉사.jpg" alt="카테고리" width="80%"
				height="50%">봉사활동
		</div>
		<div id="box">
			<img src="<%= root %>/resources/사교.jpg" alt="카테고리" width="80%"
				height="50%">사교/인맥
		</div>
		<div id="box">
			<img src="<%= root %>/resources/차오토바이.jpg" alt="카테고리" width="80%"
				height="50%">차/오토바이
		</div>
		<div id="box">
			<img src="<%= root %>/resources/야구관람3.png" alt="카테고리" width="80%"
				height="50%">야구관람
		</div>
		<div id="box">
			<img src="<%= root %>/resources/게임오락.jpg" alt="카테고리" width="80%"
				height="50%">게임/오락
		</div>
		<div id="box">
			<img src="<%= root %>/resources/요리.jpg" alt="카테고리" width="80%"
				height="50%">요리/레시피
		</div>
		<div id="box">
			<img src="<%= root %>/resources/반려동물2.jpg" alt="카테고리" width="80%"
				height="50%">반려동물
		</div>
		<div id="box">
			<img src="<%= root %>/resources/기타.jpg" alt="카테고리" width="80%"
				height="50%">자유주제
		</div>
	</div>
	
    <div id="group-place">ㅇㅇㅇ</div> 
	<div id="group-list">의 모임 리스트</div>
       <table border="1" id="recomm">
            <tr id="tr1">
                <td id="td1" rowspan="4"><img src="<%= root %>/resources/기타.jpg" width="100%" height="100%"></td>
            </tr>
            <tr>
                <td>강남구</td>
            </tr>
            <tr>
                <td>강행시</td>
            </tr>
            <tr>
                <td>29명</td>
            </tr>
       </table>

	<script>
$(document).ready(function(){
  $('.more').click(function(){
    if($('.more').hasClass('more')){
       $('.more').addClass('close').removeClass('more');
       $('#container2').css('display', 'flex');
    }else if($('.close').hasClass('close')){
       $('.close').addClass('more').removeClass('close');  
       $('#container2').css('display', 'none');
    }
  });
});
/* $(document).ready(function(){
    $(".ca-option").change(function(){
        alert($(this).text())
        var pl = $(this).val()
        if(pl == null){
            $("#group-place").val(domain) 
        }                
    })
}) */



    </script>
</body>
</html>