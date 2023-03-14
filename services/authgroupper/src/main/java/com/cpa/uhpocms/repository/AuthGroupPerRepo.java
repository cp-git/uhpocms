/**
 * @author  - Code Generator
 * @createdOn -  13-03-2023
 * @Description Entity class for AuthGroupPer
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AuthGroupPer;

@Repository
public interface AuthGroupPerRepo extends JpaRepository<AuthGroupPer, Integer> {

	public AuthGroupPer findById(int id);

	public List<Object> findByAuthGroupPerIsActiveTrue();

	@Transactional
	@Modifying
	@Query(value = "UPDATE auth_group_permissions SET is_active=false WHERE id = ?1", nativeQuery = true)
	public int deleteAuthGroupPerByid(String id);

}
