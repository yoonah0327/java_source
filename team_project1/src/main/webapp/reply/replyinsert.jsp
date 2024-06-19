<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰작성</title>
<link rel="stylesheet" type="text/css" href="../css/star_rating.css">
<script>
function check(){
	if(frm.reply_cont.value==""){
		confirm("리뷰내용을 작성해주세요");
		frm.reply_cont.focus();	
	}
	frm.submit();
}

</script>
</head>
<body>
<form action="replyproc.jsp?flag=insert"  name="frm" method="post" enctype="multipart/form-data">
<h2>리뷰 작성하기</h2>
책 평점주기
<div class ="star_rating">
  	<input type="radio" class="star" value="1">
    <input type="radio" class="star" value="2">
    <input type="radio" class="star" value="3">
    <input type="radio" class="star" value="4">
    <input type="radio" class="star" value="5">
    <!-- 라디오버튼5개 별모양으로. 마우스오버로 빈별>색칠된별 전환. 클릭시 고정. -->
</div>
<br>
리뷰 제목<br>
<input type="text" name="reply_title">
<br><br>
리뷰 내용<br>
 <textarea rows="10" name="reply_cont" placeholder="리뷰 내용을 작성해주세요." ></textarea> 
<br><br>
인증사진 : <input type="file" name="image"><br>
<br><br>
<input type="button" class="btnOk" value="리뷰등록" onClick="check()"/>
<input type="button"  value="목록으로"  onClick="location.href='view.jsp'"/> 
  
</form>
</body>
</html>