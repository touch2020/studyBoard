package com.finite.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.finite.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void write(BoardVO boardVO) {
		// TODO Auto-generated method stub
		sqlSession.insert("boardMapper.insert", boardVO);
	}

	@Override
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardMapper.list");
	}

	@Override
	public BoardVO select(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("boardMapper.select", bno);
	}

	@Override
	public void update(BoardVO boardVO) {
		// TODO Auto-generated method stub
		sqlSession.update("boardMapper.update", boardVO);
		
	}

	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub
		sqlSession.delete("boardMapper.delete", bno);
	}

}
