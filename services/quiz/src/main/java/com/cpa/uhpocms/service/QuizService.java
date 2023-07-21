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

	Quiz createQuiz(Quiz quiz);

	Quiz getQuizBytitle(String title);

	List<Object> getAllQuizs();

	Quiz updateQuiz(Quiz quiz, String title);

	int deleteQuizBytitle(String title);

	List<Object> getAllQuizzesByProfileId(int studentId);
	
	List<Object> getAllQuizzesByModuleId(int moduleId) ;

	Object updateActiveStatus(int quizID);

	List<Object> getInactiveQuizzes();
	
	List<Object[]> getQuizInfoByQuizId(int quizId);
	
	List<Object> getAllInactiveQuizzesByStudentId(int studentId);

	List<Object> getAllQuizzesByTeacherId(int teacherId);

	List<Object> getAllInactiveQuizzesByTeacherId(int teacherId);
	
	public List<Object> getAllActInacQuizzes() ;
}