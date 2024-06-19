<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="bean" class="pack.reply.ReplyBean"/>
<jsp:setProperty property="*" name="bean"/>
<jsp:useBean id="replyMgr" class="pack.reply.ReplyMgr"/>
<%
bean.setReply_ip(request.getRemoteAddr()); //클라이언트의 ipaddress 
bean.setReply_create_date();//클라이언트의 작성날짜등록

int newNo= replyMgr.currentMaxNo()+1; 
bean.setReply_no(newNo);
bean.setReply_gnum(newNo);

replyMgr.saveData(bean); 

//controller 역할
String flag= request.getParameter("flag");
boolean result = false;

if(flag.equals("insert")){ //여기서mgr 컨트롤 
	result = replyMgr.insertReply(request); //클라이언트가 넘겨준 정보를 받는다.
}else if(flag.equals("update")){
	//result = replyMgr.updateReply(request); //클라이언트가 넘겨준 정보를 받는다.
}else if(flag.equals("delete")){
	//result = replyMgr.deleteReply(request.getParameter("no")); //클라이언트가 넘겨준 정보를 받는다.
}else{
	response.sendRedirect("view.jsp");
}

%>