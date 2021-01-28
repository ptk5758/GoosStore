package com.ptk.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ptk.domain.CartVO;
import com.ptk.persistence.CartDAO;

@Controller
@RequestMapping(value = "/Cart/")
public class CartController {
	
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Inject
	private CartDAO dao;
	
	@RequestMapping(value = "/{userID}", method = RequestMethod.GET)
	public String cartPage(@PathVariable("userID") String userID) {
		logger.info(userID);
		return "/cart";
	}
	
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	public String insertCart(CartVO cart, HttpSession session) {
		String result;
		if(session.getAttribute("sessionID") == null) {
			result = "{\"msg\":\"실패\",\"comment\":\"로그인 후에 이용가능합니다.\"}";			
		} else {
			logger.info(cart.toString());
			logger.info(dao.checkCart(cart)+"<<<<<<<<<<<<<<<<<<");
			if(dao.checkCart(cart)) {
				dao.addCart(cart);				
			} else {
				dao.insertCart(cart);				
			}
			result = "{\"msg\":\"성공\"}";
		} 
		return  result;
	}

}
