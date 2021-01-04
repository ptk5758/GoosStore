package com.ptk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/shop/")
public class ShopController {

	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void shopMainGET() {
		logger.info("메인 샵 페이지");
	}
}
