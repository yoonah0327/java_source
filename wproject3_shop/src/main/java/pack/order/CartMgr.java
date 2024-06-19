package pack.order;

import java.util.Hashtable;

public class CartMgr {
	private Hashtable<String, OrderBean> hCart = new Hashtable<String, OrderBean>();
	// 1주문 슬리퍼2. 2주문 책상1. 3주문 슬리퍼5. 
	
	public void addCart(OrderBean obean){//카트에 담기
		//cartMgr.addCart(order);
		String product_no = obean.getProduct_no();
		int quantity = Integer.parseInt(obean.getQuantity());
		
		if(quantity >0) {//동일 상품 주문인 경우 주문수량만 증가
			if(hCart.containsKey(product_no)) { //있다면. 이미1회이상 주문된 상품인경우
				OrderBean temp = hCart.get(product_no);
				quantity += Integer.parseInt(temp.getQuantity()); //3주문시 5개를누적. 2+5=7이됨.
				temp.setQuantity(Integer.toString(quantity)); //7을 temp에 담고
				hCart.put(product_no, temp); //hCart에 temp를 담는다
			}else {//없다면 최초상품
				hCart.put(product_no, obean); //카트에 담기는 최초의 상품 
				//상품번호와 상품정보들이 오빈에담김.(오빈에 아이디 등이 담겨잇다)
				//슬리퍼2 책상1
				
			}
		}
		//System.out.println(hCart.size()); 
		//주문건수가 없다고 계속 출력되어서 혹 size()값을 못 받아오나 여기서 찍어봤다.콘솔에 찍히는것을 확인. 
		
	}
	
	public Hashtable<String, OrderBean> getCartList(){ //카트 읽기
		return hCart;
	}
	
	public void updateCart(OrderBean obean) {//카트 업데이트.수정.
		String product_no= obean.getProduct_no();
		hCart.put(product_no, obean);
		
	}
	public void deleteCart(OrderBean obean) { //카트지우기
		String product_no= obean.getProduct_no();
		hCart.remove(product_no); //램에 들어있다. 디비에 있는게 아님.
	}
}
