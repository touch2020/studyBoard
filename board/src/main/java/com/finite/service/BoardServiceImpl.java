package com.finite.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.finite.dao.BoardDAO;
import com.finite.vo.BoardPage;
import com.finite.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO dao;
	
	@Override
	public void write(BoardVO boardVO) {

		dao.write(boardVO);
		

	}

	@Override
	public List<BoardVO> list(BoardPage bp) {
		// TODO Auto-generated method stub
		return dao.list(bp);
	}

	@Override
	public BoardVO select(int bno) {
		// TODO Auto-generated method stub
		return dao.select(bno);
	}

	@Override
	public void update(BoardVO boardVO) {
		// TODO Auto-generated method stub
		dao.update(boardVO);
	}

	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub
		dao.delete(bno);
	}

	@Override
	public int listCount() {
		// TODO Auto-generated method stub
		return dao.listCount();
	}

}
