package com.cya.entity;

public class DormBuild {
	private int dormBuildId;
	private String dormBuildName;
	private String dormBuildDetail;
	public int getDormBuildId() {
		return dormBuildId;
	}
	public void setDormBuildId(int dormBuildId) {
		this.dormBuildId = dormBuildId;
	}
	public String getDormBuildName() {
		return dormBuildName;
	}
	public void setDormBuildName(String dormBuildName) {
		this.dormBuildName = dormBuildName;
	}
	public String getDormBuildDetail() {
		return dormBuildDetail;
	}
	public void setDormBuildDetail(String dormBuildDetail) {
		this.dormBuildDetail = dormBuildDetail;
	}
	@Override
	public String toString() {
		return "DormBuild [dormBuildId=" + dormBuildId + ", dormBuildName=" + dormBuildName + ", dormBuildDetail="
				+ dormBuildDetail + "]";
	}
	
	
}
