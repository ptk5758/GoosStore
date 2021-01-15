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
	
	private String[] ENG_MONTH = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	private String[] DAY_OF_WEEK = {"일","월","화","수","목","금","토"};
	private String[] font_color = {"#ff464a","#454545","#454545","#454545","#454545","#454545","#6f6fff"};
	//								   일		월			화		수			목		금			토

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
			String defaultYear = cal.get(Calendar.YEAR)+"";
			int defaultMonth = cal.get(Calendar.MONTH)+1;
			int defaultDate = cal.get(Calendar.DATE);
			String defaultDates = defaultYear+"-"+String.format("%02d", defaultMonth)+"-"+String.format("%02d", defaultDate);
			int count = dao.getAttendCount(defaultDates);
			if(i+1 == 5) {
				result += "{\"day\":\"" + cal.get(Calendar.DATE) + "\",\"MONTH_ENG\":\""+ENG_MONTH[cal.get(Calendar.MONTH)]+"\",\"Month\":\""+(cal.get(Calendar.MONTH)+1)+"\",";
				result += "\"font_color\":\""+font_color[cal.get(Calendar.DAY_OF_WEEK)-1]+"\",";
				result += "\"year\":\""+cal.get(Calendar.YEAR)+"\",";
				result += "\"count\":\""+count+"\",";
				result += "\"DAY_OF_WEEK\":\""+DAY_OF_WEEK[cal.get(Calendar.DAY_OF_WEEK)-1]+"\"}]}";
				break;
			}
			result += "{\"day\":\"" + cal.get(Calendar.DATE) + "\",\"MONTH_ENG\":\""+ENG_MONTH[cal.get(Calendar.MONTH)]+"\",\"Month\":\""+(cal.get(Calendar.MONTH)+1)+"\",";
			result += "\"font_color\":\""+font_color[cal.get(Calendar.DAY_OF_WEEK)-1]+"\",";
			result += "\"year\":\""+cal.get(Calendar.YEAR)+"\",";
			result += "\"count\":\""+count+"\",";
			result += "\"DAY_OF_WEEK\":\""+DAY_OF_WEEK[cal.get(Calendar.DAY_OF_WEEK)-1]+"\"},";
			cal.add(Calendar.DATE, 1);
			
		}
		//logger.info(result);
		return result;
	}
	/**
	 * 기준날 의 기점으로 앞의 날자를 가져옴
	 * @param date 기준날
	 * @return date json
	 */
	@RequestMapping(value = "/getDate", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8", params = {"date"})
	public String getDatePOST(@RequestParam("date") String date) {
		String result;
		//중간에 오늘날짜 총 5개 출력예정
		Calendar cal = Calendar.getInstance();
		int newyear = Integer.parseInt(date.substring(0, 4));
		int newMonth = Integer.parseInt(date.substring(5, 7));
		int newDate = Integer.parseInt(date.substring(8, 10));
		cal.set(newyear, newMonth-1, newDate);
		
		result = "{\"date\":[";
		//"{\"day\":\"1\"},{\"day\":\"2\"},{\"day\":\"3\"},{\"day\":\"4\"},{\"day\":\"5\"}]}";
		
		for(int i=0; i<5; i++) {
			String defaultYear = cal.get(Calendar.YEAR)+"";
			int defaultMonth = cal.get(Calendar.MONTH)+1;
			int defaultDate = cal.get(Calendar.DATE);
			String defaultDates = defaultYear+"-"+String.format("%02d", defaultMonth)+"-"+String.format("%02d", defaultDate);
			int count = dao.getAttendCount(defaultDates);
			if(i+1 == 5) {
				result += "{\"day\":\"" + cal.get(Calendar.DATE) + "\",\"MONTH_ENG\":\""+ENG_MONTH[cal.get(Calendar.MONTH)]+"\",\"Month\":\""+(cal.get(Calendar.MONTH)+1)+"\",";
				result += "\"font_color\":\""+font_color[cal.get(Calendar.DAY_OF_WEEK)-1]+"\",";
				result += "\"year\":\""+cal.get(Calendar.YEAR)+"\",";
				result += "\"count\":\""+count+"\",";
				result += "\"DAY_OF_WEEK\":\""+DAY_OF_WEEK[cal.get(Calendar.DAY_OF_WEEK)-1]+"\"}]}";
				break;
			}
			result += "{\"day\":\"" + cal.get(Calendar.DATE) + "\",\"MONTH_ENG\":\""+ENG_MONTH[cal.get(Calendar.MONTH)]+"\",\"Month\":\""+(cal.get(Calendar.MONTH)+1)+"\",";
			result += "\"font_color\":\""+font_color[cal.get(Calendar.DAY_OF_WEEK)-1]+"\",";
			result += "\"year\":\""+cal.get(Calendar.YEAR)+"\",";
			result += "\"count\":\""+count+"\",";
			result += "\"DAY_OF_WEEK\":\""+DAY_OF_WEEK[cal.get(Calendar.DAY_OF_WEEK)-1]+"\"},";
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
			String defaultYear = cal.get(Calendar.YEAR)+"";
			int defaultMonth = cal.get(Calendar.MONTH)+1;
			int defaultDate = cal.get(Calendar.DATE);
			String defaultDates = defaultYear+"-"+String.format("%02d", defaultMonth)+"-"+String.format("%02d", defaultDate);
			int count = dao.getAttendCount(defaultDates);
			logger.info(defaultDate+"<<<<<");
			
			if(i+1 == 2) {
				result += "{\"day\":\"" + cal.get(Calendar.DATE) + "\",\"MONTH_ENG\":\""+ENG_MONTH[cal.get(Calendar.MONTH)]+"\",\"Month\":\""+(cal.get(Calendar.MONTH)+1)+"\",";
				result += "\"font_color\":\""+font_color[cal.get(Calendar.DAY_OF_WEEK)-1]+"\",";
				result += "\"year\":\""+cal.get(Calendar.YEAR)+"\",";
				result += "\"count\":\""+count+"\",";
				result += "\"DAY_OF_WEEK\":\""+DAY_OF_WEEK[cal.get(Calendar.DAY_OF_WEEK)-1]+"\"}]}";
				break;
			}
			result += "{\"day\":\"" + cal.get(Calendar.DATE) + "\",\"MONTH_ENG\":\""+ENG_MONTH[cal.get(Calendar.MONTH)]+"\",\"Month\":\""+(cal.get(Calendar.MONTH)+1)+"\",";
			result += "\"font_color\":\""+font_color[cal.get(Calendar.DAY_OF_WEEK)-1]+"\",";
			result += "\"year\":\""+cal.get(Calendar.YEAR)+"\",";
			result += "\"count\":\""+count+"\",";
			result += "\"DAY_OF_WEEK\":\""+DAY_OF_WEEK[cal.get(Calendar.DAY_OF_WEEK)-1]+"\"},";
		}
		//logger.info(result);
		return result;
	}
	
	
	/**
	 * 겟 기준 날짜 의 뒤에 날짜를 불러오는 메소드의 오버로딩 
	 * @param date 기준날짜
	 * @return date json
	 */
	@RequestMapping(value = "/backDate", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8", params = {"date"})
	public String getBackDate(@RequestParam("date") String date) {
		String result;
		int newyear = Integer.parseInt(date.substring(0, 4));
		int newMonth = Integer.parseInt(date.substring(5, 7));
		int newDate = Integer.parseInt(date.substring(8, 10));
		Calendar cal = Calendar.getInstance();
		cal.set(newyear, newMonth-1, newDate);
		result = "{\"backDate\":[";
		for(int i=0; i<2; i++) {
			cal.add(Calendar.DATE, -1);
			String defaultYear = cal.get(Calendar.YEAR)+"";
			int defaultMonth = cal.get(Calendar.MONTH)+1;
			int defaultDate = cal.get(Calendar.DATE);
			String defaultDates = defaultYear+"-"+String.format("%02d", defaultMonth)+"-"+String.format("%02d", defaultDate);
			int count = dao.getAttendCount(defaultDates);
			logger.info(defaultDate+"<<<<<");
			if(i+1 == 2) {
				result += "{\"day\":\"" + cal.get(Calendar.DATE) + "\",\"MONTH_ENG\":\""+ENG_MONTH[cal.get(Calendar.MONTH)]+"\",\"Month\":\""+(cal.get(Calendar.MONTH)+1)+"\",";
				result += "\"font_color\":\""+font_color[cal.get(Calendar.DAY_OF_WEEK)-1]+"\",";
				result += "\"year\":\""+cal.get(Calendar.YEAR)+"\",";
				result += "\"count\":\""+count+"\",";
				result += "\"DAY_OF_WEEK\":\""+DAY_OF_WEEK[cal.get(Calendar.DAY_OF_WEEK)-1]+"\"}]}";
				break;
			}
			result += "{\"day\":\"" + cal.get(Calendar.DATE) + "\",\"MONTH_ENG\":\""+ENG_MONTH[cal.get(Calendar.MONTH)]+"\",\"Month\":\""+(cal.get(Calendar.MONTH)+1)+"\",";
			result += "\"font_color\":\""+font_color[cal.get(Calendar.DAY_OF_WEEK)-1]+"\",";
			result += "\"year\":\""+cal.get(Calendar.YEAR)+"\",";
			result += "\"count\":\""+count+"\",";
			result += "\"DAY_OF_WEEK\":\""+DAY_OF_WEEK[cal.get(Calendar.DAY_OF_WEEK)-1]+"\"},";
		}
		//logger.info(result);
		return result;
	}
		
	
	@RequestMapping(value = "/attendInsert", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	public String attendInsert(@RequestBody AttendVO attend) {
		//logger.info(attend.toString());
		if(attend.getContent().equals("") || attend.getUserID().equals("") || attend.getUserNickName().equals("")) {
			return "등록하는대 실패하였습니다.";
		}
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = sdf.format(date);
		try {
			
		  if(today.substring(0,10).equals(lastAttend(attend).substring(0, 10))) {
			  return "오늘은 이미 출석체크를 하셨습니다."; 
		  } else {
			  attend.setLastAttendDate(today);
			  dao.insertAttend(attend); 
			  //dao.updateLastAttend(attend);
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
		if(list.isEmpty()) {
			result += "{\"userID\":\"\",";
			result += "\"userLevel\":\"1\",";
			result += "\"userNickName\":\"사람\",";
			result += "\"attendDate\":\"\",";
			result += "\"content\":\"1등할사람 기다리는중\"}]}";
		} else {
			for(int i=0; i<list.size(); i++) {
				AttendVO attend = list.get(i);
				result += "{\"userID\":\""+attend.getUserID()+"\",";
				result += "\"userLevel\":\""+attend.getUserLevel()+"\",";
				result += "\"userNickName\":\""+attend.getUserNickName()+"\",";
				result += "\"attendUID\":\""+attend.getAttendUID()+"\",";
				result += "\"attendDate\":\""+sdf.format(attend.getAttendDate())+"\",";
				result += "\"content\":\""+attend.getContent()+"\"}";
				if(i+1 == list.size()) {
					result += "]}";
				} else {
					result += ",";
				}
			}
		}
		
		//logger.info(result);
		
		return result;
	}
	
	@RequestMapping(value = "/attendUpdate", method = RequestMethod.PATCH, produces = "application/text; charset=UTF-8")
	public String attendUpdate(@RequestBody AttendVO attend) {
		dao.attendUpdate(attend);
		return "{\"value\":\"ok\",\"msg\":\"수정완료\"}";
	}
	
	@RequestMapping(value = "/attendDelete", method = RequestMethod.DELETE, produces = "application/text; charset=UTF-8")
	public String attendDelete(@RequestBody AttendVO attend) {
		logger.info(attend.toString()+"================");
		dao.attendDelete(attend);
		return "{\"value\":\"ok\",\"msg\":\"삭제완료\"}";
	}
	
	@RequestMapping(value = "/getAttendCount", method = RequestMethod.GET, produces = "application/text; charset=UTF-8")
	public String getAttendCount(@RequestParam("date")String date) {
		logger.info(date+"dsfjkahfdkjsa");
		return "성공";
	}
	
	
	
	
	
	
	
	
	
	
	
	private String lastAttend(AttendVO attend) {
		List<String> string = dao.getLastAttend(attend);
		
		return string.get(0);
	}
	
	
	
	
	
	
	
	
}











