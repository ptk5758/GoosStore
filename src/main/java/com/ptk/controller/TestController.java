package com.ptk.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/test")
public class TestController {

	@RequestMapping(value = "/aaa", method = RequestMethod.GET)
	public String testGET(Model model) {
		model.addAttribute("msg", "test");
		return "/test";
	}
}
