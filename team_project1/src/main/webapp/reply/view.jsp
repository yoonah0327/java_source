<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pack.reply.ReplyDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="replyMgr" class="pack.reply.ReplyMgr"/>
<jsp:useBean id="dto" class="pack.reply.ReplyDto"/>

<%
int bno =1; //책번호
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
</head>
<body>
책 상세정보
<table border="1">
  <tr>
    <td rowspan='2'>책 이미지넣기</td>
    <td>책내용넣기 주루룩</td>
  </tr>
  <tr>
    <td>평균평점 /  리뷰수</td>
  </tr>
  <tr>
	<td colspan="2" align="right" height="30">
		<input type="button" value=" 리뷰 작성" onClick="location.href='replyinsert.jsp'">
		<!-- 화면전환을 해주어서 작성페이지로 넘어가게해야한다. -->
			</td>
		</tr>
</table>

<table style="width:80%">
	<tr style="background-color: beige;">
	<th>번호</th><th>제목</th><th>작성자id</th><th>작성일</th><th>좋아요 수</th>
	</tr>
	<%
	//책 상세페이지보여줄때 url에 책 넘버가 적히게 된다. url접근 방법제한두기
	try{
		bno= Integer.parseInt(request.getParameter("reply_book_no"));
	}catch(Exception e){
		bno=1;
	}
	if(bno<=0) bno=1;
	
	
ArrayList<ReplyDto> list = replyMgr.getDataAll(bno);

for(int i=0; i<list.size(); i++){
	dto= (ReplyDto)list.get(i);
	
%>	
<tr style="text-align: center;">
<td><%=dto.getReply_no()%></td>
<td><!-- ?reply_no=<%=dto.getReply_no()%>&reply_book_no=<%=dto.getReply_book_no()%> -->
<a href="replydetails.jsp">
			<%=dto.getReply_title() %></a>
</td> 
<td><%=dto.getReply_id() %></td>
<td><%=dto.getReply_create_date() %></td>
<td><%=dto.getReply_like_cnt() %></td>
</tr>
<%
}
%>	
</table>
</body>
</html>