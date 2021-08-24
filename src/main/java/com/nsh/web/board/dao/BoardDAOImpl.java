package com.nsh.web.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.nsh.web.board.domain.BoardVO;

@Repository("BoardDAO")
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;

	
	@Override
	public List<BoardVO> getBoardList() throws Exception {
		
		return sqlSession.selectList("com.nsh.web.domain.BoardMapper.getBoardList");

	}

	@Override
	public BoardVO getBoardContent(int bid) throws Exception {
		
		return sqlSession.selectOne("com.nsh.web.domain.BoardMapper.getBoardContent", bid);
	}

	@Override
	public int insertBoard(BoardVO boardVO) throws Exception {
		
		return sqlSession.insert("com.nsh.web.domain.BoardMapper.getBoardContent", boardVO);
	}

	@Override
	public int updateBoard(BoardVO boardVO) throws Exception {
		
		return sqlSession.update("com.nsh.web.domain.BoardMapper.updateBoard", boardVO);
	}

	@Override
	public int deleteBoard(int bid) throws Exception {
		
		return sqlSession.insert("com.nsh.web.domain.BoardMapper.deleteBoard", bid);
	}

	@Override
	public int updateViewCnt(int bid) throws Exception {
		
		return sqlSession.update("com.nsh.web.domain.BoardMapper.updateViewCnt", bid);
	}

}
