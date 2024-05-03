package pack;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DbTest2CRUD {
	private Connection conn; // 1개
	private Statement stmt; // 여러개 가
	private ResultSet rs; // 여러개 가
	Properties prop = new Properties();

	public DbTest2CRUD() { // securer coding의 하나로 연결정보 별도저장후 읽기
		try {
			prop.load(new FileInputStream("C:\\work\\jsou\\jpro2\\src\\pack\\dbtest2.properties"));

			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
					prop.getProperty("passwd"));
			stmt = conn.createStatement();
			String sql = "";
	
			/*
			// 자료 추가. auto commit이 기본
			sql = "insert into sangdata values(5,'새우깡', 55,3000)"; //문자열, 날짜는 ''. 
			stmt.executeUpdate(sql); //insert, update, delete는 .executeUpdate. 

			
			// auto commit을 수동으로 전환해 작업: transaction 처리가 필요
			conn.setAutoCommit(false); // 수동전환
			sql = "insert into sangdata values(6,'감자깡', 7,3000)";
			stmt.executeUpdate(sql); //transaction 시작. 마무리 요!!
			sql = "insert into sangdata values(7,'고구마깡', 17,2000)";
			stmt.executeUpdate(sql);
			//conn.rollback();// transaction 종료됨. 클라이언트에서 입력한내용 취소.
			conn.commit();// transaction 종료. 클라이언트에서 입력한내용 원격db에 업로드.
			conn.setAutoCommit(true);
			*/
			
			// 자료 수정
//			sql = "update sangdata set sang= '데일리콤부차', su=12, dan=8000 where code=5";
//			stmt.executeUpdate(sql);
			
			// 자료 삭제
			sql= "delete from sangdata where code>=5";
			//stmt.executeUpdate(sql);
			//insert, update, delete는 수행 후 처리수만큼 행의갯수 반환
			//insert는 반환값이 실패시0or성공시1. update, delete는 반환값이 0이상. 
			int result = stmt.executeUpdate(sql);
			System.out.println("result:"+result);
			if(result == 0) System.out.println("삭제 실패");
			// 이러면 삭제된 값이 2개라 2개가 나온다. 삭제후 다시 run해보면 반환값은 0이나오게 된다. 
			
			
			
			// 모든 자료 읽기
			sql = "select * from sangdata order by code desc";
			rs = stmt.executeQuery(sql); // select는 .executeQuery
			int cou= 0;
			while(rs.next()) {
				System.out.println(rs.getString("code")+ " "+ 
						rs.getString("sang")+ " "+
						rs.getString("su")+ " "+
						rs.getString("dan"));
				cou++;
			} // db서버에 한번만 갖다오고, 카운트는 내가 하는것. 
			System.out.println("전체 자료수: "+ cou);
			
			// 부분 자료 읽기
			sql= "select *from sangdata where code=7";
			rs=stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println(rs.getString("code")+ " "+ 
						rs.getString("sang")+ " "+
						rs.getString("su")+ " "+
						rs.getString("dan"));
			}else {
				System.out.println("해당 자료는 없어요");
			}
			
		} catch (Exception e) {
			System.out.println("err: " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				;
				if (stmt != null)
					stmt.close();
				;
				if (conn != null)
					conn.close();
				;
			} catch (Exception e2) {

			}
		}
	}

	public static void main(String[] args) {
		new DbTest2CRUD();

	}

}
