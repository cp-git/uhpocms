/**
 * @author  - Code Generator
 * @createdOn -  10-01-2023
 * @Description Entity class for Course Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.Course;
import com.cpa.uhpocms.entity.CourseDepartment;

public interface CourseService {

	//CREATE COURSE
	Course createCourse(Course course);



	
	//GET ALL COURSE
	List<Object> getAllCourses();

	

	//UPDATE COURSE BY ID
	Course updateCourseById(Course course, int courseid);

	

	//DELETE THE COURSE BY ID
	int deleteCourseByCourseId(int courseid);

	//FIND COURSE BY PROFILE ID
	List<Object> findCourseByProfileId(int profile_id);

	//FIND COURSE BY DEPARTMENT ID
	List<Object> findCoursesByDepartmentId(int department_id);

	//FIND BY INSTITUTION ID
	List<Object> findByInstitutionId(int institutionId);

	//GET ALL INACTIVE COURSES
	List<Object> getAllInactiveCourses();

	//FIND COURSES ASSIGN TO TEACHER
	List<Object> findCoursesAssignToTeacher(int profile_id);
	
	//FIND INACTIVE COURSES ASSIGN TO TEACHER
	List<Object> findInactiveCoursesAssignToTeacher(int profile_id);
	
	//ACTIVATE COURSE BY ID
	int activateCourseById(int courseId);
	

	//ASSIGN COURSE TO DEPARTMENT
	CourseDepartment assignCourseToDepartment(CourseDepartment courseDepartment);

	//GET LIST OF INACTIVE COURSES BASED ON INSTITUTION ID
	List<Object> findInactiveCourseByInstitutionId(int institutionId);

}