package com.ptk.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ptk.domain.AskVO;

@Repository
public class AskDAOCon implements AskDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "org.zerock.mapper.AskMapper";

	@Override
	public void insertAsk(AskVO ask) {
		sqlSession.insert(NAMESPACE+".insertAsk", ask);
	}
	
	@Override
	public List<AskVO> getAskList() {
		return sqlSession.selectList(NAMESPACE+".getAskList");
	}
	
	@Override
	public AskVO getAskPage(Integer askUID) {
		return sqlSession.selectOne(NAMESPACE+".getAskVO", askUID);
	}
}
