package com.ptk.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ptk.domain.UserVO;
import com.ptk.persistence.UserDAO;

@RestController
@RequestMapping(value = "/usersearch")
public class UserRestController {
	
	@Inject
	private UserDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
	@ResponseBody
	@RequestMapping(value = "/userIDsearch", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public String getUserIDJSON(@RequestBody UserVO user) throws Exception {
		
		String result;
		try {
			user = dao.userIDsearch(user);
			result = "{"
					+ "\"userName\":\""+user.getUserName()+"\","
					+ "\"userNickName\":\""+user.getUserNickName()+"\","
					+ "\"userSignUpDate\":\""+user.getUserSignUpDate()+"\","
					+ "\"userID\":\""+user.getUserID()+"\""
					+ "}";
			return result;
		} catch (Exception e) {
			result = "{\"msg\":\"아이디를 찾지못하였습니다.Not Fount user\"}";
			return result;
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/userPasswordsearch", method = RequestMethod.POST, produces = "application/text; charset=UTF8")
	public String getUserPasswordJSON(@RequestBody UserVO user) {
		String result;
		try {
			user = dao.userPasswordsearch(user);
			result = "{"
					+ "\"userName\":\""+user.getUserName()+"\","
					+ "\"userNickName\":\""+user.getUserNickName()+"\","
					+ "\"userPassword\":\""+user.getUserPassword()+"\","
					+ "\"userID\":\""+user.getUserID()+"\""
					+ "}";
		} catch (Exception e) {
			e.printStackTrace();
			result = "{\"msg\":\"아이디를 찾지못하였습니다.Not Fount user\"}";
			return result;
		}
		return result;
	}
	

}
