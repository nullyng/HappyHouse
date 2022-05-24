package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.service.HouseInfoService;

@RestController
@CrossOrigin(origins = "http://localhost:8081", allowCredentials = "true")
public class HouseInfoController{
	
	@Autowired
	private HouseInfoService houseInfoService;
	
	@GetMapping("/houseInfo")
	//houseInfo?aptName=asdsd&dongName=aasdasd
	public ResponseEntity<?> searchByAptNameAndDongName(@RequestParam("aptName") String aptName, @RequestParam("dongName") String dongName){
		List<HouseInfoDto> list = houseInfoService.searchByAptNameAndDongName(aptName, dongName);
		for(HouseInfoDto houseInfoDto : list) {
			System.out.println(houseInfoDto);
		}
		return new ResponseEntity<List<HouseInfoDto>>(list, HttpStatus.OK);
	}
	
}