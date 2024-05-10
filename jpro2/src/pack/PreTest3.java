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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PreTest3 extends JFrame implements ActionListener {
	JTextField txtNo = new JTextField("",5);
	JTextField txtName = new JTextField("", 10);
	JButton btn= new JButton("로그인");
	JTextArea txtTable = new JTextArea();
	JTextArea txtResult = new JTextArea();


Connection conn;
PreparedStatement pstmt, pstmtNo, pstmtName, pstmtFinal; // 선처리 방식
ResultSet rs;

	public PreTest3() {
		super("로그인");
		layInit();
		accDb();

		setBounds(200, 200, 800, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	private void layInit() { // 한줄에 직원번호칸 이름칸 로그인버튼 / 그리고 결과출력
		setLayout(new GridLayout(3, 1));
		
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("직원 번호: "));
		panel1.add(txtNo);
		panel1.add(new JLabel("이름: "));
		panel1.add(txtName);
		panel1.add(btn);
		add(panel1);
		
		txtTable.setEditable(false);
		txtResult.setEditable(false);
		JScrollPane pane = new JScrollPane(txtTable);
		add(pane);
		add(txtResult);
		
		btn.addActionListener(this);
	}
	
	private void accDb() { // 데이터베이스 드라이브 로딩
		try {
			Class.forName("org.mariadb.jdbc.Driver");
	
		} catch (Exception e) {
			System.out.println("accDb err:" + e);

		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			txtTable.setText(null);
			txtResult.setText(null); 
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
			
			String sql = "";
			String sqlNum = "";
			String sqlName = "";
			String sqlFinal = "";
			String sql2 = "";
			
			
		}
		
		// 직원번호, 이름 입력 
		String sql = "select jikwon_name from jikwon where jikwon_no = ? and jikwon_name =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, txtNo.getText());
		pstmt.setString(2, txtName.getText());
		
		// 직원번호, 이름  검사
		
		try {
			int a = Integer.parseInt(txtNo.getText());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "직원번호 미입력");
			txtNo.requestFocus();
		}
		
		
		if ( rs.getString("jikwon_no").equals(txtNo.getText())) {
			JOptionPane.showMessageDialog(this, "직원번호 미입력");
			txtNo.requestFocus();
			return;
		} else if (txtJikName.getText().equals("")) {
			txtResult.setText("직원번호 미입력");
			txtJikName.requestFocus();
			return;
		}
		
		// 데이터 숫자확인(직원번호)
		try {
			jikno = Integer.parseInt(txtJikNo.getText());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "직원번호를 숫자로 입력하시오", "오류!", JOptionPane.INFORMATION_MESSAGE);
			txtJikNo.setText("");
			txtJikNo.requestFocus();
			return;
		}
		
		// 1. 해당 직원번호, 이름의 직원이 있다면, 모든직원자료 출력
		// 사번 직원명 연봉 직급 평점
		// SELECT jikwon_jik on where jikwon_no= ? and jikwon_name= ?;
		// Select * from jikwon
		
		try {
			sql ="GRANT SELECT ON jikwon TO jikwon_no= ? and jikwon_name= ?"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, jikno);
			pstmt.setString(2, txtJikName.getText());
			rs = pstmt.executeQuery();
			txtResult.setText("사원\t직원명\t연봉\t직급\t평점\n");
			if(rs.next()) { 
				System.out.println(
						rs.getString("jikwon_no") + "\t" + rs.getString("jikwon_name") + "\t" 
								+ rs.getString("jikwon_pay") + "\t" + rs.getString("jikwon_jik")
								+ rs.getString("jikwon_rating"));
				
			}
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "일치하는 직원 없음 ", "오류", JOptionPane.INFORMATION_MESSAGE);
			txtJikNo.setText("");
			txtJikName.setText("");
			txtJikNo.requestFocus();
			return;
		}
		// 2. 직급별 연봉평균
		// 이사: 부장: 과장: 대리: 사원: 
		// SELECT jikwon_jik 직급, avg(jikwon_pay) 연봉 평균 FROM jikwon GROUP BY jikwon_jik order by jikwon_jik;
		//SELECT jikwon_jik 직급, avg(jikwon_pay) 연봉평균 FROM jikwon GROUP BY jikwon_jik order by 연봉평균 desc;
		// SELECT AVG(jikwon_pay) FROM jikwon WHERE jikwon_jik= ?;
		// getString 
		try {
			sql ="SELECT jikwon_jik 직급, avg(jikwon_pay) 연봉평균 FROM jikwon GROUP BY jikwon_jik order by 연봉평균 desc"; 
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			txtResult.setText("직급별 연봉 평균\n");
			if(rs.next()) { 
				System.out.println(
						rs.getString("직급") + "\t" + rs.getString("연봉평균"));	
			}
			
		} catch (Exception e2) {
			System.out.println("err: " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {

			}
		}
		
		
		
	}
	
	public static void main(String[] args) {
		new PreTest3();
		

	}

}