package pack3;

import java.awt.Frame;

public class MyFrame2 extends Frame {
	
	public MyFrame2() {
		 super("상속 사용");
	 }
	
	void display() {
		setSize(500, 300); //super.setSize(500,300);인것. 
		setLocation(200, 150);
		setVisible(true);
	}
	

	
	public static void main(String[] args) {
		// 상속으로 Frame 띄우기
		
		new MyFrame2().display();
		//MyFrame2 frame = new MyFrame2();
		//frame.display();
		
		
	}

}
