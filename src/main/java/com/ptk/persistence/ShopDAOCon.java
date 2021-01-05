package com.ptk.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ptk.domain.ShopVO;

@Repository
public class ShopDAOCon implements ShopDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "org.zerock.mapper.ShopMapper";

	@Override
	public void shopPosting(ShopVO shop) {
		sqlSession.insert(NAMESPACE+".shopPosting", shop);
	}
}
