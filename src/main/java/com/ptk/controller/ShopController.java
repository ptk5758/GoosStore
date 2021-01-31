package com.ptk.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
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

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.ptk.domain.SellerVO;
import com.ptk.domain.ShopVO;
import com.ptk.domain.UserVO;
import com.ptk.persistence.CartDAO;
import com.ptk.persistence.ShopDAO;
import com.ptk.persistence.UserDAO;

@Controller
@RequestMapping("/shop/")
public class ShopController {

	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@Inject
	private ShopDAO dao;
	@Inject
	private UserDAO userdao;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String shopMainGET() {
		logger.info("메인 샵 페이지");
		return "/shop/shopMain";
		
	}
	
	@RequestMapping(value = "/{sellerID}", method = RequestMethod.GET)
	public String shopSellerMainPage(@PathVariable("sellerID") String sellerID, Model model) {
		logger.info(sellerID);
		
		List<ShopVO> list = dao.getSellerItemList(sellerID);
		if(list.isEmpty()) {
			model.addAttribute("list", null);
		} else {
			model.addAttribute("list", list);
		}
		model.addAttribute("seller", dao.getSellerVO(sellerID));
		
		
		return "/shop/shopSeller";
	}
	@RequestMapping(value = "/{sellerID}/{itemUID}", method = RequestMethod.GET)
	public String viewItemPage(@PathVariable("sellerID")String sellerID,@PathVariable("itemUID") Integer itemUID, Model model) {
		logger.info(sellerID+"||"+itemUID);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sellerID", sellerID);
		map.put("itemUID", itemUID);
		ShopVO shop = dao.getViewItemVO(map);
		model.addAttribute("item", shop);
		return "/shop/viewItem";
	}
	
	@RequestMapping(value = "/shopPosting", method = RequestMethod.GET)
	public String shopPostingPage(Model model, HttpSession session) {
		model.addAttribute("category", dao.getCategory());
		model.addAttribute("user", dao.getSellerOne((String)session.getAttribute("sessionID")));
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
			logger.info(seller.getSellerID()+"<><<<<<");
			
		}
		userdao.updateSeller(seller);
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
			result += "\"img\":\"http://freeptk.shop/6/"+vo.getImg()+"\",";
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
	
	@ResponseBody
	@RequestMapping(value = "/posting", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	public String insertItem(ShopVO shop, @RequestParam("mainimg")MultipartFile mainimg, @RequestParam("imgs") MultipartFile[] imgs) throws IOException, Exception {
		shop.setImg_m(uploadFile(mainimg.getOriginalFilename(), mainimg.getBytes()));
		int i=0;
		for(MultipartFile file : imgs) {
			if(i==0) {shop.setImg_1(uploadFile(file.getOriginalFilename(), file.getBytes()));}
			if(i==1) {shop.setImg_2(uploadFile(file.getOriginalFilename(), file.getBytes()));}
			if(i==2) {shop.setImg_3(uploadFile(file.getOriginalFilename(), file.getBytes()));}
			i++;
		}
		dao.addCategory(shop.getItemMidCategory());
		dao.itemInsert(shop);
		logger.info(shop.toString());
		return  "{\"msg\":\"성공\"}";
	}
	
	@RequestMapping(value = "/myShop", method = RequestMethod.GET)
	public String myShopPage(HttpSession session) {
		
		if(session.getAttribute("sessionID") == null) {
			return "/";
		}
		return "/shop/myShop";
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
