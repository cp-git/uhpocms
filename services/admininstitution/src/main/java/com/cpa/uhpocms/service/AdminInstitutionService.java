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

	AdminInstitution saveAdminInstitution(AdminInstitution adminInstitution);

	List<Object> getAllAdminInstitution();

	int deleteAdminInstitutionByName(String adminInstitutionName);

	AdminInstitution updateAdminInstitutionByName(AdminInstitution adminInstitution, String adminInstitutionName);

	AdminInstitution findByAdminInstitutionName(String adminInstitutionName);

	List<Object> getAdminInstitutionByProfileId(int profileid);

	List<Object> getAllInactiveAdminInstitutions();

	int activateAdminInstitutionById(int adminInstitutionId);
	
	AdminInstitution findInstituteById(int adminInstitutionId);
	
	

}
