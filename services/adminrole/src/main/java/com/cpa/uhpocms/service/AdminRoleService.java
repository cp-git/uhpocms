package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.AdminRole;

public interface AdminRoleService {

	AdminRole saveAdminRole(AdminRole adminRole);

	List<Object> getAllAdminRole();

	AdminRole getRoleByRoleName(String roleName);

	int deleteAdminRoleByRoleName(String roleName);

	AdminRole updateRoleNameByRoleName(AdminRole adminRole, String roleName);
}
