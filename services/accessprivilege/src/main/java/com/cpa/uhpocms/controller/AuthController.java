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

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/permissions")
	public ResponseEntity<AuthPermission> createPermission(@RequestBody AuthPermission permission) {
		AuthPermission createdPermission = authService.createPermission(permission);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdPermission);
	}

	@DeleteMapping("/permissions/{permissionId}")
	public ResponseEntity<AuthPermission> deletePermission(@PathVariable long permissionId) {
		AuthPermission deletedPermission = authService.deletePermission(permissionId);
		if (deletedPermission != null) {
			return ResponseEntity.ok(deletedPermission);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

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

	@PostMapping("/role/{roleId}")
	public ResponseEntity<List<AuthGroupPermission>> assignPermissionToRole(@PathVariable("roleId") int roleId,
			@RequestBody Map<Long, List<Long>> permissions) {
		List<AuthGroupPermission> assignedPermissions = authService.assignPermissionToRole(roleId, permissions);
		return ResponseEntity.ok(assignedPermissions);
	}

	@DeleteMapping("/role/{roleId}")
	public ResponseEntity<String> revokePermissionFromRole(@PathVariable("roleId") int roleId,
			@RequestBody Map<Long, List<Long>> permissions) {
		authService.revokePermission(roleId, permissions);
		return ResponseEntity.ok("Permissions revoked successfully");
	}

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

	@PostMapping("/users/{userId}")
	public ResponseEntity<List<AuthUserUserPermission>> assignPermissionToUser(@PathVariable("userId") Long userId,
			@RequestBody Map<Long, List<Long>> permissions) {
		List<AuthUserUserPermission> assignedPermissions = authService.assignPermissionToUser(userId, permissions);
		return ResponseEntity.ok(assignedPermissions);
	}

	@DeleteMapping("/user/{userId}")
	public ResponseEntity<List<AuthUserUserPermission>> revokePermissionFromUser(@PathVariable("userId") Long userId,
			@RequestBody Map<Long, List<Long>> permissions) {
		List<AuthUserUserPermission> revokedPermissions = authService.revokePermissionFromUser(userId, permissions);
		return ResponseEntity.ok(revokedPermissions);
	}

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

	@GetMapping("/permissions")
	public ResponseEntity<List<AuthPermission>> getPermissionsByUserIdAndRoleId(@RequestParam("userId") Long userId,
			@RequestParam("roleId") Long roleId) {

		List<AuthPermission> permissions = authService.getPermissionsByUserIdAndRoleId(userId, roleId);
		return ResponseEntity.ok(permissions);
	}

	// Exception handling

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		logger.error("An error occurred", e);
		return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
