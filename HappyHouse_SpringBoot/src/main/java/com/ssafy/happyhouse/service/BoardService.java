package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.model.dto.BoardDto;

import java.util.List;

public interface BoardService {
    int insertBoard(String userId, BoardDto boardDto);
    int updateBoard(Long boardId, BoardDto boardDto);
    int deleteBoardById(Long boardId);
    List<BoardDto> getBoards();
    BoardDto getBoardById(Long boardId);
    List<BoardDto> getBoardsByWriter(String writer);
    List<BoardDto> getBoardsByContents(String contents);
    List<BoardDto> getBoardsByTitle(String title);
}
