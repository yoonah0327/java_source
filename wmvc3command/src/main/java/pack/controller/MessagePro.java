package pack.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.model.MessageModel;

public class MessagePro implements CommandInter{
	 @Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 적당한 모델을 선택해 수행결과 얻기
		 
		MessageModel messageModal = new MessageModel();//원래는 싱글톤처리
		String msg = messageModal.messageProcess();
		request.setAttribute("datas", msg);
		return "view1.jsp";
	}
}
