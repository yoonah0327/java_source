package pack2;

public class Ex10PohamHandle { //부품클래스
	int quantity; // 회전량

	private void Ex10PohamHandle() {
		quantity = 0;
	}

	String leftTurn(int q) {
		quantity = q;
		return "좌회전";
	}

	String ReftTurn(int quantity) {
		this.quantity = quantity;
		return "우회전";
	}

	String straight(int quantity) {
		this.quantity = quantity;
		return "직진";
	}
}
