package com.ptk.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ptk.domain.AskVO;
import com.ptk.persistence.AskDAO;

@RestController
@RequestMapping("/RestAsk/")
public class RestAsk {
	
	@Inject
	private AskDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(RestAsk.class);
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@ResponseBody
	@RequestMapping(value = "",method = RequestMethod.POST)
	public String insertASK(@RequestParam("file") MultipartFile[] files, AskVO ask) throws IOException, Exception {
		logger.info("성공");
		
		int i = 0;
		for(MultipartFile file : files) {
			if(i == 0) ask.setFile1(uploadFile(file.getOriginalFilename(), file.getBytes()));
			if(i == 1) ask.setFile2(uploadFile(file.getOriginalFilename(), file.getBytes()));
			if(i == 2) ask.setFile3(uploadFile(file.getOriginalFilename(), file.getBytes()));
			i++;
		}
		dao.insertAsk(ask);
		logger.info(ask.toString()+"<<<<<<<<<<<<<<<<<<<<<<<");
		
		
		
		
		return "{\"msg\":\"접수되었습니다.\"}";
	}
	
	@RequestMapping(value = "",method = RequestMethod.GET, produces = "application/text; charset=UTF-8")
	public String getAskList() {
		String result;
		result = "{\"list\":[";
		List<AskVO> list = dao.getAskList();
		for(int i=0; i<list.size(); i++) {
			AskVO ask = list.get(i);
			result += "{\"askUID\":\""+ask.getAskUID()+"\",";
			result += "\"subject\":\""+ask.getSubject()+"\",";
			result += "\"category\":\""+ask.getCategory()+"\"}";
			if(i+1 == list.size()) {
				result += "]}";
			} else {
				result += ",";
			}
		}
		if(list.isEmpty()) {
			result = "{\"msg\":\"없음\"}";
		}
		
		
		return result;
	}
	//@PathVariable("askUID") Integer askUID <<<<<<<<<<<<<<<<<<<<<<<이거 url 에서 값가져오는거 중요한거
	@RequestMapping(value = "/{askUID}", method = RequestMethod.GET, produces = "application/text; charset=UTF-8")
	public String getAskPage(@PathVariable("askUID") Integer askUID) {
		logger.info(askUID+"<<<<<<<<<<<<<<<<<<<");
		AskVO ask = dao.getAskPage(askUID);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info(ask.toString());
		String result = "";
		result += "{\"askUID\":\""+ask.getAskUID()+"\",";
		result += "\"userEmail\":\""+ask.getUserEmail()+"\",";
		result += "\"subject\":\""+ask.getSubject()+"\",";
		result += "\"category\":\""+ask.getCategory()+"\",";
		result += "\"phone\":\""+ask.getPhone()+"\",";
		result += "\"content\":\""+ask.getContent()+"\",";
		result += "\"uploadDate\":\""+sdf.format(ask.getUploadDate())+"\",";
		result += "\"file1\":\""+ask.getFile1()+"\",";
		result += "\"file2\":\""+ask.getFile2()+"\",";
		result += "\"file3\":\""+ask.getFile3()+"\"}";
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
