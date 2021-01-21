package com.finite.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finite.service.BoardService;
import com.finite.vo.BoardVO;

@Controller
@RequestMapping("/board/")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
	@RequestMapping(value="writeView", method = RequestMethod.GET)
	public void writeView() throws Exception {
		logger.info("writeView");
		

	}
	
	@RequestMapping(value="write", method = RequestMethod.POST)
	public String write(BoardVO boardVO) throws Exception{
		logger.info("write");
		
		service.write(boardVO);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="list" ,method = RequestMethod.GET)
	public String list(Model model) {
		logger.info("list");
		
		model.addAttribute("list", service.list());
		
		return "board/list";
	}
}
