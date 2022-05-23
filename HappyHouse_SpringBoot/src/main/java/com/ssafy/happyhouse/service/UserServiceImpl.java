package com.ssafy.happyhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.UserDto;
import com.ssafy.happyhouse.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
   private UserMapper userMapper; // 싱글톤
   
   //로그인
   @Override
   public UserDto LoginUserDto(String userId, String userPwd) {
      return userMapper.LoginUserDto(userId, userPwd);
   }
   
   //비밀번호 찾기
   @Override
   public String findPwd(String userName, String userId, String userPhone) {
      return userMapper.findPwd(userName, userId, userPhone);
   }
   
   //회원정보 가입
   @Override
   public int registerInfo(UserDto userDto) {
      return userMapper.registerInfo(userDto);
   }
   
   //회원정보 수정
   @Override
   public int updateInfo(UserDto userDto) {
      return userMapper.updateInfo(userDto);
   }

   //회원정보 조회
   @Override
   public UserDto searchById(String userId) {
      return userMapper.searchById(userId);
   }

	@Override
	public int deleteById(String userId) {
		return userMapper.deleteById(userId);
	}
   
}