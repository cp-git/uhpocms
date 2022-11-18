/**
 * 
 */
package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.AdminInstitution;

/**
 * @author Akash
 *
 */
public interface AdminInstitutionService {

	AdminInstitution getAdminInstitutionByName(String adminInstitutionName);

	AdminInstitution saveAdminInstitution(AdminInstitution adminInstitution);

	List<AdminInstitution> getAllAdminInstitution();

	String deleteAdminInstitutionByName(String adminInstitutionName);

	AdminInstitution updateAdminInstitutionByName(AdminInstitution adminInstitution, String adminInstitutionName);

}
