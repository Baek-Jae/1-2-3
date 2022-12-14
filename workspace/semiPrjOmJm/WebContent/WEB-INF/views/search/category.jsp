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
  
  String search = (String)session.getAttribute("search");
  
  String search2 = (String)request.getAttribute("search2");

  List<GroupVo> groupList = (ArrayList<GroupVo>)request.getAttribute("groupList");

  List<GroupVo> groupName = (ArrayList<GroupVo>)request.getAttribute("groupName");
  
  List<GroupVo> groupName2 = (ArrayList<GroupVo>)request.getAttribute("groupName2");
  String msg = (String)request.getAttribute("msg");
  
 %>
  <%if(msg != null){%>
    alert('<%=msg%>');
   <%}%>
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
   pla =  placeArr[arrmath];   %>
   
<script>

console.log(${search});

      $.ajax({
      url :   "<%=root%>/main/membergroup" , 
        method : "GET",   
        data :   {
           "p1" :"<%=pla%>"
        },
        success : function(x){
           var o = JSON.parse(x);
           
           let j = 0;
         for(let i = 0; i < o.length; i++ && j < 3){
        	 
            let div = $('<div/>');
            div.addClass("group-card");
      
            div.append('<div class="group-wrap">'
                       +'<div class="card-top">'
                        +'<img src="<%= root %>/resources/testImg.png" alt="????????????"/>'
                    +'</div>'
                    +'<div class="card-bottom">'
                       +'<span>?????????</span>'
                           +'<span class="group-na">'+o[i].name+'</span>'
                           +'<span>????????????</span>'
                           +'<span class="group-cate">'+o[i].category+'</span>'
                           +'<div>'
                               +'<span class="material-symbols-outlined" id="location-icon">location_on</span>'
                               +'<span class="group-pl">'+o[i].place+'</span>'
                           +'</div>'
                           +'<div id="group-info">'
                               +'<span class="material-symbols-outlined" id="group-icon">group</span>'
                               +'<span class="group-cnt">'+o[i].userCnt+'</span>'
                        +'</div>'
                        +'<a href="/omjm/group/main?gno='+o[i].no+'">???????????? <i class="fa-solid fa-angles-right fa-beat-fade"></i></a>'
                   +'</div>'
                +'</div>');
            
            $(div).appendTo('.group-list');   
            j++;
         }
      },
      error : function(){
         alert("login-group ?????? ??????!");
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
            
             let j = 0;
            for(let i = 0; i < o.length; i++ && j < 3){ 
               let div = $('<div/>');
               div.addClass("group-card");
               
               div.append('<div class="group-wrap">'
                          +'<div class="card-top">'
                           +'<img src="<%= root %>/resources/testImg.png" alt="????????????"/>'
                       +'</div>'
                       +'<div class="card-bottom">'
                          +'<span>?????????</span>'
                              +'<span class="group-na">'+o[i].name+'</span>'
                              +'<span>????????????</span>'
                              +'<span class="group-cate">'+o[i].category+'</span>'
                              +'<div>'
                                  +'<span class="material-symbols-outlined" id="location-icon">location_on</span>'
                                  +'<span class="group-pl">'+o[i].place+'</span>'
                              +'</div>'
                              +'<div id="group-info">'
                                  +'<span class="material-symbols-outlined" id="group-icon">group</span>'
                                  +'<span class="group-cnt">'+o[i].userCnt+'</span>'
                           +'</div>'
                           +'<a href="/omjm/group/main?gno='+o[i].no+'">???????????? <i class="fa-solid fa-angles-right fa-beat-fade"></i></a>'
                      +'</div>'
                   +'</div>');
               
               $(div).appendTo('.group-list');   
            }
         },
         error : function(){
            alert("logout-group ?????? ??????!");
         }
      });
</script>
<%}%>

