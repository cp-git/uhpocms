package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.uhpocms.entity.AuthGroupPermission;
import com.cpa.uhpocms.entity.AuthModule;
import com.cpa.uhpocms.entity.AuthPermission;
import com.cpa.uhpocms.entity.AuthUserUserPermission;
import com.cpa.uhpocms.entity.PermissionAssignment;
import com.cpa.uhpocms.entity.UserRoleIds;
import com.cpa.uhpocms.repository.AuthGroupPermissionRepository;
import com.cpa.uhpocms.repository.AuthGroupRepository;
import com.cpa.uhpocms.repository.AuthModuleRepository;
import com.cpa.uhpocms.repository.AuthPermissionRepository;
import com.cpa.uhpocms.repository.AuthUserGroupRepository;
import com.cpa.uhpocms.repository.AuthUserUserPermissionRepository;
import com.cpa.uhpocms.service.AuthService;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthPermissionRepository permissionRepository;

	@Autowired
	private AuthGroupRepository groupRepository;

	@Autowired
	private AuthGroupPermissionRepository groupPermissionRepository;

	@Autowired
	private AuthUserUserPermissionRepository userPermissionRepository;

	@Autowired
	private AuthUserGroupRepository userGroupRepository;

	@Autowired
	private AuthModuleRepository authModuleRepository;

	private static final Logger logger = LogManager.getLogger(AuthServiceImpl.class);

	// Rest of the methods go here...

	/**
	 * Creates a new permission.
	 *
	 * @param permission The AuthPermission object to be created.
	 * @return The created AuthPermission object.
	 */
	@Override
	public AuthPermission createPermission(AuthPermission permission) {
		return permissionRepository.save(permission);
	}

	/**
	 * Deletes a permission by its ID.
	 *
	 * @param permissionId The ID of the permission to be deleted.
	 * @return The deleted AuthPermission object, or null if not found.
	 */
	@Override
	public AuthPermission deletePermission(long permissionId) {
		Optional<AuthPermission> optionalPermission = permissionRepository.findById(permissionId);
		if (optionalPermission.isPresent()) {
			AuthPermission permission = optionalPermission.get();
			permissionRepository.delete(permission);
			return permission;
		}
		return null;
	}

	/**
	 * Retrieves all permissions.
	 *
	 * @return The list of all AuthPermission objects.
	 */
	@Override
	public List<AuthPermission> getAllPermissions() {
		return permissionRepository.findAll();
	}

	/**
	 * Retrieves all permissions.
	 *
	 * @return The list of all AuthPermission objects.
	 */
	@Override
	public List<AuthGroupPermission> getAllGroupPermissions() {
		return groupPermissionRepository.findAll();
	}

	/**
	 * Retrieves group permissions by role ID.
	 *
	 * @param roleId The ID of the role.
	 * @return The list of AuthGroupPermission objects associated with the role.
	 */
	@Override
	public List<AuthGroupPermission> getPermissionsByRoleId(Long roleId) {
		return groupPermissionRepository.findByRoleId(roleId);
	}

	/**
	 * Assigns permissions to a role.
	 *
	 * @param roleId      The ID of the role to assign permissions to.
	 * @param permissions A map containing module IDs as keys and a list of
	 *                    permission IDs as values.
	 * @return The list of assigned AuthGroupPermission objects.
	 */
	@Override
	public List<AuthGroupPermission> assignPermissionToRole(Long roleId, List<PermissionAssignment> permissions) {
		groupPermissionRepository.deleteAllByRoleId(roleId);

		List<AuthGroupPermission> assignedPermissions = new ArrayList<>();
		// Iterate over each permission request
		permissions.forEach(permissionRequest -> {
			Long moduleId = permissionRequest.getModuleId();
			List<Long> permissionIds = permissionRequest.getPermissionIds();
			// Iterate over each permission ID
			permissionIds.forEach(permissionId -> {
				// Create a new AuthUserUserPermission object
				AuthGroupPermission groupPermission = new AuthGroupPermission();
				groupPermission.setRoleId(roleId);
				groupPermission.setModuleId(moduleId);
				groupPermission.setPermissionId(permissionId);
				// Save the user permission to the database and add it to the list of assigned
				// permissions

//				AuthGroupPermission groupPermission = groupPermissionRepository
//						.findByRoleIdAndModuleIdAndPermissionId(roleId, moduleId, permissionId);

//				if (groupPermission == null) {
				assignedPermissions.add(groupPermissionRepository.save(groupPermission));
//				}

			});
		});

		return assignedPermissions; // Return the list of assigned AuthGroupPermission objects
	}

	/**
	 * Revokes permissions from a role.
	 *
	 * @param roleId      The ID of the role to revoke permissions from.
	 * @param permissions A map containing module IDs as keys and a list of
	 *                    permission IDs as values.
	 * @return The list of revoked AuthGroupPermission objects.
	 */
	public List<AuthGroupPermission> revokePermission(Long roleId, Map<Long, List<Long>> permissions) {
		List<AuthGroupPermission> revokedPermissions = new ArrayList<>();

		// Iterate over the module IDs and their corresponding permission IDs
		permissions.forEach((moduleId, permissionIds) -> {
			// Iterate over the permission IDs
			permissionIds.forEach(permissionId -> {
				// Find the existing AuthGroupPermission object based on role ID, module ID, and
				// permission ID
				AuthGroupPermission groupPermission = groupPermissionRepository
						.findByRoleIdAndModuleIdAndPermissionId(roleId, moduleId, permissionId);
				if (groupPermission != null) {
					groupPermissionRepository.delete(groupPermission); // Delete the group permission
					revokedPermissions.add(groupPermission); // Add the revoked group permission to the list
				}
			});
		});

		return revokedPermissions; // Return the list of revoked AuthGroupPermission objects
	}

	/**
	 * Checks if a role has a specific permission for a module.
	 *
	 * @param roleId       The ID of the role.
	 * @param permissionId The ID of the permission.
	 * @param moduleId     The ID of the module.
	 * @return true if the role has the permission for the module, false otherwise.
	 */
	@Override
	public boolean checkPermissionForRoleId(Long roleId, long permissionId, long moduleId) {
		AuthGroupPermission permission = groupPermissionRepository.findByRoleIdAndPermissionIdAndModuleId(roleId,
				permissionId, moduleId);
		return permission != null && permission.getModuleId() == moduleId;
	}

	/**
	 * Retrieves user permissions by user ID.
	 *
	 * @param userId The ID of the user.
	 * @return The list of AuthUserUserPermission objects associated with the user.
	 */
	@Override
	public List<AuthUserUserPermission> getPermissionsByUserId(long userId) {
		return userPermissionRepository.findByUserId(userId);
	}

	/**
	 * Assigns permissions to a user.
	 *
	 * @param userId      The ID of the user to assign permissions to.
	 * @param permissions A map containing module IDs as keys and a list of
	 *                    permission IDs as values.
	 * @return The list of assigned AuthUserUserPermission objects.
	 */
	@Override
	public List<AuthUserUserPermission> assignPermissionToUser(Long userId, Map<Long, List<Long>> permissions) {
		List<AuthUserUserPermission> assignedPermissions = new ArrayList<>();

		// Iterate over the module IDs and their corresponding permission IDs
		permissions.forEach((moduleId, permissionIds) -> {
			// Iterate over the permission IDs
			permissionIds.forEach(permissionId -> {
				// Create a new AuthUserUserPermission object
				AuthUserUserPermission userPermission = new AuthUserUserPermission();
				userPermission.setUserId(userId);
				userPermission.setModuleId(moduleId);
				userPermission.setPermissionId(permissionId);
				assignedPermissions.add(userPermissionRepository.save(userPermission)); // Save the user permission
			});
		});

		return assignedPermissions; // Return the list of assigned AuthUserUserPermission objects
	}

	/**
	 * Revokes permissions from a user.
	 *
	 * @param userId      The ID of the user to revoke permissions from.
	 * @param permissions A map containing module IDs as keys and a list of
	 *                    permission IDs as values.
	 * @return The list of revoked AuthUserUserPermission objects.
	 */
	public List<AuthUserUserPermission> revokePermissionFromUser(Long userId, Map<Long, List<Long>> permissions) {
		List<AuthUserUserPermission> revokedPermissions = new ArrayList<>();

		// Iterate over the module IDs and their corresponding permission IDs
		permissions.forEach((moduleId, permissionIds) -> {
			// Iterate over the permission IDs
			permissionIds.forEach(permissionId -> {
				// Find the user permission based on the user ID, module ID, and permission ID
				AuthUserUserPermission userPermission = userPermissionRepository
						.findByUserIdAndModuleIdAndPermissionId(userId, moduleId, permissionId);
				if (userPermission != null) {
					// Delete the user permission from the repository
					userPermissionRepository.delete(userPermission);
					// Add the revoked user permission to the list of revoked permissions
					revokedPermissions.add(userPermission);
				}
			});
		});

		return revokedPermissions; // Return the list of revoked AuthUserUserPermission objects
	}

	/**
	 * Checks if a user has a specific permission for a module.
	 *
	 * @param userId       The ID of the user.
	 * @param permissionId The ID of the permission.
	 * @param moduleId     The ID of the module.
	 * @return true if the user has the permission for the module, false otherwise.
	 */
	@Override
	public boolean checkPermissionForUserId(long userId, long permissionId, long moduleId) {
		AuthUserUserPermission permission = userPermissionRepository.findByUserIdAndPermissionIdAndModuleId(userId,
				permissionId, moduleId);
		return permission != null && permission.getModuleId() == moduleId;
	}

	/**
	 * Adds a new module.
	 *
	 * @param module The AuthModule object to be added.
	 * @return The added AuthModule object.
	 */
	@Override
	public AuthModule addModule(AuthModule module) {
		return authModuleRepository.save(module);
	}

	/**
	 * Deletes a module by its ID.
	 *
	 * @param moduleId The ID of the module to be deleted.
	 * @return The deleted AuthModule object, or null if not found.
	 */
	@Override
	public AuthModule deleteModule(long moduleId) {
		Optional<AuthModule> optionalModule = authModuleRepository.findById(moduleId);
		if (optionalModule.isPresent()) {
			AuthModule module = optionalModule.get();
			authModuleRepository.delete(module);
			return module;
		}
		return null;
	}

	/**
	 * Retrieves all modules.
	 *
	 * @return The list of all AuthModule objects.
	 */
	@Override
	public List<AuthModule> getAllModules() {
		return authModuleRepository.findAll();
	}

	/**
	 * Retrieves permissions by user ID and role ID.
	 *
	 * @param userId The ID of the user.
	 * @param roleId The ID of the role.
	 * @return The list of AuthPermission objects associated with the user and role.
	 */
	@Override
	public List<AuthUserUserPermission> getUserPermissionsByUserIdAndRoleId(Long userId, Long roleId) {

		List<AuthUserUserPermission> userPermissions = userPermissionRepository.findByUserId(userId);

		List<AuthGroupPermission> groupPermissions = groupPermissionRepository.findByRoleId(roleId);

		List<AuthUserUserPermission> userAndGroupPermissions = new ArrayList<>(userPermissions);

//		for (AuthGroupPermission perm : userPermissions) {
//			userAndGroupPermissions.add(perm);
//		}
		AuthUserUserPermission userPermission = null;
		for (AuthGroupPermission perm : groupPermissions) {

			userPermission = new AuthUserUserPermission();
			userPermission.setUserId(userId);
			userPermission.setPermissionId(perm.getPermissionId());
			userPermission.setModuleId(perm.getModuleId());
			userPermission.setRoleId(roleId);
			userAndGroupPermissions.add(userPermission);
		}
		System.out.println(userAndGroupPermissions);

		return userAndGroupPermissions;

	}

	/**
	 * Retrieves all permissions.
	 *
	 * @return The list of all AuthPermission objects.
	 */
	@Override
	public List<Object> getAllUserPermissions() {

		List<AuthUserUserPermission> userPermissions = userPermissionRepository.findAll();

		List<UserRoleIds> userRoleIds = userPermissionRepository.getDistinctRoleIdsAndUserIds();
		System.out.println(userRoleIds);

//		List<UserRoleIds> groupRoleIds = groupPermissionRepository.getDistinctRoleIds();
//		System.out.println("here" + groupRoleIds);
		List<AuthGroupPermission> groupPermissions = groupPermissionRepository.findAll();

		List<AuthUserUserPermission> allUserPermissions = new ArrayList<>();

		allUserPermissions.addAll(userPermissions);

		for (UserRoleIds result : userRoleIds) {

			Long roleId = result.getRoleId();
			Long userId = result.getUserId();
			System.out.println("Role ID: " + roleId + ", User ID: " + userId);

			List<AuthGroupPermission> filteredPermissions = groupPermissions.stream()
					.filter(groupPerm -> groupPerm.getRoleId() == roleId).collect(Collectors.toList());

			System.out.println("filetr " + filteredPermissions);

			AuthUserUserPermission userPermission = null;
			for (AuthGroupPermission perm : filteredPermissions) {

				userPermission = new AuthUserUserPermission();
				userPermission.setUserId(userId);
				userPermission.setPermissionId(perm.getPermissionId());
				userPermission.setModuleId(perm.getModuleId());
				userPermission.setRoleId(roleId);
				allUserPermissions.add(userPermission);
			}
			System.out.println("semi final " + allUserPermissions);
		}
		System.out.println("final " + allUserPermissions);

		List<Object> objectAllUserPermissions = new ArrayList<>(allUserPermissions);
		return objectAllUserPermissions;
	}

	/**
	 * Assigns permissions to a user.
	 *
	 * @param userId      The ID of the user to assign permissions to.
	 * @param roleId      The ID of the role associated with the user.
	 * @param permissions The list of PermissionRequest objects containing module
	 *                    IDs and permission IDs.
	 * @return The list of assigned AuthUserUserPermission objects.
	 */
	public List<AuthUserUserPermission> assignPermissionToUser(Long userId, Long roleId,
			List<PermissionAssignment> permissions) {
		userPermissionRepository.deleteAllByUserId(userId);

		List<AuthUserUserPermission> assignedPermissions = new ArrayList<>();
		// Iterate over each permission request
		permissions.forEach(permissionRequest -> {
			Long moduleId = permissionRequest.getModuleId();
			List<Long> permissionIds = permissionRequest.getPermissionIds();
			// Iterate over each permission ID
			permissionIds.forEach(permissionId -> {
				// Create a new AuthUserUserPermission object
				AuthUserUserPermission userPermission = new AuthUserUserPermission();
				userPermission.setUserId(userId);
				userPermission.setRoleId(roleId);
				userPermission.setModuleId(moduleId);
				userPermission.setPermissionId(permissionId);
				// Save the user permission to the database and add it to the list of assigned
				// permissions

				AuthGroupPermission groupPermission = groupPermissionRepository
						.findByRoleIdAndModuleIdAndPermissionId(roleId, moduleId, permissionId);

				if (groupPermission == null) {
					assignedPermissions.add(userPermissionRepository.save(userPermission));
				}

			});
		});
		return assignedPermissions;
	}
}
