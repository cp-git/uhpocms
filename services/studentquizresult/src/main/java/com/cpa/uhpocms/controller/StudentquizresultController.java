/**
 * @author - Code Generator
 * @createdOn 01-06-2023
 * @Description Controller class for studentquizresult
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.uhpocms.entity.Studentquizresult;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.StudentquizresultService;

@CrossOrigin
@RestController
@RequestMapping("/uhpocms")
public class StudentquizresultController {

	@Autowired
	private StudentquizresultService studentquizresultService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	StudentquizresultController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(StudentquizresultController.class);
	}

	@PutMapping("/quizresult")
	public ResponseEntity<Object> addAndUpdateStudentAnswer(@RequestBody Studentquizresult studentquizresult)
			throws CPException {
		logger.debug("Entering addAndUpdateStudentAnswer");
		logger.info("Data of creating Studentquizresult: " + studentquizresult.toString());

		try {
			Studentquizresult createdStudentquizresult = null;

			Studentquizresult existingStudentquizresults = studentquizresultService
					.getStudentAnswerByProfileIdAndQuestionId(studentquizresult.getStudentId(),
							studentquizresult.getQuestionId());
			logger.debug("Existing Studentquizresult: " + existingStudentquizresults);

			if (existingStudentquizresults == null) {
				// Create a new Studentquizresult

				createdStudentquizresult = studentquizresultService.createStudentquizresult(studentquizresult);
				logger.info("Studentquizresult created: " + createdStudentquizresult);

				return ResponseHandler.generateResponse(createdStudentquizresult, HttpStatus.CREATED);
			} else {
				// Update the existing Studentquizresult
				Studentquizresult updatedStudentquizresult = studentquizresultService
						.updateStudentquizresultByquestionid(studentquizresult);

				if (updatedStudentquizresult == null) {
					logger.error(resourceBunde.getString("err003"));
					return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
				} else {
					// Handle the case when the update operation fails
					// Return an appropriate response
					return ResponseHandler.generateResponse(createdStudentquizresult, HttpStatus.CREATED);
				}
			}

		} catch (Exception ex) {
			throw new CPException("err003", resourceBunde.getString("err003"));
		}

	}

	@GetMapping("/quizresult/{quizid}")
	public ResponseEntity<List<Object>> getStudentquizresultByQuizId(@PathVariable("quizid") int quizid)
			throws CPException {
		logger.debug("Entering getStudentquizresultByQuizId");
		logger.info("entered quiz id:" + quizid);

		List<Object> objectResult = null;

		try {

			List<Object> studentquizresult = studentquizresultService.getStudentquizresultByQuizId(quizid);
			logger.info("fetched Studentquizresult :" + studentquizresult);

			if (!studentquizresult.isEmpty()) {
				logger.debug("Studentquizresult fetched generating response");
				return ResponseHandler.generateListResponse(studentquizresult, HttpStatus.OK);
			} else {
				logger.debug("Studentquizresult not found");
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting studentquizresult : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	@GetMapping("/quizresult/{studentid}/{quizid}")
	public ResponseEntity<List<Object>> getStudentAnswerByStudentIdAndQuizId(@PathVariable("studentid") int studentid,
			@PathVariable("quizid") int quizid) throws CPException {
		logger.debug("Entering getStudentquizresultByQuizId");
		logger.info("entered quiz id:" + quizid);

		List<Object> objectResult = null;

		try {

			List<Object> studentquizresult = studentquizresultService.getStudentquizresultByStudentAndQuizId(studentid,
					quizid);
			logger.info("fetched Studentquizresult :" + studentquizresult);

			if (!studentquizresult.isEmpty()) {
				logger.debug("Studentquizresult fetched generating response");
				return ResponseHandler.generateListResponse(studentquizresult, HttpStatus.OK);
			} else {
				logger.debug("Studentquizresult not found");
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting studentquizresult : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

//	@GetMapping("/quizresult")
//	public ResponseEntity<List<Object>> getAllStudentquizresults(@RequestParam(name = "questionid") String questionid)
//			throws CPException {
//		logger.debug("Entering getAllStudentquizresult");
//		logger.info("Parameter  :" + questionid);
//		
//		List<Object> studentquizresults = null;
//
//		try {
//
//			if (questionid.equalsIgnoreCase("all")) {
//
//				studentquizresults = studentquizresultService.getAllStudentquizresults();
//				logger.info("Fetched all Studentquizresult :" + studentquizresults);
//
//				return ResponseHandler.generateListResponse(studentquizresults, HttpStatus.OK);
//			} else {
//
//				logger.info(resourceBunde.getString("err002"));
//				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
//			}
//
//		} catch (Exception ex) {
//
//			logger.error("Failed getting all studentquizresults : " + ex.getMessage());
//			throw new CPException("err002", resourceBunde.getString("err002"));
//
//		}
//	}
//}

//	@DeleteMapping("/quizresult/{questionid}")
//	public ResponseEntity<Object> deleteStudentquizresultByquestionid(@PathVariable("questionid") int questionid) throws CPException {
//		logger.debug("Entering deleteAuthUser");
//		logger.info("entered deleteStudentquizresult  :" + questionid);
//		//TODO - implement the business logic
//		
//		int count = 0;
//
//		try {
//			count = studentquizresultService.deleteStudentquizresultByquestionid(questionid);
//			if (count >= 1) {
//				logger.info("deleted Studentquizresult : questionid = " + questionid);
//				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
//			} else {
//				logger.info(resourceBunde.getString("err005"));
//				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
//			}
//
//		} catch (Exception ex) {
//			logger.error("Failed to delete Studentquizresult :" + ex.getMessage());
//			throw new CPException("err005", resourceBunde.getString("err005"));
//		}
//		
//
//	}
//}
//	@PutMapping("/quizresult/{questionid}")
//	public ResponseEntity<Object> updateStudentquizresultByquestionid(@RequestBody Studentquizresult studentquizresult,
//			@PathVariable("questionid") String questionid) throws CPException {
//		logger.debug("Entering updateStudentquizresult");
//		logger.info("entered  updateStudentquizresult :" + studentquizresult);
//
//		Studentquizresult updatedStudentquizresult = null;
//
//		try { 
//			updatedStudentquizresult = studentquizresultService.updateStudentquizresultByquestionid(studentquizresult, questionid);
//
//			if (updatedStudentquizresult == null) {
//				logger.info(resourceBunde.getString("err004"));
//				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
//			} else {
//				logger.info("updated studentquizresult : " + updatedStudentquizresult);
//				return ResponseHandler.generateResponse(updatedStudentquizresult, HttpStatus.CREATED);
//			}
//
//		} catch (Exception ex) {
//			logger.error("Failed update Studentquizresult : " + ex.getMessage());
//			throw new CPException("err004", resourceBunde.getString("err004"));
//
//		}
//
//	}
//
}
