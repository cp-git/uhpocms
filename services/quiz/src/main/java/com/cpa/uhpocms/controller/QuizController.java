/**
 * @author - Code Generator
 * @createdOn 06-12-2022
 * @Description Controller class for quiz
 * 
 */

package com.cpa.uhpocms.controller;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.hamcrest.Description;
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

import com.cpa.uhpocms.entity.Quiz;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.QuizService;

@CrossOrigin
@RestController
@RequestMapping("/uhpocms")
public class QuizController {

	@Autowired
	private QuizService quizService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	QuizController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(QuizController.class);
	}

	/**
	 * 
	 * @param quiz
	 * @return
	 * @throws CPException
	 * @description Method to create a new quiz entry in table
	 */
	@PostMapping("/quiz")
	public ResponseEntity<Object> createQuiz(@RequestBody Quiz quiz) throws CPException {
		logger.debug("Entering createQuiz");
		logger.info("data of creating Quiz  :" + quiz.toString());

		Quiz createdQuiz = null;
		try {

			Quiz toCheckQuiz = quizService.getQuizBytitle(quiz.getTitle());
			logger.debug("existing quiz :" + toCheckQuiz);

			if (toCheckQuiz == null) {

				createdQuiz = quizService.createQuiz(quiz);
				logger.info("Quiz created :" + createdQuiz);

				return ResponseHandler.generateResponse(createdQuiz, HttpStatus.CREATED);

			} else {

				logger.error(resourceBunde.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (NullPointerException e) {
		
			throw new CPException("err003", resourceBunde.getString("err003"));
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Failed Quiz creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}

	/**
	 * 
	 * 
	 * @param title
	 * @return
	 * @throws CPException
	 * @Description Method to get quiz entry from qiuz table with isactive flag as
	 *              true by providing title
	 */
	@GetMapping("/quiz/{title}")
	public ResponseEntity<Object> getQuizBytitle(@PathVariable("title") String title) throws CPException {
		logger.debug("Entering getQuizBytitle");
		logger.info("entered user name :" + title);

		Quiz quiz = null;

		try {

			quiz = quizService.getQuizBytitle(title);
			logger.info("fetched Quiz :" + quiz);

			if (quiz != null) {
				logger.debug("Quiz fetched generating response");
				return ResponseHandler.generateResponse(quiz, HttpStatus.OK);
			} else {
				logger.debug("Quiz not found");
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting quiz : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	/**
	 * 
	 * 
	 * @param title
	 * @return
	 * @throws CPException
	 * @description method to get quizzes from quiz table with isactive flag as true
	 */
	@GetMapping("/quiz")
	public ResponseEntity<List<Object>> getAllQuiz(@RequestParam(name = "title") String title) throws CPException {
		logger.debug("Entering getAllQuiz");
		logger.info("Parameter  :" + title);

		List<Object> quizs = null;

		try {

			if (title.equalsIgnoreCase("all")) {

				quizs = quizService.getAllQuizs();
				logger.info("Fetched all Quiz :" + quizs);

				return ResponseHandler.generateListResponse(quizs, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all quizs : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

	/**
	 * 
	 * 
	 * @param title
	 * @return
	 * @throws CPException
	 * @description method to perform soft delete
	 */
	@DeleteMapping("/quiz/{title}")
	public ResponseEntity<Object> deleteQuiz(@PathVariable("title") String title) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteQuiz  :" + title);
		// TODO - implement the business logic

		int count = 0;

		try {
			count = quizService.deleteQuizBytitle(title);
			if (count >= 1) {
				logger.info("deleted Quiz : title = " + title);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Failed to delete Quiz :" + ex.getMessage());
			throw new CPException("err005", resourceBunde.getString("err005"));
		}

	}

	/**
	 * 
	 * 
	 * @param quiz
	 * @param title
	 * @return
	 * @throws CPException
	 * @description Method to update an entry in quiz table
	 */
	@PutMapping("/quiz/{title}")
	public ResponseEntity<Object> updateQuiz(@RequestBody Quiz quiz, @PathVariable("title") String title)
			throws CPException {
		logger.debug("Entering updateQuiz");
		logger.info("entered  updateQuiz :" + quiz);

		Quiz updatedQuiz = null;

		try {
			updatedQuiz = quizService.updateQuiz(quiz, title);

			if (updatedQuiz == null) {
				logger.info(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated quiz : " + updatedQuiz);
				return ResponseHandler.generateResponse(updatedQuiz, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Failed update Quiz : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

}
