package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.uhpocms.AdminRoleApplication;
import com.cpa.uhpocms.entity.AdminRole;
import com.cpa.uhpocms.repository.AdminRoleRepository;
import com.cpa.uhpocms.service.AdminRoleService;

@Service

public class AdminRoleServiceImpl implements AdminRoleService {

	@Autowired
	AdminRoleRepository adminRoleRepository;
	ResourceBundle resourceBundle;
	private static final Logger logger = Logger.getLogger(AdminRoleApplication.class);

	AdminRoleServiceImpl() {
		resourceBundle = ResourceBundle.getBundle("ErrorMessage", Locale.US);
	}

	/**
	 * @author : Akash
	 * @param : AdminRole
	 * @return :createdRole
	 * @description : For creating/save entry in adminrole table
	 */
	@Override
	public AdminRole saveAdminRole(AdminRole adminRole) {
		logger.debug("Entering createRole");
		AdminRole createdRole = null;

		adminRole.setCreatedBy("admin");
		adminRole.setModifiedBy("admin");

		String roleName = adminRole.getRoleName();
		if (roleName != null) {
			// Convert to lowercase and replace spaces with hyphens
			roleName = roleName.toLowerCase().replaceAll("\\s+", "-");
			 // Remove hyphen after the last word
	        roleName = roleName.replaceAll("-$", "");
			adminRole.setRoleName(roleName);
		}

		createdRole = adminRoleRepository.save(adminRole);

		logger.info("created Role: " + createdRole);
		return createdRole;
	}
	/**
	 * @author : Kaushik
	 * @return : adminrole
	 * @description : For get all the roles info
	 */
	@Override
	public List<Object> getAllAdminRole() {
		// TODO Auto-generated method stub
		logger.debug("Entering getAllAdminRole");
		List<Object> adminRole = new ArrayList<Object>(adminRoleRepository.findByisActiveTrue());

		logger.info("Fetched all active users :" + adminRole);
		return adminRole;
	}

	/**
	 * @author : Kaushik
	 * @param : String roleName
	 * @return : AdminRole
	 * @description : For soft deleting entry
	 */

	@Override
	public int deleteAdminRoleByRoleName(String roleName) {
		// TODO Auto-generated method stub
		logger.debug("Entering in delete role by role name");
		int adminRole = 0;

		adminRole = adminRoleRepository.deleteByRoleName(roleName);
		logger.info("Delete role by role name :" + adminRole);
		return adminRole;
	}

	/**
	 * @author : Kaushik
	 * @param : String roleName
	 * @return : method
	 * @description : For geting role details by role name
	 */
	@Override
	public AdminRole getRoleByRoleName(String roleName) {
		// TODO Auto-generated method stub
		AdminRole adminRole = null;
		logger.debug("getRoleByRoleName");
		adminRole = adminRoleRepository.findByRoleName(roleName);
		logger.info("Find Role by role name :" + adminRole);
		return adminRole;
	}

	/**
	 * @author : Akash
	 * @param : AdminRole adminRole, String roleName
	 * @return : object
	 * @description : For updating entry in adminrole table
	 */
	@Override
	public AdminRole updateRoleNameByRoleName(AdminRole adminRole) {
		// TODO Auto-generated method stub
		logger.debug("update role by role name");

		AdminRole RoleNamePresent = null;
		AdminRole updatedRole = null;

		RoleNamePresent = adminRoleRepository.findByRoleName(adminRole.getRoleName());

		if (RoleNamePresent != null) {

			RoleNamePresent.setRoleName(adminRole.getRoleName());
			RoleNamePresent.setRoleDescription(adminRole.getRoleDescription());
			RoleNamePresent.setActive(adminRole.isActive());
			updatedRole = adminRoleRepository.save(RoleNamePresent);
		}
		logger.info("---update role :" + updatedRole);
		return updatedRole;
	}
	/**
	 * @param : int roleId
	 * @return : int - count of updated /activated roles
	 * @description : For soft deleting entry
	 */

	@Override
	public int activateAdminRoleByRoleId(int roleId) {

		logger.debug("Entering in activateAdminRoleByRoleId");
		int adminRole = 0;

		adminRole = adminRoleRepository.activateRoleById(roleId);
		logger.info("activate role by role id :" + roleId);
		return adminRole;
	}

	/**
	 * @return : adminrole list
	 * @description : For get all the roles info
	 */
	@Override
	public List<Object> getAllInactiveAdminRoles() {
		// TODO Auto-generated method stub
		logger.debug("Entering getAllInactiveAdminRoles");
		List<Object> adminRole = new ArrayList<Object>(adminRoleRepository.findByisActiveFalse());

		logger.info("Fetched all inactive admin roles:" + adminRole);
		return adminRole;
	}

}
