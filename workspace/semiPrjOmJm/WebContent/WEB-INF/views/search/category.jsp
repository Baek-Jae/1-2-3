<%@page import="place.vo.PlaceVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
  List<PlaceVo> placeList = (List<PlaceVo>)request.getAttribute("placeList");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<style>
#container, #container2 {
	display: flex;
	flex-wrap: wrap;
	flex-direction: row;
	margin-left: 10%;
	margin-right: 10%;
	width: 1920px;
}
#box {
	height: 500px;
	width: 20%;
}
#container>div {
	text-align: center;
}
/*#box>div{
	display : inline-block;
}*/
.more {
	display: block;
	margin-left: 50%;
	margin-bottom: 5%;
	width: 55px;
	height: 16px;
	background-image:
		url('https://s.pstatic.net/static/www/img/2017/sp_nav_v170523.png');
	background-position: 0 -78px;
}

.blind {
	position: absolute;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	margin: -1px;
	width: 1px;
	height: 1px;
}

.more:hover, .close:hover {
	cursor: pointer;
}

.close {
	display: block;
	margin-left: 50%;
	margin-bottom: 5%;
	background-image:
		url('https://s.pstatic.net/static/www/img/2017/sp_nav_v170523.png');
	width: 42px;
	height: 16px;
	background-position: -166px -78px;
}

#container2 {
	display : block;
	/*position: absolute;*/
	visibility: hidden;
}
#container2 > #box{
	display : inline-block;
	height: 500px;
    width: 20%;
}
}

 /* 이미지 체크박스 */
