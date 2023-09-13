/**
 * @author  - Code Generator
 * @createdOn -  07-12-2022
 * @Description Entity class for Question Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;
import java.util.Map;



import com.cpa.uhpocms.entity.Answer;
import com.cpa.uhpocms.entity.Question;

public interface QuestionService {

	//CREATE QUESTION 
	Question createQuestion(Question question);

	
	//GET QUESTION BY QUESTION ID
	Question getQuestionById(int questionId);

	//GET ALL QUESTIONS
	List<Object> getAllQuestions();

	//UPDATE QUESTION BY FIGURE
	Question updateQuestionByFigure(Question question, String figure);

	//UPDATE QUESTION BY ID
	Question updateQuestionById(Question question, int questionId);

	int deleteQuestionByFigure(String figure);

	//GET ALL INACTIVE QUESTIONS
	List<Object> getInActiveQuestions();

	//GET ALL QUESTIONS BY QUIZ ID
	List<Object> getAllQuestionsByQuizId(int quizId);
	
	//GET SHUFFLED QUESTION BY QUIX ID
	List<Object> getShuffledQuestionByQuizId(int quizId);

	//ACTIVATE QUESTION BY FIGURE
	Object updateActiveStatus(String figure);

	//ADD AND UPDATE QUESTION AND ANSWER
	int addQuestionWithAnswers(Question question);
    
	//ADD AND UPDATE QUESTION AND ANSWER
	Integer addQuestionsAndAnswers(Question question, Answer[] answers);
	
	//GET QUESTION USING QUESTION ID
	Question findQuestionById(int questionId);
	
	//DELETE QUESTION ANSWER USING QUESTION ID
    Map<Integer, Integer> deleteQuestionWithAnswersMCQ(int questionId);

}