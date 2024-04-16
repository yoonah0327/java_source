package pack1other;

import pack1.Ex6Bank; // 다른 패키지에 있는 클래스읽기 
//import pack1.*; //pack1의 모든 클래스읽기: 비권장- 메모리낭비심함
public class Ex6Main2 {

	public static void main(String[] args) {
		// 같은 프로젝트, 다른 패키지에 있는 Ex6Bank 클래스를 사용
		Ex6Bank kildong = new Ex6Bank();
		//System.out.println("a:" + kildong.a ); //default. 불가. 패키지가 달라져서.
		System.out.println("b:" + kildong.b ); //public. 가.
	}

}
