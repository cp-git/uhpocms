package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.AdminRole;

public interface AdminRoleService {

	AdminRole saveAdminRole(AdminRole adminRole);

	List<Object> fetchallAdminRole();

	AdminRole getRoleByRoleName(String roleName);

	int deleteAdminRolebyRoleName(String roleName);

	AdminRole updateRoleNamebyRoleName(AdminRole adminRole, String roleName);
}
