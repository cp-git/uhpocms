/**
 * @author  - Code Generator
 * @createdOn -  03-04-2023
 * @Description Entity class for Quizprogress Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.Quizprogress;

public interface QuizprogressService {

	//ADD QUIZ PROGRESS
	Quizprogress createQuizprogress(Quizprogress quizprogress);

	//GET QUIZ PROGRESS BY STUDENT ID AND QUIZ ID
	Quizprogress getQuizprogressByStudentIdAndQuizId(int studentId, int quizId);
	
	
	// GET ALL QUIZ PROGRESS
	List<Object> getAllQuizprogress();

	//UPDATE THE QUIZ PROGRESS  STUDENT ID AND QUIZ ID
	Quizprogress updateQuizprogressByStudentIdAndQuizId(Quizprogress quizprogress);

	
	// GET QUIZ PROGRESS BY STUDENT ID
	List<Object> getQuizprogressBystudentId(int studentId);
	
	//GET QUIZ PROGRESS BY COURSE ID AND MODULE ID
	List<Object> getQuizProgByCourIDAndModID(int courId,int modId);

}