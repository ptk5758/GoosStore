package com.ptk.domain;

public class PageVO {
	
	private int totalPage;
	private int nowPage;
	private int lastpage;
	private int pageCut;
	private int limitStart;
	private int totalListCount;
	
	
	
	public int getTotalListCount() {
		return totalListCount;
	}

	public void setTotalListCount(int totalListCount) {
		this.totalListCount = totalListCount;
	}

	public PageVO() {
		this.pageCut = 2;
		this.nowPage = 1;
	}
	
	public int getLimitStart() {
		return limitStart;
	}
	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getLastpage() {
		return lastpage;
	}
	public void setLastpage(int lastpage) {
		this.lastpage = lastpage;
	}
	public int getPageCut() {
		return pageCut;
	}
	public void setPageCut(int pageCut) {
		this.pageCut = pageCut;
	}
	
	public String toString(PageVO vo) {
		return "총페이지 수 "+vo.getTotalPage()+"보여줄 게시물수"+vo.getPageCut()+"현재 페이지"+vo.getNowPage()+"리미트가 시작하는지점"+vo.limitStart+"마지막 페이지"+vo.lastpage;
	}
	
	

}
