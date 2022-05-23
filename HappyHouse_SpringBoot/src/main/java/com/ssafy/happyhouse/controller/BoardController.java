package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.dto.BoardDto;
import com.ssafy.happyhouse.model.dto.UserDto;
import com.ssafy.happyhouse.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/board")
@CrossOrigin(origins = "http://localhost:8081", allowCredentials = "true")
public class BoardController {

    private static final Logger log = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService boardService;

    @PostMapping("/")
    public ResponseEntity<?> createBoard(@RequestBody BoardDto boardDto, HttpSession session){
        log.debug("sessionID : {}", session.getId());
        String userId = ((UserDto) session.getAttribute("user")).getUserId();
        boardService.insertBoard(userId, boardDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<?> getBoard(@PathVariable("boardId") Long boardId){
        return new ResponseEntity<>(boardService.getBoardById(boardId), HttpStatus.OK);
    }

    @GetMapping("/searchbywriter")
    public ResponseEntity<?> getBoardByWriter(@RequestParam("writer") String writer){
        return new ResponseEntity<>(boardService.getBoardsByWriter(writer), HttpStatus.OK);
    }

    @GetMapping("/searchbycontents")
    public ResponseEntity<?> getBoardByContents(@RequestParam("contents") String contents){
        return new ResponseEntity<>(boardService.getBoardsByContents(contents), HttpStatus.OK);
    }

    @GetMapping("/searchbytitle")
    public ResponseEntity<?> getBoardByTitle(@RequestParam("title") String title){
        return new ResponseEntity<>(boardService.getBoardsByTitle(title), HttpStatus.OK);
    }

    @PutMapping("/{boardId}")
    public ResponseEntity<?> updateBoard(@PathVariable("boardId") Long boardId, @RequestBody BoardDto boardDto) throws Exception{
        return new ResponseEntity<>(boardService.updateBoard(boardId,boardDto), HttpStatus.OK);
    }
    @DeleteMapping("/{boardId}")
    public ResponseEntity<?> deleteBoard(@PathVariable("boardId") Long boardId){
        boardService.deleteBoardById(boardId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getBoardList(){
        return new ResponseEntity<>(boardService.getBoards(), HttpStatus.OK);
    }
}
