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

	//ENROLLED STUDENT
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

	//GET ENROLL STUDENT BY COURSE ID AND PROFILE ID
	@Override
	public EnrollToStudent getEnrollToStudentBycourseIdandprofileId(int courseid,int profile_id) {
		logger.debug("Entering getEnrollToStudentBycourseId");

		EnrollToStudent enrolltostudent = enrolltostudentRepo.findByCourseIdAndProfileId(courseid,profile_id);
		logger.info("Founded enrolltostudent :" + enrolltostudent);

		return enrolltostudent;
	}



	//GET LIST OF PROFILE INSTITUTE ID AND COURSE ID
	@Override
	public List<Object> getStudentByCourseId(int courseid) {
		// TODO Auto-generated method stub
		List<Object> enrolltostudent = enrolltostudentRepo.findAllByCourseId(courseid);
		
		return enrolltostudent;
	}



	//GET LIST STUDENT BY COURSE ID
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

	// DELETE ENROLL STUDENT COURSE ID AND PROFILE ID
	@Override
	public int deleteEnrollToStudentByCourseIdAndProfileId(int courseId, int profileId) {
		// TODO Auto-generated method stub
		 return enrolltostudentRepo.deleteEnrollToStudentByCourseIdAndProfileId(courseId, profileId);
	}

	


	
	
}
