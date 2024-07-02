package kr.mvc.controller;

public class ModelAndView { //호출방식과 view 파일명 기억
	private boolean isRedirect = false; //스프링은 포워드가 기본값. 스프링전초전이니 false로 해보자.
	private String viewName="";
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	
}
