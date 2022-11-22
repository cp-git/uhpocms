/**
 * @author : Akash
 * @created on : 21 - Nov - 2022
 * @Description : This is an Repository interface for AdminInstitution which extends CrudRepository
 * Last modified : None 
 */

package com.cpa.uhpocms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AdminInstitution;

@Repository
public interface AdminInstitutionRepository extends CrudRepository<AdminInstitution, Integer> {
	/**
	 * @author: Akash
	 * @param : String adminInstitutionName
	 * @return : List<AdminInstitution>
	 * @description: To find the all data using Institution name from
	 *               AdminInstitution table
	 */
	AdminInstitution findByAdminInstitutionName(String adminInstitutionName);

	/**
	 * @author: Akash
	 * @param : String adminInstitutionName
	 * @return : String
	 * @description: To delete all data using Institution name from AdminInstitution
	 *               table
	 */
	String deleteByAdminInstitutionName(String adminInstitutionName);
}
