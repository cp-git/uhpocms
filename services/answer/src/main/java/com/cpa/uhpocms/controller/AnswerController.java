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

	

	

}
