package com.cpa.uhpocms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cpa.uhpocms.entity.AdminRole;

@Repository
public interface AdminRoleRepository extends JpaRepository<AdminRole, String> {

	/**
	 * @author Kaushik
	 * @description : for getting active: true roles
	 * 
	 */
	boolean roleIsActive = true;


	//DELETE ADMIN ROLE BY NAME
	@Transactional
	@Modifying
	@Query(value = "UPDATE admin_role SET isactive=false WHERE role_name=?1", nativeQuery = true)
	int deleteByRoleName(String roleName);

	//GET ACTIVE ADMIN ROLE
	public List<Object> findByisActiveTrue();

	//FIND ADMIN ROLE BY ROLE NAME
	public AdminRole findByRoleName(String roleName);

	
	// GET INACTIVE ADMIN ROLE
	public List<Object> findByisActiveFalse();

	
	// ACTIVATE ADMIN ROLE BY ROLE ID
	@Transactional
	@Modifying
	@Query(value = "UPDATE admin_role SET isactive=true WHERE role_id=?1", nativeQuery = true)
	int activateRoleById(int roleId);

}
