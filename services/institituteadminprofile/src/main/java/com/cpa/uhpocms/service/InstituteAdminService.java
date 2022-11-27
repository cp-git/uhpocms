package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.InstituteAdmin;

public interface InstituteAdminService {
	
	InstituteAdmin saveInstituteAdmin(InstituteAdmin instituteAdmin);
	
	InstituteAdmin getInstitutebyName(String firstName);
	
	
	List<Object> getAllInstitute(); 
	
	InstituteAdmin updateInstituteAdmin(InstituteAdmin instituteAdmin, String  firstName);
	
	int deleteDepartmentById(String firstName);
	
	
}
