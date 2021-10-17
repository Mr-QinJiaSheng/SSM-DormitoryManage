package com.cya.entity;

import java.sql.Date;

public class Record {
	private int recordId;
	private String studentNumber;
	private String studentName;
	private int dormBuildId;
	private String dormName;
	private Date date;
	private String detail;
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getDormBuildId() {
		return dormBuildId;
	}
	public void setDormBuildId(int dormBuildId) {
		this.dormBuildId = dormBuildId;
	}
	public String getDormName() {
		return dormName;
	}
	public void setDormName(String dormName) {
		this.dormName = dormName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "Record [recordId=" + recordId + ", studentNumber=" + studentNumber + ", studentName=" + studentName
				+ ", dormBuildId=" + dormBuildId + ", dormName=" + dormName + ", date=" + date + ", detail=" + detail
				+ "]";
	}
	
	
	
}
