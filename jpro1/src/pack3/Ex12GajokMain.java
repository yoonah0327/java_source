package pack3;

public class Ex12GajokMain {

	public static void main(String[] args) {
		// 상속연습 : 우리가족 소개
		Ex12GranaFa gr1 = new Ex12GranaFa(); //매개변수가 없는 생성자 호출
		System.out.println("가보 : " + gr1.gabo);
		System.out.println("가훈 : " + gr1.gahun);
		System.out.println(gr1.say());
		gr1.eat();
		System.out.println("할아버지 나이 :" + gr1.getNai());
		
		
	System.out.println();
	
	Ex12GranaFa gr2 = new Ex12GranaFa(77); //매개변수가 있는 생성자 호출
	// [할아버지 생성자] 출력이유: this();가 적혀있어서 기본생성자를 호출해서출력함.
	System.out.println("가훈 : " + gr2.gahun);
	System.out.println("할아버지 나이 :" + gr2.getNai());
	
	System.out.println("\n아버지에 대해-------------");
	Ex12Father father = new Ex12Father(); //매개변수가 없는 생성자 호출
	System.out.println("가보 : " + father.gabo); //지역우선. father에 gabo있으니 꽃병을출력. 상감청자x. 
	System.out.println("가훈 : " + father.gahun);
	System.out.println(father.say());
	father.eat();
	System.out.println("아버지 나이 :" + father.getNai()); 
	System.out.println(father.getHouse());
	father.showData();
	
	System.out.println("\n나에 대해-------------");
	EX12Me me = new EX12Me();// 내 생성자에 extends로 인해 super가 생략되어있음. 따라서 부모인
	//father 생성자에 갔는데, 거기도 extends라 grandfa 생성자가는것. 
	System.out.println("가보 : " + me.gabo); // 나-fa-gf
	System.out.println("가훈 : " + me.gahun);
	System.out.println(me.say());
	me.eat();
	System.out.println("아버지 나이 :" + me.getNai()); 
	System.out.println(me.getHouse());
	me.biking();
	
	}

}
