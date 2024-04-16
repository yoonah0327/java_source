package pack3;

public class EX12Me extends Ex12Father {
	final int score = 90; 
	public EX12Me() {
		// super();가 생략되어있음.
		System.out.println("내 생성자");
		// score = 80; 에러. 멤버필드에 final 해서 값수정불가. 
	}
	 
	public void biking() {
		System.out.println("자전거로 전국일주~~~"); 
	}
	/*
	public String getHouse() { //부모에서 final해서 오버라이딩 불가
		return "집";
	}*/

}
// final 
//클래스에 final은 상속불가
//부모에서 final해서 오버라이딩 불가
//멤버필드에 final 해서 값수정불가. 