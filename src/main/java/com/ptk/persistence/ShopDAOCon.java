package com.ptk.persistence;

import java.util.List;

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
	
	@Override
	public List<ShopVO> getShopList() {
		return sqlSession.selectList(NAMESPACE+".getShopList");
	}
	
	@Override
	public List<String> getCategory(String itemMidCategory) {
		List<String> list = sqlSession.selectList(NAMESPACE+".getCategory", itemMidCategory);
		return list;
	}
	
	@Override
	public List<ShopVO> getShopListMidselect(String itemMidCategory) {
		return sqlSession.selectList(NAMESPACE+".getShopListMidSelect", itemMidCategory);
	}
	
	@Override
	public List<ShopVO> getShopListBottomSelect(String itemBottomCategory) {
		return sqlSession.selectList(NAMESPACE+".getShopListBottomSelect", itemBottomCategory);
	}
}
