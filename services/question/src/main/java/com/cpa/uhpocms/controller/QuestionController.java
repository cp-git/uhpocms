/**
 * @author - Code Generator
 * @createdOn 07-12-2022
 * @Description Controller class for question
 * 
 */

package com.cpa.uhpocms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.cpa.uhpocms.entity.Answer;
import com.cpa.uhpocms.entity.AuthenticationBean;
import com.cpa.uhpocms.entity.Question;
import com.cpa.uhpocms.entity.QuestionAnswer;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.repository.QuestionRepo;
import com.cpa.uhpocms.service.QuestionService;

@CrossOrigin
@RestController
@RequestMapping("/uhpocms")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuestionRepo questionRepo;

	private ResourceBundle resourceBundle;
	private static Logger logger;

	QuestionController() {
		resourceBundle = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(QuestionController.class);
	
	}
	
	@Value("${file.base-path}")
	private String basePath;



	// GET ALL INACTIVE QUESTIONS
	@GetMapping("/question/inactive")
	public ResponseEntity<List<Object>> getInactiveQuestions(
			@RequestParam(name = "inactivequestions") String inactivequestions) throws CPException {
		List<Object> questions = null;
		try {

			if (inactivequestions.equalsIgnoreCase("all")) {

				questions = questionService.getInActiveQuestions();
				logger.info("Fetched all Inactive Question :" + questions);

				return ResponseHandler.generateListResponse(questions, HttpStatus.OK);
			} else {

				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all questions : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));

		}
	}

	//GET ALL ACTIVE QUESTIONS
	@GetMapping("/question")
	public ResponseEntity<List<Object>> getAllQuestions(@RequestParam(name = "figure") String figure)
			throws CPException {
		logger.debug("Entering getAllQuestion");
		logger.info("Parameter  :" + figure);

		List<Object> questions = null;

		try {

			if (figure.equalsIgnoreCase("all")) {

				questions = questionService.getAllQuestions();
				logger.info("Fetched all Question :" + questions);

				return ResponseHandler.generateListResponse(questions, HttpStatus.OK);
			} else {

				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all questions : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));

		}
	}

	//DELETE QUESTION BY FIGURE
	@DeleteMapping("/question/{figure}")
	public ResponseEntity<Object> deleteQuestionByFigure(@PathVariable("figure") String figure) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteQuestion  :" + figure);
		// TODO - implement the business logic

		int count = 0;

		try {
			count = questionService.deleteQuestionByFigure(figure);
			if (count >= 1) {
				logger.info("deleted Question : Figure = " + figure);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBundle.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete Question :" + ex.getMessage());
			throw new CPException("err005", resourceBundle.getString("err005"));
		}

	}

	
	// DELETE QUESTION AND ANSER BY QUESTION ID
	@DeleteMapping("/question/deletequeansbyid/{questionId}")
	public ResponseEntity<Object> deleteQuestionAnswerById(@PathVariable("questionId") int questionId) throws CPException {
		logger.debug("Entering deleteAuthUser");
		// logger.info("entered deleteQuestion :" + figure);
		// TODO - implement the business logic

		Integer ansCount = 0;
		
	    Integer keyCnt = 0;
	    Map<Integer, Integer> result = new LinkedHashMap<>();
		try {
			
			
			result= questionService.deleteQuestionWithAnswersMCQ(questionId);
			if (result != null) {
		        System.out.println("Entered IN IF LOOP OF CONTROLLER");
				return ResponseHandler.generateResponse(result,HttpStatus.OK);
			} else {
				logger.info(resourceBundle.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete Question :" + ex.getMessage());
			throw new CPException("err005", resourceBundle.getString("err005"));
		}

	}

	//UPDATE QUESTION ANSER BY FIGURE
	@PutMapping("/question/{figure}")
	public ResponseEntity<Object> updateQuestionByFigure(@RequestBody Question question,
			@PathVariable("figure") String figure) throws CPException {
		logger.debug("Entering updateQuestion");
		logger.info("entered  updateQuestion :" + question);

		Question updatedQuestion = null;

		try {
			updatedQuestion = questionService.updateQuestionByFigure(question, figure);

			if (updatedQuestion == null) {
				logger.info(resourceBundle.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated question : " + updatedQuestion);
				return ResponseHandler.generateResponse(updatedQuestion, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update Question : " + ex.getMessage());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}

	}

	// UPDATE UESTION ANSWER BY QUESTION ID
	@PutMapping("/question/byid/{questionId}")
	public ResponseEntity<Object> updateQuestionById(@RequestBody Question question,
			@PathVariable("questionId") int questionId) throws CPException {
		logger.debug("Entering updateQuestion");
		logger.info("entered  updateQuestion :" + question);

		Question updatedQuestion = null;

		try {
			updatedQuestion = questionService.updateQuestionById(question, questionId);

			if (updatedQuestion == null) {
				logger.info(resourceBundle.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated question : " + updatedQuestion);
				return ResponseHandler.generateResponse(updatedQuestion, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update Question : " + ex.getMessage());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}

	}

	

	
	// ACTIVATE QUESTION BY QUESTION FIGURE
	@PatchMapping("/question/{figure}")
	public ResponseEntity<Object> updateActiveStatus(@PathVariable("figure") String figure) throws CPException {

		logger.debug("Entering updateActiveStatus");

		Object obj = null;

		try {
			obj = questionService.updateActiveStatus(figure);

			if (obj == null) {
				logger.info(resourceBundle.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated question : " + obj);
				return ResponseHandler.generateResponse(obj, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update Question : " + ex.getMessage());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}
	}

	@GetMapping(path = "/basicauth")
	public AuthenticationBean basicauth() {
		return new AuthenticationBean("You are authenticated");
	}	
	

	//GET QUESTION IMAGE BY ID
	@GetMapping("/question/id/{questionId}")
	public ResponseEntity<Object> getQuestionById(@PathVariable("questionId") int questionId) throws CPException {
		logger.debug("Entering getQuestionByfigure");
		// logger.info("entered user name :" + question);
		Question question = null;
		try {

			question = questionService.getQuestionById(questionId);
			logger.info("fetched Question :" + question);

			if (question != null) {
				logger.debug("Question fetched generating response");
				return ResponseHandler.generateResponse(question, HttpStatus.OK);
			} else {
				logger.debug("Question not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting question : " + ex.getMessage());
			throw new CPException("err001", resourceBundle.getString("err001"));
		}

	}

	//GET ALL QUESTION BY QUIZ ID
	@GetMapping("/questions")
	public ResponseEntity<List<Object>> getQuestionByQuizId(@RequestParam(name = "quizId") int quizId)
			throws CPException {
		logger.debug("Entering getAllQuestion");
		logger.info("Parameter  :" + quizId);
		List<Object> questions = null;
		try {
			if (quizId > 0) {
				questions = questionService.getAllQuestionsByQuizId(quizId);
				logger.info("Fetched all Question :" + questions.size());
				return ResponseHandler.generateListResponse(questions, HttpStatus.OK);
			} else {
				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}
		} catch (Exception ex) {
			logger.error("Failed getting all questions : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));
		}
	}
	
	
	//GET SHUFFLED QUESTION BY QUIZ ID
	@GetMapping("/questions/quizid/{quizId}")
	public ResponseEntity<List<Object>> getShuffledQuesitonByQuizId(@PathVariable(name = "quizId") int quizId)
			throws CPException {
		logger.debug("Entering getAllQuestion");
		logger.info("Parameter  :" + quizId);
		List<Object> questions = null;
		try {
			if (quizId > 0) {
				questions = questionService.getShuffledQuestionByQuizId(quizId);
				logger.info("Fetched all Question :" + questions.size());
				return ResponseHandler.generateListResponse(questions, HttpStatus.OK);
			} else {
				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}
		} catch (Exception ex) {
			logger.error("Failed getting all questions : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));
		}
	}

	//INSERTING THE QUESTION ANSWER ADD AND UPDATE
	@PostMapping("/question/add")
	public ResponseEntity<Object> addQuestionsAndAnswers(@RequestPart("request") QuestionAnswer request,@RequestParam(value="files",required=false)List<MultipartFile> files) throws CPException {
		// Extract questions and answers arrays from the request

		Question question = request.getQuestion();
		Answer[] answers = request.getAnswers();

		Integer questionId = 0;
		
		System.out.println();
		//files=new ArrayList<>();
		 
		
	
		
		
		try {

			logger.info("fetched Question :" + question);
			logger.info("fetched answers :" + answers.length);
			
			
		
				if(files == null) {
					files=new ArrayList<>();
					
					 for (MultipartFile file : files) {
					  if (file != null && !file.isEmpty()) {
			                // File is not null and has content
			                // Process the file and perform the insertion logic
			            	
			            	
			                String fileName = file.getOriginalFilename();
			                // Insert the file into the database or perform any other necessary operations
			                System.out.println("File inserted: " + fileName);
//			                files.add(file);
			            } 
					 }
					 
				}
			
			
		
			try {
				
		        for (MultipartFile file : files) {
		            if (file != null && !file.isEmpty()) {
		                // File is not null and has content
		                // Process the file and perform the insertion logic
		            	
		            	
		                String fileName = file.getOriginalFilename();
		                // Insert the file into the database or perform any other necessary operations
		               
//		                files.add(file);
		            } else {
		                // File is null or empty
		                // Perform your desired action here, such as logging an error or returning a response
		              
		              
		            }
		        }
			}
			catch(Exception ee) {
				System.out.println(ee);
			}
		    
			
			

			
		        
		        
		    

			
			questionId = questionService.addQuestionsAndAnswers(question, answers);
			
			System.out.println(question.getQuestionId());
			
		
			logger.info("generated value in controller :" + questionId);
			if (questionId > 0) {
			
				//Institute Name
				String instituteName=questionRepo.getInstituteByQuestion(questionId);
				
				
				
				//Institute Id
				int instituteId=questionRepo.getInstituteidByQuestion(questionId);
			
				
				
				String InstituteNameandId=instituteName+"_"+instituteId;
				
				              
				
				
				
				//Department Name
				String departmentName=questionRepo.getDepartmentByQuestion(questionId);
				
				
				String deptName=departmentName.trim();
				
				
				
				//Course Name
				String courseName=questionRepo.getCourseByQuestion(questionId);
				
				
				String cName=courseName.trim();
				
				//Module Name
				
				String moduleName=questionRepo.getModuleByQuestion(questionId);
				
				
				//Quiz Name
				
				String quizName=questionRepo.getQuizByQuestion(questionId);
				
				
				int quizId=questionRepo.getQuizIdByQuestion(questionId);
			
				
				String QuestionData=quizName+"_"+quizId;
			
				
				
				
				
				File theDir = new File(basePath+"/institute/"+InstituteNameandId+"/"+deptName+"/"+cName+"/"+moduleName+"/"+QuestionData);
				System.out.println("the directory path"+theDir);
				if (!theDir.exists()){
				    theDir.mkdirs();
				}
				
				List<String> fileNames = new ArrayList<>();

				for (MultipartFile file : files) {
					
					String fileName;
					
					String fileData=file.getOriginalFilename();
					
					if(fileData == file.getOriginalFilename()) {
						String fileDataName=questionId+"_"+file.getOriginalFilename();
						 fileName = StringUtils.cleanPath(fileDataName);
						
					}
					else {
						 fileName = StringUtils.cleanPath(file.getOriginalFilename());
						
						
					}
					
					
					
					
					Path fileStorage = Paths.get(basePath+"/institute/"+InstituteNameandId+"/"+deptName+"/"+cName+"/"+moduleName+"/"+QuestionData+"/", fileName).toAbsolutePath().normalize();
					Files.copy(file.getInputStream(), fileStorage, StandardCopyOption.REPLACE_EXISTING);
					fileNames.add(fileName);
				}


				

				logger.debug("added question and answers successfully");
				return ResponseHandler.generateResponse(questionId, HttpStatus.OK);
			} else {
				logger.debug("Failed to add question and answers");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err006");
			}

		} catch (Exception ex) {

			logger.error("Failed getting question : " + ex.getMessage());
			throw new CPException("err001", resourceBundle.getString("err001"));
		}
//		return ResponseHandler.generateResponse(HttpStatus.OK);

	}
	
	
	
	//GET DISPLAY IMAGE BY QUESTION ID
	@GetMapping(path="getFileById/{questionId}")
    ResponseEntity<InputStreamResource> getImageById(@PathVariable int questionId) throws IOException { //download file
     
		System.out.println("in controller..");
		Question myFile;
		 myFile =questionService.findQuestionById(questionId);
      
        
		//Institute Name
		String instituteName=questionRepo.getInstituteByQuestion(questionId);
	
		
		
		//Institute Id
		int instituteId=questionRepo.getInstituteidByQuestion(questionId);
		
		
		
		String InstituteNameandId=instituteName+"_"+instituteId;
	
		
		
		//Department Name
		String departmentName=questionRepo.getDepartmentByQuestion(questionId);
		
		
		String deptName=departmentName.trim();
		
		
		
		//Course Name
		String courseName=questionRepo.getCourseByQuestion(questionId);
	
		
		String cName=courseName.trim();
		
		//Module Name
		
		String moduleName=questionRepo.getModuleByQuestion(questionId);
	
		
		//Quiz Name
		
		String quizName=questionRepo.getQuizByQuestion(questionId);
		
		
		int quizId=questionRepo.getQuizIdByQuestion(questionId);
		
		
		String QuestionData=quizName+"_"+quizId;
		
	
		
		String imageName=myFile.getQuestionId()+"_"+myFile.getQuestionFigure();
        
        
       String address =basePath+"/institute/"+InstituteNameandId+"/"+deptName+"/"+cName+"/"+moduleName+"/"+QuestionData+"/"+imageName;
       File file = new File(address);
   
       InputStream inputStream = new FileInputStream(file);

       InputStreamResource a = new InputStreamResource(inputStream);
//      
        HttpHeaders httpHeaders = new HttpHeaders();
//        // httpHeaders.put("Content-Disposition", Collections.singletonList("attachmen"+image.getName())); //download link
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);
        //httpHeaders.set("Content-Disposition", "attachment; filename=" + myFile.getAdminInstitutionPicture()); // best for download
//        System.out.println(myFile.getAdminInstitutionPicture());
       
       
       
        return new ResponseEntity<InputStreamResource>(a, httpHeaders, HttpStatus.ACCEPTED);
    }


}
