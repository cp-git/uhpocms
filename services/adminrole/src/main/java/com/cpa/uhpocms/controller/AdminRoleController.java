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
	AdminRoleService adminRoleService;
	ResourceBundle resourceBundle;

	private static final Logger logger = Logger.getLogger(AdminRoleApplication.class);

	AdminRoleController() {
		resourceBundle = ResourceBundle.getBundle("ErrorMessage", Locale.US);
	}

	/**
	 * @author : Kaushik
	 * @param : AdminRole adminRole
	 * @return : Response entity object
	 * @description : adding admin role
	 */

	@PostMapping("/uhpocms/role")
	public ResponseEntity<Object> addAdminRole(@RequestBody AdminRole adminRole) throws CPException {

		logger.debug("Entering addAdminRole");
		AdminRole createdRole = null;
		logger.info("in POST Operation method");
		try {
			createdRole = adminRoleService.saveAdminRole(adminRole);

			if (createdRole == null) {
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err013");
			} else {
				return ResponseHandler.generateResponse(createdRole, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			logger.error(resourceBundle.getString("err013"));
			throw new CPException("err013", resourceBundle.getString("err013"));

		}

	}

	/**
	 * @author : Kaushik
	 * @param : String roleName
	 * @return : Response entity object
	 * @description : get all roles
	 */
	@GetMapping("/uhpocms/role")
	public ResponseEntity<List<Object>> getAllAdminRole(@RequestParam(name = "name") String roleName)
			throws CPException {
		try {
			logger.info("in getAll method");
			logger.debug("in getAllAdminRole method");
			if (roleName.equals("all")) {
				List<Object> adminRole = adminRoleService.getAllAdminRole();

				return ResponseHandler.generateListResponse(adminRole, HttpStatus.OK);
			} else {
				return ResponseHandler.generateListResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err022");
			}

		} catch (Exception e) {
			logger.error("Exception in getAll: " + e.getMessage());
			throw new CPException("err022", resourceBundle.getString("err022"));
		}

	}

	/**
	 * @author : Kaushik
	 * @param : String roleName
	 * @return : Response entity object
	 * @description : getting role by roleName
	 */

	@GetMapping("uhpocms/role/{roleName}")
	public ResponseEntity<Object> getRoleByRoleName(@PathVariable("roleName") String roleName) throws CPException {
		logger.info("In GET method ");
		logger.debug("Entering getRoleByRoleName");
		AdminRole adminRole = null;
		try {

			adminRole = adminRoleService.getRoleByRoleName(roleName);
			if (adminRole != null) {
				return ResponseHandler.generateResponse(adminRole, HttpStatus.OK);

			} else {

				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err041");
			}
		} catch (Exception e) {
			logger.error(resourceBundle.getString("err041"));
			throw new CPException("err041", resourceBundle.getString("err041"));

		}

	}

	/**
	 * @author : Kaushik
	 * @param : String roleName
	 * @return : Response entity object
	 * @description : for soft deleting the record
	 */
	@DeleteMapping("uhpocms/role/{roleName}")
	public ResponseEntity<Object> deleteRoleByRoleName(@PathVariable("roleName") String roleName) throws CPException {
		logger.info("In DELETE Operaton ");
		logger.debug("In deleteRoleByRoleName");
		try {
			int adminRole = 0;
			adminRole = adminRoleService.deleteAdminRoleByRoleName(roleName);
			if (adminRole > 0) {
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);

			} else {

				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}
		} catch (Exception e) {
			logger.info(resourceBundle.getString("err005"));
			logger.error("Error in DELETE Operation" + e.getMessage());
			throw new CPException("err005", resourceBundle.getString("err005"));

		}

	}

	/**
	 * @author : Kaushik
	 * @param : AdminRole adminRole
	 * @return : Response entity object
	 * @description : update the role details by role name
	 */
	@PutMapping("/uhpocms/role/{roleName}")
	public ResponseEntity<Object> updateRoleByRoleName(@RequestBody AdminRole adminRole,
			@PathVariable("roleName") String roleName) throws CPException {
		logger.info("In Put Operaton ");
		logger.debug("Entering in updateRoleByRoleName");
		AdminRole updateRole = null;
		try {
			updateRole = adminRoleService.updateRoleNameByRoleName(adminRole, roleName);

			if (updateRole != null) {
				return ResponseHandler.generateResponse(updateRole, HttpStatus.CREATED);
			} else {
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			}

		} catch (Exception e) {
			logger.error("Error in PUT Operation" + e.getMessage());
			throw new CPException("err004", resourceBundle.getString("err004"));
		}

	}

}