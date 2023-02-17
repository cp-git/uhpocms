package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.InstituteAdmin;

public interface InstituteAdminService {
	
	InstituteAdmin saveInstituteAdmin(InstituteAdmin instituteAdmin);
	
	InstituteAdmin getInstituteByName(String firstName);
	
	public InstituteAdmin findByUserId(int userId);
	
	
	List<Object> getAllInstitute(); 
	
	InstituteAdmin updateInstituteAdmin(InstituteAdmin instituteAdmin, String  firstName);
	
	int deleteDepartmentByName(String firstName);
	
	List<Object> getProfileByDepartmentId(int department_id);
	
	
	
}
