<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id= request.getParameter("id");
String pwd= request.getParameter("pwd");

if(id.equals("admin") && pwd.equals("111")){ //db에 관리자정보가 아직 없다. 그래서 약식으로 매칭값을 줌.
	//로그인에 성공했으므로 세션을 생성. 세션은 30분간유효 기본값.
	session.setAttribute("adminOk", id);
	out.println("로그인성공<br>");
}else{
	out.println("로그인실패<br>");
}
%>
<a href="javascript:window.close()">[창닫기]</a>
</body>
</html>