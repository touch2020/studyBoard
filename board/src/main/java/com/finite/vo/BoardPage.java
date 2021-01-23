package com.finite.vo;

public class BoardPage {
	
	//현재 페이지
	private int page;
	//페이지당 게시물 수
	private int perPageNum;
	//블록 시작 페이지 
	private int pageStart;
	//블록 마지막 페이지
	private int pageEnd;
	
	public BoardPage() {
		this.page = 1;
		this.perPageNum = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}

	public int getPageStart() {
		pageStart = (page-1)*perPageNum + 1;
		return pageStart;
	}


	public int getPageEnd() {
		pageEnd = pageStart + perPageNum -1;
		return pageEnd;
	}

	
	

}
