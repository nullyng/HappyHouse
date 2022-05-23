package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ssafy.happyhouse.model.dto.HouseDealDto;
import com.ssafy.happyhouse.model.dto.HouseInfoDto;

@Mapper
public interface HouseInfoMapper {
	
	@Select("SELECT h.aptCode as aptCode, aptName, dongCode, dongName, dealAmount, area, lat, lng from houseinfo h join housedeal hd WHERE aptName LIKE CONCAT('%', #{aptName}, '%') and dongName = #{dongName} group by h.aptCode")
	@Results({
		@Result(property = "aptCode", column = "aptCode"),
		@Result(property = "houseDealDto", column = "aptCode",
				one =  @One(select = "findByAptCode"))
	})
	List<HouseInfoDto> searchByAptNameAndDongName(@Param("aptName") String aptName, @Param("dongName") String dongName);
	
	@Select("SELECT aptCode, dealAmount, area FROM housedeal where aptcode = #{aptCode} LIMIT 1")
	HouseDealDto findByAptCode(String aptCode);
}
