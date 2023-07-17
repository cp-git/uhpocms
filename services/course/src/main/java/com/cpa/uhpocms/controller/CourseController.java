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

//			Course toCheckCourse = courseService.getCourseByName(course.getCourseName());
//			logger.debug("existing course :" + toCheckCourse);

			// TODO: Uncomment below 2 lines and change the method name as per your Entity
			// class
			course.setCourseCreatedBy("admin");
			course.setCourseUpdatedBy("admin");

			createdCourse = courseService.createCourse(course);
			logger.info("Course created :" + createdCourse);

//			
//			String instituteName=courseDeptRepo.finByAdminInstitutionByCourseId(course.getCourseId());
//			System.out.println(instituteName);
//			
//
//			int instituteId=courseDeptRepo.finByAdminInstitutionsByCourseId(course.getCourseId());
//			System.out.println(instituteId);
//			
//			String instituteNameAndId=instituteName+"_"+instituteId;
//			
//			String departmentName=courseDeptRepo.finByDepartmentInstitutionId(course.getCourseId());
//			System.out.println(departmentName);
//			
//			
//
//			
//			
//			
//			
//			System.out.println(course.getCourseName());
//			
//			
//			File theDir = new File(basePath+"/institute/"+instituteNameAndId+"/"+departmentName+"/"+course.getCourseName());
//			System.out.println(theDir);
//			if (!theDir.exists()){
//			    theDir.mkdirs();
//			}
//			

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
			throw new CPException("err001", resourceBundle.getString("err001"));
		}

	}

	@GetMapping("/course/courseId/{id}")
	public ResponseEntity<Object> getCourseByCourseId(@PathVariable("id") int courseid) throws CPException {
		logger.debug("Entering getCourseByCourseId");

		Course course = null;

		try {

			course = courseService.getCourseByCourseId(courseid);
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
			throw new CPException("err001", resourceBundle.getString("err001"));
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

	@DeleteMapping("/course/{name}")
	public ResponseEntity<Object> deleteCourseByName(@PathVariable("name") String name) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteCourse  :" + name);

		int count = 0;

		try {
			count = courseService.deleteCourseByName(name);
			if (count >= 1) {
				logger.info("deleted Course : Name = " + name);
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

	@PutMapping("/course/{name}")
	public ResponseEntity<Object> updateCourseByName(@RequestBody Course course, @PathVariable("name") String name)
			throws CPException {
		logger.debug("Entering updateCourse");
		logger.info("entered  updateCourse :" + course);

		Course updatedCourse = null;

		try {
			updatedCourse = courseService.updateCourseByName(course, name);

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

	@GetMapping(path = "/course/department/{department_id}/profile/{profile_id}")

	public ResponseEntity<List<Object>> getCoursesByDepartmentIdAndProfileId(
			@PathVariable("department_id") int department_id, @PathVariable("profile_id") int profile_id)
			throws CPException {
		logger.debug("Entering getAllCourse");
		logger.info("Parameter  :");
		List<Object> courses = null;
		try {
			if (department_id >= 0 && profile_id >= 0) {
				courses = courseService.findCoursesByDepartmentIdAndProfileId(department_id, profile_id);
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

//				   System.out.println("Id of Course Department"+dp.getDepartment_id());
//				   System.out.println("User Enter deptId"+courseDepartment.getDepartment_id());
//				   
					for (Course c : CoursesByDepartment) {
						// System.out.println("In Loop..."+c);

//						 System.out.println("Array Course Name"+c.getCourseName());
//						 System.out.println("course Name"+course.getCourseName());

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
				// System.out.println(departmentName);

				String instituteName = courseDeptRepo.finByAdminInstitutionByCourseId(courseDepartment.getCourseId());
				// System.out.println(instituteName);

				int instituteId = courseDeptRepo.finByAdminInstitutionsByCourseId(courseDepartment.getCourseId());
				// System.out.println(instituteId);

				String instituteNameAndId = instituteName + "_" + instituteId;
				;
				// System.out.println(instituteNameAndId);

				String courseName = courseDeptRepo.finByCourseByCourseId(courseDepartment.getCourseId());
				// System.out.println(courseName);

				File theDir = new File(
						basePath + "/institute/" + instituteNameAndId + "/" + departmentName + "/" + courseName);
				// System.out.println(theDir);
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
//		logger.info("Parameter  :" + name);

		List<Object> courseDepartmentIds = null;

		try {

			if (name.equalsIgnoreCase("all")) {

				courseDepartmentIds = courseDepartmentService.getAllCoursesDepartmentIds();
//				logger.info("Fetched all Course :" + courses);

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
