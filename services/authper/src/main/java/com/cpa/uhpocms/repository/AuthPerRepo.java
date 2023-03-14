/**
 * @author  - Code Generator
 * @createdOn -  13-03-2023
 * @Description Entity class for AuthPer
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AuthPer;

@Repository
public interface AuthPerRepo extends JpaRepository<AuthPer, Integer> {

	public AuthPer findById(int id);

//	public List<Object> findByAuthPerIsActiveTrue();

	@Transactional
	@Modifying
	@Query(value = "UPDATE auth_permission SET is_active=false WHERE id = ?1", nativeQuery = true)
	public int deleteAuthPerByid(String id);

//	public List<Object> findAll(List<AuthPer> authperlist);

	

}
