/**
 * @author - Code Generator
 * @createdOn 06-12-2022
 * @Description Controller class for quiz
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;
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

	//CREATE QUIZ
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

	
	//GET QUIZ BY TITLE
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

	
	//GET ALL QUIZ
	@Override
	public List<Object> getAllQuizs() {
		logger.debug("Entering getAllQuizs");

		List<Object> quizs = quizRepo.findByIsActiveTrue();
		logger.info("Fetched all active quiz :" + quizs);
		return quizs;
	}


	//UPDATE THE QUIZ BY USING TITLE
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
		
			toUpdatedQuiz.setRandomOrder(quiz.isRandomOrder());
			toUpdatedQuiz.setMaxQuestions(quiz.getMaxQuestions());

			
			toUpdatedQuiz.setSingleAttempt(quiz.isSingleAttempt());
			toUpdatedQuiz.setPassMark(quiz.getPassMark());
			toUpdatedQuiz.setMaxMarks(quiz.getMaxMarks());
			toUpdatedQuiz.setSuccessText(quiz.getSuccessText());
			toUpdatedQuiz.setFailText(quiz.getFailText());


			toUpdatedQuiz.setQuizOrderNo(quiz.getQuizOrderNo());
			toUpdatedQuiz.setCourseId(quiz.getCourseId());

			toUpdatedQuiz.setModuleId(quiz.getModuleId());
			toUpdatedQuiz.setCategoryId(quiz.getCategoryId());
			toUpdatedQuiz.setActive(quiz.isActive());
			toUpdatedQuiz.setModifiedBy(quiz.getModifiedBy());
			toUpdatedQuiz.setSetTimer(quiz.getSetTimer());

			updatedQuiz = quizRepo.save(toUpdatedQuiz);

			logger.info("updated Quiz :" + updatedQuiz);
		}

		return updatedQuiz;
	}

	
	

	
	//DELETE QUIZ BY TITLE
	@Override
	public int deleteQuizBytitle(String title) {
		logger.debug("Entering deleteQuizBytitle");

		int count = quizRepo.deleteBytitle(title);
		logger.info("deleted Quiz count : " + count);
		return count;
	}
    
	
	



	//GET ALL INACTIVE QUIZZESS
	@Override
	public List<Object> getInactiveQuizzes() {
		// TODO Auto-generated method stub
		logger.debug("Entering getInActiveQuestions ");
		List<Object> quizzes = quizRepo.findByIsActiveFalse();

		logger.info("In active quizzes : " + quizzes);
		return quizzes;
	}

	
	//ACTIVATE QUIZ BY QUIZ ID
	@Override
	public Object updateActiveStatus(int quizId) {
		// TODO Auto-generated method stub

		logger.debug("Entering getInActiveQuestions ");
		List<Object> quizzes = getInactiveQuizzes();

		if (quizzes.size() >= 1) {
			Object object = quizRepo.findByQuizId(quizId);

			Quiz quiz = (Quiz) object;
			quiz.setActive(true);

			logger.info("question object" + object);
			return quizRepo.save(quiz);
		}

		return null;
	}

	
	//GET ALL QUIZ BY PROFILE ID
	public List<Object> getAllQuizzesByProfileId(int studentId) {
		logger.debug("Entering getAllQuizzesByProfileId");

		List<Quiz> quizzes = quizRepo.getAllQuizzesByStudentId(studentId);
		List<Object> objQuizzes = new ArrayList<Object>(quizzes);
		logger.info("Fetched quiz :" + quizzes);
		return objQuizzes;
	}

	//GET ALL INACTIVE QUIZ
	public List<Object> getAllActInacQuizzes() {
		logger.debug("Entering getAllQuizzesByModuleId");

		List<Quiz> quizzes = quizRepo.findAll();
		
		List<Object> objQuizzes = new ArrayList<Object>(quizzes);
		logger.info("Fetched quiz :" + quizzes);
		return objQuizzes;
	}
	
	//GET ALL QUIZ BY MODULE ID
	public List<Object> getAllQuizzesByModuleId(int moduleId) {
		logger.debug("Entering getAllQuizzesByModuleId");

		List<Quiz> quizzes = quizRepo.findByModuleId(moduleId);
		
		List<Object> objQuizzes = new ArrayList<Object>(quizzes);
		logger.info("Fetched quiz :" + quizzes);
		return objQuizzes;
	}


	// GET QUIZ LIST INFO QUIZ ID
	@Override
	public List<Object[]> getQuizInfoByQuizId(int quizId) {
		// TODO Auto-generated method stub
		 return quizRepo.getQuizInfoByQuizId(quizId);
	}
	
	
	//GET QUIZ BY QUIZ ID
	@Override
	public Object getQuizByQuizId(int quizId) {
		// TODO Auto-generated method stub
		 return quizRepo.findByQuizId(quizId);
	}
	
	
	//GET ALL INACTIVE QUIZ BY STUDENT ID
	@Override
	public List<Object> getAllInactiveQuizzesByStudentId(int studentId) {
		logger.debug("Entering getAllQuizzesByProfileId");

		List<Quiz> quizzes = quizRepo.getAllInactiveQuizzesByStudentId(studentId);
		List<Object> objQuizzes = new ArrayList<Object>(quizzes);
		logger.info("Fetched quiz :" + quizzes);
		return objQuizzes;
	}
	
	//GET ALL QUIZ BY TEACHER ID
	@Override
	public List<Object> getAllQuizzesByTeacherId(int teacherId) {
		logger.debug("Entering getAllQuizzesByProfileId");

		List<Quiz> quizzes = quizRepo.getAllQuizzesByTeacherId(teacherId);
		List<Object> objQuizzes = new ArrayList<Object>(quizzes);
		logger.info("Fetched quiz :" + quizzes);
		return objQuizzes;
	}
	
	//GET ALL INACTIVE QUIZZESS BY TEACHER ID
	@Override
	public List<Object> getAllInactiveQuizzesByTeacherId(int teacherId) {
		logger.debug("Entering getAllQuizzesByProfileId");

		List<Quiz> quizzes = quizRepo.getAllInactiveQuizzesByTeacherId(teacherId);
		List<Object> objQuizzes = new ArrayList<Object>(quizzes);
		logger.info("Fetched quiz :" + quizzes);
		return objQuizzes;
	}
}
