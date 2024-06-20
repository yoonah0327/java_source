<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="bean" class="pack.reply.ReplyBean"/>
<jsp:setProperty property="*" name="bean"/>
<jsp:useBean id="replyMgr" class="pack.reply.ReplyMgr"/>

<%
String reply_no= request.getParameter("reply_no");
String reply_book_no= request.getParameter("reply_book_no");

//비밀번호부분..??조건...?
	replyMgr.saveEdit(bean);
	response.sendRedirect("view.jsp?page=" + reply_book_no);
%> 
