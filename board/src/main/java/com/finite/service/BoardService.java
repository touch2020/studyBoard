package com.finite.service;

import java.util.List;

import com.finite.vo.BoardVO;

public interface BoardService {
	public void write(BoardVO boardVO);
	public List<BoardVO> list();
}
