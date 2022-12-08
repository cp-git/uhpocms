/**
 * @author - Code Generator
 * @createdOn 07-12-2022
 * @Description Controller class for question
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

import com.cpa.uhpocms.entity.Question;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.QuestionService;

@RestController
@RequestMapping("/uhpocms")
public class QuestionController {

	@Autowired
	private QuestionService questionService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	QuestionController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(QuestionController.class);
	}

	@PostMapping("/question")
	public ResponseEntity<Object> createQuestion(@RequestBody Question question) throws CPException {
		logger.debug("Entering createQuestion");
		logger.info("data of creating Question  :" + question.toString());

		Question createdQuestion = null;
		try {

			Question toCheckQuestion = questionService.getQuestionByFigure(question.getQuestionFigure());
			logger.debug("existing question :" + toCheckQuestion);

			if (toCheckQuestion == null) {

			// TODO: Uncomment below 2 lines and change the method name as per your Entity class
			//	question.setCreatedby("admin");
			//	question.setUpdatedby("admin");

				createdQuestion = questionService.createQuestion(question);
				logger.info("Question created :" + createdQuestion);

				return ResponseHandler.generateResponse(createdQuestion, HttpStatus.CREATED);

			} else {

				logger.error(resourceBunde.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed Question creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}

	@GetMapping("/question/{figure}")
	public ResponseEntity<Object> getQuestionByFigure(@PathVariable("figure") String figure)
			throws CPException {
		logger.debug("Entering getQuestionByfigure");
		logger.info("entered user name :" + figure);
		
		Question question = null;

		try {

			question = questionService.getQuestionByFigure(figure);
			logger.info("fetched Question :" + question);

			if (question != null) {
				logger.debug("Question fetched generating response");
				return ResponseHandler.generateResponse(question, HttpStatus.OK);
			} else {
				logger.debug("Question not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting question : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	@GetMapping("/question")
	public ResponseEntity<List<Object>> getAllQuestion(@RequestParam(name = "figure") String figure)
			throws CPException {
		logger.debug("Entering getAllQuestion");
		logger.info("Parameter  :" + figure);
		
		List<Object> questions = null;

		try {

			if (figure.equalsIgnoreCase("all")) {

				questions = questionService.getAllQuestions();
				logger.info("Fetched all Question :" + questions);

				return ResponseHandler.generateListResponse(questions, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all questions : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

	@DeleteMapping("/question/{figure}")
	public ResponseEntity<Object> deleteQuestionByFigure(@PathVariable("figure") String figure) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteQuestion  :" + figure);
		//TODO - implement the business logic
		
		int count = 0;

		try {
			count = questionService.deleteQuestionByFigure(figure);
			if (count >= 1) {
				logger.info("deleted Question : Figure = " + figure);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete Question :" + ex.getMessage());
			throw new CPException("err005", resourceBunde.getString("err005"));
		}
		

	}

	@PutMapping("/question/{figure}")
	public ResponseEntity<Object> updateQuestionByFigure(@RequestBody Question question,
			@PathVariable("figure") String figure) throws CPException {
		logger.debug("Entering updateQuestion");
		logger.info("entered  updateQuestion :" + question);

		Question updatedQuestion = null;

		try {
			updatedQuestion = questionService.updateQuestion(question, figure);

			if (updatedQuestion == null) {
				logger.info(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated question : " + updatedQuestion);
				return ResponseHandler.generateResponse(updatedQuestion, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update Question : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

}
