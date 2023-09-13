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

		List<Object> createdEnrollToStudent = null;
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
				
				if(createdEnrollToStudent !=null )
				{
				logger.info("EnrollToStudent created :" + createdEnrollToStudent);

				return ResponseHandler.generateResponse(createdEnrollToStudent, HttpStatus.CREATED);
				}
				
				else{

					logger.error(resourceBunde.getString("err003"));
					return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
				}	
			} 
			else{

					logger.error(resourceBunde.getString("err003"));
					return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
				}

			
		} catch (Exception ex) {
			logger.error("Failed EnrollToStudent creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}


	
	@GetMapping("enrollstudent/courseid/{courseId}")
	public ResponseEntity<Object> getStudentByCourseId(@PathVariable("courseId") int courseId)
			throws CPException {
		logger.debug("Entering getEnrollToStudentBycourseId");
		logger.info("entered user name :" + courseId);
		
		List<Object> enrolltostudent = null;

		try {

			enrolltostudent = enrolltostudentService.getStudentByCourseId(courseId);
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






	
	
	@GetMapping("enrollstudent/instid_courid/{instId}/{courseId}")
	public ResponseEntity<Object> getStudentByInstIdAndCourseId(@PathVariable("instId") int instId,@PathVariable("courseId") int courseId)
			throws CPException {
		logger.debug("Entering  getStudentByInstIdAndCourseId");
		logger.info("entered user name :" + instId+"   " + courseId);
		
		List<Object> enrolltostudent = null;

		try {

			enrolltostudent = enrolltostudentService.getProfilesByInstIdandCourId(instId, courseId);
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

	 @DeleteMapping("/enrollstudent/courseid/{courseId}/profileid/{profileId}")
	    public ResponseEntity<Object> deleteEnrollToStudentByCourseIdAndProfileId(
	            @PathVariable("courseId") int courseId, @PathVariable("profileId") int profileId) {
	        int count = enrolltostudentService.deleteEnrollToStudentByCourseIdAndProfileId(courseId, profileId);
	        if (count > 0) {
	            return ResponseEntity.ok().build();
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }

}
