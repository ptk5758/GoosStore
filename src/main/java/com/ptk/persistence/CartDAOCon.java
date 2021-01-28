package com.ptk.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ptk.domain.CartVO;

@Repository
public class CartDAOCon implements CartDAO{
	
	private final static String NAMESPACE = "org.zerock.mapper.CartMapper";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void insertCart(CartVO cart) {
		sqlSession.insert(NAMESPACE+".insertCart", cart);
	}
	
	@Override
	public boolean checkCart(CartVO cart) {
		return sqlSession.selectOne(NAMESPACE+".checkCart", cart);
	}
	
	@Override
	public void addCart(CartVO cart) {
		sqlSession.update(NAMESPACE+".addCart", cart);	
	}
	
	@Override
	public List<CartVO> getCartList(String userID) {
		return sqlSession.selectList(NAMESPACE+".getCartList", userID);
	}


}
