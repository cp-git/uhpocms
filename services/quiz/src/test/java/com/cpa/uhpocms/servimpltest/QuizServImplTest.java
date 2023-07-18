
package com.cpa.uhpocms.servimpltest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cpa.uhpocms.entity.Quiz;
import com.cpa.uhpocms.repository.QuizRepo;
import com.cpa.uhpocms.serviceimpl.QuizServiceImpl;

@ExtendWith(MockitoExtension.class)
public class QuizServImplTest {

	@Mock
	private QuizRepo quizRepo;

	@InjectMocks
	private QuizServiceImpl impl;

	/**
	 * @author Shradha
	 * @description: Function that perform functional testing for
	 *               deleteQuizBytitleTest() method in QuizServiceImpl
	 * @createdOn : 9 Dec 2022
	 * 
	 */
	@Test
	public void deleteQuizBytitleTest() {
		Mockito.when(quizRepo.deleteBytitle("ABC")).thenReturn(1);

		int count = impl.deleteQuizBytitle("ABC");

		assertEquals(count, 1);

	}

	/**
	 * @author Shradha
	 * @description: Function that perform functional testing for getAllQuizsTest()
	 *               method in QuizServiceImpl
	 * @createdOn : 24 Nov 2022
	 */
	@Test
	public void getAllQuizsTest() {

		Date date = new Date();
//		Quiz quiz = new Quiz(9, "TRF", "AMOEBA", "", true, 5, true, true, true, 5,10, "", "", false, 1, 1, 1, 1, true,
//				"admin", "admin", date, date);
		Quiz quiz = new Quiz();
		List<Object> quizzes = new ArrayList<>();
		quizzes.add(quiz);

		given(quizRepo.findByIsActiveTrue()).willReturn(quizzes);
		List<Object> quizListExpected = impl.getAllQuizs();
		assertThat(quizListExpected).isNotNull();

	}

	/**
	 * @author Shradha
	 * @description: Function that perform functional testing for
	 *               getQuizBytitleTest() method in QuizServiceImpl
	 * @createdOn : 24 Nov 2022
	 */

	@Test
	public void getQuizBytitleTest() {
		Date date = new Date();
//		Quiz quiz = new Quiz(9, "TRF", "AMOEBA", "", true, 5, true, true, true, 5,10, "", "", false, 1, 1, 1, 1, true,
//				"admin", "admin", date, date);
		Quiz quiz = new Quiz();

		given(quizRepo.findBytitle(quiz.getTitle())).willReturn(quiz);

		Quiz quizExpected = (Quiz) impl.getQuizBytitle(quiz.getTitle());

		assertThat(quizExpected).isNotNull();

	}

	/**
	 * @author Shradha
	 * @description: Function that perform functional testing for createQuizTest()
	 *               method in QuizServiceImpl
	 * @createdOn : 12 Dec 2022
	 */

	@Test
	public void createQuizTest() {

		Date date = new Date();
//		Quiz quiz = new Quiz(9, "TRF", "AMOEBA", "", true, 5, true, true, true, 5,10, "", "", false, 1, 1, 1, 1, true,
//				"admin", "admin", date, date);

		Quiz quiz = new Quiz();
		given(quizRepo.save(quiz)).willReturn(quiz);

		Quiz quizExpected = impl.createQuiz(quiz);

		assertEquals(quiz.toString(), quizExpected.toString());

	}

	/**
	 * @author Shradha
	 * @description: Function that perform functional testing for updateQuizTest()
	 *               method in QuizServiceImpl
	 * @createdOn : 12 Dec 2022
	 */

