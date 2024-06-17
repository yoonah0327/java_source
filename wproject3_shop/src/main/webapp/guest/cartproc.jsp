<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cartMgr" class="pack.order.CartMgr" scope="session"/>
<!-- 램상에만존재만하는것. 카트엠쥐알은 세션이 살아있는동안 유효한다. -->
<jsp:useBean id="order" class="pack.order.OrderBean"/>
<jsp:setProperty property="*" name="order"/>

<%
String orderFlag = request.getParameter("flag"); //구매목록 보기, 수정, 삭제판단용
String id = (String)session.getAttribute("idKey");

out.print(order.getProduct_no() + ", 주문수량: "+ order.getQuantity());
%>