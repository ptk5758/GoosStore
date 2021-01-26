package com.ptk.persistence;

import java.util.List;

import com.ptk.domain.UserVO;

public interface UserDAO {
	
	public void signup(UserVO user);
	public UserVO login(UserVO user);
	public UserVO userIDsearch(UserVO user);
	public UserVO userPasswordsearch(UserVO user);
	public void userPasswordChange(UserVO user);
	public UserVO getUser(String userID);
	/**
	 * 유저 오브잭트를 리스트형태로 가져옵니다.
	 * @return 리턴 유저리스트<UserVO>
	 */
	public List<UserVO> getUserList();	
	/**
	 * 유저의 레벨 을 세팅하는 메서드입니다
	 * @param userLevel userUUID
	 */
	public void setUserLevel(UserVO user);
	public int getTotalUser();
	public void updateSeller(String sellerID);
}
