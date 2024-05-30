package pack;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletEx3") 
public class ServletEx3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int num=0;
	
	public void init(ServletConfig config) throws ServletException {
		// 웹서버 서비스가 시작되면 자동호출. 현재 서블릿 클래스의 초기화를 담당. 최초요청에의해 1회만수행.
		num=1;
		System.out.println("init 수행: num="+num);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get, post요청시 매번 수행. doGet, doPost 호출 가. (doGet,doPost보다 우선순위가높다)ㄴ
		//jsp파일은 service메소드만을 가진 파일
		num +=1;
		System.out.println("service 수행: num="+num);
		
		doGet(request,response);
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get 요청시 수행
		num +=1;
		System.out.println("doGet 수행: num="+num);
	}
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 요청시 수행
		num +=1;
		System.out.println("doPost 수행: num="+num);
	}

	public void destroy() {
		// 웹서버 서비스가 종료되면 자동 호출. 마무리작업 담당. 
		System.out.println("destroy 호출");
	}
}
