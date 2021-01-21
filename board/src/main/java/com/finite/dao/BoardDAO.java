package com.finite.dao;

import java.util.List;

import com.finite.vo.BoardVO;

public interface BoardDAO {
	public void write(BoardVO boardVO);
	public List<BoardVO> list();
}
