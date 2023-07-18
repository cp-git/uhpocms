/**
 * @author - Code Generator
 * @createdOn 05-04-2023
 * @Description Controller class for courseprogress
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

import com.cpa.uhpocms.entity.CourseProgress;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.CourseProgressService;

@CrossOrigin
@RestController
@RequestMapping("/uhpocms")
public class CourseProgressController {

	@Autowired
	private CourseProgressService courseprogressService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	CourseProgressController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(CourseProgressController.class);
	}

	/**
	 * @author shradha
	 * @param courseprogress
	 * @return
	 * @throws CPException
	 * @desc Api to create an entry in table
	 */
	@PostMapping("/courseprog")
	public ResponseEntity<Object> createCourseProgress(@RequestBody CourseProgress courseprogress) throws CPException {
		logger.debug("Entering createCourseProgress");
		logger.info("data of creating CourseProgress  :" + courseprogress.toString());

		CourseProgress createdCourseProgress = null;
		try {

			CourseProgress toCheckCourseProgress = courseprogressService.getCourseProgressByid(courseprogress.getId());
			logger.debug("existing courseprogress :" + toCheckCourseProgress);

			if (toCheckCourseProgress == null) {

				createdCourseProgress = courseprogressService.createCourseProgress(courseprogress);
				if (createdCourseProgress != null) {

					logger.info("CourseProgress created :" + createdCourseProgress);

					return ResponseHandler.generateResponse(createdCourseProgress, HttpStatus.CREATED);

				} else {
					logger.error(resourceBunde.getString("err003"));
					return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
				}
			} else {

				logger.error(resourceBunde.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed CourseProgress creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}

	@GetMapping("/courseprog/courseId/{id}")
	public ResponseEntity<Object> getCourseProgressByCourseId(@PathVariable("id") int id) throws CPException {
		logger.debug("Entering getCourseProgressByid");
		logger.info("entered user name :" + id);

		List<Object> courseprogress = null;

		try {

			courseprogress = courseprogressService.getCourseProgressByCourseId(id);
			logger.info("fetched CourseProgress :" + courseprogress);

			if (courseprogress != null) {
				logger.debug("CourseProgress fetched generating response");
				return ResponseHandler.generateResponse(courseprogress, HttpStatus.OK);
			} else {
				logger.debug("CourseProgress not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting courseprogress : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	/**
	 * 
	 * @author shradha
	 * @param courId
	 * @param studId
	 * @return
	 * @throws CPException
	 * @desc Get course by course and student id
	 */
	@GetMapping("/courseprog/{courId}/{studId}")
	public ResponseEntity<Object> getCourseProgressByCourseId(@PathVariable("courId") int courId,
			@PathVariable("studId") int studId) throws CPException {
		logger.debug("Entering getCourseProgressByCourseId");
		logger.info("entered course and student id :" + courId + "   " + studId);

		CourseProgress courseprogress = null;

		try {

			courseprogress = courseprogressService.getCourseProgressByCourseIdStudId(courId, studId);
			logger.info("fetched CourseProgress :" + courseprogress);

			if (courseprogress != null) {
				logger.debug("CourseProgress fetched generating response");
				return ResponseHandler.generateResponse(courseprogress, HttpStatus.OK);
			} else {
				logger.debug("CourseProgress not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting courseprogress : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	/**
	 * @author shradha
	 * @param id
	 * @return
	 * @throws CPException
	 * @desc get all entries in table
	 */
	@GetMapping("/courseprog")
	public ResponseEntity<List<Object>> getAllCourseProgresss(@RequestParam(name = "id") String id) throws CPException {
		logger.debug("Entering getAllCourseProgress");
		logger.info("Parameter  :" + id);

		List<Object> courseprogresss = null;

		try {

			if (id.equalsIgnoreCase("all")) {

				courseprogresss = courseprogressService.getAllCourseProgresss();
				logger.info("Fetched all CourseProgress :" + courseprogresss);

				return ResponseHandler.generateListResponse(courseprogresss, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all courseprogresss : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

	/**
	 * @author shradha
	 * @param id
	 * @return
	 * @throws CPException
	 * @desc dekte an entry in table
	 */
	@DeleteMapping("/courseprog/{id}")
	public ResponseEntity<Object> deleteCourseProgressByid(@PathVariable("id") int id) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteCourseProgress  :" + id);
		// TODO - implement the business logic

		int count = 0;

		try {
			count = courseprogressService.deleteCourseProgressByid(id);
			if (count >= 1) {
				logger.info("deleted CourseProgress : id = " + id);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete CourseProgress :" + ex.getMessage());
			throw new CPException("err005", resourceBunde.getString("err005"));
		}

	}

	@PutMapping("/courseprog/{id}")
	public ResponseEntity<Object> updateCourseProgressByid(@RequestBody CourseProgress courseprogress,
			@PathVariable("id") int id) throws CPException {
		logger.debug("Entering updateCourseProgress");
		logger.info("entered  updateCourseProgress :" + courseprogress);

		CourseProgress updatedCourseProgress = null;

		try {
			updatedCourseProgress = courseprogressService.updateCourseProgressByid(courseprogress, id);

			if (updatedCourseProgress == null) {
				logger.info(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated courseprogress : " + updatedCourseProgress);
				return ResponseHandler.generateResponse(updatedCourseProgress, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update CourseProgress : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

	/**
	 * @author shradha
	 * @param id
	 * @return
	 * @throws CPException
	 * @desc get en entry by providing id
	 */
	@GetMapping("/courseprog/{id}")
	public ResponseEntity<Object> getCourseProgressByid(@PathVariable("id") int id) throws CPException {
		logger.debug("Entering getCourseProgressByid");
		logger.info("entered user name :" + id);

		CourseProgress courseprogress = null;

		try {

			courseprogress = courseprogressService.getCourseProgressByid(id);
			logger.info("fetched CourseProgress :" + courseprogress);

			if (courseprogress != null) {
				logger.debug("CourseProgress fetched generating response");
				return ResponseHandler.generateResponse(courseprogress, HttpStatus.OK);
			} else {
				logger.debug("CourseProgress not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting courseprogress : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	@DeleteMapping("/courseprog/courseid/{courseId}/studentid/{studentId}")
	public ResponseEntity<Object> deleteCourseProgressByCourseIdAndStudentId(@PathVariable("courseId") int courseId,
			@PathVariable("studentId") int studId) {
		int count = courseprogressService.deleteCourseProgressByCourseIdAndStudentId(courseId, studId);
		if (count > 0) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
