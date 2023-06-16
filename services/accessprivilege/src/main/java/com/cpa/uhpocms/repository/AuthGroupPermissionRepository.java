package com.cpa.uhpocms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AuthGroupPermission;

@Repository
public interface AuthGroupPermissionRepository extends JpaRepository<AuthGroupPermission, Long> {
	// Retrieves a list of group permissions by role ID.
	List<AuthGroupPermission> findByRoleId(int roleId);

	// Retrieves a group permission by permission ID and role ID.
	AuthGroupPermission findByPermissionIdAndRoleId(Long permissionId, int roleId);

	List<AuthGroupPermission> findByPermissionId(Long permissionId);

	public int deleteGroupPermissionById(Long id);

	AuthGroupPermission findByRoleIdAndPermissionIdAndModuleId(int roleId, Long permissionId, Long moduleId);

	void deleteByRoleId(Long id);

	AuthGroupPermission findByRoleIdAndModuleIdAndPermissionId(int roleId, Long moduleId, Long permissionId);

}
