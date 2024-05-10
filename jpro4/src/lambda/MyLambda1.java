package lambda;

// Lambda expression: 이름이 없는 익명 함수(메소드)
// 람다 표현식은 함수형 인터페이스의 구현으로만 가용할 수 있다.
// 1개의 추상 메소드를 가져야 하며, 람다표현식은 해당 메소드의 구현으로 동작한다

@FunctionalInterface  // 함수형 인터페이스임을 명시적으로 알림
interface HelloInter { // Lambda expression을 사용할 인터페이스
	int calcData(int a, int b); // 함수형 인터페이스라고 한다. 
	// int calcData2(int a, int b); // 추상메소드는 오직1개여야한다!
}

public class MyLambda1 implements HelloInter {

	public MyLambda1() {
	}

	@Override// 인터페이스의 추상 메소드를 오버라이딩 : 전통적 방법
	public int calcData(int a, int b) {
		return a+b;
	}
//	@Override
//	public int calcData2(int a, int b) {
//		return 0;
//	}

	public static void main(String[] args) {
		MyLambda1 my = new MyLambda1();
		System.out.println(my.calcData(3, 4)); // 전통적인 방법 Legacy. 생성자만들고 오버라이딩해서 값넣어출력
		
		System.out.println();// 인터페이스 변수 = 람다 표현식
		// 람다표현식의 일반적인 구문 : (parameter,,,) -> {body}
		HelloInter inter = (x,y) -> x+y;
		System.out.println(inter.calcData(4, 5)); // 람다 표현식 Lambda
		
		HelloInter inter2 = (x,y) -> x*y;
		System.out.println(inter2.calcData(4, 5)); // 람다 표현식 Lambda2
		
		

	}

}
