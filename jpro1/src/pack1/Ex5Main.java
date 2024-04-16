package pack1;

public class Ex5Main {

	public static void main(String[] args) {
		System.out.println("메소드 오버로딩---");
		Ex5AnimalOverload tiger = new Ex5AnimalOverload(); //new를통해생성자호출
		// animal객체에 tiger주소하나 만든것.
		tiger.display();
		tiger.display(5); //인수(=인자, argument)
		tiger.display("호랑이");
		tiger.display("호랭이",2);
		tiger.display(3, "호돌이");
		
		System.out.println("\n생성자 오버로딩---");
		Ex5AnimalOverload dog = new Ex5AnimalOverload();
		dog.display();
		
		Ex5AnimalOverload hen = new Ex5AnimalOverload(2);
		hen.display();
		
		Ex5AnimalOverload wolf = new Ex5AnimalOverload("늑대", 3, 4);
		wolf.display();
				
	}

}

/* 그 흐름에 익숙해져야지 막 조목조목 따지면 힘들다. 아그렇구나~하면서 교재읽고, 수업내용복기하고. 
 * 그걸로 충분하다. 
 * 
 * 메소드 오버로딩
 * 원래 1메소드1기능인데, 기능이비슷한데계속메소드를 다르게 주는건 너무 피곤.
 * 그래서 메소드를 고정해주고, 매개변수에 변화를 주어 계속 쓰는것. 
 * 
 * 생성자 오버로딩
 */

// void는 반환값이 없다. 따라서 보통 return;이라는 것을 같이 적지 않는다.(굳이?)
// 받을 값이 있을 경우, return; 을 적고, 앞에 int, double, string 등의 붙여
// 값을 받는 틀을 만들어준다.
//반환형은 그래서 메소드에만 붇는다. (당연한것!)

