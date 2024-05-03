package pack;

//1번문제) https://cafe.daum.net/flowlife/HqLo/53
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Dbtest7 extends JFrame implements ActionListener {
	private JLabel lbl1, lbl2, lbl3, lbl4;
	private JTextField txtc, txtp, txts, txtd;
	private JButton btninput;
	int code, su, dan, total;
	JTextArea txtResult = new JTextArea();

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public Dbtest7() {
		setTitle("상품 처리");

		layInit();
		accDb();

		setBounds(200, 200, 300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void layInit() {
		JPanel panel = new JPanel();
		JLabel lbl1 = new JLabel("코드: ");
		txtc = new JTextField("", 5);
		JLabel lbl2 = new JLabel("품명: ");
		txtp = new JTextField("", 10);
		JLabel lbl3 = new JLabel("수량: ");
		txts = new JTextField("", 5);
		JLabel lbl4 = new JLabel("단가: ");
		txtd = new JTextField("", 10);
		btninput = new JButton("추가");
		btninput.addActionListener(this);

		panel.add(lbl1);
		panel.add(txtc);
		panel.add(lbl2);
		panel.add(txtp);
		panel.add(lbl3);
		panel.add(txts);
		panel.add(lbl4);
		panel.add(txtd);
		panel.add(btninput);
		add("North", panel);

		txtResult.setEditable(false);
		add(txtResult);
	}

	private void accDb() {
		// 커낵션
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
			display();
		} catch (Exception e) {
			System.out.println("accDb err:" + e);
		}
	}

	private void display() {
		// 결과출력. 금액 3자리마다 콤마
		DecimalFormat df = new DecimalFormat("###,###");

		try {
			String sql = "";
			sql = "select * from sangdata";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int cnt = 0;
			txtResult.setText("코드\t상품명\t수량\t단가\t금액\n");

			while (rs.next()) {
				txtResult.append(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4)
						+ "\t" + df.format(rs.getInt(3) * rs.getInt(4)) + "\n");
				cnt++;
			}
			txtResult.append("\n건수: " + cnt);
		} catch (Exception e) {
			System.out.println("자료 출력 불가능err" + e);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 입력값 오류검사
		if (txtc.getText().equals("")) {
			txtResult.setText("코드 미입력");
			txtc.requestFocus();
			return;
		} else if (txtp.getText().equals("")) {
			txtResult.setText("품명 미입력");
			txtp.requestFocus();
			return;
		} else if (txts.getText().equals("")) {
			txtResult.setText("수량 미입력");
			txts.requestFocus();
			return;
		} else if (txtd.getText().equals("")) {
			txtResult.setText("단가 미입력");
			txtd.requestFocus();
			return;
		}

		// 코드 수량 단가 숫자여부확인
		try {
			code = Integer.parseInt(txtc.getText());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "코드를 숫자로 입력!", "오류", JOptionPane.INFORMATION_MESSAGE);
			txtc.setText("");
			txtc.requestFocus();
			return;
		}
		try {
			su = Integer.parseInt(txts.getText());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "수량를 숫자로 입력!", "오류", JOptionPane.INFORMATION_MESSAGE);
			txts.setText("");
			txts.requestFocus();
			return;
		}
		try {
			dan = Integer.parseInt(txtd.getText());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "단가를 숫자로 입력!", "오류", JOptionPane.INFORMATION_MESSAGE);
			txtd.setText("");
			txtd.requestFocus();
			return;
		}
		// 자료 추가
		try {
			String sql = "";
			sql = "insert into sangdata values(?,?,?.?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			pstmt.setString(2, "txt2");
			pstmt.setInt(3, su);
			pstmt.setInt(4, dan);
			
			int re = pstmt.executeUpdate();
			System.out.println("insert 반환값:" + re);
		} catch (Exception e2) {
			System.out.println("insert err:" + e);
		}
		display();

	}
	// 출력

	public static void main(String[] args) {
		new Dbtest7();
	}
}
//////	e.getSource() == btninput;
////if (txt1.getText().equals("")) {
////txtResult.setText("코드입력!");
////txt1.requestFocus();
////return;
////}
////try {
//// = Integer.parseInt(txt2.getText());
////
////} catch (Exception e2) {
////txtResult.setText("코드 정수로 제대로 입력!!");
////txt2.requestFocus();
////return;
////}
////if (txt2.getText().equals("")) {
////txtResult.setText("품명입력!");
////txt2.requestFocus();
////return;
////}
////if (txt3.getText().equals("")) {
////txtResult.setText("수량입력!");
////txt3.requestFocus();
////return;
////}
////try {
////num3 = Integer.parseInt(txt3.getText());
////
////} catch (Exception e2) {
////txtResult.setText("수량 정수로 제대로 입력!!");
////txt3.requestFocus();
////return;
////}
////if (txt4.getText().equals("")) {
////txtResult.setText("단가입력!");
////txt4.requestFocus();
////return;
////}
////try {
////num4 = Integer.parseInt(txt2.getText());
////
////} catch (Exception e2) {
////txtResult.setText("단가 정수로 제대로 입력!!");
////txt4.requestFocus();
////return;
////}
////
////// 자료추가
////
//
//
////}