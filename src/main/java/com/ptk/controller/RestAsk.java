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
import org.springframework.web.bind.annotation.PatchMapping;
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
	/**
	 * #질문답변에 양식에 맞춰 데이터베이스에 입력하는 메서드 입니다.
	 * @param files 
	 * @param ask
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
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
	
	/**
	 * #DB에서 질문답변의 모든리스트를 읽어오는 메서드 입니다.
	 * @return
	 */
	@RequestMapping(value = "",method = RequestMethod.GET, produces = "application/text; charset=UTF-8")
	public String getAskList() {
		String result;
		result = "{\"list\":[";
		List<AskVO> list = dao.getAskList();
		for(int i=0; i<list.size(); i++) {
			AskVO ask = list.get(i);
			result += "{\"askUID\":\""+ask.getAskUID()+"\",";
			result += "\"subject\":\""+ask.getSubject()+"\",";
			result += "\"feedback\":\""+ask.isFeedback()+"\",";
			result += "\"userEmail\":\""+ask.getUserEmail()+"\",";
			result += "\"active\":\""+ask.getActive()+"\",";
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
	/**
	 * #그 질문답변의 게실글에 대한 모든 정보를 읽어옵니다
	 * @param askUID 질문 유니크 ID
	 * @return
	 */
	//@PathVariable("askUID") Integer askUID <<<<<<<<<<<<<<<<<<<<<<<이거 url 에서 값가져오는거 중요한거
	@RequestMapping(value = "/{askUID}", method = RequestMethod.GET, produces = "application/text; charset=UTF-8")
	public String getAskPage(@PathVariable("askUID") Integer askUID) {
		logger.info(askUID+"<<<<<<<<<<<<<<<<<<<");
		AskVO ask = dao.getAskPage(askUID);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info(ask.toString());
		String content;
		content = ask.getContent();
		content.replaceAll("\n","");
		content.replaceAll("\"", "&#34;");
		content.replaceAll(",", "&#44;");
		String result = "";
		result += "{\"askUID\":\""+ask.getAskUID()+"\",";
		result += "\"userEmail\":\""+ask.getUserEmail()+"\",";
		result += "\"subject\":\""+ask.getSubject()+"\",";
		result += "\"category\":\""+ask.getCategory()+"\",";
		result += "\"phone\":\""+ask.getPhone()+"\",";
		result += "\"content\":\""+ask.getContent().replaceAll("\n", "").replaceAll("\"", "&#34;").replaceAll(",", "&#44;")+"\",";//	replaceAll(System.getProperty("line.separator"), " ") 문자열안의 엔터키 처리할때
		result += "\"uploadDate\":\""+sdf.format(ask.getUploadDate())+"\",";
		result += "\"active\":\""+ask.getActive()+"\",";
		result += "\"file1\":\""+ask.getFile1()+"\",";
		result += "\"file2\":\""+ask.getFile2()+"\",";
		result += "\"file3\":\""+ask.getFile3()+"\"}";
		logger.info(result);
		return result;
	}
	
	/**
	 * ask 의 답변상태를 업로드 하는메서드입니다
	 * @param askUID ask글의 유니크 ID
	 * @param active 변경할 값 2 읽음 3답변완료
	 * @return
	 */
	@RequestMapping(value = "/{askUID}", method = RequestMethod.PATCH, produces = "application/text; charset=UTF-8")
	public String askActiveUpdate(@PathVariable("askUID")Integer askUID, @RequestParam("active") Integer active) {
		//logger.info(askUID+"<<<<<<<<<<<<<<<<");
		//logger.info(active+"<<<<<<<<<<<<<<");
		AskVO ask = new AskVO();
		ask.setAskUID(askUID);
		ask.setActive(active);
		//logger.info(ask.toString()+"<<<<<<<<<<<<");
		dao.updateAskActive(ask);
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
