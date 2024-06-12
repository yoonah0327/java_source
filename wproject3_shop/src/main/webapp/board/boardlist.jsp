<%@page import="pack.board.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardMgr" class="pack.board.BoardMgr"/>
<jsp:useBean id="dto" class="pack.board.BoardDto"/>

<%
int spage =1, pageSu=0;
int star, end; // 페이지블럭소스코도. https://cafe.daum.net/flowlife/HqLp/13 코드참조


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="../css/board.css">
<script type="text/javascript">
window.onload = () => { // 글제목, 작성자를 찾는 검색버튼 함수
	document.querySelector("#btnSearch").onclick = function(){
		if(frm.sword.value === ""){
			frm.sword.focus();
			frm.sword.placeholder = "검색어를 입력하세요";
			return;
		}
		frm.submit();
	}
}
</script>
</head>
<body>
<table> <!-- 상단의 메뉴 테이블 -->
	<tr>
	<td>
	<a href="../index.html">메인으로</a>&nbsp;
	<a href="boardlist.jsp?page=1">최근목록</a>&nbsp;
	<!-- 가장 최근목록을 보여주어야하기에 페이지쪽수까지 지정.-->
	<a href="boardwrite.jsp">새글작성</a>&nbsp;
	<a href="#" onclick="window.open('admin.jsp', '', 'width=300,height=150,top=200,left=300')">관리자용</a>&nbsp;
	<br><br>
	<table style="width:100%">
	<tr style="background-color: silver;">
	<th>번호</th><th>제  목</th><th>작성자</th><th>작성일</th><th>조회수</th>
	</tr>
	<%
	try{
		spage= Integer.parseInt(request.getParameter("page"));
	}catch(Exception e){
		spage=1;
	}
	if(spage<=0) spage=1;
	
	//검색
	String stype= request.getParameter("stype");
	String sword= request.getParameter("sword");
	
	// 페이징처리
	boardMgr.totalList(); //전체레코드수 계산
	pageSu = boardMgr.getPageSu(); //전체페이지수 얻기
	
	//ArrayList<BoardDto> list = boardMgr.getDataAll(spage); //페이징처리만
	ArrayList<BoardDto> list = boardMgr.getDataAll(spage, stype, sword); //페이징처리랑 검색처리
	
	for(int i=0; i<list.size(); i++){
		dto= (BoardDto)list.get(i);
		
		// 댓글 들여쓰기
		int nst= dto.getNested();
		String tab = "";
		for(int b=0; b<nst; b++){
			tab += "&nbsp;&nbsp;";
		}
		
	
	%>	
	<tr>
	<td><%=dto.getNum() %></td>
	<td><!-- 댓글1개마다 2칸공백. 대댓글이면 4칸공백. -->
	<%=tab %><a href="boardcontent.jsp?num=<%=dto.getNum() %>&page=<%=spage %>"><%=dto.getTitle() %></a> 
	</td> <!-- 해당 게시글이 있던 페이지로 돌아와야하기에, 해당 페이지값도 같이 가지고간다 -->
	<td><%=dto.getName() %></td>
	<td><%=dto.getBdate() %></td>
	<td><%=dto.getReadcnt() %></td>
	</tr>
	<%
	}
	%>
	</table>
	<br>
	<table style="width: 100%">
	<tr>
	<td style="text-align: center;">
	<%
	for(int i=1; i <= pageSu; i++){
		if(i==spage){ //선택페이지. 캡쳐화면에선 [1]
			out.print("<b style='font-size:12pt;color:red'>[" +i + "]</b>");
		}else{ //선택되지 않은 페이지. 캡쳐화면에선 [2][3]
			out.print("<a href='boardlist.jsp?page=" +i + "'>[" +i + "]</a>");
			
		}
		
	}
	%>		
	<br><br>
	<form action="boardlist.jsp" name="frm" method="get">
		<select name="stype">
		<option value="title" selected="selected">글제목</option>
		<option value="name">작성자</option>
		</select>
		<input type="text" name="sword">
		<input type="button" value="검색" id="btnSearch">
	</form>
	</td>
	</tr>
	</table>
	</td>
	</tr>
</table>
</body>
</html>