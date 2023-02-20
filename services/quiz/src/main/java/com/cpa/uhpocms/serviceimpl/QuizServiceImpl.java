/**
 * @author - Code Generator
 * @createdOn 06-12-2022
 * @Description Controller class for quiz
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//import com.cpa.uhpocms.controller.QuizController;
import com.cpa.uhpocms.entity.Quiz;
import com.cpa.uhpocms.repository.QuizRepo;
import com.cpa.uhpocms.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepo quizRepo;
	private static Logger logger;

	public QuizServiceImpl() {
		logger = Logger.getLogger(QuizServiceImpl.class);
	}

	/**
	 * @param : Quiz quiz
	 * @return : Quiz createdQuiz
	 * @description : For creating/inserting entry in Teacher_quiz table
	 */
	@Override
	public Quiz createQuiz(Quiz quiz) {
		logger.debug("Entering createQuiz");
		Quiz createdQuiz = null;

		quiz.setCreatedBy("admin");
		quiz.setModifiedBy("admin");

		createdQuiz = quizRepo.save(quiz);
		logger.info("created Quiz :" + createdQuiz);
		return createdQuiz;
	}

	/**
	 * @param : String title
	 * @return : Quiz quiz
	 * @description : For get entry in Teacher_quiz table
	 */
	@Override
	public Quiz getQuizBytitle(String title) {
		logger.debug("Entering getQuizBytitle");

		Quiz quiz = quizRepo.findBytitle(title);

		try {
			if (quiz.isActive() == true) {
				logger.info("Founded quiz :" + quiz);

				return quiz;
			}
		} catch (NullPointerException e) {
		
		}

		return null;
	}

	/**
	 * @return : List<Object> quiz
	 * @description : For fetching all quiz which are active state from Teacher_quiz
	 *              table
	 */
	@Override
	public List<Object> getAllQuizs() {
		logger.debug("Entering getAllQuizs");

		List<Object> quizs = quizRepo.findByIsActiveTrue();
		logger.info("Fetched all active quiz :" + quizs);
		return quizs;
	}

	/**
	 * @param : Quiz to update
	 * @return : quiz
	 * @description : For updating quiz of Teacher_quiz table
	 */
	@Override
	public Quiz updateQuiz(Quiz quiz, String title) {
		logger.debug("Entering updateQuiz");

		Quiz toUpdatedQuiz = null;
		Quiz updatedQuiz = null;

		toUpdatedQuiz = quizRepo.findBytitle(title);
		logger.info("exisitng Quiz :: " + toUpdatedQuiz);

		if (toUpdatedQuiz != null) {
			logger.debug("setting new data of Quiz to exisitng Quiz");

			toUpdatedQuiz.setTitle(quiz.getTitle());
			toUpdatedQuiz.setDescription(quiz.getDescription());
			toUpdatedQuiz.setUrl(quiz.getUrl());
			toUpdatedQuiz.setRandomOrder(quiz.getRandomOrder());
			toUpdatedQuiz.setMaxQuestions(quiz.getMaxQuestions());
			toUpdatedQuiz.setAnswersAtEnd(quiz.isAnswersAtEnd());
			toUpdatedQuiz.setExamPaper(quiz.isExamPaper());
			;
			toUpdatedQuiz.setSingleAttempt(quiz.isSingleAttempt());
			toUpdatedQuiz.setPassMark(quiz.getPassMark());
			toUpdatedQuiz.setSuccessText(quiz.getSuccessText());
			toUpdatedQuiz.setFailText(quiz.getFailText());
			;
			toUpdatedQuiz.setDraft(quiz.isDraft());
			toUpdatedQuiz.setQuizOrderNo(quiz.getQuizOrderNo());
			toUpdatedQuiz.setCourseId(quiz.getCourseId());
			;
			toUpdatedQuiz.setModuleId(quiz.getModuleId());
			toUpdatedQuiz.setCategoryId(quiz.getCategoryId());
			toUpdatedQuiz.setActive(quiz.isActive());
			toUpdatedQuiz.setModifiedBy(quiz.getModifiedBy());

			updatedQuiz = quizRepo.save(toUpdatedQuiz);

			logger.info("updated Quiz :" + updatedQuiz);
		}

		return updatedQuiz;
	}

	/**
	 * @param : String title
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of Quiz
	 * 
	 */
	@Override
	public int deleteQuizBytitle(String title) {
		logger.debug("Entering deleteQuizBytitle");

		int count = quizRepo.deleteBytitle(title);
		logger.info("deleted Quiz count : " + count);
		return count;
	}

	/**
	 * @author Shradha
	 * 
	 * 
	 */
	@Override
	public List<Object> getInactiveQuizzes() {
		// TODO Auto-generated method stub
		logger.debug("Entering getInActiveQuestions ");
		List<Object> quizzes = quizRepo.findByIsActiveFalse();
		
		logger.info("In active quizzes : " + quizzes);
		return quizzes;
	}

	
	/**
	 * @author Shradha
	 * 
	 */
	@Override
	public Object updateActiveStatus(String title) {
		// TODO Auto-generated method stub

		System.out.println(title);
		logger.debug("Entering getInActiveQuestions ");
		List<Object> quizzes = getInactiveQuizzes();
		
		if(quizzes.size() >= 1)
		{
			Object object = quizRepo.findBytitle(title);
			
			System.out.println(object);
			
		  	System.out.println("Entered  instanceof loop");
		        Quiz quiz = (Quiz) object;
		        System.out.println(quiz);
		        quiz.setActive(true);
		        
		        System.out.println(quiz);
		        
		        
		    

		    logger.info("question object"+ object);
		    return quizRepo.save(quiz);
		}
		
		
		return null;
	}

}
