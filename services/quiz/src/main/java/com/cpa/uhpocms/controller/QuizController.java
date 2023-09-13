/**
 * @author - Code Generator
 * @createdOn 06-12-2022
 * @Description Controller class for quiz
 * 
 */

package com.cpa.uhpocms.controller;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.uhpocms.entity.AuthenticationBean;
import com.cpa.uhpocms.entity.Quiz;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.QuizService;

@CrossOrigin
@RestController
@RequestMapping("/uhpocms")
public class QuizController {

	@Autowired
	private QuizService quizService;;

	private ResourceBundle resourceBundle;
	private static Logger logger;

	QuizController() {
		resourceBundle = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(QuizController.class);
	}

	
	//CREATE QUIZ
	@PostMapping("/quiz")
	public ResponseEntity<Object> createQuiz(@RequestBody Quiz quiz) throws CPException {
		logger.debug("Entering createQuiz");
		logger.info("data of creating Quiz  :" + quiz.toString());

		Quiz createdQuiz = null;
		try {

			Quiz toCheckQuiz = quizService.getQuizBytitle(quiz.getTitle());
			logger.debug("existing quiz :" + toCheckQuiz);

			if (toCheckQuiz == null) {

				createdQuiz = quizService.createQuiz(quiz);
				logger.info("Quiz created :" + createdQuiz);

				return ResponseHandler.generateResponse(createdQuiz, HttpStatus.CREATED);

			} else {

				logger.error(resourceBundle.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new CPException("err003", resourceBundle.getString("err003"));
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Failed Quiz creation : " + ex.getMessage());
			throw new CPException("err003", resourceBundle.getString("err003"));
		}
	}

	//GET QUIZ BY USING QUIZ TITLE
	@GetMapping("/quiz/{title}")
	public ResponseEntity<Object> getQuizBytitle(@PathVariable("title") String title) throws CPException {
		logger.debug("Entering getQuizBytitle");
		logger.info("entered user name :" + title);

		Quiz quiz = null;

		try {

			quiz = quizService.getQuizBytitle(title);
			logger.info("fetched Quiz :" + quiz);

			if (quiz != null) {
				logger.debug("Quiz fetched generating response");
				return ResponseHandler.generateResponse(quiz, HttpStatus.OK);
			} else {
				logger.debug("Quiz not found");
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting quiz : " + ex.getMessage());
			throw new CPException("err001", resourceBundle.getString("err001"));
		}

	}
	
	
	//GET QUIZ LIST INFO USING QUIZ ID
	@GetMapping("/quiz/info/{quizId}")
	public ResponseEntity<Object[]> getQuizInfoByQuizId(@PathVariable int quizId) {
        List<Object[]> quizInfoList = quizService.getQuizInfoByQuizId(quizId);
        if (!quizInfoList.isEmpty()) {
            return new ResponseEntity<>(quizInfoList.get(0), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	//GET QUIZ DATA USING QUIZ ID
	@GetMapping("/quiz/quizId/{quizId}")
	public ResponseEntity<Object> getQuizByQuizId(@PathVariable int quizId) {
        Object quiz = quizService.getQuizByQuizId(quizId);
        if (quiz != null) {
			return ResponseHandler.generateResponse(quiz, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


	
	//GET ALL QUIZ DETAILS
	@GetMapping("/quiz")
	public ResponseEntity<List<Object>> getAllQuiz(@RequestParam(name = "title") String title) throws CPException {
		logger.debug("Entering getAllQuiz");
		logger.info("Parameter  :" + title);

		List<Object> quizs = null;

		try {

			if (title.equalsIgnoreCase("all")) {

				quizs = quizService.getAllQuizs();
				logger.info("Fetched all Quiz :" + quizs);

				return ResponseHandler.generateListResponse(quizs, HttpStatus.OK);
			} else {

				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err002");
			}

		} catch (Exception ex) {
			ex.printStackTrace();

			logger.error("Failed getting all quizs : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));

		}
	}
	
	
	//GET INACTIVE QUIZ DATA
	@GetMapping("/quiz/actInactQuizzes")
	public ResponseEntity<List<Object>> getAllActInacQuizzes(@RequestParam(name = "actInac") String actInac) throws CPException {
		logger.debug("Entering getAllQuiz");
		logger.info("Parameter  :" + actInac);

		List<Object> quizs = null;

		try {

			if (actInac.equalsIgnoreCase("all")) {

				quizs = quizService.getAllActInacQuizzes();
				logger.info("Fetched all Quiz :" + quizs);

				return ResponseHandler.generateListResponse(quizs, HttpStatus.OK);
			} else {

				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err002");
			}

		} catch (Exception ex) {
			ex.printStackTrace();

			logger.error("Failed getting all quizs : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));

		}
	}

	
	//DELETE QUIZ BY QUIZ TITLE
	@DeleteMapping("/quiz/{title}")
	public ResponseEntity<Object> deleteQuiz(@PathVariable("title") String title) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteQuiz  :" + title);
		// TODO - implement the business logic

		int count = 0;

		try {
			count = quizService.deleteQuizBytitle(title);
			if (count >= 1) {
				logger.info("deleted Quiz : title = " + title);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBundle.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Failed to delete Quiz :" + ex.getMessage());
			throw new CPException("err005", resourceBundle.getString("err005"));
		}

	}

	
	//UPDATE QUIZ BY QUIZ QUIZ TITLE
	@PutMapping("/quiz/{title}")
	public ResponseEntity<Object> updateQuiz(@RequestBody Quiz quiz, @PathVariable("title") String title)
			throws CPException {
		logger.debug("Entering updateQuiz");
		logger.info("entered  updateQuiz :" + quiz);

		Quiz updatedQuiz = null;

		try {
			updatedQuiz = quizService.updateQuiz(quiz, title);

			if (updatedQuiz == null) {
				logger.info(resourceBundle.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated quiz : " + updatedQuiz);
				return ResponseHandler.generateResponse(updatedQuiz, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Failed update Quiz : " + ex.getMessage());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}

	}

	
	
	//GET INACTIVE QUIZ DATA
	@GetMapping("/quiz/inactive")
	public ResponseEntity<List<Object>> getInactiveQuizzes(
			@RequestParam(name = "inactivequizzes") String inactivequizzes) throws CPException {
		List<Object> quizzes = null;
		try {

			if (inactivequizzes.equalsIgnoreCase("all")) {

				quizzes = quizService.getInactiveQuizzes();
				logger.info("Fetched all Inactive  :" + quizzes);

				return ResponseHandler.generateListResponse(quizzes, HttpStatus.OK);
			} else {

				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all quizzes : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));

		}
	}


	//ACTIVATE QUIZ BY QUIZ ID
	@PatchMapping("/quiz/{id}")
	public ResponseEntity<Object> updateActiveStatus(@PathVariable("id") int quizId) throws CPException {

		logger.debug("Entering updateActiveStatus");

		Object obj = null;

		try {
			obj = quizService.updateActiveStatus(quizId);

			if (obj == null) {
				logger.info(resourceBundle.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated quiz : " + obj);
				return ResponseHandler.generateResponse(obj, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update Quiz : " + ex.getMessage());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}
	}

	@GetMapping(path = "/basicauth")
	public AuthenticationBean basicauth() {
		return new AuthenticationBean("You are authenticated");
	}

	
	
	//GET LIST OF QUIZ BASED ON STUDENT ID
	@GetMapping("/quiz/studentId")
	public ResponseEntity<List<Object>> getAllQuizByStudentId(@RequestParam(name = "id") int studentId)
			throws CPException {
		logger.debug("Entering getAllQuiz");
		logger.info("Parameter  :" + studentId);

		List<Object> quizzes = null;

		try {
			quizzes = quizService.getAllQuizzesByProfileId(studentId);
			logger.info("Fetched all Quiz :" + quizzes);

			if (quizzes != null) {
				logger.debug("quizzes fetched generating response");
				return ResponseHandler.generateListResponse(quizzes, HttpStatus.OK);
			} else {
				logger.debug("quizzes not found");
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {
			ex.printStackTrace();

			logger.error("Failed getting all quizs : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));

		}

	}
	
	
	
	
	//GET LIST OF QUIZ BASED ON MODULE ID
	@GetMapping("/quiz/moduleId/{moduleId}")
	public ResponseEntity<List<Object>> getAllQuizByModuleId(@PathVariable("moduleId") int moduleId)
			throws CPException {
		logger.debug("Entering getAllQuizByStudentId");
		logger.info("Parameter  :" + moduleId);

		List<Object> quizzes = null;

		try {
			quizzes = quizService.getAllQuizzesByModuleId(moduleId);
			logger.info("Fetched all Quiz :" + quizzes);

			if (quizzes != null) {
				logger.debug("quizzes fetched generating response");
				return ResponseHandler.generateListResponse(quizzes, HttpStatus.OK);
			} else {
				logger.debug("quizzes not found");
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {
			ex.printStackTrace();

			logger.error("Failed getting all quizs : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));

		}

	}
	

	//GET INACTIVE QUIZ BY STUDENT ID
	@GetMapping("/quiz/enroll/inactive/profileid")
	public ResponseEntity<List<Object>> getAllInactiveQuizzesByStudentId(@RequestParam(name = "id") int studentId)
			throws CPException {
		logger.debug("Entering getAllInactiveQuizzesByStudentId");
		logger.info("Parameter  :" + studentId);

		List<Object> quizzes = null;

		try {
			quizzes = quizService.getAllInactiveQuizzesByStudentId(studentId);
			logger.info("Fetched all Quiz :" + quizzes);

			if (quizzes != null) {
				logger.debug("quizzes fetched generating response");
				return ResponseHandler.generateListResponse(quizzes, HttpStatus.OK);
			} else {
				logger.debug("quizzes not found");
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {
			ex.printStackTrace();

			logger.error("Failed getting all quizs : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));

		}

	}
	
	
	//GET ALL QUIZ BY TEACHER ID
	@GetMapping("/quiz/assign/active/profileid")
	public ResponseEntity<List<Object>> getAllQuizzesByTeacherId(@RequestParam(name = "id") int profileId)
			throws CPException {
		logger.debug("Entering getAllQuizzesByTeacherId");
		logger.info("Parameter  :" + profileId);

		List<Object> quizzes = null;

		try {
			quizzes = quizService.getAllQuizzesByTeacherId(profileId);
			logger.info("Fetched all Quiz :" + quizzes);

			if (quizzes != null) {
				logger.debug("quizzes fetched generating response");
				return ResponseHandler.generateListResponse(quizzes, HttpStatus.OK);
			} else {
				logger.debug("quizzes not found");
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {
			ex.printStackTrace();

			logger.error("Failed getting all quizs : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));

		}

	}
	
	
	//GET ALL ACTIVE QUIZ BY TEACHER ID
	@GetMapping("/quiz/assign/inactive/profileid")
	public ResponseEntity<List<Object>> getAllInactiveQuizzesByTeacherId(@RequestParam(name = "id") int profileId)
			throws CPException {
		logger.debug("Entering getAllInactiveQuizzesByTeacherId");
		logger.info("Parameter  :" + profileId);

		List<Object> quizzes = null;

		try {
			quizzes = quizService.getAllInactiveQuizzesByTeacherId(profileId);
			logger.info("Fetched all Quiz :" + quizzes);

			if (quizzes != null) {
				logger.debug("quizzes fetched generating response");
				return ResponseHandler.generateListResponse(quizzes, HttpStatus.OK);
			} else {
				logger.debug("quizzes not found");
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {
			ex.printStackTrace();

			logger.error("Failed getting all quizs : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));

		}

	}
}
