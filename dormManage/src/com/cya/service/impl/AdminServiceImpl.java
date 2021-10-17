package com.cya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cya.entity.Admin;
import com.cya.entity.DormBuild;
import com.cya.entity.DormManage;
import com.cya.entity.Notice;
import com.cya.entity.PageResult;
import com.cya.entity.PunchClock;
import com.cya.entity.PunchClockRecord;
import com.cya.entity.Record;
import com.cya.entity.Student;
import com.cya.mapper.IAdminMapper;
import com.cya.service.IAdminService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	private IAdminMapper adminMapperImpl;
	
	/*-------------------------宿管---------------------------*/

	@Override
	public PageResult getDormManage(int pageNum, int pageSize,String filter,String key) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<DormManage>dormManageList= adminMapperImpl.getDormManage(filter,key);
		Page<DormManage> page=(Page<DormManage>) dormManageList;
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public void addDormManage(DormManage dormManage) {
		// TODO Auto-generated method stub
		adminMapperImpl.addDormManage(dormManage);
	}

	@Override
	public DormManage getDormMangerById(int dormManId) {
		// TODO Auto-generated method stub
		return adminMapperImpl.getDormMangerById(dormManId);
	}

	@Override
	public void updataDormManageById(DormManage dormManage) {
		// TODO Auto-generated method stub
		adminMapperImpl.updataDormManageById(dormManage);
	}

	@Override
	public void deleteDormManageById(Integer dormManId) {
		// TODO Auto-generated method stub
		adminMapperImpl.deleteDormManageById(dormManId);
	}
	
	/*-------------------------宿管---------------------------*/

	
	/*-------------------------学生---------------------------*/
	
	//获取学生信息
	@Override
	public PageResult getStudentManage(int pageNum, int pageSize, String filter, String key) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<Student>studentManageList= adminMapperImpl.getStudentManage(filter, key);
		Page<Student> page=(Page<Student>) studentManageList;
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public void addStudentManage(Student student) {
		// TODO Auto-generated method stub
		adminMapperImpl.addStudentManage(student);
	}
	
	@Override
	public Student getStudentMangerById(int studentId) {
		// TODO Auto-generated method stub
		return adminMapperImpl.getStudentMangerById(studentId);
	}

	@Override
	public void updataStudentManageById(Student student) {
		// TODO Auto-generated method stub
		adminMapperImpl.updataStudentManageById(student);
	}

	@Override
	public void studentManagerDeleteById(int studentId) {
		// TODO Auto-generated method stub
		adminMapperImpl.studentManagerDeleteById(studentId);
	}
	
	/*-------------------------学生---------------------------*/
	
	
	/*-------------------------宿舍楼---------------------------*/

	@Override
	public PageResult getBuildManage(int pageNum, int pageSize, String filter, String key) {
		// TODO Auto-generated method stub
		
		PageHelper.startPage(pageNum, pageSize);
		List<DormBuild>buildList= adminMapperImpl.getBuildManage(filter, key);
		Page<DormBuild> page=(Page<DormBuild>) buildList;
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public void addBuildManage(DormBuild dormBuild) {
		// TODO Auto-generated method stub
		adminMapperImpl.addBuildManage(dormBuild);
	}

	@Override
	public DormBuild getBuildMangerById(int dormBuildId) {
		// TODO Auto-generated method stub
		return adminMapperImpl.getBuildMangerById(dormBuildId);
	}

	@Override
	public void updataBuildManageById(DormBuild dormBuild) {
		// TODO Auto-generated method stub
		adminMapperImpl.updataBuildManageById(dormBuild);
	}

	@Override
	public void buildManagerDeleteById(Integer dormBuildId) {
		// TODO Auto-generated method stub
		adminMapperImpl.buildManagerDeleteById(dormBuildId);
	}

	@Override
	public List<DormManage> getDormMangerByBuildId(Integer dormBuildId) {
		// TODO Auto-generated method stub
		return adminMapperImpl.getDormMangerByBuildId(dormBuildId);
	}

	@Override
	public List<DormManage> getDormManage2() {
		// TODO Auto-generated method stub
		return adminMapperImpl.getDormManage2();
	}

	@Override
	public void addDormManageToBuild(Integer dormBuildId, Integer dormManId) {
		// TODO Auto-generated method stub
		adminMapperImpl.addDormManageToBuild(dormBuildId, dormManId);
	}

	@Override
	public void removeaDormManageToBuild(Integer dormManId) {
		// TODO Auto-generated method stub
		adminMapperImpl.removeaDormManageToBuild(dormManId);
	}

	/*-------------------------宿舍楼---------------------------*/
	
	
	/*-------------------------考勤---------------------------*/
	
	@Override
	public PageResult getRecordManage(int pageNum, int pageSize, String filter, String key) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<Record>recordManageList= adminMapperImpl.getRecordManage(filter, key);
		Page<Record> page=(Page<Record>) recordManageList;
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public void recordManagerDeleteById(Integer recordId) {
		// TODO Auto-generated method stub
		adminMapperImpl.recordManagerDeleteById(recordId);
	}

	
	/*-------------------------考勤---------------------------*/
	
	
	
	/*-------------------------公告---------------------------*/
	
	@Override
	public PageResult getNoticeManage(Integer pageNum,Integer pageSize,String filter, String key) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<Notice>noticeManageList= adminMapperImpl.getNoticeManage(filter, key);
		Page<Notice> page=(Page<Notice>) noticeManageList;
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public void addNoticeManage(Notice notice) {
		// TODO Auto-generated method stub
		adminMapperImpl.addNoticeManage(notice);
	}

	@Override
	public Notice getNoticeMangerById(Integer noticeId) {
		// TODO Auto-generated method stub
		return adminMapperImpl.getNoticeMangerById(noticeId);
	}

	@Override
	public void updataNoticeManageById(Notice notice) {
		// TODO Auto-generated method stub
		adminMapperImpl.updataNoticeManageById(notice);
	}

	@Override
	public void noticeManagerDeleteById(Integer noticeId) {
		// TODO Auto-generated method stub
		adminMapperImpl.noticeManagerDeleteById(noticeId);
	}

	
	
	/*-------------------------公告---------------------------*/
	
	
	/*-------------------------我的---------------------------*/
	
	@Override
	public Admin getMyMsgById(Integer adminId) {
		// TODO Auto-generated method stub
		return adminMapperImpl.getMyMsgById(adminId);
	}

	@Override
	public void updateMyMsgById(Admin admin) {
		// TODO Auto-generated method stub
		adminMapperImpl.updateMyMsgById(admin);
	}

	@Override
	public void updatePsd(Admin admin) {
		// TODO Auto-generated method stub
		adminMapperImpl.updatePsd(admin);
	}

	
	
	/*-------------------------我的---------------------------*/
	
	
	/*-------------------------打卡---------------------------*/
	
	@Override
	public PageResult getPunchClockManage(int pageNum, int pageSize, String filter, String key) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<PunchClock>punchClockManageList= adminMapperImpl.getPunchClockManage(filter, key);
		Page<PunchClock> page=(Page<PunchClock>) punchClockManageList;
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public void addPunchClockManageMsg(PunchClock punchClock) {
		// TODO Auto-generated method stub
	 	adminMapperImpl.addPunchClockManageMsg(punchClock);
	}

	@Override
	public PunchClock getPunchClockMangerById(String id) {
		// TODO Auto-generated method stub
		return adminMapperImpl.getPunchClockMangerById(id);
	}

	@Override
	public void updataPunchClockManageMsgById(PunchClock punchClock) {
		// TODO Auto-generated method stub
		adminMapperImpl.updataPunchClockManageMsgById(punchClock);
	}

	@Override
	public void punchClockManagerDeleteById(String id) {
		// TODO Auto-generated method stub
		adminMapperImpl.punchClockManagerDeleteById(id);
	}

	@Override
	public List<Student> getStudentMsg() {
		// TODO Auto-generated method stub
		return adminMapperImpl.getStudentMsg();
	}

	@Override
	public void insertIntoPunchClockRecord(PunchClockRecord punchClockRecord) {
		// TODO Auto-generated method stub
		adminMapperImpl.insertIntoPunchClockRecord(punchClockRecord);
	}

	@Override
	public void updateIntoPunchClockRecordById(PunchClock punchClock) {
		// TODO Auto-generated method stub
		adminMapperImpl.updateIntoPunchClockRecordById(punchClock);
	}

	@Override
	public void deletePunchClockRecordById(String id) {
		// TODO Auto-generated method stub
		adminMapperImpl.deletePunchClockRecordById(id);
	}
	
	/*-------------------------打卡---------------------------*/

}
