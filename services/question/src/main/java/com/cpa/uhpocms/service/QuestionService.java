/**
 * @author  - Code Generator
 * @createdOn -  07-12-2022
 * @Description Entity class for Question Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.Question;

public interface QuestionService {

	Question createQuestion(Question question);

	Question getQuestionByFigure(String figure);
	
	Question getQuestionById(int questionId);

	List<Object> getAllQuestions();

	Question updateQuestionByFigure(Question question, String figure);
	
	Question updateQuestionById(Question question , int questionId);

	int deleteQuestionByFigure(String figure);
	
	int deleteQuestionById(int questionId);

	List<Object> getInActiveQuestions();
	
	Object updateActiveStatus(String figure);
}