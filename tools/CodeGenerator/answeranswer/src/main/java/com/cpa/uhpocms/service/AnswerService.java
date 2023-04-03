/**
 * @author  - Code Generator
 * @createdOn -  06-12-2022
 * @Description Entity class for Answer Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.Answer;

public interface AnswerService {

	Answer createAnswer(Answer answer);

	Answer getAnswerById(String id);

	List<Object> getAllAnswers();

	Answer updateAnswerById(Answer answer, String id);

	int deleteAnswerById(String id);

}