<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 자바 영역
String irum= request.getParameter("writer");
String jemok= request.getParameter("subject");
String nai= request.getParameter("age");
String content = request.getParameter("content");

System.out.println(irum+" "+jemok+" "+ nai+ " "+ content);

%>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- html영역 -->
작성 이름은 <%=irum %><br/>
제목은 <%=jemok %>
</body>
</html>