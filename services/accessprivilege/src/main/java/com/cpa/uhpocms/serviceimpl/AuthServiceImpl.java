package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.uhpocms.entity.AuthGroupPermission;
import com.cpa.uhpocms.entity.AuthModule;
import com.cpa.uhpocms.entity.AuthPermission;
import com.cpa.uhpocms.entity.AuthUserUserPermission;
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

	@Override
	public AuthPermission createPermission(AuthPermission permission) {
		return permissionRepository.save(permission);
	}

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

	@Override
	public List<AuthPermission> getAllPermissions() {
		return permissionRepository.findAll();
	}

	@Override
	public List<AuthGroupPermission> getPermissionsByRoleId(int roleId) {
		return groupPermissionRepository.findByRoleId(roleId);
	}

	@Override
	public List<AuthGroupPermission> assignPermissionToRole(int roleId, Map<Long, List<Long>> permissions) {
		List<AuthGroupPermission> assignedPermissions = new ArrayList<>();

		permissions.forEach((moduleId, permissionIds) -> {
			permissionIds.forEach(permissionId -> {
				AuthGroupPermission groupPermission = new AuthGroupPermission();
				groupPermission.setRoleId(roleId);
				groupPermission.setModuleId(moduleId);
				groupPermission.setPermissionId(permissionId);
				assignedPermissions.add(groupPermissionRepository.save(groupPermission));
			});
		});

		return assignedPermissions;
	}

	public List<AuthGroupPermission> revokePermission(int roleId, Map<Long, List<Long>> permissions) {
		List<AuthGroupPermission> revokedPermissions = new ArrayList<>();

		permissions.forEach((moduleId, permissionIds) -> {
			permissionIds.forEach(permissionId -> {
				AuthGroupPermission groupPermission = groupPermissionRepository
						.findByRoleIdAndModuleIdAndPermissionId(roleId, moduleId, permissionId);
				if (groupPermission != null) {
					groupPermissionRepository.delete(groupPermission);
					revokedPermissions.add(groupPermission);
				}
			});
		});

		return revokedPermissions;
	}

	@Override
	public boolean checkPermissionForRoleId(int roleId, long permissionId, long moduleId) {
		AuthGroupPermission permission = groupPermissionRepository.findByRoleIdAndPermissionIdAndModuleId(roleId,
				permissionId, moduleId);
		return permission != null && permission.getModuleId() == moduleId;
	}

	@Override
	public List<AuthUserUserPermission> getPermissionsByUserId(long userId) {
		return userPermissionRepository.findByUserId(userId);
	}

	@Override
	public List<AuthUserUserPermission> assignPermissionToUser(Long userId, Map<Long, List<Long>> permissions) {
		List<AuthUserUserPermission> assignedPermissions = new ArrayList<>();

		permissions.forEach((moduleId, permissionIds) -> {
			permissionIds.forEach(permissionId -> {
				AuthUserUserPermission userPermission = new AuthUserUserPermission();
				userPermission.setUserId(userId);
				userPermission.setModuleId(moduleId);
				userPermission.setPermissionId(permissionId);
				assignedPermissions.add(userPermissionRepository.save(userPermission));
			});
		});

		return assignedPermissions;
	}

	public List<AuthUserUserPermission> revokePermissionFromUser(Long userId, Map<Long, List<Long>> permissions) {
		List<AuthUserUserPermission> revokedPermissions = new ArrayList<>();

		permissions.forEach((moduleId, permissionIds) -> {
			permissionIds.forEach(permissionId -> {
				AuthUserUserPermission userPermission = userPermissionRepository
						.findByUserIdAndModuleIdAndPermissionId(userId, moduleId, permissionId);
				if (userPermission != null) {
					userPermissionRepository.delete(userPermission);
					revokedPermissions.add(userPermission);
				}
			});
		});

		return revokedPermissions;
	}

	@Override
	public boolean checkPermissionForUserId(long userId, long permissionId, long moduleId) {
		AuthUserUserPermission permission = userPermissionRepository.findByUserIdAndPermissionIdAndModuleId(userId,
				permissionId, moduleId);
		return permission != null && permission.getModuleId() == moduleId;
	}

	@Override
	public AuthModule addModule(AuthModule module) {
		return authModuleRepository.save(module);
	}

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

	@Override
	public List<AuthModule> getAllModules() {
		return authModuleRepository.findAll();
	}

	@Override
	public List<AuthPermission> getPermissionsByUserIdAndRoleId(Long userId, Long roleId) {
		// TODO Auto-generated method stub
		return permissionRepository.findPermissionByUserIdAndRoleId(userId, roleId);
	}

}
