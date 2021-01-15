package com.ptk.domain;

public class UserVO {
	
	private int userUUID;
	private String userName;
	private String userID;
	private String userPassword;
	private String userSignUpDate;
	private String userSteamID;
	private String userNickName;
	private String userPhone;
	private String userEmail;
	private int userLevel;
	private int userExp;
	

	public int getUserExp() {
		return userExp;
	}
	public void setUserExp(int userExp) {
		this.userExp = userExp;
	}
	public int getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getUserUUID() {
		return userUUID;
	}
	public void setUserUUID(int userUUID) {
		this.userUUID = userUUID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserSignUpDate() {
		return userSignUpDate;
	}
	public void setUserSignUpDate(String userSignUpDate) {
		this.userSignUpDate = userSignUpDate;
	}
	public String getUserSteamID() {
		return userSteamID;
	}
	public void setUserSteamID(String userSteamID) {
		this.userSteamID = userSteamID;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	
	@Override
	public String toString() {
		return userUUID+" = 유니크아이디, "
				+userName+" = 유저이름, "
				+userID+" = 유저아이디, "
				+userPassword+" = 유저비밀번호, "
				+userSignUpDate+" = 회원가입날자, "
				+userSteamID+" = 유저스팀아이디, "
				+userNickName+" = 유저닉네임, "
				+userPhone+" = 전화번호, "
				+userEmail+" = 유저이메일주소,"
				+userExp+" = 유저포인트,"
				+userLevel+" = 유저레벨";
	}
}

