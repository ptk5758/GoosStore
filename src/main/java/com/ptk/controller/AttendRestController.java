package com.ptk.controller;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restAttend/")
public class AttendRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(AttendRestController.class);

	/**
	 * 날짜를 가져오는 API입니다. 20% 진행
	 * count 의 default 값은 5이며 count 는 가져올 날짜의 수입니다.
	 * @return
	 */
	@RequestMapping(value = "/getDate", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public String getDatePOST() {
		String result;
		//중간에 오늘날짜 총 5개 출력예정
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		result = "{\"date\":[";
		//"{\"day\":\"1\"},{\"day\":\"2\"},{\"day\":\"3\"},{\"day\":\"4\"},{\"day\":\"5\"}]}";
		String[] ENG_MONTH = {"January","April","March","April","May","June","July","August","September","October","November","December"};
		for(int i=0; i<5; i++) {
			if(i+1 == 5) {
				result += "{\"day\":\"" + cal.get(Calendar.DATE) + "\",\"MONTH_ENG\":\""+ENG_MONTH[cal.get(Calendar.MONTH)]+"\",\"Month\":\""+cal.get(Calendar.MONTH)+1+"\"}]}";
				break;
			}
			result += "{\"day\":\"" + cal.get(Calendar.DATE) + "\",\"MONTH_ENG\":\""+ENG_MONTH[cal.get(Calendar.MONTH)]+"\",\"Month\":\""+cal.get(Calendar.MONTH)+1+"\"},";
			cal.add(Calendar.DATE, 1);
			
		}
		logger.info(result);
		return result;
	}
}
