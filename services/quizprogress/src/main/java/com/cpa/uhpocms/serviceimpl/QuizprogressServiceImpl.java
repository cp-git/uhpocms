/**
 * @author - Code Generator
 * @createdOn 03-04-2023
 * @Description Controller class for quizprogress
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.QuizprogressController;
import com.cpa.uhpocms.entity.Quizprogress;
import com.cpa.uhpocms.repository.QuizprogressRepo;
import com.cpa.uhpocms.service.QuizprogressService;

@Service
public class QuizprogressServiceImpl implements QuizprogressService {

	@Autowired
	private QuizprogressRepo quizprogressRepo;
	private static Logger logger;

	public QuizprogressServiceImpl() {
		logger = Logger.getLogger(QuizprogressServiceImpl.class);
	}

	/**
	 * @param : Quizprogress quizprogress
	 * @return : Quizprogress createdQuizprogress
	 * @description : For creating/inserting entry in Teacher_studentquizprogress
	 *              table
	 */
	@Override
	public Quizprogress createQuizprogress(Quizprogress quizprogress) {
		logger.debug("Entering createQuizprogress");
		Quizprogress createdQuizprogress = null;

		createdQuizprogress = quizprogressRepo.save(quizprogress);
		logger.info("created Quizprogress :" + createdQuizprogress);
		return createdQuizprogress;
	}

	/**
	 * @param : String studentid
	 * @return : Quizprogress quizprogress
	 * @description : For get entry in Teacher_studentquizprogress table
	 */
	@Override
	public Quizprogress getQuizprogressByStudentIdAndQuizId(int studentId, int quizId) {
		logger.debug("Entering getQuizprogressBystudentId");

		Quizprogress quizprogress = quizprogressRepo.getQuizprogressByStudentIdAndQuizId(studentId, quizId);
		logger.info("Founded quizprogress :" + quizprogress);

		return quizprogress;
	}


	/**
	 * @author shradha
	 * @param : String studentid
	 * @return : Quizprogress quizprogress
	 * @description : For get entry in Teacher_studentquizprogress table by given quiz and student id for completed status as true
	 */
	@Override
	public Quizprogress getQuizprogressByStudentIdAndQuizIdProg(int studentId, int quizId) {
		logger.debug("Entering getQuizprogressByStudentIdAndQuizIdProg");

		Quizprogress quizprogress = quizprogressRepo.getQuizprogressByStudentIdAndQuizIdAndIsCompletedTrue(studentId, quizId);
		logger.info("Founded quizprogress :" + quizprogress);

		return quizprogress;
	}

	
	
	/**
	 * @return : List<Object> quizprogress
	 * @description : For fetching all quizprogress which are active state from
	 *              Teacher_studentquizprogress table
	 */
	@Override
	public List<Object> getAllQuizprogress() {
		logger.debug("Entering getAllQuizprogresss");

		List<Object> quizProgressList = null;
		List<Quizprogress> quizProgress = quizprogressRepo.findAll();

		quizProgressList = new ArrayList<Object>(quizProgress);

		logger.info("Fetched all active quizprogress :" + quizProgress);
		return quizProgressList;
	}

	/**
	 * @param : Quizprogress to update
	 * @return : quizprogress
	 * @description : For updating quizprogress of Teacher_studentquizprogress table
	 */
	@Override
	public Quizprogress updateQuizprogressByStudentIdAndQuizId(Quizprogress quizprogress) {
		logger.debug("Entering updateQuizprogress");

		Quizprogress toUpdatedQuizprogress = null;
		Quizprogress updatedQuizprogress = null;

		toUpdatedQuizprogress = quizprogressRepo.getQuizprogressByStudentIdAndQuizId(quizprogress.getStudentId(),
				quizprogress.getQuizId());

		logger.info("exisitng Quizprogress :: " + toUpdatedQuizprogress);

		if (toUpdatedQuizprogress != null) {
			logger.debug("setting new data of Quizprogress to exisitng Quizprogress");

			toUpdatedQuizprogress.setScore(quizprogress.getScore());
			toUpdatedQuizprogress.setCompleted(quizprogress.isCompleted());
			toUpdatedQuizprogress.setNumberOfAttempts(quizprogress.getNumberOfAttempts());

			updatedQuizprogress = quizprogressRepo.save(toUpdatedQuizprogress);

			logger.info("updated Quizprogress :" + toUpdatedQuizprogress);
		}

		return updatedQuizprogress;
	}

	/**
	 * @param : String studentid
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of
	 *              Quizprogress
	 * 
	 */
	@Override
	public int deleteQuizprogressByStudentIdAndQuizId(int studentId, int quizId) {
		logger.debug("Entering deleteQuizprogressBystudentId");

		int count = quizprogressRepo.deleteQuizprogressByStudentIdAndQuizId(studentId, quizId);
		logger.info("deleted Quizprogress count : " + count);
		return count;
	}

	/**
	 * @param : String studentid
	 * @return : Quizprogress quizprogress
	 * @description : For get entry in Teacher_studentquizprogress table
	 */
	@Override
	public List<Object> getQuizprogressBystudentId(int studentId) {
		logger.debug("Entering getQuizprogressBystudentId");
		List<Object> quizprogress = quizprogressRepo.findAllByStudentId(studentId);
		logger.info("Founded quizprogress :" + quizprogress.size());
		return quizprogress;
	}

	public List<Object> getQuizProgByCourIDAndModID(int courId,int modId)
	{ System.out.println(courId +" " +modId);
		List<Object> objectQuizProg = null;
		
		List<Quizprogress> qplist = quizprogressRepo.findquizprogressBycourseIdandModId(courId, modId);
		objectQuizProg = new  ArrayList<Object>(qplist);
		
		System.out.println(qplist);
		return objectQuizProg;

	}
	
	
	
}
