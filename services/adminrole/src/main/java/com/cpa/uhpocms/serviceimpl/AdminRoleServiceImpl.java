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
	 * @author : Kaushik
	 * @param : AdminRole
	 * @return :createdRole
	 * @description : For creating/save entry in adminrole table
	 */
	@Override
	public AdminRole saveAdminRole(AdminRole adminRole) {
		// TODO Auto-generated method stub
		logger.debug("Entering createRole");
		ArrayList<String> role = new ArrayList<String>();
		role.add("admin");
		role.add("coadmin");
		role.add("teacher");
		role.add("student");

		AdminRole createdRole = null;

		if (role.contains(adminRole.getRoleName())) {

			AdminRole checkAdminRole = adminRoleRepository.findByRoleName(adminRole.getRoleName());

			if (checkAdminRole == null) {
				adminRole.setCreatedBy("admin");
				adminRole.setModifiedBy("admin");
				createdRole = adminRoleRepository.save(adminRole);
			}
		}

		logger.info("created Role :" + createdRole);
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
	 * @author : Kaushik
	 * @param : AdminRole adminRole, String roleName
	 * @return : object
	 * @description : For updating entry in adminrole table
	 */
	@Override
	public AdminRole updateRoleNameByRoleName(AdminRole adminRole, String roleName) {
		// TODO Auto-generated method stub
		logger.debug("update role by role name");
		ArrayList<String> role = new ArrayList<String>();
		role.add("admin");
		role.add("coadmin");
		role.add("teacher");
		role.add("student");

		AdminRole updateRole = null;
		try {

			if (role.contains(roleName)) {

				AdminRole existingAdminRole = adminRoleRepository.findByRoleName(adminRole.getRoleName());

				if (existingAdminRole != null) {

					existingAdminRole.setRoleName(adminRole.getRoleName());
					existingAdminRole.setRoleDescription(adminRole.getRoleDescription());
					existingAdminRole.setActive(adminRole.isActive());
					updateRole = adminRoleRepository.save(existingAdminRole);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("---update role :" + updateRole);
		return updateRole;
	}

}
