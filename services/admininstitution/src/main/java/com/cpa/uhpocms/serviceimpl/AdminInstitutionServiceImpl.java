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

	/**
	 * @author: Akash
	 * @param : AdminInstitution adminInstitution
	 * @return : AdminInstitution createdAdminInstitution
	 * @description : For creating/inserting entry in admin_institution table
	 */
	
	
	public AdminInstitution saveAdminInstitution(AdminInstitution adminInstitution) {

		adminInstitution.setAdminInstitutionCreatedBy("Admin");
		adminInstitution.setAdminInstitutionModifiedBy("Admin");
		

		logger.debug("Entering the admin institution data");

		AdminInstitution createdAdminInstitution = null;

		createdAdminInstitution = adminInstitutionRepository.save(adminInstitution);
		
		

		logger.info("Created admin institution :" + createdAdminInstitution);

		return createdAdminInstitution;
	}

	/**
	 * @author: Akash
	 * @return : objectList
	 * @description : For Retrieving all entry in admin_institution table
	 */

	
	public List<Object> getAllAdminInstitution() {
		logger.debug("Entering getAllAdminInstitution");
		List<Object> objectList = adminInstitutionRepository.findByAdminInstitutionIsActiveTrue();

		logger.info("Fetched all active institution :" + objectList);

		return objectList;

	}



	
	
	@Override
	public List<Object> getAllInactiveAdminInstitutions() {
		logger.debug("Entering getAllInactiveAdminInstitutions");

		List<Object> objectList = adminInstitutionRepository.findByAdminInstitutionIsActiveFalse();

		logger.info("Fetched all inactive institution :" + objectList);

		return objectList;
	}

	/**
	 * @param: int adminInstitutionId - id of institution we want to update
	 * @return : int count - how many rows updated
	 * @description : For activating the specific entry in admin_institution table
	 *              by id
	 */
	
	
	@Override
	public int activateAdminInstitutionById(int adminInstitutionId) {
		logger.debug("Entering getAllInactiveAdminInstitutions");
		int count = adminInstitutionRepository.activateAdminInstitutionById(adminInstitutionId);

		logger.info("activated institutions count :" + count);

		return count;
	}

	
	
	@Override
	public List<Object> getAdminInstitutionByProfileId(int profileid) {
		// TODO Auto-generated method stub
		List<Object> objectAdminInstitutions = null;
		List<AdminInstitution> adminInstitution = adminInstitutionRepository
				.findActiveInstitutionByProfileId(profileid);
		objectAdminInstitutions = new ArrayList<Object>(adminInstitution);
		return objectAdminInstitutions;
	}

	
	
	@Override
	public AdminInstitution findInstituteById(int adminInstitutionId) {
		// TODO Auto-generated method stub
		System.out.println("in serviceImpl");
		AdminInstitution admin=null;
		admin =adminInstitutionRepository.findByAdminInstitutionId(adminInstitutionId);
		
		return  admin;
	}
	
	
	
	@Override
	public int deleteInstitutionById(int institutionId) {
		// TODO Auto-generated method stub
		logger.debug("Entering deleteInstitutionById");

		int count = adminInstitutionRepository.deleteAdminInstitutionByadminInstitutionId(institutionId);
		
		return count;
	}

}
