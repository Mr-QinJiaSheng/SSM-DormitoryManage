package com.cya.service;

import org.apache.ibatis.annotations.Param;

import com.cya.entity.PageResult;
import com.cya.entity.PunchClockRecord;
import com.cya.entity.Student;

public interface IStudentService {
	
	public PageResult getRecordMMsgByStuNum(Integer pageNum,Integer pageSize,String filter, String key,String studentNumber);
	
    public Student student_getMyMsgById(Integer studentId);
	
	public void student_updateMyMsgById(Student student);
	
	public void student_updatePsd(Student student);
	
	public PageResult getPunchClockRecordMsgByStuNum(Integer pageNum,Integer pageSize,String filter, String key,String studentNumber);
	
	public PunchClockRecord getPunckColcokRecordById(Integer id);
	
	public void updataPunchClockRecordMsg(PunchClockRecord punchClockRecord);

}
