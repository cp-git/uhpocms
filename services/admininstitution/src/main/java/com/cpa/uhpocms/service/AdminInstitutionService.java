/**
 * @author : Akash
 * @created on : 21 - Nov - 2022
 * @Description : This is a Service Interface for AdminInstitution.
 * Last modified : None 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cpa.uhpocms.entity.AdminInstitution;

@Service
public interface AdminInstitutionService {

	
	////////////////////////// CREATE AN INSTITUTE ////////////////////////////////////
	AdminInstitution saveAdminInstitution(AdminInstitution adminInstitution);

	
	////////////////////////// GET ALL ADMIN INSTITUTION /////////////////////////////
	List<Object> getAllAdminInstitution();

	

	
	/////////////////////// GET ALL ADMIN INSTITUTION BY PROFILE ID //////////////////////
	List<Object> getAdminInstitutionByProfileId(int profileid);

	
	///////////////////////////// GET ALL INACTIVE INSTITUTIONS /////////////////////////
	List<Object> getAllInactiveAdminInstitutions();

	
	////////////////////////////////// ACTIVATE ADMIN INSTITUTION BY ID //////////////////
	int activateAdminInstitutionById(int adminInstitutionId);
	
	
	//////////////////  FIND BY ADMIN INSTITUTION BY ID /////////////////////////
	AdminInstitution findInstituteById(int adminInstitutionId);
	
	
	////////////////////////// DELETE ADMIN INSTITUTION BY ID ///////////////////////
	 int deleteInstitutionById(int institutionid);
	
	

}
