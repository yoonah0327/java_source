<%@page import="pack.board.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardMgr" class="pack.board.BoardMgr"/>
<jsp:useBean id="dto" class="pack.board.BoardDto"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="../css/board.css">
<script type="text/javascript"></script>


</head>
<body>
<table>
	<tr>
	<td>
	<a href="../index.html">메인으로</a>&nbsp;
	<a href="boardlist.jsp?page=1">최근목록</a>&nbsp;
	<a href="boardwrite.jsp">새글작성</a>&nbsp;
	<a href="#" onclick="window.open('admim.jsp', '', 'width=300,height=150,top=200,left=300')">관리자용</a>&nbsp;
	<br><br>
	<table style="width:100%">
	<tr style="background-color: silver;">
	<th>번호</th><th>제  목</th><th>작성자</th><th>작성일</th><th>조회수</th>
	</tr>
	<%
	ArrayList<BoardDto> list = boardMgr.getDataAll();
	
	for(int i=0; i<list.size(); i++){
		dto= (BoardDto)list.get(i);
	%>	
	<tr>
	<td><%=dto.getNum() %></td>
	<td><%=dto.getTitle() %></td>
	<td><%=dto.getName() %></td>
	<td><%=dto.getBdate() %></td>
	<td><%=dto.getReadcnt() %></td>
	
	
	</tr>
	
	<%
	}
	%>
	
	</table>
	</td>
	</tr>
</table>
</body>
</html>