<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="replyMgr" class="pack.reply.ReplyMgr"></jsp:useBean>
<jsp:useBean id="dto" class="pack.reply.ReplyDto"></jsp:useBean>
<%
String reply_no= request.getParameter("reply_no");
String reply_book_no= request.getParameter("reply_book_no");

dto= replyMgr.getData(reply_no); //수정할 자료 읽기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
<script type="text/javascript">
window.onload =() =>{
	document.querySelector("#btnUpOk").onclick = function(){
	if(confirm("정말 수정하시겠습니까?"))
		frm.submit();
	}
}


</script>
</head>
<body>
<h2 style="text-align: center;">리뷰수정하기</h2>
<form action="editsave.jsp" method="post" name="frm">
<input type="hidden" name="reply_no" value="<%=reply_no %>">
<input type="hidden" name="reply_book_no" value="<%=reply_book_no %>">
리뷰 수정하기
<div class ="star_rating">
  	<input type="radio" class="star" value="1">
    <input type="radio" class="star" value="2">
    <input type="radio" class="star" value="3">
    <input type="radio" class="star" value="4">
    <input type="radio" class="star" value="5">
</div>
<br>
리뷰 제목<br>
<input type="text" name="reply_title" value="<%=dto.getReply_title() %>>">
<br><br>
리뷰 내용<br>
 <textarea rows="10" name="reply_cont"><%=dto.getReply_cont() %></textarea> 
<br><br>
인증사진 : <input type="file" name="image" value="<%=dto.getReply_image()%>"><br>

<input type="button" value="수정 완료" id="btnUpOk">&nbsp;&nbsp;
<input type="button" value="목록 보기" onclick="location.href='view.jsp'">
</form>
</body>
</html>