package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.other.ServletEx2Other;

@WebServlet("/ServletEx2")
public class ServletEx2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletEx2Other other; //멤버필드로 뽑아올림
	
	public void init(ServletConfig config) throws ServletException {
		// 서버는 init()메소드 호출해서 Servlet 초기화.
		other = new ServletEx2Other("고길동"); //첫요청자는 이걸 만나지만, 그뒤요청자들은 만나지않는다.
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); //Mime type과 문자코드를 적어준다
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>서블릿 문서 Ex2</h1>");
		
		int a=10, b=20; //지역변수출력
		out.println("a: "+a+" b: "+b);
		
		int tot= calcData(a,b); //현클래스의 메소드호출
		out.println("<br>두 수의 합은 "+tot);
		
		//ServletEx2Other other = new ServletEx2Other("홍길동");//클래스 호출 자제!! 
		String ir = other.getIrum();
		out.println("<br>이름은 "+ir);
		
		out.println("</body></html>");
		out.close();
	}
	
	private int calcData(int a, int b) {
		int imsi = a+b;
		return imsi;
		
	}

}
