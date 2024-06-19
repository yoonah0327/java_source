package pack.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class OrderMgr {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	public OrderMgr() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria");
		} catch (Exception e) {
			System.out.println("Db 연결 실패:"+e);
		}
	}
	//ArrayList<OrderBean> list = orderMgr.getOrder(id);
	public ArrayList<OrderBean> getOrder(String id){
		ArrayList<OrderBean> list = new ArrayList<OrderBean>();
		
		try {
			conn = ds.getConnection();
			String sql= "select * from shop_order where id=? order by no desc";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);;
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				OrderBean bean = new OrderBean();
				bean.setNo(rs.getString("no"));
				bean.setProduct_no(rs.getString("product_no"));
				bean.setQuantity(rs.getString("quantity"));
				bean.setSdate(rs.getString("sdate"));
				bean.setState(rs.getString("state"));
				bean.setId(rs.getString("id"));
				list.add(bean);
				
			}
		} catch (Exception e) {
			System.out.println("getOrder err:"+e);
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
	
	//orderMgr.insertOrder(orderBean);
	public void insertOrder(OrderBean bean) {
		try {
			conn = ds.getConnection();
			String sql= "insert into shop_order(product_no, quantity, sdate, state, id)"
					+ "values(?,?,now(),?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getProduct_no());
			pstmt.setString(2, bean.getQuantity());
			pstmt.setString(3, "1"); //1:접수 2:입금하기 3:배송준비 4:배송중 5:처리완료
			pstmt.setString(4, bean.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("insertOrder err:"+e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	// ArrayList<OrderBean> list = orderMgr.getOrderAll();
	public ArrayList<OrderBean> getOrderAll(){
		ArrayList<OrderBean> list = new ArrayList<OrderBean>();
		
		try {
			conn = ds.getConnection();
			String sql= "select * from shop_order order by no desc";
			
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				OrderBean bean = new OrderBean();
				bean.setNo(rs.getString("no"));
				bean.setProduct_no(rs.getString("product_no"));
				bean.setQuantity(rs.getString("quantity"));
				bean.setSdate(rs.getString("sdate"));
				bean.setState(rs.getString("state"));
				bean.setId(rs.getString("id"));
				list.add(bean);
				
			}
		} catch (Exception e) {
			System.out.println("getOrderAll err:"+e);
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
	
	//OrderBean order= orderMgr.getOrderDetail(request.getParameter("no");
	public OrderBean getOrderDetail(String no){ //하나만 수정할 예정. 
		OrderBean bean = null;
		
		try {
			conn = ds.getConnection();
			String sql= "select * from shop_order where no=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);;
			rs= pstmt.executeQuery();
			
			if(rs.next()) { //1개니까 while이 아닌 if
				bean = new OrderBean();
				bean.setNo(rs.getString("no"));
				bean.setProduct_no(rs.getString("product_no"));
				bean.setQuantity(rs.getString("quantity"));
				bean.setSdate(rs.getString("sdate"));
				bean.setState(rs.getString("state"));
				bean.setId(rs.getString("id"));
				
			}
		} catch (Exception e) {
			System.out.println("getOrderDetail err:"+e);
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
	

