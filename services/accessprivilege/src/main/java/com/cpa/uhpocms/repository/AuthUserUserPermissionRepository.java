package com.cpa.uhpocms.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AuthUserUserPermission;
import com.cpa.uhpocms.entity.UserRoleIds;

@Repository
public interface AuthUserUserPermissionRepository extends JpaRepository<AuthUserUserPermission, Long> {

	public static final EntityManager entityManager = null;

	// Retrieves a list of user permissions by user ID.
	List<AuthUserUserPermission> findByUserId(Long userId);

	// Retrieves a user permission by permission ID and user ID.
	AuthUserUserPermission findByPermissionIdAndUserId(Long permissionId, Long userId);

	List<AuthUserUserPermission> findByPermissionId(Long permissionId);

	public int deleteUserPermissionById(Long id);

	AuthUserUserPermission findByUserIdAndPermissionIdAndModuleId(Long userId, Long permissionId, Long moduleId);

	AuthUserUserPermission findByUserIdAndModuleIdAndPermissionId(Long userId, Long moduleId, Long permissionId);

//	List<AuthUserUserPermission> findByUserId(Long userId);

	@Query(value = "SELECT DISTINCT userroleid AS roleId, user_id AS userId FROM instituteadmin_profile", nativeQuery = true)
	List<UserRoleIds> getDistinctRoleIdsAndUserIds();

	int deleteAllByUserId(Long userId);
}
