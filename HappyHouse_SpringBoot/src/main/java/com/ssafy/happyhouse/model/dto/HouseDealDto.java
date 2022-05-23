package com.ssafy.happyhouse.model.dto;

public class HouseDealDto {
	private Long aptCode;
	private String dealAmount;
	private double area;
	
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public Long getAptCode() {
		return aptCode;
	}
	public void setAptCode(Long aptCode) {
		this.aptCode = aptCode;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	@Override
	public String toString() {
		return "dealAmount=" + dealAmount + ", area=" + area;
	}
}
