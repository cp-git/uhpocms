package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.AdminDepartment;

public interface AdminDeptService {
  
	public AdminDepartment insertDept(AdminDepartment adminDepartment);
	public List<AdminDepartment> getAdminDepartments();
	public AdminDepartment updateDept(AdminDepartment adminDepartment, String name);
}
