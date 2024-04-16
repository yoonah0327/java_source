package pack;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("성공1");
		System.out.println("단축키를 사용하자");
		System.out.print("자바");
		System.out.print("변수");
		System.out.println("연습");
		// 한 줄 주석
		/*
		 여러 줄
		 주석. 실행에 참여 안함
		
		 */
		System.out.println("주석연습"); // 한 줄 주석
		
		System.out.println("---변수 연습-----------");
		// 기본형 : b(불리언)c(캐릭터)bsil(정수)fd(실수) - 값을 변수가 직접 기억
		// 참조형 : 객체 - 객체의 주소를 변수가 기억
		// byte : 하나의 단위로 이루어진 이진 문자(bit)의 집합
		// 8bit로 1byte를 구성하는 것이 일반적
		
		// 숫자형 기억장소 : 변수 선언 방법 -> 타입 변수명
		byte var1; // 1byte 정수 기억장소 -128 ~ 127
		var1 = 3; 
		var1 = 5; //이건 3에 5를 덮어쓴것
		/*
		 자바세계에선 장소가 중요하지 않음. 
		 */
		System.out.println(var1);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		System.out.println("-----");
		short var2 = 123; //2byte 정수 기억장소
		System.out.println(var2);
		
		System.out.println("-----");
		int var3 = 123; //4byte 정수 기억장소
		System.out.println(var3);
		
		System.out.println("-----");
		long var4 = 123; //8byte 정수 기억장소
		var4 = 12345678912345L; //원래 에러나야하는데, 뒤에 L을 붙임으로서 int가 아니라 long이라고 알려주는것.
		System.out.println(var4);

		System.out.println("형변환에 대해 : 자동형변환(promotion), 강제형변환(casting)");
		// 자바에서 정수는 무조건 int로 인정. << 이게 대전제임! 
		short ss = 10; // promotion임
		short ss2 = (short)10; //casting임  // 이 둘은 같은거임. 프로그램은 모방임. 창조하지말고 모방에 더하자. 
		System.out.println(ss + " " + ss2); // 여기서 +는 문자열 더하기 
		//이건 숫자10이 아니라 글자임. RESULT: 10 10. if) ss+ss2 > 10+10으로 숫자 계산해서 20이라고 뜸. 
		short ss3 = (short)50000; //type mismatch에러뜸. 
		// short은 2바이트 확보, 50000는 4바이트임. 근데 (short)를 넣어서 강제로 하면 에러무시하고 그냥 해줘임. 
		System.out.println(ss3);
		
		int imsi = 123;
		// short ss4 = 123;
		short ss4 = (short)imsi;
		System.out.println(ss4);
		 /* 수업의 메인! 
		  * 우리는 123이라는 거 알아서 문제가 없다는걸 알고있다. 그러나 컴터입장에선 s44 범위내(short 2바이트짜리)에선 너무 큰 놈이 들어온 것으로 보기에 노노에러라고 반응. 
		  그래서 강제적으로 (short)를 기입함으로써 실행시킴.
		*/
		
		
		
		
		// 3월 28일 수업.------------------------------------------------------------------------------------------------------------------- 
	/* 자바에서 정수는 int, 실수는 double로 인정
	 * 정수 byte(1byte) short(2byte) char(2byte.유니코드) int(4byte) long(8byte)
	 * 실수(소수점) float(4byte) double(8byte)
	 */
		System.out.println("---------");
		double d1 = 1.2; //1.2 // 8byte 확보.
		d1 = 12.345; //12.345 // 1.2였다가 12.345 덮어씀. "치환" 
		d1 = 12345; //12345.0 // promotion 정수는 실수 기억장소에 기억될 때 실수로 자동 형변환이 일어남.
		System.out.println(d1);
		

		float f1 = 12.3F;// float 4바이트짜리. 12.3 double, 8바이트짜리. 에러발생. 그래서 강제형변환 casting 작업실시.
		float f2 = (float)12.3; 
		System.out.println(f1);
		System.out.println(f2);
		
		// 연산시 큰 타입으로 자동변환!! 
		double result = 4.5+10; // 정수와 실수의 조합임. int는 4바이트, double 은 8바이트. 
		result = 4.5 + (double)10; // 좀더 직관적으로 표시한 것.
		result = (int)4.5 + 10; // 14.0 //실수4.5를 정수로 강제로. 그러면 소수점값 버려지고 4+10이어서 14인데, 실수기억장소인 double에 저장되기에 14.0 
		System.out.println(result); // 14.5
		
		double dd = 5.5; 
		int result2 = (int)(4.5 + 10); // 연산 우선순위임. 오른쪽에서 끝나고 왼쪽으로 넘어가는것. 4.5 + 10하고 그 결과를 정수화. int (14.5) = 14
		result2 = (int)4.5 + (int)dd; // 4 + 5= 9(정수) =>정수기억장소에 넣을수있다. 
		//dd앞에 int 빠지면 typemismatch. (int)4.5 + dd는 에러없는데, 왼쪽 result가 int라서 에러. 
		System.out.println(result2);
		
		System.out.println("지금부터는 논리형(boolean) - 참, 거짓말과기억");
		boolean bu1 = true; //1byte
		bu1 = false;
		System.out.println(bu1);
		
		System.out.println("지금부터는 문자형(char) - Ascii 코드표에 등록된 문자");
		char c1 = 'a'; //	
		/* 작은따옴표, 한글자만 가능.
		 * c1 = 'kbs' 에러. 한글자만 가능. //c1= "a" 에러. 
		 */
		c1 = '7'; // 숫자7아님. 문자임.
		c1 = 'A';
		System.out.println(c1); // A
		System.out.println(c1 + " " + (int)c1 + " " + 65 + " " + (char)65); // A 65 65 A 
		
		System.out.println("안녕" + 13 + "반가워"); // 안녕13반가워
		System.out.println("안녕" + (char)13 + "반가워");
		System.out.println("안녕" + "\n" + "반가워");
		System.out.println("안녕\n반가워"); // 이게 자바 이스케이프(escape) 문자. 
		/* 안녕
		   반가워  */
		System.out.println();
		System.out.println(11 + " " +  0xb + " " + 013); // 11 11 11 // 10진수 16진수 8진수 
		
		System.out.println("\n---문자열 처리-------"); // 한줄띄고 적힘. 
		// String : 창조형 객체이지만 기본형처럼 사용할 수 있도록 자바가 배려. 
		String irum = "홍길동"; // 홍길동 객체의 주소를 irum이란 변수가 기억하는것. 
		System.out.println(irum + "님 만세"); // 홍길동님 만세
		
		System.out.println();
		
		// 상수 : final type 변수명 = 값(리터럴, literal)
		// 리터럴은 데이터(값) 그 자체를 뜻한다. 즉, 변수에 넣는 변하지 않는 데이터를 의미하는 것.
		// 한 번 저장된 값은 수정 불가
		int kbs = 9;
		kbs = 11;   // kbs는 기억장소의 이름. 9에서 11로 덮어씌어짐.  
		/* final int kbs = 9;
		kbs = 11:                // 수정불가. 에러. 
		*/
		System.out.println("kbs : " + kbs); //kbs : 11 // kbs문자열인 Kbs :출력되고 기억장소 kbs의 값이 출력 
		
		final double PI = 3.14;  //fianl 변수 (=상수)는 대문자로 쓰기를 권장.가독성위해.
		System.out.println("pi : " + PI); 
		
		
	}
	
}























