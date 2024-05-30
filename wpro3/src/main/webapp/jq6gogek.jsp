<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>

[
<%
//gogek 테이블을 읽어 JSON 형식으로 출력 
Connection conn =null;;
PreparedStatement pstmt =null;
ResultSet rs=null;

String arg= request.getParameter("arg");

try{
	Class.forName("org.mariadb.jdbc.Driver");
	
	String url = "jdbc:mariadb://localhost:3306/test";
	conn = DriverManager.getConnection(url, "root", "123");
	pstmt = conn.prepareStatement("select gogek_name, gogek_tel from gogek inner join jikwon on gogek_damsano=jikwon_no where jikwon_no=?");
	pstmt.setString(1, arg);
	rs = pstmt.executeQuery();
		
	String result="";
	
	while(rs.next()){
	result += "{";
	result += "\"gogek_name\":" + "\""+rs.getString("gogek_name")+"\",";
	result += "\"gogek_tel\":" + "\""+rs.getString("gogek_tel")+"\"";
	result += "},";
	}
	if(result.length() > 0){
		result = result.substring(0,result.length()-1);
	}
	out.print(result);
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
]


