package com.finite.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.finite.dao.BoardDAO;
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
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

}