	@Test
	public void updateQuizTest() {
		Date date = new Date();
//		Quiz quiz = new Quiz(9, "TRF", "AMOEBA", "", true, 5, true, true, true, 5,10, "", "", false, 1, 1, 1, 1, true,
//				"admin", "admin", date, date);
		Quiz quiz = new Quiz();
		given(quizRepo.save(quiz)).willReturn(quiz);
		given(quizRepo.findBytitle(quiz.getTitle())).willReturn(quiz);

		Quiz quizUpdated = new Quiz();
		quizUpdated.setActive(false);
		quizUpdated.setTitle("XYZ");
		quizUpdated.setDescription("PQR");

		Quiz quizExpected = impl.updateQuiz(quizUpdated, "TRF");
		assertThat(quizUpdated.getTitle()).isNotEqualTo("TRF");
		assertThat(quizUpdated.getDescription()).isNotEqualTo("AMOEBA");

	
}
}
//package com.cpa.uhpocms.servimpltest;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.mockito.BDDMockito.given;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.cpa.uhpocms.entity.Quiz;
//import com.cpa.uhpocms.repository.QuizRepo;
//import com.cpa.uhpocms.serviceimpl.QuizServiceImpl;
//
//@ExtendWith(MockitoExtension.class)
//public class QuizServImplTest {
//
//	@Mock
//	private QuizRepo quizRepo;
//
//	@InjectMocks
//	private QuizServiceImpl impl;
//
//	/**
//	 * @author Shradha
//	 * @description: Function that perform functional testing for
//	 *               deleteQuizBytitleTest() method in QuizServiceImpl
//	 * @createdOn : 9 Dec 2022
//	 * 
//	 */
//	@Test
//	public void deleteQuizBytitleTest() {
//		Mockito.when(quizRepo.deleteBytitle("ABC")).thenReturn(1);
//
//		int count = impl.deleteQuizBytitle("ABC");
//
//		assertEquals(count, 1);
//
//	}
//
//	/**
//	 * @author Shradha
//	 * @description: Function that perform functional testing for getAllQuizsTest()
//	 *               method in QuizServiceImpl
//	 * @createdOn : 24 Nov 2022
//	 */
//	@Test
//	public void getAllQuizsTest() {
//
//		Date date = new Date();
//		Quiz quiz = new Quiz(9, "TRF", "AMOEBA", "", true, 5, true, true, true, 5, "", "", false, 1, 1, 1, 1,120, true,
//				"admin", "admin", date, date);
//
//		List<Object> quizzes = new ArrayList<>();
//		quizzes.add(quiz);
//
//		given(quizRepo.findByIsActiveTrue()).willReturn(quizzes);
//		List<Object> quizListExpected = impl.getAllQuizs();
//		assertThat(quizListExpected).isNotNull();
//
//	}
//
//	/**
//	 * @author Shradha
//	 * @description: Function that perform functional testing for
//	 *               getQuizBytitleTest() method in QuizServiceImpl
//	 * @createdOn : 24 Nov 2022
//	 */
//
//	@Test
//	public void getQuizBytitleTest() {
//		Date date = new Date();
//		Quiz quiz = new Quiz(9, "TRF", "AMOEBA", "", true, 5, true, true, true, 5, "", "", false, 1, 1, 1, 1, true,
//				"admin", "admin", date, date);
//
//		given(quizRepo.findBytitle(quiz.getTitle())).willReturn(quiz);
//
//		Quiz quizExpected = (Quiz) impl.getQuizBytitle(quiz.getTitle());
//
//		assertThat(quizExpected).isNotNull();
//
//	}
//
//	/**
//	 * @author Shradha
//	 * @description: Function that perform functional testing for createQuizTest()
//	 *               method in QuizServiceImpl
//	 * @createdOn : 12 Dec 2022
//	 */
//
//	@Test
//	public void createQuizTest() {
//
//		Date date = new Date();
//		Quiz quiz = new Quiz(9, "TRF", "AMOEBA", "", true, 5, true, true, true, 5, "", "", false, 1, 1, 1, 1, true,
//				"admin", "admin", date, date);
//
//		given(quizRepo.save(quiz)).willReturn(quiz);
//
//		Quiz quizExpected = impl.createQuiz(quiz);
//
//		assertEquals(quiz.toString(), quizExpected.toString());
//
//	}
//
//	/**
//	 * @author Shradha
//	 * @description: Function that perform functional testing for updateQuizTest()
//	 *               method in QuizServiceImpl
//	 * @createdOn : 12 Dec 2022
//	 */
//
//	@Test
//	public void updateQuizTest() {
//		Date date = new Date();
//		Quiz quiz = new Quiz(9, "TRF", "AMOEBA", "", true, 5, true, true, true, 5, "", "", false, 1, 1, 1, 1, true,
//				"admin", "admin", date, date);
//
//		given(quizRepo.save(quiz)).willReturn(quiz);
//		given(quizRepo.findBytitle(quiz.getTitle())).willReturn(quiz);
//
//		Quiz quizUpdated = new Quiz();
//		quizUpdated.setActive(false);
//		quizUpdated.setTitle("XYZ");
//		quizUpdated.setDescription("PQR");
//
//		Quiz quizExpected = impl.updateQuiz(quizUpdated, "TRF");
//		assertThat(quizUpdated.getTitle()).isNotEqualTo("TRF");
//		assertThat(quizUpdated.getDescription()).isNotEqualTo("AMOEBA");
//
//	}
//}

