<%@page import="java.util.ArrayList"%>
<%@page import="place.vo.PlaceVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%List<PlaceVo> placeList = (ArrayList<PlaceVo>)request.getAttribute("placeList");%>
 <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@40,400,0,0" />
<style>
*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Noto Sans KR', sans-serif;
}
.full{

    width: 60vw;
    height: 80vh;
    background-color: #fff;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    align-items: center;
    border: 5px solid #fdb930;
    border-radius: 20px;
    margin: auto;
    margin-top: 50px;
    font-size: 18px;
    
}
.select{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
    width: 500px;
    height: 100%;
}

.full > form {
    height: 700px;
    width: 500px;
}

.select div {
    width: 250px;
    height: 100%;
}
.select-place{
    -o-appearance: none;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    border: 1px solid #dddddd;
      color: #999999;
    border-radius: 5px;
    cursor: pointer;
    height: 35px;
    width: 100%;
    text-align: center
    ;
}
.small{
    padding-top: 50px;
}
#submit{
    background-color: rgba(0, 53, 109, 0.95);
    color: #fff;
}
.yellow{
    color: #fdb930;
}
#interest{
    height: 100px;
    display: grid;
    align-content: center;
    
}
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  
    <div class="full">
        <div id="interest"><h3>관심지역을 골라주세요</h3></div>
        
            <div class="select">
                <div class="small"><span class="material-symbols-outlined yellow" >home_pin서울시</span></div>
                <div><select name="place" class="select-place">
                        <option value="">==지역 선택==</option>
                        <% for(int i = 0; i < placeList.size(); ++i){%>
                        <option id="place-name" value="<%= placeList.get(i).getpName() %>"><%= placeList.get(i).getpName() %></option>
                        <%  } %>
                    </select>
                </div>
                <div class="small"><span class="material-symbols-outlined">pin_drop서울시</span></div>
                <div><select name="place" class="select-place">
                        <option value="">==지역 선택==</option>
                        <% for(int i = 0; i < placeList.size(); ++i){%>
                        <option id="place-name" value="<%= placeList.get(i).getpName() %>"><%= placeList.get(i).getpName() %></option>
                        <%  } %>
                    </select>
                </div>
                <div class="small"><span class="material-symbols-outlined">pin_drop서울시</span></div>
                <div> <select name="place" class="select-place">
                        <option value="">==지역 선택==</option>
                        <% for(int i = 0; i < placeList.size(); ++i){%>
                        <option id="place-name" value="<%= placeList.get(i).getpName() %>"><%= placeList.get(i).getpName() %></option>
                        <%  } %>
                    </select>
                </div>
                <div><input type="button" value="관심지역 선택하기" class="select-place" id="submit"></div>
            </div>
        
    </div>

<script>
    //타입이 버튼인 것을 가져옴
    const btn = document.querySelector('input[type=button]');
    //이름이 place인것을 가져옴 
    const place = document.querySelectorAll('select[name=place]');

    console.log(place.length);
    btn.addEventListener('click', function(){

     let likeplace = "";

       for(let i = 0; i < place.length; i++){
       
            if(place[i].value !=null && place[i].value != ""){

                if(i == 0){
                    likeplace += place[i].value;
                }else if(likeplace != ""){
                    likeplace += "," + place[i].value;
                }else{
                    likeplace += place[i].value;
                }
            }
        }
        if(likeplace != ""){
            opener.document.querySelector('#likeplace').value = likeplace;
           
            window.close();

        }else {
            alert('관심지역 선택 1개는 필수 입니다')
        }

    })

</script>
</body>
</html>