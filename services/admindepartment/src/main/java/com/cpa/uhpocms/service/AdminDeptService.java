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

	int deleteDeptById(int departmentid);

	public AdminDepartment getDeptByName(String name);

	AdminDepartment getDepartmentById(int departmentid);

	List<Object> findActiveDepartmentOfAssignCoursesByProfileId(int profileid);

	List<Object> findByInstitutionId(int institutionId);

	public List<Object> getAllInactiveDepartments();

	public int activateDepartment(int departmentId);

	public AdminDepartment updateDepartmentById(AdminDepartment adminDepartment, int departmentid);

	AdminDepartment createDepartment(AdminDepartment adminDepartment);

	AdminDepartment getDepartmentByInstitutionIdAndName(int institutionId, String name);

	public List<Object> getInactiveDepartmentsByInstituionId(int institutionId);

	List<Object> getDepartmentByProfileId(int profileid);
}
