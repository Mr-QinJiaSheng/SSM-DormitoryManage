package com.cya.mapper;

import java.util.List;

import com.cya.entity.Admin;
import com.cya.entity.DormManage;
import com.cya.entity.Login;
import com.cya.entity.Student;

public interface ILoginMapper {
	
	public List<Admin> loginToAdmin(Login login);
	
	public List<DormManage> loginToDormManage(Login login);
	
	public List<Student> loginToStudent(Login login);
}
