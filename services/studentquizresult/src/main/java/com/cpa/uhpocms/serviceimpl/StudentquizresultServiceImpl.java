/**
 * @author - Code Generator
 * @createdOn 01-06-2023
 * @Description Controller class for studentquizresult
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.StudentquizresultController;
import com.cpa.uhpocms.entity.Studentquizresult;
import com.cpa.uhpocms.repository.StudentquizresultRepo;
import com.cpa.uhpocms.service.StudentquizresultService;

@Service
public class StudentquizresultServiceImpl implements StudentquizresultService {

	@Autowired
	private StudentquizresultRepo studentquizresultRepo;
	private static Logger logger;

	public StudentquizresultServiceImpl() {
		logger = Logger.getLogger(StudentquizresultServiceImpl.class);
	}

	//CREATE STUDENT QUIZ RESULT
	@Override
	public Studentquizresult createStudentquizresult(Studentquizresult studentquizresult) {
		logger.debug("Entering createStudentquizresult");
		Studentquizresult createdStudentquizresult = null;

		// studentquizresult.setStudentquizresultCreatedBy("admin");
		// studentquizresult.setStudentquizresultModifiedBy("admin");

		createdStudentquizresult = studentquizresultRepo.save(studentquizresult);
		logger.info("created Studentquizresult :" + createdStudentquizresult);
		return createdStudentquizresult;
	}


	//GET STUDENT ANSWER BY PROFILE AND QUESTION ID
	@Override
	public Studentquizresult getStudentAnswerByProfileIdAndQuestionId(int studentId, int questionId) {
		// TODO Auto-generated method stub
		Studentquizresult studentquizresults = studentquizresultRepo.findByStudentIdAndQuestionId(studentId,
				questionId);
		logger.info("Fetched all active studentquizresult :" + studentquizresults);
		return studentquizresults;
	}
	
	

	// GET STUDENT QUIZ RESULT BY STUDENT AND QUIZ ID
	@Override
	public List<Object> getStudentquizresultByStudentAndQuizId(int studentId, int quizId) {
		// TODO Auto-generated method stub
		List<Object> objectResult = null;

		List<Studentquizresult> studentquizresult = studentquizresultRepo.findByStudentIdAndQuizId(studentId, quizId);
		logger.info("Founded studentquizresult :" + studentquizresult);

		objectResult = new ArrayList<>(studentquizresult);
		return objectResult;
	}
	
	
	//UPDATE STUDENT QUIZ RESULT BY QUESTION ID
	@Override
	public Studentquizresult updateStudentquizresultByquestionid(Studentquizresult studentquizresult) {
		logger.debug("Entering updateStudentquizresult");

		Studentquizresult toUpdatedStudentquizresult = null;
		Studentquizresult updatedStudentquizresult = null;

		toUpdatedStudentquizresult = studentquizresultRepo
				.findByStudentIdAndQuestionId(studentquizresult.getStudentId(), studentquizresult.getQuestionId());
		logger.info("exisitng Studentquizresult :: " + toUpdatedStudentquizresult);

		if (toUpdatedStudentquizresult != null) {
			logger.debug("setting new data of Studentquizresult to exisitng Studentquizresult");

//			studentquizresult.setModifiedBy("admin");
			toUpdatedStudentquizresult.setQuestionContent(studentquizresult.getQuestionContent());
			toUpdatedStudentquizresult.setSelectedOption(studentquizresult.isSelectedOption());
			toUpdatedStudentquizresult.setTeacherRemark(studentquizresult.getTeacherRemark());
			toUpdatedStudentquizresult.setMarks(studentquizresult.getMarks());
			toUpdatedStudentquizresult.setCreatedOn(studentquizresult.getCreatedOn());
			toUpdatedStudentquizresult.setModifiedOn(studentquizresult.getModifiedOn());
			toUpdatedStudentquizresult.setReviewedOn(studentquizresult.getReviewedOn());
			toUpdatedStudentquizresult.setReviewStat(studentquizresult.isReviewStat());
			updatedStudentquizresult = studentquizresultRepo.save(toUpdatedStudentquizresult);

			logger.info("updated Studentquizresult :" + updatedStudentquizresult);
		}

		return updatedStudentquizresult;
	}

}
