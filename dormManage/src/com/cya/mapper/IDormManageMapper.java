package com.cya.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cya.entity.Admin;
import com.cya.entity.DormManage;
import com.cya.entity.Notice;
import com.cya.entity.PunchClockRecord;
import com.cya.entity.Record;
import com.cya.entity.Student;

public interface IDormManageMapper {

	public List<Student>getStudentMsgByBuildId(@Param("filter")String filter,@Param("key")String key,@Param("dormBuildId") Integer dormBuildId);
	
	public void studentMsgDeleteById(@Param("studentId") int studentId);
	
	public List<Record>getRecordMsg(@Param("filter")String filter,@Param("key")String key,@Param("dormBuildId") Integer dormBuildId);
	
	public Record getRecordById(@Param("recordId") int recordId);
	
	public void updataRecordMsg(Record record);
	
	public void addRecordMsg(Record record);
	
	public void recordManagerDeleteById1(@Param("recordId") Integer recordId);

    
    public DormManage dorm_getMyMsgById(@Param("dormManId") Integer dormManId);
	
	public void dorm_updateMyMsgById(DormManage dormManage);
	
	public void dorm_updatePsd(DormManage dormManage);
	
	
	public List<Notice> getNoticeAll();
	
	
	public List<PunchClockRecord>getPunchClockRecordMsgByDormBuildId(@Param("filter")String filter,@Param("key")String key,@Param("dormBuildId") Integer dormBuildId);
	
	

}
