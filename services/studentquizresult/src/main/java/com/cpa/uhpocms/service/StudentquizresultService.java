/**
 * @author  - Code Generator
 * @createdOn -  01-06-2023
 * @Description Entity class for Studentquizresult Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.Studentquizresult;

public interface StudentquizresultService {


	//CREATE STUDENT QUIZ RESULT 
	Studentquizresult createStudentquizresult(Studentquizresult studentquizresult);



	//GET STUDENT QUIZ RESULT BY STUDENT ID AND QUIZ ID
	List<Object> getStudentquizresultByStudentAndQuizId(int studentId, int quizId);

	// GET STUDENT ANSWER BY PROFILE AND QUESTION ID
	Studentquizresult getStudentAnswerByProfileIdAndQuestionId(int studentId, int questionId);
	
	//UPDATE QUIZ RESULT BY QUESTION ID
	Studentquizresult updateStudentquizresultByquestionid(Studentquizresult studentquizresult);

	

}