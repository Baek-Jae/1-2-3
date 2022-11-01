<%@page import="kh.semi.omjm.group.vo.GroupVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cate.vo.CateVo"%>
<%@page import="place.vo.PlaceVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%
  List<PlaceVo> placeList = (ArrayList<PlaceVo>)request.getAttribute("placeList");
  List<CateVo> cateVo = (ArrayList<CateVo>)request.getAttribute("cateVo");
  
/*   List<GroupVo> keyword = (ArrayList<GroupVo>)request.getAttribute("keyword");
 */  
  String search = (String)request.getAttribute("search");
  String search2 = (String)request.getAttribute("search2");
  String jjap = (String)request.getAttribute("jjap");
  List<GroupVo> groupName = (ArrayList<GroupVo>)request.getAttribute("groupName");
  List<GroupVo> groupName2 = (ArrayList<GroupVo>)request.getAttribute("groupName2");
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
<%
String[] placeArr = null;
String pla = null;
if (loginMember != null){
	placeArr = loginMember.getPlace().split(",");
	int arrlength = placeArr.length;
	int arrmath = (int)Math.floor(Math.random() * arrlength);
	pla =  placeArr[arrmath];	%>
	
<script>
	
		$.ajax({
		url :	"<%=root%>/main/membergroup" , 
        method : "GET",   
        data :   {
           "p1" :"<%=pla%>"
        },//data
        success : function(x){
           var o = JSON.parse(x);

           for(var i=0 in o){    
              alert(o[i].name);
               $('.group-cnt').eq(i).text(o[i].userCnt); 
               $('.group-na').eq(i).text(o[i].name); 
               $('.group-pl').eq(i).text(o[i].place); 
               $('.group-cate').eq(i).text(o[i].category);
           }//for
        },//success
        error : function(){
           alert("login-group 통신 에러!");
        }//error
     });//ajax
	
	//function
</script>
	<%}else{%>
	
	<script>
	/* window.onload = function(){ */
		$.ajax({
			url : "<%=root%>/main/group" , 
			method : "GET" ,
			//data :	
			success : function(x){
				o = JSON.parse(x);
				console.log(o);
				
				for(var i=0 in o){    
		              //alert(o[i].name);
					var random = Math.floor(Math.random()*o[i].length);
					 /* alert(random);  */
		               $('.group-cnt').eq(i).text(o[i].userCnt); 
		               $('.group-na').eq(i).text(o[i].name); 
		               $('.group-pl').eq(i).text(o[i].place); 
		               $('.group-cate').eq(i).text(o[i].category);
				}
			},error : function(){
				alert("logout-group 통신 에러!");
			}
		});
	
	</script>
<%}%>
	<%if(search != null){ 
		System.out.println(search);%>
	<script type="text/javascript">

	$(document).ready(function() {  
		/* alert("dd"); */
	
	 <%	for(int i = 0; i < groupName.size(); ++i) {%>
		 <%-- console.log('<%=groupName.get(0).getName()%>');
		 console.log($('.group-cate').eq(0)); --%>
 	 		
		$('.group-cate').eq(<%=i%>).text('<%= groupName.get(i).getCategory() %>');
		$('.group-na').eq(<%=i%>).text('<%= groupName.get(i).getName() %>'); 
		$('.group-pl').eq(<%=i%>).text('<%= groupName.get(i).getPlace() %>');
		$('.group-cnt').eq(<%=i%>).text('<%= groupName.get(i).getUserCnt() %>'); 
		<%}%>
	})
	</script>
	<%}else if(jjap != null){%> 
		<script type="text/javascript">
			alert("해당 모임이 존재하지 않습니다");
			$(document).ready(function() {  
			 <%	for(int i = 0; i < groupName.size(); ++i) {%>
		 console.log('<%=groupName.get(0).getName()%>');
		 console.log($('.group-cate').eq(0));
 	 		
		$('.group-cate').eq(<%=i%>).text('<%= groupName.get(i).getCategory() %>');
		$('.group-na').eq(<%=i%>).text('<%= groupName.get(i).getName() %>'); 
		$('.group-pl').eq(<%=i%>).text('<%= groupName.get(i).getPlace() %>');
		$('.group-cnt').eq(<%=i%>).text('<%= groupName.get(i).getUserCnt() %>'); 
		<% } %>
	})
	</script>
	<% } %> 
	
	<div id="ca-search">
		<form action="<%= root %>/search" class="main-search" method="post">
			<div class="main-search-group">
				<span class="material-symbols-outlined">search</span> 
				<input type="text" id="my_name" name="search2" placeholder="모임을 찾아보세요" 
				value="<% if(search != null){ %> <%= search %>
							<%}else if(search2 != null){ %> <%= search2 %>
			                       <%}%>"/>
         </div>
         <!-- <input type="submit" value="검  색" id="submit"> -->
         <button type="button" id="submit" onclick="return doAction();">변경</button> 
      </form>

		<select name="place" class="ca-option" id="select-pl">
			<option value="option1">==지역 선택==</option>
			<% for(int i = 0; i < placeList.size(); ++i){%>
			<option id="place-name" value="<%= placeList.get(i).getpNo() %>"><%= placeList.get(i).getpName() %></option>
			<%  } %>
			<!-- <input type="button" value="변  경"> -->
		</select>
	</div>
	<div id="container">
