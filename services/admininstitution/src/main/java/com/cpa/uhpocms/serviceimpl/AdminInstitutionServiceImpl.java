/**
 * @author : Akash
 * @created on : 21 - Nov - 2022
 * @Description : This class is an implementation class for AdminInstitution
 * Last modified : None 
 */
package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.uhpocms.controller.AdminInstitutionController;
import com.cpa.uhpocms.entity.AdminInstitution;
import com.cpa.uhpocms.repository.AdminInstitutionRepository;
import com.cpa.uhpocms.service.AdminInstitutionService;

@Service

public class AdminInstitutionServiceImpl implements AdminInstitutionService {
	@Autowired
	AdminInstitutionRepository adminInstitutionRepository;
	private static Logger logger;

	public AdminInstitutionServiceImpl() {
		logger = Logger.getLogger(AdminInstitutionController.class);

	}


	
//////////////////////////CREATE AN INSTITUTE ////////////////////////////////////
	public AdminInstitution saveAdminInstitution(AdminInstitution adminInstitution) {

		adminInstitution.setAdminInstitutionCreatedBy("Admin");
		adminInstitution.setAdminInstitutionModifiedBy("Admin");
		

		logger.debug("Entering the admin institution data");

		AdminInstitution createdAdminInstitution = null;

		createdAdminInstitution = adminInstitutionRepository.save(adminInstitution);
		
		

		logger.info("Created admin institution :" + createdAdminInstitution);

		return createdAdminInstitution;
	}

//////////////////////////GET ALL ADMIN INSTITUTION /////////////////////////////	
	public List<Object> getAllAdminInstitution() {
		logger.debug("Entering getAllAdminInstitution");
		List<Object> objectList = adminInstitutionRepository.findByAdminInstitutionIsActiveTrue();

		logger.info("Fetched all active institution :" + objectList);

		return objectList;

	}




	


	/**
	 * @author: Akash
	 * @param: AdminInstitution adminInstitution,String adminInstitutionName
	 * @return : AdminInstitution admin.
	 * @description : For updating entry in admin_institution table
	 */
	public AdminInstitution updateAdminInstitutionByName(AdminInstitution adminInstitution,
			String adminInstitutionName) {
		logger.debug("Entering updateAdminInstitutionByName");

		AdminInstitution updatedAdminInstitution = null;

		AdminInstitution admin = adminInstitutionRepository.findByAdminInstitutionName(adminInstitutionName);
		logger.info("Existimg Admin Institution" + admin);

		if (admin != null) {
			admin.setAdminInstitutionName(adminInstitution.getAdminInstitutionName());
			admin.setAdminInstitutionDescription(adminInstitution.getAdminInstitutionDescription());
			admin.setAdminInstitutionIsActive(adminInstitution.isAdminInstitutionIsActive());
			admin.setAdminInstitutionPicture(adminInstitution.getAdminInstitutionPicture());
			admin.setInstSignature(adminInstitution.getInstSignature());
			updatedAdminInstitution = adminInstitutionRepository.save(admin);
		}

		logger.info("Updated AdminInstitution data" + updatedAdminInstitution);
		return updatedAdminInstitution;

	}

	/**
	 * @author: Akash
	 * @param: String adminInstitutionName
	 * @return : adminInstitutionName
	 * @description : For retrieving the specific entry in admin_institution table
	 */
	public AdminInstitution findByAdminInstitutionName(String adminInstitutionName) {
		logger.debug("Entering getAdminInstitutionByName");
		AdminInstitution adminInstitution = adminInstitutionRepository.findByAdminInstitutionName(adminInstitutionName);

		logger.info("Fetched AdminInstitution data" + adminInstitution);
		return adminInstitution;
	}

	/**
	 * @return : adminInstitutions - list of institution which are in inactive state
	 * @description : For retrieving the all entries in admin_institution table
	 *              which are in inactive state
	 */

	@Override
	public List<Object> getAllInactiveAdminInstitutions() {
		logger.debug("Entering getAllInactiveAdminInstitutions");

		List<Object> objectList = adminInstitutionRepository.findByAdminInstitutionIsActiveFalse();

		logger.info("Fetched all inactive institution :" + objectList);

		return objectList;
	}

	
///////////////////////////// GET ALL INACTIVE INSTITUTIONS /////////////////////////
	@Override
	public int activateAdminInstitutionById(int adminInstitutionId) {
		logger.debug("Entering getAllInactiveAdminInstitutions");
		int count = adminInstitutionRepository.activateAdminInstitutionById(adminInstitutionId);

		logger.info("activated institutions count :" + count);

		return count;
	}

	
////////////////////////////////// ACTIVATE ADMIN INSTITUTION BY ID //////////////////	
	@Override
	public List<Object> getAdminInstitutionByProfileId(int profileid) {
		// TODO Auto-generated method stub
		List<Object> objectAdminInstitutions = null;
		List<AdminInstitution> adminInstitution = adminInstitutionRepository
				.findActiveInstitutionByProfileId(profileid);
		objectAdminInstitutions = new ArrayList<Object>(adminInstitution);
		return objectAdminInstitutions;
	}

	
	
//////////////////FIND BY ADMIN INSTITUTION BY ID /////////////////////////
	@Override
	public AdminInstitution findInstituteById(int adminInstitutionId) {
		// TODO Auto-generated method stub
		System.out.println("in serviceImpl");
		AdminInstitution admin=null;
		admin = adminInstitutionRepository.findByAdminInstitutionId(adminInstitutionId);
		
		return  admin;
	}
	
	
	////////////////////////// DELETE ADMIN INSTITUTION BY ID ///////////////////////
	@Override
	public int deleteInstitutionById(int institutionId) {
		// TODO Auto-generated method stub
		logger.debug("Entering deleteInstitutionById");

		int count = adminInstitutionRepository.deleteAdminInstitutionByadminInstitutionId(institutionId);
		
		return count;
	}

}
