package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.mapper.HouseInfoMapper;
import com.ssafy.happyhouse.model.dto.HouseInfoDto;

@Service
public class HouseInfoServiceImpl implements HouseInfoService{
	@Autowired
	private HouseInfoMapper houseInfoMapper;
	
	//repo

	@Override
	public List<HouseInfoDto> searchByAptNameAndDongName(String aptName, String dongName) {
		return houseInfoMapper.searchByAptNameAndDongName(aptName, dongName);
	}
}
