package com.cya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cya.entity.PageResult;
import com.cya.entity.PunchClockRecord;
import com.cya.entity.Record;
import com.cya.entity.Student;
import com.cya.mapper.IStudentMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class IStudentServiceImpl implements com.cya.service.IStudentService {

	@Autowired
	private IStudentMapper studentMapperImpl;
	
	@Override
	public Student student_getMyMsgById(Integer studentId) {
		// TODO Auto-generated method stub
		return studentMapperImpl.student_getMyMsgById(studentId);
	}

	@Override
	public void student_updateMyMsgById(Student student) {
		// TODO Auto-generated method stub
		studentMapperImpl.student_updateMyMsgById(student);
	}

	@Override
	public void student_updatePsd(Student student) {
		// TODO Auto-generated method stub
		studentMapperImpl.student_updatePsd(student);
	}

	@Override
	public PageResult getRecordMMsgByStuNum(Integer pageNum, Integer pageSize, String filter, String key,
			String studentNumber) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<Record>studentsManageList= studentMapperImpl.getRecordMsgByStuNum(filter, key, studentNumber);
		Page<Record> page=(Page<Record>) studentsManageList;
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public PageResult getPunchClockRecordMsgByStuNum(Integer pageNum, Integer pageSize, String filter, String key,
			String studentNumber) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<PunchClockRecord>punchClockRecordManageList= studentMapperImpl.getPunchClockRecordMsgByStuNum(filter, key, studentNumber);
		Page<PunchClockRecord> page=(Page<PunchClockRecord>) punchClockRecordManageList;
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public PunchClockRecord getPunckColcokRecordById(Integer id) {
		// TODO Auto-generated method stub
		return studentMapperImpl.getPunckColcokRecordById(id);
	}

	@Override
	public void updataPunchClockRecordMsg(PunchClockRecord punchClockRecord) {
		// TODO Auto-generated method stub
		studentMapperImpl.updataPunchClockRecordMsg(punchClockRecord);
	}

	

	
}
