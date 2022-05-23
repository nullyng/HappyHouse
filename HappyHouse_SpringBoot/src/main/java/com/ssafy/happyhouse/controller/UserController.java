package com.ssafy.happyhouse.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.happyhouse.model.dto.UpdateUserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.happyhouse.model.dto.UserDto;
import com.ssafy.happyhouse.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8081", allowCredentials = "true")
public class UserController{

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public ResponseEntity<?> getUser(HttpSession session){
		UserDto user = (UserDto) session.getAttribute("user");
		if(user == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping("/regist")
	public ResponseEntity<?> regist(@RequestBody UserDto userDto, HttpSession session) throws Exception {
		int success = userService.registerInfo(userDto);
		return success > 0 ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/login")
	public ResponseEntity<?> login(@RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpSession session, HttpServletResponse response){
		UserDto user = userService.LoginUserDto(id, pwd);
		if(user != null){
			session.setAttribute("user", user);
			return new ResponseEntity<>(session.getId(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session){
		session.invalidate();
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/")
	public ResponseEntity<?> delete(HttpSession session){
		UserDto deleteUser = (UserDto) session.getAttribute("user");
		if(deleteUser == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		userService.deleteById(deleteUser.getUserId());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<?> update(@RequestBody UpdateUserDto updateUserDto, HttpSession session){
		UserDto updateUser = (UserDto) session.getAttribute("user");
		updateUser.setUserAddress(updateUserDto.getAddress());
		updateUser.setUserName(updateUserDto.getName());
		updateUser.setUserPhone(updateUserDto.getPhone());
		updateUser.setUserPwd(updateUserDto.getPwd());
		log.debug("update User : {}", updateUser);
		userService.updateInfo(updateUser);
		session.removeAttribute("user");
		session.setAttribute("user", updateUser);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/findpassword")
	public ResponseEntity<?> findPassword(String name, String id, String phone){
		log.debug("name : {}",name);
		String findPwd = userService.findPwd(name, id, phone);
		if(findPwd == null){
			return new ResponseEntity<>("입력하신 회원 정보와 일치하는 정보가 없습니다.",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(findPwd, HttpStatus.OK);
	}
}