<div id="box">
		<input type="checkbox" class="" id="collapsible5" name="cs_biz_form">
			<label for="collapsible5"> 
			<img src="<%= root %>/resources/업종직무2.jpg" alt="카테고리" width="80%" height="70%"> 
			<div>업종/직무</div>
				</label>
			<ul class="menuitems">
				<% for(int i = 0; i < cateVo.size(); ++i){
          				if("업종/직무".equals(cateVo.get(i).getCaName())){ %>
				<li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
				<%}}%>
			</ul>
		</div>
		<div id="box">
		<input type="checkbox" class="" id="collapsible6" name="cs_biz_form">
			<label for="collapsible6"> 
			<img src="<%= root %>/resources/언어.jpg" alt="카테고리" width="80%" height="70%"> 
			<div>외국/언어</div>
				</label>
			<ul class="menuitems">
			<% for(int i = 0; i < cateVo.size(); ++i){
         				if("외국/언어".equals(cateVo.get(i).getCaName())){ %>
			<li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
			<%}}%>
			</ul>
		</div>
		<div id="box">
		<input type="checkbox" class="" id="collapsible7" name="cs_biz_form">
			<label for="collapsible7"> 
			<img src="<%= root %>/resources/음악악기2.jpg" alt="카테고리" width="80%" height="70%">
			<div>음악/악기</div> 
				</label>
			<ul class="menuitems">
			<% for(int i = 0; i < cateVo.size(); ++i){
         				if("음악/악기".equals(cateVo.get(i).getCaName())){ %>
			<li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
			<%}}%>
			</ul>
		</div>
		<div id="box">
		<input type="checkbox" class="" id="collapsible8" name="cs_biz_form">
			<label for="collapsible8"> 
			<img src="<%= root %>/resources/만들기.jpg" alt="카테고리" width="80%" height="70%"> 
			<div>공예/만들기</div>
				</label>
			<ul class="menuitems">
			<% for(int i = 0; i < cateVo.size(); ++i){
         				if("공예/만들기".equals(cateVo.get(i).getCaName())){ %>
			<li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
			<%}}%>
			</ul>
		</div>
		
		<div id="box">
			<input type="checkbox" class="" id="collapsible" name="cs_biz_form">
			<label for="collapsible"> 
			 <img src="<%= root %>/resources/예술1.png" alt="카테고리" width="80%" height="70%">
			 <div>문화/예술</div> 
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
				<img src="<%= root %>/resources/여행2.png" alt="카테고리" width="80%" height="70%"> 
				<div>아웃도어/여행</div>
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
			<label for="collapsible3"> 
				<img src="<%= root %>/resources/운동2.png" alt="카테고리" width="80%" height="70%"> 
				<div>운동/스포츠</div>
			</label>
			<ul class="menuitems">
				<% for(int i = 0; i < cateVo.size(); ++i){
          				if("운동/스포츠".equals(cateVo.get(i).getCaName())){ %>
				<li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
				<%}}%>
			</ul>
		</div>
		<div id="box">
		<input type="checkbox" class="" id="collapsible4" name="cs_biz_form">
			<label for="collapsible4"> 
			<img src="<%= root %>/resources/책2.png" alt="카테고리" width="80%" height="70%"> 
			<div>인문학/책/글</div>
				</label>
			<ul class="menuitems">
				<% for(int i = 0; i < cateVo.size(); ++i){
          				if("인문학/책/글".equals(cateVo.get(i).getCaName())){ %>
				<li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
				<%}}%>
			</ul>
		</div>
		

	</div>
	<div class="more">
		<div class="blind"></div>
	</div>

	<div id="container2" style="display: none;">
		<div id="box">
		<input type="checkbox" class="" id="collapsible9" name="cs_biz_form">
			<label for="collapsible9"> 
			<img src="<%= root %>/resources/환경봉사.jpg" alt="카테고리" width="80%" height="70%">
			<div>봉사활동</div>
				</label>
			<ul class="menuitems">
			<% for(int i = 0; i < cateVo.size(); ++i){
         				if("봉사활동".equals(cateVo.get(i).getCaName())){ %>
			<li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
			<%}}%>
			</ul>
		</div>
		<div id="box">
		<input type="checkbox" class="" id="collapsible10" name="cs_biz_form">
			<label for="collapsible10">
			<img src="<%= root %>/resources/사교.jpg" alt="카테고리" cwidth="80%" height="70%">
			<div>사교/인맥</div>
				</label>
			<ul class="menuitems">
			<% for(int i = 0; i < cateVo.size(); ++i){
         				if("사교/인맥".equals(cateVo.get(i).getCaName())){ %>
			<li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
			<%}}%>
			</ul>
		</div>
		<div id="box">
		<input type="checkbox" class="" id="collapsible11" name="cs_biz_form">
			<label for="collapsible11">
			<img src="<%= root %>/resources/차오토바이.jpg" alt="카테고리" width="80%" height="70%">
			<div>차/오토바이</div>
				</label>
			<ul class="menuitems">
			<% for(int i = 0; i < cateVo.size(); ++i){
         				if("차/오토바이".equals(cateVo.get(i).getCaName())){ %>
			<li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
			<%}}%>
			</ul>
		</div>
		<div id="box">
		<input type="checkbox" class="" id="collapsible12" name="cs_biz_form">
			<label for="collapsible12">
			<img src="<%= root %>/resources/야구관람3.png" alt="카테고리" width="80%" height="70%">
			<div>야구관람</div>
					</label>
			<ul class="menuitems">
			<% for(int i = 0; i < cateVo.size(); ++i){
         				if("야구관람".equals(cateVo.get(i).getCaName())){ %>
			<li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
			<%}}%>
			</ul>
		</div>
		<div id="box">
		<input type="checkbox" class="" id="collapsible13" name="cs_biz_form">
			<label for="collapsible13">
			<img src="<%= root %>/resources/게임오락.jpg" alt="카테고리" width="80%" height="70%">
			<div>게임/오락</div>
				</label>
			<ul class="menuitems">
			<% for(int i = 0; i < cateVo.size(); ++i){
         				if("게임/오락".equals(cateVo.get(i).getCaName())){ %>
			<li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
			<%}}%>
			</ul>
		</div>
		<div id="box">
		<input type="checkbox" class="" id="collapsible14" name="cs_biz_form">
			<label for="collapsible14">
			<img src="<%= root %>/resources/요리.jpg" alt="카테고리" width="80%" height="70%">
			<div>요리/레시피</div>
				</label>
			<ul class="menuitems">
			<% for(int i = 0; i < cateVo.size(); ++i){
         				if("요리/레시피".equals(cateVo.get(i).getCaName())){ %>
			<li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
			<%}}%>
			</ul>
		</div>
		<div id="box">
		<input type="checkbox" class="" id="collapsible15" name="cs_biz_form">
			<label for="collapsible15">
			<img src="<%= root %>/resources/반려동물2.jpg" alt="카테고리" width="80%" height="70%">
			<div>반려동물</div>
				</label>
			<ul class="menuitems">
			<% for(int i = 0; i < cateVo.size(); ++i){
         				if("반려동물".equals(cateVo.get(i).getCaName())){ %>
			<li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
			<%}}%>
			</ul>
		</div>
		<div id="box">
		<input type="checkbox" class="" id="collapsible16" name="cs_biz_form">
			<label for="collapsible16">
			<img src="<%= root %>/resources/기타.jpg" alt="카테고리" width="80%" height="70%">
			<div>자유주제</div>
				</label>
			<ul class="menuitems">
			<% for(int i = 0; i < cateVo.size(); ++i){
         				if("자유주제".equals(cateVo.get(i).getCaName())){ %>
			<li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
			<%}}%>
		</div>
	</div>

		<div id="group-place"></div>
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
						<span>모임명</span>
                        <span class="group-na">모임</span>
                        <span>카테고리</span>
                        <span class="group-cate"></span>
					<div>
						<span class="material-symbols-outlined" id="location-icon">location_on</span>
						<span class="group-pl"> </span>
					</div>
					<div>
						<span class="material-symbols-outlined" id="group-icon">group</span>
						<span class="group-cnt"></span>
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
		                        <span>모임명</span>
		                        <span class="group-na">모임1</span>
		                        <span>카테고리</span>
		                        <span class="group-cate"></span>
		                        <div>
		                            <span class="material-symbols-outlined" id="location-icon">location_on</span>
		                            <span class="group-pl"> </span>
		                        </div>
		                        <div>
		                            <span class="material-symbols-outlined" id="group-icon">group</span>
		                            <span class="group-cnt"></span>
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
		                        <span class="group-na">모임2</span>
		                        <span>카테고리</span>
		                        <span class="group-cate"></span>
		                        <div>
		                            <span class="material-symbols-outlined" id="location-icon">location_on</span>
		                            <span class="group-pl"></span>
		                        </div>
		                        <div id="group-info">
		                            <span class="material-symbols-outlined" id="group-icon">group</span>
		                            <span class="group-cnt"></span>
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
	var temp2 = $('#select-pl option:selected').val();
		/*  console.log(temp.val());    */
		 
	  if(temp != null){
		  /* $('#group-list').show(); */
		  $('#group-list').css('visibility', 'visible');
		  $('#group-place').text($(temp).text());
		  
				  // function searchcate(num2){ 
					$.ajax({
						url : "<%=root%>/plsearch",
						method : "GET",	
						data :	{
							"temp" : temp.val()
						},
						success : function(z){
							var sp = JSON.parse(z);
							for(var i=0 in sp){    
								/* alert(sp[i].name);   */    
								       /* console.log($('.group-cnt').eq(i)); */
								//for(var i = 0; i < sp.legnth; ++i){
							 		$('.group-cnt').eq(i).text(sp[i].userCnt); 
							 		$('.group-na').eq(i).text(sp[i].name); 
							 		$('.group-pl').eq(i).text(sp[i].place);  
							 		$('.group-cate').eq(i).text(sp[i].category); 
								}
						},
						error : function(){
							alert("통신 에러!");
						}
					});
				}
					/* else if(temp2 == 'option1'){
					 $('#group-place').hide();
					 $('#group-list').hide();
				} */
	  
});

	
	<%--
  function myListener(obj) {        
	alert(obj.value); }
	} --%>
	

	 $(document).ready(function() {
		  $('input[type="checkbox"][name="cs_biz_form"]').click(function(){
		   if($(this).prop('checked')){
		      $('input[type="checkbox"][name="cs_biz_form"]').prop('checked',false);
		      $(this).prop('checked',true);
		     }
		    });
		  });


	 searchcate = function(num2){
		    /* function searchcate(num2){ */
		      $.ajax({
		         url : "<%=root%>/desearch",
		         method : "GET",   
		         data :   {
		            dese : num2
		         },
		         success : function(x){
		            var o = JSON.parse(x);

		            for(var i=0 in o){    
		               //alert(o[i].name);
		                $('.group-cnt').eq(i).text(o[i].userCnt); 
		                $('.group-na').eq(i).text(o[i].name); 
		                $('.group-pl').eq(i).text(o[i].place); 
		                $('.group-cate').eq(i).text(o[i].category);
		            }       
		         },
		         error : function(){
		            alert("num2 통신 에러!");
		         }
		      });
		   } 


		   /*검색 페이지에서 모임명 검색*/
			/*  function nameSearch(){
				 alert("dd");
				 var form = $("form")[0];        
			     var formData = new FormData(form); */
			     
			 /*  $('.main-search').submit(function(event){  */
				/*  function nameSearch(event){
					 event.preventDefault();  */
			 
			  /* $(function(){ 
		        $('#submit').("click",function () { */
			    /*  var formData =  $("form").serialize();
			     console.log(formData); */
			//$('input[name=search2]').attr('value',"search2");
			  
			  
	 $('#submit').click(function(){
		 //alert($('input[name=search2]').val())
		<%--  alert("<%=search2%>");  --%>
		 	$.ajax({
				url : "<%=root%>/keywordsearch",
			     method : "GET",   
			     data :   {
			        "key" : $('input[name=search2]').val()
			     },
			     success : function(x){
			        var o = JSON.parse(x);
			        for(var i=0 in o){    
			        
			            $('.group-cnt').eq(i).text(o[i].userCnt); 
			            $('.group-na').eq(i).text(o[i].name); 
			            $('.group-pl').eq(i).text(o[i].place); 
			            $('.group-cate').eq(i).text(o[i].category);
			        }       
			     },
			     error : function(){
			        alert("keyword 통신 에러!");
			     }
});  
	})
	
	function doAction(form){
 		if(form.search.value == ''){
 			  /* alert("검색어를 입력하세요~");   */
 			  alertify
		 		.alert("검색어를 입력해 주세요~");  
 			form.search.focus();
 			return false;
 		}
 		
 		return true;
 	}
	
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


 /* function printName()  {
	  const name = document.getElementById('my_name').value;
	  document.getElementById("my_name").value = name;
	} */
    </script>
</body>
</html>