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

	/**
	 * @param : AssignToTeacher assigntoteacher
	 * @return : AssignToTeacher createdAssignToTeacher
	 * @description : For creating/inserting entry in teacher_course_assigntoteacher table
	 */
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

	/**
	 * @param : String courseid
	 * @return : AssignToTeacher assigntoteacher
	 * @description : For get entry in teacher_course_assigntoteacher table
	 */
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

	/**
	 * @param : AssignToTeacher to update
	 * @return : assigntoteacher
	 * @description : For updating assigntoteacher of teacher_course_assigntoteacher table
	 */
	public AssignToTeacher updateAssignToTeacherBycourseId(AssignToTeacher assigntoteacher, int courseid) {
		logger.debug("Entering updateAssignToTeacher");

		AssignToTeacher toUpdatedAssignToTeacher = null;
		AssignToTeacher updatedAssignToTeacher = null;

		toUpdatedAssignToTeacher = assigntoteacherRepo.findByCourseId(courseid);
		logger.info("exisitng AssignToTeacher :: " + toUpdatedAssignToTeacher);

		if (toUpdatedAssignToTeacher != null) {
			logger.debug("setting new data of AssignToTeacher to exisitng AssignToTeacher");

//			assigntoteacher.setModifiedBy("admin");
						
			updatedAssignToTeacher = assigntoteacherRepo.save(assigntoteacher);

			logger.info("updated AssignToTeacher :" + updatedAssignToTeacher);
		}

		return updatedAssignToTeacher;
	}

	/**
	 * @param : String courseid
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of AssignToTeacher
	 * 
	 */
	
	public int deleteAssignToTeacherBycourseId(int courseid) {
		logger.debug("Entering deleteAssignToTeacherBycourseId");

		int count =  assigntoteacherRepo.deleteAssignToTeacherBycourseId(courseid);
		logger.info("deleted AssignToTeacher count : " + count);
		return count;
	}
	
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

	

}
