package com.ptk.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ptk.controller.AttendRestController;
import com.ptk.domain.AttendVO;

@Repository
public class AttendDAOCon implements AttendDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "org.zerock.mapper.AttendMapper";
	
	private static final Logger logger = LoggerFactory.getLogger(AttendRestController.class);
	
	@Override
	public void insertAttend(AttendVO attend) {
		sqlSession.insert(NAMESPACE+".attend", attend);
	}
	
	@Override
	public List<String> getLastAttend(AttendVO attend) {
		List<String> result = sqlSession.selectList(NAMESPACE+".lastAttend", attend);
		logger.info(result.size()+"============");
		if(result.isEmpty()) {
			result.add("9999-99-99 99:99:99");
		}
		return result;
	}
	
	@Override
	public void updateLastAttend(AttendVO attend) {
		sqlSession.update(NAMESPACE+".updateLastAttend", attend);
		
	}
}
