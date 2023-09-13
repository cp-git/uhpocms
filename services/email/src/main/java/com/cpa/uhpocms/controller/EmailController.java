/**
 * @author - Code Generator
 * @createdOn 06-12-2022
 * @Description Controller class for email
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.uhpocms.entity.AuthenticationBean;
import com.cpa.uhpocms.entity.Email;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.EmailService;

@CrossOrigin
@RestController
@RequestMapping("/uhpocms")
public class EmailController {

	@Autowired
	private EmailService emailService;;

	private ResourceBundle resourceBundle;
	private static Logger logger;

	EmailController() {
		resourceBundle = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(EmailController.class);
	}

	
	// Insert the email
	@PostMapping("/email")
	public ResponseEntity<Object> createEmail(@RequestBody Email email) throws CPException {
		logger.debug("Entering createEmail");
		logger.info("data of creating Email  :" + email.toString());

		Email createdEmail = null;
		try {

			Email toCheckEmail = emailService.getEmailByTitle(email.getTitle());
			logger.debug("existing email :" + toCheckEmail);

			if (toCheckEmail == null) {

			// TODO: Uncomment below 2 lines and change the method name as per your Entity class
			//	email.setCreatedby("admin");
			//	email.setUpdatedby("admin");

				createdEmail = emailService.createEmail(email);
				logger.info("Email created :" + createdEmail);

				return ResponseHandler.generateResponse(createdEmail, HttpStatus.CREATED);

			} else {

				logger.error(resourceBundle.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed Email creation : " + ex.getMessage());
			throw new CPException("err003", resourceBundle.getString("err003"));
		}
	}

	//GET EMAIL BY TITLE
	@GetMapping("/email/{title}")
	public ResponseEntity<Object> getEmailByTitle(@PathVariable("title") String title)
			throws CPException {
		logger.debug("Entering getEmailBytitle");
		logger.info("entered user name :" + title);
		
		Email email = null;

		try {

			email = emailService.getEmailByTitle(title);
			logger.info("fetched Email :" + email);

			if (email != null) {
				logger.debug("Email fetched generating response");
				return ResponseHandler.generateResponse(email, HttpStatus.OK);
			} else {
				logger.debug("Email not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting email : " + ex.getMessage());
			throw new CPException("err001", resourceBundle.getString("err001"));
		}

	}

	//GET ALL EMAILS 
	@GetMapping("/email")
	public ResponseEntity<List<Object>> getAllEmails(@RequestParam(name = "title") String title)
			throws CPException {
		logger.debug("Entering getAllEmail");
		logger.info("Parameter  :" + title);
		
		List<Object> emails = null;

		try {

			if (title.equalsIgnoreCase("all")) {

				emails = emailService.getAllEmails();
				logger.info("Fetched all Email :" + emails);

				return ResponseHandler.generateListResponse(emails, HttpStatus.OK);
			} else {

				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all emails : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));

		}
	}

	// DELETE EMAIL BY TITLE
	@DeleteMapping("/email/{title}")
	public ResponseEntity<Object> deleteEmailByTitle(@PathVariable("title") String title) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteEmail  :" + title);
		//TODO - implement the business logic
		
		int count = 0;

		try {
			count = emailService.deleteEmailByTitle(title);
			if (count >= 1) {
				logger.info("deleted Email : Title = " + title);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBundle.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete Email :" + ex.getMessage());
			throw new CPException("err005", resourceBundle.getString("err005"));
		}
		

	}

	//UPDATE EMAIL BY TITLE
	@PutMapping("/email/{title}")
	public ResponseEntity<Object> updateEmailByTitle(@RequestBody Email email,
			@PathVariable("title") String title) throws CPException {
		logger.debug("Entering updateEmail");
		logger.info("entered  updateEmail :" + email);

		Email updatedEmail = null;

		try { 
			updatedEmail = emailService.updateEmailByTitle(email, title);

			if (updatedEmail == null) {
				logger.info(resourceBundle.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated email : " + updatedEmail);
				return ResponseHandler.generateResponse(updatedEmail, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update Email : " + ex.getMessage());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}

	}
	
	@GetMapping(path = "/basicauth")
    public AuthenticationBean basicauth() {
        return new AuthenticationBean("You are authenticated");
    }

}
