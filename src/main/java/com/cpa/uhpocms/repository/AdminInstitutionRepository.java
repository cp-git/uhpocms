/**
 * 
 */
package com.cpa.uhpocms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AdminInstitution;

/**
 * @author Akash
 *
 */
@Repository
public interface AdminInstitutionRepository extends CrudRepository<AdminInstitution, String> {

}
