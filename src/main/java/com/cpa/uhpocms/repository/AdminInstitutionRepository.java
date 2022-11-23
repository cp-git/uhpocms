/**
 * @author : Akash
 * @created on : 21 - Nov - 2022
 * @Description : This is an Repository interface for AdminInstitution which extends CrudRepository
 * Last modified : None 
 */

package com.cpa.uhpocms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cpa.uhpocms.entity.AdminInstitution;

@Repository
public interface AdminInstitutionRepository extends JpaRepository<AdminInstitution, Integer> {
	boolean adminInstitutionIsActive = true;

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
	@Transactional
	@Modifying
	@Query(value = "UPDATE admin_institution SET is_active=false WHERE institution_name=?1", nativeQuery = true)
	int deleteByAdminInstitutionName(String adminInstitutionName);
}
