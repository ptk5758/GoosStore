package com.ptk.domain;

public class SellerVO {
	private String name;
	private String sellerID;
	private String phone;
	private String postcod;
	private String addr1;
	private String addr2;
	private String img;
	private String comment;
	
	@Override
	public String toString() {
		String result;
		result = "";
		result += "{\"name\":\""+this.name+"\"},";
		result += "{\"sellerID\":\""+this.sellerID+"\"},";
		result += "{\"phone\":\""+this.phone+"\"},";
		result += "{\"postcod\":\""+this.postcod+"\"},";
		result += "{\"addr1\":\""+this.addr1+"\"},";
		result += "{\"addr2\":\""+this.addr2+"\"},";
		result += "{\"comment\":\""+this.comment+"\"},";
		result += "{\"img\":\""+this.img+"\"}";
		return result;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSellerID() {
		return sellerID;
	}
	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPostcod() {
		return postcod;
	}
	public void setPostcod(String postcod) {
		this.postcod = postcod;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
