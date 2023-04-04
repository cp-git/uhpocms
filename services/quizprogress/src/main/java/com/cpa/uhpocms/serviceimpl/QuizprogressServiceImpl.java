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
	 * @description : For creating/inserting entry in Teacher_studentquizprogress table
	 */
	@Override
	public Quizprogress createQuizprogress(Quizprogress quizprogress) {
		logger.debug("Entering createQuizprogress");
		Quizprogress createdQuizprogress = null;

	//	quizprogress.setQuizprogressCreatedBy("admin");
	//	quizprogress.setQuizprogressModifiedBy("admin");

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
	public Quizprogress getQuizprogressBystudentId(int studentId) {
		logger.debug("Entering getQuizprogressBystudentId");

		Quizprogress quizprogress = quizprogressRepo.findByStudentId(studentId);
		logger.info("Founded quizprogress :" + quizprogress);

		return quizprogress;
	}

	/**
	 * @return : List<Object> quizprogress
	 * @description : For fetching all quizprogress which are active state from Teacher_studentquizprogress table
	 */
	@Override
	public List<Object> getAllQuizprogresss() {
		logger.debug("Entering getAllQuizprogresss");

		List<Object> quizProgressList = null;
		List<Quizprogress> quizProgress = quizprogressRepo.findAll();
		quizProgressList = new ArrayList<Object>(quizProgress);
		//List<Object> quizprogresss = quizprogressRepo.findByQuizProgressIsActiveTrue();
		logger.info("Fetched all active quizprogress :" + quizProgress);
		return quizProgressList;
	}

	/**
	 * @param : Quizprogress to update
	 * @return : quizprogress
	 * @description : For updating quizprogress of Teacher_studentquizprogress table
	 */
	@Override
	public Quizprogress updateQuizprogressBystudentId(Quizprogress quizprogress, int studentId) {
		logger.debug("Entering updateQuizprogress");

		Quizprogress toUpdatedQuizprogress = null;
		Quizprogress updatedQuizprogress = null;

		
		toUpdatedQuizprogress = quizprogressRepo.findByStudentId(studentId);
		logger.info("exisitng Quizprogress :: " + toUpdatedQuizprogress);

		if (toUpdatedQuizprogress != null) {
			logger.debug("setting new data of Quizprogress to exisitng Quizprogress");

//			quizprogress.setModifiedBy("admin");
			toUpdatedQuizprogress.setScore(quizprogress.getScore());
			toUpdatedQuizprogress.setCompleted(quizprogress.isCompleted());
			toUpdatedQuizprogress.setNumberOfAttempts(quizprogress.getNumberOfAttempts());
			toUpdatedQuizprogress.setQuizid(quizprogress.getQuizid());
			toUpdatedQuizprogress.setStudentId(quizprogress.getStudentId());
			updatedQuizprogress = quizprogressRepo.save(toUpdatedQuizprogress);

			logger.info("updated Quizprogress :" + toUpdatedQuizprogress);
		}

		return updatedQuizprogress;
	}

	/**
	 * @param : String studentid
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of Quizprogress
	 * 
	 */
	@Override
	public int deleteQuizprogressBystudentId(int studentId) {
		logger.debug("Entering deleteQuizprogressBystudentId");

		int count =  quizprogressRepo.deleteQuizProgressBystudentId(studentId);
		logger.info("deleted Quizprogress count : " + count);
		return count;
	}

}
