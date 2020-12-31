package com.ptk.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptk.domain.UserVO;
import com.ptk.persistence.UserDAO;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
	
	@Inject
	private UserDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminUserController.class);
	
	@RequestMapping(value = "/userTool", method = RequestMethod.GET)
	public void userToolGET(HttpServletRequest request) {
		logger.info("유저 관리 페이지");
		request.setAttribute("userList", dao.getUserList());
	}
	@RequestMapping(value = "/userTool", method = RequestMethod.POST)
	public String userToolPOST(UserVO user) {
		logger.info("유저 레벨 변경");
		logger.info(user.toString());
		dao.setUserLevel(user);
		return "redirect: /admin/user/userTool";
	}

}

