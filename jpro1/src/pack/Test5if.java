package pack;

import java.util.Scanner;

public class Test5if {
	public static void main(String[] args) {
		// 조건 판단문 if 연습
		int num = 2;

		// if 문
		if (num >= 3) { // 조건이 참일때만 두 개의 실행문 수행.
			System.out.println("크군요");
			System.out.println("참일 때"); // 조건이 1개일땐 괄호 안써도됨. 첫문장만 유관.
		}
		System.out.println("출력1"); // if문과 무관.
// if-else 문 	
		num = 5;
		if (num < 3) {
			System.out.println("작군요");
			System.out.println("참일 때 수행");
		} else {
			System.out.println("거짓일 때 수행");
		}
		System.out.println("출력2");

		System.out.println("다중 if ----------");
		// if-else if-else 문
		int jumsu = 54; // 스캐너를 써서 값 받아서 변동.
		if (jumsu >= 70) {
			if (jumsu >= 90) {
				System.out.println("우수");
			} else {
				System.out.println("보통");
			}
		} else {
			System.out.println("어라 70점 미만");
			if (jumsu > 50) {
				System.out.println("50점 초과");
			} else {
				System.out.println("50점 미만");
			}
		}
		System.out.println("출력3");

		/// 마지막 조건문은 if 불요.
		jumsu = 35;
		String msg = "";
		if (jumsu >= 90) {
			msg = "수";
		} else if (jumsu >= 80) {
			msg = "우";
		} else if (jumsu >= 70) {
			msg = "미";
		} else if (jumsu >= 60) {
			msg = "양";
		} else {
			msg = "가";
		}
		System.out.println("평가 결과 : " + msg);

		System.out.println();
		// 입장료 : 8세 이하, 65세 이상무료
		// 9세 이상 20세 미만 3000원
		// 20세 이상 65세 미만 5000원
		int age = 35;
		if (8 >= age || age >= 65) {
			System.out.println("0");
		}
		if (9 <= age && age < 20) {
			System.out.println("3000");
		}
		if (20 <= age && age < 65) {
			System.out.println("5000");
		}
		// 위 아래 코드의 값(결과)는 같다. 단 과정이 다른것. 하단의 과정이 더 간결하다.
		System.out.println();
		age = 35;
		int total = 0;
		if (9 <= age && age < 20) {
			total = 3000;
		} else if (20 <= age && age < 65) {
			total = 5000;
		}
		System.out.println(total + "원");

		System.out.println();
		// 문제 : 키보드로 상품명, 수량, 단가를 각각 입력받아 금액(수량*단가)을 출력하시오.
		// 조건 : 금액이 5만원 이상이면 금액에 10%를 아니면 금액에 5%를 세금으로 출력.
		// 출력 모양은 상품명:*** 금액:*** 세금:***
		Scanner sc = new Scanner(System.in); // 기본적인 조건문. 메소드.
		System.out.print("상품명 :"); // sc는 변수명. 내가 암거나 지정하면 되는것.
		String name = sc.next();
		System.out.print("수량 :");
		int many = sc.nextInt(); // int가 붙은건 정수이기에.
		System.out.print("단가 :");
		int cost = sc.nextInt();
		int kumek = many * cost; // 금액값. 이것하나 더 넣어주면 뒤에 굳이 매니*코스트 적을 필요없음. 단순화작업가.

		double tax = 0.0; // 하단의 조건문으로는 모두 다 값을 송출함. 그러나 아닐경우는 출력할 것이 없음. 되도록 0.0 초기값을 주는것이 좋다.
		if (many * cost >= 50000) {
			tax = kumek * 0.1; // 최종적으로 출력할 값들은 총 4. 상품명 수량 단가 세금. 그래서 값만 얻으면 되기에 syso 적을필요 없음.
		} else {
			tax = kumek * 0.05;
		}

		System.out.println("상품명:" + name + " 금액:" + kumek + " 세금:" + tax);
	}
}
