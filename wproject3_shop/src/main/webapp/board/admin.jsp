<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="../css/board.css">
<script type="text/javascript">
function check(){
	if(frm.id.value==="" || frm.pwd.value===""){
		alert("아이디, 패스워드를 모두 입력하시오");
		return;
	}
	frm.submit();
}
</script>

</head>
<body>
<form action="adminlogin.jsp" name="frm" method="post">
<table style="width=100%">
<tr>
	<td>
	<%
	String sessionValue= (String)session.getAttribute("adminOk");
	if(sessionValue != null){ //세션값이 있는경우. 이미 로그인한 상황.
	%>
		이미 로그인 했어요😉👍<br><br>
		<a href="adminlogout.jsp">[로그아웃]</a>
		<a href="javascript:window.close()">[창닫기]</a>
	<%	
		
	}else{ //세션값이 없는경우. 로그인하게 유도해야함.
	%>
	<table style="width:100%">
	<tr>
		<td>id: <input type="text" name="id"></td>
	</tr>
	<tr>
		<td>pwd: <input type="text" name="pwd"></td>
	</tr>
	<tr>
		<td>
		<a href="#" onclick="check()">[로그인]</a>
		<a href="javascript:window.close()">[창닫기]</a><!-- window.open으로 열엇기에 그에 알맞게 close로닫음 -->
		</td>
	</tr>
	
	</table>
	
	<%	
	}
	%>
	</td>
</tr>
</table>
</form>

</body>
</html>