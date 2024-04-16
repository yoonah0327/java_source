package pack3;

public class Ex16elecMain {

	public static void main(String[] args) {
		// 가전제품 부모클래스 생성 후 volumeControl()을 오버라이딩하여 다형성구사
		Ex16ElecPolyProduct product= null; //부모 객체로만 의미를 가진다
		
		Ex16ElecPolyRadio radio = new Ex16ElecPolyRadio();
		radio.setVolume(7);
		System.out.println(radio.getVolume());
		radio.volumeControl();
		
		System.out.println();
		Ex16ElecPolyTV tv= new Ex16ElecPolyTV();
		tv.setVolume(3);
		tv.volumeControl();
		tv.tvShow(); // tv 고유메소드
		
		System.out.println("\n다형성==============");
		product = radio; // promotion 
		product.volumeControl();
		System.out.println();
		product = tv; //promotion
		product.volumeControl();
		
	}

}
