/**
 * @author  - Code Generator
 * @createdOn -  05-04-2023
 * @Description Entity class for CourseProgress Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.CourseProgress;

public interface CourseProgressService {

	CourseProgress createCourseProgress(CourseProgress courseprogress);

	CourseProgress getCourseProgressByid(int id);
	
	List<Object> getCourseProgressByCourseId(int id);

	List<Object> getAllCourseProgresss();

	CourseProgress updateCourseProgressByid(CourseProgress courseprogress, int id);

	
	
	public CourseProgress getCourseProgressByCourseIdStudId(int courseId, int studId);
	
	int deleteCourseProgressByCourseIdAndStudentId(int courseId, int studId);

}