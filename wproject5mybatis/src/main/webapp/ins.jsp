<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="form" class="pack.business.DataForm"/>
<jsp:setProperty property="*" name="form"/>
<jsp:useBean id="processDao" class="pack.business.ProcessDao"/>

<%
processDao.insData(form);
response.sendRedirect("list.jsp");// 리다이랙트vs포워드. 여기선 리다이랙트해야함. 안그러면 자료 계속 들어감.
%>