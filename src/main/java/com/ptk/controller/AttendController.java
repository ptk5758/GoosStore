package com.ptk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/attend/")
public class AttendController {

	private static final Logger logger = LoggerFactory.getLogger(AttendController.class);
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String attendGET() {
		logger.info("출석체크 페이지");
		return "/attend";
	}
	
}
