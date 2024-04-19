package pack6thread;

public class Ex42BreadMaker extends Thread { // 빵 생산자 //스레드를 상속받아 run메소드를 오버라이딩한다. 소비자도 동일.
	private Ex42BreadPlate plate;

	public Ex42BreadMaker(Ex42BreadPlate plate) {
		this.plate = plate;
	}

	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			plate.makeBread();
		}
	}

}
