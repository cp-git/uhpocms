package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AuthPermission;

@Repository
public interface AuthPermissionRepository extends JpaRepository<AuthPermission, Long> {

	AuthPermission findByName(String name);

	@Transactional
	@Modifying
	@Query(value = "SELECT * FROM public.auth_permission where id IN (SELECT uup.id FROM auth_user_user_permissions uup WHERE uup.userid = ?1 UNION SELECT agp.permissionId FROM auth_group_permissions agp WHERE agp.roleid = ?2)", nativeQuery = true)
	List<AuthPermission> findPermissionByUserIdAndRoleId(Long userId, Long roleId);

	AuthPermission findById(int id);
}
