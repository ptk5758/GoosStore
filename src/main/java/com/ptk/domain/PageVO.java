package com.ptk.domain;

public class PageVO {
	private int showPage; //보여지는페이지
	private int nowPage; //현재페이지
	private int startPage; //시작페이지
	private int firstLimitPage; //첫번쨰리미트 페이지
	private int totalPage; //전체페이지
	private int totalList; //전체리스트
	private String seller;
	
	
	public String getSeller() {
		return seller;
	}


	public void setSeller(String seller) {
		this.seller = seller;
	}


	public PageVO() {
		this.showPage = 5;
		this.firstLimitPage = 0;
		this.nowPage = 1;
	}
	
	
	public int getShowPage() {
		return showPage;
	}

	public void setShowPage(int showPage) {
		this.showPage = showPage;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getFirstLimitPage() {
		return firstLimitPage;
	}

	public void setFirstLimitPage(int firstLimitPage) {
		this.firstLimitPage = firstLimitPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalList() {
		return totalList;
	}

	public void setTotalList(int totalList) {
		this.totalList = totalList;
	}

	@Override
	public String toString() {
		return"페이지::"+this.showPage+"현재페이지::"+this.nowPage+"시작페이지::"+this.startPage+"리미트::"+this.firstLimitPage+"전체페이지::"+this.totalPage+"전체리스트::"+this.totalList;
	}
}
