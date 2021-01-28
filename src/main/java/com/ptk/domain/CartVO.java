package com.ptk.domain;

import java.util.Date;

public class CartVO {
	 private int cartUID;
	 private int itemUID;
	 private int itemCount;
	 private String userID;
	 private Date cartDate;
	 
	 @Override
	public String toString() {
		String result;
		result = "";
		result += "{\"cartUID\":\""+this.cartUID+"\",";
		result += "\"itemUID\":\""+this.itemUID+"\",";
		result += "\"itemCount\":\""+this.itemCount+"\",";
		result += "\"userID\":\""+this.userID+"\",";
		result += "\"cartDate\":\""+this.cartDate+"\"}";
		return result;
	}
	 
	 

	public int getItemUID() {
		return itemUID;
	}

	public void setItemUID(int itemUID) {
		this.itemUID = itemUID;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getCartUID() {
		return cartUID;
	}

	public void setCartUID(int cartUID) {
		this.cartUID = cartUID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public Date getCartDate() {
		return cartDate;
	}

	public void setCartDate(Date cartDate) {
		this.cartDate = cartDate;
	}
	 
	 
}
