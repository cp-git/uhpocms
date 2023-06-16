/**
 * Controller class for AuthController
 */
package com.cpa.uhpocms.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.uhpocms.entity.AuthGroupPermission;
import com.cpa.uhpocms.entity.AuthModule;
import com.cpa.uhpocms.entity.AuthPermission;
import com.cpa.uhpocms.entity.AuthUserUserPermission;
import com.cpa.uhpocms.service.AuthService;

@RestController
@RequestMapping("/uhpocms")
@CrossOrigin
public class AuthController {
	private static final Logger logger = LogManager.getLogger(AuthController.class);

	@Autowired
	private final AuthService authService;

	/**
	 * Constructor injection for AuthService.
	 *
	 * @param authService The AuthService implementation.
	 */
	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	/**
	 * Creates a new permission.
	 *
	 * @param permission The AuthPermission object to be created.
	 * @return ResponseEntity containing the created AuthPermission object and HTTP
	 *         status code.
	 */
	@PostMapping("/permissions")
	public ResponseEntity<AuthPermission> createPermission(@RequestBody AuthPermission permission) {
		AuthPermission createdPermission = authService.createPermission(permission);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdPermission);
	}

	/**
	 * Deletes a permission by its ID.
	 *
	 * @param permissionId The ID of the permission to be deleted.
	 * @return ResponseEntity containing the deleted AuthPermission object and HTTP
	 *         status code.
	 */
	@DeleteMapping("/permissions/{permissionId}")
	public ResponseEntity<AuthPermission> deletePermission(@PathVariable long permissionId) {
		AuthPermission deletedPermission = authService.deletePermission(permissionId);
		if (deletedPermission != null) {
			return ResponseEntity.ok(deletedPermission);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	/**
	 * Retrieves all permissions.
	 *
	 * @return ResponseEntity containing the list of AuthPermission objects and HTTP
	 *         status code.
	 */
	@GetMapping("/permission")
	public ResponseEntity<List<AuthPermission>> getAllPermissions() {
		try {
			List<AuthPermission> permissions = authService.getAllPermissions();
			return new ResponseEntity<>(permissions, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error occurred while retrieving permissions", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Retrieves permissions by role ID.
	 *
	 * @param roleId The ID of the role.
	 * @return ResponseEntity containing the list of AuthGroupPermission objects and
	 *         HTTP status code.
	 */
	@GetMapping("/permissions/role/{roleId}")
	public ResponseEntity<List<AuthGroupPermission>> getPermissionsByRoleId(@PathVariable int roleId) {
		try {
			List<AuthGroupPermission> permissions = authService.getPermissionsByRoleId(roleId);
			return new ResponseEntity<>(permissions, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error occurred while retrieving permissions by role ID", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Assigns permissions to a role.
	 *
	 * @param roleId      The ID of the role.
	 * @param permissions Map of permission IDs to module IDs.
	 * @return ResponseEntity containing the list of assigned AuthGroupPermission
	 *         objects and HTTP status code.
	 */
	@PostMapping("/role/{roleId}")
	public ResponseEntity<List<AuthGroupPermission>> assignPermissionToRole(@PathVariable("roleId") int roleId,
			@RequestBody Map<Long, List<Long>> permissions) {
		List<AuthGroupPermission> assignedPermissions = authService.assignPermissionToRole(roleId, permissions);
		return ResponseEntity.ok(assignedPermissions);
	}

	/**
	 * Revokes permissions from a role.
	 *
	 * @param roleId      The ID of the role.
	 * @param permissions Map of permission IDs to module IDs.
	 * @return ResponseEntity containing a success message and HTTP status code.
	 */
	@DeleteMapping("/role/{roleId}")
	public ResponseEntity<String> revokePermissionFromRole(@PathVariable("roleId") int roleId,
			@RequestBody Map<Long, List<Long>> permissions) {
		authService.revokePermission(roleId, permissions);
		return ResponseEntity.ok("Permissions revoked successfully");
	}

	/**
	 * Checks if a role has a specific permission for a module.
	 *
	 * @param roleId       The ID of the role.
	 * @param permissionId The ID of the permission.
	 * @param moduleId     The ID of the module.
	 * @return ResponseEntity containing a boolean indicating if the role has the
	 *         permission and HTTP status code.
	 */
	@GetMapping("/role/{roleId}/permission/{permissionId}/module/{moduleId}")
	public ResponseEntity<Boolean> checkPermissionForRoleId(@PathVariable int roleId, @PathVariable long permissionId,
			@PathVariable long moduleId) {
		try {
			boolean hasPermission = authService.checkPermissionForRoleId(roleId, permissionId, moduleId);
			return new ResponseEntity<>(hasPermission, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error occurred while checking permission for role ID", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Retrieves permissions by user ID.
	 *
	 * @param userId The ID of the user.
	 * @return ResponseEntity containing the list of AuthUserUserPermission objects
	 *         and HTTP status code.
	 */
	@GetMapping("/permissions/user/{userId}")
	public ResponseEntity<List<AuthUserUserPermission>> getPermissionsByUserId(@PathVariable long userId) {
		try {
			List<AuthUserUserPermission> permissions = authService.getPermissionsByUserId(userId);
			return new ResponseEntity<>(permissions, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error occurred while retrieving permissions by user ID", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Assigns permissions to a user.
	 *
	 * @param userId      The ID of the user.
	 * @param permissions Map of permission IDs to module IDs.
	 * @return ResponseEntity containing the list of assigned AuthUserUserPermission
	 *         objects and HTTP status code.
	 */
	@PostMapping("/users/{userId}")
	public ResponseEntity<List<AuthUserUserPermission>> assignPermissionToUser(@PathVariable("userId") Long userId,
			@RequestBody Map<Long, List<Long>> permissions) {
		List<AuthUserUserPermission> assignedPermissions = authService.assignPermissionToUser(userId, permissions);
		return ResponseEntity.ok(assignedPermissions);
	}

	/**
	 * Revokes permissions from a user.
	 *
	 * @param userId      The ID of the user.
	 * @param permissions Map of permission IDs to module IDs.
	 * @return ResponseEntity containing the list of revoked AuthUserUserPermission
	 *         objects and HTTP status code.
	 */
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<List<AuthUserUserPermission>> revokePermissionFromUser(@PathVariable("userId") Long userId,
			@RequestBody Map<Long, List<Long>> permissions) {
		List<AuthUserUserPermission> revokedPermissions = authService.revokePermissionFromUser(userId, permissions);
		return ResponseEntity.ok(revokedPermissions);
	}

	/**
	 * Checks if a user has a specific permission for a module.
	 *
	 * @param userId       The ID of the user.
	 * @param permissionId The ID of the permission.
	 * @param moduleId     The ID of the module.
	 * @return ResponseEntity containing a boolean indicating if the user has the
	 *         permission and HTTP status code.
	 */
	@GetMapping("/user/{userId}/permission/{permissionId}/module/{moduleId}")
	public ResponseEntity<Boolean> checkPermissionForUserId(@PathVariable long userId, @PathVariable long permissionId,
			@PathVariable long moduleId) {
		try {
			boolean hasPermission = authService.checkPermissionForUserId(userId, permissionId, moduleId);
			return new ResponseEntity<>(hasPermission, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error occurred while checking permission for user ID", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Adds a new module.
	 *
	 * @param module The AuthModule object to be added.
	 * @return ResponseEntity containing the added AuthModule object and HTTP status
	 *         code.
	 */
	@PostMapping("/module")
	public ResponseEntity<AuthModule> addModule(@RequestBody AuthModule module) {
		try {
			AuthModule addedModule = authService.addModule(module);
			return new ResponseEntity<>(addedModule, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Error occurred while adding module", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Deletes a module by its ID.
	 *
	 * @param moduleId The ID of the module to be deleted.
	 * @return ResponseEntity containing the deleted AuthModule object and HTTP
	 *         status code.
	 */
	@DeleteMapping("/module/{moduleId}")
	public ResponseEntity<AuthModule> deleteModule(@PathVariable long moduleId) {
		try {
			AuthModule deletedModule = authService.deleteModule(moduleId);
			if (deletedModule != null) {
				return new ResponseEntity<>(deletedModule, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Error occurred while deleting module", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Retrieves all modules.
	 *
	 * @return ResponseEntity containing the list of AuthModule objects and HTTP
	 *         status code.
	 */
	@GetMapping("/modules")
	public ResponseEntity<List<AuthModule>> getAllModules() {
		try {
			List<AuthModule> modules = authService.getAllModules();
			return new ResponseEntity<>(modules, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error occurred while retrieving modules", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Retrieves permissions by user ID and role ID.
	 *
	 * @param userId The ID of the user.
	 * @param roleId The ID of the role.
	 * @return ResponseEntity containing the list of AuthPermission objects and HTTP
	 *         status code.
	 */
	@GetMapping("/permissions")
	public ResponseEntity<List<AuthPermission>> getPermissionsByUserIdAndRoleId(@RequestParam("userId") Long userId,
			@RequestParam("roleId") Long roleId) {

		List<AuthPermission> permissions = authService.getPermissionsByUserIdAndRoleId(userId, roleId);
		return ResponseEntity.ok(permissions);
	}

	// Exception handling

	/**
	 * Exception handler for handling exceptions thrown by the controller.
	 *
	 * @param ex The exception object.
	 * @return ResponseEntity containing the error message and HTTP status code.
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		logger.error("Exception occurred in AuthController", ex);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
	}
}
