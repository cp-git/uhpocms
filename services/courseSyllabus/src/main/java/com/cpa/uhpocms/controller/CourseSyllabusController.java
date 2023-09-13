/**
 * @author - Code Generator
 * @createdOn 27-02-2023
 * @Description Controller class for courseSyllabus
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.uhpocms.entity.CourseSyllabus;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.CourseSyllabusService;

@RestController
@RequestMapping("/uhpocms")
@CrossOrigin
public class CourseSyllabusController {

	@Autowired
	private CourseSyllabusService courseSyllabusService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	CourseSyllabusController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(CourseSyllabusController.class);
	}

	//INSERT COURSE SYLLABUS
	@PostMapping("/courseSyllabu" + "" + "s")
	public ResponseEntity<Object> createCourseSyllabus(@RequestBody CourseSyllabus courseSyllabus) throws CPException {
		logger.debug("Entering createCourseSyllabus");
		logger.info("data of creating CourseSyllabus  :" + courseSyllabus.toString());

		CourseSyllabus createdCourseSyllabus = null;
		try {

			CourseSyllabus toCheckCourseSyllabus = courseSyllabusService
					.getCourseSyllabusByid(courseSyllabus.getCourseSyllabusId());
			logger.debug("existing courseSyllabus :" + toCheckCourseSyllabus);

			if (toCheckCourseSyllabus == null) {

				// TODO: Uncomment below 2 lines and change the method name as per your Entity
				// class
				courseSyllabus.setCreatedBy("admin");
				courseSyllabus.setModifiedBy("admin");

				createdCourseSyllabus = courseSyllabusService.createCourseSyllabus(courseSyllabus);
				logger.info("CourseSyllabus created :" + createdCourseSyllabus);

				return ResponseHandler.generateResponse(createdCourseSyllabus, HttpStatus.CREATED);

			} else {

				logger.error(resourceBunde.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed CourseSyllabus creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}

	//GET COURSE SYALLBUS BY ID
	@GetMapping("/courseSyllabus/{id}")
	public ResponseEntity<Object> getCourseSyllabusByid(@PathVariable("id") int courseSyllabusId) throws CPException {
		logger.debug("Entering getCourseSyllabusByid");
		logger.info("entered user name :" + courseSyllabusId);

		CourseSyllabus courseSyllabus = null;

		try {

			courseSyllabus = courseSyllabusService.getCourseSyllabusByid(courseSyllabusId);
			logger.info("fetched CourseSyllabus :" + courseSyllabus);

			if (courseSyllabus != null) {
				logger.debug("CourseSyllabus fetched generating response");
				return ResponseHandler.generateResponse(courseSyllabus, HttpStatus.OK);
			} else {
				logger.debug("CourseSyllabus not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting courseSyllabus : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	//GET ALL COURSE SYLLABUS
	@GetMapping("/courseSyllabus")
	public ResponseEntity<List<Object>> getAllCourseSyllabuss(@RequestParam(name = "name") String name)
			throws CPException {
		logger.debug("Entering getAllCourseSyllabus");
		logger.info("Parameter  :" + name);

		List<Object> courseSyllabuss = null;

		try {

			if (name.equalsIgnoreCase("all")) {

				courseSyllabuss = courseSyllabusService.getAllCourseSyllabuss();
				logger.info("Fetched all CourseSyllabus :" + courseSyllabuss);

				return ResponseHandler.generateListResponse(courseSyllabuss, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all courseSyllabuss : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

	//DELETE COURSE SYALLBUS BY ID
	@DeleteMapping("/courseSyllabus/{id}")
	public ResponseEntity<Object> deleteCourseSyllabusByid(@PathVariable("id") int id) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteCourseSyllabus  :" + id);
		// TODO - implement the business logic

		int count = 0;

		try {
			count = courseSyllabusService.deleteCourseSyllabusByid(id);
			if (count >= 1) {
				logger.info("deleted CourseSyllabus : id = " + id);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete CourseSyllabus :" + ex.getMessage());
			throw new CPException("err005", resourceBunde.getString("err005"));
		}

	}

	//UPDATE THE COURSE SYLLABUS BY ID
	@PutMapping("/courseSyllabus/{id}")
	public ResponseEntity<Object> updateCourseSyllabusByid(@RequestBody CourseSyllabus courseSyllabus,
			@PathVariable("id") int courseSyllabusId) throws CPException {
		logger.debug("Entering updateCourseSyllabus");
		logger.info("entered  updateCourseSyllabus :" + courseSyllabus);

		CourseSyllabus updatedCourseSyllabus = null;

		try {
			updatedCourseSyllabus = courseSyllabusService.updateCourseSyllabusByid(courseSyllabus, courseSyllabusId);

			if (updatedCourseSyllabus == null) {
				logger.info(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated courseSyllabus : " + updatedCourseSyllabus);
				return ResponseHandler.generateResponse(updatedCourseSyllabus, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update CourseSyllabus : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

}
