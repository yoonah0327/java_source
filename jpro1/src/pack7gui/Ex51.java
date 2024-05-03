package pack7gui;
/*
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex51 extends JFrame implements ActionListener {
	JTextField txtName, txtKor, txtEng, txtMath;
	JLabel lblKor, lblEng, lblMath, lblSum, lblAvg, lblGrade;
	JButton btnOk, btnReset;
	Image image;

	public Ex51() {
		super("성적출력");
		Layout();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\ab.png"));

		setResizable(false);
		// 미니마이져없애기메소드추가해주기
		setBounds(200, 200, 200, 200);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// addKeyListener(this);

	}

	private void Layout() {
		setLayout(new GridLayout(5, 1));

		// 1행
		JLabel lbl1 = new JLabel("이름: ");
		txtName = new JTextField("", 10);
		JPanel panel1 = new JPanel();
		panel1.add(lbl1);
		add(panel1);

		// 2행
		lblKor = new JLabel("국어: ");
		txtKor = new JTextField("", 10);
		lblEng = new JLabel("영어: ");
		txtEng = new JTextField("", 10);
		lblMath = new JLabel("수학: ");
		txtMath = new JTextField("", 10);

		JPanel panel2 = new JPanel();
		panel2.add(lblKor);
		panel2.add(txtKor);
		panel2.add(lblEng);
		panel2.add(txtEng);
		panel2.add(lblEng);
		panel2.add(txtEng);

		// 3행
		lblSum = new JLabel("총점: ");
		lblAvg = new JLabel("평균: ");
		lblGrade = new JLabel("평가: ");
		add(lblSum);
		add(lblAvg);
		add(lblGrade);
		JPanel panel3 = new JPanel();
		panel3.add(lblSum);
		panel3.add(lblAvg);
		panel3.add(lblGrade);
		add(panel3);

		// 4행
		btnOk = new JButton();
		btnReset = new JButton();
		btnOk.addActionListener(this);
		btnReset.addActionListener(this);

		JPanel panel4 = new JPanel();
		panel4.add(btnOk);
		panel4.add(btnReset);
		add(panel4);

		// 5행: 이미지넣기

	}

	@Override
	public void paint(Graphics g) {
		if (GImage) {
			image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\ab.png");
			break;
		} else {
			image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\cdf.png");
			break;
		}
		g.clearRect(0, 0, getWidth(), getHeight());
		// g.drawImage(image, x-image.getWidth(this)/2, y-image.getWidth(this)/2, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			// 이름입력
			if (txtName.getText().equals("")) {
				txtName.requestFocus();
				return;
			}
			// 극어 입력
			if (txtKor.getText().equals("")) {
				txtKor.requestFocus();
				return;
			}
			// 국어 숫자입력
			int kor = 0;
			try {
				kor = Integer.parseInt(txtKor.getText());
			} catch (Exception e2) {
				txtKor.requestFocus();
				return;
			}
			// 영어 입력
			if (txtEng.getText().equals("")) {
				txtEng.requestFocus();
				return;
			}
			// 영어 숫자입력
			int eng = 0;
			try {
				eng = Integer.parseInt(txtEng.getText());
			} catch (Exception e2) {
				txtEng.requestFocus();
				return;
			}
			// 수학 입력
			if (txtMath.getText().equals("")) {
				txtMath.requestFocus();
				return;
			}
			// 수학 숫자입력
			int math = 0;
			try {
				math = Integer.parseInt(txtMath.getText());
			} catch (Exception e2) {
				txtMath.requestFocus();
				return;
			}
// 총점, 평균, 평가출력
	lblSum.setText((kor+eng+math));
	lblAvg.setText((kor+eng+math)/3);
	if((kor+eng+math)/3 >= )
	
		}
		else if (e.getSource() == btnReset)	{
			txtName.setText()
		}
			
	}

	public static void main(String[] args) {
		new Ex51();

	}

}
*/