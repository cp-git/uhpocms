package com.cpa.uhpocms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AuthUserUserPermission;

@Repository
public interface AuthUserUserPermissionRepository extends JpaRepository<AuthUserUserPermission, Long> {
	// Retrieves a list of user permissions by user ID.
	List<AuthUserUserPermission> findByUserId(Long userId);

	// Retrieves a user permission by permission ID and user ID.
	AuthUserUserPermission findByPermissionIdAndUserId(Long permissionId, Long userId);

	List<AuthUserUserPermission> findByPermissionId(Long permissionId);

	public int deleteUserPermissionById(Long id);

	AuthUserUserPermission findByUserIdAndPermissionIdAndModuleId(Long userId, Long permissionId, Long moduleId);

	AuthUserUserPermission findByUserIdAndModuleIdAndPermissionId(Long userId, Long moduleId, Long permissionId);

}
