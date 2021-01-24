package com.ptk.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ptk.domain.CommunityVO;

@Repository
public class CommunityDAOCon implements CommunityDAO{

	@Inject
	private SqlSession sqlsession;
	
	private static final String NAMESPACE = "org.zerock.mapper.CommunityMapper";

	@Override
	public void CommunityPost(CommunityVO co) {
		sqlsession.insert(NAMESPACE+".CommunityPost",co);
	}

	@Override
	public List<CommunityVO> getCommunityList(CommunityVO co) {
		return sqlsession.selectList(NAMESPACE+".getCommunityList",co);
	}

	@Override
	public CommunityVO getPostingDetail(int uid) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(NAMESPACE+".getpostdetail",uid);
	}
	
}
