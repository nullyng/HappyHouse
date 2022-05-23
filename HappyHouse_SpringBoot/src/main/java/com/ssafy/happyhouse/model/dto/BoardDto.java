package com.ssafy.happyhouse.model.dto;

public class BoardDto {
    private Long id;
    private String writer;
    private String regDate;
    private String contents;
    private String title;
    private int hit;

    public BoardDto(Long id, String writer, String regDate, String contents, String title, int hit) {
        this.id = id;
        this.writer = writer;
        this.regDate = regDate;
        this.contents = contents;
        this.title = title;
        this.hit = hit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "id=" + id +
                ", writer='" + writer + '\'' +
                ", regDate='" + regDate + '\'' +
                ", contents='" + contents + '\'' +
                ", title='" + title + '\'' +
                ", hit=" + hit +
                '}';
    }
}