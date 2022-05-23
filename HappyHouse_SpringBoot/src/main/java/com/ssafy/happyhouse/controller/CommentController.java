package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.dto.CommentDto;
import com.ssafy.happyhouse.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "http://localhost:8081", allowCredentials = "true")
public class CommentController {
    private static final Logger log = LoggerFactory.getLogger(CommentController.class);
    @Autowired
    private CommentService commentService;

    @GetMapping("/{boardId}")
    public ResponseEntity<?> getCommentsByBoardId(@PathVariable("boardId") Long boardId){
        List<CommentDto> list = commentService.getCommentsByBoardId(boardId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/{userId}/{boardId}")
    public ResponseEntity<?> insertComment(@PathVariable("userId") String userId, @PathVariable("boardId") Long boardId, @RequestBody CommentDto commentDto){
        commentService.insertComment(userId, boardId, commentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable("commentId") Long commentId){
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<?> updateComment(@PathVariable("commentId") Long commentId, @RequestBody CommentDto commentDto){
        commentService.updateComment(commentId, commentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
