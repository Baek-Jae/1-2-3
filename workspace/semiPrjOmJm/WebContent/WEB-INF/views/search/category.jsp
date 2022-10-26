<%@page import="java.util.ArrayList"%>
<%@page import="cate.vo.CateVo"%>
<%@page import="place.vo.PlaceVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
  List<PlaceVo> placeList = (ArrayList<PlaceVo>)request.getAttribute("placeList");
  List<CateVo> cateVo = (ArrayList<CateVo>)request.getAttribute("cateVo");
  
  List<CateVo> keyword = (ArrayList<CateVo>)request.getAttribute("keyword");
  
  String search = (String)request.getAttribute("search");
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="<%= root %>/css/searchCate.css" />
</head>
<body>
	<div id="ca-search">
		<form action="" class="main-search" name="form1">
			<div class="main-search-group">
				<span class="material-symbols-outlined">search</span> <input
					type="text" id="my_name" name="search" placeholder="모임을 찾아보세요"
					value="<% if(search != null){ %> <%= search %>
                    <% }else{ %>  <input type="text" id="my_name" name="search" placeholder="모임을 찾아보세요">
                    	<%}%>"/>
			</div>
			<input type="submit" value="검  색" onclick="recordSearch()" />
		</form>

		<select name="place" class="ca-option" id="select-pl" onchange="javascript:myListener(this)">
			<option value="">==지역 선택==</option>
			<% for(int i = 0; i < placeList.size(); ++i){%>
			<option id="place-name" value="<%= placeList.get(i).getpNo() %>"><%= placeList.get(i).getpName() %></option>
			<%  } %>
			<!-- <input type="button" value="변  경"> -->
		</select>
	</div>
	<div id="container">

		<div id="box">
			<input type="checkbox" class="" id="collapsible" name="cs_biz_form">
			<label for="collapsible"> <img
				src="<%= root %>/resources/예술.jpg" alt="카테고리" width="50%" height="20%">문화/예술
			</label>
			<ul class="menuitems">
				<% for(int i = 0; i < cateVo.size(); ++i){
					String cate = cateVo.get(i).getCaName();
          				if("문화/예술".equals(cate)){ %>
				<li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
				<%}}%>
			</ul>
		</div>

		<div id="box">
			<input type="checkbox" class="" id="collapsible2" name="cs_biz_form">
			<label for="collapsible2"> 
				<img src="<%= root %>/resources/여행3.jpg" alt="카테고리" width="100%"
				height="50%">아웃도어/여행
			</label>
			<ul class="menuitems">
				<% for(int i = 0; i < cateVo.size(); ++i){
          				if("아웃도어/여행".equals(cateVo.get(i).getCaName())){ %>
				<li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
				<%}}%>
			</ul>
		</div>
		<div id="box">
			<input type="checkbox" class="" id="collapsible3" name="cs_biz_form">
			<label for="collapsible3"> <img
				src="<%= root %>/resources/운동2.png" alt="카테고리" width="80%"
				height="50%">운동/스포츠
			</label>
			<ul class="menuitems">
				<% for(int i = 0; i < cateVo.size(); ++i){
          				if("운동/스포츠".equals(cateVo.get(i).getCaName())){ %>
				<li><%=cateVo.get(i).getDeName() %></li>
				<%}}%>
			</ul>
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

	<div id="container2" style="display: none;">
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

	<div id="group-place"> </div>
	<div id="group-list">의 모임 리스트</div>
	
	<div class="group-list">
		<div class="group-card">
			<div class="group-tag">
				<i class="fa-sharp fa-solid fa-tag"></i>
				<label>서울시 베스트</label>
			</div>
			<div class="group-wrap">
				<div class="card-top">
					<img src="<%=root%>/resources/testImg.png" alt="그룹사진" />
				</div>
				<div class="card-bottom">
					<span>모임명</span> <span>아자자</span> <span>그룹장</span> <span>아자자</span>
					<div>
						<span class="material-symbols-outlined" id="location-icon">location_on</span>
						<span> 강남구</span>
					</div>
					<div>
						<span class="material-symbols-outlined" id="group-icon">group</span>
						<span>9/10</span>
					</div>
					<a href="">들어가기 <i class="fa-solid fa-angles-right fa-beat-fade"></i></a>
				</div>
			</div>
		</div>
			<div class="group-card">
	                	<div class="group-tag">
	                		<i class="fa-sharp fa-solid fa-tag"></i>
	                		<label>서울시 베스트</label>
	                	</div>
	            		<div class="group-wrap">    
		                    <div class="card-top">
		                        <img src="<%= root %>/resources/testImg.png" alt="그룹사진" />
		                    </div>
		                    <div class="card-bottom">
		                        <span class="group-name">모임명</span>
		                        <span class="group-ca">아자자</span>
		                        <span class="group-pl">그룹장</span>
		                        <span class="group-cnt">아자자</span>
		                        <div>
		                            <span class="material-symbols-outlined" id="location-icon">location_on</span>
		                            <span> 강남구</span>
		                        </div>
		                        <div>
		                            <span class="material-symbols-outlined" id="group-icon">group</span>
		                            <span>9/10</span>
		                        </div>
		                        <a href="">들어가기 <i class="fa-solid fa-angles-right fa-beat-fade"></i></a>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="group-card">
	                	<div class="group-tag">
	                		<span class="material-symbols-outlined">sell</span>
	                		<label>서울시 베스트</label>
	                	</div>
	            		<div class="group-wrap">    
		                    <div class="card-top">
		                        <img src="<%= root %>/resources/testImg.png" alt="그룹사진" />
		                    </div>
		                    <div class="card-bottom">
		                        <span>모임명</span>
		                        <span>아자자</span>
		                        <span>그룹장</span>
		                        <span>아자자</span>
		                        <div>
		                            <span class="material-symbols-outlined" id="location-icon">location_on</span>
		                            <span> 강남구</span>
		                        </div>
		                        <div id="group-info">
		                            <span class="material-symbols-outlined" id="group-icon">group</span>
		                            <span>9/10</span>
		                        </div>
		                        <a href="">들어가기 <i class="fa-solid fa-angles-right fa-beat-fade"></i></a>
	                    	</div>
	                    </div>
	                </div>
	            </div>
            </div>
		<%-- <table border="1" id="recomm">
		<tr id="tr1">
			<td id="td1" rowspan="4"><img src="<%= root %>/resources/기타.jpg"
				width="100%" height="100%"></td>
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
	</table> --%>


