package pack1;

public class Ex2Main {

	public static void main(String[] args) {
		// getter, setter 연습
		System.out.println("프로그램을 실행하다가..");

		// Ex2Car 객체 만들기
		System.out.println();
		Ex2Car tom = new Ex2Car();
		tom.showData();
		System.out.println("이름은 " + tom.irum);
		tom.irum = "미스터 톰";  //private이 아니므로 접근이 가능.  
		System.out.println("이름은 " + tom.irum);
		
		System.out.println("겟터, 셋터 확인");
		//tom.speed = 80; // private이므로 접근 불가. ExClass2내에서만 가. 보안강화용. 
		tom.setSpeed(80,123); //80을 Ex2Car 클래스의 int s에 넣어서, 스피드의 값을 80을. 
		tom.showData();  // 그래서 비번자리에 111넣으면, 속도값이 10 나오고. 제대로 123넣으면, 80 값 나온다. 
		// 예를들어 비밀번호에 의해 수정결정. 비번부분은 플러스알파. 신경ㄴㄴ.
		// System.out.println("속도는 " + tom.speed); // 실행안됨. speed는 퍼블릭이라. 
		
		System.out.println("속도는 " + tom.getSpeed());
		int result = tom.getSpeed();
		System.out.println("속도는 " + result);
		
	}

}
