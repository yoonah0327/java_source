package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PreTest3HS extends JFrame implements ActionListener {
	JTextField txtNo, txtName;
	JTextArea txtResult1 = new JTextArea();
	JTextArea txtResult2 = new JTextArea();
	
	Connection conn;
	PreparedStatement pstmt, pstmt1, pstmt2;
	ResultSet rs, rs1, rs2;
	String sql, sql1, sql2;
	// 1,2는 파라미터 없어서 Statement여도 상관없을텐데 SQL Injection 공격 방지만으로 이용가치가 있나?
	
	public PreTest3HS() {
		super("로그인 성공 시 모든 직원자료 출력");
		layInit();
		accDb();
		
		setBounds(200, 200, 500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void layInit() {
		JPanel panel = new JPanel();
		txtNo = new JTextField("",5);
		txtName = new JTextField("",8);
		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(this);
		panel.add(new JLabel("직원번호: "));
		panel.add(txtNo);
		panel.add(new JLabel("이름: "));
		panel.add(txtName);
		panel.add(btnLogin);
		add("North", panel);
		
		txtResult1.setEditable(false);
		txtResult1.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		JScrollPane sp = new JScrollPane(txtResult1);
		add("Center", sp);
		
		txtResult2.setEditable(false);
		txtResult2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add("South", txtResult2);
	}
	
	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
		} catch (Exception e) {
			System.out.println("accDb() err: " + e);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 로그인 데이터 모두 입력했는지 검사
		if(txtNo.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "번호 미입력", "알림", JOptionPane.INFORMATION_MESSAGE);
			txtNo.requestFocus();
			return;
		} else if(txtName.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "이름 미입력", "알림", JOptionPane.INFORMATION_MESSAGE);
			txtName.requestFocus();
			return;
		}
		

		// 로그인 처리하기
		try {
			sql = "select * from jikwon where jikwon_no = ? and jikwon_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, txtNo.getText());
			pstmt.setString(2, txtName.getText());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				displayResult1();
				displayResult2();
			} else {
				JOptionPane.showMessageDialog(this, "직원 정보 조회 불가능", "로그인 실패", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e2) {
			System.out.println("로그인 처리 err: " + e2);
		}
		
		
	}
	
	private void displayResult1() {
		try {
			sql1 = "select * from jikwon";
			pstmt1 = conn.prepareStatement(sql1);
			rs1 = pstmt1.executeQuery();
			txtResult1.setText("사번\t직원명\t연봉\t직급\t평점\n");
			while(rs1.next()) {
				txtResult1.append(rs1.getString("jikwon_no") + "\t" + rs1.getString("jikwon_name") + "\t" + rs1.getString("jikwon_pay") + "\t" 
			+ rs1.getString("jikwon_jik") + "\t" + rs1.getString("jikwon_rating") + "\n");
			}
		} catch (Exception e2) {
			System.out.println("displayResult1() err: " + e2);
			return;
		}
		
		try {
			if(rs1!=null) rs1.close();
			if(pstmt1!=null) pstmt1.close();
		} catch (Exception e2) {
			System.out.println("cannot close: " + e2);
			return;
		}
	}
	
	private void displayResult2() {
		txtResult2.setText("직급별 연봉평균\n");
		sql2 = "select jikwon_jik 직급, avg(jikwon_pay) 연봉평균 from jikwon group by jikwon_jik order by 연봉평균 desc";
		try {
			pstmt2 = conn.prepareStatement(sql2);
			rs2 = pstmt2.executeQuery();
			while(rs2.next()) {
				txtResult2.append(rs2.getString(1)+ ": " + rs2.getInt(2) +"  ");
			}
			
		} catch (Exception e2) {
			System.out.println("displayResult1() err: " + e2);
			return;
		}
		
		try {
			if(rs2!=null) rs1.close();
			if(pstmt2!=null) pstmt1.close();
		} catch (Exception e2) {
			System.out.println("cannot close: " + e2);
			return;
		}

	}

	public static void main(String[] args) {
		new PreTest2HS();
	}
}

