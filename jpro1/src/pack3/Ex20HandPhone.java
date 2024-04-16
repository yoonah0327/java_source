package pack3;

public class Ex20HandPhone implements Ex20Volume {
	private int volLevel;
	
	public Ex20HandPhone() {
		volLevel = 0;
	}
	
	@Override
	public void volumeUp(int level) {
		// 인터페이스의 추상메소드를 오버라이드
		if(level > 100) level = 100;
		volLevel +=level;
		System.out.println("핸드폰 소리를 올리면 " +volLevel);
			
	}
	
	@Override
	public void volumeDown(int level) {
		volLevel -= level;
		if(volLevel < 0) volLevel = 0;
		System.out.println("핸드폰 볼륨을 내리면 " +volLevel);
		
	}
}
