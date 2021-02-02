package com.ptk.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShopVO {

	private int itemUID;
	private String itemName;
	private String itemTitle;
	private String itemMidCategory;
	private String itemBottomCategory;
	private String itemPrice;
	private int itemRef;
	private int itemCount;
	private String itemContent;
	private String img_s;
	private String img_m;
	private String img_1;
	private String img_2;
	private String img_3;
	private String User;
	private String UserID;
	private Date signdate;
	



	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDate = sdf.format(this.signdate);
		String result;
		result = "{";
		result += "\"itemUID\":\""+this.itemUID+"\",";
		result += "\"itemName\":\""+this.itemName+"\",";
		result += "\"UserID\":\""+this.UserID+"\",";
		result += "\"itemMidCategory\":\""+this.itemMidCategory+"\",";
		result += "\"itemPrice\":\""+this.itemPrice+"\",";
		result += "\"user\":\""+this.User+"\",";
		result += "\"signdate\":\""+formatDate+"\",";
		result += "\"itemContent\":\""+this.itemContent+"\",";		
		result += "\"itemRef\":\""+this.itemRef+"\",";
		result += "\"itemCount\":\""+this.itemCount+"\",";
		/* result += "\"img_m\":\"http://localhost:8080/6/"+this.img_m+"\","; //로컬용*/
		result += "\"img_m\":\"http://freeptk.shop/6/"+this.img_m+"\",";//웹호스팅용
		result += "\"img_1\":\""+this.img_1+"\",";
		result += "\"img_2\":\""+this.img_2+"\",";
		result += "\"img_3\":\""+this.img_3+"\"";
		result += "}";
		return result;
	} 
	
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getItemContent() {
		return itemContent;
	}

	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}
	public int getItemUID() {
		return itemUID;
	}
	public void setItemUID(int itemUID) {
		this.itemUID = itemUID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public String getItemMidCategory() {
		return itemMidCategory;
	}
	public void setItemMidCategory(String itemMidCategory) {
		this.itemMidCategory = itemMidCategory;
	}
	public String getItemBottomCategory() {
		return itemBottomCategory;
	}
	public void setItemBottomCategory(String itemBottomCategory) {
		this.itemBottomCategory = itemBottomCategory;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemRef() {
		return itemRef;
	}
	public void setItemRef(int itemRef) {
		this.itemRef = itemRef;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public String getImg_s() {
		return img_s;
	}
	public void setImg_s(String img_s) {
		this.img_s = img_s;
	}
	public String getImg_m() {
		return img_m;
	}
	public void setImg_m(String img_m) {
		this.img_m = img_m;
	}
	public String getImg_1() {
		return img_1;
	}
	public void setImg_1(String img_1) {
		this.img_1 = img_1;
	}
	public String getImg_2() {
		return img_2;
	}
	public void setImg_2(String img_2) {
		this.img_2 = img_2;
	}
	public String getImg_3() {
		return img_3;
	}
	public void setImg_3(String img_3) {
		this.img_3 = img_3;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public Date getSigndate() {
		return signdate;
	}
	public void setSigndate(Date signdate) {
		this.signdate = signdate;
	}
	
}

