<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="productMgr" class="pack.product.ProductMgr"/>
<%
request.setCharacterEncoding("utf-8");

//controller 역할
String flag= request.getParameter("flag");
boolean result = false;

if(flag.equals("insert")){
	result = productMgr.insertProduct(request); //클라이언트가 넘겨준 정보를 받는다.
}else if(flag.equals("update")){
	//result = productMgr.updateProduct(request); //클라이언트가 넘겨준 정보를 받는다.
}else if(flag.equals("delete")){
	//result = productMgr.deleteProduct(request); //클라이언트가 넘겨준 정보를 받는다.
}else{
	response.sendRedirect("productmanager.jsp");
}

if(result){ //리절트 트루. 즉, 인서트 업데이트 딜리트 성공한경우
	%>
	<script>
	alert("정상처리되었습니다.");
	location.href="productmanager.jsp";
	</script>
	<%
}else{
	%>
	<script>
	alert("오류가 발생했습니다.");
	location.href="productmanager.jsp";
	</script>
	<%
}
%>

