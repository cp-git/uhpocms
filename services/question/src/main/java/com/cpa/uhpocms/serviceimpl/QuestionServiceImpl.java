/**
 * @author - Code Generator
 * @createdOn 07-12-2022
 * @Description Controller class for question
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.uhpocms.entity.Answer;
//import com.cpa.uhpocms.controller.QuestionController;
import com.cpa.uhpocms.entity.Question;
import com.cpa.uhpocms.repository.QuestionRepo;
import com.cpa.uhpocms.service.QuestionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepo questionRepo;
	private static Logger logger;

	private final int ANSWER_LENGTH = 4;

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
	public Question updateQuestionByFigure(Question question, String figure) {
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
			toUpdatedQuestion.setQuestionQuizId(question.getQuestionQuizId());
			toUpdatedQuestion.setQuestionCategoryId(question.getQuestionCategoryId());
			toUpdatedQuestion.setQuestionIsActive(question.isQuestionIsActive());

			updatedQuestion = questionRepo.save(toUpdatedQuestion);

			logger.info("updated Question :" + updatedQuestion);
		}

		return updatedQuestion;
	}

	@Override
	public Question updateQuestionById(Question question, int questionId) {
		logger.debug("Entering updateQuestion");

		Question toUpdatedQuestion = null;
		Question updatedQuestion = null;

		toUpdatedQuestion = questionRepo.findByQuestionId(questionId);
//		logger.info("exisitng Question :: " + toUpdatedQuestion);

		if (toUpdatedQuestion != null) {
			logger.debug("setting new data of Question to exisitng Question");
			toUpdatedQuestion.setQuestionId(questionId);
			toUpdatedQuestion.setQuestionModifiedBy("admin");
			toUpdatedQuestion.setQuestionFigure(question.getQuestionFigure());
			toUpdatedQuestion.setQuestionContent(question.getQuestionContent());
			toUpdatedQuestion.setQuestionExplanation(question.getQuestionExplanation());
			toUpdatedQuestion.setQuestionOrderNo(question.getQuestionOrderNo());
			toUpdatedQuestion.setQuestionIsMCQ(question.isQuestionIsMCQ());
			toUpdatedQuestion.setQuestionQuizId(question.getQuestionQuizId());
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

	@Override
	public int deleteQuestionById(int questionId) {
		int count = questionRepo.deleteQuestionByQuestionId(questionId);
		logger.info("deleted Question count : " + count);
		return count;
	}

	/**
	 * @author Shradha
	 * @param String
	 * @return Object
	 */
	public Object updateActiveStatus(String figure) {
		logger.debug("Entering getInActiveQuestions ");
		List<Object> questions = getInActiveQuestions();

		if (questions.size() >= 1) {
			Object object = questionRepo.findByQuestionFigure(figure);
			Question question = (Question) object;
			System.out.println(question);
			question.setQuestionIsActive(true);

			System.out.println(question);
			logger.info("question object" + question);
			return questionRepo.save(question);
		}
		return null;
	}

	/**
	 * @author Shradha
	 * @return : Object
	 * @description : Function to get all inactive questions whose active flag is
	 *              false
	 * 
	 */
	@Override
	public List<Object> getInActiveQuestions() {
		// TODO Auto-generated method stub
		logger.debug("Entering getInActiveQuestions ");
		List<Object> questions = questionRepo.findByQuestionIsActiveFalse();

		logger.info("In active questions : " + questions);
		return questions;
	}

	@Override
	public Question getQuestionById(int questionId) {
		logger.debug("Entering getQuestionByFigure");

		Question question = questionRepo.findByQuestionId(questionId);
		logger.info("Founded question :" + question);

		return question;
	}

	@Override
	public List<Object> getAllQuestionsByQuizId(int quizId) {
		logger.debug("Entering getAllQuestionsByQuizId");
		List<Object> questions = questionRepo.findAllByQuestionQuizIdAndQuestionIsActiveOrderByQuestionOrderNo(quizId,
				true);
		logger.info("Fetched all active question :" + questions.size());
		return questions;
	}

//	@Override
//	public int addQuestionWithAnswers(Question question) {
//
//		int value = 0;
//		ObjectMapper objectMapper = new ObjectMapper();
//		question.setQuestionCreatedBy("admin");
//		question.setQuestionModifiedBy("admin");
//		String questionJson = null;
//
//		try {
//			questionJson = objectMapper.writeValueAsString(question);
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		System.out.println("json array " + questionJson);
//		value = questionRepo.addQuestionWithAnswers(questionJson, value);
//		return value;
//	}

	// for additing question and answers
	@Override
	public Integer addQuestionsAndAnswers(Question question, Answer[] answers) {

		Integer value = 0;

		ObjectMapper objectMapper = new ObjectMapper();

		question.setQuestionCreatedBy("admin");
		question.setQuestionModifiedBy("admin");

		String questionJson = null;
		List<String> answersJson = new ArrayList<String>();

		try {
			questionJson = objectMapper.writeValueAsString(question);

			for (Answer answer : answers) {
				System.out.println(answer.getContent());
				if (answer.getContent() != null) {
					answersJson.add(objectMapper.writeValueAsString(answer));
				}
			}

			// inserting null values
			System.out.println(answersJson.size());
			for (int i = answersJson.size(); i < ANSWER_LENGTH; i++) {
				answersJson.add(null);
			}

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		System.out.println("json array " + questionJson);
//		System.out.println("answer json " + answersJson);

		value = questionRepo.addQuestionWithAnswers(questionJson, answersJson.get(0), answersJson.get(1),
				answersJson.get(2), answersJson.get(3), value);

		logger.info("generated ID" + value.toString());
		return value;

	}

	@Override
	public int addQuestionWithAnswers(Question question) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Object> getShuffledQuestionByQuizId(int quizId) {
		 logger.debug("Entering getAllQuestionsByQuizId");
		 System.out.println("quiz id : " + quizId);
		    List<Question> questions = questionRepo.shuffleQuestionsByQuizId(quizId);
		    logger.info("Fetched all active question :" + questions.size());

		    List<Object> questionObjects = new ArrayList<Object>(questions);
		    System.out.println("array of quesitons ++++++++++" + questions);

		 
		    return questionObjects;
	}

	@Override
	public Question findQuestionById(int questionId) {
		// TODO Auto-generated method stub
		
		Question question=null;
		question=questionRepo.findByQuestionId(questionId);
		return question;
	}
}
