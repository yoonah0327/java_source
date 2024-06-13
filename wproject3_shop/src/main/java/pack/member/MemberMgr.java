package pack.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberMgr {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	public MemberMgr() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria");
		} catch (Exception e) {
			System.out.println("Db 연결 실패:"+e);
		}
	}
	
	//동이름으로 우편자료 검색 
	//ArrayList<ZipcodeDto> zlist = memberMgr.zipcodeRead(dongName);
	public ArrayList<ZipcodeDto> zipcodeRead(String dongName){
		ArrayList<ZipcodeDto> list = new ArrayList<ZipcodeDto>();
		try {
			conn = ds.getConnection();
			String sql="select * from ziptab where area3 like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dongName+"%"); //이 글자로 시작되는.
			rs= pstmt.executeQuery();
			
			while(rs.next()) { // 1개이상의 자료출력. rs.next이유: 모든자료가 소진될때까지 밑으로 내려줌. 그래서 while문으로 돌려줌.
				ZipcodeDto dto = new ZipcodeDto();
				dto.setZipcode(rs.getString("zipcode"));
				dto.setArea1(rs.getString("area1"));
				dto.setArea2(rs.getString("area2"));
				dto.setArea3(rs.getString("area3"));
				dto.setArea4(rs.getString("area4"));
				list.add(dto);
			}
					
		} catch (Exception e) {
			System.out.println("zipcodeRead err:"+e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}
	
	//아이디중복검사
	//boolean b = memberMgr.idCheckProcess(id);
	public boolean idCheckProcess(String id) {
		boolean b = false;
		
		try {
			conn = ds.getConnection();
			String sql = "select id from member where id=?";
			//String sql = "select count(*) from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs= pstmt.executeQuery();
			b= rs.next();//있으면 true 없으면 false;
			
		}catch (Exception e) {
			System.out.println("idCheckProcess err:"+e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return b;
		
	}
	
	//boolean b = memberMgr.memberInsert(mbean);
	public boolean memberInsert(MemberBean mbean) {
		boolean b= false;
		System.out.println(mbean.getId()+mbean.getName());
		
		try {
			conn=ds.getConnection();
			String sql="insert into member values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mbean.getId());
			pstmt.setString(2, mbean.getPasswd());
			pstmt.setString(3, mbean.getName());
			pstmt.setString(4, mbean.getEmail());
			pstmt.setString(5, mbean.getPhone());
			pstmt.setString(6, mbean.getZipcode());
			pstmt.setString(7, mbean.getAddress());
			pstmt.setString(8, mbean.getJob());
			if(pstmt.executeUpdate()>0) b = true;
			
		}catch (Exception e) {
			System.out.println("memberInsert err:"+e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return b;
	}
	//boolean b= memberMgr.loginCheck(id, passwd);
	public boolean loginCheck(String id, String passwd) {
		boolean b= false;
		
		try {
			conn=ds.getConnection();
			String sql="select * from member where id=? and passwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs= pstmt.executeQuery();
			b=rs.next();
		}catch (Exception e) {
			System.out.println("loginCheck err:"+e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return b;
	}
	
	//MemberBean bean = memberMgr.getMember(id);
	public MemberBean getMember(String id) {
		MemberBean bean = null;
		
		try {
			conn= ds.getConnection();
			String sql= "select * from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean= new MemberBean();
				bean.setId(rs.getString("id"));
				bean.setPasswd(rs.getString("passwd"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setPhone(rs.getString("phone"));
				bean.setZipcode(rs.getString("zipcode"));
				bean.setAddress(rs.getString("address"));
				bean.setJob(rs.getString("job"));
			}
			
			
		}catch (Exception e) {
			System.out.println("loginCheck err:"+e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return bean;
	}
}
	
