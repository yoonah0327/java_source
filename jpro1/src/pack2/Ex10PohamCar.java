package pack2;

public class Ex10PohamCar { // Ex10PohamCar 클래스
	// 여러개의 부품이 모인 완성차 설계도
	int speed = 0;
	String ownerName, turnMessageShow; // 멤버필드들
	Ex10PohamHandle handle; // 클래스를 멤버로 부름. 부품클래스를 자신의 멤버처럼 사용
	//스피드 오너네임 메시지 핸들 모두 객체변수.

	public Ex10PohamCar() { // 객체가안만들어졌으므로 handle 못씀
	}

	public Ex10PohamCar(String name) {
		ownerName = name;
		handle = new Ex10PohamHandle(); // 클래스의 포함관계(has a 관계)
		// 객체가만들어졌으므로 handle 씀
	}

	public void playCarTurnHandle(int q) { // q: 핸들 회전량
		if (q > 0) {
			turnMessageShow = handle.ReftTurn(q);
		}
		if (q < 0) {
			turnMessageShow = handle.leftTurn(q);
		}
		if (q==0) {
			turnMessageShow = handle.straight(q);
		}
	}
}
