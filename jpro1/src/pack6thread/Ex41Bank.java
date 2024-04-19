package pack6thread;

public class Ex41Bank {
	private int money = 10000; // 프로세스가 가진 자원(스레드 공유 자원)

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
// synchronized: 스레드의 동기화를 가능하게 함/
// 공유자원에 lock이 걸림. 즉 하나의 스레드가 공유자원을 사용하는 동안 다른 스레드는 대기상태.
	public synchronized void inMoney(int mon) { //입금
		int m= this.getMoney();
		try {
			Thread.sleep(2000);  //try catch 불요. 은행입금시 약간의 시간지연 표현해봄. 2초정도 걸리도록. 
		} catch (Exception e) {
			// TODO: handle exception
		}
		setMoney(m+ mon);
	}

	public synchronized void outMoney(int mon) { // 출금
		int m= this.getMoney();
		if(mon> m) {
			System.out.println("잔고액보다 출금액이 많아요");
			return; // 잔금보다 출금이 많은경우 해당문구띄워알려주고 아웃. : 메소드 탈출 //System.exit(0); //응용프로그램 무조건 종료
		}
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		setMoney(m- mon);
	}
}
