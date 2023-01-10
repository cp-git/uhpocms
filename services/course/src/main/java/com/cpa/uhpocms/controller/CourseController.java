/**
 * @author - Code Generator
 * @createdOn 10-01-2023
 * @Description Controller class for course
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

import com.cpa.uhpocms.entity.Course;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.CourseService;

@CrossOrigin
@RestController
@RequestMapping("/uhpocms")
public class CourseController {

	@Autowired
	private CourseService courseService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	CourseController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(CourseController.class);
	}

	@PostMapping("/course")
	public ResponseEntity<Object> createCourse(@RequestBody Course course) throws CPException {
		logger.debug("Entering createCourse");
		logger.info("data of creating Course  :" + course.toString());

		Course createdCourse = null;
		try {

			Course toCheckCourse = courseService.getCourseByName(course.getCourseName());
			logger.debug("existing course :" + toCheckCourse);

			if (toCheckCourse == null) {

				// TODO: Uncomment below 2 lines and change the method name as per your Entity
				// class
				course.setCourseCreatedBy("admin");
				course.setCourseUpdatedBy("admin");

				createdCourse = courseService.createCourse(course);
				logger.info("Course created :" + createdCourse);

				return ResponseHandler.generateResponse(createdCourse, HttpStatus.CREATED);

			} else {

				logger.error(resourceBunde.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed Course creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}

	@GetMapping("/course/{name}")
	public ResponseEntity<Object> getCourseByName(@PathVariable("name") String name) throws CPException {
		logger.debug("Entering getCourseByname");
		logger.info("entered user name :" + name);

		Course course = null;

		try {

			course = courseService.getCourseByName(name);
			logger.info("fetched Course :" + course);

			if (course != null) {
				logger.debug("Course fetched generating response");
				return ResponseHandler.generateResponse(course, HttpStatus.OK);
			} else {
				logger.debug("Course not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting course : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	@GetMapping("/course")
	public ResponseEntity<List<Object>> getAllCourses(@RequestParam(name = "name") String name) throws CPException {
		logger.debug("Entering getAllCourse");
		logger.info("Parameter  :" + name);

		List<Object> courses = null;

		try {

			if (name.equalsIgnoreCase("all")) {

				courses = courseService.getAllCourses();
				logger.info("Fetched all Course :" + courses);

				return ResponseHandler.generateListResponse(courses, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all courses : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

	@DeleteMapping("/course/{name}")
	public ResponseEntity<Object> deleteCourseByName(@PathVariable("name") String name) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteCourse  :" + name);
		// TODO - implement the business logic

		int count = 0;

		try {
			count = courseService.deleteCourseByName(name);
			if (count >= 1) {
				logger.info("deleted Course : Name = " + name);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete Course :" + ex.getMessage());
			throw new CPException("err005", resourceBunde.getString("err005"));
		}

	}

	@PutMapping("/course/{name}")
	public ResponseEntity<Object> updateCourseByName(@RequestBody Course course, @PathVariable("name") String name)
			throws CPException {
		logger.debug("Entering updateCourse");
		logger.info("entered  updateCourse :" + course);

		Course updatedCourse = null;

		try {
			updatedCourse = courseService.updateCourseByName(course, name);

			if (updatedCourse == null) {
				logger.info(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated course : " + updatedCourse);
				return ResponseHandler.generateResponse(updatedCourse, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update Course : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

}
