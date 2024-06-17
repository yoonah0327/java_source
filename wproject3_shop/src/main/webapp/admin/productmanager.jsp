<%@page import="pack.product.ProductDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="productMgr" class="pack.product.ProductMgr"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>
</head>
<body>
전체 상품목록(관리자)<p/>
<%@ include file="admin_top.jsp" %>
<table>
	<tr style="background-color: yellowgreen;">
		<th>번호</th><th>상품명</th><th>가격</th><th>등록일</th><th>재고량</th><th>상세보기</th>
	<%
	ArrayList<ProductDto> plist = productMgr.getproductAll();
	if(plist.size()==0){ //상품재고가 없을수도있다. 없을때
		%>
		<tr>
		<td colspan="6">등록된 상품 없음</td>
		</tr>
		<% 
	}else{//상품재고있으면 배열에서 하나씩 꺼내서 보여주자.
		for(ProductDto p:plist){
		%>
		<tr style="text-align: center;">
		<td><%=p.getNo() %></td>
		<td><%=p.getName() %></td>
		<td><%=p.getPrice() %></td>
		<td><%=p.getSdate() %></td>
		<td><%=p.getStock() %></td>
		<td>
		<a href="javascript:productDetail('<%=p.getNo() %>')">보기</a></td>
		</tr>
		<%	
		}
	}
	%>
	</tr>
	<tr>
		<td colspan="6">
		[<a href="productinsert.jsp">상품 등록</a>]
		<!--  html이아닌 jsp로 만든 이유. 관리자 세션을 이용하고자. @include를 사용하려면 jsp여야하기에.-->
		</td>
	</tr>
</table>
<%@ include file="admin_bottom.jsp" %> 


<form action="productdetail.jsp" name="detailForm" method="get">
<input type="hidden" name="no">




</form>
</body>
</html>