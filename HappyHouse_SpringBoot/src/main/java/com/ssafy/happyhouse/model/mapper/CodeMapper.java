package com.ssafy.happyhouse.model.mapper;

import com.ssafy.happyhouse.model.dto.CodeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CodeMapper {
    @Select("SELECT LEFT(sidoCode, 2) as code, sidoName as name FROM sidocode")
    List<CodeDto> getSidoList();

    @Select("SELECT LEFT(gugunCode, 5) as code, gugunName as name FROM guguncode WHERE gugunCode LIKE concat(#{regcode},'%')")
    List<CodeDto> getGugunList(@Param("regcode") String regcode);

    @Select("SELECT LEFT(dongCode, 8) as code, dongName as name, lat, lng FROM baseaddress WHERE dongCode LIKE concat(#{regcode}, '%')")
    List<CodeDto> getDongList(@Param("regcode") String regcode);
}
