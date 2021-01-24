package com.ptk.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ptk.domain.CartVO;
import com.ptk.domain.ShopVO;
import com.ptk.persistence.CartDAO;

@RestController
@RequestMapping("/CartRest")
public class CartRestController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private CartDAO dao;

	@RequestMapping(value = "/CartInsert", method = RequestMethod.POST, produces = "application/text; charset=utf-8")
	public String insertcart(@RequestBody CartVO vo, HttpSession session) {
		int uid = vo.getItem_uid();
		String data; 
		
		if (dao.itemuid(uid) == 1) {
			dao.updateAmount(vo);
			logger.info("변경되었습니다");
		} else {
			dao.addToCart(vo);
			logger.info("장바구니추가되었습니다");
		}
		int count = dao.cartamount((String)session.getAttribute("sessionID"));
		logger.info((String)session.getAttribute("sessionID"));
		logger.info("==" + count);
		data = "{\"acount\":[{\"count\":\""+count+"\"}]}"; 
		
		logger.info(data);
		return data;
	}
	@RequestMapping(value="/changeamount",method = RequestMethod.POST)
	public String changeamount(@RequestBody CartVO vo) {
		logger.info("바꾸기");
		
		Map<String,Object> paramap = new HashMap<String, Object>();
		int amount = vo.getAmount();
		int uid = vo.getItem_uid();
		
		paramap.put("amount",amount);
		paramap.put("uid",uid);
		dao.incartupdateAmount(paramap);
		
		
		
		logger.info("==="+amount);
		return "redirect:/cart/cart";
	}
	@RequestMapping(value="/deletecart",method=RequestMethod.POST)
	public String deletecart(@RequestBody CartVO vo,HttpSession session) {
		String data;
		int uid = vo.getItem_uid();
		int count = dao.cartamount((String)session.getAttribute("sessionID"));
		data = "{\"delete\":[{\"count\":\""+count+"\"}]}"; 
		dao.deletecart(uid);
		
		return data;
		
	}
	
}
