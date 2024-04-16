package pack;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		// 응용 프로그램의 시작 메소드(method(행위))
		
		
	int a = 5; // 치환 연산자. 오른쪽의 최종 결과값을 왼쪽 기억장소에 저장하는 연산자. 
	int b = 3;
	int c = a + b;
	System.out.println("c는 " + c); // c는 8
	
	System.out.println("산술 연산자 연습");
	System.out.println(a + b); //8
	System.out.println(a - b); //2
	System.out.println(a * b); //15
	System.out.println(a / b); //1 몫만. 정수연산 
	System.out.println(a % b); //2 나머지만. 정수연산
	System.out.println(a / (double)b); // 몫과 나머지 모두. 실수연산.  
	System.out.println(3 + 4 * 5); //23  // *, /가 +,-보다 우선순위가 높음. 
	System.out.println((3 + 4) * 5); //35 // () 소괄호 내의 연산순위가 가장 높다. 
	
	// System.out.println(a / 0 ); //Exception in thread "main" java.lang.ArithmeticException: / by zero at pack.Test2.main(Test2.java:37) 
	// 정수연산인경우 에러. Exception in thread "main" java.lang.ArithmeticException: / by zero at pack.Test2.main(Test2.java:37)
	System.out.println(a / 0.0 ); //Infinity //실수연산인경우 Infinity(무한대)
	System.out.println(a % 0.0 ); //NaN // 숫자가 아니라 표현할 수 없는 상태 NaN(Not a Number)
	
	System.out.println("문자열 더하기 연산");
	String ss1 = "배가";
	String ss2 = "고파";
	String ss3 = ss1 + ss2;
	System.out.println(ss3); //배가고파
	System.out.println(ss3+ " " + 123); //배가고파 123 //숫자가 문자열로 자동 변환 후 연산
	System.out.println(ss3+ " " + 123 + 100);//배가고파 123100
	System.out.println(ss3+ " " + (123 + 100)); //배가고파 223
	// string ss4 = 5 +6 ; // type mismatch err
	String ss4 = "5" + 6; // 자동형변환
	System.out.println(ss4); //56 
	String ss5 = Integer.toString(5) + 6; //강제형변환. int 기본형 클래스는 Integer(wrapper class)
	System.out.println(ss5); //56 
	String ss6 = Double.toString(5.5) + 6;
	System.out.println(ss6);
	
	System.out.println();
	int abc= 5 + Integer.parseInt("6");
	System.out.println(abc);
	double abc2 = 5 + Double.parseDouble("6.7");
	System.out.println(abc2);
	
	System.out.println();
	//누적
	int no = 1;
	no = no + 1;
	no += 1; // 상동
	no++; // 상동. 후위 증감연산자
	++no; //1+no. 전위 증감연산자
	System.out.println("no : " + no); //5
	
	int imsi = 5;
	int result = ++imsi + 1; // imsi가 계산 전 증가. 6+1이기에 7 
	System.out.println("imsi : " + imsi); //imsi : 6
	System.out.println("result : " + result); //result : 7
	
	int imsi2 = 5;
	int result2 = imsi2++ + 1; // ismi2가 계산 후 1증가. 5+1해서 6결과 넘겨주고, 그다음 imsi2++결과를 6이 됨. 
	// 헷갈리니 전위,후위연산자는 다른 연산자와 함께하는것 지양함. 단독사용권장. 
	System.out.println("imsi2 : " + imsi2); //imsi2 : 6
	System.out.println("result2 : " + result2); //result2 : 6
	// 주의! 증감연산자는 다른 연산자와 함께 쓰지 않도록 권장.
	
	//부호 관련
	int imsi3 = 3;
	System.out.println(imsi3); //3
	System.out.println(-imsi3); //-3
	System.out.println(imsi3*-1); //-3
	
	
	
	
	
	}

}
