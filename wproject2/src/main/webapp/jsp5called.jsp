<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
서버에 의해 호출(Servlet이 호출)된 파일<br>
<%
//redirect 방식
String mydata= request.getParameter("data");
out.println("전송된 data(리다이렉트방식)는 "+ mydata);
out.println("<br>");

//forward 방식
String ourdata= (String)request.getAttribute("dd");
out.println("전송된 data(포워드방식)는 "+ ourdata);
%>


</body>
</html>