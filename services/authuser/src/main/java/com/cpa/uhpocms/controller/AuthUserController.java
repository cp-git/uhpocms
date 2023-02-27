/**
 * @author Mayur
 * @createdOn 18th Nov 2022
 * @Description Controller class for auth_user
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.uhpocms.entity.AuthUser;
import com.cpa.uhpocms.entity.AuthenticationBean;
import com.cpa.uhpocms.helper.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.AuthUserService;

@RestController
@RequestMapping("/uhpocms")
@CrossOrigin
public class AuthUserController {

	@Autowired
	private AuthUserService authUserService;

	private ResourceBundle resourceBundle;
	private static Logger logger;

	AuthUserController() {
		resourceBundle = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(AuthUserController.class);
	}

	@PostMapping("/authuser")
	public ResponseEntity<Object> createAuthUser(@RequestBody AuthUser authUser) throws CPException {
		logger.debug("Entering createAuthUser");
		logger.info("data of creating auth user with username :" + authUser.getAuthUserName());

		AuthUser createdUser = null;
		try {

			AuthUser toCheckAuthUser = authUserService.getAuthUserByUserName(authUser.getAuthUserName());
			logger.debug("existing auth user :" + toCheckAuthUser);

			if (toCheckAuthUser == null) {

				createdUser = authUserService.createAuthUser(authUser);
				logger.info("user created :" + createdUser);

				return ResponseHandler.generateResponse(createdUser, HttpStatus.CREATED);

			} else {

				logger.error(resourceBundle.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed auth user creation : " + ex.getMessage());
			throw new CPException("err003", resourceBundle.getString("err003"));
		}

	}

	@GetMapping("/authuser/{username}")
	public ResponseEntity<Object> getAuthUserByUserName(@PathVariable("username") String authUserName)
			throws CPException {
		logger.debug("Entering getAuthUserByUserName");
		logger.info("entered user name :" + authUserName);

		AuthUser authUser = null;

		try {

			authUser = authUserService.getAuthUserByUserName(authUserName);
			logger.info("fetched auth user :" + authUser);

			if (authUser != null) {
				logger.debug("auth user fetched generating response");
				return ResponseHandler.generateResponse(authUser, HttpStatus.OK);
			} else {
				logger.debug("auth user not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting auth user : " + ex.getMessage());
			throw new CPException("err001", resourceBundle.getString("err001"));
		}

	}

	@GetMapping("/login")
	public AuthUser loginAuthUser(@RequestBody AuthUser authUser) throws CPException {
		logger.debug("Entering loginAuthUser");

		String authUserName = authUser.getAuthUserName();
		String authUserPassword = authUser.getAuthUserPassword();
		AuthUser loginUser = null;
		try {

			if (authUserName != null && authUserPassword != null) {

				loginUser = authUserService.getDetailsByUserNameAndPassword(authUserName, authUserPassword);
				logger.info("user login :" + loginUser);

			}

			if (loginUser == null) {

				throw new CPException("err006", resourceBundle.getString("err006"));
			}

		} catch (Exception ex) {
			logger.error("Failed auth user login : " + ex.getMessage());
			throw new CPException("err006", resourceBundle.getString("err006"));
		}
		return loginUser;

	}

	@GetMapping("/authuser")
	public ResponseEntity<List<Object>> getAllAuthUsers(@RequestParam(name = "username") String authUserName)
			throws CPException {
		logger.debug("Entering getAllAuthUsers");
		logger.info("entered user name :" + authUserName);

		List<Object> authUsers = null;

		try {
			if (authUserName.equalsIgnoreCase("all")) {
				authUsers = authUserService.getAllAuthUsers();
				logger.info("Fetched all active auth users :" + authUsers);
				return ResponseHandler.generateListResponse(authUsers, HttpStatus.OK);

			} else if (authUserName.equalsIgnoreCase("inactive")) {
				authUsers = authUserService.getAllInactiveAuthUsers();
				logger.info("Fetched all inactive auth users :" + authUsers);
				return ResponseHandler.generateListResponse(authUsers, HttpStatus.OK);
			} else {
				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all auth users : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));

		}
	}

	@DeleteMapping("/authuser/{username}")
	public ResponseEntity<Object> deleteAuthUser(@PathVariable("username") String authUserName) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered username to delete auth user is :" + authUserName);

		int authUser = 0;

		try {
			authUser = authUserService.deleteAuthUserByUserName(authUserName);
			if (authUser >= 1) {
				logger.info("deleted auth user : username = " + authUserName);
				return ResponseHandler.generateResponse(HttpStatus.ACCEPTED);
			} else {
				logger.info(resourceBundle.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete auth user :" + ex.getMessage());
			throw new CPException("err005", resourceBundle.getString("err005"));
		}

	}

	@PutMapping("/authuser/{username}")
	public ResponseEntity<Object> updateAuthUser(@RequestBody AuthUser authUser,
			@PathVariable("username") String authUserName) throws CPException {
		logger.debug("Entering updateAuthUser");
		logger.info("entered username to update auth user is :" + authUserName);

		AuthUser updatedUser = null;

		try {
			updatedUser = authUserService.updateAuthUser(authUser, authUserName);

			if (updatedUser == null) {
				logger.info(resourceBundle.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated auth user :" + updatedUser);
				return ResponseHandler.generateResponse(updatedUser, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update auth user : " + ex.getMessage());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}

	}

	@GetMapping(path = "/basicauth")
	public AuthenticationBean basicauth() {
		return new AuthenticationBean("You are authenticated");
	}

	@PatchMapping(path = "/authuser/activate/{id}")
	public ResponseEntity<Object> activateAuthUserById(@PathVariable("id") int authUserId) throws CPException {
		logger.debug("Entering activateAuthUserById");
		logger.info("entered activateAuthUserById  :" + authUserId);
		// TODO - implement the business logic

		int count = 0;

		try {
			count = authUserService.activateAuthUserById(authUserId);
			if (count >= 1) {
				logger.info("activated authuser : Id = " + authUserId);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBundle.getString("err007"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err007");
			}

		} catch (Exception ex) {
			logger.error("Failed to activate authuser :" + ex.getMessage());
			throw new CPException("err007", resourceBundle.getString("err007"));
		}
	}

}
