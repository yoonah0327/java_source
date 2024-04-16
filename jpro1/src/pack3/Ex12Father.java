package pack3;

// extends 부모클래스를 적음으로써 상속관계맺음
public class Ex12Father extends Ex12GranaFa { // 단일상속만가능

	public String gabo = "꽃병"; // 은닉화
	private int nai = 55;
	private int house = 1;

	public Ex12Father() {
		// super(); 매개변수가 없는 부모생성자호출
		// 생략된것. 기본으로 있다고 전제하고 부모생성자 호출해서 출력한다.
		System.out.println("아버지 생성자");
	}

	public Ex12Father(int n) {
		System.out.println("아버지 생성자라고 해");
	}

	@Override // 에노테이션. 오버라이딩 제대로하는지 체크하는역할. 옵션임.
	public int getNai() {
		return nai;
		}

	public String say() {
		return "아버지 말씀 : 에러잡는 연습을 해라";
	}

	final public String getHouse() { //메소드에 final하면 자식클래스에 오버라이딩불가
		return "집: " + house + "채";
	}// 부모는 주기만가능. 부모는 자식멤버가지고갈수없음.

	public void showData() {
		System.out.println("아버지 나이 " + nai);
		// 블록(지역변수) - 현클래스(멤버변수) - 부모클래스. 
		System.out.println("아버지 나이 " + this.nai);
		// 현클래스 - 부모클래스. 
		System.out.println("아버지 나이 " + getNai());
		// 현클래스 - 부모클래스.
		System.out.println("아버지 나이 " + this.getNai());
		// 현클래스 - 부모클래스. 
		
		
		// System.out.println("할아버지 나이 "+ super.nai); 에러
		System.out.println("할아버지 나이 " + super.getNai());
		// 처음부터 부모클래스.
		System.out.println();
		String gabo = "물병";
		System.out.println("가보 " + gabo);
		// 물병. 현블럭내.
		System.out.println("가보 "+ this.gabo);
		// 꽃병. 현클래스의 멤버필드. 
		System.out.println("가보 " + super.gabo);
		// 상감청자. 부모에게. 
		
		
		
		
		
		
		
		
		
		
		
	}
}
