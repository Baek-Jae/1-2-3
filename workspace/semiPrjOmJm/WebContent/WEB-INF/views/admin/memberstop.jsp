<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/admin/memberheader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./member1.css">
<link rel="stylesheet" href="./stop.css">
 <style>

#nav2{
    font-size: 12pt;
    font-family: 'PT Sans', Arial, Sans-serif;
    position: relative;
}
#nav2 .ulc{
    padding: 0;
    margin: 0 auto;
    width: auto;
}
#nav2 li{

}
#nav2 a{
    line-height: 50px;
    height: 50px;
}

#nav2 li a{
    box-sizing: border-box;
}

#nav2 li:last-child{
    border-right: 0;
}

#nav2 a:hover,#nav2 a:active{

}
#nav2 a:pull{
    display: none;
}

ul{
    margin: 0;
    padding: 0;
    background-color: #333;
    text-align: center;
}

li{
    /*position: relative;*/
    display: inline-block;
}

li a{
    color: #FFFFFF;
    text-align: center;
    padding: 14.5px 16px;
    text-decoration: none;
}

li a:hover{
    color: #FFD400;
    font-weight: normal;
}

.menu{
    width: 500px;
       height: 50px;
       text-align: center;
       max-width: 100%;
       background-position: center;
       background-size: cover;
       background-color: #333333;color: white;
       position: absolute;z-index: 1;
       right: 500px;
}









    html, body{
        padding: 0;
        margin: 0;
    }
    div{
        box-sizing: bor;
    }

    /*헤더 부분*/
    
    #head{
        border: 1px solid blue;
        width: 1920px;
        height: 100px;
        
    }
    #content{
        border: 1px solid red;
        
        width: 1920px;
        height: 780px;
    }
    #bot{
        width: 1920px;
        height: 200px;
        border: 1px solid green;
    }

    #menuTop{
        margin-top: 0;
        margin-bottom: 0;
        margin-left: 0px;
        margin-right: 0;
        background-color: #f6f6f6;
    }

    #menuTop1{
        width: 100vw;
        height: 50%;
        background-color: white;
        color: black;
        font-size: 1.5rem;
        display: grid;
        grid-template-columns: repeat(4,1fr);
        position: relative; left: 250px;
    }

    #modify1{
        position: absolute;
        width: 140px;
        height: 30px;
        left: 1700px;
        top: 200px;
        border: 2px solid yellow;
        border-radius: 30%;
        text-align: center;
        background-color: yellow;

    }
    #modify2{
        position: absolute;
        width: 100px;
        height: 30px;
        left: 1700px;
        top: 240px;
        border: 2px solid yellow;
        border-radius: 30%;
        text-align: center;
        background-color: yellow;
    }
   
    #membersyo{
        position: absolute;
        width: 200px;
        height: 300px;
        left: 800px;
        top: 200px;
        border: 1px solid black;
        border-radius: 20%;
        text-align: center;
        background-color: whitesmoke;
    }
    
    .box{
            position: absolute;
            left: 520px;
            top: 0px;
            width: 200px;
            height: 300px;
            border: 1px solid black;
            box-sizing: border-box;
            border-radius: 20%;
            text-align: center;
            background-color: whitesmoke;
            
        }


    </style>
</head>
<body>
  <div id="main">
        <div id="head"></div>
        <div id="header">
            <div class="menu" >
                <div id="nav2">
                  <ul class="ulc">
                    <li><a href="">회원정보</a></li> 
                    <li><a href="">회원모임</a></li>
                    <li><a href="">회원제제내역</a></li>
                    <li><a href="">문의관리</a></li>
                </ul>
                <a id="pull" href="#"></a>
              </nav>
              </div>
        </div>
        <div id="content">
            
            <div id="membersyo"> 
            회원이름: <input type="text" id="in1" placeholder="회원이름 을 입력하세요 .  ">
            <br><br>
            회원등급: <input type="text" id="in2" placeholder="회원등급 을 입력하세요 .">
            <br><br>
            회원제제:<input type="text" id="in3" placeholder= "회원 제제내역을 입력하세요 .">
            <br><br><br><br>
            <button onclick="printOrder();">정보 출력</button>
            <br>
            <div id="result" class="box">

                <h3>id</h3>
                <h3>id</h3>
                <h3>id</h3>
                <h3>id</h3>
                
            </div>
        
            <script>
                function printOrder(){
                x1=document.querySelector('#in1');
                x2=document.querySelector('#in2');
                x3=document.querySelector('#in3');
            
                console.log(x1.value);
                console.log(x2.value);
                console.log(x3.value);
        
                resultDiv = document.querySelector('#result');
                console.log(resultDiv);
                
            </script>

            </div>

        

        <div id="modify1"><a>회원정보 저장</a></div>
        <div id ="modify2"><a>제제하기</a></div>
        
            
        
        </div>
        <div id="bot"></div>
    </div>
		

</body>
</html>