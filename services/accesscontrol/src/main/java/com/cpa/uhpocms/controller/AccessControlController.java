/**
 * @author - Code Generator
 * @createdOn 29-03-2023
 * @Description Controller class for accesscontrol
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

import com.cpa.uhpocms.entity.AccessControl;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.AccessControlService;

@RestController
@RequestMapping("/uhpocms")
public class AccessControlController {

	@Autowired
	private AccessControlService accesscontrolService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	AccessControlController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(AccessControlController.class);
	}

	@PostMapping("/access")
	public ResponseEntity<Object> createAccessControl(@RequestBody AccessControl accesscontrol) throws CPException {
		logger.debug("Entering createAccessControl");
		logger.info("data of creating AccessControl  :" + accesscontrol.toString());

		AccessControl createdAccessControl = null;
		try {

			AccessControl toCheckAccessControl = accesscontrolService.getAccessControlByid(accesscontrol.getId());
			logger.debug("existing accesscontrol :" + toCheckAccessControl);

			if (toCheckAccessControl == null) {

			// TODO: Uncomment below 2 lines and change the method name as per your Entity class
			//	accesscontrol.setCreatedby("admin");
			//	accesscontrol.setUpdatedby("admin");

				createdAccessControl = accesscontrolService.createAccessControl(accesscontrol);
				logger.info("AccessControl created :" + createdAccessControl);

				return ResponseHandler.generateResponse(createdAccessControl, HttpStatus.CREATED);

			} else {

				logger.error(resourceBunde.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed AccessControl creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}

	@GetMapping("/access/{id}")
	public ResponseEntity<Object> getAccessControlByid(@PathVariable("id") int id)
			throws CPException {
		logger.debug("Entering getAccessControlByid");
		logger.info("entered user name :" + id);
		
		AccessControl accesscontrol = null;

		try {

			accesscontrol = accesscontrolService.getAccessControlByid(id);
			logger.info("fetched AccessControl :" + accesscontrol);

			if (accesscontrol != null) {
				logger.debug("AccessControl fetched generating response");
				return ResponseHandler.generateResponse(accesscontrol, HttpStatus.OK);
			} else {
				logger.debug("AccessControl not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting accesscontrol : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	@GetMapping("/access")
	public ResponseEntity<List<Object>> getAllAccessControls(@RequestParam(name = "id") String id)
			throws CPException {
		logger.debug("Entering getAllAccessControl");
		logger.info("Parameter  :" + id);
		
		List<Object> accesscontrols = null;

		try {

			if (id.equalsIgnoreCase("all")) {

				accesscontrols = accesscontrolService.getAllAccessControls();
				logger.info("Fetched all AccessControl :" + accesscontrols);

				return ResponseHandler.generateListResponse(accesscontrols, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all accesscontrols : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

	@DeleteMapping("/access/{id}")
	public ResponseEntity<Object> deleteAccessControlByid(@PathVariable("id") int id) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteAccessControl  :" + id);
		//TODO - implement the business logic
		
		int count = 0;

		try {
			count = accesscontrolService.deleteAccessControlByid(id);
			if (count >= 1) {
				logger.info("deleted AccessControl : id = " + id);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete AccessControl :" + ex.getMessage());
			throw new CPException("err005", resourceBunde.getString("err005"));
		}
		

	}

	@PutMapping("/access/{id}")
	public ResponseEntity<Object> updateAccessControlByid(@RequestBody AccessControl accesscontrol,
			@PathVariable("id") int id) throws CPException {
		logger.debug("Entering updateAccessControl");
		logger.info("entered  updateAccessControl :" + accesscontrol);

		AccessControl updatedAccessControl = null;

		try { 
			updatedAccessControl = accesscontrolService.updateAccessControlByid(accesscontrol, id);

			if (updatedAccessControl == null) {
				logger.info(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated accesscontrol : " + updatedAccessControl);
				return ResponseHandler.generateResponse(updatedAccessControl, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update AccessControl : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

}
