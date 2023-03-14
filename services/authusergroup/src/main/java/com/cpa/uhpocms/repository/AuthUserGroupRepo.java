/**
 * @author  - Code Generator
 * @createdOn -  13-03-2023
 * @Description Entity class for AuthUserGroup
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AuthUserGroup;

@Repository
public interface AuthUserGroupRepo extends JpaRepository<AuthUserGroup, Integer> {

	public AuthUserGroup findById(int id);

	public List<Object> findByAuthUserGroupIsActiveTrue();

	@Transactional
	@Modifying
	@Query(value = "UPDATE auth_user_group SET is_active=false WHERE id = ?1", nativeQuery = true)
	public int deleteAuthUserGroupByid(String id);

}
