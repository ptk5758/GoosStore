package com.ptk.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ptk.domain.AttendVO;

@Repository
public class AttendDAOCon implements AttendDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "org.zerock.mapper.AttendMapper";
	
	@Override
	public void insertAttend(AttendVO attend) {
		sqlSession.insert(NAMESPACE+".attend", attend);
	}
}
