package pack;


import java.awt.GridLayout;
// 2번문제) https://cafe.daum.net/flowlife/HqLo/53
// 주민번호 아직 처리 안 함
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PreTest2HS extends JFrame implements ActionListener{
	JTextField txtName, txtJuminA, txtJuminB;
	JButton btnOk = new JButton("확인");
	JTextArea txtResult = new JTextArea();
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String sql = "";
	int cnt = 0;
	
	public PreTest2HS() {
		super("담당자 정보 확인하기");
		layInit();
		accDb();
		
		setBounds(100, 100, 450, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	private void layInit() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		
		JPanel panel1 = new JPanel();
		txtName = new JTextField("",5);
		panel1.add(new JLabel("고객명: "));
		panel1.add(txtName);
		panel.add(panel1);
		
		JPanel panel2 = new JPanel();
		txtJuminA = new JTextField("",8);
		txtJuminB = new JTextField("",8);
		btnOk.addActionListener(this);
		panel2.add(new JLabel("주민번호: "));
		panel2.add(txtJuminA);
		panel2.add(new JLabel(" - "));
		panel2.add(txtJuminB);
		panel2.add(btnOk);
		panel.add(panel2);
		
		add("North", panel);
		
		txtResult.setEditable(false);
		txtResult.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(txtResult);
	}
	
	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
		} catch (Exception e) {
			System.out.println("accDb err: " + e);
		}
	}
		
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 데이터 모두 입력했는지 검사
		if(txtName.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "고객명 미입력", "알림", JOptionPane.INFORMATION_MESSAGE);
			txtName.requestFocus();
			return;
		} else if(txtJuminA.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "주민번호 앞자리 미입력", "알림", JOptionPane.INFORMATION_MESSAGE);
			txtJuminA.requestFocus();
			return;
		} else if(txtJuminB.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "주민번호 뒷자리 미입력", "알림", JOptionPane.INFORMATION_MESSAGE);
			txtJuminB.requestFocus();
			return;
		}
		
		// 주민번호 형식이 맞는지 검사
		if(txtJuminA.getText().length()!=6) {
			JOptionPane.showMessageDialog(this, "주민번호 앞자리는 숫자 6자리입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			txtJuminB.requestFocus();
			return;
		} else if(txtJuminB.getText().length()!=7) {
			JOptionPane.showMessageDialog(this, "주민번호 뒷자리는 숫자 7자리입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			txtJuminB.requestFocus();
			return;
		}
		
		display();

        // 메모리 관리
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e2) {
			System.out.println("안 닫힐 수가 있네 " + e2);
		}
		
		// TextField 비워주기
		txtName.setText("");
		txtJuminA.setText("");
		txtJuminB.setText("");
		txtName.requestFocus();	
	}

	private void display() {
		sql = "select jikwon_no, jikwon_name, buser_name, buser_tel, jikwon_jik from jikwon "
				+ "inner join gogek on gogek_damsano = jikwon_no "
				+ "inner join buser on buser_num = buser_no "
				+ "where gogek_name = ? and substr(gogek_jumin,1,6) = ? and substr(gogek_jumin,8,14) = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, txtName.getText());
			pstmt.setString(2, txtJuminA.getText());
			pstmt.setString(3, txtJuminB.getText());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				txtResult.setText("담당직원 정보\n\n사번\t이름\t부서명\t전화\t\t직급\n");
				txtResult.append(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t\t"+rs.getString(5));
			} else {
				JOptionPane.showMessageDialog(this, "담당 직원 없음", "조회 불가능", JOptionPane.INFORMATION_MESSAGE);	
			}
		} catch (Exception e2) {
			System.out.println("로그인 err" + e2);
		}
	}


	public static void main(String[] args) {
		new PreTest2HS();
	}

}

