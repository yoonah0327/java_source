<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="bean" class="pack.board.BoardFormBean"/>
<jsp:setProperty property="*" name="bean"/>
<jsp:useBean id="boardMgr" class="pack.board.BoardMgr"/>

<%
bean.setBip(request.getRemoteAddr());//클라이언트의 ipaddress등록
bean.setBdate(); //클라이언트의 작성날짜등록
int newNum= boardMgr.currentMaxNum()+1; // 현재글수에서 +1을 하여 새번호매기기
bean.setNum(newNum);
bean.setGnum(newNum);

boardMgr.saveData(bean); // 작성내용 빈에 저장

response.sendRedirect("boardlist.jsp?page=1"); //최신글목록으로 돌려보내기
%>