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

	
	//USED
	AdminInstitution saveAdminInstitution(AdminInstitution adminInstitution);

	
	//USED
	List<Object> getAllAdminInstitution();

	

	
	//USED
	List<Object> getAdminInstitutionByProfileId(int profileid);

	
	//USED
	List<Object> getAllInactiveAdminInstitutions();

	
	//USED
	int activateAdminInstitutionById(int adminInstitutionId);
	
	
	//USED
	AdminInstitution findInstituteById(int adminInstitutionId);
	
	
	//USED
	 int deleteInstitutionById(int institutionid);
	
	

}
