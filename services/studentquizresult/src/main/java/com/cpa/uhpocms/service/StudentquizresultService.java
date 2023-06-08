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

	List<Object> getStudentquizresultByQuizId(int quizid);

	List<Object> getStudentquizresultByStudentAndQuizId(int studentId, int quizId);

	Studentquizresult getStudentAnswerByProfileIdAndQuestionId(int studentId, int questionId);

	/**
	 * @param : Studentquizresult to update
	 * @return : studentquizresult
	 * @description : For updating studentquizresult of teacher_studentquizresult
	 *              table
	 */
	Studentquizresult updateStudentquizresultByquestionid(Studentquizresult studentquizresult);

//	int deleteStudentquizresultByquestionid(int questionid);

}