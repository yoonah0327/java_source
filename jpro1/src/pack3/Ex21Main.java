package pack3;

public class Ex21Main {

	public static void main(String[] args) {
		// 지원자가 작성한 이력서를 인사담당자가 취합하여 출력
		System.out.println("톰 이력서 작성 후 출력");
		Ex21Tom tom = new Ex21Tom();
		tom.setIrum("톰");
		tom.setPhone("111-1234");
		tom.setJuso("강남구 역삼1동 123");
		tom.printData();
		
		System.out.println("제임스 이력서 작성 후 출력");
		Ex21James j = new Ex21James();
		j.setIrum("제임스");
		j.setPhone("111-7878");
		j.setskill("웹프로그래밍 전문가");
		j.printData();
		
		System.out.println("\n인사 담당자가 이력서 출력 -----");
		Ex21Resume[] resBox = new Ex21Resume[2];
		resBox[0] = tom;
		resBox[1] = j;
		
		for(Ex21Resume r: resBox) {
			r.printData();
			System.out.println();
		}
	}

}
