package com.cpa.uhpocms.service;

import java.util.List;
import java.util.Map;

import com.cpa.uhpocms.entity.AuthGroupPermission;
import com.cpa.uhpocms.entity.AuthModule;
import com.cpa.uhpocms.entity.AuthPermission;
import com.cpa.uhpocms.entity.AuthUserUserPermission;

public interface AuthService {

	AuthPermission createPermission(AuthPermission permission);

	AuthPermission deletePermission(long permissionId);

	List<AuthPermission> getAllPermissions();

	List<AuthGroupPermission> getPermissionsByRoleId(int roleId);

	List<AuthGroupPermission> assignPermissionToRole(int roleId, Map<Long, List<Long>> permissions);

	List<AuthGroupPermission> revokePermission(int roleId, Map<Long, List<Long>> permissions);

	boolean checkPermissionForRoleId(int roleId, long permissionId, long moduleId);

	List<AuthUserUserPermission> getPermissionsByUserId(long userId);

	List<AuthUserUserPermission> assignPermissionToUser(Long userId, Map<Long, List<Long>> permissions);

	List<AuthUserUserPermission> revokePermissionFromUser(Long userId, Map<Long, List<Long>> permissions);

	boolean checkPermissionForUserId(long userId, long permissionId, long moduleId);

	List<AuthPermission> getPermissionsByUserIdAndRoleId(Long userId, Long roleId);

	AuthModule addModule(AuthModule module);

	AuthModule deleteModule(long moduleId);

	List<AuthModule> getAllModules();
}
