package com.ptk.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
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
import org.springframework.web.bind.annotation.PathVariable;
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
import com.ptk.domain.UserVO;
import com.ptk.persistence.ShopDAO;
import com.ptk.persistence.UserDAO;

@Controller
@RequestMapping("/shop/")
public class ShopController {

	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@Inject
	private ShopDAO dao;
	private UserDAO userdao;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String shopMainGET() {
		logger.info("메인 샵 페이지");
		return "/shop/shopMain";
		
	}
	
	@RequestMapping(value = "/{sellerID}", method = RequestMethod.GET)
	public String shopSellerMainPage(@PathVariable("sellerID") String sellerID) {
		logger.info(sellerID);
		return "/shop/shopSeller";
	}
	
	@RequestMapping(value = "/shopPosting", method = RequestMethod.GET)
	public String shopPostingPage() {
		return "/shop/shopPosting";
	}
	
	@RequestMapping(value = "/seller", method = RequestMethod.GET)
	public String sellerGET(HttpSession session, RedirectAttributes rttr, Model model) {
		
		if(session.getAttribute("sessionID") == null) {
			rttr.addFlashAttribute("msg", "로그인 후 이용하실수 있습니다.");
			return "redirect:/";
		}
		
		String sessionID = (String)session.getAttribute("sessionID");
		UserVO user = dao.getSellerOne(sessionID);
		logger.info(user.toString());
		model.addAttribute("user", user);
		return "/shop/seller";
	}
	
	@RequestMapping(value = "/sellerModify", method = RequestMethod.GET)
	public String sellerModifyPage(HttpSession session, RedirectAttributes rttr, Model model) {
		if(session.getAttribute("sessionID") == null) {
			rttr.addFlashAttribute("msg", "로그인 후 이용하실수 있습니다.");
			return "redirect:/";
		}
		
		String sessionID = (String)session.getAttribute("sessionID");
		SellerVO user = dao.getSellerVO(sessionID);
		logger.info(user.toString());
		model.addAttribute("user", user);
		return "/shop/sellerModify";
	}
	
	/**
	 * ##셀러 신청하는 메서드입니다. 
	 */
	@ResponseBody
	@RequestMapping(value = "/seller",method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	public String sellerInsert(SellerVO seller, @RequestParam("file")MultipartFile file, HttpSession session) throws IOException, Exception {
		if(session.getAttribute("sessionID") == null) {
			return "{\"msg\":\"로그인후 이용하실수있습니다.\"}";
		} else {
			seller.setImg(uploadFile(file.getOriginalFilename(), file.getBytes()));
			dao.insertSeller(seller);
			userdao.updateSeller(seller.getSellerID());
		}
		return "{\"msg\":\"성공\",\"dir\":\"/\"}";
	}
	
	@ResponseBody
	@RequestMapping(value = "/sellermodify",method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	public String sellerModify(SellerVO seller, @RequestParam("files")MultipartFile file, HttpSession session) throws IOException, Exception {
		logger.info(seller.toString());
		if(session.getAttribute("sessionID") == null) {
			return "{\"msg\":\"로그인후 이용하실수있습니다.\"}";
		} else {
			seller.setImg(uploadFile(file.getOriginalFilename(), file.getBytes()));
			dao.modifySeller(seller);
		}
		return "{\"msg\":\"성공\",\"dir\":\"/\"}";
	}
	
	@ResponseBody
	@RequestMapping(value = "/Seller", method = RequestMethod.GET, produces = "application/text; charset=UTF-8")
	public String sellerGET() {
		String result;
		result = "{\"count\":\"1\",\"list\":[";
		List<SellerVO> list = dao.getSeller();
		for(int i=0; i<list.size(); i++) {
			SellerVO vo = list.get(i);
			result += "{\"name\":\""+vo.getName()+"\",";
			result += "\"ID\":\""+vo.getSellerID()+"\",";
			result += "\"img\":\"http://localhost:8080/6/"+vo.getImg()+"\",";
			result += "\"postcod\":\""+vo.getPostcod()+"\",";
			result += "\"address1\":\""+vo.getAddr1()+"\",";
			result += "\"address2\":\""+vo.getAddr2()+"\",";
			result += "\"comment\":\""+vo.getComment()+"\",";
			result += "\"phone\":\""+vo.getPhone()+"\"}";
			if(i+1 == list.size()) {
				result += "]}";
			} else {
				result += ",";
			}
			
		}
		logger.info(result);
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
