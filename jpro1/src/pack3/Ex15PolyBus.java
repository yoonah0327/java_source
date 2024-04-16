package pack3;

public class Ex15PolyBus extends Ex15PolyCar {
	private int passenger = 10;

	public void show() { // 부모car는 없는 자식bus만 있는 Ex15PolyBus의 고유메소드
		System.out.println("버스");
	}

	@Override // Annotation, 메타데이터: 컴파일러에 다양한 정보를 알려주는 역할.
	public void displaySpeed() {
		// super.displaySpeed(); 대전제. 무의미.
		System.out.println("버스 승객 수는 " + passenger);
		System.out.println("버스 속도는 " + speed);

	}

}
