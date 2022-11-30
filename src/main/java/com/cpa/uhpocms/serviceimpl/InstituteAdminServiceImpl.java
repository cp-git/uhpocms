package com.cpa.uhpocms.serviceimpl;

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
	
	private static final Logger loggger = Logger.getLogger(InstituteAdminServiceImpl.class);
	
	
	
	/**
	 * @author : Anmesh
	 * @param :  SaveInstituteAdmin
	 * @return : InstituteAdmin 
	 * @description : For Saving All the data 
	 */
	@Override
	public InstituteAdmin saveInstituteAdmin(InstituteAdmin instituteAdmin) {
		loggger.debug("In SaveInstituteAdmin Method...");
		instituteAdmin.setCreatedBy("admin");

		instituteAdmin.setModifiedBy("admin");

		InstituteAdmin createInstituteAdmin=null;
		createInstituteAdmin =instituteAdminRepository.save(instituteAdmin);
		loggger.info("The Values saveInstitute"+createInstituteAdmin);
		return createInstituteAdmin;
	}
	
	
	
	
	

	
	/**
	 * @author : Anmesh
	 * @param :  getAllInstitute
	 * @return : List<InstituteAdmin> 
	 * @description : For getting All data using getAllInstitute
	 */
	@Override
	public List<Object> getAllInstitute() {
		loggger.debug("in GetAllInstituteAdmin method...");
		List<Object> InstituteList ;
		InstituteList = instituteAdminRepository.findByActiveUserIsTrue();
		loggger.info("Fetching All List Data "+InstituteList);
		return InstituteList;
	}

	
	/**
	 * @author : Anmesh
	 * @param :  updateInstituteAdmin
	 * @return : InstituteAdmin 
	 * @description : For updating data using firstName
	 */
	@Override
	public InstituteAdmin updateInstituteAdmin(InstituteAdmin instituteAdmin, String firstName) {
		loggger.debug("InSaveInstituteAdmin...");
		InstituteAdmin insAdmin = instituteAdminRepository.findByFirstName(firstName);
		loggger.info("The Update Method is..."+insAdmin);
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
	 * @param :  DeleteInstituteAdmin
	 * @return : int
	 * @description : For Soft Delete data using firstName
	 */
	@Override
	public int deleteDepartmentByName(String firstName) {
    loggger.debug("in deleteByInstituteAdmin Name");
		return instituteAdminRepository.deleteDepartmentByName(firstName);
	}
	
	
	/**
	 * @author : Anmesh
	 * @param :  UserId unique key and foreign key
	 * @return : int UserId
	 * @description : For fetching userId  using
	 */
	@Override
	public InstituteAdmin findByUserId(int userId) {
		loggger.debug("in unique key constraint...");
		return instituteAdminRepository.findByUserId(userId);
	}


	/**
	 * @author : Anmesh
	 * @param :  getInstituteByName
	 * @return : InstituteAdmin 
	 * @description : For getting data using firstName
	 */

	@Override
	public InstituteAdmin getInstituteByName(String firstName) {
		// TODO Auto-generated method stub
		return instituteAdminRepository.findByFirstName(firstName);
	}

}
