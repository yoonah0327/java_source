package pack3;

public class Ex24Main {

	public static void main(String[] args) {
		// 내부 클래스  연습용
Ex24Outer outer = new Ex24Outer();
outer.aa();
outer.bb();
//outer.cc():

System.out.println();
//Inner inner = new Inner(); //내부클래스는 독립적인스턴스불가. 

//Ex24Outer.Inner inner = outer.new Inner();
//inner.cc(); // 이렇게 가능하지만 현실적으로 사용노.
System.out.println("============");
outer.aa();



	}

}
