$(document).ready(function(){
	$("#btnSearch").click(function(){
		$("#show").empty();
		$("#showCount").empty();
		
		let bname = $("#bname").val();
		
		$.ajax({
			type: "get",
			url: "jq6.jsp",
			data: { "bname":bname },
			dataType: "json",
			success: function(datas) {
				let str = "<table border='1'>";
				str += "<tr><th>사번</th><th>직원명</th><th>직급</th><th>관리고객</th></tr>";
				let count = 0;
				$.each(datas,function(idx, entry){
					str += "<tr>";
					str += "<td>"+ entry["jikwon_no"]+ "</td>";
					if(entry["jikwon_gogek"] <= 0){
						str += "<td>"+ entry["jikwon_name"]+ "</td>";	
					}else{
						str += "<td><a href='javascript:func("  
							+entry["jikwon_no"]+ ")'>"
							+entry["jikwon_name"] + "</a></td>";
					}
					str += "<td>"+ entry["jikwon_jik"]+ "</td>";
					str += "<td>"+ entry["jikwon_gogek"];
					str += "</tr>";
					count++;
				});
				str += "</table>";
				$("#show").append(str);
				$("#showCount").append(count);
			}, 
				error: function(){
					$("#show").text("에러: "+ status);
				}
		
	});
	});
	
});

function func(para){
	//alert(para); // 영업부 김이화사원(6번)을 누를경우, 6이 뜬다
	$("#gogek").empty();
	
	$.ajax({
			type: "get",
			url: "jq6gogek.jsp",
			data: { "arg":para },
			dataType: "json",
			success: function(datas) {
				let str = "<table border='1'>";
				str += "<tr><th>고객명</th><th>고객번호</th></tr>";
				let count = 0;
				$.each(datas,function(idx, entry){
					str += "<tr>";
					str += "<td>"+ entry["gogek_name"]+ "</td>";
					str += "<td>"+ entry["gogek_tel"]+ "</td>";
					str += "</tr>";
					count++;
				});
				str += "</table>";
				$("#gogek").append(str);
			}, 
				error: function(){
					$("#gogek").text("func에러: "+ status);
				}
		
	});
	
}


