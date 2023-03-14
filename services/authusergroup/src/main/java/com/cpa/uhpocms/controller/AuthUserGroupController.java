/**
 * @author - Code Generator
 * @createdOn 13-03-2023
 * @Description Controller class for authusergroup
 * 
 */

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.uhpocms.entity.AuthUserGroup;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.AuthUserGroupService;

@RestController
@RequestMapping("/uhpocms")
public class AuthUserGroupController {

	@Autowired
	private AuthUserGroupService authusergroupService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	AuthUserGroupController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(AuthUserGroupController.class);
	}

	@PostMapping("/authusergroup")
	public ResponseEntity<Object> createAuthUserGroup(@RequestBody AuthUserGroup authusergroup) throws CPException {
		logger.debug("Entering createAuthUserGroup");
		logger.info("data of creating AuthUserGroup  :" + authusergroup.toString());

		AuthUserGroup createdAuthUserGroup = null;
		try {

			AuthUserGroup toCheckAuthUserGroup = authusergroupService.getAuthUserGroupByid(authusergroup.getId());
			logger.debug("existing authusergroup :" + toCheckAuthUserGroup);

			if (toCheckAuthUserGroup == null) {

			// TODO: Uncomment below 2 lines and change the method name as per your Entity class
			//	authusergroup.setCreatedby("admin");
			//	authusergroup.setUpdatedby("admin");

				createdAuthUserGroup = authusergroupService.createAuthUserGroup(authusergroup);
				logger.info("AuthUserGroup created :" + createdAuthUserGroup);

				return ResponseHandler.generateResponse(createdAuthUserGroup, HttpStatus.CREATED);

			} else {

				logger.error(resourceBunde.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed AuthUserGroup creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}

	@GetMapping("/authusergroup/{id}")
	public ResponseEntity<Object> getAuthUserGroupByid(@PathVariable("id") int id)
			throws CPException {
		logger.debug("Entering getAuthUserGroupByid");
		logger.info("entered user name :" + id);
		
		AuthUserGroup authusergroup = null;

		try {

			authusergroup = authusergroupService.getAuthUserGroupByid(id);
			logger.info("fetched AuthUserGroup :" + authusergroup);

			if (authusergroup != null) {
				logger.debug("AuthUserGroup fetched generating response");
				return ResponseHandler.generateResponse(authusergroup, HttpStatus.OK);
			} else {
				logger.debug("AuthUserGroup not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting authusergroup : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	@GetMapping("/authusergroup")
	public ResponseEntity<List<Object>> getAllAuthUserGroups(@RequestParam(name = "id") String id)
			throws CPException {
		logger.debug("Entering getAllAuthUserGroup");
		logger.info("Parameter  :" + id);
		
		List<Object> authusergroups = null;

		try {

			if (id.equalsIgnoreCase("all")) {

				authusergroups = authusergroupService.getAllAuthUserGroups();
				logger.info("Fetched all AuthUserGroup :" + authusergroups);

				return ResponseHandler.generateListResponse(authusergroups, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all authusergroups : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

	@DeleteMapping("/authusergroup/{id}")
	public ResponseEntity<Object> deleteAuthUserGroupByid(@PathVariable("id") String id) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteAuthUserGroup  :" + id);
		//TODO - implement the business logic
		
		int count = 0;

		try {
			count = authusergroupService.deleteAuthUserGroupByid(id);
			if (count >= 1) {
				logger.info("deleted AuthUserGroup : id = " + id);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete AuthUserGroup :" + ex.getMessage());
			throw new CPException("err005", resourceBunde.getString("err005"));
		}
		

	}

	@PutMapping("/authusergroup/{id}")
	public ResponseEntity<Object> updateAuthUserGroupByid(@RequestBody AuthUserGroup authusergroup,
			@PathVariable("id") int id) throws CPException {
		logger.debug("Entering updateAuthUserGroup");
		logger.info("entered  updateAuthUserGroup :" + authusergroup);

		AuthUserGroup updatedAuthUserGroup = null;

		try { 
			updatedAuthUserGroup = authusergroupService.updateAuthUserGroupByid(authusergroup, id);

			if (updatedAuthUserGroup == null) {
				logger.info(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated authusergroup : " + updatedAuthUserGroup);
				return ResponseHandler.generateResponse(updatedAuthUserGroup, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update AuthUserGroup : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

}
