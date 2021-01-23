package com.finite.vo;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum = 10;
	private BoardPage bp;
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public boolean isNext() {
		return next;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public BoardPage getBp() {
		return bp;
	}
	public void setBp(BoardPage bp) {
		this.bp = bp;
	}
	
	private void calcData() {
		//현재 페이지/ 10 이후 올림을 통해 현재 몇페이지인지 구하고 * 10을 통해 페이지 블록 넘버 구하기
		endPage = (int) (Math.ceil(bp.getPage()/ (double)displayPageNum)* displayPageNum);
		startPage = (endPage - displayPageNum) + 1;
		
		//전체 페이지를 페이지당 게시물 갯수로 나누고 올림을 통해 realendpage 구하기
		//ex)현재페이지 12  end page = 20, total count = 125 tempEndPage = 13
		//전체 게시글 수를 이용해서 실제 endpage를 구해서 실제 endpage가 더 작다면 더 상세한 값인 realendpage로 대체
		int realEndPage = (int) (Math.ceil(totalCount) / (double)bp.getPerPageNum());
		if(endPage > realEndPage) {
			endPage = realEndPage;
		}
		prev = startPage == 1 ? false : true;
		next = endPage * bp.getPerPageNum() >= totalCount ? false : true;
	}
	
	public String makeQuery(int page) {
		UriComponents uriComponents =
		UriComponentsBuilder.newInstance()
						    .queryParam("page", page)
							.queryParam("perPageNum", bp.getPerPageNum())
							.build();
		   
		return uriComponents.toUriString();
	}
	
	

}
