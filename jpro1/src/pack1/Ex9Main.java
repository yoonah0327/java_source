package pack1;

public class Ex9Main {

	public static void main(String[] args) {
		// 메소드 호출 시 매개변수를 통한 자료 전달(타입이 기본형, 참조형(일반, 배열))
		Ex9Callby1 myData = new Ex9Callby1();
		Ex9Callby2 myMethod = new Ex9Callby2();

		System.out.println("원래 a:" + myData.a + ",b:" + myData.b);
		myMethod.ex(myData.a, myData.b); // 인수로 기본형 전달(값이 전달) : Call by Value
		System.out.println("1. 수행 후 a:" + myData.a + ",b:" + myData.b); // 원래값유지. 저장소4개임.

		System.out.println();
		myMethod.ex(myData); // Ex9Callby1 객체 타입의 주소를 전달.
		System.out.println("2. 수행 후 a:" + myData.a + ",b:" + myData.b);
		
		System.out.println();
		System.out.println("배열의 대표명 c : " + myData.c);
//		int kbs[] = myData.c; //주소 치환
//		System.out.println(myData.c[0]);
//		System.out.println(kbs[0]);  // mydata.c의 주소를 kbs에 넘겨서 주소를 같게하고, 값도 같아진다. 
		myMethod.ex(myData.c);
		System.out.println("3. 배열수행 후 a:" + myData.c[0] + ",b:" + myData.c[1]);
	}

}
