<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cartMgr" class="pack.order.CartMgr" scope="session"/>
<!-- 램상에만존재만하는것. 카트엠쥐알은 세션이 살아있는동안 유효한다. -->
<jsp:useBean id="order" class="pack.order.OrderBean"/>
<jsp:setProperty property="*" name="order"/>

<%
String orderFlag = request.getParameter("flag"); //구매목록 보기, 수정, 삭제판단용
String id = (String)session.getAttribute("idKey");

//out.print(order.getProduct_no() + ", 주문수량: "+ order.getQuantity());

if(id== null){
	response.sendRedirect("../member/login.jsp");// 회원로그인안한경우 다시보내주기.
}else{ //로그인했다면~
	if(orderFlag== null){//cart에 주문 상품 담기
		order.setId(id); //order:id, quantity, product_no
		cartMgr.addCart(order);
%>
	<script>
	alert("장바구니에 담았습니다");
	location.href="cartlist.jsp"; //카트에 등록된 주문상품 목록보기
	</script>
<%		
		
	}else if(orderFlag.equals("update")){
		order.setId(id);
		cartMgr.updateCart(order);
%>		
		<script>
		alert("장바구니 상품을 수정했습니다");
		location.href="cartlist.jsp"; //카트에 등록된 주문상품 목록보기
		</script>
<%	
	}else if(orderFlag.equals("del")){
		cartMgr.deleteCart(order);		
%>
		<script>
		alert("해당 상품 주문 삭제했습니다");
		location.href="cartlist.jsp"; //카트에 등록된 주문상품 목록보기
		</script>
	<%	
	}
}
%>