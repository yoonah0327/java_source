
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
{"sangpum":
[
<%
//sangdata 테이블을 읽어 JSON 형식으로 출력 
Connection conn =null;;
PreparedStatement pstmt =null;
ResultSet rs=null;

try{
	Class.forName("org.mariadb.jdbc.Driver");
	
	String url = "jdbc:mariadb://localhost:3306/test";
	conn = DriverManager.getConnection(url, "root", "123");
	pstmt = conn.prepareStatement("select * from sangdata");
	rs = pstmt.executeQuery();
		
	//rs.next();
	//out.print(rs.getString("sang")); 
	String result="";
	
	while(rs.next()){
	result += "{";
	result += "\"code\":" + "\""+rs.getString("code")+"\",";
	result += "\"sang\":" + "\""+rs.getString("sang")+"\",";
	result += "\"su\":" + "\""+rs.getString("su")+"\",";
	result += "\"dan\":" + "\""+rs.getString("dan")+"\"";
	result += "},";
	}
	if(result.length()>0){
		result = result.substring(0,result.length()-1);//전체길이-1만큼만 반환
	}
	out.print(result);
}catch(Exception e){
	System.out.println("에러:"+e); // 표준출력장치console
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
}

