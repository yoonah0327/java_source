package pack3;

	public class Ex13Object {
	// public class Ex13Object extends Object{ 오브젝이 생략된것.
	
	public String toString() {
		// 오버라이딩: 부모의 본래 기능을 자식이 원하는 명령으로 재정의.
		//오
		return "자바여 영원하라";
	}

	public static void main(String[] args) {
		// 최상위 슈퍼클래스 Object
		// 모든 클래스는 자동으로 Object클래스를 상속.-진리
		Ex13Object obj = new Ex13Object();
		System.out.println(obj); // toString이 생략된것.
		System.out.println(obj.toString()); // 주소 찍는메소드.
		//오브젝의 투스트링을 오버라이딩했기에, 주소대신 자바여영원하라가 출력.

	}

}
