package com.ssafy.happyhouse.model.dto;

public class UserDto {
	private String userId;
	private String userName;
	private String userPwd;
	private String userAddress;
	private String userPhone;

	public UserDto() {
		super();
	}

	public UserDto(String userId, String userName, String userPwd, String userAdress, String userPhone) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userAddress = userAdress;
		this.userPhone = userPhone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}


	@Override
	public String toString() {
		return "UserDto{" +
				"userId='" + userId + '\'' +
				", userName='" + userName + '\'' +
				", userPwd='" + userPwd + '\'' +
				", userAddress='" + userAddress + '\'' +
				", userPhone='" + userPhone + '\'' +
				'}';
	}
}
