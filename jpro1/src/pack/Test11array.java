package pack;

public class Test11array {

	public static void main(String[] args) {
		// main 메소드의 매개변수(배열) 확인
		if(args.length == 0) {
			System.out.println("실행 시 값을주세요");
			System.exit(0); // 프로그램 종료
		}       // 마우스 오른쪽버튼 run as- run configuration. java의 해당 페이지인것확인.
		// argument에 입력. 띄워쓰기로 구분. 1 2 : 두개. 길동 만세 : 2개
		System.out.println(args.length);
		for(int i = 0; i < args.length; i++) {
			System.out.println(args[i]);   
		}
		System.out.println();
		for(String imsi:args) {
			System.out.println(imsi);
		}
		System.out.println("응용 프로그램 종료");
	}

}
