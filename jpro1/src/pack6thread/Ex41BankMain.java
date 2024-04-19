package pack6thread;

public class Ex41BankMain {
	public static Ex41Bank bank = new Ex41Bank();

	public static void main(String[] args) {
		System.out.println("원금:"+ bank.getMoney());
		
		Ex41BankTom tom = new Ex41BankTom();
		Ex41BankTomWife wife = new Ex41BankTomWife();
		
		tom.start();
		wife.start();
		
	}

}
