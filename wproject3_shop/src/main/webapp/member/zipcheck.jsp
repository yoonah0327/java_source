<%@page import="pack.member.ZipcodeDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="memberMgr" class="pack.member.MemberMgr"/>

<%
request.setCharacterEncoding("utf-8");
String check = request.getParameter("check"); //y(동 입력화면) or n
String dongName= request.getParameter("dongName");

ArrayList<ZipcodeDto> zlist = memberMgr.zipcodeRead(dongName); 

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/board.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
window.onload= () => {
	document.querySelector("#btnZipFind").onclick = dongCheck;
	document.querySelector("#btnZipClose").onclick = function(){
		window.close();
	};
} 

function dongCheck(){
	if(zipForm.dongName.value ===""){
		alert("검색할 동이름을 입력하시오");
		zipForm.dongName.focus();
		return;
	}
	zipForm.submit();
}
function sendFunc(code, a1, a2, a3, a4){
	//alert(code+a1+a2+a3+a4);
	opener.document.regForm.zipcode.value= code; //window.open으로 주소창이열렸다. register의 폼의 zipcode에 code넣어주기.
	const addr = a1+" "+ a2+ " "+ a3+ " "+ a4;
	opener.document.regForm.address.value= addr; //같은 방법으로 주소도 넣어줌.
	
	window.close(); //주소 검색창 닫기
	
}
</script>
</head>
<body>
<strong>** 우편자료 찾기 **</strong>
<form action="zipcheck.jsp" name="zipForm" method="post">
<table>
<tr>
	<td>
	동 이름 입력: <input type="text" name="dongName" size="30">
	<input type="button" value="검색" id="btnZipFind">
	<input type="button" value="닫기" id="btnZipClose">
	<input type="hidden" name="check" value="n">
	</td>
</tr>
</table>
</form>

<%
if(check.equals("n")){
	if(zlist.isEmpty()){
%>
	<b>검색결과가 없습니다</b>
<%		
	}else{
%>
	<table>
		<tr>
		<td style="text-align:center;">
		검색 자료를 클릭하면 자동으로 주소가 입력됩니다.
		</td>
		</tr>
		
		<tr>
		<td>	
<%	
for(int i=0; i<zlist.size(); i++){ // 검색결과를 뿌리기 위해 for문을 돌린다.
	ZipcodeDto dto= (ZipcodeDto)zlist.get(i); // dto에 담아둔 내용들 불러오기. 
	String zipcode= dto.getZipcode();
	String area1= dto.getArea1();
	String area2= dto.getArea2();
	String area3= dto.getArea3();
	String area4= dto.getArea4();
	if(area4 == null) area4 = ""; //null인경우많아서 그럴경우 공백처리.
%>
<a href="javascript:sendFunc('<%=zipcode %>','<%=area1 %>','<%=area2 %>','<%=area3 %>','<%=area4 %>')"> 
<!--출력물을 하이퍼텍스트작업 -->
<%=zipcode %> <%=area1 %> <%=area2 %> <%=area3 %> <%=area4 %>
</a>
<br>
<%
}
%>
		</td>
		</tr>
	</table>
<%		
	}
}


%>
</body>
</html>