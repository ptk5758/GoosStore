package com.ptk.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ptk.domain.CartVO;
import com.ptk.persistence.CartDAO;
import com.ptk.persistence.ShopDAO;

@RestController
@RequestMapping(value = "/Cartapi")
public class CartAPI {
	
	private static final Logger logger = LoggerFactory.getLogger(CartAPI.class);
	
	@Inject
	private CartDAO dao;
	@Inject
	private ShopDAO shopdao;
	
	@RequestMapping(value = "/ListGet", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public String cartListGet(@RequestParam("userID") String userID) {
		String result;
		List<CartVO> list = dao.getCartList(userID);
		logger.info(list.size()+"<<<<<<<<<<<<<<<<");
		result = "{\"count\":\""+list.size()+"\",\"list\":[";
		for(int i=0; i<list.size(); i++) {
			CartVO cart = list.get(i);
			result += "{\"cartuid\":\""+cart.getCartUID()+"\",";
			result += "\"itemcount\":\""+cart.getItemCount()+"\",";
			result += "\"itemuid\":\""+cart.getItemUID()+"\",";
			result += "\"userid\":\""+cart.getUserID()+"\",";
			result += "\"shopItem\":["+shopdao.getCartShopList(cart.getItemUID()).toString()+"],";//요거
			result += "\"cartdate\":\""+cart.getCartDate()+"\"}";
			if(i+1 == list.size()) {
				result += "]}";
			} else {
				result += ",";
			}
		}
		//logger.info(result);
		return result;
	}

}

