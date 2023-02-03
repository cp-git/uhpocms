/**
 * @author  - Code Generator
 * @createdOn -  10-01-2023
 * @Description Entity class for Course Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.Course;

public interface CourseService {

	Course createCourse(Course course);

	Course getCourseByName(String name);

	List<Object> getAllCourses();

	Course updateCourseByName(Course course, String name);

	int deleteCourseByName(String name);
	
	List<Object> findByInstitutionId(int institutionId);

}