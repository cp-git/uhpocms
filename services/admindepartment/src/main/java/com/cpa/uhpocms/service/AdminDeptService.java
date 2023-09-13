/**
 * @author Shradha
 * @description: Interface that provides declaration for methods that can perform CRUD operation for AdminDepartment Entity
 * @createdOn : 24 Nov 2022
 */
package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.AdminDepartment;

public interface AdminDeptService {

	//insert the department 
	public AdminDepartment insertDept(AdminDepartment adminDepartment);

	//getting the list of department  
	public List<Object> getAdminDepartments();

	
	//delete the department by id  
	int deleteDeptById(int departmentid);

	
	//finding the active department by assignrd courses by profile id 
	List<Object> findActiveDepartmentOfAssignCoursesByProfileId(int profileid);

	//find institute using institute id 
	List<Object> findByInstitutionId(int institutionId);

	//getting all inactive departments 
	public List<Object> getAllInactiveDepartments();

	
	//activate department using department id 
	public int activateDepartment(int departmentId);

	//update the department by department id 
	public AdminDepartment updateDepartmentById(AdminDepartment adminDepartment, int departmentid);


	//Getting inactive department by institution id 
	public List<Object> getInactiveDepartmentsByInstituionId(int institutionId);

	
}
