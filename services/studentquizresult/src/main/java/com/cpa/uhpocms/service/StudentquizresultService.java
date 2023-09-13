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


	Studentquizresult createStudentquizresult(Studentquizresult studentquizresult);




	List<Object> getStudentquizresultByStudentAndQuizId(int studentId, int quizId);


	Studentquizresult getStudentAnswerByProfileIdAndQuestionId(int studentId, int questionId);
	
	Studentquizresult updateStudentquizresultByquestionid(Studentquizresult studentquizresult);

	

}