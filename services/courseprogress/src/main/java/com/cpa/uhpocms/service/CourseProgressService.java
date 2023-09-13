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

	
	//INSERT COURSE PROGRESS
	CourseProgress createCourseProgress(CourseProgress courseprogress);

	//GET COURSE PROGRESS BY ID
	CourseProgress getCourseProgressByid(int id);
	
	//GET LIST OF COURSE PROGRESS BY COURSE ID
	List<Object> getCourseProgressByCourseId(int id);

	//GET ALL COURSE PROGRESS
	List<Object> getAllCourseProgresss();

	//UPDATE THE COURSE PROGRESS BY ID
	CourseProgress updateCourseProgressByid(CourseProgress courseprogress, int id);

	//GET COURSE PROGRESS BY COURSE ID AND STUDENT ID
	public CourseProgress getCourseProgressByCourseIdStudId(int courseId, int studId);
	
	//DELETE COURSE PROGRESS BY COURSE ID AND STUDENT ID
	int deleteCourseProgressByCourseIdAndStudentId(int courseId, int studId);

}