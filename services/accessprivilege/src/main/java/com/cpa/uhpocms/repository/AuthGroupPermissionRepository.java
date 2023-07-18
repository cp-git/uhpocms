
package com.cpa.uhpocms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AuthGroupPermission;
import com.cpa.uhpocms.entity.UserRoleIds;

@Repository
public interface AuthGroupPermissionRepository extends JpaRepository<AuthGroupPermission, Long> {
	// Retrieves a list of group permissions by role ID.
	List<AuthGroupPermission> findByRoleId(Long roleId);

	// Retrieves a group permission by permission ID and role ID.
	AuthGroupPermission findByPermissionIdAndRoleId(Long permissionId, int roleId);

	List<AuthGroupPermission> findByPermissionId(Long permissionId);

	public int deleteGroupPermissionById(Long id);

	AuthGroupPermission findByRoleIdAndPermissionIdAndModuleId(Long roleId, Long permissionId, Long moduleId);

	void deleteByRoleId(Long id);

	AuthGroupPermission findByRoleIdAndModuleIdAndPermissionId(Long roleId, Long moduleId, Long permissionId);

	int deleteAllByRoleId(Long roleId);

	@Query(value = "SELECT DISTINCT roleid AS roleId FROM auth_group_permissions", nativeQuery = true)
	List<UserRoleIds> getDistinctRoleIds();
}
