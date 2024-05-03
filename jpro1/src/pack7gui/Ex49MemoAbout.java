package pack7gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

// jdialog: 맞춤형 대화상자 작성. 커스터마이징 가. 독립적 호출불가, frame에서 자식창으로 호출가. 
public class Ex49MemoAbout extends JDialog implements ActionListener {
	public Ex49MemoAbout(JFrame frame) {
		super(frame);
		//super(frame, "메모장이란", true); // 생성자로 모달리스 이렇게 줄수도 있다. 
		
		setTitle("메모장이란");
		setModal(true); // 모달. 만약 false이면 false modal, modelless라고 함. 이건 본창이 안먹힘. 먼저 이거 수행안하면 멈춤.
		//setModal(false); modelless 이건 확인창이 띄어져있어도 본메모장클릭해서 글씨적기가 먹힌다. 
		initLayoutAbout();
		
		setBackground(Color.lightGray);
		setBounds(350, 350, 200, 200);
		setVisible(true);
		
	}

	private void initLayoutAbout() { 
		JLabel lblMsg= new JLabel("미니 메모장 ver0.9");
		JButton btnConfirm= new JButton("확인");
		btnConfirm.addActionListener(this);
		add("Center", lblMsg);
		add("South", btnConfirm);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose(); // jdialog 닫기. 정확히 표현하면 앞에 super붙는다

	}
}
