/**
 * @author - Code Generator
 * @createdOn 13-03-2023
 * @Description Controller class for authuserper
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

import com.cpa.uhpocms.entity.AuthUserPer;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.AuthUserPerService;

@RestController
@RequestMapping("/uhpocms")
public class AuthUserPerController {

	@Autowired
	private AuthUserPerService authuserperService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	AuthUserPerController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(AuthUserPerController.class);
	}

	@PostMapping("/authuserper")
	public ResponseEntity<Object> createAuthUserPer(@RequestBody AuthUserPer authuserper) throws CPException {
		logger.debug("Entering createAuthUserPer");
		logger.info("data of creating AuthUserPer  :" + authuserper.toString());

		AuthUserPer createdAuthUserPer = null;
		try {

			AuthUserPer toCheckAuthUserPer = authuserperService.getAuthUserPerByid(authuserper.getId());
			logger.debug("existing authuserper :" + toCheckAuthUserPer);

			if (toCheckAuthUserPer == null) {

			// TODO: Uncomment below 2 lines and change the method name as per your Entity class
			//	authuserper.setCreatedby("admin");
			//	authuserper.setUpdatedby("admin");

				createdAuthUserPer = authuserperService.createAuthUserPer(authuserper);
				logger.info("AuthUserPer created :" + createdAuthUserPer);

				return ResponseHandler.generateResponse(createdAuthUserPer, HttpStatus.CREATED);

			} else {

				logger.error(resourceBunde.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed AuthUserPer creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}

	@GetMapping("/authuserper/{id}")
	public ResponseEntity<Object> getAuthUserPerByid(@PathVariable("id") int id)
			throws CPException {
		logger.debug("Entering getAuthUserPerByid");
		logger.info("entered user name :" + id);
		
		AuthUserPer authuserper = null;

		try {

			authuserper = authuserperService.getAuthUserPerByid(id);
			logger.info("fetched AuthUserPer :" + authuserper);

			if (authuserper != null) {
				logger.debug("AuthUserPer fetched generating response");
				return ResponseHandler.generateResponse(authuserper, HttpStatus.OK);
			} else {
				logger.debug("AuthUserPer not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting authuserper : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	@GetMapping("/authuserper")
	public ResponseEntity<List<Object>> getAllAuthUserPers(@RequestParam(name = "id") String id)
			throws CPException {
		logger.debug("Entering getAllAuthUserPer");
		logger.info("Parameter  :" + id);
		
		List<Object> authuserpers = null;

		try {

			if (id.equalsIgnoreCase("all")) {

				authuserpers = authuserperService.getAllAuthUserPers();
				logger.info("Fetched all AuthUserPer :" + authuserpers);

				return ResponseHandler.generateListResponse(authuserpers, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all authuserpers : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

	@DeleteMapping("/authuserper/{id}")
	public ResponseEntity<Object> deleteAuthUserPerByid(@PathVariable("id") String id) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteAuthUserPer  :" + id);
		//TODO - implement the business logic
		
		int count = 0;

		try {
			count = authuserperService.deleteAuthUserPerByid(id);
			if (count >= 1) {
				logger.info("deleted AuthUserPer : id = " + id);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete AuthUserPer :" + ex.getMessage());
			throw new CPException("err005", resourceBunde.getString("err005"));
		}
		

	}

	@PutMapping("/authuserper/{id}")
	public ResponseEntity<Object> updateAuthUserPerByid(@RequestBody AuthUserPer authuserper,
			@PathVariable("id") int id) throws CPException {
		logger.debug("Entering updateAuthUserPer");
		logger.info("entered  updateAuthUserPer :" + authuserper);

		AuthUserPer updatedAuthUserPer = null;

		try { 
			updatedAuthUserPer = authuserperService.updateAuthUserPerByid(authuserper, id);

			if (updatedAuthUserPer == null) {
				logger.info(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated authuserper : " + updatedAuthUserPer);
				return ResponseHandler.generateResponse(updatedAuthUserPer, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update AuthUserPer : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

}
