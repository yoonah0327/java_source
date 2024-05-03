package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// 커넥션 객체는 필요할때만 연결하고 끊는것이 원칙. 그러나 이 경우는 예외.
public class DBTest5RecMove extends JFrame implements ActionListener {
	JButton btnF = new JButton("|<<");
	JButton btnP = new JButton("<");
	JButton btnN = new JButton(">");
	JButton btnL = new JButton(">>|");

	JTextField txtNo = new JTextField("", 5);
	JTextField txtName = new JTextField("", 10);

	Connection conn;
	Statement stmt;
	ResultSet rs;

	public DBTest5RecMove() {
		super("레코드이동");

		layInit();
		accDb();

		setBounds(200, 200, 300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {

			if (e.getSource() == btnF)
				rs.first();
			else if (e.getSource() == btnP)
				rs.previous();
			else if (e.getSource() == btnN)
				rs.next();
			else if (e.getSource() == btnL)
				rs.last();

			display();
		} catch (Exception e2) {
			//JOptionPane.showMessageDialog(this, "자료의 처음 또는 끝입니다"); //?
		}

	}

	private void display() {
		try {
			txtNo.setText(rs.getString("jikwon_no"));
			txtName.setText(rs.getString("jikwon_name"));
		} catch (Exception e) {

		}
	}

	private void layInit() {
		JPanel p1 = new JPanel(); // flowlayout 배치관리자
		p1.add(new JLabel("직원자료: "));
		txtNo.setEditable(false); // 둘다 손못대는건 같음. 편집불가.
		txtName.setEnabled(false); // 아예비활성화.
		p1.add(txtNo);
		p1.add(txtName);
		add("North", p1);

		JPanel p2 = new JPanel();
		p2.add(btnF);
		p2.add(btnP);
		p2.add(btnN);
		p2.add(btnL);
		add("Center", p2);

		btnF.addActionListener(this);
		btnP.addActionListener(this);
		btnN.addActionListener(this);
		btnL.addActionListener(this);

	}

	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			processDb();
		} catch (Exception e) {
			System.out.println("accDb err:" + e);
		}
	}

	private void processDb() {
		try {
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery("select jikwon_no, jikwon_name from jikwon");
			// sql injection. https://velog.io/@k4minseung/DB-SQL-Injection-%EA%B3%B5%EA%B2%A9%EA%B3%BC-%EB%B0%A9%EC%96%B4-%EB%B0%A9%EB%B2%95
			rs.next(); // 커서를 바로 밑으로 이동 
			display(); // 뜨자마자 바로보이게 해줌
		} catch (Exception e) {
			System.out.println("processDb err: " + e);
		}
	}

	public static void main(String[] args) {
		new DBTest5RecMove();
	}

}
