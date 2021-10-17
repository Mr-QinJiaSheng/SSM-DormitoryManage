package com.cya.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.IntegerTypeHandler;

import com.cya.entity.Admin;
import com.cya.entity.DormBuild;
import com.cya.entity.DormManage;
import com.cya.entity.Notice;
import com.cya.entity.PunchClock;
import com.cya.entity.PunchClockRecord;
import com.cya.entity.Record;
import com.cya.entity.Student;
import com.sun.org.glassfish.gmbal.ParameterNames;

public interface IAdminMapper {
	
	/*-------------------------宿管---------------------------*/
	
	public List<DormManage>getDormManage(@Param("filter")String filter,@Param("key")String key);
	
	public void addDormManage(DormManage dormManage);
	
	public DormManage getDormMangerById(@Param("dormManId") int dormManId);
	
	public void updataDormManageById(DormManage dormManage);
	
	public void deleteDormManageById(@Param("dormManId") Integer dormManId);
	
	/*-------------------------宿管---------------------------*/
	
	/*-------------------------学生---------------------------*/
	
	public List<Student>getStudentManage(@Param("filter")String filter,@Param("key")String key);
	
	public void addStudentManage(Student student);
	
	public Student getStudentMangerById(@Param("studentId") int studentId);
	
	public void updataStudentManageById(Student student);
	
	public void studentManagerDeleteById(@Param("studentId") int studentId);
	
	/*-------------------------学生---------------------------*/
	
	
	
	/*-------------------------宿舍楼---------------------------*/
	
	public List<DormBuild>getBuildManage(@Param("filter")String filter,@Param("key")String key);
	
	public void addBuildManage(DormBuild dormBuild);
	
	public DormBuild getBuildMangerById(@Param("dormBuildId") int dormBuildId);
	
	public void updataBuildManageById(DormBuild dormBuild);
	
	public void buildManagerDeleteById(@Param("dormBuildId") Integer dormBuildId);
	
	public List<DormManage> getDormMangerByBuildId(@Param("dormBuildId") Integer dormBuildId);
	
	public List<DormManage> getDormManage2();
	
	public void addDormManageToBuild(@Param("dormBuildId")Integer dormBuildId,@Param("dormManId")Integer dormManId);
	
	public void removeaDormManageToBuild(@Param("dormManId")Integer dormManId);
	
	/*-------------------------宿舍楼---------------------------*/
	
	
	/*-------------------------考勤---------------------------*/
	
	public List<Record>getRecordManage(@Param("filter")String filter,@Param("key")String key);
	
	
	public void recordManagerDeleteById(@Param("recordId")Integer recordId);
	/*-------------------------考勤---------------------------*/
	
	
	/*-------------------------公告---------------------------*/
	
	public List<Notice>getNoticeManage(@Param("filter")String filter,@Param("key")String key);
	
	public void addNoticeManage(Notice notice);
	
	public Notice getNoticeMangerById(@Param("noticeId") Integer noticeId);
	
	public void updataNoticeManageById(Notice notice);
	
	public void noticeManagerDeleteById(@Param("noticeId") Integer noticeId);
	
	/*-------------------------公告---------------------------*/
	
	/*-------------------------我的---------------------------*/
	
	public Admin getMyMsgById(@Param("adminId") Integer adminId);
	
	public void updateMyMsgById(Admin admin);
	
	public void updatePsd(Admin admin);
	
	
	
	/*-------------------------我的---------------------------*/
	
	
	/*-------------------------打卡---------------------------*/
	
	public List<PunchClock>getPunchClockManage(@Param("filter")String filter,@Param("key")String key);
	
	public void addPunchClockManageMsg(PunchClock punchClock);
	
	public PunchClock getPunchClockMangerById(@Param("id") String id);
	
	public void updataPunchClockManageMsgById(PunchClock punchClock);
	
	public void punchClockManagerDeleteById(@Param("id") String id);
	
	public List<Student> getStudentMsg();
	
	public void insertIntoPunchClockRecord(PunchClockRecord punchClockRecord);
	
	public void updateIntoPunchClockRecordById(PunchClock punchClock);
	
	public void deletePunchClockRecordById(String id);
	
	/*-------------------------打卡---------------------------*/
	
	
	
	
	
}
