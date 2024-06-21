<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" 
    %>
    <!--isELIgnored="false": 기본값. el무시할건지? 아니오. el인식  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>EL 연산자 / 내장객체 경험</h2>
--- 연산자 --- <br>
\${3 + 4} ==>  ${3 + 4}<br><!-- \를통해 글자그대로 출력하게했다. -->
\${5 / 4} ==>  ${5 / 4}<br> <!--  ${5 div 4 } --> 
\${5 % 4} ==>  ${5 % 4}, ${5 mod 4 }<br>

\${5 > 4} ==> ${5 > 4}, ${5 gt 4}, ${5 lt 4 }<br>
\${5 >= 4} ==> ${5 >= 4}, ${5 ge 4}, ${5 le 4 }<br>

\${5 > 4 and 3 > 2} ==> ${5 > 4 and 3 > 2},${5 > 4 or 3 > 2} <br><!-- 관계연산자 -->
<!-- 삼항연산자 -->
\${5 >= 4?10:10+5} ==> ${5 >= 4?10:10+5}

<hr>
-- 내장객체-- <br>
<%
request.setAttribute("aa", "air");
session.setAttribute("bb", "burger");
application.setAttribute("cc", "cat");
%>
* 생존범위 관련 내장객체 출력 * <br>
jsp: <%=request.getAttribute("aa") %> EL: ${requestScope.aa }, ${aa }<br>
jsp: <%=session.getAttribute("bb") %> EL: ${sessionScope.bb }<br>
jsp: <%=application.getAttribute("cc") %> EL: ${applicationScope.cc }<br>
<br>
jsp의 header : <%=request.getHeader("host") %><br>
EL의 header : ${header.host}, ${header["host"]}<br>
<br>
* 컬렉션 객체 값 출력 * <br>
<%
ArrayList<String> list = new ArrayList<>();
list.add("치킨버거");
list.add("새우버거");
list.add("불고기 버거");
request.setAttribute("list", list);

ArrayList<String> list2= new ArrayList<>();
list2= (ArrayList)request.getAttribute("list");
out.println(list2.get(1));
%>
<br>
EL로 출력: ${list[0]}, ${list[1]}
<br><br>
-- HTML문서자료 받기-- <p/>
<a href="el_2.html">el_2 html 호출</a><br>
이름: ${param.irum } ${param["irum"] }<br><!-- 단일값이어서 param. -->
성격: ${paramValues.sung[0]} -- ${paramValues.sung["1"]}<!-- 배열이어서 paramValues[] -->

</body>
</html>