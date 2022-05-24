package com.ssafy.happyhouse.model.dto;

public class CommentDto {
    private Long id;
    private Long boardId;
    private String writer;
    private String regDate;
    private String contents;

    public CommentDto(Long id, String writer, Long boardId, String regDate, String contents) {
        this.id = id;
        this.boardId = boardId;
        this.writer = writer;
        this.regDate = regDate;
        this.contents = contents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "id=" + id +
                ", boardId=" + boardId +
                ", writer='" + writer + '\'' +
                ", regDate='" + regDate + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
