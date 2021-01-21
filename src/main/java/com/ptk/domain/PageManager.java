package com.ptk.domain;
/**
 * PageVO 값을 받아 페이지 값을 설정해주는 클레스
 * @author pc1
 *
 */
public class PageManager {
	
	private PageVO object;
	/**
	 * 생성자를 생성과 동시에 init()메서드를 사용하여 변수값 초기화
	 * @param vo 리스트의 PageVO 값을 읽어옴
	 */
	public PageManager(PageVO vo) {
		object = vo;
		init();
	}
	/**
	 * 주요 변수들을 초기화하하는메서드
	 * 총 페이지수 총 리스트수(totalList)(임시 132개)를 보여줄리스트의(PageCut) 갯수 로 나눈값   
	 * 현재페이지가 0 보다 작은경우 현재페이지 1
	 * 현재페이지가 마지막 페이지보다 큰경우 현재페이지는 마지막페이지
	 */
	private void init() {
		//int total = object.getTotalListCount();
		int total = 11;
		object.setTotalPage((int)Math.ceil((double)total/object.getPageCut()));
		object.setLastpage(object.getTotalPage());
		if(object.getNowPage() <= 0) {
			object.setNowPage(1);
		}
		if(object.getNowPage() >= object.getTotalPage()) {
			object.setNowPage(object.getLastpage());
		}
		object.setLimitStart((object.getNowPage()*object.getPageCut())-object.getPageCut());
	}
	/**
	 * object 에 값을 담아준것을 리턴해주는 메서드
	 * @return PageVO의 페이지값
	 */
	public PageVO getPageVO() {
		return this.object;
	}

}
