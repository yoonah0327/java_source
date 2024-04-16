package pack1;

public class Ex3Main {

	public static void main(String[] args) {
		// 클래스 기본 연습 Ex3을 실행시키기 위해 존재하는 클래스.
		Ex3Programmer programmer = new Ex3Programmer();
		programmer.displayData(); // 메소드부르기 //퍼블릭 보이드 디스플레이데이타가기. 가서 멤버필드로 찾아가서 값 찾기.
		// 찾아보니 닉네임은 null, 나이는 0, 보유기술은 자바이더라.

		
		System.out.println();
		System.out.println("--------");
		programmer.setAge(33);
		System.out.println("나이는 " + programmer.getAge());
		programmer.displayData(); // 보유기술 : 프로..: 자바.. 구현.

		System.out.println("--------");
		Ex3Programmer tom = new Ex3Programmer();
		tom.nickName = " 톰 아저씨";
		tom.displayData();

		System.out.println("--------");
		Ex3Programmer james = new Ex3Programmer();
		james.nickName = "제임스 형";
		james.displayData();

		
		System.out.println();
		System.out.println("너의 모토는 " + james.motto);
		// static멤버는 위보단아래처럼 적는것을 권장. 바로 클래스로 부를수 있기에.
		// 형태 : 클래스이름.멤버. 
		// age, nickName은 객체변수통해서 접근 (heap)에 있는 애들. new 요. 
//		//Ex3Programmer james = new Ex3Programmer();
//		james.nickName = "제임스 형";
//		james.displayData();
//		 즉 이걸 단순화해서 작성하는것. 
		System.out.println("너의 모토는 " + Ex3Programmer.motto);
		Ex3Programmer.goodMethod();
	}

}
