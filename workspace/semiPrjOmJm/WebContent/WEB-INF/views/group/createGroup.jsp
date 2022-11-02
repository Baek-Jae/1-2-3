<%@page import="java.util.ArrayList"%>
<%@page import="place.vo.PlaceVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= root %>/css/createGroup.css" />
<script defer src="<%= root %>/javaScript/createGroup.js"></script>
</head>
<body>
	<section class="group_wrap">
            <div class="group_outer">
                <div class="group_head">
                    <h2>Create your group!</h2>
                </div>
         		<form action="<%= root %>/group/create" method="post" enctype="multipart/form-data" class="create_form">
					<div class="group_pic">
					     <div id="group_img"><img id="preview" src="<%= root %>/resources/testImg.png" alt="배너사진을 업로드 해주세요" /></div>
					    <div class="fileUpload"><label for="group_file">배너사진</label></div>
					    <input type="file" value="사진첨부" name="group_file" id="group_file" onchange="readURL(this)"/>
					</div>
					<div class="group_top">
					    <div class="group_info">
					        <div class="groupcheck">
					            <label for="group_name">NAME</label>
					            <input type="text" name="group_name" id="group_name" placeholder="모임의 이름을 적어주세요"/>
					            <i class="material-symbols-outlined" id="green">task_alt</i>
                        		<i class="material-symbols-outlined" id="red"> error </i>
                        		<small>모임명을 입력해주세요 중복이 되었을수도 있습니다</small>
					        </div>
					        <div class="groupcheck">
					            <label for="group_category">CATEGORY</label>
					            <input type="text" name="group_category" id="category" required readonly placeholder="모임의 카테고리는 무엇인가요?"/>
					            <i class="material-symbols-outlined" id="green">task_alt</i>
                        		<i class="material-symbols-outlined" id="red"> error </i>
                        		<small>모임의 카테고리를 설정해주세요.</small>
					        </div>
					        <div class="group_place_usercnt">
						        <div class="groupcheck">
						        	<label for="selectPlace">LOCATION</label>
						        	<select name="group_place" id="selectPlace">
						        		<option value="" selected disabled>지역을 선택해주세요</option>
						          	<c:forEach items="${placeList}" var="i">
						           		<option value="${i.pNo}">${i.pName}</option>
						          	</c:forEach>
						        	</select>
						        	<i class="material-symbols-outlined" id="green">task_alt</i>
	                        		<i class="material-symbols-outlined" id="red"> error </i>
	                        		<small>모임의 장소를 선택해주세요</small>
						        </div>
						        <div class="groupcheck">
					            	<label for="setGroupMember">MAX MEMBER</label>
					                <input type="number" min="0" max="10" step="1" name="userCnt" id="setGroupMember" placeholder="아쉽지만 최대정원은 10명입니다."/>
					                <i class="material-symbols-outlined" id="green">task_alt</i>
	                        		<i class="material-symbols-outlined" id="red"> error </i>
	                        		<small>정원은 10명까지만 가능합니다.</small>
						        </div>
					        </div>
					    </div>
					</div>
					<div class="groupcheck">
						<label for="selectPlace">CONTENT</label>
					    <textarea
					        name="group_content"
					        id="group_textarea"
					        onKeyup="textbyte(this,500)"
					        placeholder="어떤 모임을 만들고 싶으신가요?"></textarea>
					    	<div class="textlength"><span id="byteInfo">0</span>/500Byte</div>
					        <i class="material-symbols-outlined" id="green">task_alt</i>
                       		<i class="material-symbols-outlined" id="red"> error </i>
                       		<small>모임소개를 작성해 많은사람들과 함께하세요.</small>
					</div>
					<input type="text" value="" name="cate_no" id="categoryNo" style="visibility: hidden;">
					<div class="group_check">
					    <input type="submit" value="생 성" />
					</div>
				</form>
			</div>
	</section>
</body>
</html>