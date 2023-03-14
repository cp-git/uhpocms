/**
 * @author  - Code Generator
 * @createdOn -  13-03-2023
 * @Description Entity class for AuthUserPer
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AuthUserPer;

@Repository
public interface AuthUserPerRepo extends JpaRepository<AuthUserPer, Integer> {

	public AuthUserPer findById(int id);

	public List<Object> findByAuthUserPerIsActiveTrue();

	@Transactional
	@Modifying
	@Query(value = "UPDATE auth_user_user_permissions SET is_active=false WHERE id = ?1", nativeQuery = true)
	public int deleteAuthUserPerByid(String id);

}
