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

	Object updateActiveStatus(String figure);

	List<Object> getInactiveQuizzes();
}