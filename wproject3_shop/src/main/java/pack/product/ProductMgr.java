package pack.product;

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

import pack.member.ZipcodeDto;

public class ProductMgr {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	public ProductMgr() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria");
		} catch (Exception e) {
			System.out.println("Db 연결 실패:"+e);
		}
	}
	
	public ArrayList<ProductDto> getproductAll(){
		ArrayList<ProductDto> list = new ArrayList<ProductDto>();
		
		try {
			conn = ds.getConnection();
			String sql="select * from shop_product order by no desc";
			pstmt= conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				ProductDto dto = new ProductDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getString("price"));
				dto.setDetail(rs.getString("detail"));
				dto.setSdate(rs.getString("sdate"));
				dto.setStock(rs.getString("stock"));
				dto.setImage(rs.getString("image"));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("getproductAll err:"+e);
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
	
	//result = productMgr.insertProduct(request);
	public boolean insertProduct(HttpServletRequest request){
		boolean b= false;
		
		try {
			//업로드할 이미지 경로: upload 폴더(절대경로)
			String uploadDir= "C:/work/jsou/wproject3_shop/src/main/webapp/upload";
			
			MultipartRequest multi= new MultipartRequest(request, uploadDir, 
					5*1024*1024, "UTF-8", new DefaultFileRenamePolicy()); //파일사이즈, 맨뒤는정책명.
			//System.out.println(multi.getParameter("name"));
			//System.out.println(multi.getParameter("price"));
			conn = ds.getConnection();
			String sql= "insert into shop_product(name, price, detail, sdate, stock, image)"+ 
			" values(?,?,?,now(),?,?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, multi.getParameter("name"));
			pstmt.setString(2, multi.getParameter("price"));
			pstmt.setString(3, multi.getParameter("detail"));
			pstmt.setString(4, multi.getParameter("stock"));
			//이미지 파일명. 파일업로드안할수도있다. 
			if(multi.getFilesystemName("image") == null) {//상품등록시 이미지를 선택하지 않은 경우
				pstmt.setString(5, multi.getParameter("ready.gif"));
			}else {
				pstmt.setString(5, multi.getFilesystemName("image"));
			}
			if(pstmt.executeUpdate() > 0) b= true; //>0말고 =1이렇게 물어봐도된다.
		}catch (Exception e) {
			System.out.println("insertProduct err:"+e);
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
	
	//ProductDto dto = productMgr.getProduct(no);
	public ProductDto getProduct(String no){
		ProductDto dto = null;
		
		try {
			conn = ds.getConnection();
			String sql= "select * from shop_product where no=?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new ProductDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getString("price"));
				dto.setDetail(rs.getString("detail"));
				dto.setSdate(rs.getString("sdate"));
				dto.setStock(rs.getString("stock"));
				dto.setImage(rs.getString("image"));
			}
			
		}catch (Exception e) {
			System.out.println("getProduct err:"+e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return dto;
	}
	
}
