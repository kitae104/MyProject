package kr.inhatc.spring.board.service;

import java.util.List;

import kr.inhatc.spring.board.dto.BoardDto;

public interface BoardService {

	List<BoardDto> boradList();

	void boardInsert(BoardDto board);

	BoardDto boardDetail(int boardIdx);

}