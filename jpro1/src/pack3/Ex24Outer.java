package pack3;
// 내부클래스

// 클래스의 멤버로 필드, 메소드, 클래스를 사용할수있다.
// 추가적으로 특정 클래스내에서 클래스를 선언해서 사용할 수 있는데
// 이를 내부클래스라한다.
// 내부클래스는 독립적으로 인스턴스 불가. 내부클래스를 포함한 외부클래스에 의해 통제된다.

public class Ex24Outer {
	private int a;
	private Inner inner;

	public Ex24Outer() {
		System.out.println("Outer  생성자");
		a = 10;
		inner = new Inner();
		// 내부클래스는 외부클래스를 통해 인스턴스.
	}

	public void aa() {
		System.out.println("외부에 있는 aa 메소드 실행");
		bb(); //aa와 동급 메소드호출
		inner.cc();// cc메소드는 내부클래스의 멤버.객체변수의이름을통해불러줌.
		System.out.println("1. outer의 a: " +a + ", inner의 b:" + inner.b);
	}

	public void bb() {
		System.out.println("외부에 있는 bb 메소드 실행");
	}

	public class Inner { // 내부클래스
		private int b;

		public Inner() {
			System.out.println("Inner 생성자");
			b= 20;
		}

		public void cc() {
			System.out.println("내부에 있는 cc 메소드 실행");
			bb(); //내부클래스는 외부클래스의 멤버를 자유롭게 호출가.
			System.out.println("2. outer의 a: " +a + ", inner의 b:" + b);
			
		}

		public class InnerInner { // 내부클래스에 내부클래스를 선언가.

		}
	}
	//내부 클래스의 수 만큼 extends를 사용할 수 있다. 
//	public class Inner2 extends Frame { 
//	}
//	public class Inner3 extends WindowAdapter { // 내부클래스
//	}
	}

