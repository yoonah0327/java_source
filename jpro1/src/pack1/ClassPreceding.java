package pack1;

public class ClassPreceding {

	public static void main(String[] args) {
		// 클래스 이해 전 자원의재활용에 대해 알아보자. // 클래스의 존재 목적
		int su1 = 6;
		int su2 = 3;
		System.out.println("방법1 사용");
		System.out.println("합은 " + (su1 + su2));
		System.out.println("차는 " + (su1 - su2));
		// 뭔가를 하다가..
		System.out.println();
		// 합과 차 구하기가 또 필요한경우
		System.out.println("합은 " + (su1 + su2)); // 방법1 : 복붙
		System.out.println("차는 " + (su1 - su2));

		System.out.println("\n방법2 사용");
		// 별도의 단위 프로그램을 작성 후 필요할 때마다 호출
		hap(su1, su2);
		cha(su1, su2);
		// 뭔가를 하다가..
		System.out.println();
		// 합과 차 구하기가 또 필요한경우
		hap(su1, su2);
		cha(su1, su2); // 호출해서 수행한뒤 반드시 돌아옴.
		
		System.out.println("\n방법3 사용 - ClassPre2의 단위 프로그램을 호출");
		// 별도의 단위 프로그램을 작성 후 필요할 때마다 호출
		ClassPre2 my = new ClassPre2();
		my.hap(su1, su2);
		my.hap(20, 5);
		my.cha(su1, su2);
	}


	public static void hap(int su1, int su2) { // 방법2: 합구하기 코드 별도 작성
		System.out.println("합은 " + (su1 + su2));

	}

	public static void cha(int su1, int su2) {
		System.out.println("차는 " + (su1 - su2));
	}

}