#box input[type=checkbox]{
    display: none;
}
#box input[type=checkbox]+label>img{
    font-weight: bold;
}
/* 메뉴 목록*/
#box .menuitems{
    display: none;
}
#box .menuitems{
    list-style: none;
}
#box .menuitems li{
    padding: 15px;
	margin-top: 5px;
	margin-left: 10px;
	float: left;
}
#box .menuitems li a{
    text-decoration: none;
}
/* 메뉴 펼침 - 체크박스 체크되면 메뉴목록 표시 */
#box input[type=checkbox]:checked~.menuitems{
    display: block;
}
/* #box:active {
  cursor:pointer;
  width: 30%;
  height: 30%;
} */
#box {
  transform: scale(1);
  transition: all 0.3s ease-in-out;   /* 부드러운 모션을 위해 추가*/
}
#box:active, #box:hover {
  transform: scale(1.2);
  cursor:pointer;
  font-size: 1.2em;
}
li:nth-child(2n) {
    background: #9CB43A;
    border-radius: 50px;
}
li:nth-child(odd){
    background: #46A15E;
    border-radius: 50px;
}
/* 모임부분 */
#group-list{
    display: grid;
    grid-column : span 5;
    text-align: center;
    margin-top: 20px;
    margin-bottom: 20px;
}
#td1{
    width: 200px;
    height: 200px;
}
table {
    width: 70%;
    height: 100px;
    margin-left: 20%;
    margin-right: 20%;
  }
 /*헤더*/
 #ca-search{
 	width: 100%;
    height: 15%;
 	display:grid;
 	grid-template-columns: 5fr 2fr 2fr;
 }
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<div id="ca-search">
		<div class="ca-title">카테고리 검색</div>
		<div class="ca-place"></div>
			<select name="place" class="ca-option" onchange="javascript:myListener(this)">
               <!-- 지역 테이블로부터 조회해오기 -->
                 <option value="">==지역 선택==</option>
               <% for(int i = 0; i < placeList.size(); ++i){%>
          			<option value="<%= placeList.get(i).getpNo() %>"><%= placeList.get(i).getpName() %></option>
               <%}%>
           </select> 
		<input type="button" value="변경">
	</div>
	<div id="container">
		
		<div id="box">
			<input type="checkbox" class="" id="collapsible">
			<label for="collapsible">
			<img src="/semi3/resources/img/결혼2.jpg" alt="결혼이미지" width="100%" height="50%">문화/예술
			</label>
			<ul id="menuitems" class="menuitems">
			
				<li><a href="#">
				<c:forEach items="${cateVo}" var="i" begin="1" end="126" step="1">
					<c:if test="${i.caName  eq '문화/예술'}">${i.deName}</c:if>			
				</c:forEach>	</a></li>
				<li><a href="#">디자인</a></li>
				<li><a href="#">캘리그라피/서예</a></li>
				<li><a href="#">사진</a></li>
				<li><a href="#">댄스/무용</a></li>
				<li><a href="#">영화</a></li>
			</ul>
		</div>

		<div id="box">
			<img src="/semi3/resources/img/결혼2.jpg" alt="결혼이미지" width="100%"
				height="50%">아웃도어/여행
		</div>
		<div id="box">
			<img src="/semi3/resources/img/결혼2.jpg" alt="결혼이미지" width="80%"
				height="50%">운동/스포츠
		</div>
		<div id="box">
			<img src="/semi3/resources/img/결혼2.jpg" alt="결혼이미지" width="80%"
				height="50%">인문학/책/글
		</div>
		<div id="box">
			<img src="/semi3/resources/img/결혼2.jpg" alt="결혼이미지" width="80%"
				height="50%">업종/직무
		</div>
		<div id="box">
			<img src="/semi3/resources/img/결혼2.jpg" alt="결혼이미지" width="80%"
				height="50%">외국/언어
		</div>
		<div id="box">
			<img src="/semi3/resources/img/결혼2.jpg" alt="결혼이미지" width="80%"
				height="50%">음악/악기
		</div>
		<div id="box">
			<img src="/semi3/resources/img/결혼2.jpg" alt="결혼이미지" width="80%"
				height="50%">공예/만들기
		</div>
		<div id="box">
			<img src="/semi3/resources/img/결혼2.jpg" alt="결혼이미지" width="80%"
				height="50%">봉사활동
		</div>
		<div id="box">
			<img src="/semi3/resources/img/결혼2.jpg" alt="결혼이미지" width="80%"
				height="50%">사교/인맥
		</div>
	</div>
	<div class="more">
		<div class="blind"></div>
	</div>
	<div id="container2">
		<div id="box">
			<img src="/semi3/resources/img/결혼2.jpg" alt="결혼이미지" width="80%"
				height="50%">차/오토바이
		</div>
		<div id="box">
			<img src="/semi3/resources/img/결혼2.jpg" alt="결혼이미지" width="80%"
				height="50%">야구관람
		</div>
		<div id="box">
			<img src="/semi3/resources/img/결혼2.jpg" alt="결혼이미지" width="80%"
				height="50%">게임/오락
		</div>
		<div id="box">
			<img src="/semi3/resources/img/결혼2.jpg" alt="결혼이미지" width="80%"
				height="50%">요리/레시피
		</div>
		<div id="box">
			<img src="/semi3/resources/img/결혼2.jpg" alt="결혼이미지" width="80%"
				height="50%">반려동물
		</div>
		<div id="box">
			<img src="/semi3/resources/img/결혼2.jpg" alt="결혼이미지" width="80%"
				height="50%">자유주제
		</div>
	</div>

	<div id="group-list">의 모임 리스트</div>
    <!-- <div id="group"> -->
       <table border="1" id="recomm">
            <tr id="tr1">
                <td id="td1" rowspan="4"><img src="/semi3/resources/img/게임오락.jpg" width="100%" height="100%"></td>
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
    <!-- </div> -->

	<script>
$(document).ready(function(){
  $('.more').click(function(){
    if($('.more').hasClass('more')){
       $('.more').addClass('close').removeClass('more');
       $('#container2').css('visibility', 'visible');
    }else if($('.close').hasClass('close')){
       $('.close').addClass('more').removeClass('close');  
       $('#container2').css('visibility', 'hidden');
    }
  });
});

// const box = document.querySelector("#box");
// box.addEventListener("click", function () {
  
// });
// $("img")
// 		    .html("<img src='"+fileCallPath+"' >")
// 		    .animate({width:'10%', height: '10%'}, 1000);
		    
// 		  }
// var abc=0;
//     $(function() {
        
//         $('img').bind('click', function(event){  //one은 한번만 실행된다.(확대 한번.)
//             var $target = $(this); // $(event.target);
            
//             $target.width($target.width()*0.5);  // 나누기는 축소
//             $target.height($target.height()*0.5);
            
//             $target.unbind();  
 
//         });
//     });
    </script>
</body>
</html>