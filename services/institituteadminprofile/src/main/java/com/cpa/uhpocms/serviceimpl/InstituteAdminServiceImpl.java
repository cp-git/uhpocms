package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;

/**
 * @author Anmesh
 * @createdOn 30th Nov 2022
 * @Description implementation class for Institute_Admin
 * 
 */

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.uhpocms.entity.InstituteAdmin;
import com.cpa.uhpocms.repository.InstituteAdminRepository;
import com.cpa.uhpocms.service.InstituteAdminService;

@Service
class InstituteAdminServiceImpl implements InstituteAdminService {

	@Autowired
	private InstituteAdminRepository instituteAdminRepository;

	private static final Logger logger = Logger.getLogger(InstituteAdminServiceImpl.class);

	/**
	 * @author : Anmesh
	 * @param : InstituteAdmin
	 * @return : InstituteAdmin
	 * @description : For Saving All the data
	 */
	@Override
	public InstituteAdmin saveInstituteAdmin(InstituteAdmin instituteAdmin) {
		logger.debug("In SaveInstituteAdmin Method...");
		instituteAdmin.setCreatedBy("admin");

		instituteAdmin.setModifiedBy("admin");

		InstituteAdmin createInstituteAdmin = null;
		createInstituteAdmin = instituteAdminRepository.save(instituteAdmin);
		logger.info("The Values saveInstitute" + createInstituteAdmin);
		return createInstituteAdmin;
	}

	/**
	 * @author : Anmesh
	 * @return : List<InstituteAdmin>
	 * @description : For getting All data using getAllInstitute
	 */
	@Override
	public List<Object> getAllInstitute() {
		logger.debug("in GetAllInstituteAdmin method...");
		List<Object> InstituteList;
		InstituteList = instituteAdminRepository.findByActiveUserIsTrue();
		logger.info("Fetching All List Data " + InstituteList);
		return InstituteList;
	}

	/**
	 * @author : Anmesh
	 * @param : InstituteAdmin,String
	 * @return : InstituteAdmin
	 * @description : For updating data using firstName
	 */
	@Override
	public InstituteAdmin updateInstituteAdmin(InstituteAdmin instituteAdmin, String firstName) {
		logger.debug("InSaveInstituteAdmin...");
		InstituteAdmin insAdmin = instituteAdminRepository.findByFirstName(firstName);
		logger.info("The Update Method is..." + insAdmin);
		insAdmin.setUserId(instituteAdmin.getAdminId());
		insAdmin.setUserRole(instituteAdmin.getUserRole());
		insAdmin.setFirstName(instituteAdmin.getFirstName());
		insAdmin.setLastName(instituteAdmin.getLastName());
		insAdmin.setAdminEmail(instituteAdmin.getAdminEmail());
		insAdmin.setDob(instituteAdmin.getDob());
		insAdmin.setMobilePhone(instituteAdmin.getMobilePhone());
		insAdmin.setAdminGender(instituteAdmin.getAdminGender());
		insAdmin.setAdminDepartment(instituteAdmin.getAdminDepartment());
		insAdmin.setAdminAddress1(instituteAdmin.getAdminAddress1());
		insAdmin.setAdminAddress2(instituteAdmin.getAdminAddress2());
		insAdmin.setAdminCity(instituteAdmin.getAdminCity());
		insAdmin.setAdminState(instituteAdmin.getAdminState());
		insAdmin.setAdminZip(instituteAdmin.getAdminZip());
		insAdmin.setProfilePics(instituteAdmin.getProfilePics());
		insAdmin.setActiveUser(instituteAdmin.isActiveUser());
		insAdmin.setInstitutionId(instituteAdmin.getInstitutionId());
		insAdmin.setUserId(instituteAdmin.getUserId());

		instituteAdminRepository.save(insAdmin);
		return insAdmin;
	}

	/**
	 * @author : Anmesh
	 * @param : String
	 * @return : int
	 * @description : For Soft Delete data using firstName
	 */
	@Override
	public int deleteInstitutionProfileByName(String firstName) {
		logger.debug("in deleteByInstituteAdmin Name");
		return instituteAdminRepository.deleteInstitutionProfileByName(firstName);
	}

	/**
	 * @author : Anmesh
	 * @param : int
	 * @return : int UserId
	 * @description : For fetching userId using
	 */
	@Override
	public InstituteAdmin findByUserId(int userId) {
		logger.debug("in unique key constraint...");
		return instituteAdminRepository.findByUserId(userId);
	}

	/**
	 * @author : Anmesh
	 * @param : getInstituteByName
	 * @return : InstituteAdmin
	 * @description : For getting data using firstName
	 */

	@Override
	public InstituteAdmin getInstituteByName(String firstName) {

		return instituteAdminRepository.findByFirstName(firstName);
	}




	@Override
	public List<Object> getProfileByDepartmentId(int department_id) {
		// TODO Auto-generated method stub
		List<Object> profileObject = null;

		List<Object> object = instituteAdminRepository.findProfileByDepartmentId(department_id);


		profileObject = new ArrayList<Object>(object);
		return profileObject;

	}


	/**
	 * @return : List<InstituteAdmin>
	 * @description : For getting All institute admin profile data which are in
	 *              inactive state
	 */
	@Override
	public List<Object> getAllInactiveInstitute() {
		logger.debug("in getAllInactiveInstitute method...");
		List<Object> objectInstitutionProfiles = null;

		List<InstituteAdmin> institutionProfiles = instituteAdminRepository.findInactiveProfileOfActiveInstitutions();

		logger.info("Fetching inactive profile Data " + institutionProfiles);

		objectInstitutionProfiles = new ArrayList<Object>(institutionProfiles);
		
		return objectInstitutionProfiles;
	}

	/**
	 * @return : count of activated profiles
	 * @description : For activating institute admin profile data which are in
	 *              inactive state using profileId
	 */
	@Override
	public int activateInstituteProfileById(int profileId) {
		logger.debug("Entering activateInstitutionProfileById");

		int count = instituteAdminRepository.activateInstituteProfileById(profileId);
		logger.info("activated institutionProfile count : " + count);
		return count;
	}


	/**
	 * @author Shradha
	 * @return : List of Institute_Admin_Profile Objects
	 * @param : institution Id and userRole
	 * @description : returns a sorted list of profiles based on institution id and userRole provided
	 */
	public List<Object> getProfileByInstitutionIdAndUserRole(Integer institutionId, String userRole) {
		// TODO Auto-generated method stub
		logger.debug("Entering getProfileByUserRole");

		List<Object> institutionProfilesList = null;
		
	    
	    	institutionProfilesList = instituteAdminRepository.findByInstitutionIdAndUserRole(institutionId, userRole);
	    	logger.info("activated institutionProfile count : " + institutionProfilesList);
			return institutionProfilesList;
	    
				
		
		
	}

	

	
}
