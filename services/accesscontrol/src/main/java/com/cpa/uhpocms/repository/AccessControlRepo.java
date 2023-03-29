/**
 * @author  - Code Generator
 * @createdOn -  29-03-2023
 * @Description Entity class for AccessControl
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AccessControl;

@Repository
public interface AccessControlRepo extends JpaRepository<AccessControl, Integer> {

	public AccessControl findById(int id);
	
	
	
	@Transactional
	@Modifying
	@Query(value = "DELETE from accesscontrol WHERE id= ?1", nativeQuery = true)
	public int deleteById(int id);

}
