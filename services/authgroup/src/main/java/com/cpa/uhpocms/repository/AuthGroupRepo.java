/**
 * @author  - Code Generator
 * @createdOn -  13-03-2023
 * @Description Entity class for AuthGroup
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AuthGroup;

@Repository
public interface AuthGroupRepo extends JpaRepository<AuthGroup, Integer> {
  
	public AuthGroup findById(int id);

	public List<Object> findByAuthGroupIsActiveTrue();

	@Transactional
	@Modifying
	@Query(value = "UPDATE auth_group SET is_active=false WHERE id = ?1", nativeQuery = true)
	public int deleteAuthGroupByid(String id);

}
