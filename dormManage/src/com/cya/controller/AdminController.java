package com.cya.controller;
/**
 * 系统管理员
 * @author C you again[公众号]
 *
 */

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cya.entity.Admin;
import com.cya.entity.Dorm;
import com.cya.entity.DormBuild;
import com.cya.entity.DormManage;
import com.cya.entity.Notice;
import com.cya.entity.PageResult;
import com.cya.entity.PunchClock;
import com.cya.entity.PunchClockRecord;
import com.cya.entity.Result;
import com.cya.entity.Student;
import com.cya.service.IAdminService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@ResponseBody
public class AdminController {
	
	@Autowired
	private IAdminService adminServiceImpl;
	
	/*-------------------------宿管---------------------------*/
	
	@RequestMapping("/getDormManage")
	public PageResult getDormManage(HttpServletRequest request){
		Integer pageNum=1;
		Integer pageSize=20;
		String filter=request.getParameter("filter");
		String key=request.getParameter("key");
		if(request.getParameter("pageNum")!=null && request.getParameter("pageNum")!="") {
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
		}
		if(request.getParameter("pageSize")!=null && request.getParameter("pageSize")!="") {
			pageSize=Integer.parseInt(request.getParameter("pageSize"));
		}
		System.out.println("pageNum="+pageNum);
		System.out.println("pageSize="+pageSize);
		return adminServiceImpl.getDormManage(pageNum,pageSize,filter,key);
	}
	
