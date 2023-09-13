/**
 * @author - Code Generator
 * @createdOn 02-03-2023
 * @Description Controller class for assigntoteacher
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.AssignToTeacherController;
import com.cpa.uhpocms.entity.AssignToTeacher;

import com.cpa.uhpocms.repository.AssignToTeacherRepo;
import com.cpa.uhpocms.service.AssignToTeacherService;

@Service
public class AssignToTeacherServiceImpl implements AssignToTeacherService {

	@Autowired
	private AssignToTeacherRepo assigntoteacherRepo;
	private static Logger logger;

	public AssignToTeacherServiceImpl() {
		logger = Logger.getLogger(AssignToTeacherServiceImpl.class);
	}

	//CREATE ASSIGN TO TEACHER
	@Override
	public AssignToTeacher createAssignToTeacher(AssignToTeacher assigntoteacher) {
		logger.debug("Entering createAssignToTeacher");
		AssignToTeacher createdAssignToTeacher = null;

	//	assigntoteacher.setAssignToTeacherCreatedBy("admin");
	//	assigntoteacher.setAssignToTeacherModifiedBy("admin");

		createdAssignToTeacher = assigntoteacherRepo.save(assigntoteacher);
		logger.info("created AssignToTeacher :" + createdAssignToTeacher);
		return createdAssignToTeacher;
	}

	//GET ALL LIST OF  TEACHER COURSE ID
	@Override
	public List<Object> getTeacherBycourseId(int courseid) {
		logger.debug("Entering getAssignToTeacherBycourseId");

		List<Object> assigntoteacher = assigntoteacherRepo.findAllByCourseId(courseid);
		logger.info("Founded assigntoteacher :" + assigntoteacher);

		return assigntoteacher;
	}

	/**
	 * @return : List<Object> assigntoteacher
	 * @description : For fetching all assigntoteacher which are active state from teacher_course_assigntoteacher table
	 */
//	@Override
//	public List<Object> getAllAssignToTeachers() {
//		logger.debug("Entering getAllAssignToTeachers");
//
//		List<Object> assigntoteachers = assigntoteacherRepo.findByAssignToTeacherIsActiveTrue();
//		logger.info("Fetched all active assigntoteacher :" + assigntoteachers);
//		return assigntoteachers;
//	}


	

	//GET LIST OF PROFILES BY INSTITUTE ID AND COURSE ID
	@Override
	public List<Object> getProfilesByInstIdandCourId(int instId, int courId) {
		// TODO Auto-generated method stub
		logger.debug("Entering getEnrollToStudentByInstIdandCourId");

		List<AssignToTeacher> assignedTeachers = null;
		assignedTeachers = assigntoteacherRepo.findProfilesByInstIDandCourseId(instId, courId);
		logger.info("Founded enrolltostudent :" + assignedTeachers);
		
		List<Object> assignedTeacherObjects = new ArrayList<Object>(assignedTeachers);
		return assignedTeacherObjects;	
	
	}

	//DELETE ASSIGN TEACHER COURSE ID AND PROFILE ID
	@Override
	public int deleteAssignToTeacherByCourseIdAndProfileId(int courseId, int profileId) {
		// TODO Auto-generated method stub
		 return assigntoteacherRepo.deleteAssignToTeacherByCourseIdAndProfileId(courseId, profileId);
	}

	

}
