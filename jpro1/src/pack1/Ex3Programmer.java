package pack1;

public class Ex3Programmer {

	public String nickName; // 초기값 null 형태. 참조형. public String nickName = ""; 과 같음.
	private int age; // 초기값 0. 기본형. private int age = 0;과 같음.
	String spec = "자바";

	public static String motto = "자바에 미쳐 버리자"; //정적변수
	public final String campName = "에이콘 아카데미"; //상수(=특별한변수). 수정불가
	
	
	public Ex3Programmer() {
		System.out.println("난 생성자야 역할은 객체 생성시 초기화를 담당해");
		System.out.println("초기화 없을 때는 생략가능");
		age = 22;
		displayData();
		//campName = "도토리"; 10행에 final 때문에 에러.
		System.out.println("캠프 이름 : " + campName);
	}

	public void displayData() {
		System.out.println("별명이 " + nickName + ": 나이는 " + age + "살, 보유기술은 " + spec);
		
		//메소드가 다른 메소드 호출가능
		System.out.println("보유기술 재 확인 : " + showSpec());
	}
	private String showSpec() {  //string인것은 반환값정체(msg)때문. 
		//값은 1개만 가지고 갈 수있다. n개를 원할경우 배열로묶어 그묶음으로.
		String msg = "프로그래밍 언어 : " + spec;
		return msg + "(커피아님)";
	}
	// private age에 대한 getter, setter
	public void setAge(int age) {
		this.age= age; //age = age; 이러면 의미도없고, main에적은 33데이타값이 안들어감. 지역변수가 메인필드로 들어감. 
	}
	
	public int getAge() {
		return age;
	}
	
	static public void goodMethod() {
		System.out.println("스테틱 메소드임을 널리 알리노라");
		System.out.println(motto);
		//System.out.println(age); //에러 static 메소드는 일반멤버 호출불가. 
		//왜: 만들어지는순서.스태틱은 스태틱만 호출가.
	}
	
	public void niceMethod() {
		System.out.println(age); //일반 메소드는 일반 멤버 호출가.
		System.out.println(motto); //일반 메소드는 static 멤버 호출가. 
	}
}

