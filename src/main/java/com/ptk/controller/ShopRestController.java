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
@RequestMapping("/shopList/")
public class ShopRestController {

	@Inject
	private ShopDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(ShopRestController.class);
	
	@RequestMapping(value = "/bottomCategory", method = RequestMethod.GET,produces = "text/plain; charset=UTF-8")
	public String categoryResult(@RequestParam("select") String select) {
		String result;
		result = "{\"cateGory\":[\"전체\",";
		List<String> list = dao.getCategory(select);
		if(!list.isEmpty()) {
			for(int i=0; i<list.size(); i++) {
				logger.info(list.get(i));
				if(i+1 == list.size()) {
					result +="\""+list.get(i)+"\"";
					break;
				}
				result +="\""+list.get(i)+"\",";
			}
			result +="]}";
		}else {
			result ="{\"cateGory\":[\"전체\"]}";
		}
		logger.info(result);
		
		return result;
		//의류 -> 모자, 후드티, 티쳐츠
	}
	
	@RequestMapping(value = "/getShopList", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public String getShopList(@RequestParam("select") String select) {
		String result;
		result = "";
		List<ShopVO> list = dao.getShopListMidselect(select);
		result = "{\"item\":[";
		if(!list.isEmpty()) {
			for(int i=0; i<list.size(); i++) {
				ShopVO shop = list.get(i);
				logger.info(shop.getItemName());
				if(i+1 == list.size()) {
					result += "{\"itemName\":\""+shop.getItemName()+"\",\"itemUID\":\""+shop.getItemUID()+"\",\"itemPrice\":\""+shop.getItemPrice()+"\",\"img_m\":\""+shop.getImg_m()+"\"}]}";
					break;
				}
				result += "{\"itemName\":\""+shop.getItemName()+"\",\"itemUID\":\""+shop.getItemUID()+"\",\"itemPrice\":\""+shop.getItemPrice()+"\",\"img_m\":\""+shop.getImg_m()+"\"},";
			}
		}else {
			result = "";
		}
		
		logger.info(result);
		
		return result;
	}
	
	@RequestMapping(value = "/getItemList", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public String getItemList(@RequestParam("select") String select) {
		String result;
		List<ShopVO> list = dao.getShopListBottomSelect(select);
		result = "{\"items\":[";
		if(list.isEmpty()) {
			result = "";
		}else {
			for(int i=0; i<list.size(); i++) {
				ShopVO shop = list.get(i);
				logger.info(shop.getItemName());
				if(i+1 == list.size()) {
					result += "{\"itemName\":\""+shop.getItemName()+"\",\"itemUID\":\""+shop.getItemUID()+"\",\"itemPrice\":\""+shop.getItemPrice()+"\",\"img_m\":\""+shop.getImg_m()+"\"}]}";
					break;
				}
				result += "{\"itemName\":\""+shop.getItemName()+"\",\"itemUID\":\""+shop.getItemUID()+"\",\"itemPrice\":\""+shop.getItemPrice()+"\",\"img_m\":\""+shop.getImg_m()+"\"},";
			}
		}
		return result;
	}
	
}