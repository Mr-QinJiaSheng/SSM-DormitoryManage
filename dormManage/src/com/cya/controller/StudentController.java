package com.cya.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cya.entity.PageResult;
import com.cya.entity.PunchClockRecord;
import com.cya.entity.Result;
import com.cya.entity.Student;
import com.cya.service.IStudentService;

@Controller
@ResponseBody
public class StudentController {
	
	@Autowired
	private IStudentService studentSeriveImpl;
	
	
	
	/*-------------------------考勤---------------------------*/
	
	@RequestMapping("/getRecordMMsgByStuNum")
	public PageResult getRecordMMsgByStuNum(HttpServletRequest request){
		Integer pageNum=1;
		Integer pageSize=20;
		Integer dormBuildId=0;
		String filter=request.getParameter("filter");
		String key=request.getParameter("key");
		String studentNumber=request.getParameter("studentNumber");
		if(request.getParameter("pageNum")!=null && request.getParameter("pageNum")!="") {
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
		}
		if(request.getParameter("pageSize")!=null && request.getParameter("pageSize")!="") {
			pageSize=Integer.parseInt(request.getParameter("pageSize"));
		}
		System.out.println("filter"+filter);
		System.out.println("key"+key);
		
		return studentSeriveImpl.getRecordMMsgByStuNum(pageNum, pageSize, filter, key, studentNumber);
	}
	
	/*-------------------------考勤---------------------------*/
	
	
	
/*-------------------------我的---------------------------*/
	
	@RequestMapping("student_getMyMsgById")
	public Student student_getMyMsgById(@RequestBody Student student) {
		return studentSeriveImpl.student_getMyMsgById(student.getStudentId());
	}
	
	@RequestMapping("student_updateMyMsgById")
	public Result student_updateMyMsgById(HttpServletRequest request ,@RequestBody Student student) {
		try {
			HttpSession session=request.getSession();
			if(session.getAttribute("student") !=null) {
				session.removeAttribute("student");
			}
			List list=new ArrayList();
			list.add(student);
			session.setAttribute("student", list);
			studentSeriveImpl.student_updateMyMsgById(student);
			return new Result(true, "更新成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "更新失败");
		}
	}
	
	@RequestMapping("student_updatePsd")
	public Result student_updatePsd(@RequestBody Student student) {
		try {
			studentSeriveImpl.student_updatePsd(student);
			System.out.println(student);
			return new Result(true, "更新成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "更新失败");
		}
	} 
	
	
	/*-------------------------我的---------------------------*/
	
	
	/*-------------------------打开---------------------------*/
	
	
	
	
	/*-------------------------打开---------------------------*/
	
	@RequestMapping("/getPunchClockRecordMsgByStuNum")
	public PageResult getPunchClockRecordMsgByStuNum(HttpServletRequest request){
		Integer pageNum=1;
		Integer pageSize=20;
		Integer dormBuildId=0;
		String filter=request.getParameter("filter");
		String key=request.getParameter("key");
		String studentNumber=request.getParameter("studentNumber");
		if(request.getParameter("pageNum")!=null && request.getParameter("pageNum")!="") {
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
		}
		if(request.getParameter("pageSize")!=null && request.getParameter("pageSize")!="") {
			pageSize=Integer.parseInt(request.getParameter("pageSize"));
		}
		System.out.println("filter"+filter);
		System.out.println("key"+key);
		
		return studentSeriveImpl.getPunchClockRecordMsgByStuNum(pageNum, pageSize, filter, key, studentNumber);
	}
	
	@RequestMapping("getPunckColcokRecordById")
	public PunchClockRecord getPunckColcokRecordById(HttpServletRequest request) {
		Integer id=0;
		if(request.getParameter("id")!=null && request.getParameter("id")!="") {
			id=Integer.parseInt(request.getParameter("id"));
		}
		return studentSeriveImpl.getPunckColcokRecordById(id);
	}
	
	
	@RequestMapping("updataPunchClockRecordMsg")
	public Result updataPunchClockRecordMsg(@RequestBody PunchClockRecord punchClockRecord) {
		try {
			studentSeriveImpl.updataPunchClockRecordMsg(punchClockRecord);
			System.out.println(punchClockRecord);
			return new Result(true, "更新成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "更新失败");
		}
	} 
	
	
}
