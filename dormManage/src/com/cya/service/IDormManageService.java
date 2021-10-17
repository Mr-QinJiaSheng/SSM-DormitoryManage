package com.cya.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cya.entity.Admin;
import com.cya.entity.DormManage;
import com.cya.entity.Notice;
import com.cya.entity.PageResult;
import com.cya.entity.Record;
import com.cya.entity.Student;

public interface IDormManageService {

	public PageResult getStudentMsgByBuildId(int pageNum, int pageSize,String filter,String key,Integer dormBuildId);
	
	public void studentMsgDeleteById(int studentId);

	public PageResult getRecordMsg(int pageNum, int pageSize,String filter,String key,Integer dormBuildId);
	
	public Record getRecordById(int recordId);
	
	public void updataRecordMsg(Record record);
	
	public void addRecordMsg(Record record);
	
	public void recordManagerDeleteById1(Integer recordId);
	
/*-------------------------我的---------------------------*/
	
	public DormManage dorm_getMyMsgById(Integer dormManId);
	
	public void dorm_updateMyMsgById(DormManage dormManage);
	
	public void dorm_updatePsd(DormManage dormManage);
	
	/*-------------------------我的---------------------------*/
	
	public List<Notice> getNoticeAll();
	
	/*-------------------------打卡---------------------------*/
	
	public PageResult getPunchClockRecordMsgByDormBuildId(int pageNum, int pageSize,String filter,String key,Integer dormBuildId);
	
	/*-------------------------打卡---------------------------*/
}
