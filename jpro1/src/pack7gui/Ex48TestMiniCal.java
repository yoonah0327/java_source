package pack7gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ex48TestMiniCal extends JFrame implements ActionListener {
	JTextField txtSu1, txtSu2;
	int su1, su2;
	// 뒤에 따로 로칼로 언급해주었었다. 그러나 숫자1를 빈칸>정수연달아 검사해주기 위해
	// 아예 멤버필드에서 선언해주는 방법으로 바꾸어보자.
	ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton rdo1, rdo2, rdo3, rdo4;
	JLabel lblResult;
	JButton btn1, btn2, btn3;

	public Ex48TestMiniCal() {
		super("미니 계산기");
		layoutInit();
		// addLayout(); 따로 5행을 빼지말고 한 메소드안에 모두 선언해줘보자.
		setBounds(200, 200, 300, 300);
		setVisible(true);
		// super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void layoutInit() {
		setLayout(new GridLayout(5, 1));

		// 1행
		JLabel lbl1 = new JLabel("숫자1: ");
		txtSu1 = new JTextField("", 10);
		JPanel p1 = new JPanel();
		p1.add(lbl1);
		p1.add(txtSu1);
		add(p1);

		// 2행
		JLabel lbl2 = new JLabel("숫자2: ");
		txtSu1 = new JTextField("", 10);
		JPanel p2 = new JPanel();
		p2.add(lbl2);
		p2.add(txtSu2);
		add(p2);

		// 3행
		JLabel lbl3 = new JLabel("연산선택: ");
		rdo1 = new JRadioButton("+", true);
		rdo2 = new JRadioButton("-", false);
		rdo3 = new JRadioButton("*", false);
		rdo4 = new JRadioButton("/", false);
		buttonGroup.add(rdo1);
		buttonGroup.add(rdo2);
		buttonGroup.add(rdo3);
		buttonGroup.add(rdo4);

		JPanel p3 = new JPanel();
		p3.add(lbl3);
		p3.add(rdo1);
		p3.add(rdo2);
		p3.add(rdo3);
		p3.add(rdo4);
		add(p3);

		// 4행
		lblResult = new JLabel("결과: ", JLabel.CENTER);
		add(lblResult);

		// 5행
		btn1 = new JButton("계산");
		btn2 = new JButton("초기화");
		btn3 = new JButton("종료");
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);

		JPanel p5 = new JPanel();
		p5.add(btn1);
		p5.add(btn2);
		p5.add(btn3);
		add(p5);

	}

	// 아예숫자마다 빈칸>정수로 입력하도록 유도하자.
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) { // 계산 버튼
			// 숫자 1 검사
		}
		if (txtSu1.getText().equals("")) { // 빈칸인지
			lblResult.setText("숫자1 입력하시오");
			txtSu1.requestFocus();
			return;
		}
		try {// 정수로 입력하도록 유도
			su1 = Integer.parseInt(txtSu1.getText());
		} catch (Exception e2) {
			lblResult.setText("정수만 가능");
			txtSu1.requestFocus();
			return;
		}

		// 숫자2 검사
		if (txtSu2.getText().equals("")) {
			// 빈칸인지
			lblResult.setText("숫자2 입력하시오");
			txtSu2.requestFocus();
			return;
		}
		try {
			// 정수로 입력하도록 유도
			su2 = Integer.parseInt(txtSu2.getText());
		} catch (Exception e2) {
			lblResult.setText("숫자만 가능");
			txtSu2.requestFocus();
			return;
		}

		// 계산
		if (rdo1.isSelected()) {
			lblResult.setText("결과: " + (su1 + su2));
		}else if (rdo2.isSelected()) {
			lblResult.setText("결과: " + (su1 - su2));
		}else if (rdo3.isSelected()) {
			lblResult.setText("결과: " + (su1 * su2));
		}else {
			if (su1 ==0) {
				lblResult.setText("0은 나눌 수 없습니다");
				txtSu1.setText("");
				txtSu1.requestFocus();
			}else if (su2 ==0) {
				lblResult.setText("0으로 나눌 수 없습니다");
				txtSu2.setText("");
				txtSu2.requestFocus();
			} else
				lblResult.setText("결과: " + (double) su1 / su2);
		}
		if (e.getSource() == btn2) { // 초기화 버튼
			txtSu1.setText("");
			txtSu2.setText("");
			rdo1.setSelected(true);
			rdo2.setSelected(false);
			rdo3.setSelected(false);
			rdo4.setSelected(false);
			txtSu1.requestFocus(); // 커서가 숫자1에 가있도록 설정.
			lblResult.setText("결과: ");
		} else {
		int result= JOptionPane.showConfirmDialog(this, 
				"정말 종료할거야?", "종료 확인", JOptionPane.YES_NO_OPTION);
		if (result == 0)
			System.exit(0);
		else
			return;
//			JOptionPane.showMessageDialog(null, "정말 끌꺼니?", "확인", JOptionPane.INFORMATION_MESSAGE);
//			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	}

	public static void main(String[] args) {
		new Ex48TestMiniCal();

	}

}
