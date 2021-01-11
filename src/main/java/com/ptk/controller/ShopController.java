package com.ptk.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ptk.domain.ShopVO;
import com.ptk.persistence.ShopDAO;

@Controller
@RequestMapping("/shop/")
public class ShopController {

	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@Inject
	private ShopDAO dao;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void shopMainGET() {
		logger.info("메인 샵 페이지");
		
	}
	
	@RequestMapping(value = "/midcat", method = RequestMethod.GET)
	public void midcatGET(@RequestParam("itemTopCategory") String topCategory, Model model) {
		logger.info("중간분류 페이지");
		model.addAttribute("shop", dao.getShopList());
	}
	
	@RequestMapping(value = "/posting", method = RequestMethod.GET)
	public void postingGET() {
		logger.info("포스팅페이지");
	}
	@RequestMapping(value = "/posting2", method = RequestMethod.GET)
	public void posting2GET() {
		logger.info("포스팅페이지2");
	}
	
	@RequestMapping(value = "/posting", method = RequestMethod.POST)
	public void postingPOST(MultipartHttpServletRequest request, HttpSession session) throws Exception {
		MultipartFile file = request.getFile("img_m");
		String fileName = "";
		if(!file.isEmpty() || file != null) {
			fileName = uploadFile(file.getOriginalFilename(), file.getBytes());
		}
		ShopVO shop = new ShopVO();
		shop.setUser("게스트");
		if(session.getAttribute("sessionID") != null) {
			shop.setUser((String)session.getAttribute("sessionID"));
		}
		shop.setItemName(request.getParameter("itemName"));
		shop.setItemTitle(request.getParameter("itemTitleCategory"));
		shop.setItemMidCategory(request.getParameter("itemMidCategory"));
		shop.setItemBottomCategory(request.getParameter("itemBottomCategory"));
		shop.setItemPrice(request.getParameter("itemPrice"));
		shop.setImg_m(fileName);
		
		dao.shopPosting(shop);
	}
	
	@RequestMapping(value = "/posting2", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void posting2POST(@RequestPart MultipartFile[] files, ShopVO shop) throws IOException, Exception {
		logger.info("파일업로드2");
		logger.info("아이템이름{}입니다",shop.getItemName());
		for(int i=0; i<files.length; i++) {
			MultipartFile file = files[i];
			logger.info(file.getOriginalFilename());
			if(i == 0) {	shop.setImg_m(uploadFile(file.getOriginalFilename(), file.getBytes()));	}
			if(i == 1) {	shop.setImg_1(uploadFile(file.getOriginalFilename(), file.getBytes()));	}
			if(i == 2) {	shop.setImg_2(uploadFile(file.getOriginalFilename(), file.getBytes()));	}
			if(i == 3) {	shop.setImg_3(uploadFile(file.getOriginalFilename(), file.getBytes()));	}
		}
	}
	
	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + originalName;
		// import java.io.File; 
		File target = new File(uploadPath, savedName);
		// FileCopyUtils는 'org.springframework.util' 패키지에 설정된 클래스(실제 파일 처리)
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}	
	
	
}
