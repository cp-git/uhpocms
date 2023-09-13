/**
 * @author  - Code Generator
 * @createdOn -  23-02-2023
 * @Description Entity class for EnrollToStudent Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.EnrollToStudent;

public interface EnrollToStudentService {

	List<Object> createEnrollToStudent(EnrollToStudent enrolltostudent);

	EnrollToStudent getEnrollToStudentBycourseIdandprofileId(int courseid,int profile_id);
	
	List<Object> getProfilesByInstIdandCourId(int instId,int courId);
	

	
	List<Object> getStudentByCourseId(int courseid);


	
	  int deleteEnrollToStudentByCourseIdAndProfileId(int courseId, int profileId);

}