package pack2;

import java.util.Scanner;

public class Ex11Machine {
	private int cupCount;
	private Ex11CoinIn coinIn = new Ex11CoinIn(); 
	// 멤버필드구역. 
	//객체변수(coinIn)앞에 new 라는 것을 붙여서 인스턴스화시킴.클래스의 포함관계.
	
	public Ex11Machine() {

	} 
	
	
	public void showData() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("금액을 입력하세요");
		coinIn.setCoin(scanner.nextInt());

		System.out.print("몇 잔을 원하세요 :");
		cupCount = scanner.nextInt();
		System.out.println(coinIn.calc(cupCount));
		scanner.close();

	}

}
