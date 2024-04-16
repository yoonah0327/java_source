package pack1;

public class Ex6Main {

	public static void main(String[] args) {
		// 같은 패키지에 있는 Ex6Bank클래스를 사용 //앞서하던것처럼
		Ex6Bank kildong = new Ex6Bank();
		kildong.dePosit(5000);
		kildong.withDraw(2000);
		System.out.println("kildong 예금액 : " + kildong.getMoney());

		//kildong.money(); //에러: money는 프라이빗멤버이므로 해당 클래스에서만 참조.
		System.out.println("a:" + kildong.a ); //default. 가.
		System.out.println("b:" + kildong.b ); //public. 가.
		
		System.out.println();
		Ex6Bank dajeong = new Ex6Bank(2000);
		dajeong.dePosit(5000);
		dajeong.withDraw(12000);
		dajeong.withDraw(2000);
		System.out.println("dajeong 예금액 : " + dajeong.getMoney());

		System.out.println("객체 주소 관련 ---------------");
		System.out.println("kildong 주소 : " + kildong + " " + kildong.hashCode()); // 16진수 10진수
		System.out.println("dajeong 주소 : " + dajeong + " " + dajeong.hashCode()); // 16진수 10진수

		Ex6Bank tom = null; // Ex6Bank tom;과 같음
		System.out.println("tom 주소 : " + tom);
		// System.out.println("tom 예금액 : " + tom.getMoney());
		// syntax(문법)상 에러아님.
		// NullPointerException 값이없움.
		tom = dajeong; // 주소 치환. 참조형이기에. 기본형이라면 값을 치환한다.
		System.out.println("tom 예금액 : " + tom.getMoney());

		if (dajeong == tom) {
			System.out.println("둘은 같은 주소");
		} else {
			System.out.println("둘은 다른 주소");
		}

		if (dajeong == kildong) { // 객체변수의 ==는 주소 비교. 기본변수의 ==는 값비교
			System.out.println("둘은 같은 주소임을 알림");
		} else {
			System.out.println("둘은 다른 주소야~~");
		}

		if (dajeong instanceof Ex6Bank) {
			// instanceof : 객체 타입 비교 연산자
			System.out.println("Ex6Bank 타입이 맞아요");
		} else {
			System.out.println("ㅠㅠ Ex6Bank 타입이 아니군요");
		}

		System.out.println("\n스트링(String)타입의 값 비교-----------");
		String ss1 = "kor"; // String 클래스 : 기본형처럼 사용가능하도록 자바배려.
		String ss2 = new String();
		ss2 = "kor"; // kor이 literal pool에 저장되고, ss2는 그 주소를 같이 참조. pool : 공유
		String ss3 = new String("kor"); // heap에 만들어짐. new로 ss4, ss5 만들어도 heap에 또만들어짐.

		System.out.println(ss1 + " " + ss2 + " " + ss3);

		if (ss1 == ss2)
			System.out.println("같음1");
		else
			System.out.println("다름1");

		if (ss1 == ss3)
			System.out.println("같음2");
		else
			System.out.println("다름2");

		// 그러므로 String은 주소 비교가 아니라 갑을 비교하는것이 목적이므로 equals() 사용
		if (ss1.equals(ss2)) // 값 비교
			System.out.println("같음3");
		else
			System.out.println("다름3");

		if (ss1.equals(ss3)) // 값 비교
			System.out.println("같음4");
		else
			System.out.println("다름4");

		if (ss1.equalsIgnoreCase(ss3)) // 값 비교 (영문 대소문자 구분 안함)
			System.out.println("같음5");
		else
			System.out.println("다름5");

	}
}
