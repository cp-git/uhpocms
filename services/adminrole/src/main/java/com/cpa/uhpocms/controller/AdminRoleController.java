package com.cpa.uhpocms.controller;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.uhpocms.AdminRoleApplication;
import com.cpa.uhpocms.entity.AdminRole;
import com.cpa.uhpocms.helper.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.AdminRoleService;

@RestController
public class AdminRoleController {

	@Autowired
	AdminRoleService adminroleService;
	ResourceBundle resourceBundle;

	private static final Logger logger = Logger.getLogger(AdminRoleApplication.class);

	AdminRoleController() {
		resourceBundle = ResourceBundle.getBundle("ErrorMessage", Locale.US);
	}

	@PostMapping("/uhpocms/role")
	public ResponseEntity<Object> addAdminrole(@RequestBody AdminRole adminRole) throws CPException {

		AdminRole createdRole = null;
		logger.info("in POST Operation method");
		try {
			createdRole = adminroleService.saveAdminRole(adminRole);

			if (createdRole == null) {
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err013");
			} else {
				return ResponseHandler.generateResponse(createdRole, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println(resourceBundle.getString("err013"));
			throw new CPException("err003", resourceBundle.getString("err013"));

		}

	}

	@GetMapping("/uhpocms/role")
	public ResponseEntity<List<Object>> getAllAdminRole(@RequestParam(name = "name") String roleName)
			throws CPException {

		logger.info("in getAll method");
		if (roleName.equals("all")) {
			List<Object> adminRole = adminroleService.fetchallAdminRole();
			// System.out.println(adminRole);
			if (adminRole != null) {
				System.out.println(adminRole);
				System.out.println("Inside the main..");
				return ResponseHandler.generateListResponse(adminRole, HttpStatus.OK);
			}
		}
		logger.error("Exception in getAll");
		return ResponseHandler.generateListResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err022");

	}

	@GetMapping("uhpocms/role/{roleName}")
	public ResponseEntity<Object> getRoleByRoleName(@PathVariable("roleName") String roleName) throws CPException {
		logger.info("In GET method ");
		AdminRole adminRole = null;
		try {

			adminRole = adminroleService.getRoleByRoleName(roleName);
			if (adminRole != null) {
				return ResponseHandler.generateResponse(adminRole, HttpStatus.OK);

			} else {
				throw new CPException("err001", resourceBundle.getString("err001"));

			}
		} catch (Exception e) {
			System.err.println(resourceBundle.getString("err041"));
			logger.error("Exception in GET Operation");
			return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err041");
		}

	}

	@DeleteMapping("uhpocms/role/{roleName}")
	public ResponseEntity<Object> deleteRoleByRoleName(@PathVariable("roleName") String roleName) throws CPException {
		logger.info("In DELETE Operaton ");
		int adminRole = 0;
		adminRole = adminroleService.deleteAdminRolebyRoleName(roleName);
		if (adminRole > 0) {
			return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);

		} else {
			System.err.println(resourceBundle.getString("err005"));
			logger.error("Error in DELETE Operation");
			return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
		}

	}

	@PutMapping("/uhpocms/role/{roleName}")
	public ResponseEntity<Object> updateRoleByRoleName(@RequestBody AdminRole adminRole,
			@PathVariable("roleName") String roleName) throws CPException {
		logger.info("In Put Operaton ");
		AdminRole updateRole = null;
		try {
			updateRole = adminroleService.updateRoleNamebyRoleName(adminRole, roleName);

			if (updateRole != null) {
				return ResponseHandler.generateResponse(updateRole, HttpStatus.CREATED);
			} else {
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err013");
			}

		} catch (Exception e) {
			System.err.println(e.toString());
			logger.error("Error in PUT Operation");
			return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err013");
		}

	}

}