<script>
      <%if(search != null){ %>
   $(document).ready(function() {
   
     <%   for(int i = 0; i < 3; ++i) {%> 

            let div = $('<div/>');
            div.addClass("group-card");
            console.log($('.group-card'))
            div.append('<div class="group-wrap">'
                       +'<div class="card-top">'
                    +'<img src="<%= root %>/resources/testImg.png" alt="????????????"/>'
                +'</div>'
                +'<div class="card-bottom">'
                   +'<span>?????????</span>'
                           +'<span class="group-na">'+<%= groupName.get(i).getName() %>+'</span>'
                           +'<span>????????????</span>'
                           +'<span class="group-cate">'+<%= groupName.get(i).getCategory() %>+'</span>'
                           +'<div>'
                               +'<span class="material-symbols-outlined" id="location-icon">location_on</span>'
                               +'<span class="group-pl">'+<%= groupName.get(i).getPlace() %>+'</span>'
                           +'</div>'
                           +'<div id="group-info">'
                               +'<span class="material-symbols-outlined" id="group-icon">group</span>'
                               +'<span class="group-cnt">'+<%= groupName.get(i).getUserCnt() %>+'</span>'
                    +'</div>'
                    +'<a href="/omjm/group/main?gno='+<%= groupList.get(i).getNo() %>'">???????????? <i class="fa-solid fa-angles-right fa-beat-fade"></i></a>'
               +'</div>'
            +'</div>');
            
            $(div).appendTo('.group-list');   
      <%}%>   
   })
</script>
   <% } else{ %>
<script>
$(document).ready(function() { 
  
   alert("????????? ??????!");
     <%for(int i = 0; i < 3; ++i){ %>
         let div = $('<div/>');
         div.addClass("group-card");
         
         div.append('<div class="group-wrap">'
                   +'<div class="card-top">'
               +'<img src="<%= root %>/resources/testImg.png" alt="????????????"/>'
           +'</div>'
           +'<div class="card-bottom">'
              +'<span>?????????</span>'
                       +'<span class="group-na">'+<%= groupList.get(i).getName() %>+'</span>'
                       +'<span>????????????</span>'
                       +'<span class="group-cate">'+<%= groupList.get(i).getCategory() %>+'</span>'
                       +'<div>'
                           +'<span class="material-symbols-outlined" id="location-icon">location_on</span>'
                           +'<span class="group-pl">'+<%= groupList.get(i).getPlace() %>+'</span>'
                       +'</div>'
                       +'<div id="group-info">'
                           +'<span class="material-symbols-outlined" id="group-icon">group</span>'
                           +'<span class="group-cnt">'+<%= groupList.get(i).getUserCnt() %>+'</span>'
               +'</div>'
               +'<a href="/omjm/group/main?gno='+<%= groupList.get(i).getNo() %>'">???????????? <i class="fa-solid fa-angles-right fa-beat-fade"></i></a>'
          +'</div>'
       +'</div>');
         
         $(div).appendTo('.group-list');   
      }
         
      <% } %>
    }) 
