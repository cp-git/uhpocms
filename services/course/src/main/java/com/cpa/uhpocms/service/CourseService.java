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

	Course createCourse(Course course);

	Course getCourseByName(String name);

	Course getCourseByCourseId(int courseid);

	List<Object> getAllCourses();

	Course updateCourseByName(Course course, String name);

	Course updateCourseById(Course course, int courseid);

	int deleteCourseByName(String name);

	int deleteCourseByCourseId(int courseid);

	List<Object> findCourseByProfileId(int profile_id);

	List<Object> findCoursesByDepartmentId(int department_id);

	List<Object> findByInstitutionId(int institutionId);

	List<Object> getAllInactiveCourses();

	List<Object> findCoursesAssignToTeacher(int profile_id);
	List<Object> findInactiveCoursesAssignToTeacher(int profile_id);
	int activateCourseById(int courseId);
	


	CourseDepartment assignCourseToDepartment(CourseDepartment courseDepartment);


}