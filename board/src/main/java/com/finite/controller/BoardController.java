package com.finite.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finite.service.BoardService;
import com.finite.vo.BoardPage;
import com.finite.vo.BoardVO;
import com.finite.vo.PageMaker;

@Controller
@RequestMapping("/board/")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	//게시글 작성 화면 호출
	@RequestMapping(value="writeView", method = RequestMethod.GET)
	public void writeView() throws Exception {
		logger.info("writeView");
		

	}
	//게시글 작성
	@RequestMapping(value="write", method = RequestMethod.POST)
	public String write(BoardVO boardVO) throws Exception{
		logger.info("write");
		
		service.write(boardVO);
		
		return "redirect:/board/list";
	}
	//게시글 목록 리스트 조회
	@RequestMapping(value="list" ,method = RequestMethod.GET)
	public String list(Model model, BoardPage bp) {
		logger.info("list");
		
		model.addAttribute("list", service.list(bp));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setBp(bp);
		pageMaker.setTotalCount(service.listCount());
		
		model.addAttribute("pageMaker", pageMaker);
		
		
		return "board/list";
	}
	//게시글 상세 조회
	@RequestMapping(value="selectView", method = RequestMethod.GET)
	public String selectView(BoardVO vo, Model model) {
		logger.info("selectView");
		
		model.addAttribute("select", service.select(vo.getBno()));
		
		return "board/selectView";
	}
	//게시글 수정 화면 호출
	@RequestMapping(value="updateView", method = RequestMethod.GET)
	public String updateView(BoardVO vo, Model model) {
		logger.info("updateView");
		
		model.addAttribute("update", service.select(vo.getBno()));
		
		return "board/updateView";
	}
	//게시글 수정
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String update(BoardVO vo) {
		logger.info("update");
		
		service.update(vo);
		
		return "redirect:/board/list";
	}
	//게시글 삭제
	@RequestMapping(value="delete", method = RequestMethod.POST)
	public String delete(BoardVO vo) {
		logger.info("delete");
		
		service.delete(vo.getBno());
		
		return "redirect:/board/list";
	}
	
	
	
}
