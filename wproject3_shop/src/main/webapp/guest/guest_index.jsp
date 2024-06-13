<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>
</head>
<body>
<table>
	<tr>
	<td style="font-size: 24px;">특별상품 전문 쇼핑몰</td>
	</tr>
</table>

<%@ include file="guest_top.jsp" %>
<!-- 로그인성공여부에 따라서 상단메뉴바가 달라지도록 설정해줌. -->
<table>
<%
if(memid != null){// 로그인정보부합해서 로그인성공화면 
	// 상단메뉴바가 로그아웃, 회원수정 코너가 등장
	%>
	<tr style="text-align: center;">
	<td>
	<%=memid %>님 방문을 환영합니다!!
	<img src="../images/pic2.gif"/><!-- 데이터처럼넣기 -->
	</td>
	</tr>
	<% 
}else{//로그인정보부합하지 않음. 로그인실패.
	//상단메뉴바 로그인, 회원가입 코너 등장.
	%>
	<tr style="text-align: center;"><!-- 배경으로깔기 -->
	<td style="font-size: 24px; background-image: url(../images/pic.jpg); background-size: 100%">
	<br><br><br><br><br><br><br><br>
	😁고객님 어서오세요😁
	<br><br>
	로그인 후 이용바랍니다😊
	</td>
	</tr>	
	<%
}
%>

</table>
<%@ include file="guest_bottom.jsp" %> 
<!-- 고객님환영합니다 바닥글영역 -->

</body>
</html>