/**
 * @author Shradha
 * @description: Interface that provides declaration for methods that can perform CRUD operation for AdminDepartment Entity
 * @createdOn : 24 Nov 2022
 */
package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.AdminDepartment;

public interface AdminDeptService {
  
	public AdminDepartment insertDept(AdminDepartment adminDepartment);
	public List<Object> getAdminDepartments();
	public Object updateDept(AdminDepartment adminDepartment, String name);
	public void deleteDept(String name);
	public Object getDeptByName( String name);
}
