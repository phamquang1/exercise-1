package com.exercise.dto.request;

public class BuildingReq {
	

	String name;
	String street;
	String district;
	String ward;
	Integer florrArea;
	String type;
	public BuildingReq( ) {
		
	}
	public BuildingReq( String name, String street, String district, String ward, Integer florrArea,
			String type) {
		this.name = name;
		this.street = street;
		this.district = district;
		this.ward = ward;
		this.florrArea = florrArea;
		this.type = type;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public Integer getFlorrArea() {
		return florrArea;
	}

	public void setFlorrArea(Integer florrArea) {
		this.florrArea = florrArea;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
