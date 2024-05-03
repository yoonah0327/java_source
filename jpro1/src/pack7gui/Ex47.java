package pack7gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ex47 extends JFrame implements ActionListener {
	JTextField txtName, txtAge;
	ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton rdoM, rdoF;
	JLabel lblResult;

	public Ex47() {
		super("이벤트 연습");
		layoutInit();

		setBounds(200, 200, 00, 300);
		setVisible(true);

		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void layoutInit() {
		setLayout(new GridLayout(5, 1));
		
		// 1행
		JLabel lbl1 = new JLabel("이름: ");
		txtName = new JTextField("", 20);
		JPanel panel1 = new JPanel();
		panel1.add(lbl1);
		panel1.add(txtName);
		add(panel1); // frame에 등록

		// 2행
		JLabel lbl2 = new JLabel("나이: ");
		txtAge = new JTextField("", 20);
		JPanel panel2 = new JPanel();
		panel2.add(lbl2);
		panel2.add(txtAge);
		add(panel2);

		// 라디오를 위해 ButtonGroup, JRadioButton rdoM, rdo 선언했다. 
		// 3행 // 라디오는 반드시&하나 선택. 
		rdoM = new JRadioButton("남자", true);
		rdoF = new JRadioButton("여자", false);
		buttonGroup.add(rdoM);
		buttonGroup.add(rdoF);
		JPanel panel3 = new JPanel();
		panel3.add(rdoM);
		panel3.add(rdoF);
		add(panel3);
		
		// 4행
		JButton btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		JPanel panel4 = new JPanel();
		panel4.add(btnOk);
		add(panel4);

		// 5행
		lblResult = new JLabel("결과: ", JLabel.CENTER);
		add(lblResult);
		
		txtName.requestFocus(); // 해당 객체로 커서이동
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 남여칸은 어짜피 반드시 입력하게되어있음. 이름 나이칸 반드시 입력하도록. 입력 자료 오류 검사
		if(txtName.getText().equals("")) {
			lblResult.setText("이름 입력!");
			txtName.requestFocus();
			return;
		}
		if(txtAge.getText().equals("")) {
			lblResult.setText("나이 입력!");
			txtAge.requestFocus();
			return;
		}
		//나이는 숫자 형태 여부확인 요. 
		int nai;
		try {
			nai = Integer.parseInt(txtAge.getText());
		} catch (Exception e2) {
			lblResult.setText("나이는 정수만 가능");
			txtAge.requestFocus();
			return;
		}
		//System.out.println(nai);
		//System.out.println(rdoM.isSelected()+ " " + rdoF.isSelected());	// 라디오 버튼 선택 여부 확인 
		String gender = "";
		if(rdoM.isSelected()) {
			gender= "남";
		}else {
			gender= "여";
		}
		String msg= "결과: "+ txtName.getText()+ "님의 나이는 "+ nai + ", 성별은 "+ gender;
		lblResult.setText(msg);
	}

	public static void main(String[] args) {
		new Ex47();

	}

}