</script>
 <% } %> 
   
   <div id="ca-search">
      <form action="<%= root %>/search" class="main-search" method="post">
         <div class="main-search-group">
            <span class="material-symbols-outlined">search</span> 
            <input type="text" id="my_name" name="search2" placeholder="????????? ???????????????" 
            value="<% if(search != null){ %> <%= search %>
                     <%}else if(search2 != null){ %> <%= search2 %>
                                <%}%>"/>
         </div> 
         <input type="button" id="submit" onclick="return doAction();" value="???  ???">
      </form>

      <select name="place" class="ca-option" id="select-pl">
         <option value="option1">==?????? ??????==</option>
         <% for(int i = 0; i < placeList.size(); ++i){%>
         <option id="place-name" value="<%= placeList.get(i).getpNo() %>"><%= placeList.get(i).getpName() %></option>
         <%  } %>
      </select>
   </div>
   
   <div id="container">
      <div id="box">
      <input type="checkbox" class="" id="collapsible5" name="cs_biz_form">
         <label for="collapsible5"> 
         <img src="<%= root %>/resources/????????????2.jpg" alt="????????????" width="80%" height="70%"> 
         <div>??????/??????</div>
            </label>
         <ul class="menuitems">
            <% for(int i = 0; i < cateVo.size(); ++i){
                      if("??????/??????".equals(cateVo.get(i).getCaName())){ %>
            <li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
            <%}}%>
         </ul>
      </div>
      <div id="box">
      <input type="checkbox" class="" id="collapsible6" name="cs_biz_form">
         <label for="collapsible6"> 
         <img src="<%= root %>/resources/??????.jpg" alt="????????????" width="80%" height="70%"> 
         <div>??????/??????</div>
            </label>
         <ul class="menuitems">
         <% for(int i = 0; i < cateVo.size(); ++i){
                     if("??????/??????".equals(cateVo.get(i).getCaName())){ %>
         <li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
         <%}}%>
         </ul>
      </div>
      <div id="box">
      <input type="checkbox" class="" id="collapsible7" name="cs_biz_form">
         <label for="collapsible7"> 
         <img src="<%= root %>/resources/????????????2.jpg" alt="????????????" width="80%" height="70%">
         <div>??????/??????</div> 
            </label>
         <ul class="menuitems">
         <% for(int i = 0; i < cateVo.size(); ++i){
                     if("??????/??????".equals(cateVo.get(i).getCaName())){ %>
         <li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
         <%}}%>
         </ul>
      </div>
      <div id="box">
      <input type="checkbox" class="" id="collapsible8" name="cs_biz_form">
         <label for="collapsible8"> 
         <img src="<%= root %>/resources/?????????.jpg" alt="????????????" width="80%" height="70%"> 
         <div>??????/?????????</div>
            </label>
         <ul class="menuitems">
         <% for(int i = 0; i < cateVo.size(); ++i){
                     if("??????/?????????".equals(cateVo.get(i).getCaName())){ %>
         <li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
         <%}}%>
         </ul>
      </div>
      <div id="box">
      <input type="checkbox" class="" id="collapsible15" name="cs_biz_form">
         <label for="collapsible15">
         <img src="<%= root %>/resources/????????????2.jpg" alt="????????????" width="80%" height="70%">
         <div>????????????</div>
            </label>
         <ul class="menuitems">
         <% for(int i = 0; i < cateVo.size(); ++i){
                     if("????????????".equals(cateVo.get(i).getCaName())){ %>
         <li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
         <%}}%>
         </ul>
      </div>
      

      <div id="box">
         <input type="checkbox" class="" id="collapsible2" name="cs_biz_form">
         <label for="collapsible2"> 
            <img src="<%= root %>/resources/??????2.png" alt="????????????" width="80%" height="70%"> 
            <div>????????????/??????</div>
         </label>
         <ul class="menuitems">
            <% for(int i = 0; i < cateVo.size(); ++i){
                      if("????????????/??????".equals(cateVo.get(i).getCaName())){ %>
            <li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
            <%}}%>
         </ul>
      </div>
      <div id="box">
         <input type="checkbox" class="" id="collapsible3" name="cs_biz_form">
         <label for="collapsible3"> 
            <img src="<%= root %>/resources/??????2.png" alt="????????????" width="80%" height="70%"> 
            <div>??????/?????????</div>
         </label>
         <ul class="menuitems">
            <% for(int i = 0; i < cateVo.size(); ++i){
                      if("??????/?????????".equals(cateVo.get(i).getCaName())){ %>
            <li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
            <%}}%>
         </ul>
      </div>
      <div id="box">
      <input type="checkbox" class="" id="collapsible4" name="cs_biz_form">
         <label for="collapsible4"> 
         <img src="<%= root %>/resources/???2.png" alt="????????????" width="80%" height="70%"> 
         <div>?????????/???/???</div>
            </label>
         <ul class="menuitems">
            <% for(int i = 0; i < cateVo.size(); ++i){
                      if("?????????/???/???".equals(cateVo.get(i).getCaName())){ %>
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
         <img src="<%= root %>/resources/????????????.jpg" alt="????????????" width="80%" height="70%">
         <div>????????????</div>
            </label>
         <ul class="menuitems">
         <% for(int i = 0; i < cateVo.size(); ++i){
                     if("????????????".equals(cateVo.get(i).getCaName())){ %>
         <li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
         <%}}%>
         </ul>
      </div>
      <div id="box">
      <input type="checkbox" class="" id="collapsible10" name="cs_biz_form">
         <label for="collapsible10">
         <img src="<%= root %>/resources/??????.jpg" alt="????????????" cwidth="80%" height="70%">
         <div>??????/??????</div>
            </label>
         <ul class="menuitems">
         <% for(int i = 0; i < cateVo.size(); ++i){
                     if("??????/??????".equals(cateVo.get(i).getCaName())){ %>
         <li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
         <%}}%>
         </ul>
      </div>
      <div id="box">
      <input type="checkbox" class="" id="collapsible13" name="cs_biz_form">
         <label for="collapsible13">
         <img src="<%= root %>/resources/????????????.jpg" alt="????????????" width="80%" height="70%">
         <div>??????/??????</div>
            </label>
         <ul class="menuitems">
         <% for(int i = 0; i < cateVo.size(); ++i){
                     if("??????/??????".equals(cateVo.get(i).getCaName())){ %>
         <li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
         <%}}%>
         </ul>
      </div>
      <div id="box">
      <input type="checkbox" class="" id="collapsible11" name="cs_biz_form">
         <label for="collapsible11">
         <img src="<%= root %>/resources/???????????????.jpg" alt="????????????" width="80%" height="70%">
         <div>???/????????????</div>
            </label>
         <ul class="menuitems">
         <% for(int i = 0; i < cateVo.size(); ++i){
                     if("???/????????????".equals(cateVo.get(i).getCaName())){ %>
         <li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
         <%}}%>
         </ul>
      </div>
      <div id="box">
      <input type="checkbox" class="" id="collapsible12" name="cs_biz_form">
         <label for="collapsible12">
         <img src="<%= root %>/resources/????????????3.png" alt="????????????" width="80%" height="70%">
         <div>????????????</div>
               </label>
         <ul class="menuitems">
         <% for(int i = 0; i < cateVo.size(); ++i){
                     if("????????????".equals(cateVo.get(i).getCaName())){ %>
         <li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
         <%}}%>
         </ul>
      </div>
      <div id="box">
      <input type="checkbox" class="" id="collapsible14" name="cs_biz_form">
         <label for="collapsible14">
         <img src="<%= root %>/resources/??????.jpg" alt="????????????" width="80%" height="70%">
         <div>??????/?????????</div>
            </label>
         <ul class="menuitems">
         <% for(int i = 0; i < cateVo.size(); ++i){
                     if("??????/?????????".equals(cateVo.get(i).getCaName())){ %>
         <li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
         <%}}%>
         </ul>
      </div>
      <div id="box">
         <input type="checkbox" class="" id="collapsible" name="cs_biz_form">
         <label for="collapsible"> 
          <img src="<%= root %>/resources/??????1.png" alt="????????????" width="80%" height="70%">
          <div>??????/??????</div> 
          </label>
         <ul class="menuitems">
            <% for(int i = 0; i < cateVo.size(); ++i){
               String cate = cateVo.get(i).getCaName();
                      if("??????/??????".equals(cate)){ %>
            <li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
            <%}}%>
         </ul>
      </div>
      
      
      <div id="box">
      <input type="checkbox" class="" id="collapsible16" name="cs_biz_form">
         <label for="collapsible16">
         <img src="<%= root %>/resources/??????.jpg" alt="????????????" width="80%" height="70%">
         <div>????????????</div>
            </label>
         <ul class="menuitems">
         <% for(int i = 0; i < cateVo.size(); ++i){
                     if("????????????".equals(cateVo.get(i).getCaName())){ %>
         <li class="li-click" onclick="searchcate(<%=cateVo.get(i).getCaNo()%>);"><%=cateVo.get(i).getDeName() %></li>
         <%}}%>
      </div>
   </div>

      <div id="group-place"></div>
      <div id="group-list">??? ?????? ?????????</div>
   
   <div id="tempList" class="group-list"></div>
  
   <br><br><br><br><br><br><br>
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
       
     if(temp != null){
        $('#group-list').css('visibility', 'visible');
        $('#group-place').text($(temp).text());
        
              // function searchcate(num2){ 
               $.ajax({
                  url : "<%=root%>/plsearch",
                  method : "GET",   
                  data :   {
                     "temp" : temp.val()
                  },
                  success : function(z){
                     var sp = JSON.parse(z);
                     
                     $('.group-list').empty();
                     
                     let j = 0;
                     for(let i = 0; i < sp.length; i++ && j<4){
                        let div = $('<div/>');
                        div.addClass("group-card");
                        
                        div.append('<div class="group-wrap">'
                                   +'<div class="card-top">'
                                   +'<img src="<%= root %>/resources/testImg.png" alt="????????????"/>'
                               +'</div>'
                               +'<div class="card-bottom">'
                                  +'<span>?????????</span>'
                                       +'<span class="group-na">'+sp[i].name+'</span>'
                                       +'<span>????????????</span>'
                                       +'<span class="group-cate">'+sp[i].category+'</span>'
                                       +'<div>'
                                           +'<span class="material-symbols-outlined" id="location-icon">location_on</span>'
                                           +'<span class="group-pl">'+sp[i].place+'</span>'
                                       +'</div>'
                                       +'<div id="group-info">'
                                           +'<span class="material-symbols-outlined" id="group-icon">group</span>'
                                           +'<span class="group-cnt">'+sp[i].userCnt+'</span>'
                                   +'</div>'
                                   +'<a href="/omjm/group/main?gno='+sp[i].no+'">???????????? <i class="fa-solid fa-angles-right fa-beat-fade"></i></a>'
                              +'</div>'
                           +'</div>');
                        
                        $(div).appendTo('.group-list');   
                        j++;
                     }
                  },
                  error : function(){
                     alert("?????? ??????!");
                  }
               });
            }
     
});

    $(document).ready(function() {
        $('input[type="checkbox"][name="cs_biz_form"]').click(function(){
         if($(this).prop('checked')){
            $('input[type="checkbox"][name="cs_biz_form"]').prop('checked',false);
            $(this).prop('checked',true);
           }
          });
        });


    searchcate = function(num2){
            $.ajax({
               url : "<%=root%>/desearch",
               method : "GET",   
               data :   {
                  dese : num2
               },
               success : function(x){
                  var o = JSON.parse(x);

               $('.group-list').empty();
                  for(let i = 0; i < o.length; i++ && j < 4){
                  let div = $('<div/>');
                  div.addClass("group-card");

                  div.append('<div class="group-wrap">'
                             +'<div class="card-top">'
                              +'<img src="<%= root %>/resources/testImg.png" alt="????????????"/>'
                          +'</div>'
                          +'<div class="card-bottom">'
                             +'<span>?????????</span>'
                                 +'<span class="group-na">'+o[i].name+'</span>'
                                 +'<span>????????????</span>'
                                 +'<span class="group-cate">'+o[i].category+'</span>'
                                 +'<div>'
                                     +'<span class="material-symbols-outlined" id="location-icon">location_on</span>'
                                     +'<span class="group-pl">'+o[i].place+'</span>'
                                 +'</div>'
                                 +'<div id="group-info">'
                                     +'<span class="material-symbols-outlined" id="group-icon">group</span>'
                                     +'<span class="group-cnt">'+o[i].userCnt+'</span>'
                              +'</div>'
                              +'<a href="/omjm/group/main?gno='+o[i].no+'">???????????? <i class="fa-solid fa-angles-right fa-beat-fade"></i></a>'
                         +'</div>'
                      +'</div>');

                  $(div).appendTo('.group-list');
                  j++;
               }
            },
               error : function(){
                  alert("num2 ?????? ??????!");
               }
            });
         } 
           
    $('#submit').click(function(){
      <%--  alert("<%=search2%>");  --%>
          $.ajax({
            url : "<%=root%>/keywordsearch",
              method : "GET",   
              data :   {
                 "key" : $('input[name=search2]').val()
              },
              success : function(x){
                 var o = JSON.parse(x);

               $('.group-list').empty();
               let j = 0;
                 for(let i = 0; i < o.length; i++ && j <3){
                  let div = $('<div/>');
                  div.addClass("group-card");
            
                  div.append('<div class="group-wrap">'
                             +'<div class="card-top">'
                              +'<img src="<%= root %>/resources/testImg.png" alt="????????????"/>'
                          +'</div>'
                          +'<div class="card-bottom">'
                             +'<span>?????????</span>'
                                 +'<span class="group-na">'+o[i].name+'</span>'
                                 +'<span>????????????</span>'
                                 +'<span class="group-cate">'+o[i].category+'</span>'
                                 +'<div>'
                                     +'<span class="material-symbols-outlined" id="location-icon">location_on</span>'
                                     +'<span class="group-pl">'+o[i].place+'</span>'
                                 +'</div>'
                                 +'<div id="group-info">'
                                     +'<span class="material-symbols-outlined" id="group-icon">group</span>'
                                     +'<span class="group-cnt">'+o[i].userCnt+'</span>'
                              +'</div>'
                              +'<a href="/omjm/group/main?gno='+o[i].no+'">???????????? <i class="fa-solid fa-angles-right fa-beat-fade"></i></a>'
                         +'</div>'
                      +'</div>');
                  
                  $(div).appendTo('.group-list');   
                  j++;
               }
            },
              error : function(){
                 alert("keyword ?????? ??????!");
              }
         });  
   })
   
   function doAction(form){
       if(form.search.value == ''){
            alertify
             .alert("???????????? ????????? ?????????~");  
          form.search.focus();
          return false;
       }
       return true;
    }
   
</script>
</body>
</html>