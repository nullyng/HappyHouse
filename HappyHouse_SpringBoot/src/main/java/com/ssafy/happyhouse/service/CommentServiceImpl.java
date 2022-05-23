package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.model.dto.CommentDto;
import com.ssafy.happyhouse.model.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentMapper commentMapper;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public int insertComment(String userId, Long boardId, CommentDto commentDto) {
        commentDto.setBoardId(boardId);
        commentDto.setWriter(userId);
        commentDto.setRegDate(simpleDateFormat.format(new Date()));
        return commentMapper.insert(commentDto);
    }

    @Override
    public int deleteComment(Long commentId) {
        return commentMapper.deleteById(commentId);
    }

    @Override
    public List<CommentDto> getCommentsByBoardId(Long boardId) {
        return commentMapper.getCommentsByBoardId(boardId);
    }

    @Override
    public int updateComment(Long commentId, CommentDto commentDto) {
        CommentDto updateDto = commentMapper.getCommentById(commentId);
        updateDto.setContents(commentDto.getContents());
        return commentMapper.updateById(commentId, updateDto);
    }
}
