package com.cpa.uhpocms.service;

import java.util.List;
import java.util.Map;

import com.cpa.uhpocms.entity.AuthGroupPermission;
import com.cpa.uhpocms.entity.AuthModule;
import com.cpa.uhpocms.entity.AuthPermission;
import com.cpa.uhpocms.entity.AuthUserUserPermission;

public interface AuthService {

	/**
	 * Creates a new permission.
	 *
	 * @param permission The AuthPermission object to be created.
	 * @return The created AuthPermission object.
	 */
	AuthPermission createPermission(AuthPermission permission);

	/**
	 * Deletes a permission by its ID.
	 *
	 * @param permissionId The ID of the permission to be deleted.
	 * @return The deleted AuthPermission object, or null if not found.
	 */
	AuthPermission deletePermission(long permissionId);

	/**
	 * Retrieves all permissions.
	 *
	 * @return The list of all AuthPermission objects.
	 */
	List<AuthPermission> getAllPermissions();

	/**
	 * Retrieves permissions by role ID.
	 *
	 * @param roleId The ID of the role.
	 * @return The list of AuthGroupPermission objects associated with the role.
	 */
	List<AuthGroupPermission> getPermissionsByRoleId(int roleId);

	/**
	 * Assigns permissions to a role.
	 *
	 * @param roleId      The ID of the role to assign permissions to.
	 * @param permissions A map containing module IDs as keys and a list of
	 *                    permission IDs as values.
	 * @return The list of assigned AuthGroupPermission objects.
	 */
	List<AuthGroupPermission> assignPermissionToRole(int roleId, Map<Long, List<Long>> permissions);

	/**
	 * Revokes permissions from a role.
	 *
	 * @param roleId      The ID of the role to revoke permissions from.
	 * @param permissions A map containing module IDs as keys and a list of
	 *                    permission IDs as values.
	 * @return The list of revoked AuthGroupPermission objects.
	 */
	List<AuthGroupPermission> revokePermission(int roleId, Map<Long, List<Long>> permissions);

	/**
	 * Checks if a role has a specific permission for a module.
	 *
	 * @param roleId       The ID of the role.
	 * @param permissionId The ID of the permission.
	 * @param moduleId     The ID of the module.
	 * @return true if the role has the permission for the module, false otherwise.
	 */
	boolean checkPermissionForRoleId(int roleId, long permissionId, long moduleId);

	/**
	 * Retrieves user permissions by user ID.
	 *
	 * @param userId The ID of the user.
	 * @return The list of AuthUserUserPermission objects associated with the user.
	 */
	List<AuthUserUserPermission> getPermissionsByUserId(long userId);

	/**
	 * Assigns permissions to a user.
	 *
	 * @param userId      The ID of the user to assign permissions to.
	 * @param permissions A map containing module IDs as keys and a list of
	 *                    permission IDs as values.
	 * @return The list of assigned AuthUserUserPermission objects.
	 */
	List<AuthUserUserPermission> assignPermissionToUser(Long userId, Map<Long, List<Long>> permissions);

	/**
	 * Revokes permissions from a user.
	 *
	 * @param userId      The ID of the user to revoke permissions from.
	 * @param permissions A map containing module IDs as keys and a list of
	 *                    permission IDs as values.
	 * @return The list of revoked AuthUserUserPermission objects.
	 */
	List<AuthUserUserPermission> revokePermissionFromUser(Long userId, Map<Long, List<Long>> permissions);

	/**
	 * Checks if a user has a specific permission for a module.
	 *
	 * @param userId       The ID of the user.
	 * @param permissionId The ID of the permission.
	 * @param moduleId     The ID of the module.
	 * @return true if the user has the permission for the module, false otherwise.
	 */
	boolean checkPermissionForUserId(long userId, long permissionId, long moduleId);

	/**
	 * Retrieves permissions by user ID and role ID.
	 *
	 * @param userId The ID of the user.
	 * @param roleId The ID of the role.
	 * @return The list of AuthPermission objects associated with the user and role.
	 */
	List<AuthPermission> getPermissionsByUserIdAndRoleId(Long userId, Long roleId);

	/**
	 * Adds a new module.
	 *
	 * @param module The AuthModule object to be added.
	 * @return The added AuthModule object.
	 */
	AuthModule addModule(AuthModule module);

	/**
	 * Deletes a module by its ID.
	 *
	 * @param moduleId The ID of the module to be deleted.
	 * @return The deleted AuthModule object, or null if not found.
	 */
	AuthModule deleteModule(long moduleId);

	/**
	 * Retrieves all modules.
	 *
	 * @return The list of all AuthModule objects.
	 */
	List<AuthModule> getAllModules();
}
