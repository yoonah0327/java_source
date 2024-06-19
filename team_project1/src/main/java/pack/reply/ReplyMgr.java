package pack.reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReplyMgr {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	public ReplyMgr() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria");
		} catch (Exception e) {
			System.out.println("Db 연결 실패:"+e);
		}
	}
	
	//ArrayList<ReplyDto> list = replyMgr.getDataAll(bno);
	public ArrayList<ReplyDto> getDataAll(int bno){
		ArrayList<ReplyDto> list = new ArrayList<ReplyDto>();
		
		
		try {
			conn = ds.getConnection();
			String sql = "select * from reply order by reply_gnum desc, reply_onum asc ";
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			
		while(rs.next()) {
			ReplyDto dto= new ReplyDto();
			dto.setReply_no(rs.getInt(1));
			dto.setReply_book_no(rs.getInt(2));
			dto.setReply_id(rs.getString(3));
			dto.setReply_cont(rs.getString(4));
			dto.setReply_create_date(rs.getString(5));
			dto.setReply_point(rs.getInt(6));
			dto.setReply_like_cnt(rs.getInt(7));
			dto.setReply_del_is(rs.getInt(8));
			dto.setReply_del_date(rs.getString(9));
			dto.setReply_ip(rs.getString(10));
			dto.setReply_blocked(rs.getInt(11));
			dto.setReply_blocked_cnt(rs.getInt(11));
			dto.setReply_gnum(rs.getInt(13));
			dto.setReply_onum(rs.getInt(14));
			dto.setReply_title(rs.getString(15));
			list.add(dto);
		}
			
		} catch (Exception e) {
			System.out.println("getDataAll() err:"+e);
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
	public boolean insertReply(HttpServletRequest request){
		boolean b = false;
		
		try {
			//업로드할 이미지 경로: upload 폴더(절대경로)
			String uploadDir= "C:/work/jsou/team_project1/src/main/webapp/upload";
			
			MultipartRequest multi= new MultipartRequest(request, uploadDir, 
					5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			
			conn = ds.getConnection();
			String sql= "insert into reply(reply_no, reply_point, reply_title, reply_cont, reply_create_date, reply_image)"+ 
					" values(?,?,?,?,now(),?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, multi.getParameter("reply_no"));
			pstmt.setString(2, multi.getParameter("reply_point"));
			pstmt.setString(3, multi.getParameter("reply_title"));
			pstmt.setString(4, multi.getParameter("reply_cont"));
			//이미지 파일명. 파일 업로드 안할수도 있다.
			if(multi.getFilesystemName("reply_image") == null) {//상품등록시 이미지를 선택하지 않은 경우
				pstmt.setString(5, multi.getParameter("cookiecharc.jpg"));
			}else {
				pstmt.setString(5, multi.getFilesystemName("reply_image"));
			}if(pstmt.executeUpdate() > 0) b= true;
		
		}catch (Exception e) {
			System.out.println("insertReply err:"+e);
			//Field 'reply_no' doesn't have a default value //기본키. 꼭 불러서 값을 넣어주자.
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
	//int newNo= replyMgr.currentMaxNo()+1;
	public int currentMaxNo() { //reply 테이블의 최대 번호 반납
		String sql ="select max(reply_no) from reply";
		int no=0;
		
		try {
			conn=ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			if(rs.next()) no = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("currentMaxno err: "+e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				
			}
		}
		return no;
		
	}
	//replyMgr.saveData(bean);
	public void saveData(ReplyBean bean) {
		String sql= "insert into reply values(?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			conn=ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getReply_no());
			pstmt.setInt(2, bean.getReply_book_no());
			pstmt.setString(3, bean.getReply_id());
			pstmt.setString(4, bean.getReply_cont());
			pstmt.setString(5, bean.getReply_create_date());
			pstmt.setInt(6, bean.getReply_point());
			pstmt.setInt(7, 0);//Reply_like_cnt. 누적용 0.
			pstmt.setInt(8, bean.getReply_del_is());
			pstmt.setString(9, bean.getReply_del_date());
			pstmt.setString(10, bean.getReply_ip());
			pstmt.setInt(11, bean.getReply_blocked());
			pstmt.setInt(12, bean.getReply_blocked_cnt());
			pstmt.setInt(13, bean.getReply_gnum());
			pstmt.setInt(14, 0);//Reply_onum
			pstmt.setString(15, bean.getReply_title());
			pstmt.setString(16, bean.getReply_image());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("saveData err: "+e);
			//Cannot add or update a child row: a foreign key constraint fails 
			//(`bookie`.`reply`, CONSTRAINT `fk_reply_book` FOREIGN KEY (`reply_book_no`) REFERENCES `book` (`bnum`))
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				
			}
		}
	}
	//ReplyDto dto = ReplyDto.getReply_no(reply_no);
	

	
}
