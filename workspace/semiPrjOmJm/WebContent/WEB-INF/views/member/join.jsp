<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
    body, html {
        margin: 0;
        padding: 0;
    }
    #back{
    padding-top:80px;
        width: 1920px;
        height: 780px;
        display: grid;
        background-color: lightslategray;
    }
    #header{
        width: 1920px;
        height: 100px;
    
    }
    #bot{
        width: 1920px;
        height: 200px;
        border: 1px solid black;
    }
    #main{
        
        display: grid;
        grid-template-rows: repeat(12, 1fr);
        justify-content: center;
        
    }
   
</style>
</head>
<body>
    <div id="back">
        <form action="/omjm/member/join" method="post" enctype="multipart/form-data">
            <div id="main">
                
                <div >아이디</div>
                <div><input type="text" name="memberId"><button>중복체크</button></div>
                
                <div class="span-2">비밀번호</div>
                <div><input type="password" name="memberPwd1"></div>
                <div>비밀번호 확인</div>
                <div><input type="password" name="memberPwd2"></div>
                <div>닉네임</div>
                <div><input type="text" name="memberNick"></div>
                <div>첨부파일</div>
                <div><input type="file" name="f"></div>
                <div>이름</div>
                <div><input type="text" name="memberName"></div>
                <div>핸드폰번호</div>
                <div><input type="text" name="memberPhone"><button>중복체크</button></div>
                <div>관심지역</div>
                <div><input type="text" name="memberPlace"></div>
                <div>카테고리</div>
                <div><input type="text" name="memberCate"></div>
                <div>성별</div>
                <div>
                    남자 <input type="radio" name="memberGender" value="M"> &nbsp;
                    여자 <input type="radio" name="memberGender" value="F">
                </div>
                <select>비밀번호 찾기 질문
                    <option value="1" name = "memberPQ">기억에 남는 추억의 장소는?</option>
                    <option value="2" name = "memberPQ">인상 깊게 읽은 책 이름은?</option>
                    <option value="3" name = "memberPQ">자신의 보물 제1호는?</option>
                    <option value="4" name = "memberPQ">내가 좋아하는 캐릭터는?</option>
                 </select>
                <div>비밀번호 찾기 답</div>
                <div><input type="text" name="memberPA"></div>
                <div><input type="submit" value="회원가입"></div>
            </div>
        </form>
    </div>
    <div id="bot"></div>
</body>
</html>