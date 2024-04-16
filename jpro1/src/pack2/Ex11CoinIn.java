package pack2;

public class Ex11CoinIn {
	private int coin;
	private int jandon;

	public void setCoin(int coin) { // setter. coin 값을 넣어주면, 하단오른쪽에 넣고, 그게 this로 넘어가는것.
		this.coin = coin;
	}

	public String calc(int cupCount) { 
		String msg = "";
		if(coin < 200) {
			msg= "요금이 부족합니다";
		}else if(cupCount*200 >coin) {
			msg= "요금이 부족합니다";
		}else {
			jandon = coin - (200*cupCount);
			msg = "커피" + cupCount + "잔과 잔돈" + jandon + "원";
		}
		return msg;

	}

}
