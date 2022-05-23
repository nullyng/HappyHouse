package com.ssafy.happyhouse.model.dto;

public class UpdateUserDto {
    private String name;
    private String phone;
    private String pwd;
    private String address;

    public UpdateUserDto(String name, String phone, String pwd, String address) {
        this.name = name;
        this.phone = phone;
        this.pwd = pwd;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
