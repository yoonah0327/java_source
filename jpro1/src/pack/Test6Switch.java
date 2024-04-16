package pack;

import java.util.Scanner;

public class Test6Switch {

	public static void main(String[] args) {
		// 조건 판단문 switch : 좀 더 정형화된 문법으로 값에 따라 여러 방향으로 분기하는경우 사용
		// 길게 늘어진 if문에 비해 코드가 짧고 의미파악이 쉽다
		int nai = 15;
		nai = nai / 10 * 10; // / 먼저 계산. 몫 먼저 취한뒤, 곱하기 10. 그래서 단자리가 잘림.
		// System.err.println(nai);
		switch (nai) {
		case 20:
			System.err.println("이십대");
			break; // 흘러내려오는 작업에 브레이크를 거는것.
		case 30:
			System.err.println("삼십대");
			System.err.println("만세");
			break; // 자바에서는 마지막은 안 써도 상관무.
		default: // 15, 65 적으면 아무것도 안 찍힘. 디폴트는 그 외를 말하는것.
			System.err.println("기타");
			break;
		}

		System.out.println();
		String jik = "사원";
		switch (jik) { // 스위치문에 문자열이 들어올수있음.
		case "대리":
			System.err.println("대리");
			break;
		case "과장":
			System.err.println("과장 만세");
			break;
		case "부장":
			System.err.println("부장 만세2");
			System.err.println("하하하");
			break;
		default:
			System.out.println("기타 직원");
		}
		
	//----------------------------------------------------------------------------------------------------
		System.out.println();
		System.out.println(Math.random()); // 난수 출력
		// int time = (int) (Math.random() *10); // 값 올려서 0-10사이의 실수 만들어낸뒤, 뒷 소수점들 잘라버리기
		int time = (int) (Math.random() * 4) + 8; // 8-11 사이의 정수 얻기
		System.out.println(time); // 난수는 각 조건문마다 발생하기에 위 코드와 하단의 코드는 서로 영향 안받음. // ex. 0.173... 6

		switch (time) {
		case 8:
			System.out.println("학원가자");
			break;
		case 9:
			System.out.println("인사하자");
			System.out.println("복습하자");
			break; // 9시일때 인사 복습 문제 다 나오게 하고 싶으면 break 지우면 됨.
		case 10:
			System.out.println("문제 풀자");
			break;
		default:
			System.out.println("명상 시간");
		}

		System.out.println();
		// 키보드로 년과 월을 입력받아 해당 년월의 날수 출력
		int year, month, days = 28;
		String msg = "평년";
		
		 Scanner sc= new Scanner(System.in); // 여기서부터
		 System.out.print("년도 :"); 
		 year = sc.nextInt(); 
		 System.out.print("월 :"); 
		 month = sc.nextInt();  //여기까지 주석하든
		 
		//year = 2024;  // 여기서부터
		//month = 8; // year, month, 는 위에 값을 안줘서 밑에 주는것. day 값은 위에 줌.   //여기까지 주석하든
		if (month < 1 || month > 12) {
			System.out.println("월은 1 ~ 12 사이만 허용"); // 입력자료 오류검사
			System.exit(0); // 프로그램의 강제종료
		}
		// 윤년 체크해서 2월에 29
		// 4의 배수이고 100의 배수가 아니거나 400의 배수.
		if(year %4 ==0 && year % 100 != 0 ||  year % 400 == 0 ) { // = : 치환. == : 같다. != : 아니다.
			days= 29;
			msg = "윤년";
		}
		switch(month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				days = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				days = 30;
				break;
			//case 2:
			// break;
		}
		
		System.out.println("결과 : " + year + "년 " + month + "월은 " + days + " " + msg);

	}
}
