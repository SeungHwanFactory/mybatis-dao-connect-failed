package com.nsh.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nsh.web.board.dao.BoardDAO;
import com.nsh.web.board.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
@Log4j
public class BoardDAOTest {

	@Inject
	private BoardDAO boardDAO;

	

	@Test 
	public void testGetBoardList() throws Exception {

		List<BoardVO> boardList = boardDAO.getBoardList();

		log.info("\n Board List \n ");
		log.info(boardList);

		if(boardList.size() > 0) {

			for(BoardVO list : boardList) {

				log.info(list.title);

			}

		} else {

			log.info("데이터가 없습니다.");

		}

	}

	

	//@Test //@Ignore

	public void testGetBoardContent() throws Exception {

		BoardVO boardVO = boardDAO.getBoardContent(1);

		log.info("\n Board List \n ");

		if(boardVO != null) {

			log.info("글번호 : " + boardVO.getBid() );

			log.info("글제목 : " + boardVO.getTitle() );

			log.info("글내용 : " + boardVO.getContent() );

			log.info("글태그 : " + boardVO.getTag() );

			log.info("조회수 : " + boardVO.getView_cnt() );

			log.info("작성자 : " + boardVO.getReg_id() );

			log.info("작성일 : " + boardVO.getReg_dt() );

			log.info("수정일 : " + boardVO.getEdit_dt() );

		} else {

			log.info("데이터가 없습니다.");

		}

	}

	

	//@Test 
	public void testInsertBoard() throws Exception {

		BoardVO boardVO = new BoardVO();

		boardVO.setCate_cd("1");

		boardVO.setTitle("첫번째 게시물 입니다.");

		boardVO.setContent("첫번째 게시물입니다.");

		boardVO.setTag("1");

		boardVO.setReg_id("1");

		

		int result = boardDAO.insertBoard(boardVO);

		log.info("\n Insert Board Result " +result);

		if(result == 1) {

			log.info("\n 게시물 등록 성공 ");

		} else {

			log.info("\n 게시물 등록 실패");

		}

	}

	

	//@Test //@Ignore 

	public void testUpdateBoard() throws Exception {

		BoardVO boardVO = new BoardVO();

		boardVO.setBid(1);

		boardVO.setCate_cd("1");

		boardVO.setTitle("첫번째 게시물 입니다-수정 합니다.");

		boardVO.setContent("첫번째 게시물입니다-수정합니다.");

		boardVO.setTag("1-1");

		

		int result = boardDAO.updateBoard(boardVO);

		log.info("\n Update Board Result \n ");

		if(result > 0) {

			log.info("\n 게시물 수정 성공 ");

		} else {

			log.info("\n 게시물 수정 실패");

		}

	}

	

	//@Test   //@Ignore

	public void tesDeleteBoard() throws Exception {

		

		int result = boardDAO.deleteBoard(1);

		log.info("\n Delete Board Result \n ");

		if(result > 0) {

			log.info("\n 게시물 삭제 성공 ");

		} else {

			log.info("\n 게시물 삭제 실패");

		}

	}



	//@Test @Ignore
	public void testUpdateViewCnt() throws Exception {

		

		int result = boardDAO.updateViewCnt(1);

		log.info("\n Update View Count Result \n ");

		if(result > 0) {

			log.info("\n 게시물 조회수 업데이트 성공 ");

		} else {

			log.info("\n 게시물 조회수 업데이트 실패");

		}

	}

	
}
