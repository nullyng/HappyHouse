package com.ssafy.happyhouse.model.mapper;

import com.ssafy.happyhouse.model.dto.BoardDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Insert("INSERT board (writer, regdate, contents, title, hit) VALUES (#{writer}, #{regDate}, #{contents}, #{title}, #{hit})")
    int insert(BoardDto boardDto);

    @Update("UPDATE board SET title=#{title}, contents=#{contents} WHERE id = #{id}")
    int update(BoardDto boardDto);

    @Select("SELECT * FROM board")
    List<BoardDto> getList();

    @Select("SELECT * FROM board WHERE id = #{boardId}")
    BoardDto getBoardById(@Param("boardId") Long boardId);

    @Select("SELECT * FROM board WHERE writer = #{writer}")
    List<BoardDto> getBoardsByWriter(@Param("writer") String writer);

    @Select("SELECT * FROM board WHERE contents LIKE concat('%', #{contents}, '%')")
    List<BoardDto> getBoardsByContents(@Param("contents") String contents);

    @Select("SELECT * FROM board WHERE title LIKE concat('%', #{title}, '%')")
    List<BoardDto> getBoardsByTitle(@Param("title") String title);

    @Delete("DELETE FROM board WHERE id = #{boardId}")
    int delete(@Param("boardId") Long boardId);
}
