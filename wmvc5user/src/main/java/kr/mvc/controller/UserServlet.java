package kr.mvc.controller;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.m2")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; //없어도 문제없음
	
	private ModelAndView modelAndView = null;
	private Controller controller= null;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//파일명 요청으로 사용
		try {
			String ss= request.getRequestURI();
			//System.out.println("ss: "+ss);
			int idx = ss.lastIndexOf('/');
			StringTokenizer st = new StringTokenizer(ss.substring(idx+1),".");
			ss = st.nextToken();
			//System.out.println("ss: "+ss); // login, list, insert, view
			String command = ss;
			
			controller = getController(command); // 여러개의 컨트롤러의 주소를 넘기고. 
			modelAndView = controller.execute(request, response); 
			//부모객체에서 받은걸 갖고 modelandview로 넘김 
			// 이번엔 리스트컨트롤러의 익스큐트를 만남.
			
			//파일 호출 방식 선택
			if(modelAndView.isRedirect()) { //리다이렉트방식. login insert
				response.sendRedirect(modelAndView.getViewName()); 
			}else { //포워드방식. list view
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/"+ modelAndView.getViewName());
				dispatcher.forward(request, response); 
			}
		} catch (Exception e) {
			System.out.println("service err: "+e);
		}
				
	}
	public Controller getController(String command) throws Exception{
		if(command.equals("login")) {
			controller = new LoginController();
		}else if(command.equals("list")) {
			controller = new ListController();
		}else if(command.equals("insert")) {
			controller = new InsertController();
		}else if(command.equals("view")) {
			controller = new ViewController();
		}else if(command.equals("logout")) {
			controller = new LogoutController();
		}else if(command.equals("updateform")) {
			controller = new UpdateFormController();
		}else if(command.equals("update")) {
			//controller = new UpdateController();
		}else if(command.equals("delete")) {
			//controller = new DeleteController();
		}
		
		return controller; //로그인컨트롤러주소 반환. 리스트컨트롤러주소반환. 
	}
}
