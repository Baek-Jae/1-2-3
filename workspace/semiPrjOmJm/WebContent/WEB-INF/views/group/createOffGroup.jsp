<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= root %>/css/createOffGroup.css" />
<script src="<%= root %>/javaScript/createOffGroup.js"></script>
</head>
<body>
	 <section>
            <div class="off-wrap">
                <div class="off_head">
                    <h2>Create Offline</h2>
                </div>
                <form action="<%= root %>//offgroup/create" method="post">
                    <div class="off_top">
                        <div class="off_info">
                            <div class="off_profile">
                                <input type="text" name="off_name" required />
                                <label for="off_name">Name</label>
                            </div>
                            <div class="off_profile">
                                <input type="date" name="off_date" id="off-date"  required />
                                <label for="off_name">Date</label>
                            </div>
                            <div class="off_cnt">
                                <div class="off_memberCnt">
	                          		<span class="material-symbols-outlined">group</span>
		                            <input type="range" min="1" max="10" value="2" class="slider" id="user_cnt" name="user_cnt" required>
									<span id="value"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="off_content">
                        <textarea
                            name="off_content"
                            id="off_textarea"
                            onKeyup="textbyte(this,150)"
                            placeholder="약속장소와 시간등을 간단하게 설명해주세요"  required></textarea>
                        <div class="textlength"><span id="byteInfo">0</span>/150Byte</div>
                    </div>
                    <input type="submit" value="Create" />
                </form>
            </div>
        </section>
        <script>
			var slider = document.getElementById("user_cnt");
			var output = document.getElementById("value");
			output.innerHTML = slider.value;
			
			slider.oninput = function() {
			  output.innerHTML = this.value;
			}
		</script>
</body>
</html>