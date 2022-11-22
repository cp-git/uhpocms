/**
 * @author : Akash
 * @created on : 21 - Nov - 2022
 * @Description : This is an Repository interface for AdminInstitution which extends CrudRepository
 * Last modified : None 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AdminInstitution;

@Repository
public interface AdminInstitutionRepository extends CrudRepository<AdminInstitution, String> {

	List<AdminInstitution> findByAdminInstitutionName(String adminInstitutionName);

	String deleteByAdminInstitutionName(String adminInstitutionName);
}
