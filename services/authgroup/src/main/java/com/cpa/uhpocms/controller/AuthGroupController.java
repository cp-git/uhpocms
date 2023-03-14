/**
 * @author - Code Generator
 * @createdOn 13-03-2023
 * @Description Controller class for authgroup
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

import com.cpa.uhpocms.entity.AuthGroup;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.AuthGroupService;

@RestController
@RequestMapping("/uhpocms")
public class AuthGroupController {

	@Autowired
	private AuthGroupService authgroupService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	AuthGroupController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(AuthGroupController.class);
	}

	@PostMapping("/authgroup")
	public ResponseEntity<Object> createAuthGroup(@RequestBody AuthGroup authgroup) throws CPException {
		logger.debug("Entering createAuthGroup");
		logger.info("data of creating AuthGroup  :" + authgroup.toString());

		AuthGroup createdAuthGroup = null;
		try {

			AuthGroup toCheckAuthGroup = authgroupService.getAuthGroupByid(authgroup.getId());
			logger.debug("existing authgroup :" + toCheckAuthGroup);

			if (toCheckAuthGroup == null) {

			// TODO: Uncomment below 2 lines and change the method name as per your Entity class
			//	authgroup.setCreatedby("admin");
			//	authgroup.setUpdatedby("admin");

				createdAuthGroup = authgroupService.createAuthGroup(authgroup);
				logger.info("AuthGroup created :" + createdAuthGroup);

				return ResponseHandler.generateResponse(createdAuthGroup, HttpStatus.CREATED);

			} else {

				logger.error(resourceBunde.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed AuthGroup creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}

	@GetMapping("/authgroup/{id}")
	public ResponseEntity<Object> getAuthGroupByid(@PathVariable("id") Integer id)
			throws CPException {
		logger.debug("Entering getAuthGroupByid");
		logger.info("entered user name :" + id);
		
		AuthGroup authgroup = null;

		try {

			authgroup = authgroupService.getAuthGroupByid(id);
			logger.info("fetched AuthGroup :" + authgroup);

			if (authgroup != null) {
				logger.debug("AuthGroup fetched generating response");
				return ResponseHandler.generateResponse(authgroup, HttpStatus.OK);
			} else {
				logger.debug("AuthGroup not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting authgroup : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	@GetMapping("/authgroup")
	public ResponseEntity<List<Object>> getAllAuthGroups(@RequestParam(name = "id") String id)
			throws CPException {
		logger.debug("Entering getAllAuthGroup");
		logger.info("Parameter  :" + id);
		
		List<Object> authgroups = null;

		try {

			if (id.equalsIgnoreCase("all")) {

				authgroups = authgroupService.getAllAuthGroups();
				logger.info("Fetched all AuthGroup :" + authgroups);

				return ResponseHandler.generateListResponse(authgroups, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all authgroups : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

	@DeleteMapping("/authgroup/{id}")
	public ResponseEntity<Object> deleteAuthGroupByid(@PathVariable("id") String id) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteAuthGroup  :" + id);
		//TODO - implement the business logic
		
		int count = 0;

		try {
			count = authgroupService.deleteAuthGroupByid(id);
			if (count >= 1) {
				logger.info("deleted AuthGroup : id = " + id);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete AuthGroup :" + ex.getMessage());
			throw new CPException("err005", resourceBunde.getString("err005"));
		}
		

	}

	@PutMapping("/authgroup/{id}")
	public ResponseEntity<Object> updateAuthGroupByid(@RequestBody AuthGroup authgroup,
			@PathVariable("id") Integer id) throws CPException {
		logger.debug("Entering updateAuthGroup");
		logger.info("entered  updateAuthGroup :" + authgroup);

		AuthGroup updatedAuthGroup = null;

		try { 
			updatedAuthGroup = authgroupService.updateAuthGroupByid(authgroup, id);

			if (updatedAuthGroup == null) {
				logger.info(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated authgroup : " + updatedAuthGroup);
				return ResponseHandler.generateResponse(updatedAuthGroup, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update AuthGroup : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

}
