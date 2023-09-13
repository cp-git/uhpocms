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

	//Used
	Course createCourse(Course course);



	
	//Used
	List<Object> getAllCourses();

	

	//Used
	Course updateCourseById(Course course, int courseid);

	

	//Used
	int deleteCourseByCourseId(int courseid);

	//Used
	List<Object> findCourseByProfileId(int profile_id);

	//Used
	List<Object> findCoursesByDepartmentId(int department_id);

	//used
	List<Object> findByInstitutionId(int institutionId);

	//Used
	List<Object> getAllInactiveCourses();

	//Used
	List<Object> findCoursesAssignToTeacher(int profile_id);
	
	//Used
	List<Object> findInactiveCoursesAssignToTeacher(int profile_id);
	
	//Used
	int activateCourseById(int courseId);
	

	//Used
	CourseDepartment assignCourseToDepartment(CourseDepartment courseDepartment);

	//Used
	List<Object> findInactiveCourseByInstitutionId(int institutionId);

}