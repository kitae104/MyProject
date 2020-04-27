package kr.inhatc.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.inhatc.spring.board.dto.BoardDto;
import kr.inhatc.spring.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping("/")
	public String hello() {
		return "index"; 
	}
	
	@RequestMapping("/board/boardList")
	public String boardList(Model model) {		
		List<BoardDto> list = boardService.boradList();
		System.out.println("=============> " + list.size());
		model.addAttribute("list", list);
		return "board/boardList";
	}
	
	@RequestMapping("/board/boardWrite")
	public String boardWrite() {		
		return "board/boardWrite";
	}
	
	@RequestMapping("/board/boardInsert")
	public String boardInsert(BoardDto board) {		
		boardService.boardInsert(board);
		return "redirect:/board/boardList";
	}
	
	@RequestMapping("/board/boardDetail")
	public String boardDetail(@RequestParam int boardIdx, Model model) {		
		BoardDto board = boardService.boardDetail(boardIdx);
		model.addAttribute("board", board);
		return "board/boardDetail"; 
	}
}
