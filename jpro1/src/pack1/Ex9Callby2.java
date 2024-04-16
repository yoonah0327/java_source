package pack1;

public class Ex9Callby2 {
	// Ex9Callby2클래스안에서 내가 ex()의 형태로 만들어냈기에, 메인메소드에서
	// 이걸 불러내고자 Ex9Callby1 myData = new Ex9Callby1();
	//이 문장을 통해 myData.ex()요렇게 불러내는것. // 코딩 형태에 대한 이해.
	public void ex(int a, int b) { // 매개변수parameter로 기본형사용.
		int imsi = a;
		a = b;
		b = imsi;  //a값을 imsi에, b값을 a에, imsi값을 b에. > 이를통해 a값과 b값을 서로 맞바꾸는것.
		System.out.println("메소드 내의 a:" + a + ",b:" + b);

	}
	
	public void ex(Ex9Callby1 data) { // 매개변수parameter로 참조형사용. : 일반참조형
		int imsi = data.a;
	 data.a = data.b;
	 data.b = imsi; //객체의 주소를 이용해 값 맞바꾸기
System.out.println("메소드(참조형) 내의 a:" + data.a + ",b" + data.b);
	 
	}
	public void ex(int[] ar) { //: 배열참조형
		int imsi = ar[0];
		ar[0]= ar[1];
		ar[1] = imsi;
		System.out.println("메소드 내의 배열요소[0]:" + ar[0] + ",[1]:" + ar[1]);
		
	
	}
}
