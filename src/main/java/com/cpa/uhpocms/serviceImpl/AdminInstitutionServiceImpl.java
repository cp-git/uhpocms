/**
 * @author : Akash
 * @created on : 21 - Nov - 2022
 * @Description : This class is an implementation class for AdminInstitution
 * Last modified : None 
 */
package com.cpa.uhpocms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpa.uhpocms.entity.AdminInstitution;
import com.cpa.uhpocms.repository.AdminInstitutionRepository;
import com.cpa.uhpocms.service.AdminInstitutionService;

@Service
@Transactional
public class AdminInstitutionServiceImpl implements AdminInstitutionService {
	@Autowired
	AdminInstitutionRepository adminInstitutionRepository;

	/**
	 * @author: Akash
	 * @param : AdminInstitution adminInstitution
	 * @return : AdminInstitution createdAdminInstitution
	 * @description : For creating/inserting entry in admin_institution table
	 */
	public AdminInstitution saveAdminInstitution(AdminInstitution adminInstitution) {
		adminInstitution.setAdminInstitutionCreatedBy("Admin");
		adminInstitution.setAdminInstitutionModifiedBy("Admin");

		AdminInstitution createdAdminInstitution = null;

		createdAdminInstitution = adminInstitutionRepository.save(adminInstitution);

		return createdAdminInstitution;
	}

	/**
	 * @author: Akash
	 * @return : List<AdminInstitution>
	 * @description : For Retrieving all entry in admin_institution table
	 */
	public List<AdminInstitution> getAllAdminInstitution() {

		return (List<AdminInstitution>) adminInstitutionRepository.findAll();
	}

	/**
	 * @author: Akash
	 * @param: String adminInstitutionName
	 * @return : String Record deleted Successfully.
	 * @description : For deleting entry in admin_institution table
	 */
	public String deleteAdminInstitutionByName(String adminInstitutionName) {

		adminInstitutionRepository.deleteByAdminInstitutionName(adminInstitutionName);
		return "Record Deleted Successfully";

	}

	/**
	 * @author: Akash
	 * @param: AdminInstitution adminInstitution,String adminInstitutionName
	 * @return : null.
	 * @description : For updating entry in admin_institution table
	 */
	public AdminInstitution updateAdminInstitutionByName(AdminInstitution adminInstitution,
			String adminInstitutionName) {

		return null;
	}

	/**
	 * @author: Akash
	 * @param: String adminInstitutionName
	 * @return : List<AdminInstitution>
	 * @description : For retrieving the specific entry in admin_institution table
	 */
	public List<AdminInstitution> findByAdminInstitutionName(String adminInstitutionName) {

		return adminInstitutionRepository.findByAdminInstitutionName(adminInstitutionName);
	}

}
