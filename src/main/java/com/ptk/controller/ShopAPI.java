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
	
	@RequestMapping(value = "/GetShopItemList", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public String getShopItem(@RequestParam("userID") String userID) {
		String result;		
		
		List<ShopVO> list = dao.getSellerItemList(userID);
		result = "{\"count\":\""+list.size()+"\",\"list\":[";
		for(int i=0; i<list.size(); i++) {
			ShopVO shop = list.get(i);
			result += shop.toString();
			if(i+1 == list.size()) {
				result += "]}";
			} else {
				result += ",";
			}
		}
		logger.info(result);
		return result;
	}

}
