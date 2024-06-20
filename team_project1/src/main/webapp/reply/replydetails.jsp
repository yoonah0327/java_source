<%@page import="pack.reply.ReplyDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="replyMgr" class="pack.reply.ReplyMgr"></jsp:useBean>
<jsp:useBean id="dto" class="pack.reply.ReplyDto"></jsp:useBean>
<%
String reply_no= request.getParameter("reply_no");

replyMgr.replyLikecnt(reply_no);
dto = replyMgr.getData(reply_no);

String reply_id = dto.getReply_id();
String reply_create_date = dto.getReply_create_date();
int likecnt= dto.getReply_like_cnt();
String reply_title= dto.getReply_title();
String reply_image = dto.getReply_image();
String reply_cont = dto.getReply_cont();


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 상세보기</title>
</head>
<body>
리뷰 상세보기
<table>
<tr>
	<td colspan ="3" style="text-align: right;">
	<a href="">좋아요</a><a href="">신고하기</a>
	</td>
</tr>
	<tr>
	<td>작성자 id: <a href="<%=reply_id %>"></a></td>
	<td>작성일: <%=reply_create_date %></td>
	<td>좋아요 수: <%=likecnt %></td>
</tr>
<tr>
	 <td colspan="3" >제목: <%=reply_title %></td>
</tr>
<tr>
	<td colspan="3">
	<img src="../upload/<%=reply_image%>" width="150" />
	</td>
</tr>
<tr>
	<td colspan="3">
	<textarea rows= "10" style="width:99%" readonly><%=reply_cont %></textarea>
	</td>
</tr>
<tr>
<td colspan ="3" style="text-align: right;">
	<a href="comment.jsp">
	댓글쓰기</a>
	<a href="edit.jsp">
	수정하기</a>
	<a href="delete.jsp">
	삭제하기</a>
	<a href="view.jsp">
	목록으로</a>
</td>
</tr>

</table>
</body>
</html>