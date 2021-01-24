package com.ptk.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptk.domain.CartVO;
import com.ptk.domain.ShopVO;
import com.ptk.persistence.CartDAO;
import com.ptk.persistence.ShopDAO;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private CartDAO dao;
	
	@RequestMapping(value="/cart",method=RequestMethod.GET)
	public void getCart(@RequestParam("sessionid")String sessionid,Model model) {
	List<CartVO> cart = dao.cartlist(sessionid);
		
		model.addAttribute("cart",cart);
		
		logger.info("장바구니페이지다");
	}
	@RequestMapping(value="/cart",method=RequestMethod.POST)
	public String getcartlist() {
		
		
		return "redirect:/shop/order";
	}

}

