package com.ptk.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ptk.domain.FeedVO;
import com.ptk.persistence.FeedDAO;

@RestController
@RequestMapping("/AdminFeed/")
public class AdminFeedRestController {
	
	@Inject
	private FeedDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminFeedRestController.class);
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String getAskList(FeedVO feed, @RequestParam("file") MultipartFile[] files) throws IOException, Exception {
		logger.info("test");
		logger.info(feed.toString());
		logger.info(files.length+"<<<<<<<<<<<<");
		for(int i=0; i<files.length; i++) {
			MultipartFile file = files[i];
			if(i==0) {feed.setFile1(uploadFile(file.getOriginalFilename(), file.getBytes()));}
			if(i==1) {feed.setFile2(uploadFile(file.getOriginalFilename(), file.getBytes()));}
			if(i==2) {feed.setFile3(uploadFile(file.getOriginalFilename(), file.getBytes()));}
		}
		dao.insertFeed(feed);
		return "성공";
	}
	
	/**
	 * 업로드 하는 메서드
	 * @param originalName
	 * @param fileData
	 * @return
	 * @throws Exception
	 */
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
