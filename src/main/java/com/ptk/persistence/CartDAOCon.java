package com.ptk.persistence;

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


}
