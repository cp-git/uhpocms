/**
 * @author - Code Generator
 * @createdOn 07-12-2022
 * @Description Controller class for question
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.QuestionController;
import com.cpa.uhpocms.entity.Question;
import com.cpa.uhpocms.repository.QuestionRepo;
import com.cpa.uhpocms.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepo questionRepo;
	private static Logger logger;

	public QuestionServiceImpl() {
		logger = Logger.getLogger(QuestionServiceImpl.class);
	}

	/**
	 * @param : Question question
	 * @return : Question createdQuestion
	 * @description : For creating/inserting entry in teacher_question table
	 */
	@Override
	public Question createQuestion(Question question) {
		logger.debug("Entering createQuestion");
		Question createdQuestion = null;

		question.setQuestionCreatedBy("admin");
		question.setQuestionModifiedBy("admin");

		createdQuestion = questionRepo.save(question);
		logger.info("created Question :" + createdQuestion);
		return createdQuestion;
	}

	/**
	 * @param : String figure
	 * @return : Question question
	 * @description : For get entry in teacher_question table
	 */
	@Override
	public Question getQuestionByFigure(String figure) {
		logger.debug("Entering getQuestionByFigure");

		Question question = questionRepo.findByQuestionFigure(figure);
		logger.info("Founded question :" + question);

		return question;
	}

	/**
	 * @return : List<Object> question
	 * @description : For fetching all question which are active state from
	 *              teacher_question table
	 */
	@Override
	public List<Object> getAllQuestions() {
		logger.debug("Entering getAllQuestions");

		List<Object> questions = questionRepo.findByQuestionIsActiveTrue();
		logger.info("Fetched all active question :" + questions);
		return questions;
	}

	/**
	 * @param : Question to update
	 * @return : question
	 * @description : For updating question of teacher_question table
	 */
	@Override
	public Question updateQuestion(Question question, String figure) {
		logger.debug("Entering updateQuestion");

		Question toUpdatedQuestion = null;
		Question updatedQuestion = null;

		toUpdatedQuestion = questionRepo.findByQuestionFigure(figure);
		logger.info("exisitng Question :: " + toUpdatedQuestion);

		if (toUpdatedQuestion != null) {
			logger.debug("setting new data of Question to exisitng Question");

			toUpdatedQuestion.setQuestionModifiedBy("admin");
			toUpdatedQuestion.setQuestionFigure(question.getQuestionFigure());
			toUpdatedQuestion.setQuestionContent(question.getQuestionContent());
			toUpdatedQuestion.setQuestionExplanation(question.getQuestionExplanation());
			toUpdatedQuestion.setQuestionOrderNo(question.getQuestionOrderNo());
			toUpdatedQuestion.setQuestionIsMCQ(question.isQuestionIsMCQ());
			toUpdatedQuestion.setQuestionCategoryId(question.getQuestionCategoryId());
			toUpdatedQuestion.setQuestionIsActive(question.isQuestionIsActive());

			updatedQuestion = questionRepo.save(toUpdatedQuestion);

			logger.info("updated Question :" + updatedQuestion);
		}

		return updatedQuestion;
	}

	/**
	 * @param : String figure
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of Question
	 * 
	 */
	@Override
	public int deleteQuestionByFigure(String figure) {
		logger.debug("Entering deleteQuestionByFigure");

		int count = questionRepo.deleteQuestionByFigure(figure);
		logger.info("deleted Question count : " + count);
		return count;
	}

}
