package com.ptk.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ptk.domain.PageMaker;
import com.ptk.domain.PageVO;
import com.ptk.persistence.PageTestDAO;
import com.ptk.persistence.ShopDAO;

@Controller
@RequestMapping("/page")
public class PageTestController {

	private static final Logger logger = LoggerFactory.getLogger(PageTestController.class);
	
	@Inject
	private PageTestDAO dao;	
	
	@RequestMapping(value="/pagetest",method=RequestMethod.GET	)
	public void getPage(PageVO vo,Model model) {
		vo.setTotalList(dao.totalListCount());
		PageMaker pagemaker = new PageMaker(vo);
		PageVO pagevo = pagemaker.getPageVO();
		
		  logger.info("현재페이지:"+pagevo.getNowPage());
		  logger.info("리미트페이지:"+pagevo.getFirstLimitPage());
		  logger.info("보여줄 리스트수:"+pagevo.getShowPage());
		  logger.info("총페이지:"+pagevo.getTotalPage());
		  logger.info("총게시물수:"+pagevo.getTotalList()); 	
	}
}
