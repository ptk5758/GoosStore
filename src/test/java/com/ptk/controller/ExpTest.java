package com.ptk.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ptk.domain.UserExpManager;
import com.ptk.domain.UserVO;
import com.ptk.persistence.AttendDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})

	public class ExpTest {
	
		@Inject
		private AttendDAO dao;
		
		private static Logger logger = LoggerFactory.getLogger(ExpTest.class);
	
		@Test
		public void testExp(){
			int exp = 5;
			UserVO user = new UserVO();
			user.setUserName("박태광");
			user.setUserID("ptk5758");
			user.setUserExp(0);
			
			logger.info(UserExpManager.expUp(user, exp));
		}
	
	}
