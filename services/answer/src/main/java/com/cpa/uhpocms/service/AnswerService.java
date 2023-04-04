/**
 * @author  - Code Generator
 * @createdOn -  30-03-2023
 * @Description Entity class for Answer Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.Answer;

public interface AnswerService {

	Answer createAnswer(Answer answer);

	Answer getAnswerById(int id);

	List<Object> getAllAnswers();

	Answer updateAnswerById(Answer answer, int id);

	int deleteAnswerById(int id);

}