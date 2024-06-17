package pack.order;

import java.util.Hashtable;

public class CartMgr {
	private Hashtable<String, OrderBean> hCart = new Hashtable<String, OrderBean>();
	
	public void addCard(OrderBean obean){//카트에 담기
		
	}
	
	public Hashtable<String, OrderBean> getCartList(){ //카트 읽기
		return hCart;
	}
	
	public void updateCard(OrderBean obean) {//카트 업데이트
		
	}
	public void deleteCard(OrderBean obean) { //카트지우기
		
	}
}
