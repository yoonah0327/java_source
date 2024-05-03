package pack7gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * 버튼: 장소낭비. 한눈에 보기쉬움. 
<>
메뉴: 장소절약. 한눈에보기어려움. 
버튼 메뉴 하는일은 똑같다. 모양만 다를뿐 .

 */


public class Ex46Menu extends JFrame implements ActionListener {
	JButton btnR, btnG, btnB;
	JTextArea txtArea = new JTextArea("가가가", 10, 5); // 키보드로 여러행 입력. 초기값,-,-. 
	// 내가 적는 텍스트양에 영향받지 않는다. 
	JMenuBar mBar;
	JMenuItem mnuMes, mnuOk, mnuInput;

	public Ex46Menu() {
		setTitle("연습");
		addLayout(); // 버튼 관련
		addMenuLayout(); // 메뉴관련

		setBounds(200, 200, 00, 300);
		setVisible(true);

		// addWindowListener(--); //frame에서 하던 방법. 윈도우종료.
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // jframe일때는이것도 가능
	}

	private void addLayout() {
		btnR = new JButton("빨강");
		btnG = new JButton("초록");
		btnB = new JButton("파랑");
		btnR.addActionListener(this);
		btnG.addActionListener(this);
		btnB.addActionListener(this);

		JPanel panel = new JPanel();
		panel.add(btnR);
		panel.add(btnG);
		panel.add(btnB);

		add("South", panel); // Frame은 borderlayout이므로. 위치 하단.
		add("Center", txtArea);// 상단 메뉴바. 하단 버튼. 중간에 글씨적는부분. 
	}

	private void addMenuLayout() {
		mBar = new JMenuBar();

		JMenu menu = new JMenu("대화상자");
		mnuMes = new JMenuItem("메세지창");
		mnuOk = new JMenuItem("확인창");
		mnuInput = new JMenuItem("입력창");
		menu.add(mnuMes); // 메뉴에 메뉴아이템 등록
		menu.add(mnuOk);
		menu.add(mnuInput);

		JMenu menu2 = new JMenu("나는메뉴");
		mBar.add(menu); // 메뉴바에 메뉴를 등록
		mBar.add(menu2);

		setJMenuBar(mBar); // JFrame에 메뉴바 등록
		// 메뉴에 리스너가 장착되지 않아서 반응이 없다. 붙여주자
		mnuMes.addActionListener(this);
		mnuOk.addActionListener(this);
		mnuInput.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println(e.getActionCommand());
		if (e.getSource() == btnR) { // 하단 색상 
			txtArea.setBackground(Color.red);
		} else if (e.getSource() == btnG) {
			txtArea.setBackground(new Color(0, 255, 0));
		} else if (e.getSource() == btnB) { 
			txtArea.setBackground(new Color(0, 0, 255));
		} else if (e.getSource() == mnuMes) { // 메뉴. 메세지창 
			// 내장 다이얼로그 박스 호출
			JOptionPane.showMessageDialog(this, "메세지", "알림", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("계속"); // modal dialogbox는 실행을 멈추고 창을 보여준다. 창을 닫으면 진행. 창닫으니 콘솔에 계속뜬다.
		} else if (e.getSource() == mnuOk) { // 메뉴. 확인창. 
			int result = JOptionPane.showConfirmDialog(this, "버튼을 고르시오", "골라", JOptionPane.YES_NO_CANCEL_OPTION);
			System.out.println(result);
			switch (result) {
			case JOptionPane.YES_OPTION: // case 0:과 같은것
				txtArea.append("예 선택\n");
				break;
			case JOptionPane.NO_OPTION: // case 1:과 같은것
				txtArea.append("아니오 선택\n");
				break;
			case JOptionPane.CANCEL_OPTION: // case 2:과 같은것
				txtArea.append("취소 \n");
				break;
			}
		} else if (e.getSource() == mnuInput) { // 여기서부턴 메뉴. 입력창. 
			String str = JOptionPane.showInputDialog(this, "자료 입력");
			txtArea.append(str+ "\n");
		}
	}

	public static void main(String[] args) {
		// 메뉴 작성 , 메시지박스
		new Ex46Menu();

	}

}
