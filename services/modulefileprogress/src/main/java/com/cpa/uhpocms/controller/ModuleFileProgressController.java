/**
 * @author - Code Generator
 * @createdOn 04-04-2023
 * @Description Controller class for modulefileprogress
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

import com.cpa.uhpocms.entity.ModuleFileProgress;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.ModuleFileProgressService;

@CrossOrigin
@RestController
@RequestMapping("/uhpocms")
public class ModuleFileProgressController {

	@Autowired
	private ModuleFileProgressService modulefileprogressService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	ModuleFileProgressController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(ModuleFileProgressController.class);
	}

	/**
	 * @author Shradha
	 * @param modulefileprogress
	 * @return
	 * @throws CPException
	 * @desc Api to create new entry in moduleFile progress table
	 */
	@PostMapping("/modulefileprog")
	public ResponseEntity<Object> createModuleFileProgress(@RequestBody ModuleFileProgress modulefileprogress)
			throws CPException {
		logger.debug("Entering createModuleFileProgress");
		logger.info("data of creating ModuleFileProgress  :" + modulefileprogress.toString());

		ModuleFileProgress createdModuleFileProgress = null;
		try {

			ModuleFileProgress toCheckModuleFileProgress = modulefileprogressService
					.getModuleFileProgressByid(modulefileprogress.getId());
			logger.debug("existing modulefileprogress :" + toCheckModuleFileProgress);

			if (toCheckModuleFileProgress == null) {

				createdModuleFileProgress = modulefileprogressService.createModuleFileProgress(modulefileprogress);

				if (createdModuleFileProgress != null) {
					logger.info("ModuleFileProgress created :" + createdModuleFileProgress);

					return ResponseHandler.generateResponse(createdModuleFileProgress, HttpStatus.CREATED);
				}

				//
				else {
					logger.error(resourceBunde.getString("err003"));
					return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
				}
			} else {

				logger.error(resourceBunde.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed ModuleFileProgress creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}

	/**
	 * @author shradha
	 * @param id
	 * @return
	 * @throws CPException
	 * @description API to get particular entry in moduleFileProgressTable by id
	 */
	@GetMapping("/modulefileprog/{id}")
	public ResponseEntity<Object> getModuleFileProgressByid(@PathVariable("id") int id) throws CPException {
		logger.debug("Entering getModuleFileProgressByid");
		logger.info("entered user name :" + id);

		ModuleFileProgress modulefileprogress = null;

		try {

			modulefileprogress = modulefileprogressService.getModuleFileProgressByid(id);
			logger.info("fetched ModuleFileProgress :" + modulefileprogress);

			if (modulefileprogress != null) {
				logger.debug("ModuleFileProgress fetched generating response");
				return ResponseHandler.generateResponse(modulefileprogress, HttpStatus.OK);
			} else {
				logger.debug("ModuleFileProgress not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting modulefileprogress : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	/**
	 * @author shradha
	 * @param id
	 * @return
	 * @throws CPException
	 * @description Api to get all entries in moduleFileProgress table
	 */
	@GetMapping("/modulefileprog")
	public ResponseEntity<List<Object>> getAllModuleFileProgresss(@RequestParam(name = "id") String id)
			throws CPException {
		logger.debug("Entering getAllModuleFileProgress");
		logger.info("Parameter  :" + id);

		List<Object> modulefileprogresss = null;

		try {

			if (id.equalsIgnoreCase("all")) {

				modulefileprogresss = modulefileprogressService.getAllModuleFileProgresss();
				logger.info("Fetched all ModuleFileProgress :" + modulefileprogresss);

				return ResponseHandler.generateListResponse(modulefileprogresss, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all modulefileprogresss : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

	/**
	 * @author shradha
	 * @param modId
	 * @param studId
	 * @return
	 * @throws CPException
	 * @desc Api to get list of entries in respective table by providing module and
	 *       student id whose progress will be 100
	 */
	@GetMapping("/modulefileprog/{modId}/{studId}")
	public ResponseEntity<List<Object>> getModuleFileProgresss(@PathVariable("modId") int modId,
			@PathVariable("studId") int studId) throws CPException {
		logger.debug("Entering getAllModuleFileProgress");
		logger.info("Parameter  :" + modId);

		List<Object> modulefileprogresss = null;

		try {

			modulefileprogresss = modulefileprogressService.getModuleFileProgressByModStudProg(modId, studId);

			logger.info("Fetched all ModuleFileProgress :" + modulefileprogresss);
			if (modulefileprogresss != null) {

				return ResponseHandler.generateListResponse(modulefileprogresss, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all modulefileprogresss : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

	/**
	 * @author shradha
	 * @param modId
	 * @param studId
	 * @return
	 * @throws CPException
	 * @desc Api to get list of entries in respective table by providing module and
	 *       student id
	 */
	@GetMapping("/modulefileprog/mod_studId/{modId}/{studId}")
	public ResponseEntity<List<Object>> getModuleFileProgresssByModIdStudId(@PathVariable("modId") int modId,
			@PathVariable("studId") int studId) throws CPException {
		logger.debug("Entering getAllModuleFileProgress");
		logger.info("Parameter  :" + modId);

		List<Object> modulefileprogresss = null;

		try {

			modulefileprogresss = modulefileprogressService.getModuleFileProgressByModStudId(modId, studId);

			logger.info("Fetched all ModuleFileProgress :" + modulefileprogresss);
			if (modulefileprogresss != null) {

				return ResponseHandler.generateListResponse(modulefileprogresss, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all modulefileprogresss : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

	/**
	 * @author shradha
	 * @param id
	 * @return
	 * @throws CPException
	 * @desc Api to delete an entry in respective table by providing Id
	 */
	@DeleteMapping("/modulefileprog/{id}")
	public ResponseEntity<Object> deleteModuleFileProgressByid(@PathVariable("id") int id) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteModuleFileProgress  :" + id);
		// TODO - implement the business logic

		int count = 0;

		try {
			count = modulefileprogressService.deleteModuleFileProgressByid(id);
			if (count >= 1) {
				logger.info("deleted ModuleFileProgress : id = " + id);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete ModuleFileProgress :" + ex.getMessage());
			throw new CPException("err005", resourceBunde.getString("err005"));
		}

	}

	/**
	 * @author shradha
	 * @param modulefileprogress
	 * @param id
	 * @return
	 * @throws CPException
	 * @desc Api to update an entry in respective table
	 */
	@PutMapping("/modulefileprog/{id}")
	public ResponseEntity<Object> updateModuleFileProgressByid(@RequestBody ModuleFileProgress modulefileprogress,
			@PathVariable("id") int id) throws CPException {
		logger.debug("Entering updateModuleFileProgress");
		logger.info("entered  updateModuleFileProgress :" + modulefileprogress);

		ModuleFileProgress updatedModuleFileProgress = null;

		try {
			updatedModuleFileProgress = modulefileprogressService.updateModuleFileProgressByid(modulefileprogress, id);

			if (updatedModuleFileProgress == null) {
				logger.info(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated modulefileprogress : " + updatedModuleFileProgress);
				return ResponseHandler.generateResponse(updatedModuleFileProgress, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update ModuleFileProgress : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

	/**
	 * @param modulefileprogress
	 * @param fileid,            studentid, object
	 * @throws CPException
	 * @desc Api to update an entry in respective table
	 */
	@PutMapping("/modulefileprog/file_studid/{fileId}/{studentId}")
	public ResponseEntity<Object> updateFileProgressByFileIdAndStudentId(@PathVariable("fileId") int moduleFileId,
			@PathVariable("studentId") int studentId, @RequestBody ModuleFileProgress modulefileprogress)
			throws CPException {
		logger.debug("Entering updateFileProgressByFileIdAndStudentId");
		logger.info("entered  updateFileProgressByFileIdAndStudentId :" + modulefileprogress);

		ModuleFileProgress updatedModuleFileProgress = null;

		try {
			updatedModuleFileProgress = modulefileprogressService.updateFileProgressByFileIdAndStudentId(moduleFileId,
					studentId, modulefileprogress);

			if (updatedModuleFileProgress == null) {
				logger.info(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated modulefileprogress : " + updatedModuleFileProgress);
				return ResponseHandler.generateResponse(updatedModuleFileProgress, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update ModuleFileProgress : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

	/**
	 * @param fileid, studentid
	 * @throws CPException
	 * @desc Api to get file progress using student id and file id
	 */
	@GetMapping("/modulefileprog/file_studid/{fileId}/{studentId}")
	public ResponseEntity<Object> getFileProgressByFileIdAndStudentId(@PathVariable("fileId") int moduleFileId,
			@PathVariable("studentId") int studentId) throws CPException {
		logger.debug("Entering getFileProgressByFileIdAndStudentId");
		logger.info("entered  getFileProgressByFileIdAndStudentId :" + moduleFileId);

		ModuleFileProgress moduleFileProgress = null;

		try {
			moduleFileProgress = modulefileprogressService.getFileProgressByFileIdAndStudentId(moduleFileId, studentId);

			if (moduleFileProgress == null) {
				logger.info(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("modulefileprogress : " + moduleFileProgress);
				return ResponseHandler.generateResponse(moduleFileProgress, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update ModuleFileProgress : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

}
