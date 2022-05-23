package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.model.dto.BoardDto;
import com.ssafy.happyhouse.model.mapper.BoardMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
    private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);

    @Autowired
    private BoardMapper boardMapper;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public int insertBoard(String userId, BoardDto boardDto) {
        boardDto.setWriter(userId);
        boardDto.setHit(0);
        boardDto.setRegDate(simpleDateFormat.format(new Date()));
        return boardMapper.insert(boardDto);
    }

    // updateBoard
    @Override
    public int updateBoard(Long boardId, BoardDto boardDto) {
        BoardDto updateDto = boardMapper.getBoardById(boardId);
        updateDto.setContents(boardDto.getContents());
        updateDto.setTitle(boardDto.getTitle());

        log.debug("{}", updateDto);

        return boardMapper.update(updateDto);

    }

    @Override
    public int deleteBoardById(Long boardId) {
        return boardMapper.delete(boardId);
    }

    @Override
    public List<BoardDto> getBoards() {
        return boardMapper.getList();
    }

    @Override
    public BoardDto getBoardById(Long boardId) {
        return boardMapper.getBoardById(boardId);
    }

    @Override
    public List<BoardDto> getBoardsByWriter(String writer) {
        return boardMapper.getBoardsByWriter(writer);
    }

    @Override
    public List<BoardDto> getBoardsByContents(String contents) {
        return boardMapper.getBoardsByContents(contents);
    }

    @Override
    public List<BoardDto> getBoardsByTitle(String title) {
        return boardMapper.getBoardsByTitle(title);
    }
}
