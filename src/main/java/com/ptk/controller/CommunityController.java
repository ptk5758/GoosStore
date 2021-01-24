package com.ptk.controller;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ptk.domain.CommunityVO;
import com.ptk.persistence.CommunityDAO;

@Controller
@RequestMapping("/community/")
public class CommunityController {
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	@Inject
	private CommunityDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="community",method = RequestMethod.GET)
	public void getCommunityPage(CommunityVO community,Model model) {
		dao.getCommunityList(community);
		model.addAttribute("posting",dao.getCommunityList(community));
		logger.info("커뮤니티입니다");
	}
	@RequestMapping(value="post",method = RequestMethod.GET)
	public void getPostPage() {
		logger.info("글등록입니다");
	}
	@RequestMapping(value="post",method = RequestMethod.POST)
	public String post(MultipartHttpServletRequest request) throws Exception{
		MultipartFile file = request.getFile("file");
		String fileName="";
		if(!file.isEmpty() || file != null) {
			fileName =  uploadFile(file.getOriginalFilename(), file.getBytes());
		}
		CommunityVO com = new CommunityVO();
		com.setPostTitle(request.getParameter("postTitle"));
		com.setPostContent(request.getParameter("postContent"));
		com.setPostUsername(request.getParameter("postUsername"));
		com.setPostImage(fileName);
		dao.CommunityPost(com);
		logger.info("글등록했나염");
		return "redirect:/community/community";
	}
	private String uploadFile(String originalName,byte[] fileData) throws Exception {
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString()+"_"+originalName;
		
		File target = new File(uploadPath,savedName);
		FileCopyUtils.copy(fileData, target);
		
		return savedName;
	}
	@RequestMapping(value="/postview",method = RequestMethod.GET)
	public void getPostView(@RequestParam("postUid")int uid,Model model) {
		logger.info("게시물상세페이지");
		dao.getPostingDetail(uid);
		model.addAttribute("detail",dao.getPostingDetail(uid));
	}
}