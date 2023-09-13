package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.AdminRole;

public interface AdminRoleService {

	
	// INSERTING THE ADMIN ROLE
	AdminRole saveAdminRole(AdminRole adminRole);

	// GETTING ALL ADMIN ROLE
	List<Object> getAllAdminRole();

	// GET ADMIN ROLE BY NAME
	AdminRole getRoleByRoleName(String roleName);

	//DELETE ADMIN ROLE BY NAME
	int deleteAdminRoleByRoleName(String roleName);

	//UPDATE ADMIN ROLE 
	AdminRole updateRoleNameByRoleName(AdminRole adminRole);

	//ACTIVATE ADMIN ROLE BY ROLE ID
	int activateAdminRoleByRoleId(int roleId);

	//GET INACTIVE ADMIN ROLE
	List<Object> getAllInactiveAdminRoles();
}
