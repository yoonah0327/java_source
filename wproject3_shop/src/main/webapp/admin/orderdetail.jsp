<%@page import="pack.order.OrderBean"%>
<%@page import="pack.order.OrderMgr"%>
<%@page import="pack.product.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="orderMgr" class="pack.order.OrderMgr"></jsp:useBean>
<jsp:useBean id="productMgr" class="pack.product.ProductMgr"></jsp:useBean>

<%
OrderBean order= orderMgr.getOrderDetail(request.getParameter("no"));
ProductDto product = productMgr.getProduct(order.getProduct_no());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 상세 내역</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>
</head>
<body>
<%@ include file="admin_top.jsp" %>

<form action="orderproc_admin.jsp" name="detailFrm" method="post">
<table border="1">
<tr>
	<td>고객 아이디: <%=order.getId() %></td>
	<td>주문 번호: <%=order.getNo() %></td>
	<td>상품 번호: <%=product.getNo() %></td>
	<td>상품명: <%=product.getName() %></td>
</tr>
<tr>
	<td>상품 가격: <%=product.getPrice() %></td>
	<td>주문 수량: <%=order.getQuantity() %></td>
	<td>재고 수량: <%=product.getStock() %></td>
	<td>주 문 일: <%=order.getSdate() %></td>
</tr>
<tr>
<td colspan="5">
	총 결제 금액 : 
	<%=Integer.parseInt(order.getQuantity()) * 
		Integer.parseInt(product.getPrice()) %>
</td>
</tr>
<tr>
<td colspan="4" style="text-align: center;">
주문 상태:
<select name="state">
	<option value="1">접수</option>
 	<option value="2">입금확인</option>
 	<option value="3">배송준비</option>
 	<option value="4">배송중</option>
 	<option value="5">처리완료</option>
</select>
<!--js안에서java는 괜찮다. 그러나 반대는 X. -->
<script type="text/javascript">
	document.detailFrm.state.value= <%=order.getState() %>
</script>
<!-- 각상태별로 떠야한다. 그냥 다 일괄적으로 접수라고 뜨면 안된다. 그래서 자바를 불러서 값을 수정해주는것 -->
</td>
</tr>
<tr>
	<td colspan="4" style="text-align: center;">
	<input type="hidden" name="no" value="<%=order.getNo() %>">
	<input type="hidden" name="flag" >
		<input type="button" value="수 정" onclick="orderUpdate(this.form)">
		<input type="button" value="삭제" onclick="orderDelete(this.form)">
	</td>
</tr>
</table>
</form>
<%@ include file="admin_bottom.jsp" %>
</body>
</html>