package pack6thread;

public class Ex42BreadPlate {
	private int breadCount = 0; // 스레드간 자원공유대상

	public Ex42BreadPlate() {
		// TODO Auto-generated constructor stub
	}

// 현 메소드를 스레드로 호출하면 해당스레드처리가 진행되는 동안 락이 걸린다. 
	public synchronized void makeBread() {
		if (breadCount >= 10) {
			
			try {
				System.out.println("빵 생산 목표 초과(10개 기준)");
				wait(); // 스레드를 not runnable 상태로 만들어준다.
			} catch (Exception e) {
			}

		}
		breadCount++; // 빵을 만듦
		System.out.println("빵 생산 총 수: " + breadCount + "개");
		notify(); // 스레드를 runnable 상태로 복구해준다.
	}

	public synchronized void eatBread() {
		if (breadCount < 1) {
			
			try {
				System.out.println("빵이 없어 기다림");
				wait(); // 스레드를 not runnable 상태로 만들어준다.
			} catch (Exception e) {
			}
		}
		breadCount--; // 빵을 소비
		System.out.println("빵 소비 후 총 수: " + breadCount + "개");
		notify();
	}
}
