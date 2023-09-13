package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.InstituteAdmin;

public interface InstituteAdminService {

	//Used
	InstituteAdmin saveInstituteAdmin(InstituteAdmin instituteAdmin);

	

	//Used
	public InstituteAdmin getProfileById(int id);
	
	
	//Used
	public InstituteAdmin findByUserId(int userId);

	
	//Used
	List<Object> getAllInstitute();

	
	

	//Used
	List<Object> getAllInactiveInstitute();

	//Used
	int activateInstituteProfileById(int profileId);


	//Used
	List<Object> getProfileByInstitutionIdAndUserRole(Integer institutionId, String userRole);

	//Used
	InstituteAdmin updateProfileByAuthUserId(InstituteAdmin instituteAdmin, int userId);

	//Used
	InstituteAdmin getProfileByAuthUserId(int userId);
	
	List<Object> getProfileCourseAssignedTeacher(int profileId);

	
	//Used
	InstituteAdmin getInstituteDetails(int adminId);

	
}
