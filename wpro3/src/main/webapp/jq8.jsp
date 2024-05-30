<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//csv 형태로 
Connection conn =null;;
PreparedStatement pstmt =null;
ResultSet rs=null;



try{
	Class.forName("org.mariadb.jdbc.Driver");
	String url = "jdbc:mariadb://localhost:3306/test";
	conn = DriverManager.getConnection(url, "root", "123");
	
	String keyword= request.getParameter("keyword");
	//System.out.println("keyword: "+keyword);
	
	String sql= "select jikwon_name from jikwon where jikwon_name like ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,keyword+ "%");
	rs = pstmt.executeQuery();
	
	ArrayList<String> list = new ArrayList<String>();
	
	while(rs.next()){
		list.add(rs.getString("jikwon_name"));
		
	}
	out.print(list.size()); 
	out.print("|"); //list.size()가 2라고 가정한다면, 2|이렇게 찍히도록 모양세팅.
	for(int i=0; i<list.size(); i++){
		String data = list.get(i);
		out.print(data);
		if(i<list.size()-1){ // 마지막 콤마는 안찍히도록
			out.print(","); //데이터를 ,로 구분
		}
	}
}catch(Exception e){
	System.out.println("에러:"+e); 
}finally{
	try{
		rs.close();
		pstmt.close();
		conn.close();
	}catch(Exception e){	
	}
}



%>