package pack6thread;

public class Ex42BreadMain {

	public static void main(String[] args) {
		// 스레드 간 자원 공유 및 스레드 활성화/비활성화 연습 
		Ex42BreadPlate breadPlate = new Ex42BreadPlate();
		
		Ex42BreadMaker maker = new Ex42BreadMaker(breadPlate);
		Ex42BreadEater eater = new Ex42BreadEater(breadPlate);
		//직접적으로 run을 부르지 않는다. maker.run(); eater.run(); > 싱글테스킹
		maker.start(); // > 멀티테스킹 
		eater.start(); // maker를 먼저썼다고 선수행은 아니다. 스케쥴러가 랜덤하게 결정한다. 
		
		
		
	}

}
