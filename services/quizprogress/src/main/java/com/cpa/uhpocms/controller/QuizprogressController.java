/**
 * @author - Code Generator
 * @createdOn 03-04-2023
 * @Description Controller class for quizprogress
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

import com.cpa.uhpocms.entity.Quizprogress;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.QuizprogressService;

@RestController
@RequestMapping("/uhpocms")
public class QuizprogressController {

	@Autowired
	private QuizprogressService quizprogressService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	QuizprogressController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(QuizprogressController.class);
	}

	@PostMapping("/quizprogress")
	public ResponseEntity<Object> createQuizprogress(@RequestBody Quizprogress quizprogress) throws CPException {
		logger.debug("Entering createQuizprogress");
		logger.info("data of creating Quizprogress  :" + quizprogress.toString());

		Quizprogress createdQuizprogress = null;
		try {

			Quizprogress toCheckQuizprogress = quizprogressService.getQuizprogressBystudentId(quizprogress.getStudentId());
			logger.debug("existing quizprogress :" + toCheckQuizprogress);

			if (toCheckQuizprogress == null) {

			// TODO: Uncomment below 2 lines and change the method name as per your Entity class
			//	quizprogress.setCreatedby("admin");
			//	quizprogress.setUpdatedby("admin");

				createdQuizprogress = quizprogressService.createQuizprogress(quizprogress);
				logger.info("Quizprogress created :" + createdQuizprogress);

				return ResponseHandler.generateResponse(createdQuizprogress, HttpStatus.CREATED);

			} else {

				logger.error(resourceBunde.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed Quizprogress creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}

	@GetMapping("/quizprogress/{studentId}")
	public ResponseEntity<Object> getQuizprogressBystudentId(@PathVariable("studentId") int studentId)
			throws CPException {
		logger.debug("Entering getQuizprogressBystudentId");
		logger.info("entered user name :" + studentId);
		
		Quizprogress quizprogress = null;

		try {

			quizprogress = quizprogressService.getQuizprogressBystudentId(studentId);
			logger.info("fetched Quizprogress :" + quizprogress);

			if (quizprogress != null) {
				logger.debug("Quizprogress fetched generating response");
				return ResponseHandler.generateResponse(quizprogress, HttpStatus.OK);
			} else {
				logger.debug("Quizprogress not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting quizprogress : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	@GetMapping("/quizprogress")
	public ResponseEntity<List<Object>> getAllQuizprogresss(@RequestParam(name = "studentId") String studentId)
			throws CPException {
		logger.debug("Entering getAllQuizprogress");
		logger.info("Parameter  :" + studentId);
		
		List<Object> quizprogresss = null;

		try {

			if (studentId.equalsIgnoreCase("all")) {

				quizprogresss = quizprogressService.getAllQuizprogresss();
				logger.info("Fetched all Quizprogress :" + quizprogresss);

				return ResponseHandler.generateListResponse(quizprogresss, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all quizprogresss : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

	@DeleteMapping("/quizprogress/{studentId}")
	public ResponseEntity<Object> deleteQuizprogressBystudentId(@PathVariable("studentId") int studentId) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteQuizprogress  :" + studentId);
		//TODO - implement the business logic
		
		int count = 0;

		try {
			count = quizprogressService.deleteQuizprogressBystudentId(studentId);
			if (count >= 1) {
				logger.info("deleted Quizprogress : studentId = " + studentId);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete Quizprogress :" + ex.getMessage());
			throw new CPException("err005", resourceBunde.getString("err005"));
		}
		

	}

	@PutMapping("/quizprogress/{studentId}")
	public ResponseEntity<Object> updateQuizprogressBystudentId(@RequestBody Quizprogress quizprogress,
			@PathVariable("studentId") int studentId) throws CPException {
		logger.debug("Entering updateQuizprogress");
		logger.info("entered  updateQuizprogress :" + quizprogress);

		Quizprogress updatedQuizprogress = null;

		try { 
			updatedQuizprogress = quizprogressService.updateQuizprogressBystudentId(quizprogress, studentId);

			if (updatedQuizprogress == null) {
				logger.info(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated quizprogress : " + updatedQuizprogress);
				return ResponseHandler.generateResponse(updatedQuizprogress, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update Quizprogress : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

}
