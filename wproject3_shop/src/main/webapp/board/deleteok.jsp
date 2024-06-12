<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardMgr" class="pack.board.BoardMgr"/>

<%
String spage= request.getParameter("page");
String num= request.getParameter("num");
String pass= request.getParameter("pass");

//비밀번호가 맞아야 수정된글이 저장가능
boolean b = boardMgr.checkPass(Integer.parseInt(num), pass);

if(b) { //true> 삭제
	boardMgr.delData(num);
	response.sendRedirect("boardlist.jsp?page=" + spage);
}else{ //false> 팝업창뜨고, 돌아감.
%>
<script>
	alert("비밀번호 불일치!");
	history.back();
</script>
<%	
}
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>