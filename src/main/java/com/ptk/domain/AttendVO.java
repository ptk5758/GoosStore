package com.ptk.domain;

import java.util.Date;

public class AttendVO {
	
	private String userID;
	private String userNickName;
	private String content;
	private Date attendDate;
	private Date lastAttendDate;
	private int attendRun;
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getAttendDate() {
		return attendDate;
	}

	public void setAttendDate(Date attendDate) {
		this.attendDate = attendDate;
	}

	public Date getLastAttendDate() {
		return lastAttendDate;
	}

	public void setLastAttendDate(Date lastAttendDate) {
		this.lastAttendDate = lastAttendDate;
	}

	public int getAttendRun() {
		return attendRun;
	}

	public void setAttendRun(int attendRun) {
		this.attendRun = attendRun;
	}

	@Override
	public String toString() {
		String result = "유저아이디::"+this.userID+" 유저닉네임::"+this.userNickName+" 내용::"+this.content+" 출석체크날짜::"+this.attendDate+" 마지막출석체크일::"+this.lastAttendDate+" 연속출석체크::"+this.attendRun+"";
		return result;
	}
}
