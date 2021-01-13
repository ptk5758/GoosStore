package com.ptk.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ptk.domain.AttendVO;
import com.ptk.persistence.AttendDAO;

@RestController
@RequestMapping("/restAttend/")
public class AttendRestController {
	
	@Inject
	private AttendDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(AttendRestController.class);
	
	private String[] ENG_MONTH = {"January","April","March","April","May","June","July","August","September","October","November","December"};
	private String[] DAY_OF_WEEK = {"일","월","화","수","목","금","토","일"};
	private String[] font_color = {"#454545","#454545","#454545","#454545","#454545","#6f6fff","#ff464a"};
	//								   월		화			수		목			금		토			일

	/**
	 * 날짜를 가져오는 API입니다. 20% 진행
	 * count 의 default 값은 5이며 count 는 가져올 날짜의 수입니다.
	 * @return
	 */
	@RequestMapping(value = "/getDate", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public String getDatePOST() {
		String result;
		//중간에 오늘날짜 총 5개 출력예정
		Calendar cal = Calendar.getInstance();
		
		
		result = "{\"date\":[";
		//"{\"day\":\"1\"},{\"day\":\"2\"},{\"day\":\"3\"},{\"day\":\"4\"},{\"day\":\"5\"}]}";
		
		for(int i=0; i<5; i++) {
			if(i+1 == 5) {
				result += "{\"day\":\"" + cal.get(Calendar.DATE) + "\",\"MONTH_ENG\":\""+ENG_MONTH[cal.get(Calendar.MONTH)]+"\",\"Month\":\""+cal.get(Calendar.MONTH)+1+"\",";
				result += "\"font_color\":\""+font_color[cal.get(Calendar.DAY_OF_WEEK)-1]+"\",";
				result += "\"DAY_OF_WEEK\":\""+DAY_OF_WEEK[cal.get(Calendar.DAY_OF_WEEK)]+"\"}]}";
				break;
			}
			result += "{\"day\":\"" + cal.get(Calendar.DATE) + "\",\"MONTH_ENG\":\""+ENG_MONTH[cal.get(Calendar.MONTH)]+"\",\"Month\":\""+cal.get(Calendar.MONTH)+1+"\",";
			result += "\"font_color\":\""+font_color[cal.get(Calendar.DAY_OF_WEEK)-1]+"\",";
			result += "\"DAY_OF_WEEK\":\""+DAY_OF_WEEK[cal.get(Calendar.DAY_OF_WEEK)]+"\"},";
			cal.add(Calendar.DATE, 1);
			
		}
		//logger.info(result);
		return result;
	}
	
	@RequestMapping(value = "/backDate", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public String getBackDate() {
		String result;
		Calendar cal = Calendar.getInstance();
		result = "{\"backDate\":[";
		for(int i=0; i<2; i++) {
			cal.add(Calendar.DATE, -1);
			if(i+1 == 2) {
				result += "{\"day\":\"" + cal.get(Calendar.DATE) + "\",\"MONTH_ENG\":\""+ENG_MONTH[cal.get(Calendar.MONTH)]+"\",\"Month\":\""+cal.get(Calendar.MONTH)+1+"\",";
				result += "\"font_color\":\""+font_color[cal.get(Calendar.DAY_OF_WEEK)-1]+"\",";
				result += "\"DAY_OF_WEEK\":\""+DAY_OF_WEEK[cal.get(Calendar.DAY_OF_WEEK)]+"\"}]}";
				break;
			}
			result += "{\"day\":\"" + cal.get(Calendar.DATE) + "\",\"MONTH_ENG\":\""+ENG_MONTH[cal.get(Calendar.MONTH)]+"\",\"Month\":\""+cal.get(Calendar.MONTH)+1+"\",";
			result += "\"font_color\":\""+font_color[cal.get(Calendar.DAY_OF_WEEK)-1]+"\",";
			result += "\"DAY_OF_WEEK\":\""+DAY_OF_WEEK[cal.get(Calendar.DAY_OF_WEEK)]+"\"},";
		}
		//logger.info(result);
		return result;
	}
	@RequestMapping(value = "/attendInsert", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	public String attendInsert(@RequestBody AttendVO attend) {
		logger.info(attend.toString());
		if(attend.getContent().equals("") || attend.getUserID().equals("") || attend.getUserNickName().equals("")) {
			return "등록하는대 실패하였습니다.";
		}
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = sdf.format(date);
		try {
			
		  logger.info(lastAttend(attend)+"마지막 출석체크 일자");
		  if(today.substring(0,10).equals(lastAttend(attend).substring(0, 10))) {
			  return "오늘은 이미 출석체크를 하셨습니다."; 
		  } else {
			  attend.setLastAttendDate(today);
			  dao.insertAttend(attend); 
			  dao.updateLastAttend(attend);
		  }
		} catch (Exception e) {
			return "알수없는 오류로인해 등록에 실패하였습니다";
		}
		return "등록성공";
	}
	
	@RequestMapping(value = "/getAttendList", method = RequestMethod.GET, produces = "application/text; charset=UTF-8")
	public String getAttendList(@RequestParam("date") String date) {
		String result;
		List<AttendVO> list = dao.getAttendList(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//result = "{\"list\":[{\"name\":\"ptk\"},{\"name\":\"pty\"}]}";
		result = "{\"list\":[";
		for(int i=0; i<list.size(); i++) {
			AttendVO attend = list.get(i);
			result += "{\"userID\":\""+attend.getUserID()+"\",";
			result += "\"userNickName\":\""+attend.getUserNickName()+"\",";
			result += "\"attendDate\":\""+sdf.format(attend.getAttendDate())+"\",";
			result += "\"content\":\""+attend.getContent()+"\"}";
			if(i+1 == list.size()) {
				result += "]}";
			} else {
				result += ",";
			}
		}
		logger.info(result);
		
		return result;
	}
	
	private String lastAttend(AttendVO attend) {
		List<String> string = dao.getLastAttend(attend);
		
		return string.get(0);
	}
	
	
	
	
	
	
	
	
}











