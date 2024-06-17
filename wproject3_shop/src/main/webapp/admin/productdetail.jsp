<%@page import="pack.product.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="productMgr" class="pack.product.ProductMgr"/>
<%
String no= request.getParameter("no"); 
ProductDto dto = productMgr.getProduct(no); 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>
</head>
<body>
^^ 상품 상세보기 ^^<p/><!-- 관리자로그인안되면 접근못하도록 @include 넣어준다. 그래서jsp파일씀. NOT html. -->
<%@ include file="admin_top.jsp" %>
<table>
<tr>
	<td style="width:20%">
	<img src="../upload/<%=dto.getImage() %>" width="150" />
	</td>
	<td style="vertical-align: top;">
		<table style="width:100%">
			<tr>
			<td>번호: </td><td><%=dto.getNo() %></td>
			</tr>
			<tr>
			<td>상품명: </td><td><%=dto.getName() %></td>
			</tr>
			<tr>
			<td>가격: </td><td><%=dto.getPrice() %></td>
			</tr>
			<tr>
			<td>등록일: </td><td><%=dto.getSdate() %></td>
			</tr>
			<tr>
			<td>재고량: </td><td><%=dto.getStock() %></td>
			</tr>
		</table>
	
	
	</td>
	<td style="width=30%">
	<b>* 상품 설명 *</b>
	<br>
	<%=dto.getDetail() %>
	</td>
</tr>
<tr>
	<td colspan="3" style="text-align: center;">
	<a href="javascript:productUpdate('<%=dto.getNo() %>')">수정하기</a>
	<a href="javascript:productDelete('<%=dto.getNo() %>')">삭제하기</a>
	</td>
</tr>
</table>
<%@ include file="admin_bottom.jsp" %> 

<form action="productupdate.jsp" name="updateForm" method="post">
<input type="hidden" name="no">
</form>

<form action="productproc.jsp?flag=delete" name="delForm" method="post">
<input type="hidden" name="no"><!-- get로 하니 500. 플래그가 넘어가지 않고 name만 넘어간다.-->
</form>

</body>
</html>