/**
 * @author - Code Generator
 * @createdOn 10-01-2023
 * @Description Controller class for course
 * 
 */

package com.cpa.uhpocms.controller;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.uhpocms.entity.AuthenticationBean;
import com.cpa.uhpocms.entity.Course;
import com.cpa.uhpocms.entity.CourseDepartment;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.repository.CourseDepartmentRepo;
import com.cpa.uhpocms.repository.CourseRepo;
import com.cpa.uhpocms.service.CourseDepartmentService;
import com.cpa.uhpocms.service.CourseService;

@CrossOrigin
@RestController
@RequestMapping("/uhpocms")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private CourseDepartmentService courseDepartmentService;

	@Autowired
	private CourseDepartmentRepo courseDeptRepo;

	@Autowired
	private CourseRepo courseRepo;

	@Value("${file.base-path}")
	private String basePath;

	private ResourceBundle resourceBundle;
	private static Logger logger;

	CourseController() {
		resourceBundle = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(CourseController.class);
	}

	@PostMapping("/course")
	public ResponseEntity<Object> createCourse(@RequestBody Course course) throws CPException {
		logger.debug("Entering createCourse");
		logger.info("data of creating Course  :" + course.toString());

		Course createdCourse = null;
		try {

			course.setCourseCreatedBy("admin");
			course.setCourseUpdatedBy("admin");

			createdCourse = courseService.createCourse(course);
			logger.info("Course created :" + createdCourse);



			if (createdCourse != null) {

				return ResponseHandler.generateResponse(createdCourse, HttpStatus.CREATED);

			} else {

				logger.error(resourceBundle.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed Course creation : " + ex.getMessage());
			throw new CPException("err003", resourceBundle.getString("err003"));
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
			} else if (name.equalsIgnoreCase("inactive")) {

				courses = courseService.getAllInactiveCourses();
				logger.info("Fetched all inactive Course :" + courses);

				return ResponseHandler.generateListResponse(courses, HttpStatus.OK);
			} else {

				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all courses : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));

		}
	}



	@DeleteMapping("/course/courseId/{id}")
	public ResponseEntity<Object> deleteCourseByCourseId(@PathVariable("id") int courseid) throws CPException {
		logger.debug("Entering deleteAuthUser");

		int count = 0;

		try {
			count = courseService.deleteCourseByCourseId(courseid);
			if (count >= 1) {

				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBundle.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete Course :" + ex.getMessage());
			throw new CPException("err005", resourceBundle.getString("err005"));
		}

	}



	@GetMapping(path = "course/profileId/{id}")
	public ResponseEntity<List<Object>> getCourseByProfileId(@PathVariable("id") int profile_id) throws CPException {
		logger.debug("Entering getAllCourse");
		logger.info("Parameter  :");
		List<Object> courses = null;
		try {
			if (profile_id >= 0) {
				courses = courseService.findCourseByProfileId(profile_id);
				logger.info("Fetched all Course :" + courses);
				return ResponseHandler.generateListResponse(courses, HttpStatus.OK);
			} else {
				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}
		} catch (Exception ex) {
			logger.error("Failed getting all courses : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));
		}
	}

	@GetMapping(path = "course/deptId/{id}")
	public ResponseEntity<List<Object>> getCoursesByDepartmentId(@PathVariable("id") int department_id)
			throws CPException {
		logger.debug("Entering getAllCourse");
		logger.info("Parameter  :");
		List<Object> courses = null;
		try {
			if (department_id >= 0) {
				courses = courseService.findCoursesByDepartmentId(department_id);
				logger.info("Fetched all Course :" + courses);
				return ResponseHandler.generateListResponse(courses, HttpStatus.OK);
			} else {
				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}
		} catch (Exception ex) {
			logger.error("Failed getting all courses : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));
		}
	}



	@GetMapping(path = "/basicauth")
	public AuthenticationBean basicauth() {
		return new AuthenticationBean("You are authenticated");
	}

	@GetMapping(path = "course/institutionId/{id}")
	public ResponseEntity<List<Object>> getCourseByInstitutionId(@PathVariable("id") int institutionId)
			throws CPException {

		logger.debug("Entering getAllCourse");
		logger.info("Parameter  :");

		List<Object> courses;

		try {
			courses = courseService.findByInstitutionId(institutionId);
			System.out.println(courses);
			logger.info("Fetched all Course :" + courses);

			if (institutionId >= 0) {
				return ResponseHandler.generateListResponse(courses, HttpStatus.OK);
			} else {

				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all courses : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));

		}
	}

	@PatchMapping(path = "/course/activate/{id}")
	public ResponseEntity<Object> activateCourseById(@PathVariable("id") int courseId) throws CPException {
		logger.debug("Entering activateCourseById");
		logger.info("entered activateCourseById  :" + courseId);
		// TODO - implement the business logic

		int count = 0;

		try {
			count = courseService.activateCourseById(courseId);
			if (count >= 1) {
				logger.info("activated Course : Id = " + courseId);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBundle.getString("err006"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err006");
			}

		} catch (Exception ex) {
			logger.error("Failed to activate Course :" + ex.getMessage());
			throw new CPException("err006", resourceBundle.getString("err006"));
		}
	}

	@GetMapping(path = "course/teacherid/{id}")
	public ResponseEntity<List<Object>> getCourseAssignToTeacher(@PathVariable("id") int profile_id)
			throws CPException {
		logger.debug("Entering getAllCourse");
		logger.info("Parameter  :");
		List<Object> courses = null;
		try {
			if (profile_id >= 0) {
				courses = courseService.findCoursesAssignToTeacher(profile_id);
				logger.info("Fetched all Course :" + courses);
				return ResponseHandler.generateListResponse(courses, HttpStatus.OK);
			} else {
				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}
		} catch (Exception ex) {
			logger.error("Failed getting all courses : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));
		}
	}

	@GetMapping(path = "course/inactive/teacherid/{id}")
	public ResponseEntity<List<Object>> getInactiveCourseAssignToTeacher(@PathVariable("id") int profile_id)
			throws CPException {
		logger.debug("Entering getAllCourse");
		logger.info("Parameter  :");
		List<Object> courses = null;
		try {
			if (profile_id >= 0) {
				courses = courseService.findInactiveCoursesAssignToTeacher(profile_id);
				logger.info("Fetched all Course :" + courses);
				return ResponseHandler.generateListResponse(courses, HttpStatus.OK);
			} else {
				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}
		} catch (Exception ex) {
			logger.error("Failed getting all courses : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));
		}
	}

	@PostMapping(path = "/course/department")
	public ResponseEntity<Object> assignCourseToDepartment(@RequestBody CourseDepartment courseDepartment)
			throws CPException {
		logger.debug("Entering assignCourseToDepartment");

		try {

			// List of Courses by Department
			List<Course> CoursesByDepartment = courseRepo.findCourseByDepartmentId(courseDepartment.getDepartment_id());
			// System.out.println("Courses Based on Department...."+CoursesByDepartment);

			// Course By id
			Course course = courseRepo.findByCourseId(courseDepartment.getCourseId());
			// System.out.println("course Object.."+course);

			// Find All CourseDepartment
			List<CourseDepartment> courseDepartments = courseDeptRepo.findAll();
			// System.out.println("All Data"+courseDepartments);

			for (CourseDepartment dp : courseDepartments) {
				if (dp.getDepartment_id() == courseDepartment.getDepartment_id()) {

			   
					for (Course c : CoursesByDepartment) {
						// System.out.println("In Loop..."+c);



						if (c.getCourseName().equalsIgnoreCase(course.getCourseName())) {
							throw new CPException("err001", resourceBundle.getString("err001"));

						}

					}
				}
			}

			CourseDepartment assignedCourseDepartment = null;
			assignedCourseDepartment = courseService.assignCourseToDepartment(courseDepartment);
			logger.debug("assigned course :" + assignedCourseDepartment);

			if (assignedCourseDepartment != null) {

				String departmentName = courseDeptRepo.finByAdminInstitutionId(courseDepartment.getDepartment_id());
				
				String instituteName = courseDeptRepo.finByAdminInstitutionByCourseId(courseDepartment.getCourseId());
				

				int instituteId = courseDeptRepo.finByAdminInstitutionsByCourseId(courseDepartment.getCourseId());
				

				String instituteNameAndId = instituteName + "_" + instituteId;
			

				String courseName = courseDeptRepo.finByCourseByCourseId(courseDepartment.getCourseId());
				

				File theDir = new File(
						basePath + "/institute/" + instituteNameAndId + "/" + departmentName + "/" + courseName);
				
				if (!theDir.exists()) {
					theDir.mkdirs();
				}

				return ResponseHandler.generateResponse(assignedCourseDepartment, HttpStatus.CREATED);

			} else {

				logger.error(resourceBundle.getString("err006"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err006");
			}

		} catch (Exception ex) {
			logger.error("Failed Course assign : " + ex.getMessage());
			throw new CPException("err006", resourceBundle.getString("err006"));
		}
	}

	@PutMapping("/course/courseID/{id}")
	public ResponseEntity<Object> updateCourseById(@RequestBody Course course, @PathVariable("id") int courseid)
			throws CPException {
		logger.debug("Entering updateCourse");
		logger.info("entered  updateCourse :" + course);

		Course updatedCourse = null;

		try {
			updatedCourse = courseService.updateCourseById(course, courseid);

			if (updatedCourse == null) {
				logger.info(resourceBundle.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated course : " + updatedCourse);
				return ResponseHandler.generateResponse(updatedCourse, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update Course : " + ex.getMessage());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}

	}

	@GetMapping("/course/department")
	public ResponseEntity<List<Object>> getAllCoursesDepartmentId(@RequestParam(name = "id") String name)
			throws CPException {
		logger.debug("Entering getAllCoursesDepartmentId");


		List<Object> courseDepartmentIds = null;

		try {

			if (name.equalsIgnoreCase("all")) {

				courseDepartmentIds = courseDepartmentService.getAllCoursesDepartmentIds();


				return ResponseHandler.generateListResponse(courseDepartmentIds, HttpStatus.OK);
			} else if (name.equalsIgnoreCase("inactive")) {

				courseDepartmentIds = courseService.getAllInactiveCourses();
				logger.info("Fetched all inactive Course :" + courseDepartmentIds);

				return ResponseHandler.generateListResponse(courseDepartmentIds, HttpStatus.OK);
			} else {

				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all courses : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));

		}
	}
	
	@GetMapping(path = "course/inactive/institutionId/{id}")
	public ResponseEntity<List<Object>> getInactiveCourseByInstitutionId(@PathVariable("id") int institutionId)
			throws CPException {

		logger.debug("Entering getAllCourse");
		logger.info("Parameter  :");

		List<Object> courses=null;

		try {
			courses = courseService.findInactiveCourseByInstitutionId(institutionId);
			System.out.println(courses);
			logger.info("Fetched all inactive Course :" + courses);

			if (courses!=null) {
				return ResponseHandler.generateListResponse(courses, HttpStatus.OK);
			} else {

				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all courses : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));

		}
	}

}
