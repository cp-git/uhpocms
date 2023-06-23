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
	
	EnrollToStudent getEnrollToStudentBycourseId(int courseid);

//	List<Object> getAllEnrollToStudents();
	
	List<Object> getStudentByCourseId(int courseid);

	EnrollToStudent updateEnrollToStudentBycourseId(EnrollToStudent enrolltostudent, int courseid);

	int deleteEnrollToStudentBycourseId(int courseid);
	
//	void insertCourseAndProfile(int courseId,int profileId);

}