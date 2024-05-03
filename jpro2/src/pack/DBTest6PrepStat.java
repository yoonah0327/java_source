package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
// preparedStatetment: 선처리방식이 가능. sql문에 입력자료 적용시 ? 연산자 사용가.
import java.sql.ResultSet;

public class DBTest6PrepStat {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public DBTest6PrepStat() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
			
			String sql= "";
			
			/*
			// 자료추가
			sql= "insert into sangdata values(?,?,?,?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, "10");
			pstmt.setString(2, "신상품");
			pstmt.setInt(3, 12);
			pstmt.setString(4, "5000");
			int re= pstmt.executeUpdate();
			System.out.println("insert 반환값:" +re);
			*/
			
			/*
			// 자료 수정
			sql= "update sangdata set sang=?, su=? where code=?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, "아메리카노");
			pstmt.setInt(2, 33);
			pstmt.setInt(3, 10);
			int re= pstmt.executeUpdate();
			System.out.println("update 반환값:" +re);
			*/
			
			// 자료 삭제
			sql= "delete from sangdata where code=?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, 10);
			if(pstmt.executeUpdate() >=1) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
			
			// 전체자료 읽기
			sql= "select * from sangdata";
			pstmt= conn.prepareStatement(sql);
			rs= pstmt.executeQuery();// 윗문장처럼 주고 그 다음은 안줘도됨. stmt.일때와차이.
			//rs = stmt.executeQuery("select jikwon_no, jikwon_name from jikwon");
			
			while (rs.next()) {
				System.out.println(
						rs.getString(1) + " " + rs.getString(2) + " " 
								+ rs.getString(3) + " " + rs.getString(4));
			}
			System.out.println();
			
			// 부분자료 읽기
			String no= "2";//외부에서 받았다고 가정.
			//sql= "select * from sangdata where code=" +no; // sql injection 공격대상-시큐어코딩 어긋남
			sql= "select * from sangdata where code=?"; // 시큐어코딩 가이드라인에 맞춰 코딩한다면 
			
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, no); // 1번째 ?에 no 매핑. 내가 선언한 no타입 맞춰서 setstring, setint. db의 코드타입칼럼과 무관!
			
			rs= pstmt.executeQuery();
			if(rs.next()) { 
				System.out.println(
						rs.getString("code") + " " + rs.getString("sang") + " " 
								+ rs.getString("su") + " " + rs.getString("dan"));
				
			}
			
		} catch (Exception e) {
			System.out.println("Err: " + e);
		}
	}

	public static void main(String[] args) {
		new DBTest6PrepStat();

	}

}
