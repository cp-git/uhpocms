package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.InstituteAdmin;

public interface InstituteAdminService {
	
	InstituteAdmin saveInstituteAdmin(InstituteAdmin instituteAdmin);
	
	InstituteAdmin getInstitutebyName(String firstName);
	
	
	List<InstituteAdmin> getAllInstitute(); 
}
