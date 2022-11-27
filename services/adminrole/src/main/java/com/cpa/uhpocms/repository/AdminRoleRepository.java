package com.cpa.uhpocms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cpa.uhpocms.entity.AdminRole;

@Repository
public interface AdminRoleRepository extends JpaRepository<AdminRole, String> {

	boolean roleIsActive = true;

	/// for soft delete
	@Transactional
	@Modifying
	@Query(value = "UPDATE admin_role SET isactive=false WHERE role_name=?1", nativeQuery = true)
	int deleteByRoleName(String roleName);

	/// For finding role by role name
	public AdminRole findByRoleName(String roleName);

//	@Query(value = "SELECT a.roleId,a.isActive,a.roleDescription,a.createdBy,a.createdOn,a.modifiedBy,a.modifiedOn FROM AdminRole a where a.roleName= ?1")
//	AdminRole updateroleNameByRoleName(String roleName);

}
