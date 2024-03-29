/**
 * @author - Code Generator
 * @createdOn 23-02-2023
 * @Description Controller class for enrolltostudent
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import static org.hamcrest.CoreMatchers.nullValue;

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
	public List<Object> createEnrollToStudent(EnrollToStudent enrolltostudent) {
	    logger.debug("Entering createEnrollToStudent in serviceimpl");
	    EnrollToStudent createdEnrollToStudent = null;

	    int courseIdNew = enrolltostudent.getCourseId();
	    int profileIdNew = enrolltostudent.getProfileId();

	    EnrollToStudent enrStudentSecond = getEnrollToStudentBycourseIdandprofileId(courseIdNew,profileIdNew);

	    if ((enrStudentSecond == null) || (enrStudentSecond.getProfileId() != profileIdNew)) {
	        createdEnrollToStudent = enrolltostudentRepo.save(enrolltostudent);

	        logger.info("created EnrollToStudent :" + createdEnrollToStudent);

	        List<Object> resultList = new ArrayList<>();
	        resultList.add(createdEnrollToStudent);
	        return resultList;
	    }

	    logger.error("Course Id " + courseIdNew + " already assigned to profile Id " + profileIdNew);
	    return null;
	}

	/*
	 * @param : String courseid
	 * @return : EnrollToStudent enrolltostudent
	 * @description : For get entry in teacher_course_enrollToStudent table
	 */
	@Override
	public EnrollToStudent getEnrollToStudentBycourseIdandprofileId(int courseid,int profile_id) {
		logger.debug("Entering getEnrollToStudentBycourseId");

		EnrollToStudent enrolltostudent = enrolltostudentRepo.findByCourseIdAndProfileId(courseid,profile_id);
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
	public EnrollToStudent updateEnrollToStudentBycourseId(EnrollToStudent enrolltostudent, int courseid) {
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
	public int deleteEnrollToStudentBycourseId(int courseid) {
		logger.debug("Entering deleteEnrollToStudentBycourseId");

		int count =  enrolltostudentRepo.deleteEnrollToStudentBycourseId(courseid);
		logger.info("deleted EnrollToStudent count : " + count);
		return count;
	}

	@Override
	public List<Object> getStudentByCourseId(int courseid) {
		// TODO Auto-generated method stub
		List<Object> enrolltostudent = enrolltostudentRepo.findAllByCourseId(courseid);
		
		return enrolltostudent;
	}

	@Override
	public EnrollToStudent getEnrollToStudentBycourseId(int courseid) {
		// TODO Auto-generated method stub

		EnrollToStudent enrolltostudent = enrolltostudentRepo.findByCourseId(courseid);
		logger.info("Founded enrolltostudent :" + enrolltostudent);

		return enrolltostudent;
	}

	@Override
	public List<Object> getProfilesByInstIdandCourId(int instId, int courId) {
		// TODO Auto-generated method stub
		logger.debug("Entering getEnrollToStudentByInstIdandCourId");

		List<EnrollToStudent> enrollesdSTudents = null;
		enrollesdSTudents = enrolltostudentRepo.findProfilesByInstIDandCourseId(instId, courId);
		logger.info("Founded enrolltostudent :" + enrollesdSTudents);
		
		List<Object> enrolledStudObjects = new ArrayList<Object>(enrollesdSTudents);
		return enrolledStudObjects;	
	
	}

	@Override
	public int deleteEnrollToStudentByCourseIdAndProfileId(int courseId, int profileId) {
		// TODO Auto-generated method stub
		 return enrolltostudentRepo.deleteEnrollToStudentByCourseIdAndProfileId(courseId, profileId);
	}

	

//	@Override
//	public void insertCourseAndProfile(int courseId, int profileId) {
//		// TODO Auto-generated method stub
//		enrolltostudentRepo.insertCourseAndProfile(courseId, profileId);
//		enrolltostudentRepo.saveAll(enrolltostudentRepo.insertCourseAndProfile(courseId, profileId));
//		
//	}
	
	
}
