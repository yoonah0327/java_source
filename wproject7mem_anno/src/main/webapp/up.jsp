<%@page import="pack.business.DataDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="processDao" class="pack.business.ProcessDao"/>
<%
request.setCharacterEncoding("utf-8");
String id= request.getParameter("id");
DataDto dto = processDao.selectPart(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>  회원 수정  </h2>
<form action="upok.jsp" method="post">
	아이디: <%=dto.getId() %> <br>
	<input type="hidden" name="id" value="<%=dto.getId() %>">
	회원명: <input type="text" name="name" value="<%=dto.getName()%>">
	<br>
	비밀번호: <input type="text" name="passwd"><br>
	<input type="submit" value="수정"> 
	<!--넘어가는값 : 아이디 회원명 비번  -->
</form>

</body>
</html>