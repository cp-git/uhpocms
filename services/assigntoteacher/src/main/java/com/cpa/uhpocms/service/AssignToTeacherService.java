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

	AssignToTeacher createAssignToTeacher(AssignToTeacher assigntoteacher);

	List<Object> getTeacherBycourseId(int courseid);

	//List<Object> getAllAssignToTeachers();

	AssignToTeacher updateAssignToTeacherBycourseId(AssignToTeacher assigntoteacher, int courseid);

	int deleteAssignToTeacherBycourseId(int courseid);

	List<Object> getProfilesByInstIdandCourId(int instId,int courId);
}