$(document).ready(function(){
	//html문서를 text로 읽기
	$('#test1').click(function(){
		//alert("a");
		$("#disp").empty(); //출력장소를 비워주고
		//$("#disp").load("jq4.html");//비동기방식. 
	 //html file jq4.html파일의 바디내용을 출력한다.
	 
	 $("#disp").hide().load("jq4.html",function(){
		$(this).fadeIn(); //슬며시천천히결과를 보여준다
	 });
	});
	
	//json읽기1
	$('#test2').click(function(){
		$("#disp").empty();
		
		$.getJSON('jq4json.jsp', function(datas){
			//alert(datas);
			//$("#disp").text(datas);
			
			let items = [];
			let str= "<ul>";
			$.each(datas.sangpum, function(index, data){ //jquery 반복문은 each로 처리한다
				console.log(data);
				//alert(index+ " "+ data);
				
				let s= "<li>" + (index +1) +")"
						+data["code"]+" "+data["sang"]+" "
						+data["su"]+" "+data.dan+"</li>";
				items.push(s);
			});
			str += items.join('')+"</ul>";//배열의 모든 항목을 하나의 문자열로 결합
			$("#disp").html(str);
			
		});
	});
	
	//xml읽기1
	$('#test3').click(function(){
		//alert("--");
		$.get('jq4xml.jsp', function(datas){ //get방식
		//$.post('jq4xml.jsp', function(datas){ //상동.post방식
			//alert(datas);
			//하위element(요소)를 검색할때 find()
			//alert($(datas).find('sangpum').length); //5
			$("#disp").empty();
			
			$(datas).find('sangpum').each(function(){
				let sangpum= $(this);
				let str = "<div>";
				str += sangpum.find('code').text()+" ";
				str += sangpum.find('sangirum').text()+" ";
				str += sangpum.find('su').text()+" ";
				str += sangpum.find('danga').text();
				str += "</div>";
				$("#disp").append(str);
			});
		}).fail(function(){
			$("#disp").text('test3 처리 오류');
		});	
		
	});
	
	//json 읽기2 //제일많이쓰는방법!!!!!!
	$('#test4').click(function(){
		//alert('4');
		$("#disp").empty();
		
		$.ajax({
			type:"get", //요청방식. post.
			url: 'jq4json.jsp',
			//data: {'code':3, 'sang':'book'}, // jq4json.jsp?code=3&sang=book이라는뜻
			dataType:"json", //반환데이터타입. json을 읽을예정이니까.
			success:function(datas){
				//alert(datas);
				let str ="";
				let count =0;
				str += "<table border='1'>";
				str += "<tr><th>코드</th><th>품명</th><th>수량</th><th>단가</th></tr>";
				
				$.each(datas.sangpum, function(idx, data){ //$:jquery
					str += "<tr>";
					str += "<td>" + data["code"]+"</td>";
					str += "<td>" + data["sang"]+"</td>";
					str += "<td>" + data.su+"</td>";
					str += "<td>" + data["dan"]+"</td>";// 이 형태를 더 권장
					str += "</tr>";
					count++;
					
				});
				str += "</table>";
				$("#disp").append(str);
				$("#disp").append(`건수: ${count}개`); //$:js의 string 형식
			}, 
			error:function(){
				$("#disp").text('test4 처리 오류');
			}
			
		});
	});
	
	
	//xml 읽기2
	$('#test5').on("click",function(){
		//alert('5');
		$("#disp").empty();
		
		$.ajax({
			type:"post", //요청방식
			url: 'jq4xml.jsp',
			dataType:"xml", //반환데이터타입.
			success:function(datas){
				//alert(datas);
				let str ="";
				let count =0;
				str += "<table border='1'>";
				str += "<tr><th>코드</th><th>품명</th><th>수량</th><th>단가</th></tr>";
			//--- test4와 여기서부터 달라짐!! ----	
				$(datas).find('sangpum').each(function(){ 
					str += "<tr>";
					str += "<td>" + $(this).find("code").text()+"</td>";
					str += "<td>" + $(this).find("sangirum").text()+"</td>";
					str += "<td>" + $(this).find("su").text()+"</td>";
					str += "<td>" + $(this).find("danga").text();
					str += "</tr>";
					count++;
					
				});
				str += "</table>";
				$("#disp").append(str);
				$("#disp").append(`xml건수: ${count}개`); //$:js의 string 형식
			}, 
			error:function(){
				$("#disp").text('test5 처리 오류');
			}
			
		});
	});
	
	
});