	@RequestMapping("addDormManage")
	public Result addDormManage(@RequestBody DormManage dormManage) {
		try {
			adminServiceImpl.addDormManage(dormManage);
			return new Result(true, "添加成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "添加失败");
		}
	}
	
	@RequestMapping("getDormMangerById")
	public DormManage getDormMangerById(Integer dormManId) {
		return adminServiceImpl.getDormMangerById(dormManId);
	}
	
	@RequestMapping("updataDormManageById")
	public Result updataDormManageById(@RequestBody DormManage dormManage) {
		try {
			adminServiceImpl.updataDormManageById(dormManage);
			return new Result(true, "更新成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "更新失败");
		}
	}
	
	@RequestMapping("dormManagerDeleteById")
	public Result dormManagerDeleteById(HttpServletRequest request) {
		Integer dormManId=0;
		if(request.getParameter("dormManId")!=null && request.getParameter("dormManId")!="") {
			dormManId=Integer.parseInt(request.getParameter("dormManId"));
		}
		try {
			adminServiceImpl.deleteDormManageById(dormManId);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
	/*-------------------------宿管---------------------------*/
	
	/*-------------------------学生---------------------------*/
	@RequestMapping("/getStudentManage")
	public PageResult getStudentManage(HttpServletRequest request){
		Integer pageNum=1;
		Integer pageSize=20;
		String filter=request.getParameter("filter");
		String key=request.getParameter("key");
		if(request.getParameter("pageNum")!=null && request.getParameter("pageNum")!="") {
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
		}
		if(request.getParameter("pageSize")!=null && request.getParameter("pageSize")!="") {
			pageSize=Integer.parseInt(request.getParameter("pageSize"));
		}
		System.out.println("pageNum="+pageNum);
		System.out.println("pageSize="+pageSize);
		return adminServiceImpl.getStudentManage(pageNum, pageSize, filter, key);
	}
	
	@RequestMapping("addStudentManage")
	public Result addStudentManage(@RequestBody Student student) {
		try {
			adminServiceImpl.addStudentManage(student);
			return new Result(true, "添加成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "添加失败");
		}
	}
	
	@RequestMapping("getStudentMangerById")
	public Student getStudentMangerById(Integer studentId) {
		return adminServiceImpl.getStudentMangerById(studentId);
	}
	
	@RequestMapping("updataStudentManageById")
	public Result updataStudentManageById(@RequestBody Student student) {
		try {
			System.out.println(student);
			adminServiceImpl.updataStudentManageById(student);
			return new Result(true, "更新成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "更新失败");
		}
	}
	
	@RequestMapping("studentManagerDeleteById")
	public Result studentManagerDeleteById(HttpServletRequest request) {
		Integer studentId=0;
		if(request.getParameter("studentId")!=null && request.getParameter("studentId")!="") {
			studentId=Integer.parseInt(request.getParameter("studentId"));
		}
		try {
			adminServiceImpl.studentManagerDeleteById(studentId);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
	/*-------------------------学生---------------------------*/
	
	
	/*-------------------------宿舍楼---------------------------*/
	
	@RequestMapping("/getBuildManage")
	public PageResult getBuildManage(HttpServletRequest request){
		Integer pageNum=1;
		Integer pageSize=20;
		String filter=request.getParameter("filter");
		String key=request.getParameter("key");
		if(request.getParameter("pageNum")!=null && request.getParameter("pageNum")!="") {
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
		}
		if(request.getParameter("pageSize")!=null && request.getParameter("pageSize")!="") {
			pageSize=Integer.parseInt(request.getParameter("pageSize"));
		}
		System.out.println("pageNum="+pageNum);
		System.out.println("pageSize="+pageSize);
		return adminServiceImpl.getBuildManage(pageNum,pageSize,filter,key);
	}
	
	@RequestMapping("addBuildManage")
	public Result addBuildManage(@RequestBody DormBuild dormBuild) {
		try {
			adminServiceImpl.addBuildManage(dormBuild);
			return new Result(true, "添加成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "添加失败");
		}
	}
	
	@RequestMapping("getBuildMangerById")
	public DormBuild getBuildMangerById(Integer dormBuildId) {
		return adminServiceImpl.getBuildMangerById(dormBuildId);
	}
	
	@RequestMapping("updataBuildManageById")
	public Result updataBuildManageById(@RequestBody DormBuild dormBuild) {
		try {
			adminServiceImpl.updataBuildManageById(dormBuild);
			return new Result(true, "更新成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "更新失败");
		}
	}
	
	@RequestMapping("buildManagerDeleteById")
	public Result buildManagerDeleteById(HttpServletRequest request) {
		Integer dormBuildId=0;
		if(request.getParameter("dormBuildId")!=null && request.getParameter("dormBuildId")!="") {
			dormBuildId=Integer.parseInt(request.getParameter("dormBuildId"));
		}
		try {
			adminServiceImpl.buildManagerDeleteById(dormBuildId);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
	@RequestMapping("getDormMangerByBuildId")
	public List<DormManage> getDormMangerByBuildId(Integer dormBuildId){
		System.out.println("dormBuildId="+dormBuildId);
		return adminServiceImpl.getDormMangerByBuildId(dormBuildId);
	}
	
	@RequestMapping("getDormManage2")
	public List<DormManage> getDormManage(){
		return adminServiceImpl.getDormManage2();
	}
	
	@RequestMapping("addDormManageToBuild")
	public Result addDormManageToBuild(HttpServletRequest request) {
		Integer dormBuildId=0;
		Integer dormManId=0;
		if(request.getParameter("dormBuildId")!=null && request.getParameter("dormBuildId")!="") {
			dormBuildId=Integer.parseInt(request.getParameter("dormBuildId"));
		}
		if(request.getParameter("dormManId")!=null && request.getParameter("dormManId")!="") {
			dormManId=Integer.parseInt(request.getParameter("dormManId"));
		}
		try {
			adminServiceImpl.addDormManageToBuild(dormBuildId, dormManId);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
		
	}
	
	@RequestMapping("removeaDormManageToBuild")
	public Result removeaDormManageToBuild(HttpServletRequest request) {
		Integer dormManId=0;
		if(request.getParameter("dormManId")!=null && request.getParameter("dormManId")!="") {
			dormManId=Integer.parseInt(request.getParameter("dormManId"));
		}
		try {
			adminServiceImpl.removeaDormManageToBuild(dormManId);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
	
	/*-------------------------宿舍楼---------------------------*/
	
	
	/*-------------------------考勤---------------------------*/
	
	@RequestMapping("/getRecordManage")
	public PageResult getRecordManage(HttpServletRequest request){
		Integer pageNum=1;
		Integer pageSize=20;
		String filter=request.getParameter("filter");
		String key=request.getParameter("key");
		if(request.getParameter("pageNum")!=null && request.getParameter("pageNum")!="") {
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
		}
		if(request.getParameter("pageSize")!=null && request.getParameter("pageSize")!="") {
			pageSize=Integer.parseInt(request.getParameter("pageSize"));
		}
		System.out.println("pageNum="+pageNum);
		System.out.println("pageSize="+pageSize);
		return adminServiceImpl.getRecordManage(pageNum,pageSize,filter,key);
	}
	
	@RequestMapping("recordManagerDeleteById")
	public Result recordManagerDeleteById(HttpServletRequest request) {
		Integer recordId=0;
		if(request.getParameter("recordId")!=null && request.getParameter("recordId")!="") {
			recordId=Integer.parseInt(request.getParameter("recordId"));
		}
		try {
			adminServiceImpl.recordManagerDeleteById(recordId);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
	
	/*-------------------------考勤---------------------------*/

	
	
	/*-------------------------公告---------------------------*/
	
	
	@RequestMapping("/getNoticeManage")
	public PageResult getNoticeManage(HttpServletRequest request){
		Integer pageNum=1;
		Integer pageSize=20;
		String filter=request.getParameter("filter");
		String key=request.getParameter("key");
		if(request.getParameter("pageNum")!=null && request.getParameter("pageNum")!="") {
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
		}
		if(request.getParameter("pageSize")!=null && request.getParameter("pageSize")!="") {
			pageSize=Integer.parseInt(request.getParameter("pageSize"));
		}
		System.out.println("pageNum="+pageNum);
		System.out.println("pageSize="+pageSize);
		return adminServiceImpl.getNoticeManage(pageNum,pageSize,filter,key);
	}
	
	
	@RequestMapping("addNoticeManage")
	public Result addNoticeManage(@RequestBody Notice notice) {
		try {
			adminServiceImpl.addNoticeManage(notice);
			return new Result(true, "添加成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "添加失败");
		}
	}
	
	
	@RequestMapping("getNoticeMangerById")
	public Notice getNoticeMangerById(Integer noticeId) {
		return adminServiceImpl.getNoticeMangerById(noticeId);
	}
	
	@RequestMapping("updataNoticeManageById")
	public Result updataNoticeManageById(@RequestBody Notice notice) {
		try {
			adminServiceImpl.updataNoticeManageById(notice);
			return new Result(true, "更新成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "更新失败");
		}
	}
	
	@RequestMapping("noticeManagerDeleteById")
	public Result noticeManagerDeleteById(HttpServletRequest request) {
		Integer noticeId=0;
		if(request.getParameter("noticeId")!=null && request.getParameter("noticeId")!="") {
			noticeId=Integer.parseInt(request.getParameter("noticeId"));
		}
		try {
			adminServiceImpl.noticeManagerDeleteById(noticeId);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
	/*-------------------------公告---------------------------*/
	
	
	/*-------------------------我的---------------------------*/
	
	@RequestMapping("getMyMsgById")
	public Admin getMyMsgById(@RequestBody Admin admin) {
		return adminServiceImpl.getMyMsgById(admin.getAdminId());
	}
	
	@RequestMapping("updateMyMsgById")
	public Result updateMyMsgById(HttpServletRequest request ,@RequestBody Admin admin) {
		try {
			HttpSession session=request.getSession();
			if(session.getAttribute("admin") !=null) {
				session.removeAttribute("admin");
			}
			List list=new ArrayList();
			list.add(admin);
			session.setAttribute("admin", list);
			adminServiceImpl.updateMyMsgById(admin);
			return new Result(true, "更新成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "更新失败");
		}
	}
	
	@RequestMapping("updatePsd")
	public Result updatePsd(@RequestBody Admin admin) {
		try {
			adminServiceImpl.updatePsd(admin);
			System.out.println(admin);
			return new Result(true, "更新成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "更新失败");
		}
	} 
	
	/*-------------------------我的---------------------------*/
	
	
	/*-------------------------打卡---------------------------*/
	
	@RequestMapping("/getPunchClockManage")
	public PageResult getPunchClockManage(HttpServletRequest request){
		Integer pageNum=1;
		Integer pageSize=20;
		String filter=request.getParameter("filter");
		String key=request.getParameter("key");
		if(request.getParameter("pageNum")!=null && request.getParameter("pageNum")!="") {
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
		}
		if(request.getParameter("pageSize")!=null && request.getParameter("pageSize")!="") {
			pageSize=Integer.parseInt(request.getParameter("pageSize"));
		}

		return adminServiceImpl.getPunchClockManage(pageNum,pageSize,filter,key);
	}
	
	
	@RequestMapping("addPunchClockManageMsg")
	public Result addPunchClockManageMsg(@RequestBody PunchClock punchClock) {
		try {
			String punchClockId= "pcId"+System.currentTimeMillis();
			punchClock.setId(punchClockId);
			adminServiceImpl.addPunchClockManageMsg(punchClock);
			PunchClock punchClock2=adminServiceImpl.getPunchClockMangerById(punchClockId);
			//根据学生学号生成记录表record
			//获取学生学号
			List<Student> list=adminServiceImpl.getStudentMsg();
			for (Student student : list) {
				PunchClockRecord punchClockRecord=new PunchClockRecord();
				punchClockRecord.setPunchClockId(punchClock2.getId());
				punchClockRecord.setPunchClockDate(punchClock2.getDate());
				punchClockRecord.setPunchClockTheme(punchClock2.getTheme());
				punchClockRecord.setPunchClockDetail(punchClock2.getDetail());
				punchClockRecord.setPunchClockPerson(punchClock2.getPerson());
				punchClockRecord.setName(student.getName());
				punchClockRecord.setDormName(student.getDormName());
				punchClockRecord.setTel(student.getTel());
				punchClockRecord.setStuNum(student.getStuNum());
				punchClockRecord.setDormBuildId(student.getDormBuildId());
				punchClockRecord.setRecord(false);
				punchClockRecord.setPunckClockContent("");
				
				adminServiceImpl.insertIntoPunchClockRecord(punchClockRecord);
			}
			
			return new Result(true, "添加成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "添加失败");
		}
	}
	
	@RequestMapping("getPunchClockMangerById")
	public PunchClock getPunchClockMangerById(String id) {
		return adminServiceImpl.getPunchClockMangerById(id);
	}
	
	@RequestMapping("updataPunchClockManageMsgById")
	public Result updataPunchClockManageMsgById(@RequestBody PunchClock punchClock) {
		try {
			adminServiceImpl.updataPunchClockManageMsgById(punchClock);
			//更新记录表
			adminServiceImpl.updateIntoPunchClockRecordById(punchClock);
			return new Result(true, "更新成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "更新失败");
		}
	}
	
	@RequestMapping("punchClockManagerDeleteById")
	public Result punchClockManagerDeleteById(HttpServletRequest request) {
		String id="";
		if(request.getParameter("id")!=null) {
			id=request.getParameter("id");
		}
		try {
			adminServiceImpl.punchClockManagerDeleteById(id);
			
			adminServiceImpl.deletePunchClockRecordById(id);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
	/*-------------------------打卡---------------------------*/
	
	
	
	
	
	
}
