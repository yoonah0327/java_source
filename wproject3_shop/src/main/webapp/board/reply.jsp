<%@page import="pack.board.BoardMgr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardMgr" class="pack.board.BoardMgr"/>
<jsp:useBean id="dto" class="pack.board.BoardDto"/>

<%
String num = request.getParameter("num");
String spage = request.getParameter("page");
dto = boardMgr.getReplyData(num);
// getData에 gnum onum이 없어서 따로 또 만들어준다.
//처음만들때 싹 만들고 덜 읽어오는 방법으로 해줘도된다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="../css/board.css">
<script>
function check(){
	if(frm.name.value==""){
		alert("이름을 입력하세요");
		frm.name.focus();
	}else if(frm.pass.value ==""){
		alert("비밀번호를 입력하세요");
		frm.pass.focus();
	}else if(frm.mail.value ==""){
		alert("이메일을 입력하세요");
		frm.mail.focus();
	}else if(frm.title.value ==""){
		alert("제목을 입력하세요");
		frm.title.focus();
	}else if(frm.cont.value ==""){
		alert("내용을 입력하세요");
		frm.cont.focus();
	}else
		frm.submit();
}
</script>
</head>
<body>
<h2 style="text-align: center;">댓글 쓰기</h2>
<form name="frm" method="post" action="replysave.jsp">
<input type="hidden" name="num" value="<%=num %>">
<input type="hidden" name="page" value="<%=spage %>">
<input type="hidden" name="gnum" value="<%=dto.getGnum() %>">
<input type="hidden" name="onum" value="<%=dto.getOnum() %>">
<input type="hidden" name="nested" value="<%=dto.getNested() %>">
<!-- 눈에 보이진 않지만 해당 정보들을 넘겨준다 -->
	<table border="1">
		<tr>
			<td align="center" width="100">이 름</td>
			<td width="430"><input name="name" style="width:99%"></td>
		</tr>
		<tr>
			<td align="center">암 호</td>
			<td><input type="password" name="pass" style="width:99%"></td>
		</tr>
		<tr>
			<td align="center">메 일</td>
			<td><input name="mail" style="width:99%"></td>
		</tr>
		<tr>
			<td align="center">제 목</td>
			<td><input name="title" style="width:99%"
			value="[Re]:<%=dto.getTitle().substring(0,4) %>"></td>
		</tr>
		<tr>
			<td align="center">내 용</td>
			<td><textarea name="cont" rows="10" style="width:99%"></textarea></td>
		</tr> 
		<tr>
			<td colspan="2" align="center" height="30">
				<input type="button" value="작  성" onClick="check()">&nbsp;
				<input type="button" value="목  록"
				  onClick="location.href='boardlist.jsp?page=<%=spage%>'"></td>
		</tr>
	</table>
</form>
</body>
</html>