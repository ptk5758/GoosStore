package com.ptk.domain;


public class CartVO {
	private int cart_uid;
	private String user_id;
	private int item_uid;
	private int amount;
	private String itemName;
	private String itemBottomCategory;
	private String itemPrice;
	private String img_m;
	
	
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
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
	public String getImg_m() {
		return img_m;
	}
	public void setImg_m(String img_m) {
		this.img_m = img_m;
	}
	public int getCart_uid() {
		return cart_uid;
	}
	public void setCart_uid(int cart_uid) {
		this.cart_uid = cart_uid;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getItem_uid() {
		return item_uid;
	}
	public void setItem_uid(int item_uid) {
		this.item_uid = item_uid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
