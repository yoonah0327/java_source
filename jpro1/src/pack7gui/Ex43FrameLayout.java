package pack7gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent;

// AWT(Abstract Window Toolkit)
// LayoutManager 참조
// Frame: BorderLayout이 기본 
// Panel: FlowLayout이 기본

public class Ex43FrameLayout extends Frame implements ActionListener { // 컨테이너
	Panel pn1 = new Panel();// 컨테이너(visual object을 담는 그릇)의 일종
	Panel pn2 = new Panel();
	Panel pn3 = new Panel();
	Panel pn4 = new Panel(); 
	Panel pn5 = new Panel();
	Panel pn6 = new Panel();

	TextField txtBun, txtIrum; // 멤버필드 전역변수
	Button btnGo; // 보통 객체이름생성할때, 앞쪽에 성격 뒤쪽에 용도로 이름을 만들어준다.
	CardLayout card = new CardLayout();

	public Ex43FrameLayout() {
		// 배치 관리자로 화면 디자인 연습
		setLayout(new GridLayout(2, 1)); // Frame의 Layout을 변경. 2행 1열. Frame: border > grid

		// 첫번째 행 디자인
		Label lbl1 = new Label("bunho:"); // 메시지 컨포넌트
		txtBun = new TextField("10", 20); // 키보드로 자료 입력 가능
		pn1.add(lbl1); // Panel에 Lable 객체 담기
		pn1.add(txtBun); // Panel에 TextFiled 객체 담기
		pn1.setBackground(Color.yellow); // panel 배경색 담기
		// super.add(pn1); // frame에 panel을 담기. 이걸 안하면 상단의 꾸밈이 적용되지 않는다. 중요!

		Label lbl2 = new Label("irum:"); // 메시지 컨포넌트 // 로칼 지역변수
		txtIrum = new TextField("아자좟", 20); // 키보드로 자료 입력 가능
		pn2.add(lbl2); // Panel에 Lable 객체 담기
		pn2.add(txtIrum); // Panel에 TextFiled 객체 담기
		pn2.setBackground(Color.cyan); // panel 배경색 담기.

		pn3.setLayout(card); // pn3: 기본FlowLayout > CardLayout으로 변경. Panel: flow > card
		// 정해진공간내에서 겹쳐두고 필요시 꺼내보게함.
		pn3.add("first", pn1);// pn3에 "first"라는 이름으로 pn1 담기
		pn3.add("second", pn2); // pn3에 "second"라는 이름으로 pn2 담기
		btnGo = new Button("okay");
		btnGo.addActionListener(this); // 버튼이벤트를 감지하도록 해줌.
		pn4.add(pn3); // pn4: FlowLayout
		pn4.add(btnGo); // ok버튼

		super.add(pn4); // Frame에 Panel4를 담기

		// 두번째 행 디자인
		pn5.setLayout(new BorderLayout());
		pn5.setBackground(new Color(123, 123, 123));;
		pn5.add("East", new Label("kbs"));
		pn5.add("West", new Label("mbc"));
		pn5.add("South", new Label("sbs"));
		pn5.add("North", new Label("ytn"));
		pn5.add("Center", new Label("tvn"));
		
		super.add(pn5); 
		
		super.setTitle("레이아웃 연습");
		super.setBounds(200, 200, 400, 300);
		super.setVisible(true);
		super.addWindowListener(new WindowAdapter() { // 프레임에대해서 내작업이 먹도록 지시해줌.
			@Override
			public void windowClosing(WindowEvent e) { // 작업중 창끄기 작업이 먹도록 적어줌.
				System.exit(0);
			}
		});
	}

	@Override // actionlistener implement해서, actionPerformed메소드 오버라이딩
	public void actionPerformed(ActionEvent e) {
		// 버튼 이벤트 처리 메소드
		// 버튼을 클릭하면 pn1과 pn2를 교체
		// System.out.println("GOOD");
		if (e.getActionCommand().equalsIgnoreCase("okay")) { // 버튼의 값을 받아와서 처리한다. 
			btnGo.setLabel("go");
			card.show(pn3, "second"); // pn3에 담긴 pn2를 보여줘
		} else {
			btnGo.setLabel("okay");
			card.show(pn3, "first");// pn3에 담긴 pn1를 보여줘
		}

	}

	public static void main(String[] args) {
		new Ex43FrameLayout();

	}

}
