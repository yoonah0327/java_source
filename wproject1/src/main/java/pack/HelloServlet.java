package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/HelloServlet")
@WebServlet(name ="ServletGo", urlPatterns = {"/HelloServlet", "/good.kor", "/dajung"}, loadOnStartup = 1) 
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get 요청 성공");
		
		//서블릿(웹용 자바)으로 클라이언트 브라우저에 데이터 전송
		response.setContentType("text/html;charset=utf-8"); //Mime type과 문자코드를 적어준다
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>헬로서블릿 문서</h1>");
		out.println("안녕 반가워");
		out.println("</body></html>");
		out.close();
	}

}
