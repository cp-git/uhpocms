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

	/**
	 * @param : Studentquizresult studentquizresult
	 * @return : Studentquizresult createdStudentquizresult
	 * @description : For creating/inserting entry in teacher_studentquizresult
	 *              table
	 */
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

	/**
	 * @param : String questionid
	 * @return : Studentquizresult studentquizresult
	 * @description : For get entry in teacher_studentquizresult table
	 */

	/**
	 * @return : List<Object> studentquizresult
	 * @description : For fetching all studentquizresult which are active state from
	 *              teacher_studentquizresult table
	 */
//	@Override
//	public List<Object> getAllStudentquizresults() {
//		logger.debug("Entering getAllStudentquizresults");
//
//		List<Object> studentquizresults = studentquizresultRepo.findByQuizResultIsActiveTrue();
//		logger.info("Fetched all active studentquizresult :" + studentquizresults);
//		return studentquizresults;
//	}

	/**
	 * @param : Studentquizresult to update
	 * @return : studentquizresult
	 * @description : For updating studentquizresult of teacher_studentquizresult
	 *              table
	 */
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
			updatedStudentquizresult = studentquizresultRepo.save(toUpdatedStudentquizresult);

			logger.info("updated Studentquizresult :" + updatedStudentquizresult);
		}

		return updatedStudentquizresult;
	}

	/**
	 * @param : String questionid
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of
	 *              Studentquizresult
	 * 
	 */
//	@Override
//	public int deleteStudentquizresultByquestionid(int questionid) {
//		logger.debug("Entering deleteStudentquizresultByquestionid");
//
//		int count =  studentquizresultRepo.deleteQuizResultByquestionid(questionid);
//		logger.info("deleted Studentquizresult count : " + count);
//		return count;
//	}

	@Override
	public List<Object> getStudentquizresultByQuizId(int quizid) {
		// logger.debug("Entering getStudentquizresultByquestionid");

		List<Object> objectResult = null;

		List<Studentquizresult> studentquizresult = studentquizresultRepo.findAllByQuizId(quizid);
		logger.info("Founded studentquizresult :" + studentquizresult);

		objectResult = new ArrayList<>(studentquizresult);
		return objectResult;
	}

	@Override
	public Studentquizresult getStudentAnswerByProfileIdAndQuestionId(int studentId, int questionId) {
		// TODO Auto-generated method stub
		Studentquizresult studentquizresults = studentquizresultRepo.findByStudentIdAndQuestionId(studentId,
				questionId);
		logger.info("Fetched all active studentquizresult :" + studentquizresults);
		return studentquizresults;
	}

	@Override
	public List<Object> getStudentquizresultByStudentAndQuizId(int studentId, int quizId) {
		// TODO Auto-generated method stub
		List<Object> objectResult = null;

		List<Studentquizresult> studentquizresult = studentquizresultRepo.findByStudentIdAndQuizId(studentId, quizId);
		logger.info("Founded studentquizresult :" + studentquizresult);

		objectResult = new ArrayList<>(studentquizresult);
		return objectResult;
	}

}
