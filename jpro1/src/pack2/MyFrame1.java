package pack2;

import java.awt.Frame;

// 자바가 제공하는 Frame클래스로 창띄우기: 포함관계
public class MyFrame1 {
	private String title = "포함관계";
	private Frame frame;

	public MyFrame1() {
		frame = new Frame(title); // 생성자는 짧고굴게권장.

	}

	private void display() {
		frame.setSize(500, 300);
		frame.setLocation(200, 150);
		frame.setVisible(true); // 객체변수가 없을수도 있다~
	}

	public static void main(String[] args) {
		MyFrame1 frame1 = new MyFrame1();
		frame1.display();
		// 만약 private의 내용을 생성자에 다 넣어버린다면,
		// frame1.display();불요. MyFrame1 frame1= new MyFrame1();도
		// new MyFrame1(); 만 적으면 됨.
	}

}
