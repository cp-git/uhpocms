/**
 * 
 */
package com.cpa.uhpocms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.uhpocms.entity.AdminInstitution;
import com.cpa.uhpocms.repository.AdminInstitutionRepository;
import com.cpa.uhpocms.service.AdminInstitutionService;

/**
 * @author Akash
 *
 */
@Service
public class AdminInstitutionServiceImpl implements AdminInstitutionService {
	@Autowired
	AdminInstitutionRepository adminInstitutionRepository;

	// Read Operation
	public AdminInstitution getAdminInstitutionByName(String adminInstitutionName) {

		return null;
	}

	// Save Operation
	public AdminInstitution saveAdminInstitution(AdminInstitution adminInstitution) {

		return adminInstitutionRepository.save(adminInstitution);
	}

	// Read Operation
	public List<AdminInstitution> getAllAdminInstitution() {

		return (List<AdminInstitution>) adminInstitutionRepository.findAll();
	}

	// Delete Operation
	public String deleteAdminInstitutionByName(String adminInstitutionName) {

		return null;
	}

	// update Operation
	public AdminInstitution updateAdminInstitutionByName(AdminInstitution adminInstitution,
			String adminInstitutionName) {

		return null;
	}

}
