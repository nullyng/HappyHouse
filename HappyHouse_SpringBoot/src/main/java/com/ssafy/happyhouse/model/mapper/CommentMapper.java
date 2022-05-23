package com.ssafy.happyhouse.model.mapper;

import com.ssafy.happyhouse.model.dto.CommentDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Insert("INSERT INTO comment (writer, boardId, regdate, contents) VALUES (#{writer}, #{boardId}, #{regDate}, #{contents})")
    int insert(CommentDto commentDto);

    @Select("SELECT `id`, `boardId`, `writer`, `regdate`, `contents` FROM comment WHERE boardId = #{boardId}")
    List<CommentDto> getCommentsByBoardId(@Param("boardId") Long boardId);

    @Delete("DELETE FROM comment WHERE id = #{commentId}")
    int deleteById(@Param("commentId") Long commentId);

    @Select("SELECT * FROM comment WHERE id = #{commentId}")
    CommentDto getCommentById(@Param("commentId") Long commentId);

    @Update("UPDATE FROM comment SET contents = #{contents} WHERE id = #{commentId}")
    int updateById(@Param("commentId") Long commentId, CommentDto commentDto);
}
