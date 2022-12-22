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

	/**
	 * @author Kaushik
	 * @param : String roleName
	 * @description : For Soft delete record
	 * 
	 */
	@Transactional
	@Modifying
	@Query(value = "UPDATE admin_role SET isactive=false WHERE rolename=?1", nativeQuery = true)
	int deleteByRoleName(String roleName);

	public List<Object> findByisActiveTrue();

	/**
	 * @author Kaushik
	 * @param : String roleName
	 * @description : For finding role by role name
	 * 
	 */
	public AdminRole findByRoleName(String roleName);

}
