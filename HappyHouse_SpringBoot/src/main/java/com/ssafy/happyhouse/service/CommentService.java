package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.model.dto.CommentDto;

import java.util.List;

public interface CommentService {
    int insertComment(String userId, Long boardId, CommentDto commentDto);
    int deleteComment(Long commentId);
    List<CommentDto> getCommentsByBoardId(Long boardId);
    int updateComment(Long commentId, CommentDto commentDto);
}