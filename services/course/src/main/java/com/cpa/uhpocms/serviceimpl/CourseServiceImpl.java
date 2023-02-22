/**
 * @author - Code Generator
 * @createdOn 10-01-2023
 * @Description Controller class for course
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.CourseController;
import com.cpa.uhpocms.entity.Course;
import com.cpa.uhpocms.repository.CourseRepo;
import com.cpa.uhpocms.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepo courseRepo;
	private static Logger logger;

	public CourseServiceImpl() {
		logger = Logger.getLogger(CourseServiceImpl.class);
	}

	/**
	 * @param : Course course
	 * @return : Course createdCourse
	 * @description : For creating/inserting entry in teacher_course table
	 */
	@Override
	public Course createCourse(Course course) {
		logger.debug("Entering createCourse");
		Course createdCourse = null;

		course.setCourseCreatedBy("admin");
		course.setCourseUpdatedBy("admin");

		createdCourse = courseRepo.save(course);
		logger.info("created Course :" + createdCourse);
		return createdCourse;
	}

	/**
	 * @param : String name
	 * @return : Course course
	 * @description : For get entry in teacher_course table
	 */
	@Override
	public Course getCourseByName(String name) {
		logger.debug("Entering getCourseByName");

		Course course = courseRepo.findByCourseName(name);
		logger.info("Founded course :" + course);

		return course;
	}

	/**
	 * @return : List<Object> course
	 * @description : For fetching all course which are active state from
	 *              teacher_course table
	 */
	@Override
	public List<Object> getAllCourses() {
		logger.debug("Entering getAllCourses");

		List<Object> courses = courseRepo.findByCourseIsActiveTrue();
		logger.info("Fetched all active course :" + courses);
		return courses;
	}

	/**
	 * @param : Course to update
	 * @return : course
	 * @description : For updating course of teacher_course table
	 */
	@Override
	public Course updateCourseByName(Course course, String name) {
		logger.debug("Entering updateCourse");

		Course toUpdatedCourse = null;
		Course updatedCourse = null;

		toUpdatedCourse = courseRepo.findByCourseName(name);
		logger.info("exisitng Course :: " + toUpdatedCourse);

		if (toUpdatedCourse != null) {
			logger.debug("setting new data of Course to exisitng Course");

//			course.setModifiedBy("admin");

			toUpdatedCourse.setCourseName(course.getCourseName());
			toUpdatedCourse.setCourseDescription(course.getCourseDescription());
			toUpdatedCourse.setCourseIsActive(course.isCourseIsActive());
			toUpdatedCourse.setCourseCode(course.getCourseCode());
			toUpdatedCourse.setCourseType(course.getCourseType());
			toUpdatedCourse.setPassingScore(course.getPassingScore());
			toUpdatedCourse.setInstId(course.getInstId());

			updatedCourse = courseRepo.save(toUpdatedCourse);

			logger.info("updated Course :" + updatedCourse);
		}

		return updatedCourse;
	}

	/**
	 * @param : String name
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of Course
	 * 
	 */
	@Override
	public int deleteCourseByName(String name) {
		logger.debug("Entering deleteCourseByName");

		int count = courseRepo.deleteCourseByName(name);
		logger.info("deleted Course count : " + count);
		return count;
	}

	@Override

	public List<Object> findCourseByProfileId(int profile_id) {

		List<Object> objectCourses = null;

		List<Course> courses = courseRepo.findTeacherProfileId(profile_id);

		logger.info("Fetched all active course :" + courses);
		objectCourses = new ArrayList<Object>(courses);
		return objectCourses;
	}

	public List<Object> findByInstitutionId(int institutionId) {
		// TODO Auto-generated method stub

		List<Object> objectCourses = null;

		List<Course> courses = courseRepo.findTeacherCourseByInstitutionId(institutionId);

		logger.info("Fetched all active course :" + courses);
		objectCourses = new ArrayList<Object>(courses);
		return objectCourses;

	}

	@Override
	public List<Object> findCoursesByDepartmentId(int department_id) {
		// TODO Auto-generated method stub
		List<Object> objectCourses = null;

		List<Course> courses = courseRepo.findCourseByDepartmentId(department_id);

		logger.info("Fetched all active course :" + courses);
		objectCourses = new ArrayList<Object>(courses);
		return objectCourses;
	}

	@Override
	public List<Object> getAllInactiveCourses() {
		logger.debug("Entering getAllInactiveCourses");

		List<Object> objectCourses = null;

		List<Course> courses = courseRepo.findInactiveCoursesOfActiveInstitutions();

		logger.info("Fetched all inactive course :" + courses);

		objectCourses = new ArrayList<Object>(courses);
		return objectCourses;
	}

	@Override
	public int activateCourseById(int courseId) {
		logger.debug("Entering activateCourseByName");

		int count = courseRepo.activateCourseById(courseId);
		logger.info("activated Course count : " + count);
		return count;
	}
	
	@Override
	public List<Object> findCoursesByDepartmentId(int departmentId) {
		// TODO Auto-generated method stub
		List<Object> objectCourses = null;

		List<Course> courses = courseRepo.findCourseByDepartmentId(departmentId);
		

		logger.info("Fetched all active course :" + courses);
		objectCourses = new ArrayList<Object>(courses);
		return objectCourses;


	}

	@Override
	public Course getCourseByCourseId(int courseid) {
		// TODO Auto-generated method stub

		logger.debug("Entering getCourseByCourseId");

		Course course = courseRepo.findByCourseId(courseid);
		logger.info("Founded course :" + course);

		return course;
	}

	@Override
	public int deleteCourseByCourseId(int courseid) {
		// TODO Auto-generated method stub
		logger.debug("Entering deleteCourseByCourseId");

		int count = courseRepo.deleteCourseByCourseId(courseid);
		logger.info("deleted Course count : " + count);
		return count;
	}

}
