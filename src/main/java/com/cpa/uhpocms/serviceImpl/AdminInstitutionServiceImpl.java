/**
 * @author : Akash
 * @created on : 21 - Nov - 2022
 * @Description : This class is an implementation class for AdminInstitution
 * Last modified : None 
 */
package com.cpa.uhpocms.serviceImpl;

import java.util.ArrayList;
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

	public List<Object> getAllAdminInstitution() {

		List<Object> objectList = new ArrayList<Object>(adminInstitutionRepository.findAll());
		return objectList;
	}

	/**
	 * @author: Akash
	 * @param: String adminInstitutionName
	 * @return : String Record deleted Successfully.
	 * @description : For deleting entry in admin_institution table
	 */
	public int deleteAdminInstitutionByName(String adminInstitutionName) {

		return adminInstitutionRepository.deleteByAdminInstitutionName(adminInstitutionName);

	}

	/**
	 * @author: Akash
	 * @param: AdminInstitution adminInstitution,String adminInstitutionName
	 * @return : AdminInstitution admin.
	 * @description : For updating entry in admin_institution table
	 */
	public AdminInstitution updateAdminInstitutionByName(AdminInstitution adminInstitution,
			String adminInstitutionName) {

		AdminInstitution admin = adminInstitutionRepository.findByAdminInstitutionName(adminInstitutionName);
		admin.setAdminInstitutionName(adminInstitution.getAdminInstitutionName());
		admin.setAdminInstitutionDescription(adminInstitution.getAdminInstitutionDescription());
		admin.setAdminInstitutionIsActive(adminInstitution.isAdminInstitutionIsActive());
		admin.setAdminInstitutionPicture(adminInstitution.getAdminInstitutionPicture());
		adminInstitutionRepository.save(admin);
		return admin;

	}

	/**
	 * @author: Akash
	 * @param: String adminInstitutionName
	 * @return : List<AdminInstitution>
	 * @description : For retrieving the specific entry in admin_institution table
	 */
	public AdminInstitution findByAdminInstitutionName(String adminInstitutionName) {

		return adminInstitutionRepository.findByAdminInstitutionName(adminInstitutionName);
	}

}
