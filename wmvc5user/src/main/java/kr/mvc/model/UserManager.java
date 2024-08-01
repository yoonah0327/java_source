package kr.mvc.model;

import java.util.ArrayList;

import org.apache.catalina.User;

import kr.mvc.controller.UserForm;

// 여러 개의 DAO 클래스 관리가 목적
public class UserManager {
	private static UserManager manager = new UserManager();
	
	public static UserManager instance() {
		return manager;
	}
	
	private UserDaoModel getUserDaoModel() {
		return new UserDaoModel();
				
	}
	// 로그인 성공/실패 판별
	public boolean login(String user_id, String user_password) {
		UserDto dto = getUserDaoModel().findUser(user_id);
		if(dto == null) return false;
		
		if(dto.getPassword().equals(user_password)) {
			return true;
		}else {
			return false;
		}
	}
	// 전체 자료 반환
	public ArrayList<UserDto> getUserAll(){
		return getUserDaoModel().getUserDataAll();
	}
	// 데이터 추가
	public int insert(UserForm userForm) {
		return getUserDaoModel().insertData(userForm);
	}
	// 하나의 데이터 받기
	public UserDto findUser(String userid) {
		return getUserDaoModel().findUser(userid);
	}
	// 데이터 수정
	public int update(UserForm userForm) {
		return getUserDaoModel().updateData(userForm);
	}
		
	// 데이터 삭제
	public int delete(String userid) {
		return getUserDaoModel().deleteData(userid);
	}
	
	

}
