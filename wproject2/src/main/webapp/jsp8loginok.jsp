<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인 성공했을때 <p>
<table border='1'>
<tr>
<td colspan="2">해당 페이지로 이동</td>
</tr>
<%
String id=(String)session.getAttribute("id");
if(id.equals("admin")){
%>
<tr style="background-color:gold">
	<td><%=id %></td>
	<td><a href="http://daum.net">관리자화면</a></td>
</tr>
<%	
}else if(id.equals("user")){
%>
<tr style="background-color:silver">
	<td><%=id %></td>
	<td><a href="http://naver.com">사용자화면</a></td>
</tr>
<%	
}
%>
</table>
</body>
</html>