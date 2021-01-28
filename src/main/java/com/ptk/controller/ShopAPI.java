package com.ptk.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ptk.domain.ShopVO;
import com.ptk.persistence.ShopDAO;

@RestController
@RequestMapping(value = "/Shopapi")
public class ShopAPI {
	
	@Inject
	private ShopDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(ShopAPI.class);
	
	@RequestMapping(value = "/GetShopItemList", method = RequestMethod.GET, produces = "application/text; charset=UTF-8")
	public String getShopItem() {
		String result;
		
		
		result = "{\"msg\":\"성공\"}";
		return result;
	}

}
