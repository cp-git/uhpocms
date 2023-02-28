/**
 * @author - Code Generator
 * @createdOn 23-02-2023
 * @Description Controller class for enrolltostudent
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.EnrollToStudentController;
import com.cpa.uhpocms.entity.EnrollToStudent;
import com.cpa.uhpocms.repository.EnrollToStudentRepo;
import com.cpa.uhpocms.service.EnrollToStudentService;

@Service
public class EnrollToStudentServiceImpl implements EnrollToStudentService {

	@Autowired
	private EnrollToStudentRepo enrolltostudentRepo;
	private static Logger logger;

	public EnrollToStudentServiceImpl() {
		logger = Logger.getLogger(EnrollToStudentServiceImpl.class);
	}

	/**
	 * @param : EnrollToStudent enrolltostudent
	 * @return : EnrollToStudent createdEnrollToStudent
	 * @description : For creating/inserting entry in teacher_course_enrollToStudent table
	 */
	@Override
	public EnrollToStudent createEnrollToStudent(EnrollToStudent enrolltostudent) {
		logger.debug("Entering createEnrollToStudent");
		EnrollToStudent createdEnrollToStudent = null;

	//	enrolltostudent.setEnrollToStudentCreatedBy("admin");
	//	enrolltostudent.setEnrollToStudentModifiedBy("admin");

		createdEnrollToStudent = enrolltostudentRepo.save(enrolltostudent);
		logger.info("created EnrollToStudent :" + createdEnrollToStudent);
		return createdEnrollToStudent;
	}

	/**
	 * @param : String courseid
	 * @return : EnrollToStudent enrolltostudent
	 * @description : For get entry in teacher_course_enrollToStudent table
	 */
	@Override
	public EnrollToStudent getEnrollToStudentBycourseId(String courseid) {
		logger.debug("Entering getEnrollToStudentBycourseId");

		EnrollToStudent enrolltostudent = enrolltostudentRepo.findByCourseId(courseid);
		logger.info("Founded enrolltostudent :" + enrolltostudent);

		return enrolltostudent;
	}

	/**
	 * @return : List<Object> enrolltostudent
	 * @description : For fetching all enrolltostudent which are active state from teacher_course_enrollToStudent table
	 */
//	@Override
//	public List<Object> getAllEnrollToStudents() {
//		logger.debug("Entering getAllEnrollToStudents");
//		EnrollToStudent enrollToStudent;
//		List<Object>  enrolltostudents = new ArrayList<Object>(enrollToStudent);
//		List<Object> enrolltostudents = enrolltostudentRepo.findAll();
//		logger.info("Fetched all active enrolltostudent :" + enrolltostudents);
//		return enrolltostudents;
//	}

	/**
	 * @param : EnrollToStudent to update
	 * @return : enrolltostudent
	 * @description : For updating enrolltostudent of teacher_course_enrollToStudent table
	 */
	@Override
	public EnrollToStudent updateEnrollToStudentBycourseId(EnrollToStudent enrolltostudent, String courseid) {
		logger.debug("Entering updateEnrollToStudent");

		EnrollToStudent toUpdatedEnrollToStudent = null;
		EnrollToStudent updatedEnrollToStudent = null;

		toUpdatedEnrollToStudent = enrolltostudentRepo.findByCourseId(courseid);
		logger.info("exisitng EnrollToStudent :: " + toUpdatedEnrollToStudent);

		if (toUpdatedEnrollToStudent != null) {
			logger.debug("setting new data of EnrollToStudent to exisitng EnrollToStudent");

//			enrolltostudent.setModifiedBy("admin");
						
			updatedEnrollToStudent = enrolltostudentRepo.save(enrolltostudent);

			logger.info("updated EnrollToStudent :" + updatedEnrollToStudent);
		}

		return updatedEnrollToStudent;
	}

	/**
	 * @param : String courseid
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of EnrollToStudent
	 * 
	 */
	@Override
	public int deleteEnrollToStudentBycourseId(String courseid) {
		logger.debug("Entering deleteEnrollToStudentBycourseId");

		int count =  enrolltostudentRepo.deleteEnrollToStudentBycourseId(courseid);
		logger.info("deleted EnrollToStudent count : " + count);
		return count;
	}

//	@Override
//	public void insertCourseAndProfile(int courseId, int profileId) {
//		// TODO Auto-generated method stub
//		enrolltostudentRepo.insertCourseAndProfile(courseId, profileId);
//		enrolltostudentRepo.saveAll(enrolltostudentRepo.insertCourseAndProfile(courseId, profileId));
//		
//	}
	
	
}
