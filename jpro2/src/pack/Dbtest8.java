package pack;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Dbtest8 extends JFrame implements ActionListener {

	JLabel lbl1, lbl2, lbl3;
	JTextField txtname, txtju1, txtju2, txtResult;
	JButton btn;

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public Dbtest8() {

		layInit();
		accDb();

		setBounds(200, 200, 200, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			// 버튼 누르고
			if (e.getSource() == btn)
				// 출력
				display();
		} catch (Exception e2) {
		}
	}

	private void display() {
		try {
			txtResult.setText(rs.getString("사번"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void layInit() {
		setLayout(new GridLayout(2, 1));

		JLabel lbl1 = new JLabel("고객명: ");
		txtname = new JTextField("", 5);
		JPanel p1 = new JPanel();
		p1.add(lbl1);
		p1.add(txtname);
		add(p1);

		JLabel lbl2 = new JLabel("주민번호: ");
		txtju1 = new JTextField("", 6);
		JLabel lbl3 = new JLabel(" - ");
		txtju2 = new JTextField("", 6);
		btn = new JButton("확인");

		JPanel p2 = new JPanel();
		p2.add(lbl1);
		p2.add(txtju1);
		p2.add(lbl2);
		p2.add(txtju2);
		p2.add(btn);
		add(p2);

		txtResult.setEditable(false);
		add(txtResult);

	}

	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");

			String sql = "";
			sql = "select jikwon_no 사번, jikwon_name 이름, buser_name 부서명, buser_tel 전화, jikwon_jik 직급 \r\n"
					+ "from jikwon \r\n"
					+ "inner join buser on buser_no=buser_num\r\n"
					+ "INNER JOIN gogek ON gogek_damsano= jikwon_no\r\n"
					+ "WHERE gogek_name=?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, "txtname");
			
			rs= pstmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString(1)+ " "+
						rs.getString(2)+" "+ rs.getString(3)
						+" "+ rs.getString(4)+" "+rs.getString(5));
			}
		

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {

	}

}
