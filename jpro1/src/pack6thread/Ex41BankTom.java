package pack6thread;

public class Ex41BankTom extends Thread{
	@Override
	public void run() {
		Ex41BankMain.bank.inMoney(5000);
		
		System.out.println("남편Tom의 예금후 잔고: "+ Ex41BankMain.bank.getMoney());//스태틱은 편하긴하지만 메모리저장공간이 작기에 남용 지양.
		
	}
}
