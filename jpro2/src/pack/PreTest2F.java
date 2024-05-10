package pack;

import java.awt.GridLayout;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PreTest2F extends JFrame implements ActionListener {
	JTextField txtGName, txtGJumin1, txtGJumin2;
	//int gjumin1, gjumin2;
	JButton btnOk = new JButton("확인");
	JTextArea txtResult = new JTextArea();

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public PreTest2F() {
		super("담당자 정보 확인하기");
		layInit();
		accDb();

		setBounds(200, 200, 800, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void layInit() { // 레이블 만들기 // 에러남!! 
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));;
		
		JPanel panel1 = new JPanel();
		txtGName = new JTextField("", 5);
		panel1.add(new JLabel("고객명: "));
		panel1.add(txtGName);
		panel.add(panel1);

		JPanel panel2 = new JPanel();
		txtGJumin1 = new JTextField("", 6);
		txtGJumin2 = new JTextField("", 6);
		btnOk.addActionListener(this);
		panel2.add(new JLabel("주민번호: "));
		panel2.add(txtGJumin1);
		panel2.add(new JLabel("-"));
		panel2.add(txtGJumin2);
		panel2.add(btnOk);
		panel.add(panel2);
		
		add("North", panel);
		
		txtResult.setEditable(false);
		txtResult.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		add(txtResult);
		


	}

	private void accDb() { // 데이터 연동
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
	
		} catch (Exception e) {
			System.out.println("accDb err:" + e);

		}
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// 데이터 입력검사
		if (txtGName.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "고객명 미입력", "알림", JOptionPane.INFORMATION_MESSAGE);
			txtGName.requestFocus();
			return;
		} else if (txtGJumin1.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "주민번호 앞자리 미입력", "알림", JOptionPane.INFORMATION_MESSAGE);
			txtGJumin1.requestFocus();
			return;
		} else if (txtGJumin2.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "주민번호 앞자리 미입력", "알림", JOptionPane.INFORMATION_MESSAGE);
			txtGJumin2.requestFocus();
			return;
		}
	
		
		// 데이터 숫자검사(주민번호1, 2)
		
		if(txtGJumin1.getText().length()!=6) {
			JOptionPane.showMessageDialog(this, "주민번호 앞자리는 숫자 6자리입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			txtGJumin1.requestFocus();
			return;
		} else if (txtGJumin2.getText().length()!=7) {
			JOptionPane.showMessageDialog(this, "주민번호 뒷자리는 숫자 7자리입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			txtGJumin2.requestFocus();
			return;
		}
		
		display(); // 출력 메소드
		// 메모리관리
			try {
				if (rs != null)
					rs.close(); // 쓰고나면 꼭 반납하자!!
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		
			// TextField 비워주기
			txtGName.setText("");
			txtGJumin1.setText("");
			txtGJumin2.setText("");
			txtGName.requestFocus();	
		}
	
	
	// 해당 고객에 맞는 직원정보 읽어오기- 부분읽기
	private void display() {

				String sql = "select jikwon_no, jikwon_name, buser_name, buser_tel, jikwon_jik \r\n"
						+ "from jikwon \r\n"
						+ "inner join buser on buser_no=buser_num\r\n"
						+ "INNER JOIN gogek ON gogek_damsano= jikwon_no"
				 + "WHERE gogek_name=? and substr(gogek_jumin, 1, 6)=? and substr(gogek_jumin, 8, 14)=?";
				 try {
					 pstmt= conn.prepareStatement(sql);
						pstmt.setString(1, txtGName.getText());
						pstmt.setString(2, txtGJumin1.getText());
						pstmt.setString(3, txtGJumin2.getText());
						rs = pstmt.executeQuery();
						if(rs.next()) {
						txtResult.setText("담당직원 정보\n\n사번\t이름\t부서명\t전화\t\t직급\n");
						txtResult.append(rs.getString(1)+ "\t"
							+rs.getString(2)+ "\t"
							+rs.getString(3)+ "\t"
							+rs.getString(4)+ "\t"
							+rs.getString(5));
				} else {
					JOptionPane.showMessageDialog(this, "담당 직원 없음", "조회 불가능", JOptionPane.INFORMATION_MESSAGE);
				}			
			} catch (Exception e2) {
				System.out.println("담당 직원 없음" + e2);
			}
	}
	public static void main(String[] args) {
		new PreTest2F();
	}

}