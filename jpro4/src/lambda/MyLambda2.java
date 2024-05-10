package lambda;

@FunctionalInterface
interface MyInter {
	void aaa();
}

interface MyInterArg { // argument가 있음 
	void bbb(int a, int b);
}

interface MyInterArgReturn { // return 값이 있음
	int ccc(int a, int b);
}

public class MyLambda2 {
	public static void main(String[] args) {
		// 1. 인자가 없는 추상 메소드 정리: 전통적
		MyInter inter = new MyInter() {

			@Override
			public void aaa() {
				System.out.println("익명 클래스의 aaa메소드 오버라이딩");

			}
		}; 
		inter.aaa();
		// 1-1. 람다식으로 표현1
		MyInter inter2 = () -> 
			System.out.println("익명 클래스의 aaa메소드 오버라이딩: 람다");
			; // 명령문이 1개일경우 중괄호 생략가.
		inter2.aaa();
		
		MyInter inter3 = () -> { 
			int imsi = 10;
			System.out.println("람다식으로");
			System.out.println("복수의 명령문 처리");
			System.out.println("imsi: "+ imsi);
		};
		inter3.aaa();
		
	//	2. 인자가 있는 추상 메소드 처리: 전통적
		MyInterArg MyInterArg = new MyInterArg() {
			
			@Override
			public void bbb(int a, int b) {
				System.out.println("두 수의 합은 "+ (a+b));
				
				
			}
		};  
		MyInterArg.bbb(3, 4);
		
		// 2-1. 람다식으로 표현 : arg가 1개일 경우(a)-> 또는 a -> 로 적음
		MyInterArg interaArg2 = (a,b) -> 
		System.out.println("람다로 두 수의 표현은 "+ (a+b));
		interaArg2.bbb(3, 4);
		
		System.out.println("----------");
		
		//3. 인자가 있고 반환값도 있는 추상 메소드 처리 : 전통적
		MyInterArgReturn argReturn = new MyInterArgReturn() {
			
			@Override
			public int ccc(int a, int b) { 
				System.out.println("ccc 처리");
				return a+b;
			}
		};
		int result = argReturn.ccc(5, 6);
		System.out.println("두 수를 더한 결과: "+ result);
		
		//3-1. 람다식으로 표현
		MyInterArgReturn argReturn2 = (m,n) -> (m+n); // return 안 쓰는 경우도 있음
			
		
		MyInterArgReturn argReturn3 = (m,n) -> {
			System.out.println("ccc 수행");
			return m+n;
			
		};
		int result2 = argReturn3.ccc(5, 6);
		System.out.println("두 수를 더한 결과: "+ result2);
	}

}
