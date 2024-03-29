/**
 * @author - Code Generator
 * @createdOn 30-03-2023
 * @Description Controller class for answer
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

import com.cpa.uhpocms.entity.Answer;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.AnswerService;
@CrossOrigin
@RestController
@RequestMapping("/uhpocms")
public class AnswerController {

	@Autowired
	private AnswerService answerService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	AnswerController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(AnswerController.class);
	}

//	@PostMapping("/answer")
//	public ResponseEntity<Object> createAnswer(@RequestBody Answer answer) throws CPException {
//		logger.debug("Entering createAnswer");
//		logger.info("data of creating Answer  :" + answer.toString());
//
//		Answer createdAnswer = null;
//		try {
//
//			Answer toCheckAnswer = answerService.getAnswerById(answer.getId());
//			logger.debug("existing answer :" + toCheckAnswer);
//
//			if (toCheckAnswer == null) {
//
//			// TODO: Uncomment below 2 lines and change the method name as per your Entity class
//			//	answer.setCreatedby("admin");
//			//	answer.setUpdatedby("admin");
//
//				createdAnswer = answerService.createAnswer(answer);
//				logger.info("Answer created :" + createdAnswer);
//
//				return ResponseHandler.generateResponse(createdAnswer, HttpStatus.CREATED);
//
//			} else {
//
//				logger.error(resourceBunde.getString("err003"));
//				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
//			}
//
//		} catch (Exception ex) {
//			logger.error("Failed Answer creation : " + ex.getMessage());
//			throw new CPException("err003", resourceBunde.getString("err003"));
//		}
//	}
	
	@PostMapping("/answer")
	public ResponseEntity<Object> addOrUpdateAnswer(@RequestBody Answer answer) throws CPException {
	    logger.debug("Entering addOrUpdateAnswer");
	    logger.info("Data for adding/updating Answer: " + answer.toString());
	    Answer savedAnswer = null;
	    try {
	        Answer existingAnswer = answerService.getAnswerById(answer.getId());
	        logger.debug("Existing answer: " + existingAnswer);
	        if (existingAnswer != null) {
	            // Update existing answer
	            savedAnswer = answerService.updateAnswerById(answer, answer.getId());
	            logger.info("Answer updated: " + savedAnswer);
	        } else {
	            // Create new answer
	            // TODO: Uncomment below 2 lines and change the method name as per your Entity class
	            // answer.setCreatedby("admin");
	            // answer.setUpdatedby("admin");
	            savedAnswer = answerService.createAnswer(answer);
	            logger.info("Answer created: " + savedAnswer);
	        }
	        return ResponseHandler.generateResponse(savedAnswer, HttpStatus.CREATED);
	    } catch (Exception ex) {
	        logger.error("Failed to add/update Answer: " + ex.getMessage());
	        throw new CPException("err005", resourceBunde.getString("err005"));
	    }
	}

	@GetMapping("/answer/{id}")
	public ResponseEntity<Object> getAnswerById(@PathVariable("id") int id)
			throws CPException {
		logger.debug("Entering getAnswerByid");
		logger.info("entered user name :" + id);
		
		Answer answer = null;

		try {

			answer = answerService.getAnswerById(id);
			logger.info("fetched Answer :" + answer);

			if (answer != null) {
				logger.debug("Answer fetched generating response");
				return ResponseHandler.generateResponse(answer, HttpStatus.OK);
			} else {
				logger.debug("Answer not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting answer : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	@GetMapping("/answer")
	public ResponseEntity<List<Object>> getAllAnswers(@RequestParam(name = "id") String id)
			throws CPException {
		logger.debug("Entering getAllAnswer");
		logger.info("Parameter  :" + id);
		
		List<Object> answers = null;

		try {

			if (id.equalsIgnoreCase("all")) {

				answers = answerService.getAllAnswers();
				logger.info("Fetched all Answer :" + answers);

				return ResponseHandler.generateListResponse(answers, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all answers : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

	@DeleteMapping("/answer/{id}")
	public ResponseEntity<Object> deleteAnswerById(@PathVariable("id") int id) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteAnswer  :" + id);
		//TODO - implement the business logic
		
		int count = 0;

		try {
			count = answerService.deleteAnswerById(id);
			if (count >= 1) {
				logger.info("deleted Answer : Id = " + id);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete Answer :" + ex.getMessage());
			throw new CPException("err005", resourceBunde.getString("err005"));
		}
		

	}

	@PutMapping("/answer/{id}")
	public ResponseEntity<Object> updateAnswerById(@RequestBody Answer answer,
			@PathVariable("id") int id) throws CPException {
		logger.debug("Entering updateAnswer");
		logger.info("entered  updateAnswer :" + answer);

		Answer updatedAnswer = null;

		try { 
			updatedAnswer = answerService.updateAnswerById(answer, id);

			if (updatedAnswer == null) {
				logger.info(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated answer : " + updatedAnswer);
				return ResponseHandler.generateResponse(updatedAnswer, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update Answer : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

}
