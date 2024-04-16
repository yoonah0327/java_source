package pack;

public class Test3 {

	public static void main(String[] args) {
		// 관계, 논리 연산자
		int a =5;
		
		System.out.println(a > 3); //true
		boolean bo = a > 3;
		System.out.println(bo); //true
		System.out.println(a >= 3); //t
		System.out.println(a <= 3); //f
		System.out.println(a == 3);	//f
		System.out.println(a != 3); //t
		
		System.out.println();
		int b = 10;
		System.out.println(a > 3); //t
		System.out.println(b > 3); //t
		System.out.println(a > 3 && b > 3); //t // 논리 연산자 and
		System.out.println(a > 3 && b <= 3); //f
		
		System.out.println(a > 3 || b > 3); //t //엔터키위에 ||일자점선두줄짜리. 논리연산자 or.
		System.out.println(a > 3 || b <= 3); //t
		System.out.println(a < 3 || b <= 3); // f
		
		System.out.println(a < 3 || b <= 1 + 1 * 1); //f
		boolean bb = a < 3 || b <= 1 + 1 * 1; //f
		System.out.println(bb); //f
		// 연산자 우선순위 : () 소괄호 > 산술(*,/ > +,-) > 관계 > 논리 > 치환
		
		System.out.println("\n\nshift 연산 --------");
		int ii = 8, ij = 0; // ii는 8의 값을, ij는 아무값도 안 갖고 있음.
		System.out.println("ii:" + Integer.toBinaryString(ii)); //ii=1000 //10진수8을 2진수로 

		ij = ii >> 1; // >> 우측으로 1bite 이동. 남는 좌측은 부호(0이면 양수 1이면 음수)와 같은 값로 채움. 
		System.out.println("ii:" + ii + ", ij: " + ij); //ii:8. ij: 4
		
		ij = ii >>> 2; // >>> 우측으로 2bite 이동. 남는 좌측은 0으로 채움. 
		System.out.println("ii:" + ii + ", ij: " + ij); //ii:8. ij: 2
		
		System.out.println("삼항 연산자   (조건)?참일때값:거짓일때값");
		int sbs = 8;
		int mbc = (sbs > 5)?100:10 + 20 * 2;
		System.out.println(mbc); //100
		int sbs1 = 3;
		int mbc1 = (sbs1 > 5)?100:10 + 20 * 2;
		System.out.println(mbc1); //50
		
		System.out.println();
		int x, y, z;
		x= y= z = 5;
		System.out.println(x + " " + y + " " + z); // 5 5 5 
		
		System.out.println("논리 연산자에서 주의할 점 ------------");
		
		/*
		aa(); //갔더니 aa출력 출력. return ture(true를 갖고 돌아왔는데 그거 무시)
		
		System.out.println(aa());// true //한번찍음
		
		boolean imsi = aa();
		System.out.println(imsi); //true // 갖고 돌아온 true값이 imsi에 치환. 
		*/
		
		boolean a1 = false, b1 = true, c1;
		c1 = a1 || b1; // or
		System.out.println("c1 : " + c1); //c1 : true
		c1 = a1 && b1; // and
		System.out.println("c1 : " + c1); //c1 : false
		
		System.out.println();
		boolean b2, b3;
		b1 = aa();
		System.out.println(b1); //t 
		System.out.println(bb()); //f
 		
		System.out.println("~~~~~~~~~~~~");
		b2 = aa() || bb();
		System.out.println(b2); //t //aa가 참이기에 bb는 수행하지않음.
		b2 =  bb() || aa();
		System.out.println(b2); //t // bb먼저처리했더니 f받음. 그래서 aa가서 수행함. 
		// 즉 || 에서는 앞에서 참이 걸리면 뒷 연산들은 처리하지 않음.
		b2 = aa() | bb(); // |는 하나짜리or연산. 모든 메소드 호출. 
		System.out.println(b2); 
		System.out.println();
		
		b3 = aa() && bb();
		System.out.println(b3); // aa 참. b3값 도출위해선 bb값확인요. 
		b3 = bb() && aa();
		System.out.println(b3); //bb 거짓. aa값 확인 불요.
		b3 = bb() & aa();
		System.out.println(b3); // &는 하나짜리&연산. 모든 메소드 호출. 
		
		 
		
		
		
		System.out.println("프로그램 종료");
				
	}

	public static boolean aa() { 
		System.out.println("aa 출력");
		return true;
	}
	
	public static boolean bb() { 
		System.out.println("bb 출력");
		return false;
	}
}
