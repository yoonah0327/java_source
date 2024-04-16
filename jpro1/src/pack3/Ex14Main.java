package pack3;

public class Ex14Main {

	public static void main(String[] args) {
		// 개과의 동물들 상속으로처리
		Ex14Dog dog = new Ex14Dog();
		dog.printMsg();
		System.out.println(dog.callName());

		System.out.println("HouseDog-----------");
		Ex14HouseDog hd = new Ex14HouseDog("집개");
		hd.printMsg();
		System.out.println(hd.callName());
		
		System.out.println("WolfDog ------------");
		Ex14WolfDog wd = new Ex14WolfDog("늑대");
		wd.printMsg();
		System.out.println(wd.callName());
		System.out.println();
		wd.display();
		
		System.out.println("\n\n주소 치환********************");
		Ex14WolfDog bushDog = wd; //울프독 주소를 부시독에 준것. 같은타입의 변수에게 주소치환.
		bushDog.printMsg();
		
		System.out.println();
		// Ex14HouseDog hd2 = wd; Type mismatch 에러
		Ex14Dog dog2 = wd; //자식의 객체타입주소는 부모의 객체타입주소에 치환가. Promotion
		// 타입다르지만 부모변수에 자식변수 주소치환가.
		dog2.printMsg();// 부모객체주소에 자식객체주소로 치환.부모객체주소가 자식메소드로 호출시, 울프독의것이나옴.
		
		Ex14Dog dog3 = new Ex14Dog();
		dog3.printMsg();
		//Ex14WolfDog wd2 = dog3; 에러 // 자식객체변수에 부모변수주소치환불가.
		// wd = dog3; 에러 //부모 > 자식보다 크다고 생각. double > int 사이즈비교 떠올리면된다.
		
		
		
	}

}
