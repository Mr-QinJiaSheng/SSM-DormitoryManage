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

import com.cya.entity.Admin;
import com.cya.entity.DormManage;
import com.cya.entity.Notice;
import com.cya.entity.PageResult;
import com.cya.entity.Record;
import com.cya.entity.Result;
import com.cya.service.IDormManageService;

@Controller
@ResponseBody
public class DormManageController {
	
	@Autowired
	private IDormManageService dormManageServiceImpl;
	
	/*-------------------------学生---------------------------*/
	@RequestMapping("/getStudentMsgByBuildId")
	public PageResult getStudentMsgByBuildId(HttpServletRequest request){
		Integer pageNum=1;
		Integer pageSize=20;
		Integer dormBuildId=0;
		String filter=request.getParameter("filter");
		String key=request.getParameter("key");
		if(request.getParameter("pageNum")!=null && request.getParameter("pageNum")!="") {
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
		}
		if(request.getParameter("pageSize")!=null && request.getParameter("pageSize")!="") {
			pageSize=Integer.parseInt(request.getParameter("pageSize"));
		}
		if(request.getParameter("dormBuildId")!=null && request.getParameter("dormBuildId")!="") {
			dormBuildId=Integer.parseInt(request.getParameter("dormBuildId"));
		}
		System.out.println("pageNum="+pageNum);
		System.out.println("pageSize="+pageSize);
		return dormManageServiceImpl.getStudentMsgByBuildId(pageNum, pageSize, filter, key, dormBuildId);
	}
	
	@RequestMapping("studentMsgDeleteById")
	public Result studentMsgDeleteById(HttpServletRequest request) {
		Integer studentId=0;
		if(request.getParameter("studentId")!=null && request.getParameter("studentId")!="") {
			studentId=Integer.parseInt(request.getParameter("studentId"));
		}
		try {
			dormManageServiceImpl.studentMsgDeleteById(studentId);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}

	
	@RequestMapping("/getRecordMsg")
	public PageResult getRecordMsg(HttpServletRequest request){
		Integer pageNum=1;
		Integer pageSize=20;
		Integer dormBuildId=0;
		String filter=request.getParameter("filter");
		String key=request.getParameter("key");
		if(request.getParameter("pageNum")!=null && request.getParameter("pageNum")!="") {
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
		}
		if(request.getParameter("pageSize")!=null && request.getParameter("pageSize")!="") {
			pageSize=Integer.parseInt(request.getParameter("pageSize"));
		}
		if(request.getParameter("dormBuildId")!=null && request.getParameter("dormBuildId")!="") {
			dormBuildId=Integer.parseInt(request.getParameter("dormBuildId"));
		}
		System.out.println("pageNum="+pageNum);
		System.out.println("pageSize="+pageSize);
		return dormManageServiceImpl.getRecordMsg(pageNum, pageSize, filter, key, dormBuildId);
	}
	
	@RequestMapping("getRecordById")
	public Record getRecordById(Integer recordId) {
		return dormManageServiceImpl.getRecordById(recordId);
	}
	
	
	@RequestMapping("updataRecordMsg")
	public Result updataRecordMsg(@RequestBody Record record) {
		try {
			dormManageServiceImpl.updataRecordMsg(record);
			return new Result(true, "更新成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "更新失败");
		}
	}
	
	@RequestMapping("addRecordMsg")
	public Result addRecordMsg(@RequestBody Record record) {
		try {
			System.out.println(record);
			dormManageServiceImpl.addRecordMsg(record);
			return new Result(true, "添加成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "添加失败");
		}
	}
	
	@RequestMapping("recordManagerDeleteById1")
	public Result recordManagerDeleteById(HttpServletRequest request) {
		Integer recordId=0;
		if(request.getParameter("recordId")!=null && request.getParameter("recordId")!="") {
			recordId=Integer.parseInt(request.getParameter("recordId"));
		}
		try {
			dormManageServiceImpl.recordManagerDeleteById1(recordId);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
	
/*-------------------------我的---------------------------*/
	
	@RequestMapping("dorm_getMyMsgById")
	public DormManage dorm_getMyMsgById(@RequestBody DormManage dormManage) {
		return dormManageServiceImpl.dorm_getMyMsgById(dormManage.getDormManId());
	}
	
	@RequestMapping("dorm_updateMyMsgById")
	public Result dorm_updateMyMsgById(HttpServletRequest request ,@RequestBody DormManage dormManage) {
		try {
			HttpSession session=request.getSession();
			if(session.getAttribute("dormManager") !=null) {
				session.removeAttribute("dormManager");
			}
			List list=new ArrayList();
			list.add(dormManage);
			session.setAttribute("dormManager", list);
			dormManageServiceImpl.dorm_updateMyMsgById(dormManage);
			return new Result(true, "更新成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "更新失败");
		}
	}
	
	@RequestMapping("dorm_updatePsd")
	public Result dorm_updatePsd(@RequestBody DormManage dormManage) {
		try {
			dormManageServiceImpl.dorm_updatePsd(dormManage);
			System.out.println(dormManage);
			return new Result(true, "更新成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "更新失败");
		}
	} 
	
	
	/*-------------------------我的---------------------------*/
	
	@RequestMapping("getNoticeAll")
	public List<Notice> getNoticeAll(){
		return dormManageServiceImpl.getNoticeAll();
	}
	
	
	/*-------------------------打卡---------------------------*/
	
	@RequestMapping("/getPunchClockRecordMsgByDormBuildId")
	public PageResult getPunchClockRecordMsgByDormBuildId(HttpServletRequest request){
		Integer pageNum=1;
		Integer pageSize=20;
		Integer dormBuildId=0;
		String filter=request.getParameter("filter");
		String key=request.getParameter("key");
		if(request.getParameter("pageNum")!=null && request.getParameter("pageNum")!="") {
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
		}
		if(request.getParameter("pageSize")!=null && request.getParameter("pageSize")!="") {
			pageSize=Integer.parseInt(request.getParameter("pageSize"));
		}
		if(request.getParameter("dormBuildId")!=null && request.getParameter("dormBuildId")!="") {
			dormBuildId=Integer.parseInt(request.getParameter("dormBuildId"));
		}
		System.out.println("pageNum="+pageNum);
		System.out.println("pageSize="+pageSize);
		return dormManageServiceImpl.getPunchClockRecordMsgByDormBuildId(pageNum, pageSize, filter, key, dormBuildId);
	}
	
	/*-------------------------打卡---------------------------*/
	 
	
}
