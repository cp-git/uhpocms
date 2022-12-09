package com.cpa.uhpocms.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cpa.uhpocms.entity.Question;
import com.cpa.uhpocms.repository.QuestionRepo;
import com.cpa.uhpocms.service.QuestionService;

@SpringBootTest
public class QuestionServiceImplTest {

	@MockBean
	private static QuestionRepo questionRepository;

	@Autowired
	private QuestionService questionService;

	private Question question;
	private Question expect;

	@BeforeEach
	public void setUp() {
		System.out.println("BeforeEach ");

		Date createdOn = null;
		Date modifiedOn = null;
		try {
			createdOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
			modifiedOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// actual question
		this.question = new Question(1, "user", "content", "expl", 10, true, 1, 1, true, "admin", createdOn, "admin",
				modifiedOn);

		// expected question
		this.expect = new Question(1, "user", "content", "expl", 10, true, 1, 1, true, "admin", createdOn, "admin",
				modifiedOn);

	}

	@Test
	public void testGetQuestionByFigure() {

		Mockito.when(questionRepository.findByQuestionFigure("user")).thenReturn(this.question);

		// System.out.println("expect " + expect.toString());
		Question result = questionService.getQuestionByFigure("user");
		// System.out.println("result " + result.toString());
		assertEquals(this.expect.toString(), result.toString());

	}

	@Test
	public void testGetAllQuestions() {

		List<Object> list = new ArrayList<Object>();
		list.add(this.question);
		Mockito.when(questionRepository.findByQuestionIsActiveTrue()).thenReturn(list);

		System.out.println("expect " + expect.toString());
		List<Object> result = questionService.getAllQuestions();
		System.out.println("result " + result.toString());
		assertEquals(this.expect.toString(), result.get(0).toString());

	}

	@Test
	public void testCreateQuestion() {

		/*
		 * Date joinedDate = null; try { joinedDate = new
		 * SimpleDateFormat("dd-MM-yyyy").parse("22-11-2022"); } catch (ParseException
		 * e) { e.printStackTrace(); }
		 */

		// creating question to create entry in table
		Question question = new Question("user", "content", "expl", 10, true, 1, 1, true);

		Mockito.when(questionRepository.save(question)).thenReturn(this.question);

		// result of question after creating
		Question result = questionService.createQuestion(question);

		// comparing
		assertEquals(this.expect.toString(), result.toString());
	}

	@Test
	public void testUpdateQuestionByFigure() {

		Date createdOn = null;
		Date modifiedOn = null;
		try {
			createdOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
			modifiedOn = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse("22-11-2022 12:53:00");
		} catch (ParseException e) {

			e.printStackTrace();
		}

		// exisiting question
		Question existing = new Question(1, "user", "content", "expl", 10, true, 1, 1, true, "admin", createdOn,
				"admin", modifiedOn);

		// updating question to update entry in table
		Question question = new Question("user", "content123", "expl123", 10, true, 1, 1, true);

		// expected question
		Question expect = new Question(1, "user", "content123", "expl123", 10, true, 1, 1, true, "admin", createdOn,
				"admin", modifiedOn);

		Mockito.when(questionRepository.findByQuestionFigure("user")).thenReturn(existing);
		Question toUpdateQuestion = questionRepository.findByQuestionFigure("user");
		Mockito.when(questionRepository.save(toUpdateQuestion)).thenReturn(expect);

		Question result = questionService.updateQuestionByFigure(question, "user");

		assertEquals(expect.toString(), result.toString());

	}

	@Test
	public void testDeleteQuestionByFigure() {
		Mockito.when(questionRepository.deleteQuestionByFigure("user")).thenReturn(1);

		int count = questionService.deleteQuestionByFigure("user");

		assertEquals(count, 1);

	}

	@AfterEach
	public void tearDown() {
		System.out.println("After");
	}

}
