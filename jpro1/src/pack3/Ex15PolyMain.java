package pack3;

// 폴리모피즘  ***다형성
public class Ex15PolyMain {

	public static void main(String[] args) {
		Ex15PolyCar car1 = new Ex15PolyCar();
		Ex15PolyBus bus1 = new Ex15PolyBus();
		Ex15PolyTaxi taxi1 = new Ex15PolyTaxi();

		System.out.println();
		car1.displaySpeed();
		System.out.println(car1.getSpeed());

		System.out.println();
		bus1.displaySpeed();
		System.out.println(bus1.getSpeed());

		System.out.println();
		taxi1.displaySpeed();
		System.out.println(taxi1.getSpeed());

		System.out.println("\n--객체 주소 치환--"); // 필드의 다형성?
		Ex15PolyCar car2 = new Ex15PolyBus(); // Promotion. bus자식 주소를 car부모에게 치환을함.
		car2.displaySpeed(); // *** 오버라이딩한 경우, 부모객체변수가 자식메소드 호출가.
		System.out.println(car2.getSpeed());
		// car2.show(); 에러 //오버라이딩하지 않은 메소드. 불간섭의원칙. 자식고유메소드 간섭불가.

		System.out.println();
		Ex15PolyCar car3 = taxi1; // promotion. car타입 taxi주소.
		System.out.println("주소 확인 :" + car3 + " " + taxi1);
		car3.displaySpeed();
		System.out.println(car3.getSpeed());

		System.out.println("\n================");
		// Ex15PolyBus bus2 = new Ex15PolyCar(); 불가.
		Ex15PolyBus bus3 = (Ex15PolyBus) car2; // car2는 부모타입이지만 자식의주소를 받음.
		// 그래서 부모탈을쓰고 실질은 자식. casting 으로 치환가.
		bus3.displaySpeed();

		System.out.println();
		// Ex15PolyTaxi taxi2= new Ex15PolyCar(); typemismatch
		Ex15PolyTaxi taxi2 = (Ex15PolyTaxi) car3;
		taxi2.displaySpeed();

		// Ex15PolyTaxi taxi3= (Ex15PolyTaxi)car1; //문법상ok. runtimeerror실행오류.

		System.out.println("+++++++++++++++++++++++++++++++");
		Ex15PolyCar mycar;
		mycar = bus1;
		mycar.displaySpeed();

		mycar = taxi1;
		mycar.displaySpeed(); // 51라인과 출력물이 다름. statement(명령문) same, diff result.

		System.out.println();
		Ex15PolyCar p[] = new Ex15PolyCar[3];
		p[0] = car1;
		p[1] = bus1;
		p[2] = taxi1;
		for (Ex15PolyCar poly : p) {
			poly.displaySpeed();
		}

	}

}
