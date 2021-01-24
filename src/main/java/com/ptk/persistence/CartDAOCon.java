package com.ptk.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ptk.domain.CartVO;
import com.ptk.domain.ShopVO;

@Repository
public class CartDAOCon implements CartDAO{
	@Inject
	private SqlSession sqlsession;
	
	private static final String NAMESPACE = "org.zerock.mapper.CartMapper";

	@Override
	public void addToCart(CartVO vo) {
		sqlsession.insert(NAMESPACE+".addToCart",vo);
	}

	@Override
	public int itemuid(int uid) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(NAMESPACE+".getItemList",uid);
	}

	@Override
	public void updateAmount(CartVO vo) {
		sqlsession.update(NAMESPACE+".updateAmount",vo);
	}
	
	@Override
	public void incartupdateAmount(Map<String,Object> paramap) {
		sqlsession.update(NAMESPACE+".incartupdateAmount",paramap);
		
	}

	@Override
	public int cartamount(String sessionid) {
		return sqlsession.selectOne(NAMESPACE+".cartamount",sessionid);
	}

	@Override
	public List<CartVO> cartlist(String sessionid) {
		// TODO Auto-generated method stub
		return sqlsession.selectList(NAMESPACE+".cartlist",sessionid);
	}

	@Override
	public int deletecart(int uid) {
		return sqlsession.delete(NAMESPACE+".deletecart",uid);
		
	}
	
	

	

	




}
