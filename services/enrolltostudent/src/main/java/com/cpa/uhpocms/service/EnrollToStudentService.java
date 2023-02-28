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

	EnrollToStudent createEnrollToStudent(EnrollToStudent enrolltostudent);

	EnrollToStudent getEnrollToStudentBycourseId(String courseid);

//	List<Object> getAllEnrollToStudents();

	EnrollToStudent updateEnrollToStudentBycourseId(EnrollToStudent enrolltostudent, String courseid);

	int deleteEnrollToStudentBycourseId(String courseid);
	
//	void insertCourseAndProfile(int courseId,int profileId);

}