package pack1;

// method overloading: 한개의 클래스의 이름이 같은 메소드를 여러개 선언
// 성립조건 : 매개변수의 갯수, 타입, 순서가 다르면 된다. 반환형과는 관계없다.
public class Ex5AnimalOverload {
	private int leg = 4;
	private int age;
	private String name;
	public final static int MOUTH = 1; // final멤버필드는 대문자.

	public Ex5AnimalOverload() {
		//생성자는 내용이없는경우 생략가.그러나 내용이 없어도, 내용이 있는 오버로딩 호출시, 반드시 적어야함.
		this(10); //생성자가 생성자를 부름. 어떤 생성자를 부를지는 argument로 결정.
		//생성자가 다른 생성자를 호출. 그러나 다른 생성자보다 먼저적어줘야함
		System.out.println("비어있는 생성자");
		
		//메소드명(); // 생성자가 메소드를 호출. 
	} 
	// 생성자 오버로딩은 한번 고친다음 FIX.
	// 메소드 오버로딩은 계속 고칠수 있음.
	
	public Ex5AnimalOverload(int leg) { // 생성자 오버로딩 
		this.leg = leg; //현클래스내멤버지정>this. 멤버필드를 부름.
	}
	
	public Ex5AnimalOverload(String name) { // 생성자 오버로딩 
		this.name = name;
	}
	public Ex5AnimalOverload(String name, int age, int leg) { // 생성자 오버로딩 
		this.name = name;
		this.age = age;
		this.leg = leg;
	}
// getter setter 등 밑이랑(?) 다르게
	//처음세팅값을 다르게 해주고 고정해두고 여기서 값넣어서 출력. 
	//밑은 계속변화가능.
	
	public void display() {// 멤버출력용메소드
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
	
	// 위아래 두 메소드들이 하는 기능 비슷함. 굳이 display, print, show 등 다르게 하면 비효율.
	// 같은 메소드가 있을순 없다.
	// 하단이 메소드오버로딩.
	public void display(int age) { // 매개변수(parameter) 갯수가 다름. 여기선 int값하나. 위는 없음.
		this.age = age; // 지역변수age를 멤버필드age에 기억시키기.
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
	public void display(String name) { // 타입이 다른 매개변수
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
	public void display(String name, int age) { // 갯수가 다른 매개변수.
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
		
	}
	public void display(int age, String name) { // 순서가 달라도 다른거로 취급되기에 ok.
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
	/*
	public void display(int leg) { // 에러. 
		//leg는 변수명. int 변수라는 점에서 int age와 같은 형태. 
	System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
    */
	/*
	public String display(int leg) { // 에러. 반환형string과 무관.
	System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
	*/
	
}
