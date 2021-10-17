package com.cya.entity;

public class Dorm {
	private int dormId;
	private int dormBuildId;
	private int dormNumber;
	private String dormName;
	private String dormType;
	private String dormTel;
	public int getDormId() {
		return dormId;
	}
	public void setDormId(int dormId) {
		this.dormId = dormId;
	}
	public int getDormBuildId() {
		return dormBuildId;
	}
	public void setDormBuildId(int dormBuildId) {
		this.dormBuildId = dormBuildId;
	}
	public int getDormNumber() {
		return dormNumber;
	}
	public void setDormNumber(int dormNumber) {
		this.dormNumber = dormNumber;
	}
	public String getDormName() {
		return dormName;
	}
	public void setDormName(String dormName) {
		this.dormName = dormName;
	}
	public String getDormType() {
		return dormType;
	}
	public void setDormType(String dormType) {
		this.dormType = dormType;
	}
	public String getDormTel() {
		return dormTel;
	}
	public void setDormTel(String dormTel) {
		this.dormTel = dormTel;
	}
	@Override
	public String toString() {
		return "Dorm [dormId=" + dormId + ", dormBuildId=" + dormBuildId + ", dormNumber=" + dormNumber + ", dormName="
				+ dormName + ", dormType=" + dormType + ", dormTel=" + dormTel + "]";
	}
	
	
}
