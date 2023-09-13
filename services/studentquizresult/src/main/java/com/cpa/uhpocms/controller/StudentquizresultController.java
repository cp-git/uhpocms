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

	
	//ADD AND UPDATE STUDENT ANSWER
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


	// GET STUDENT ANSWER BY STUDENT ID AND QUIZ ID
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
}



