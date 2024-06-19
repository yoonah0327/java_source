<%@page import="pack.reply.ReplyDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="replyMgr" class="pack.reply.ReplyMgr"></jsp:useBean>
<%
String reply_no= request.getParameter("reply_no");
ReplyDto dto = ReplyDto.getReply_no(reply_no);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 상세보기</title>
<script type="text/javascript" src="../js/script.js"></script>
</head>
<body>
리뷰 상세보기
<table>
<td style="width:40%">
	<img src="../upload/<%=dto.getReply_image()%>" width="150" />
</td>
<td style="vertical-align: top;">
		<table style="width:100%">
			<tr>
			<td>번호: </td><td><%=dto. %></td>
			</tr>
			<tr>
			<td>상품명: </td><td><%=dto. %></td>
			</tr>
			<tr>
			<td>가격: </td><td><%=dto. %></td>
			</tr>
			<tr>
			<td>등록일: </td><td><%=dto. %></td>
			</tr>
			<tr>
			<td>재고량: </td><td><%=dto. %></td>
			</tr>
		</table>
	</td>
</table>
</body>
</html>