/**
 * @author - Code Generator
 * @createdOn 06-12-2022
 * @Description Controller class for answer
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.AnswerController;
import com.cpa.uhpocms.entity.Answer;
import com.cpa.uhpocms.repository.AnswerRepo;
import com.cpa.uhpocms.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerRepo answerRepo;
	private static Logger logger;

	public AnswerServiceImpl() {
		logger = Logger.getLogger(AnswerServiceImpl.class);
	}

	/**
	 * @param : Answer answer
	 * @return : Answer createdAnswer
	 * @description : For creating/inserting entry in Teacher_answer table
	 */
	@Override
	public Answer createAnswer(Answer answer) {
		logger.debug("Entering createAnswer");
		Answer createdAnswer = null;

	//	answer.setAnswerCreatedBy("admin");
	//	answer.setAnswerModifiedBy("admin");

		createdAnswer = answerRepo.save(answer);
		logger.info("created Answer :" + createdAnswer);
		return createdAnswer;
	}

	/**
	 * @param : String id
	 * @return : Answer answer
	 * @description : For get entry in Teacher_answer table
	 */
	@Override
	public Answer getAnswerById(String id) {
		logger.debug("Entering getAnswerById");

		Answer answer = answerRepo.findByAnswerId(id);
		logger.info("Founded answer :" + answer);

		return answer;
	}

	/**
	 * @return : List<Object> answer
	 * @description : For fetching all answer which are active state from Teacher_answer table
	 */
	@Override
	public List<Object> getAllAnswers() {
		logger.debug("Entering getAllAnswers");

		List<Object> answers = answerRepo.findByAnswerIsActiveTrue();
		logger.info("Fetched all active answer :" + answers);
		return answers;
	}

	/**
	 * @param : Answer to update
	 * @return : answer
	 * @description : For updating answer of Teacher_answer table
	 */
	@Override
	public Answer updateAnswerById(Answer answer, String id) {
		logger.debug("Entering updateAnswer");

		Answer toUpdatedAnswer = null;
		Answer updatedAnswer = null;

		toUpdatedAnswer = answerRepo.findByAnswerId(id);
		logger.info("exisitng Answer :: " + toUpdatedAnswer);

		if (toUpdatedAnswer != null) {
			logger.debug("setting new data of Answer to exisitng Answer");

//			answer.setModifiedBy("admin");
						
			updatedAnswer = answerRepo.save(answer);

			logger.info("updated Answer :" + updatedAnswer);
		}

		return updatedAnswer;
	}

	/**
	 * @param : String id
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of Answer
	 * 
	 */
	@Override
	public int deleteAnswerById(String id) {
		logger.debug("Entering deleteAnswerById");

		int count =  answerRepo.deleteAnswerById(id);
		logger.info("deleted Answer count : " + count);
		return count;
	}

}
