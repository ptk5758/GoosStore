package com.ptk.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ptk.persistence.ShopDAO;

@RestController
@RequestMapping("/shopList/")
public class ShopRestController {

	@Inject
	private ShopDAO dao;
	
	@RequestMapping(value = "/bottomCategory", method = RequestMethod.GET,produces = "text/plain; charset=UTF-8")
	public String categoryResult() {
		String result;
		
		result = "{\"cateGory\":[\"모자\",\"티셔츠\",\"후드티\"]}";
		return result;
		//의류 -> 모자, 후드티, 티쳐츠
	}
	
}