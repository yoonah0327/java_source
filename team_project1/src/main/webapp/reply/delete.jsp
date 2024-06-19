<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String reply_no= request.getParameter("reply_no");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script type="text/javascript">
function check(){
	if(frm.pw.value===""){
		frm.pw.focus();
		confirm("비밀번호를 입력하시오");
		return;
	}
	
	if(confirm("정말 삭제할까요?")){
		frm.submit();
	}
}
</script>
</head>
<body>
## 글 삭제 ##
<br>
<form action="deleteok.jsp" method="post" name="frm">
	<input type="hidden" name="reply_no" value="<%=reply_no%>">
	
	비밀번호 입력: <input type="text" name="pw"><p/>
	<input type="button" onclick="check()" value="삭제 확인">
	<input type="button" onclick="view.jsp" value="목록 보기">
</form>
</body>
</html>