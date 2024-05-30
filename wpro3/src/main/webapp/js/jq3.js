$(document).ready(function(){
	$('#id_err').hide(); // 숨기기설정
	$('#age_err1').hide();
	$('#age_err2').hide();
	$('#pwd_err1').hide();
	$('#pwd_err2').hide();
	
 	$('#btnSend').click(function(){
		//입력 자료 오류 검사 후 자료를 서버로 전송
		//id 검사
		let id = $('#userid').val(); //document.queryselector('#userid).value
		//alert(id);
		if(id.length < 2 || isNaN(id)===false){ //2자미만or숫자인경우
			//alert("에러메세지");
			$('#id_err').show();
			return false;
		}else{
			$('#id_err').hide();
		}
		
		//age 검사1- 채우기
		let age = $('#age').val();
		if(age.length < 1 ){ 
			$('#age_err1').show();
			return false;
		}else{
			$('#id_err').hide();
		}
		
		//age 검사2- 숫자만허용
		/*
		for(let i=0;i<age.length; i++){
			let data= age.charAt(i).charCodeAt(0); //1글자씩 추출후 ascii코드값얻기
			//alert(data);
			if(data < 48 || data >57) { //숫자아닌경우
				$('#age_err2').show();
				return false;
			}else{
				$('#age_err2').hide();
			}
		} */
		
		//방법중하나: 사용자 정의 함수 작성후 호출
		/*if(!isPositiveInteger_func(age) || age <15 || age >100){
			$('#age_err2').show();
				return false;
		}else{
				$('#age_err2').hide();
			}*/
			
		//방법중하나: 사용자정의함수(정규표현식 사용) 작성 후 호출
		if(!isValidAge_myfunc(age)){
			$('#age_err2').show();
			return false;
		}else{
			$('#age_err2').hide();
		}
		
		//비밀번호검사
		let pwd1 = $('#pwd1').val();
		if(pwd1.length < 1){
			$('#pwd1').next().show();// next():next sibling을 의미
			return false;
		}else{
			$('#pwd1').next().hide(); //next(),prev()
		}
		
		let pwd2 = $('#pwd2').val();
		if(pwd1!==pwd2){
			$('#pwd_err2').show();
			return false;
		}else{
			$('#pwd_err2').hide();
		}
		
		//form태그에서 입력한 자료를 서버파일로 전송
		$("#signFrm").attr('action','jq3.jsp').attr('method','post').submit();//html에서 속성안주고 여기서 메소드체인형식으로 준다
		
	});
});

function isPositiveInteger_func(){ //사용자정의함수- 내가만든함수
	let num = Number(para);
	return Number.isInteger(num) && num >0;
}

function isValidAge_myfunc(para){ //정규표현식
	let ageRegex= /^(1[5-9]|[2-9][0-9]|100)$/;
	return ageRegex.test(para); //age가 정규표현식과 일치하는지 테스트한 값 반환
}


