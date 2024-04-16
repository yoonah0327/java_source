package pack3;
// 상속 : 한 클래스가 다른 클래스를 포함하는 상위 개념일때

// 두 클래스 사이에 일반화 관계가 있다. 이런 일반화 관계를 상속관계(is a kind of 관계)라 칭한다.
// 클래스간 부모자식의 구조를 갖는다. 부모클래스는 자식클래스의 멤버를 제공하는 틀역할을 한다.

// final public class Ex12GranaFa { // 클래스에 final은 상속불가
	public class Ex12GranaFa { // 클래스에 final은 상속불가
	private int nai = 80;
	public String gabo = "상감청자";
	protected String gahun = "자바 모르면 인간도 아니다";
	// 패키지. 부모관계 클래스. 에서의 사용여부 //protected 등 접근지정자 사용가능 체크하기

	public Ex12GranaFa() {
		System.out.println("할아버지 생성자");
	}
	public Ex12GranaFa(int nai) {
		this();
		this.nai = nai;   
	}

	public String say() {
		return "할아버지 말씀 : 자기주도학습!";
	}
	public void eat() {
		System.out.println("밥은 맛있게...");
	}
	public int getNai() { //Method Overriding.
		return nai;
	}
}
