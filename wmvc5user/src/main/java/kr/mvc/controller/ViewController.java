package kr.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mvc.model.UserDto;
import kr.mvc.model.UserManager;

public class ViewController implements Controller{
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 상세보기처리. userid받음. 
		request.setCharacterEncoding("utf-8");
		String userid= request.getParameter("userid");
		
		//모델과 통신
		//하나만 읽어오면 됨.
		UserDto dto = UserManager.instance().findUser(userid);
		//dto를 넘기고 싶은데 쿼리스트링으로는 스트링만 가능. 따라서 포워드방식으로 처리한다. request에 담아서넘김.
		request.setAttribute("user", dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view.jsp");//서버에서 서버로 넘김. 또 이걸 web-inf 에 넣을거다. 서버에서 서버로만 부르수밖에없음.
		modelAndView.setRedirect(false);
		
		return modelAndView;
	}
}
