<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String memid= (String)session.getAttribute("idKey");
String log="";
if(memid == null){//로그인안한경우
	log = "<a href='../member/login.jsp'>로그인</a>";
}else{
	log = "<a href='../member/logout.jsp'>로그아웃</a>";
}

String mem="";
if(memid == null){//로그인안한경우
	mem = "<a href='../member/register.jsp'>회원가입</a>";
}else{
	mem = "<a href='../member/memberupdate.jsp'>회원수정</a>";
}
%>
<table>
<tr style="background-color: #ffbbcc; text-align: center;">
<td><%=log %></td>
<td><%=mem %></td>
<td><a href="productlist.jsp">상품목록</a></td>
<td><a href="cartlist.jsp">장바구니</a></td>
<td><a href="orderlist.jsp">구매목록</a></td>
<td><a href="../board/boardlist.jsp">게시판</a></td>
</tr>
</table>