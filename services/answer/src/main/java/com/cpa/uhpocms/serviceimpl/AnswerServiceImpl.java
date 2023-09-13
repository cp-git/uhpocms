/**
 * @author - Code Generator
 * @createdOn 30-03-2023
 * @Description Controller class for answer
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;
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
	 * @return : List<Object> answer
	 * @description : For fetching all answer which are active state from
	 *              Teacher_answer table
	 */
	@Override
	public List<Object> getAllAnswers() {
		logger.debug("Entering getAllAnswers");
		List<Object> answersObject = null;
		List<Answer> answers = answerRepo.findAll();
		
		answersObject = new ArrayList<Object>(answers);
		logger.info("Fetched all active answer :" + answers);
		return answersObject;
	}

	
	

}
