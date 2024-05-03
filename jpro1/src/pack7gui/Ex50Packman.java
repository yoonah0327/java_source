package pack7gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
//키보드 이벤트 연습
public class Ex50Packman extends JFrame implements KeyListener {
	Image image;
	int x= 100, y= 100;
	int selImage =1;

	public Ex50Packman() {
		super("상하좌우 화살표를 사용하세요");
		//아이콘이미지변경
		setIconImage(Toolkit.getDefaultToolkit().
				getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack1.jpg"));// 절대경로만됨. 
		// 왜 한번에 \\입력이 안되지??? 나는 복붙이라 /이렇게 입력되어 에러났었음

		setLayout(null); // 배치관리자 없음
		setResizable(false);// 창크기조절불가. 우상단맥시마이져불능시켜버림
		
		setBounds(200, 200, 500, 300);
		setBackground(Color.WHITE);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addKeyListener(this);
		x= super.getWidth() /2; // 프레임너비 너비의 반에 위치시킴
		y= super.getHeight() /2; //프레임너비 높이의 반에 위치시킴
		
	}

	@Override
	public void paint(Graphics g) { //페인트메소드? 
		// Frame에 뭔가를 그려주는 메소드로 자동호출- 설명이 확 안 와닿는다.. 보완 ^_^
		switch(selImage) {
		case 1: 
			image= Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack1.jpg");
			break;
		case 2:
			image= Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack2.jpg");
			break;
		case 3: 
			image= Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack3.jpg");
			break;
		case 4:
			image= Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack4.jpg");
			break;
		case 5: 
			image= Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack5.jpg");
			break;
		case 6:
			image= Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack6.jpg");
			break;
		case 7: 
			image= Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack7.jpg");
			break;
		case 8:
			image= Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack8.jpg");
			break;
		}
		g.clearRect(0, 0, getWidth(), getHeight());// repaint시 잔상제거: 화면전체를 선택해 클리어처리. 
		g.drawImage(image, x-image.getWidth(this)/2, y-image.getHeight(this)/2, this);//이미지옵져버를 현클래스로
		// 따악 정중앙에 위치시키고자 저런 코드를 굳이 주었다. 안그러면 삐뚤게 됨. x, y로 해본 위치도 확인해보자
	}
	
	@Override
	public void keyPressed(KeyEvent e) { // 이벤트처리메소드
		int key = e.getKeyCode(); 
		//오른쪽 화살표
		if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_NUMPAD6) {
			//System.out.println("right");// 그림은paint에서 그려지는중. 여기선 값만 바꿔주는거.
			selImage = (selImage ==1)?2:1; //삼항연산자: 1이면 2 아니면 1. 
			//x= x+10; 이러면 정해진화면을 나가버린다. 
			x= (x<getWidth())?x +=10:-image.getWidth(this); // 0을 넣으면 끄트머리부터 나오고, 
			// -image.getWidth(this)넣으면 보다더 살살나오게 할 수 있다. 
		}
		/*
		화살표 방향이 바뀔때 체크해야할점 
		1. 화살표별로 그림이 바뀌는것
		2. 방향키대로 코드짜주기
		3. 화면을 나가면 다시 돌아오도록 하기위해서 범위를 정해줄때 width와 height는 음수가 아니고 시작과 끝이 정해져있다. 
		예를들어 왼이면, -10씩 가기때문에 음수에 제한을 걸어줘야한다. 
		-image.getWidth: 중간에서 계속 왼쪽으로 움직이며 x값이줄어들다가 그 값이 image.getWidth(this)
		보다 작아지면 화면에서 사라지게 된다. 
		getWidth(): 화면에 다시 나타나게 해주려면 값이 가로길이값만큼주어 다시 나타나게 해준다.
		*/
		
		// 왼쪽 화살표
		if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_NUMPAD4) {
			selImage = (selImage ==3)?4:3;
			x= (x>-image.getWidth(this))?x -=10:getWidth(); 
		}
		// 아래쪽 화살표
		if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_NUMPAD2) {
			selImage = (selImage ==5)?6:5;
			y= (y<getHeight())?y +=10:-image.getHeight(this); 
		}
		// 위쪽 화살표
		if(key == KeyEvent.VK_UP || key == KeyEvent.VK_NUMPAD8) {
			selImage = (selImage ==7)?8:7;
			y= (y>-image.getHeight(this))?y -=10:getHeight(); 
		}
		
		repaint(); // paint()호출하여 화면을다시그려준다
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public static void main(String[] args) {
		
		new Ex50Packman();

	}

}
