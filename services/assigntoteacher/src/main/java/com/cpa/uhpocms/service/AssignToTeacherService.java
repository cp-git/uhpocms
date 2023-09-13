/**
 * @author  - Code Generator
 * @createdOn -  02-03-2023
 * @Description Entity class for AssignToTeacher Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.AssignToTeacher;

public interface AssignToTeacherService {

	
	//CREATE ASSIGN TO TEACHER
	AssignToTeacher createAssignToTeacher(AssignToTeacher assigntoteacher);

	//GET ALL LIST OF  TEACHER COURSE ID
	List<Object> getTeacherBycourseId(int courseid);

	//List<Object> getAllAssignToTeachers();

	

	//GET LIST OF PROFILES BY INSTITUTE ID AND COURSE ID
	List<Object> getProfilesByInstIdandCourId(int instId,int courId);
	
	//DELETE ASSIGN TEACHER COURSE ID AND PROFILE ID
	   int deleteAssignToTeacherByCourseIdAndProfileId(int courseId, int profileId);
}