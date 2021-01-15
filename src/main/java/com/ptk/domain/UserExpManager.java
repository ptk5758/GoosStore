package com.ptk.domain;

import java.util.HashMap;
import java.util.Map;

import com.ptk.persistence.AttendDAO;

public class UserExpManager {
	
	private UserVO user;
	
	private static AttendDAO dao;
	
	public UserExpManager(UserVO object) {
		this.user = object;
	}
	
	public static String expUp(UserVO user, Integer exp) {
		HashMap<UserVO, Integer> list = new HashMap<UserVO, Integer>();
		list.put(user, exp);
		return list.toString()+"이게맞냐"+exp;
		
	}

}
