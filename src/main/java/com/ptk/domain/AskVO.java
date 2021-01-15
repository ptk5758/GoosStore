package com.ptk.domain;

import java.util.Date;

public class AskVO {
	 private int askUID;
	 private String subject;
	 private String userEmail;
	 private String category;
	 private String phone;
	 private String content;
	 private Date uploadDate;
	 private String file1;
	 private String file2;
	 private String file3;
	
	 public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getAskUID() {
		return askUID;
	}

	public void setAskUID(int askUID) {
		this.askUID = askUID;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getFile1() {
		return file1;
	}

	public void setFile1(String file1) {
		this.file1 = file1;
	}

	public String getFile2() {
		return file2;
	}

	public void setFile2(String file2) {
		this.file2 = file2;
	}

	public String getFile3() {
		return file3;
	}

	public void setFile3(String file3) {
		this.file3 = file3;
	}

	@Override
	public String toString() {
		return "askUID:"+this.askUID+"userEmail:"+this.userEmail+"category:"+this.category+"phone:"+this.phone+"content:"+this.content+"uploadDate:"+this.uploadDate+""
				+ "file1:"+this.file1+"file2:"+this.file2+"file3:"+this.file3+"";
	}
}
