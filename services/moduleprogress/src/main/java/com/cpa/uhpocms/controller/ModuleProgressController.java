/**
 * @author - Code Generator
 * @createdOn 04-04-2023
 * @Description Controller class for moduleprogress
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

import com.cpa.uhpocms.entity.ModuleProgress;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.ModuleProgressService;

@CrossOrigin
@RestController
@RequestMapping("/uhpocms")
public class ModuleProgressController {

	@Autowired
	private ModuleProgressService moduleprogressService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	ModuleProgressController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(ModuleProgressController.class);
	}
	
	
/**
 * @author shradha
 * @param moduleprogress
 * @return
 * @throws CPException
 * @desc Api to create an entry in moduleprogress table
 */
	@PostMapping("/moduleprog")
	public ResponseEntity<Object> createModuleProgress(@RequestBody ModuleProgress moduleprogress) throws CPException {
		logger.debug("Entering createModuleProgress");
		logger.info("data for  creating ModuleProgress  :" + moduleprogress.toString());

		ModuleProgress createdModuleProgress = null;
		try {

			ModuleProgress toCheckModuleProgress = moduleprogressService.getModuleProgressByid(moduleprogress.getId());
			logger.debug("existing moduleprogress :" + toCheckModuleProgress);

			if (toCheckModuleProgress == null) {
				System.out.println("Entered into if loop");
			// TODO: Uncomment below 2 lines and change the method name as per your Entity class
			//	moduleprogress.setCreatedby("admin");
			//	moduleprogress.setUpdatedby("admin");
				createdModuleProgress = moduleprogressService.createModuleProgress(moduleprogress);

				if(createdModuleProgress != null)
				{
				logger.info("ModuleProgress created :" + createdModuleProgress);

				return ResponseHandler.generateResponse(createdModuleProgress, HttpStatus.CREATED);
				}
				
				else {logger.error(resourceBunde.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
					
				}
			} else {

				logger.error(resourceBunde.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed ModuleProgress creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}

	/**
	 * @author shradha
	 * @param id
	 * @return
	 * @throws CPException
	 * @desc Api to get an entry in resp. table by Id
	 */
	@GetMapping("/moduleprog/{id}")
	public ResponseEntity<Object> getModuleProgressByid(@PathVariable("id") int id)
			throws CPException {
		logger.debug("Entering getModuleProgressByid");
		logger.info("entered user name :" + id);
		
		ModuleProgress moduleprogress = null;

		try {

			moduleprogress = moduleprogressService.getModuleProgressByid(id);
			logger.info("fetched ModuleProgress :" + moduleprogress);

			if (moduleprogress != null) {
				logger.debug("ModuleProgress fetched generating response");
				return ResponseHandler.generateResponse(moduleprogress, HttpStatus.OK);
			} else {
				logger.debug("ModuleProgress not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting moduleprogress : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	/**
	 * @author shradha
	 * @param modId
	 * @param studId
	 * @return
	 * @throws CPException
	 * @desc Api to get list of entries by providing module and student Id's
	 */
	@GetMapping("/moduleprog/{modId}/{studId}")
	public ResponseEntity<Object> getModuleProgressBymodIdstudId(@PathVariable("modId") int modId, @PathVariable("studId") int studId)
			throws CPException {
		logger.debug("Entering getModuleProgressBymodIdstudId");
		logger.info("entered module Id and student Id :" + modId + studId);
		
		ModuleProgress moduleprogress = null;

		try {

			moduleprogress = moduleprogressService.getModuleProgressBymodstudId(modId, studId);
			logger.info("fetched ModuleProgress :" + moduleprogress);

			if (moduleprogress != null) {
				logger.debug("ModuleProgress fetched generating response");
				return ResponseHandler.generateResponse(moduleprogress, HttpStatus.OK);
			} else {
				logger.debug("ModuleProgress not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting moduleprogress : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	/**
	 * @author shradha
	 * @param id
	 * @return
	 * @throws CPException
	 * @desc api to get list of netries in resp table by providing course id
	 */
	@GetMapping("/moduleprog/courseId/{courseId}")
	public ResponseEntity<List<Object>> getAllModuleProgresssByCourseId(@PathVariable(name = "courseId") int courseId)
			throws CPException {
		logger.debug("Entering getAllModuleProgress");
		logger.info("Parameter  :" + courseId);
		
		List<Object> moduleprogresss = null;

		try {

			

				moduleprogresss = moduleprogressService.getAllModuleProgresssByCourseId(courseId);
				
				if(moduleprogresss != null)
				{
				logger.info("Fetched all ModuleProgress :" + moduleprogresss);

				return ResponseHandler.generateListResponse(moduleprogresss, HttpStatus.OK);
				}
				else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
				}
		

		} catch (Exception ex) {

			logger.error("Failed getting all moduleprogresss : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}
	
	/**
	 * @author shradha
	 * @param id
	 * @return
	 * @throws CPException
	 */
	@GetMapping("/moduleprog")
	public ResponseEntity<List<Object>> getAllModuleProgresss(@RequestParam(name = "id") String id)
			throws CPException {
		logger.debug("Entering getAllModuleProgress");
		logger.info("Parameter  :" + id);
		
		List<Object> moduleprogresss = null;

		try {

			if (id.equalsIgnoreCase("all")) {

				moduleprogresss = moduleprogressService.getAllModuleProgresss();
				logger.info("Fetched all ModuleProgress :" + moduleprogresss);

				return ResponseHandler.generateListResponse(moduleprogresss, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all moduleprogresss : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}
/**
 * @author Shradha
 * @param id
 * @return
 * @throws CPException
 * @desc Api to delete an entry in table
 */
	@DeleteMapping("/moduleprog/{id}")
	public ResponseEntity<Object> deleteModuleProgressByid(@PathVariable("id") int id) throws CPException {
		logger.debug("Entering deleteModuleProgressById");
		logger.info("entered deleteModuleProgress  :" + id);
		//TODO - implement the business logic
		
		int count = 0;

		try {
			count = moduleprogressService.deleteModuleProgressByid(id);
			if (count >= 1) {
				logger.info("deleted ModuleProgress : id = " + id);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete ModuleProgress :" + ex.getMessage());
			throw new CPException("err005", resourceBunde.getString("err005"));
		}
		

	}

	/**
	 * @author Shradha
	 * @param id
	 * @return
	 * @throws CPException
	 * @desc Api to update an entry in table
	 */
	@PutMapping("/moduleprog/{id}")
	public ResponseEntity<Object> updateModuleProgressByid(@RequestBody ModuleProgress moduleprogress,
			@PathVariable("id") int id) throws CPException {
		logger.debug("Entering updateModuleProgress");
		logger.info("entered  updateModuleProgress :" + moduleprogress);

		ModuleProgress updatedModuleProgress = null;

		try { 
			updatedModuleProgress = moduleprogressService.updateModuleProgressByid(moduleprogress, id);

			if (updatedModuleProgress == null) {
				logger.info(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated moduleprogress : " + updatedModuleProgress);
				return ResponseHandler.generateResponse(updatedModuleProgress, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update ModuleProgress : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

}
