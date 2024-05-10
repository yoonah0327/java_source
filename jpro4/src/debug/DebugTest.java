package debug;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

// 개발자가 작업도중 임의의 값, 흐름 확인을 목적으로 디버깅 작업
public class DebugTest extends JFrame implements ActionListener {
	int cou = 0, tot = 0;
	JButton btn = new JButton("클릭");
	JTextField txtA = new JTextField();

	public DebugTest() {
		add("North", txtA);
		add("Center", btn);
		btn.addActionListener(this);

		setBounds(200, 200, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// 여태껏 사용하던 확인 방법.
		for (int i = 0; i < 5; i++) {
			cou++;
			System.out.println(cou); // 변수값 확인1: console로 출력
			tot += cou;
		}
		System.out.println("tot: " + tot);

		// 변수값 확인2: MessageDialog로 출력
		JOptionPane.showMessageDialog(this, cou);

		// 변수값 확인3: 임의 의 컴포넌트로 출력
		txtA.setText("합은 " + String.valueOf(tot));

		// 변수값 확인4: 디버깅 도구 사용- 확인할때 원하는 지점에 중단점 표시
		for (int i = 0; i < 5; i++) {
			cou++;
			System.out.println(cou);
			tot += cou;
		}
		System.out.println("tot: " + tot);

		aa();

		System.out.println("Bye");
	}

	private void aa() {
		System.out.println("aa 메소드 수행");

		for (int j = 0; j < 3; j++) {
			bb();
			System.out.println("aa 메소드 for문 실행");
		}

	}

	private void bb() {
		System.out.println("bb 메소드 처리~~");
	}

	public static void main(String[] args) {
		new DebugTest();

	}

}
