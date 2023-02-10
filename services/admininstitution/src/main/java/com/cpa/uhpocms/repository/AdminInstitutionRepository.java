/**
 * @author : Akash
 * @created on : 21 - Nov - 2022
 * @Description : This is an Repository interface for AdminInstitution which extends CrudRepository
 * Last modified : None 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

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
	 * @return : AdminInstitution
	 * @description: To find the all data using Institution name from
	 *               AdminInstitution table
	 */
	AdminInstitution findByAdminInstitutionName(String adminInstitutionName);

	/**
	 * @author: Akash
	 * @return : List<AdminInstitution>
	 * @description: To find the all data of institution where admin institution is
	 *               in active state
	 * 
	 */
	public List<Object> findByAdminInstitutionIsActiveTrue();

	/**
	 * @author: Akash
	 * @param : String adminInstitutionName
	 * @return : AdminInstitution
	 * @description: To soft delete admin institution by adminInstitutionName (by
	 *               setting is_active to false)
	 */
	@Transactional
	@Modifying
	@Query(value = "UPDATE admin_institution SET isactive=false WHERE name=?1", nativeQuery = true)
	public int deleteAdminInstitutionByInstitutionName(String adminInstitutionName);

	/**
	 * @return : List<AdminInstitution>
	 * @description: To find the all data of institution where admin institution is
	 *               in inactive state
	 * 
	 */
	public List<Object> findByAdminInstitutionIsActiveFalse();

	/**
	 * @param : String adminInstitutionName
	 * @return : AdminInstitution
	 * @description: To reactivate admin institution by adminInstitutionName (by
	 *               setting is_active to true)
	 */
	@Transactional
	@Modifying
	@Query(value = "UPDATE admin_institution SET isactive=true WHERE institutionid=?1", nativeQuery = true)
	public int activateAdminInstitutionById(int adminInstitutionId);
}