<script type="text/javascript">

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
	
	$('#select-pl').change(function(){
		var temp = $('#select-pl option:checked');
		 /* console.log(temp.text());  */
		  $('#group-place').text($(temp).text());
	});
 <%-- function myListener(obj) {        
	alert(obj.value); 
 	
	$.ajax({
	
	url : "<%= root %>/search",
	method : "GET",		
	data : 
		{
		"msg" : obj.value
		},
	success : function(){		
   		alert($('#place-name').val());
		$('#group-place').text();
	}		 
});
	} --%>
	

	$(document).ready(function() {
 $('input[type="checkbox"][name="cs_biz_form"]').click(function(){
  if($(this).prop('checked')){
     $('input[type="checkbox"][name="cs_biz_form"]').prop('checked',false);
     $(this).prop('checked',true);
    }
   });
 });
	
	function recordSearch(){
			  if(form1.search.length==0){
			   alert("검색어를 넣어주세요");
			   form1.search.focus();
			   return;
			  }
	 }
	searchcate = function(num2){
	 /* function searchcate(num2){ */
		  console.log(num2);
		$.ajax({
			url : "<%=root%>/desearch",
			method : "GET",	
			data :	{
				num : num2
			},
			success : function(x){
				var o = JSON.parse(x);

				for(var i=0 in o){    
					alert(o[i].name);}       
				 $('.group-cnt').text(o[i].userCnt); 
				 $('.group-ca').text(o[i].name); 
				
			},
			error : function(){
				alert("통신 에러!");
			}
		});
	} 
	
	
	<%--
	function getData() {
		$.ajax({
			url : "<%= root %>/search",
			method : "GET",		
			data : 
				v1: $("#v1").val(),
				v2: $("#v2").val()
			},
			dataType:"text",  //응답타입
			success: function (data) {
				
				o = JSON.parse(x);
				console.log(o);
				
				var name = data.username;
				var place = data.age;
				var category = data.age;
				var cnt = data.age;
				
				$(".group-name").text(name);
				$(".group-ca").text(place);
				$(".group-pl").text(category);
				$(".group-cnt").text(cnt);
			},
			error: function (xhr) {
				alert("통신 에러~!");
				console.log(xhr);
				/* $("#result").append(error);
				$("#result").append(status); */
			}
		});
	}   --%>
/* if()input 값이 있으면 가져와
 */
 /* function test01(){
	var doc = $("input:text").val();
	alert(doc);
} */

/* $(document).ready(function(){
    $("#my_name").change(function(){
        alert($(this).text())
        var pl = $(this).val()
        if(pl == null){
            $("#my_name").val(pl) 
        }                
    })
}) */
/* $('input[type=text]').attr('value',"test");*/
 
 /* function printName()  {
	  const name = document.getElementById('my_name').value;
	  document.getElementById("my_name").value = name;
	} */
    </script>
</body>
</html>