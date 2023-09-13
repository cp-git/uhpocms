package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.InstituteAdmin;

public interface InstituteAdminService {

	//CREATE PROFILE
	InstituteAdmin saveInstituteAdmin(InstituteAdmin instituteAdmin);

	

	//GET PROFILE BY ID
	public InstituteAdmin getProfileById(int id);
	
	
	//GET PROFILE BY USER ID
	public InstituteAdmin findByUserId(int userId);

	
	//GET ALL USER PROFILE
	List<Object> getAllInstitute();

	
	

	//GET INACTIVE INSTITUTE
	List<Object> getAllInactiveInstitute();

	//ACTIVATE PROFILE BY PROFILE ID
	int activateInstituteProfileById(int profileId);


	//GET LIST PROFILE INSTITUTION ID AND USER ROLE
	List<Object> getProfileByInstitutionIdAndUserRole(Integer institutionId, String userRole);

	//UPDATE PROFILE BASED ON USER ID
	InstituteAdmin updateProfileByAuthUserId(InstituteAdmin instituteAdmin, int userId);

	//GET PROFILE BY USER ID
	InstituteAdmin getProfileByAuthUserId(int userId);
	
	//GET LIST OF PROFILE COURSES ASSIGNED TO TEACHER
	List<Object> getProfileCourseAssignedTeacher(int profileId);

	
	//GET PROFILE BY ID
	InstituteAdmin getInstituteDetails(int adminId);

	
}
