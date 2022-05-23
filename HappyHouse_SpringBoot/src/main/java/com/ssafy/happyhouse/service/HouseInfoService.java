package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseInfoDto;

public interface HouseInfoService {
	List<HouseInfoDto> searchByAptNameAndDongName(String aptName, String dongName);
}
