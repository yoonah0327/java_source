package pack;

// dbpract의 내용을 콘솔에서가 아닌 gui에서 띄워보자
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DBTest3Gogek extends JFrame implements ActionListener {
	JButton btnA = new JButton("전체");
	JButton btnM = new JButton("남자");
	JButton btnF = new JButton("여자");
	JTextArea txtResult = new JTextArea();

	Connection conn;
	Statement stmt;
	ResultSet rs;

	public DBTest3Gogek() {
		setTitle("고객자료");
		layInit();
		accDb();

		setBounds(200, 200, 300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void layInit() {
		JPanel jpanel = new JPanel();
		jpanel.add(btnA);
		jpanel.add(btnM);
		jpanel.add(btnF);

		txtResult.setEditable(false); // readonly// 출력물에 손 못대게 해놨다. 고객정보변경되면 안되므로.
		JScrollPane pane = new JScrollPane(txtResult);

		add("Center", pane);
		add("North", jpanel);

		btnA.addActionListener(this);
		btnM.addActionListener(this);
		btnF.addActionListener(this);

	}

	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("accDb err:" + e);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// db 연결은 필요시 접속하고 작업이 끝나면 반드시 연결을 해야해야한다. 부하걸림!
		// mybatis > JPA : ?
		try {
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
			stmt = conn.createStatement();
			String sql = "select gogek_no, gogek_name, gogek_jumin from gogek";

			if (e.getSource() == btnA) {

			} else if (e.getSource() == btnM) {
				sql += " where gogek_jumin like '%-1%'";
				// sql+= " where substr(gogek_jumin,8,1)=1";
			} else if (e.getSource() == btnF) {
				sql += " where gogek_jumin like '%-2%'";
			}
			txtResult.setText(null); // null대신""도 ok. 자료출력전 입력칸을 지워주기
			rs = stmt.executeQuery(sql);
			int cnt = 0;
			txtResult.setText("고객번호\t고객명\t주민번호\n");

			while (rs.next()) {
				String imsi = rs.getString("gogek_no") + "\t" + rs.getString("gogek_name") + "\t"
						+ rs.getString("gogek_jumin") + "\n";
				txtResult.append(imsi); 
				cnt++;

			}
			txtResult.append("인원수: " + cnt); // 레이블출력해주고 받아온 정보(sql문)랑 인원수를 출력하고자하면
			// append메소드를 써야한다. setText는 덮어쓰기로 리셋되어버린다. 
			//System.out.println("인원수: " + cnt); // 이건 콘솔창에 출력 
			
		} catch (Exception e2) {
			System.out.println("actionperformed err:" + e);
		} finally {
			try {
				if (rs != null)
					rs.close(); // 쓰고나면 꼭 반납하자!!
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
	}

	public static void main(String[] args) {
		new DBTest3Gogek();
	}

}
