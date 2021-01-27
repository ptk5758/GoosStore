package com.ptk.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ptk.domain.SellerVO;
import com.ptk.domain.UserVO;

@Repository
public class UserDAOCon implements UserDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "org.zerock.mapper.UserMapper";
	//org에 zerock에 mapper에 UserMapper에signup을 사용해라
	
	@Override
	public void signup(UserVO user) {
		sqlSession.insert(NAMESPACE+".signup", user);
	}
	
	@Override
	public UserVO login(UserVO user) {
		return sqlSession.selectOne(NAMESPACE+".loginUser", user);
	}
	
	@Override
	public UserVO userIDsearch(UserVO user) {
		return sqlSession.selectOne(NAMESPACE+".IDsearch", user);
	}
	
	@Override
	public UserVO userPasswordsearch(UserVO user) {
		System.out.println(user.toString());
		return sqlSession.selectOne(NAMESPACE+".passwordsearch", user);
	}
	
	@Override
	public void userPasswordChange(UserVO user) {
		sqlSession.update(NAMESPACE+".passwordUpdate", user);	
	}
	
	@Override
	public UserVO getUser(String userID) {
		return sqlSession.selectOne(NAMESPACE+".getUserOne", userID);
	}
	
	/**
	 * 유저를 리스트 형태로 읽어와서 List형식으로 반환 리턴 합니다.
	 * @return 유저리스트를 List형태로 리턴
	 */
	@Override
	public List<UserVO> getUserList() {
		return sqlSession.selectList(NAMESPACE+".getUserList");
	}
	
	@Override
	public void setUserLevel(UserVO user) {
		sqlSession.update(NAMESPACE+".setUserLevel", user);
	}
	
	@Override
	public int getTotalUser() {
		return sqlSession.selectOne(NAMESPACE+".getTotalUser");
	}
	
	@Override
	public void updateSeller(SellerVO seller) {
		sqlSession.update(NAMESPACE+".updateSeller", seller);
		
	}
}
