package com.ptk.domain;

import java.util.Date;

public class CommunityVO {
	private int postUid;
	private String postUsername;
	private String postTitle;
	private String postImage;
	private String postContent;
	private int postViews;
	private Date postDate;
	private String Spare1;
	private String Spare2;
	private String Spare3;
	public int getPostUid() {
		return postUid;
	}
	public void setPostUid(int postUid) {
		this.postUid = postUid;
	}
	public String getPostUsername() {
		return postUsername;
	}
	public void setPostUsername(String postUsername) {
		this.postUsername = postUsername;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public int getPostViews() {
		return postViews;
	}
	public void setPostViews(int postViews) {
		this.postViews = postViews;
	}
	public String getPostImage() {
		return postImage;
	}
	public void setPostImage(String postImage) {
		this.postImage = postImage;
	}
	public String getSpare1() {
		return Spare1;
	}
	public void setSpare1(String spare1) {
		Spare1 = spare1;
	}
	public String getSpare2() {
		return Spare2;
	}
	public void setSpare2(String spare2) {
		Spare2 = spare2;
	}
	public String getSpare3() {
		return Spare3;
	}
	public void setSpare3(String spare3) {
		Spare3 = spare3;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	
	
}
