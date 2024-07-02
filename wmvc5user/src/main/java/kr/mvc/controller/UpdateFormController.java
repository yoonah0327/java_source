package kr.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mvc.model.UserDto;
import kr.mvc.model.UserManager;

public class UpdateFormController implements Controller{
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//수정화면 띄우기
		request.setCharacterEncoding("utf-8");
		String userid= request.getParameter("userid");
		
		UserDto dto = UserManager.instance().findUser(userid);
		request.setAttribute("user", dto); //담을것: dto
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("update.jsp");
		modelAndView.setRedirect(false); //string이 아니라 객체. 그래서 false 
		
		return modelAndView;
		
	}
}
