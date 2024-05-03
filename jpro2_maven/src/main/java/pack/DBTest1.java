package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// 마리아db(원격 db 서버) 연동 프로그래밍 
public class DBTest1 {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	public DBTest1() {
		// 1. Driver file 로딩
		// JDBC 드라이버 로딩 : 사용하고자 하는 JDBC 드라이버를 로딩한다.
		// JDBC 드라이버는 DriverManager 클래스를 통해 로딩된다.
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// 오라클, 마이에스큐엘꺼도 추가해주자.
		} catch (Exception e) {
			System.out.println("로딩실패: " + e);
			return;
		}
		// 2. DB server와 연결: 커낵션 객체 생성
		// socket?
		// Connection 객체 생성 : JDBC 드라이버가 정상적으로 로딩되면 DriverManager를 통해
		// 데이터베이스와 연결되는 세션(Session)인 Connection 객체를 생성한다.
		try {
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
		} catch (Exception e) {
			System.out.println("연결실패: " + e.getMessage());
		}
		// 3. 연결된 DB서버에 SQL을 실행
		try {
			// statement 객체생성
			// Statement 객체 생성 : Statement 객체는 작성된 SQL 쿼리문을
			// 실행하기 위한 객체로 정적 SQL 쿼리 문자열을 입력으로 가진다.
			stmt = conn.createStatement();
			// query 실행
			// Query 실행 : 생성된 Statement 객체를 이용하여 입력한 SQL 쿼리를 실행한다.
			// result객체로부터 sangdata 테이블 자료 읽기
			// ResultSet 객체로부터 데이터 조회 : 실행된 SQL 쿼리문에 대한 결과 데이터셋이다.
			rs = stmt.executeQuery("select code, sang, su, dan from sangdata"); // 인스턴스해줘~
			//rs = stmt.executeQuery("select * from sangdata");
			// 칼럼명을 통으로 가져올때 *로. 번거로워도 되도록이면 칼럼명을 모두 기입해주는게 좋다.
			// rs.next(); // 커서(레코드포인터) 이동
			// 이걸 안쓰면 커서위치에서 칼럼의 내용을 읽을수가없다.
			// System.out.println(rs.getString("sang"));
			
			while (rs.next()) { // 자료가 있는동안 반복하게하자.
				String code = rs.getString("code"); // 코드가 숫자지만 문자열로 받았다
				String sangname = rs.getString("sang"); // 문자로받음
				int su = rs.getInt("su");
				int dan = rs.getInt("dan"); // 정수로 받음
				System.out.println(code + " " + sangname + " " + su + " " + dan);
			}
			
			System.out.println("-----------------");
			rs = stmt.executeQuery("select code as 코드, sang as 상품명, dan, su from sangdata"); // 다시 인스턴스해주는거~
			while (rs.next()) {
				String code = rs.getString("코드"); // 코드가 숫자지만 문자열로 받았다
				String sangname = rs.getString(2); // 문자로받음
				int su = rs.getInt(3); // 원본테이블 무관, 내가 적은 칼럼명순번으로. 따라서 3번째는 dan칼럼내용이 su에 들어가게된다
				int dan = rs.getInt("dan"); // 정수로 받음
				System.out.println(code + " " + sangname + " " + su + " " + dan);
			}// 컬럼명은 1부터 순서가 부여된다. 별명 혹은 순번으로 불러주자. 
			
			// String sql = "select count(*) as 건수 from sangdata";
			String sql = "select count(*) from sangdata";
			// 별명을 붙여주는순간 원칼럼명이었던 count(*)는 쓸수없다
			rs = stmt.executeQuery(sql);
			rs.next();
			// System.out.println("건수: "+ rs.getString("건수"));
			// System.out.println("건수: "+ rs.getString("count(*)"));
			System.out.println("건수: " + rs.getString(1));
			// 1번째 칼럼이기에 숫자1만 써줘도 동일하게 읽어준다.
		} catch (Exception e) {
			System.out.println("처리실패: " + e);
		} finally {
			try {
				if(rs != null) rs.close(); //garbage collector?!
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
			}
		}
	}

	public static void main(String[] args) {
		new DBTest1();

	}

}
