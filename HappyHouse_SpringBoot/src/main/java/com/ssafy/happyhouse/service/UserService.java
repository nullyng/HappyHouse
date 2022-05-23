package com.ssafy.happyhouse.service;

import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.model.dto.UserDto;

public interface UserService {
	UserDto LoginUserDto(@Param("userId") String userId, @Param("userPwd") String userPwd);
	String findPwd(@Param("userName") String userName, @Param("userId") String userId, @Param("userPhone") String userPhone);
	int registerInfo(UserDto userDto);
	int updateInfo(UserDto userDto);
	UserDto searchById(String userId);
	int deleteById(String userId);
}