package pack3;

public class Ex17TV extends Ex17Jepum {
	public Ex17TV() {
		System.out.println("TV 생성자");
	}
	
	@Override
	public void volumeControl() {
		System.out.println("TV 소리 변경");//Overriding 강요
	}
	@Override
	public void volumeShow() { // Overriding 선택
		System.out.println("소리 크기는 적당히 + 부모 메소드 내용 대신 새로운 내용으로 대체 ");

		
	}
}
