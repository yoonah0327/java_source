package pack3;

public class Ex14WolfDog extends Ex14Dog {
	private String where = "산";

	public Ex14WolfDog(String name) {
		super(name); // 매개변수가 있는 생성자이기에, super안의 변수값을 가지고 부모클래스에 간다.
	}

	public void show() {
		System.out.println("늑대가 사는 곳: " + where + "속");
	}

	@Override
	public void printMsg() {
		System.out.println(getName() + "~" + where + "에 산다(요즘은 동물원)");

	}
	
	public void display() {  //WolfDog 고유메소드
		printMsg();
		this.printMsg();
		super.printMsg();
	}
}
