package com.cya.entity;

import java.sql.Date;

public class Notice {
	
	private int noticeId;
	private Date date;
	private String noticePerson;
	private String content;
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNoticePerson() {
		return noticePerson;
	}
	public void setNoticePerson(String noticePerson) {
		this.noticePerson = noticePerson;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", date=" + date + ", noticePerson=" + noticePerson + ", content="
				+ content + "]";
	}
	
	
}
