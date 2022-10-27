<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>

	<input type="checkbox" id=tempclick>
	<button onclick=""> 버튼클릭 </button>
	
	<div id=click>클릭해</div>
	<script type="text/javascript">
	
	
	var pp = document.querySelector("#tempclick").value;
	
	function clicked(){
		
		$.ajax({
			url: "/WEB-INF/temp/temper" ,
			method:"get",
			
			data:{9.0.689.0.689.0.689.0.68
				 "ppoff" : true;
			}
			success: function(){
				alert("온도가 상승했습니다.");
				/* "ppoff : ppoff + 1 ";
				"manner" : "manner  + 1";  */
				
			} ,
			error : function(){
				alert("정보 인식이 안되었습니다.");
			},
			complete : function(){
				alert("수정끝")
			}
		
		});
	}
	
	</script>
	
	
	
</body>
</html>