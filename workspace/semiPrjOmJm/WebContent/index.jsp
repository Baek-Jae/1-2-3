<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= root %>/css/mainStyle.css" />
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
            <div></div>
            <form action="" class="main-search">
                <div class="main-search-group">
                	<span class="material-symbols-outlined">search</span>
                    <input type="text" name="search" placeholder="모임을 찾아보세요" />
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
	                        <span>아자자</span>
	                        <span>그룹장</span>
	                        <span>아자자</span>
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
	                        <span>모임명</span>
	                        <span>아자자</span>
	                        <span>그룹장</span>
	                        <span>아자자</span>
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
        <br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>