package pack3;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//어댑터 클래스를 이용한 이벤트 처리연습
public class MyFrame4adapter extends WindowAdapter { // 상속. 얘는 단일상속임. ,쓰는거 안됨 ㅜㅜㅜ >>>>> 내부클래스로~
	private Frame frame;

	public MyFrame4adapter() {
	 frame = new Frame("Adapter 연습"); //포함
	 
	 frame.setSize(300, 250);
	 frame.setLocation(200, 200);
	 frame.setVisible(true);
	 //windowadapter 추상클래스는 windowlistener 인터페이스를 구현한 클래스
	 //windowlistener의 추상메소드가 windowadapter에서 일반메소드로 오버라이드(재정의)
	 
	 frame.addWindowListener(this);
	}
	 //WindowAdapter 추상클래스는 addWindowListener를 implement했다(갖고있다). 
	 //현클래스가 윈도우어댑터를 extends했기에 this! 

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		new MyFrame4adapter();
	}

}
