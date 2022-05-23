package com.ssafy.happyhouse.model.dto;

public class HouseInfoDto {
	private Long aptCode;
	private String aptName;
	private String dongCode;
	private String dongName;
	private HouseDealDto houseDealDto;
	private double lat;
	private double lng;
	
	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public Long getAptCode() {
		return aptCode;
	}

	public void setAptCode(Long aptCode) {
		this.aptCode = aptCode;
	}

	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	public HouseDealDto getHouseDealDto() {
		return houseDealDto;
	}

	public void setHouseDealDto(HouseDealDto houseDealDto) {
		this.houseDealDto = houseDealDto;
	}

	@Override
	public String toString() {
		return "[aptCode=" + aptCode + ", aptName=" + aptName + ", dongCode=" + dongCode + ", dongName="
				+ dongName + ", " + houseDealDto + "]";
	}
}
