<%@page import="java.util.ArrayList"%>
<%@page import="place.vo.PlaceVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/common/header.jsp" %>
<%List<PlaceVo> placeList = (ArrayList<PlaceVo>)request.getAttribute("placeList");%>
<style>
*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Noto Sans KR', sans-serif;
}
.full{

    width: 100vw;
    height: 80vh;
    background-color: #fff;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    
}
.select{
    display: grid;
    grid-template-rows: repeat(4,1fr);
}
#header{
        width: 100vw;
        height: 90px;
    
}
full > * {
    height: 500px;
}
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div id="header">헤더</div>
    <div class="full">
        <h1>관심지역을 골라주세요</h1>
        <form action="/member/likeplace" method="post">
            <div class="select">
                <div>o
                관심 지역1 
                    <select name="place" class="ca-option" id="select-pl" onchange="javascript:myListener(this)"
                    oninvalid="this.setCustomValidity('관심지역 1은 선택해주셔야합니다')" required>
                        <option value="">==지역 선택==</option>
                        <% for(int i = 0; i < placeList.size(); ++i){%>
                        <option id="place-name" value="<%= placeList.get(i).getpNo() %>"><%= placeList.get(i).getpName() %></option>
                        <%  } %>
                    </select>
                </div>
                <div>o
                    관심 지역 2 
                    <select name="place" class="ca-option" id="select-pl" onchange="javascript:myListener(this)">
                        <option value="">==지역 선택==</option>
                        <% for(int i = 0; i < placeList.size(); ++i){%>
                        <option id="place-name" value="<%= placeList.get(i).getpNo() %>"><%= placeList.get(i).getpName() %></option>
                        <%  } %>
                    </select>
                </div>
                <div>o
                    관심 지역 3 
                    <select name="place" class="ca-option" id="select-pl" onchange="javascript:myListener(this)">
                        <option value="">==지역 선택==</option>
                        <% for(int i = 0; i < placeList.size(); ++i){%>
                        <option id="place-name" value="<%= placeList.get(i).getpNo() %>"><%= placeList.get(i).getpName() %></option>
                        <%  } %>
                    </select>
                </div>
                <div><input type="submit" value="관심지역 선택하기"></div>
            </div>
        </form> 
    </div>
</body>
</html>