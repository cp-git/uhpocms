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

	Quizprogress createQuizprogress(Quizprogress quizprogress);

	Quizprogress getQuizprogressByStudentIdAndQuizId(int studentId, int quizId);
	
	Quizprogress getQuizprogressByStudentIdAndQuizIdProg(int studentId, int quizId) ;

	List<Object> getAllQuizprogress();

	Quizprogress updateQuizprogressByStudentIdAndQuizId(Quizprogress quizprogress);

	int deleteQuizprogressByStudentIdAndQuizId(int studentId, int quizId);

	List<Object> getQuizprogressBystudentId(int studentId);
	
	List<Object> getQuizProgByCourIDAndModID(int courId,int modId);

}