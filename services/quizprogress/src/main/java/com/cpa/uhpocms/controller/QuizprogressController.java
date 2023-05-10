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
import org.springframework.context.annotation.Description;
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

import com.cpa.uhpocms.entity.Quizprogress;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.QuizprogressService;

@RestController
@RequestMapping("/uhpocms")
@CrossOrigin
public class QuizprogressController {

	@Autowired
	private QuizprogressService quizprogressService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	// controller
	QuizprogressController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(QuizprogressController.class);
	}

	// For adding quiz progress data in table
	@PostMapping("/quizprogress")
	public ResponseEntity<Object> createQuizprogress(@RequestBody Quizprogress quizprogress) throws CPException {

		logger.debug("Entering createQuizprogress");
		logger.info("data of creating Quizprogress  :" + quizprogress.toString());

		Quizprogress createdQuizprogress = null;

		try {

			Quizprogress toCheckQuizprogress = quizprogressService
					.getQuizprogressByStudentIdAndQuizId(quizprogress.getStudentId(), quizprogress.getQuizId());
			logger.debug("existing quizprogress :" + toCheckQuizprogress);

			if (toCheckQuizprogress == null) {

				createdQuizprogress = quizprogressService.createQuizprogress(quizprogress);
				logger.info("Quizprogress created :" + createdQuizprogress);

				return ResponseHandler.generateResponse(createdQuizprogress, HttpStatus.CREATED);

			} else {
				createdQuizprogress = quizprogressService.updateQuizprogressByStudentIdAndQuizId(quizprogress);
				logger.info("Quizprogress created :" + createdQuizprogress);
//				logger.error(resourceBunde.getString("err003"));
//				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
				return ResponseHandler.generateResponse(createdQuizprogress, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed Quizprogress creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}

	// For getting quiz progress data from table using student id and quizId
	@GetMapping("/quizprogress/{quizId}/{studentId}")
	public ResponseEntity<Object> getQuizprogressByStudentIdAndQuizId(@PathVariable("studentId") int studentId,
			@PathVariable("quizId") int quizId) throws CPException {

		logger.debug("Entering getQuizprogressBystudentId");
		logger.info("entered user name : " + studentId + " quizid : " + quizId);

		Quizprogress quizprogress = null;

		try {

			quizprogress = quizprogressService.getQuizprogressByStudentIdAndQuizId(studentId, quizId);
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

	/**
	 * @author shradha
	 * @param studentId
	 * @param quizId
	 * @return
	 * @throws CPException
	 * @Description For getting quiz progress data from table using student id and quizId and is completed status as true

	 */
	// For getting quiz progress data from table using student id and quizId and is completed status as true
		@GetMapping("/quizprogress/progress/{quizId}/{studentId}")
		public ResponseEntity<Object> getQuizprogressByStudentIdAndQuizIdProg(@PathVariable("studentId") int studentId,
				@PathVariable("quizId") int quizId) throws CPException {

			logger.debug("Entering getQuizprogressByStudentIdAndQuizIdProg");
			logger.info("entered user name : " + studentId + " quizid : " + quizId);

			Quizprogress quizprogress = null;

			try {

				quizprogress = quizprogressService.getQuizprogressByStudentIdAndQuizIdProg(studentId, quizId);
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

	
	
	
	// For getting quiz progress all data from table
	@GetMapping("/quizprogress")
	public ResponseEntity<List<Object>> getAllQuizprogresss(@RequestParam(name = "data") String data)
			throws CPException {
		logger.debug("Entering getAllQuizprogress");
		logger.info("Parameter  :" + data);

		List<Object> quizprogresss = null;

		try {

			if (data.equalsIgnoreCase("all")) {

				quizprogresss = quizprogressService.getAllQuizprogress();
				logger.info("Fetched all Quizprogress :" + quizprogresss.size());

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

	// For getting quiz progress all data from table
	@GetMapping("/quizprogress/{studentId}")
	public ResponseEntity<List<Object>> getAllQuizprogresssByStudentId(@PathVariable("studentId") int studentId)
			throws CPException {
		logger.debug("Entering getAllQuizprogresssByStudentId");
		logger.info("Parameter  :" + studentId);

		List<Object> quizprogresses = null;

		try {

			quizprogresses = quizprogressService.getQuizprogressBystudentId(studentId);
			logger.info("fetched Quizprogress :" + quizprogresses);

			if (quizprogresses != null) {
				logger.debug("Quizprogress fetched generating response");
				return ResponseHandler.generateListResponse(quizprogresses, HttpStatus.OK);
			} else {
				logger.debug("Quizprogress not found");
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all quizprogresss : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

	// For deleting quiz progress data from table using student id and quizId
	@DeleteMapping("/quizprogress/{quizId}/{studentId}")
	public ResponseEntity<Object> deleteQuizprogressByStudentIdAndQuizId(@PathVariable("quizId") int quizId,
			@PathVariable("studentId") int studentId) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteQuizprogress  :" + studentId);
		// TODO - implement the business logic

		int count = 0;

		try {
			count = quizprogressService.deleteQuizprogressByStudentIdAndQuizId(studentId, quizId);
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

	// For update quiz progress data in table using student id and quizId
	@PutMapping("/quizprogress/{quizId}/{studentId}")
	public ResponseEntity<Object> updateQuizprogressBystudentId(@RequestBody Quizprogress quizprogress,
			@PathVariable("studentId") int studentId, @PathVariable("quizId") int quizId) throws CPException {
		logger.debug("Entering updateQuizprogress");
		logger.info("entered  updateQuizprogress :" + quizprogress);

		Quizprogress updatedQuizprogress = null;

		try {
			updatedQuizprogress = quizprogressService.updateQuizprogressByStudentIdAndQuizId(quizprogress);

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
