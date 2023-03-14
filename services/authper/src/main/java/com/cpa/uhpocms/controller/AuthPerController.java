/**
 * @author - Code Generator
 * @createdOn 13-03-2023
 * @Description Controller class for authper
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

import com.cpa.uhpocms.entity.AuthPer;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.AuthPerService;
import com.sun.org.apache.bcel.internal.generic.ATHROW;

@RestController
@RequestMapping("/uhpocms")
public class AuthPerController {

	@Autowired
	private AuthPerService authperService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	AuthPerController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(AuthPerController.class);
	}

	@PostMapping("/authper")
	public ResponseEntity<Object> createAuthPer(@RequestBody AuthPer authper) throws CPException {
		logger.debug("Entering createAuthPer");
		logger.info("data of creating AuthPer  :" + authper.toString());

		AuthPer createdAuthPer = null;
		try {

			AuthPer toCheckAuthPer = authperService.getAuthPerByid(authper.getId());
			logger.debug("existing authper :" + toCheckAuthPer);

			if (toCheckAuthPer == null) {

			// TODO: Uncomment below 2 lines and change the method name as per your Entity class
			//	authper.setCreatedby("admin");
			//	authper.setUpdatedby("admin");

				createdAuthPer = authperService.createAuthPer(authper);
				logger.info("AuthPer created :" + createdAuthPer);

				return ResponseHandler.generateResponse(createdAuthPer, HttpStatus.CREATED);

			} else {

				logger.error(resourceBunde.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed AuthPer creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}

	@GetMapping("/authper/{id}")
	public ResponseEntity<Object> getAuthPerByid(@PathVariable("id") int id)
			throws CPException {
		logger.debug("Entering getAuthPerByname");
		logger.info("entered user name :" + id);
		
		AuthPer authper = null;

		try {

			authper = authperService.getAuthPerByid(id);
			logger.info("fetched AuthPer :" + authper);

			if (authper != null) {
				logger.debug("AuthPer fetched generating response");
				return ResponseHandler.generateResponse(authper, HttpStatus.OK);
			} else {
				logger.debug("AuthPer not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting authper : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}
	
	
	@GetMapping("/authper")
	public ResponseEntity<List<Object>> getAllAuthPers(@RequestParam(name = "name") String name)
			throws CPException {
		logger.debug("Entering getAllAuthPer");
		logger.info("Parameter  :" + name);
		
		List<Object> authpers = null;

		try {

			if (name.equalsIgnoreCase("all")) {

				authpers = authperService.getAllAuthPers();
				logger.info("Fetched all AuthPer :" + authpers);

				return ResponseHandler.generateListResponse(authpers, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all authpers : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}
	


	@DeleteMapping("/authper/{name}")
	public ResponseEntity<Object> deleteAuthPerByid(@PathVariable("name") String name) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteAuthPer  :" + name);
		//TODO - implement the business logic
		
		int count = 0;

		try {
			count = authperService.deleteAuthPerByid(name);
			if (count >= 1) {
				logger.info("deleted AuthPer : id = " + name);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete AuthPer :" + ex.getMessage());
			throw new CPException("err005", resourceBunde.getString("err005"));
		}
		

	}

	@PutMapping("/authper/{id}")
	public ResponseEntity<Object> updateAuthPerByid(@RequestBody AuthPer authper,
			@PathVariable("id") int id) throws CPException {
		logger.debug("Entering updateAuthPer");
		logger.info("entered  updateAuthPer :" + authper);

		AuthPer updatedAuthPer = null;

		try { 
			updatedAuthPer = authperService.updateAuthPerByid(authper, id);

			if (updatedAuthPer == null) {
				logger.info(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated authper : " + updatedAuthPer);
				return ResponseHandler.generateResponse(updatedAuthPer, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update AuthPer : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

}
