/**
 * @author  - Code Generator
 * @createdOn -  06-12-2022
 * @Description Entity class for Quiz Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.Quiz;

public interface QuizService {

	//CREATE QUIZ
	Quiz createQuiz(Quiz quiz);

	//GET QUIZ BY TITLE
	Quiz getQuizBytitle(String title);

	//GET ALL QUIZZESS
	List<Object> getAllQuizs();

	//UPDATE QUIZ BY TITLE
	Quiz updateQuiz(Quiz quiz, String title);

	//DELETE QUIZ BY TITLE
	int deleteQuizBytitle(String title);

	//GET ALL QUIZESS BY PROFILE IF
	List<Object> getAllQuizzesByProfileId(int studentId);
	
	//GET ALL QUIZZESS BY MODULE ID
	List<Object> getAllQuizzesByModuleId(int moduleId) ;

	//ACTIVATE QUIZ BY QUIZ ID
	Object updateActiveStatus(int quizID);

	//GET INACTIVE QUIZZESS
	List<Object> getInactiveQuizzes();
	
	//GET INFO BY QUIZ ID
	List<Object[]> getQuizInfoByQuizId(int quizId);
	
	//GET QUIZ BY QUIZ ID
	 Object getQuizByQuizId(int quizId);
	 
	 //GET ALL INACTIVE QUIZZ BY STUDENT ID
	List<Object> getAllInactiveQuizzesByStudentId(int studentId);

	List<Object> getAllQuizzesByTeacherId(int teacherId);

	List<Object> getAllInactiveQuizzesByTeacherId(int teacherId);
	
	//GET ALL INACTIVE QUIZZESS
	public List<Object> getAllActInacQuizzes() ;
}