package pack3;

public class Ex14HouseDog extends Ex14Dog {
	private String where = "집";

	public Ex14HouseDog(String name) {
		super(name); // 매개변수가 있는 생성자이기에, super안의 변수값을 가지고 부모클래스에 간다.
	}

	public void show() {
		System.out.println("사는 곳: " + where);
	}

	@Override
	public void printMsg() {
		System.out.println(getName() + "~" + where + "에 산다");

	}
}
