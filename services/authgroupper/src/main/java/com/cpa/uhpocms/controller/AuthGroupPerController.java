/**
 * @author - Code Generator
 * @createdOn 13-03-2023
 * @Description Controller class for authgroupper
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

import com.cpa.uhpocms.entity.AuthGroupPer;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.AuthGroupPerService;

@RestController
@RequestMapping("/uhpocms")
public class AuthGroupPerController {

	@Autowired
	private AuthGroupPerService authgroupperService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	AuthGroupPerController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(AuthGroupPerController.class);
	}

	@PostMapping("/authgroupper")
	public ResponseEntity<Object> createAuthGroupPer(@RequestBody AuthGroupPer authgroupper) throws CPException {
		logger.debug("Entering createAuthGroupPer");
		logger.info("data of creating AuthGroupPer  :" + authgroupper.toString());

		AuthGroupPer createdAuthGroupPer = null;
		try {

			AuthGroupPer toCheckAuthGroupPer = authgroupperService.getAuthGroupPerByid(authgroupper.getId());
			logger.debug("existing authgroupper :" + toCheckAuthGroupPer);

			if (toCheckAuthGroupPer == null) {

			// TODO: Uncomment below 2 lines and change the method name as per your Entity class
			//	authgroupper.setCreatedby("admin");
			//	authgroupper.setUpdatedby("admin");

				createdAuthGroupPer = authgroupperService.createAuthGroupPer(authgroupper);
				logger.info("AuthGroupPer created :" + createdAuthGroupPer);

				return ResponseHandler.generateResponse(createdAuthGroupPer, HttpStatus.CREATED);

			} else {

				logger.error(resourceBunde.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed AuthGroupPer creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}

	@GetMapping("/authgroupper/{id}")
	public ResponseEntity<Object> getAuthGroupPerByid(@PathVariable("id") int id)
			throws CPException {
		logger.debug("Entering getAuthGroupPerByid");
		logger.info("entered user name :" + id);
		
		AuthGroupPer authgroupper = null;

		try {

			authgroupper = authgroupperService.getAuthGroupPerByid(id);
			logger.info("fetched AuthGroupPer :" + authgroupper);

			if (authgroupper != null) {
				logger.debug("AuthGroupPer fetched generating response");
				return ResponseHandler.generateResponse(authgroupper, HttpStatus.OK);
			} else {
				logger.debug("AuthGroupPer not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting authgroupper : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	@GetMapping("/authgroupper")
	public ResponseEntity<List<Object>> getAllAuthGroupPers(@RequestParam(name = "id") String id)
			throws CPException {
		logger.debug("Entering getAllAuthGroupPer");
		logger.info("Parameter  :" + id);
		
		List<Object> authgrouppers = null;

		try {

			if (id.equalsIgnoreCase("all")) {

				authgrouppers = authgroupperService.getAllAuthGroupPers();
				logger.info("Fetched all AuthGroupPer :" + authgrouppers);

				return ResponseHandler.generateListResponse(authgrouppers, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all authgrouppers : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

	@DeleteMapping("/authgroupper/{id}")
	public ResponseEntity<Object> deleteAuthGroupPerByid(@PathVariable("id") String id) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteAuthGroupPer  :" + id);
		//TODO - implement the business logic
		
		int count = 0;

		try {
			count = authgroupperService.deleteAuthGroupPerByid(id);
			if (count >= 1) {
				logger.info("deleted AuthGroupPer : id = " + id);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete AuthGroupPer :" + ex.getMessage());
			throw new CPException("err005", resourceBunde.getString("err005"));
		}
		

	}

	@PutMapping("/authgroupper/{id}")
	public ResponseEntity<Object> updateAuthGroupPerByid(@RequestBody AuthGroupPer authgroupper,
			@PathVariable("id") int id) throws CPException {
		logger.debug("Entering updateAuthGroupPer");
		logger.info("entered  updateAuthGroupPer :" + authgroupper);

		AuthGroupPer updatedAuthGroupPer = null;

		try { 
			updatedAuthGroupPer = authgroupperService.updateAuthGroupPerByid(authgroupper, id);

			if (updatedAuthGroupPer == null) {
				logger.info(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated authgroupper : " + updatedAuthGroupPer);
				return ResponseHandler.generateResponse(updatedAuthGroupPer, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update AuthGroupPer : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

}
