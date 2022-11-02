<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<% String alertMsg = (String)request.getAttribute("alertMsg"); %>
<%if(alertMsg != null){ %>
alert('<%=alertMsg%>');
<% } %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= root %>/css/mainStyle.css" />


</head>
<body>

<%
		String[] placeArr = null;
		String pla = null;
		if (loginMember != null){
		placeArr = loginMember.getPlace().split(",");
		int arrlength = placeArr.length;
		int arrmath = (int)Math.floor(Math.random() * arrlength);
		pla =  placeArr[arrmath];

/*System.out.println("placeArr length 배열길이 " + arrlength);
System.out.println("arrmath 랜덤 " + arrmath);
System.out.println("placeArr 인덱스번호" + pla); */
%>

<script>
		$.ajax({
		url :	"<%=root%>/main/membergroup" ,
		method : "GET",
		data :   {
		"p1" :"<%=pla%>"
		},//data
		success : function(x){
		var o = JSON.parse(x);

		
		let j = 0;
       for(let i = 0; i < o.length; i++&&j<3){
			//for(var i=0 in o){
			let div = $('<div/>');
			div.addClass("group-card");

			div.append('<div class="group-wrap">'
                    +'<div class="card-top">'
                   +'<img src="<%= root %>/resources/testImg.png" alt="그룹사진"/>'
               +'</div>'
               +'<div class="card-bottom">'
                  +'<span>모임명</span>'
                        +'<span class="group-na">'+o[i].name+'</span>'
                        +'<span>카테고리</span>'
                        +'<span class="group-cate">'+o[i].category+'</span>'
                        +'<div>'
                            +'<span class="material-symbols-outlined" id="location-icon">location_on</span>'
                            +'<span class="group-pl">'+o[i].place+'</span>'
                        +'</div>'
                        +'<div id="group-info">'
                            +'<span class="material-symbols-outlined" id="group-icon">group</span>'
                            +'<span class="group-cnt">'+o[i].userCnt+'</span>'
                   +'</div>'
                   +'<a href="/omjm/group/main?gno='+o[i].no+'">들어가기 <i class="fa-solid fa-angles-right fa-beat-fade"></i></a>'
           	+'</div>'
           +'</div>');

			$(div).appendTo('.group-list');
			j++;
		}
	},
	error : function(){
		alert("login-group 통신 에러!");
	}
});

</script>
<%}else{%>
<script>
		$.ajax({
		url : "<%=root%>/main/group" ,
		method : "GET" ,
		success : function(x){
		var o = JSON.parse(x);
		/* console.log(o); */

		
			let j = 0;
			for(let i = 0; i < o.length; i++ && j<3){
				//for(var i=0 in o){
				let div = $('<div/>');
				div.addClass("group-card");
				
				div.append('<div class="group-wrap">'
	                    +'<div class="card-top">'
                        +'<img src="<%= root %>/resources/testImg.png" alt="그룹사진"/>'
                    +'</div>'
                    +'<div class="card-bottom">'
                       +'<span>모임명</span>'
	                        +'<span class="group-na">'+o[i].name+'</span>'
	                        +'<span>카테고리</span>'
	                        +'<span class="group-cate">'+o[i].category+'</span>'
	                        +'<div>'
	                            +'<span class="material-symbols-outlined" id="location-icon">location_on</span>'
	                            +'<span class="group-pl">'+o[i].place+'</span>'
	                        +'</div>'
	                        +'<div id="group-info">'
	                            +'<span class="material-symbols-outlined" id="group-icon">group</span>'
	                            +'<span class="group-cnt">'+o[i].userCnt+'</span>'
                        +'</div>'
                        +'<a href="/omjm/group/main?gno='+o[i].no+'">들어가기 <i class="fa-solid fa-angles-right fa-beat-fade"></i></a>'
                	+'</div>'
                +'</div>');

				$(div).appendTo('.group-list');
				j++;
			}
		},
		error : function(){
			alert("logout-group 통신 에러!");
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
        <form action="<%= root %>/search" class="main-search" method="get" onsubmit="return doAction(this);">
            <div class="main-search-group">
            	<span class="material-symbols-outlined">search</span>
                <input type="text" name="search" id="text-search" placeholder="모임을 찾아보세요" />
            </div>
            <input type="submit" value="검  색" />
        </form>

        <div class="group-list"></div>

    </div>
    <br><br><br><br><br><br><br>

<script>
    	 function doAction(form){
    		if(form.search.value == ''){
    			    alert("검색어를 입력하세요~");  
    			 /*  alertify
		 		.alert("검색어를 입력해 주세요~"); */
    			form.search.focus();
    			return false;
    		}

			const str = form.search.value;
			const trimStr = str.replaceAll(' ','');

    		return true;
    	}
    	 
</script>
</body>
</html>