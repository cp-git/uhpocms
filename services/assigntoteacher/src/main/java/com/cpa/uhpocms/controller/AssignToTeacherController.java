/**
 * @author - Code Generator
 * @createdOn 02-03-2023
 * @Description Controller class for assigntoteacher
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

import com.cpa.uhpocms.entity.AssignToTeacher;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.AssignToTeacherService;

@RestController
@RequestMapping("/uhpocms")
@CrossOrigin
public class AssignToTeacherController {

	@Autowired
	private AssignToTeacherService assigntoteacherService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	AssignToTeacherController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(AssignToTeacherController.class);
	}

	@PostMapping("/assigntoteacher")
	public ResponseEntity<Object> createAssignToTeacher(@RequestBody AssignToTeacher assigntoteacher) throws CPException {
		logger.debug("Entering createAssignToTeacher");
		logger.info("data of creating AssignToTeacher  :" + assigntoteacher.toString());

		AssignToTeacher createdAssignToTeacher = null;
		try {

			AssignToTeacher toCheckAssignToTeacher= null;
		//	AssignToTeacher toCheckAssignToTeacher = assigntoteacherService.getAssignToTeacherBycourseId(assigntoteacher.getCourseId());
			logger.debug("existing assigntoteacher :" + toCheckAssignToTeacher);

			if (toCheckAssignToTeacher == null) {

			// TODO: Uncomment below 2 lines and change the method name as per your Entity class
			//	assigntoteacher.setCreatedby("admin");
			//	assigntoteacher.setUpdatedby("admin");

				createdAssignToTeacher = assigntoteacherService.createAssignToTeacher(assigntoteacher);
				logger.info("AssignToTeacher created :" + createdAssignToTeacher);

				return ResponseHandler.generateResponse(createdAssignToTeacher, HttpStatus.CREATED);

			} else {

				logger.error(resourceBunde.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed AssignToTeacher creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}

	@GetMapping("/assigntoteacher/courseid/{courseId}")
	public ResponseEntity<Object> getAssignToTeacherBycourseId(@PathVariable("courseId") int courseId)
			throws CPException {
		logger.debug("Entering getAssignToTeacherBycourseId");
		logger.info("entered user name :" + courseId);
		
		List<Object> assigntoteacher = null;

		try {

			assigntoteacher = assigntoteacherService.getTeacherBycourseId(courseId);
			logger.info("fetched AssignToTeacher :" + assigntoteacher);

			if (assigntoteacher != null) {
				logger.debug("AssignToTeacher fetched generating response");
				return ResponseHandler.generateResponse(assigntoteacher, HttpStatus.OK);
			} else {
				logger.debug("AssignToTeacher not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting assigntoteacher : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

//	@GetMapping("/assigntoteacher")
//	public ResponseEntity<List<Object>> getAllAssignToTeachers(@RequestParam(name = "courseId") String courseId)
//			throws CPException {
//		logger.debug("Entering getAllAssignToTeacher");
//		logger.info("Parameter  :" + courseId);
//		
//		List<Object> assigntoteachers = null;
//
//		try {
//
//			if (courseId.equalsIgnoreCase("all")) {
//
//				assigntoteachers = assigntoteacherService.getAllAssignToTeachers();
//				logger.info("Fetched all AssignToTeacher :" + assigntoteachers);
//
//				return ResponseHandler.generateListResponse(assigntoteachers, HttpStatus.OK);
//			} else {
//
//				logger.info(resourceBunde.getString("err002"));
//				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
//			}
//
//		} catch (Exception ex) {
//
//			logger.error("Failed getting all assigntoteachers : " + ex.getMessage());
//			throw new CPException("err002", resourceBunde.getString("err002"));
//
//		}
//	}


	
	

	@GetMapping("assigntoteacher/instid_courid/{instId}/{courseId}")
	public ResponseEntity<Object> getTeachersByInstIdAndCourseId(@PathVariable("instId") int instId,@PathVariable("courseId") int courseId)
			throws CPException {
		logger.debug("Entering  getTeachersByInstIdAndCourseId");
		logger.info("entered user name :" + courseId);
		
		List<Object> assigntoteacher = null;

		try {

			assigntoteacher = assigntoteacherService.getProfilesByInstIdandCourId(instId, courseId);
			logger.info("fetched AssignToTeacher :" + assigntoteacher);

			if (assigntoteacher != null) {
				logger.debug("AssignToTeacher fetched generating response");
				return ResponseHandler.generateResponse(assigntoteacher, HttpStatus.OK);
			} else {
				logger.debug("AssignToTeacher not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting assigntoteacher : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}


	}
	 @DeleteMapping("/assigntoteacher/courseid/{courseId}/profileid/{profileId}")
	    public ResponseEntity<Object> deleteAssignToTeacherByCourseIdAndProfileId(
	            @PathVariable("courseId") int courseId, @PathVariable("profileId") int profileId) {
	        int count = assigntoteacherService.deleteAssignToTeacherByCourseIdAndProfileId(courseId, profileId);
	        if (count > 0) {
	            return ResponseEntity.ok().build();
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }

}
