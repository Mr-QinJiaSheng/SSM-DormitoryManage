package com.cya.entity;
/**
 * 打卡
 * @author 公众号【C you again】
 *
 */

import java.sql.Date;

import javax.xml.soap.Detail;

public class PunchClock {
	private String id;  //打卡记录
	private String theme;  //打卡主题
	private String detail; //说明
	private Date date;
	private String person; //发起人
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "PunchClock [id=" + id + ", theme=" + theme + ", detail=" + detail + ", date=" + date + ", person="
				+ person + "]";
	}
	
	
	
	
	
}
