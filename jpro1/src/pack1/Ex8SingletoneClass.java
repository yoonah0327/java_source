package pack1;

public class Ex8SingletoneClass {
	int kor = 90;
	
	public Ex8SingletoneClass() {
		
	}
	
	//객체의 인스턴스가 오직 1개만 생성되는 패턴을 만들기
	//장점: 메모리 절약, 데이터 공유 편리
	//단점: 테스트가 불편, 유연성이 떨어짐
	
	private static Ex8SingletoneClass class1 = new Ex8SingletoneClass();
	
	public static Ex8SingletoneClass getInstance() {
		return class1;
	}
		
	
}
