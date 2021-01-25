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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ptk.domain.SellerVO;
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
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String shopMainGET() {
		logger.info("메인 샵 페이지");
		return "/shop/shopMain";
		
	}
	
	@RequestMapping(value = "/seller", method = RequestMethod.GET)
	public String sellerGET(HttpSession session, RedirectAttributes rttr) {
		
		if(session.getAttribute("sessionID") == null) {
			rttr.addFlashAttribute("msg", "로그인 후 이용하실수 있습니다.");
			return "redirect:/";
		}
		
		return "/shop/seller";
	}
	
	/**
	 * ##셀러 신청하는 메서드입니다. 
	 */
	@ResponseBody
	@RequestMapping(value = "/seller",method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	public String sellerInsert(SellerVO seller, @RequestParam("file")MultipartFile file, HttpSession session) throws IOException, Exception {
		logger.info(seller.toString());
		if(session.getAttribute("sessionID") == null) {
			return "{\"msg\":\"로그인후 이용하실수있습니다.\"}";
		} else {
			seller.setImg(uploadFile(file.getOriginalFilename(), file.getBytes()));
			//dao.insertSeller(seller);
		}
		return "{\"msg\":\"성공\",\"dir\":\"/\"}";
	}
	
	@ResponseBody
	@RequestMapping(value = "/seller", method = RequestMethod.GET, produces = "application/text; charset=UTF-8")
	public String sellerGET() {
		String result;
		result = "{\"msg\":\"성공\"}";
		return result;
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
