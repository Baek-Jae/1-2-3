<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<% String alertMsg = (String)request.getAttribute("alertMsg"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= root %>/css/mainStyle.css" />

<!-- JavaScript -->
<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
<!-- Default theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>
<!-- Semantic UI theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/semantic.min.css"/>
<!-- Bootstrap theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/bootstrap.min.css"/>

</head>
<body>

<%
String[] placeArr = null;
if (loginMember != null){
	placeArr = loginMember.getPlace().split(",");
/* 	System.out.println("placeArr " + placeArr.length);
 */	String p1 = null;
	switch(placeArr.length){
	case 1 : 
		p1 = placeArr[0];
		System.out.println(p1);
		 break;
	case 2 :
		String p2 = placeArr[0];
		String p3 = placeArr[1];
		System.out.println(p2);
		 break;
	case 3 : 
		String p4 = placeArr[0];
		String p5 = placeArr[1];  
		String p6 = placeArr[2];  
		System.out.println(p4);
		System.out.println(p5);
		System.out.println(p6);
		/* f01(); */
		break;}%>
		<script>
	/* window.onload = function(){ */
		$.ajax({
		url :	"<%=root%>/main/membergroup" , 
        method : "GET",   
        data :   {
           "p1" : "<%=p1%>"
          /*  "p2" : p2
           "p3" : p3
           "p4" : p4
           "p5" : p5
           "p6" : p6 */
        },//data
        success : function(x){
           var o = JSON.parse(x);

           for(var i=0 in o){    
              //alert(o[i].name);
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
					/* alert(random); */
		               $('.group-cnt').eq(i).text(o[i].userCnt); 
		               $('.group-na').eq(i).text(o[i].name); 
		               $('.group-pl').eq(i).text(o[i].place); 
		               $('.group-cate').eq(i).text(o[i].category);
			}
			},error : function(){
				alert("통신 에러!");
			}
		});
	
	</script>
<%}%>
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
            <div></div>
            <form action="<%= root %>/search" class="main-search" method="post" onsubmit="return doAction(this);">
                <div class="main-search-group">
                	<span class="material-symbols-outlined">search</span>
                    <input type="text" name="search" id="text-search" placeholder="모임을 찾아보세요" />
                </div>
                <input type="submit" value="검  색" />
            </form>
           	 
            <div class="group-list">
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
		                        <span class="group-na">내향인들의 "심야책방"</span>
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
		                        <span class="group-na">내향인들의 "심야책방"</span>
		                        <span>카테고리</span>
		                        <span class="group-cate"></span>
		                        <div>
		                            <span class="material-symbols-outlined" id="location-icon">location_on</span>
		                            <span class="group-pl"> </span>
		                        </div>
		                        <div id="group-info">
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
		                        <span class="group-na">내향인들의 "심야책방"</span>
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
        <br><br><br><br><br><br><br><br><br><br><br><br><br>
        <script type="text/javascript">
       
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
        </script>
</body>
</html>