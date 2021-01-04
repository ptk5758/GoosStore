package com.ptk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shop/")
public class ShopController {

	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void shopMainGET() {
		logger.info("메인 샵 페이지");
	}
	
	@RequestMapping(value = "/midcat", method = RequestMethod.GET)
	public void midcatGET(@RequestParam("itemTopCategory") String topCategory) {
		logger.info("중간분류 페이지");
	}
}
