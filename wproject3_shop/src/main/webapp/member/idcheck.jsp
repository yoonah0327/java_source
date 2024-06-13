<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="memberMgr" class="pack.member.MemberMgr"/>

<%
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
boolean b = memberMgr.idCheckProcess(id);

%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID검사</title>
<link href="../css/board.css" rel="stylesheet" type="text/css">
<script src="../js/script.js"></script>

</head>
<body style="text=align: center; margin-top: 30px">
<b><%=id %></b>
<%
if(b){
%>
: 이미 사용중인 id입니다. <p/> <!-- 닫기링크누르면 아이디칸으로 커서이동해주고 창닫아주자 -->
<a href="#" onclick="opener.document.regForm.id.focus();window.close()">닫기</a>
<%
}else{
%>
: 사용 가능한 id입니다. <p/> <!-- 여기는 바로 비번쪽으로 커서이동해주고 닫기 -->
<a href="#" onclick="opener.document.regForm.passwd.focus();window.close()">닫기</a>
<%	
}
%>
</body>
</html>