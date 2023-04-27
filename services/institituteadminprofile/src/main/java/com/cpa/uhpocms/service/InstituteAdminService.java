package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.InstituteAdmin;

public interface InstituteAdminService {

	InstituteAdmin saveInstituteAdmin(InstituteAdmin instituteAdmin);

	InstituteAdmin getInstituteByName(String firstName);

	public InstituteAdmin getProfileById(int id);
	
	public InstituteAdmin findByUserId(int userId);

	List<Object> getAllInstitute();

	InstituteAdmin updateInstituteAdmin(InstituteAdmin instituteAdmin, String firstName);

	List<Object> getProfileByDepartmentId(int department_id);

	int deleteInstitutionProfileByName(String firstName);

	List<Object> getAllInactiveInstitute();

	int activateInstituteProfileById(int profileId);


	List<Object> getProfileByInstitutionIdAndUserRole(Integer institutionId, String userRole);

	InstituteAdmin updateProfileByAuthUserId(InstituteAdmin instituteAdmin, int userId);

	InstituteAdmin getProfileByAuthUserId(int userId);


}
