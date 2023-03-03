/**
 * @author - Code Generator
 * @createdOn 23-02-2023
 * @Description Controller class for enrolltostudent
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

import com.cpa.uhpocms.entity.EnrollToStudent;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.EnrollToStudentService;

@CrossOrigin
@RestController
@RequestMapping("/uhpocms")
public class EnrollToStudentController {

	@Autowired
	private EnrollToStudentService enrolltostudentService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	EnrollToStudentController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(EnrollToStudentController.class);
	}

	@PostMapping("/enrollstudent/")
	public ResponseEntity<Object> createEnrollToStudent(@RequestBody EnrollToStudent enrolltostudent) throws CPException {
		logger.debug("Entering createEnrollToStudent");
		logger.info("data of creating EnrollToStudent  :" + enrolltostudent.toString());

		EnrollToStudent createdEnrollToStudent = null;
		try {
			//comment

//			EnrollToStudent toCheckEnrollToStudent = enrolltostudentService.getAllEnrollToStudents();
			
			EnrollToStudent toCheckEnrollToStudent = null;

			logger.debug("existing enrolltostudent :" + toCheckEnrollToStudent);

			if (toCheckEnrollToStudent == null) {

			// TODO: Uncomment below 2 lines and change the method name as per your Entity class
			//	enrolltostudent.setCreatedby("admin");
			//	enrolltostudent.setUpdatedby("admin");

				createdEnrollToStudent = enrolltostudentService.createEnrollToStudent(enrolltostudent);
				logger.info("EnrollToStudent created :" + createdEnrollToStudent);

				return ResponseHandler.generateResponse(createdEnrollToStudent, HttpStatus.CREATED);

			} else {

				logger.error(resourceBunde.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed EnrollToStudent creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}

	@GetMapping("/enrollstudent/{courseId}")
	public ResponseEntity<Object> getEnrollToStudentBycourseId(@PathVariable("courseId") int courseId)
			throws CPException {
		logger.debug("Entering getEnrollToStudentBycourseId");
		logger.info("entered user name :" + courseId);
		
		EnrollToStudent enrolltostudent = null;

		try {

			enrolltostudent = enrolltostudentService.getEnrollToStudentBycourseId(courseId);
			logger.info("fetched EnrollToStudent :" + enrolltostudent);

			if (enrolltostudent != null) {
				logger.debug("EnrollToStudent fetched generating response");
				return ResponseHandler.generateResponse(enrolltostudent, HttpStatus.OK);
			} else {
				logger.debug("EnrollToStudent not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting enrolltostudent : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

//	@GetMapping("/enrollstudent")
//	public ResponseEntity<List<Object>> getAllEnrollToStudents(@RequestParam(name = "courseId") String courseId)
//			throws CPException {
//		logger.debug("Entering getAllEnrollToStudent");
//		logger.info("Parameter  :" + courseId);
//		
//		List<Object> enrolltostudents = null;
//
//		try {
//
//			if (courseId.equalsIgnoreCase("all")) {
//
//				enrolltostudents = enrolltostudentService.getAllEnrollToStudents();
//				logger.info("Fetched all EnrollToStudent :" + enrolltostudents);
//
//				return ResponseHandler.generateListResponse(enrolltostudents, HttpStatus.OK);
//			} else {
//
//				logger.info(resourceBunde.getString("err002"));
//				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
//			}
//
//		} catch (Exception ex) {
//
//			logger.error("Failed getting all enrolltostudents : " + ex.getMessage());
//			throw new CPException("err002", resourceBunde.getString("err002"));
//
//		}
//	}

	@DeleteMapping("/enrollstudent/{courseId}")
	public ResponseEntity<Object> deleteEnrollToStudentBycourseId(@PathVariable("courseId") int courseId) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteEnrollToStudent  :" + courseId);
		//TODO - implement the business logic
		
		int count = 0;

		try {
			count = enrolltostudentService.deleteEnrollToStudentBycourseId(courseId);
			if (count >= 1) {
				logger.info("deleted EnrollToStudent : courseId = " + courseId);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete EnrollToStudent :" + ex.getMessage());
			throw new CPException("err005", resourceBunde.getString("err005"));
		}
		

	}

	@PutMapping("/enrollstudent/{courseId}")
	public ResponseEntity<Object> updateEnrollToStudentBycourseId(@RequestBody EnrollToStudent enrolltostudent,
			@PathVariable("courseId") int courseId) throws CPException {
		logger.debug("Entering updateEnrollToStudent");
		logger.info("entered  updateEnrollToStudent :" + enrolltostudent);

		EnrollToStudent updatedEnrollToStudent = null;

		try { 
			updatedEnrollToStudent = enrolltostudentService.updateEnrollToStudentBycourseId(enrolltostudent, courseId);

			if (updatedEnrollToStudent == null) {
				logger.info(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated enrolltostudent : " + updatedEnrollToStudent);
				return ResponseHandler.generateResponse(updatedEnrollToStudent, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update EnrollToStudent : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

}
