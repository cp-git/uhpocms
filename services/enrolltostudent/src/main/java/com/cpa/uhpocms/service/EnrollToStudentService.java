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

	//ENROLLED STUDENT
	List<Object> createEnrollToStudent(EnrollToStudent enrolltostudent);

	//GET ENROLL STUDENT BY COURSE ID AND PROFILE ID
	EnrollToStudent getEnrollToStudentBycourseIdandprofileId(int courseid,int profile_id);
	
	//GET LIST OF PROFILE INSTITUTE ID AND COURSE ID
	List<Object> getProfilesByInstIdandCourId(int instId,int courId);
	

	//GET LIST STUDENT BY COURSE ID
	List<Object> getStudentByCourseId(int courseid);


	// DELETE ENROLL STUDENT COURSE ID AND PROFILE ID
	  int deleteEnrollToStudentByCourseIdAndProfileId(int courseId, int profileId);

}