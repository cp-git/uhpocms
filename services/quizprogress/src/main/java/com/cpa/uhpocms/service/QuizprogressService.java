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

	Quizprogress getQuizprogressBystudentId(int studentId);

	List<Object> getAllQuizprogresss();

	Quizprogress updateQuizprogressBystudentId(Quizprogress quizprogress, int studentId);

	int deleteQuizprogressBystudentId(int studentId);

}