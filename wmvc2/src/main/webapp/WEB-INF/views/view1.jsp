<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
뷰1 결과<br>
예전 방식: <%=request.getAttribute("result") %><br>
EL 사용: ${result }

</body>
</html>