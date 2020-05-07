package kr.inhatc.spring.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.inhatc.spring.board.dto.BoardDto;

public interface BoardService {

	List<BoardDto> boradList();

	void boardInsert(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest);

	BoardDto boardDetail(int boardIdx);

	void boardUpdate(BoardDto board);

	void boardDelete(int boradIdx);

}
