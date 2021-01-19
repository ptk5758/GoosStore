package com.ptk.domain;

import java.util.Date;

public class FeedVO {
	
	private int askUID;
	private String admin;
	private String content;
	private Date feedDate;
	private String file1;
	private String file2;
	private String file3;
	
	public int getAskUID() {
		return askUID;
	}

	public void setAskUID(int askUID) {
		this.askUID = askUID;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getFeedDate() {
		return feedDate;
	}

	public void setFeedDate(Date feedDate) {
		this.feedDate = feedDate;
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
		return "|askUID::"+this.askUID+"|admin::"+this.admin+"|content::"+this.content+"|feedDate::"+this.feedDate+"|file1::"+this.file1+"|file2::"+this.file2+"|file3::"+this.file3+"";
	}

}
