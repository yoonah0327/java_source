<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="bean" class="pack.board.BoardFormBean"/>
<jsp:setProperty property="*" name="bean"/>
<jsp:useBean id="boardMgr" class="pack.board.BoardMgr"/>
<!-- 폼빈에 page없음. page는 넘어오지않음. -->
<%
String spage= request.getParameter("page"); //그래서 추가로 받아줌.

int num = bean.getNum(); //클라이언트가 넘겨준 num받기
int gnum = bean.getGnum();
int onum = bean.getOnum()+1; //댓글이므로 +1
int nested = bean.getNested()+1; //댓글이므로 +1

//같은 그룹내에서 새로운 댓글의 onum보다 크거나 같은 값을 댓글입력전에 먼저수정할것.
//작으면 수정하지 않음.
boardMgr.updateOnum(gnum, onum); //onum 갱신용

//그다음 댓글저장
bean.setOnum(onum);
bean.setNested(nested); // +1씩된결과 bean에 다시 넣어줌
// bip bdate안넘어옴. 
bean.setBip(request.getRemoteAddr());
bean.setBdate();
//boardsave에 있던것도 안넘어옴.
bean.setNum(boardMgr.currentMaxNum()+1); //댓글(새글) 번호(num)
boardMgr.replySave(bean);
response.sendRedirect("boardlist.jsp?page="+spage);
%>

