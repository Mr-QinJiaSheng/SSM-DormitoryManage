package com.cya.entity;
/**
 * 打卡记录表
 * @author 蜡笔小新
 *
 */

import java.sql.Date;

public class PunchClockRecord {
	
	private int id;  //记录Id
	private String punchClockId; //打卡Id;
	private Date punchClockDate;  //打卡时间
	private String punchClockTheme;  //打卡主题
	private String punchClockDetail; //打卡说明
	private String punchClockPerson;  //打卡发起人
	private String name;
	private String dormName;
	private String tel;
	private String stuNum; //学生学号
	private int dormBuildId;  ///学生寝室号
	private boolean isRecord;  //是否已经打卡
	private String punckClockContent;  //打卡内容
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPunchClockId() {
		return punchClockId;
	}
	public void setPunchClockId(String punchClockId) {
		this.punchClockId = punchClockId;
	}
	public Date getPunchClockDate() {
		return punchClockDate;
	}
	public void setPunchClockDate(Date punchClockDate) {
		this.punchClockDate = punchClockDate;
	}
	public String getPunchClockTheme() {
		return punchClockTheme;
	}
	public void setPunchClockTheme(String punchClockTheme) {
		this.punchClockTheme = punchClockTheme;
	}
	public String getPunchClockDetail() {
		return punchClockDetail;
	}
	public void setPunchClockDetail(String punchClockDetail) {
		this.punchClockDetail = punchClockDetail;
	}
	public String getPunchClockPerson() {
		return punchClockPerson;
	}
	public void setPunchClockPerson(String punchClockPerson) {
		this.punchClockPerson = punchClockPerson;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDormName() {
		return dormName;
	}
	public void setDormName(String dormName) {
		this.dormName = dormName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public int getDormBuildId() {
		return dormBuildId;
	}
	public void setDormBuildId(int dormBuildId) {
		this.dormBuildId = dormBuildId;
	}
	public boolean isRecord() {
		return isRecord;
	}
	public void setRecord(boolean isRecord) {
		this.isRecord = isRecord;
	}
	public String getPunckClockContent() {
		return punckClockContent;
	}
	public void setPunckClockContent(String punckClockContent) {
		this.punckClockContent = punckClockContent;
	}
	@Override
	public String toString() {
		return "PunchClockRecord [id=" + id + ", punchClockId=" + punchClockId + ", punchClockDate=" + punchClockDate
				+ ", punchClockTheme=" + punchClockTheme + ", punchClockDetail=" + punchClockDetail
				+ ", punchClockPerson=" + punchClockPerson + ", name=" + name + ", dormName=" + dormName + ", tel="
				+ tel + ", stuNum=" + stuNum + ", dormBuildId=" + dormBuildId + ", isRecord=" + isRecord
				+ ", punckClockContent=" + punckClockContent + "]";
	}
	
	
	
	
}
