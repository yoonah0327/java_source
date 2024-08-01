package kr.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.mvc.model.UserManager;

public class LoginController implements Controller{
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String id= request.getParameter("userid");
		String pwd = request.getParameter("password");
		
		//모델과통신. 디비
		UserManager manager = UserManager.instance();
		boolean b = manager.login(id, pwd);
		
		ModelAndView modelAndView = new ModelAndView(); 
		if(b) {
			//로그인 성공 자격을 갖춤
			HttpSession session = request.getSession(true);
			session.setAttribute("userid", id);
			modelAndView.setViewName("list.m2");
			//따라서 modelAndView.setViewName("list.m2");는 
			//로그인 성공 시 사용자를 "list.m2"라는 뷰로 리다이렉트하여 해당 화면을 보여주겠다는 의미
		}else {
			modelAndView.setViewName("fail.html");
		}
		modelAndView.setRedirect(true);
		return modelAndView;
		
	}
	

}
