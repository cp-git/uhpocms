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



	
	// FETCH ALL ACTIVE INSTITUTIONS 
	public List<Object> findByAdminInstitutionIsActiveTrue();


	
	// FETCH ALL INACTIVE INSTITUTIONS 
	public List<Object> findByAdminInstitutionIsActiveFalse();

	
	
	
	// ACTIVATE INSTITUTE BY INSTITUTE ID 
	@Transactional
	@Modifying
	@Query(value = "UPDATE admin_institution SET isactive=true WHERE institutionid=?1", nativeQuery = true)
	public int activateAdminInstitutionById(int adminInstitutionId);


// FIND  INSTITUTE BY INSTITUTE ID	
	public AdminInstitution findByAdminInstitutionId(int adminInstitutionId);
	
	

// FIND ACTIVE INSTITUTION BY PROFILE ID
	@Transactional
	@Modifying
	@Query(value = "SELECT ai.* FROM admin_institution ai JOIN instituteadmin_profile iap ON ai.institutionid = iap.institutionid_id WHERE iap.id =?1", nativeQuery = true)
	List<AdminInstitution> findActiveInstitutionByProfileId(int profileId);
	
	
	
	// DELETE ADMIN INSTITUTION BY INSTITUTION ID 
	@Transactional
	@Modifying
	@Query(value = "UPDATE admin_institution SET isactive=false WHERE institutionid=?1", nativeQuery = true)
    int deleteAdminInstitutionByadminInstitutionId(int adminInstitutionId);


}
