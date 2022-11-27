package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.uhpocms.controller.AdminRoleController;
import com.cpa.uhpocms.entity.AdminRole;
import com.cpa.uhpocms.repository.AdminRoleRepository;
import com.cpa.uhpocms.service.AdminRoleService;

@Service

public class AdminRoleServiceImpl implements AdminRoleService {

	@Autowired
	AdminRoleRepository adminroleRepository;
	AdminRoleController adminrolecontroller;

	/**
	 * @author : Kaushik
	 * @param : AdminRole
	 * @return : AuthUser createdRole
	 * @description : For creating/save entry in adminrole table
	 */
	@Override
	public AdminRole saveAdminRole(AdminRole adminRole) {
		// TODO Auto-generated method stub
		ArrayList<String> Role = new ArrayList<String>();
		Role.add("admin");
		Role.add("coadmin");
		Role.add("teacher");
		Role.add("student");
		// System.out.println(Role);

		AdminRole createdRole = null;

		try {

			if (Role.contains(adminRole.getRoleName())) {

				AdminRole checkAdminRole = adminroleRepository.findByRoleName(adminRole.getRoleName());

				if (checkAdminRole == null) {
					adminRole.setCreatedBy("admin");
					adminRole.setModifiedBy("admin");
					createdRole = adminroleRepository.save(adminRole);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return createdRole;
	}

	/**
	 * @author : Kaushik
	 * @return : adminrole
	 * @description : For get all the roles info
	 */
	@Override
	public List<Object> fetchallAdminRole() {
		// TODO Auto-generated method stub
		List<Object> adminrole = new ArrayList<Object>(adminroleRepository.findAll());

		// List<T> target = new ArrayList<>();
		return adminrole;
	}

	/**
	 * @author : Kaushik
	 * @param : String roleName
	 * @return : AdminRole
	 * @description : For soft deleting entry
	 */

	@Override
	public int deleteAdminRolebyRoleName(String roleName) {
		// TODO Auto-generated method stub
		int adminRole = 0;

		adminRole = adminroleRepository.deleteByRoleName(roleName);
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
		return adminroleRepository.findByRoleName(roleName);
	}

	/**
	 * @author : Kaushik
	 * @param : AdminRole adminRole, String roleName
	 * @return : object
	 * @description : For updating entry in adminrole table
	 */
	@Override
	public AdminRole updateRoleNamebyRoleName(AdminRole adminRole, String roleName) {
		// TODO Auto-generated method stub
		ArrayList<String> Role = new ArrayList<String>();
		Role.add("admin");
		Role.add("coadmin");
		Role.add("teacher");
		Role.add("student");
		// System.out.println(Role);

		AdminRole updateRole = null;
		try {

			if (Role.contains(roleName)) {

				AdminRole existingAdminRole = adminroleRepository.findByRoleName(adminRole.getRoleName());

				if (existingAdminRole != null) {
					System.out.println("=========" + adminRole);

					existingAdminRole.setRoleName(adminRole.getRoleName());
					existingAdminRole.setRoleDescription(adminRole.getRoleDescription());
					existingAdminRole.setActive(adminRole.isActive());
					updateRole = adminroleRepository.save(existingAdminRole);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateRole;
	}

}
