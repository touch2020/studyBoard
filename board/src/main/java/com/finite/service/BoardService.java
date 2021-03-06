package com.finite.service;

import java.util.List;

import com.finite.vo.BoardPage;
import com.finite.vo.BoardVO;

public interface BoardService {
	//게시글 작성
	public void write(BoardVO boardVO);
	//게시 목록 조회
	public List<BoardVO> list(BoardPage bp);
	//게시물 총 갯수
	public int listCount();
	//게시글 상세 조회
	public BoardVO select(int bno);
	//게시글 수정
	public void update(BoardVO boardVO);
	//게시글 삭제
	public void delete(int bno);
}
