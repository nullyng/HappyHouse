package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.UpdateUserDto;
import com.ssafy.happyhouse.model.dto.UserDto;
import com.ssafy.happyhouse.service.JwtServiceImpl;
import com.ssafy.happyhouse.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8081", allowCredentials = "true")
public class UserController{

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtServiceImpl jwtService;

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
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			UserDto user = userService.LoginUserDto(id, pwd);
			if(user != null){
				session.setAttribute("user", user);
				String token = jwtService.create("userid", user.getUserId(), "access-token");
				resultMap.put("access-token", token);
				resultMap.put("message", "success");
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", "fail");
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<>(resultMap, status);
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