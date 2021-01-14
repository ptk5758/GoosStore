package com.ptk.controller;

import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ptk.domain.UserVO;
import com.ptk.persistence.UserDAO;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserDAO dao;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET() {
		logger.info("로그인 페이지");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(UserVO user, HttpSession session, HttpServletRequest request) {
		logger.info("로그인 시도");
		logger.info(user.toString());
		try {
			user = dao.login(user);
			session.setAttribute("sessionLevel", user.getUserLevel());
			session.setAttribute("sessionID", user.getUserID());
			session.setAttribute("sessionName", user.getUserName());
			session.setAttribute("sessionNickName", user.getUserNickName());
			return "redirect: /";
		} catch (Exception e) {
			logger.info("로그인에 실패하였습니다.");
			request.setAttribute("msg", "아이디 또는 비밀번호가 잘못되었습니다.");
			return "/user/login";
		}
	}	
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public void signupGET() {
		/* logger.info("회원가입"); */
	}
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPOST(UserVO user,RedirectAttributes rttr) {
		logger.info(user.toString());
		try {
			dao.signup(user);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("회원가입에 실패하였습니다.");
		}
		rttr.addFlashAttribute("msg", "회원가입을 축하드립니다!");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(RedirectAttributes rttr, HttpSession session) {
		session.invalidate();
		rttr.addFlashAttribute("msg", "로그아웃 되었습니다.");
		rttr.addFlashAttribute("value", "logout");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/idsearch", method = RequestMethod.GET)
	public void idsearchGET() {
		logger.info("아이디 찾기 페이지");
	}
	
	@RequestMapping(value = "/passwordsearch", method = RequestMethod.GET)
	public void passwordsearchGET() {
		logger.info("비밀번호 찾기 페이지");
	}
	
	@RequestMapping(value = "/passwordsearch", method = RequestMethod.POST)
	public String passwordsearchPOST(UserVO user, RedirectAttributes rttr) {
		logger.info(user.toString());
		dao.userPasswordChange(user);
		rttr.addFlashAttribute("msg", "비밀번호가 변경성공.");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public void mypageGET(@RequestParam("sessionID") String sessionID, Model model) {
		model.addAttribute("userVO", dao.getUser(sessionID));
	}
	
	
	

}

