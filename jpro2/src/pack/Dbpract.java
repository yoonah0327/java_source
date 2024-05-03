package pack;
// 키보드로 부서번호 받아 해당 부서 근무하는 직원자료 출력 

//부서번호
//사번 이름 부서 직급 연봉... 조인. 시큐어 ㄴㄴ
// 콘솔에 출력
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Dbpract {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	public Dbpract() {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			return;
		}

		try {
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
		} catch (Exception e) {

		}
		try { // 사번 이름 부서 직급 연봉
			stmt = conn.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("부서번호 입력(10,20,30,40 중 하나) : ");
			int num = sc.nextInt();

			int cnt = 0;
			System.out.println("사번" + " " + "이름\t부서\t직급\t연봉");
			rs = stmt.executeQuery(
					"select jikwon_no as 사번, jikwon_name as 이름, buser_name as 부서, "
					+ "jikwon_jik as 직급, jikwon_pay as 연봉 from jikwon "
					+ "inner join buser on buser_num=buser_no where buser_num="
							+ num);
			while (rs.next()) {
				String sabun = rs.getString(1);
				String irum = rs.getString(2);
				String buser = rs.getString(3);
				String jik = rs.getString(4);
				int pay = rs.getInt(5);
				System.out.println(sabun + " " + irum + " " + buser + " " + jik + " " + pay);
				cnt++;
			}
			System.out.println("처리건수: " + cnt);

		} catch (Exception e) {
			// System.out.println("cdfdf" +e);// 처리실패시 확인용
		} finally { //
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}

	}

	public static void main(String[] args) {
		new Dbpract();

	}

}
