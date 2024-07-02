package kr.mvc.controller;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.mvc.model.UserDto;
import kr.mvc.model.UserManager;

public class ListController implements Controller{
	
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<UserDto> list = UserManager.instance().getUserAll(); 
		request.setAttribute("list", list);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list.jsp");
		modelAndView.setRedirect(false); //forwarding
		//request.setAttribute("list", list);들고 modelAndView.setViewName("list.jsp");한테 갈거기에
		//redirect 방법으로는 불가. 포워드방식으로 감.
		return modelAndView;
	}
	
	
}
