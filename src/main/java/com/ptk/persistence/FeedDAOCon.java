package com.ptk.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ptk.domain.FeedVO;

@Repository
public class FeedDAOCon implements FeedDAO{
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "org.zerock.mapper.FeedMapper";

	@Override
	public void insertFeed(FeedVO feed) {
		sqlSession.insert(NAMESPACE+".insertFeed", feed);
	}
	
	@Override
	public List<FeedVO> getFeedList(Integer askUID) {
		return sqlSession.selectList(NAMESPACE+".getFeedList", askUID);
	}
}
