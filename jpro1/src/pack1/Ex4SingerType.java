package pack1;

public class Ex4SingerType { // 가수들이 가져야할 기본 멤버를 클래스로 작성.
	private String name = "무명가수"; // 이름
	private String title = "아 대한민국"; // 곡 제목
	// ...

	public Ex4SingerType(String name, String title) { // 생성자 호출. 생성자를 통해 멤버변수에 값 저장
		this.name = name;
		this.title = title; //다르다는것을 표현하고자 this를 붙임.
	}

	public String getName() { // getter
		return name;
	}

	public String getTitle() {
		return title;
	}

	public void sing() {
		System.out.println(name + " is singing " + title + "...");
	}
//----------------------------------------------------------//
	public static void main(String[] args) {
		// 응용 프로그램 시작용 메소드. 메인메소드.
		// Ex4SingerType멤버는 아님. 세들어사는것. 윗 멤버아님!!!!!!
		// 이건 메인메소드임. 따로 만들기 귀찮아서 밑에 붙어있는것.
		Ex4SingerType bts = new Ex4SingerType("BTS", "Dynamite");// 무명>bts, 아대한..>dyna..
		bts.sing();
		System.out.println("가수이름 : " + bts.getName());
		System.out.println("곡 제목 : " + bts.getTitle());
		
		System.out.println();
		Ex4SingerType blackpink = new Ex4SingerType("BlackPink", "How you like that");
		blackpink.sing();
		System.out.println("가수이름 : " + blackpink.getName());
		System.out.println("곡 제목 : " + blackpink.getTitle());
		
	}

}

