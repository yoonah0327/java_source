package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ServletEx7Session") // session: 각 클라이언트의 정보를 웹서버에 메모리확보 후 저장. 
public class ServletEx7Session extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// service()쓰면 doGet, doPost 구분안한다는 뜻. service로 가서 선작업을 하고 넘어가버리기때문.
		//service를 안쓰면, doGet dePost를 구분해서 작업한다. 
		
		HttpSession session = request.getSession(true);// 세션이있으면 읽고, 없으면 세션생성함.
		//클라이언트가 요청시 클라이언트의 쿠키(그 안에 세션도)받아옴. 
		//HttpSession session = request.getSession(false);// 세션이있으면 읽고, 없으면 세션생성안함.
		session.setMaxInactiveInterval(10); //10초간 유효. 기본값은 30분. 절대적인시간x, 클라이언트가활동안할때부터카운트.
		//web.xml에 적을수도 있다. 단 그러면 프로젝트전체에 적용됨. 이경우는 이 파일만적용.
		
		if(session != null) { //이렇게 해주는순간 session id 생성후, 서버뿐아니라 클라이언트 컴의 쿠키에도 저장됨.
			session.setAttribute("name", "홍길동"); //키, 값주기. //{}로 복수로 작성할수도 있다. 크키는 동적.
			
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("session id: "+ session.getId());
		out.println("<br>사용자명: "+ session.getAttribute("name"));
		out.println("</body></html>");
		out.close();
	}
}
