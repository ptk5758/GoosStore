package com.ptk.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ptk.domain.PageVO;
import com.ptk.domain.ShopVO;

@Repository
public class PageTestDAOCon implements PageTestDAO{

	@Inject
	private SqlSession sqlsession;
	
	private static final String NAMESPACE = "org.zerock.mapper.TestMapper";
	
	@Override
	public int totalListCount() {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(NAMESPACE+".getCount");
	}

	

}
