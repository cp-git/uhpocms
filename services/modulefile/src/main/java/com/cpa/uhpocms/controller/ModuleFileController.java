/**
 * @author - Code Generator
 * @createdOn 13-02-2023
 * @Description Controller class for modulefile
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
import com.cpa.uhpocms.entity.ModuleFile;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.ModuleFileService;

@RestController
@CrossOrigin
@RequestMapping("/uhpocms")
public class ModuleFileController {

	@Autowired
	private ModuleFileService modulefileService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	ModuleFileController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(ModuleFileController.class);
	}

	@PostMapping("/modulefile")
	public ResponseEntity<Object> createModuleFile(@RequestBody ModuleFile modulefile) throws CPException {
		logger.debug("Entering createModuleFile");
		logger.info("data of creating ModuleFile  :" + modulefile.toString());

		ModuleFile createdModuleFile = null;
		try {

			ModuleFile toCheckModuleFile = modulefileService.getModuleFileByFile(modulefile.getModuleFile());
			logger.debug("existing modulefile :" + toCheckModuleFile);

			if (toCheckModuleFile == null) {

				// TODO: Uncomment below 2 lines and change the method name as per your Entity
				// class
				modulefile.setModuleFileCreatedBy("admin");
				modulefile.setModuleFileUpdatedBy("admin");

				createdModuleFile = modulefileService.createModuleFile(modulefile);
				logger.info("ModuleFile created :" + createdModuleFile);

				return ResponseHandler.generateResponse(createdModuleFile, HttpStatus.CREATED);

			} else {

				logger.error(resourceBunde.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed ModuleFile creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}

	@GetMapping("/modulefile/{file}")
	public ResponseEntity<Object> getModuleFileByFile(@PathVariable("file") String file) throws CPException {
		logger.debug("Entering getModuleFileByfile");
		logger.info("entered user name :" + file);

		ModuleFile modulefile = null;

		try {

			modulefile = modulefileService.getModuleFileByFile(file);
			logger.info("fetched ModuleFile :" + modulefile);

			if (modulefile != null) {
				logger.debug("ModuleFile fetched generating response");
				return ResponseHandler.generateResponse(modulefile, HttpStatus.OK);
			} else {
				logger.debug("ModuleFile not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting modulefile : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	@GetMapping("/modulefile")
	public ResponseEntity<List<Object>> getAllModuleFiles(@RequestParam(name = "file") String file) throws CPException {
		logger.debug("Entering getAllModuleFile");
		logger.info("Parameter  :" + file);

		List<Object> modulefiles = null;

		try {

			if (file.equalsIgnoreCase("all")) {

				modulefiles = modulefileService.getAllModuleFiles();
				logger.info("Fetched all ModuleFile :" + modulefiles);

				return ResponseHandler.generateListResponse(modulefiles, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all modulefiles : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

//	@DeleteMapping("/modulefile/{file}")
//	public ResponseEntity<Object> deleteModuleFileByFile(@PathVariable("file") String file) throws CPException {
//		logger.debug("Entering deleteModuleFile");
//		logger.info("entered deleteModuleFile  :" + file);
//		// TODO - implement the business logic
//
//		int count = 0;
//
//		try {
//			count = modulefileService.deleteModuleFileByFile(file);
//			if (count >= 1) {
//				logger.info("deleted ModuleFile : File = " + file);
//				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
//			} else {
//				logger.info(resourceBunde.getString("err005"));
//				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
//			}
//
//		} catch (Exception ex) {
//			logger.error("Failed to delete ModuleFile :" + ex.getMessage());
//			throw new CPException("err005", resourceBunde.getString("err005"));
//		}
//
//	}

	@DeleteMapping("/modulefileById/{id}")
	public ResponseEntity<Object> deleteModuleFileById(@PathVariable("id") int id) throws CPException {
		logger.debug("Entering deleteModuleFile");

		int count = 0;

		try {
			count = modulefileService.deleteModuleFileBymoduleFileId(id);
			if (count >= 1) {

				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete ModuleFile :" + ex.getMessage());
			throw new CPException("err005", resourceBunde.getString("err005"));
		}

	}

//	@PutMapping("/modulefile/{file}")
//	public ResponseEntity<Object> updateModuleFileByFile(@RequestBody ModuleFile modulefile,
//			@PathVariable("file") String file) throws CPException {
//		logger.debug("Entering updateModuleFile");
//		logger.info("entered  updateModuleFile :" + modulefile);
//
//		ModuleFile updatedModuleFile = null;
//
//		try {
//			updatedModuleFile = modulefileService.updateModuleFileByFile(modulefile, file);
//
//			if (updatedModuleFile == null) {
//				logger.info(resourceBunde.getString("err004"));
//				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
//			} else {
//				logger.info("updated modulefile : " + updatedModuleFile);
//				return ResponseHandler.generateResponse(updatedModuleFile, HttpStatus.CREATED);
//			}
//
//		} catch (Exception ex) {
//			logger.error("Failed update ModuleFile : " + ex.getMessage());
//			throw new CPException("err004", resourceBunde.getString("err004"));
//
//		}
//
//	}

	@PutMapping("/modulefileById/{id}")
	public ResponseEntity<Object> updateModuleFileById(@RequestBody ModuleFile modulefile, @PathVariable("id") int id)
			throws CPException {
		logger.debug("Entering updateModuleFile");
		logger.info("entered  updateModuleFile :" + modulefile);

		ModuleFile updatedModuleFile = null;

		try {
			updatedModuleFile = modulefileService.updateModuleFileBymoduleFileId(modulefile, id);

			if (updatedModuleFile == null) {
				logger.info(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated modulefile : " + updatedModuleFile);
				return ResponseHandler.generateResponse(updatedModuleFile, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update ModuleFile : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

	@GetMapping(path = "/basicauth")
	public AuthenticationBean basicauth() {
		return new AuthenticationBean("You are authenticated");
	}

	@GetMapping(path = "/modulefile/student")
	public ResponseEntity<List<Object>> getModuleFilesByStudentId(@RequestParam(name = "id") int studentId)
			throws CPException {
		logger.debug("Entering getModuleFilesByStudentId");
		logger.info("student id  :" + studentId);

		List<Object> modulefiles = null;

		try {
			modulefiles = modulefileService.getModuleFileByStudentId(studentId);
			if (modulefiles != null) {
				logger.info("Fetched all ModuleFile :" + modulefiles);
				return ResponseHandler.generateListResponse(modulefiles, HttpStatus.OK);
			} else {
				logger.info(resourceBunde.getString("err006"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err006");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all modulefiles by student id : " + ex.getMessage());
			throw new CPException("err006", resourceBunde.getString("err006"));

		}
	}

	/**
	 * @description api to get all inactive module files
	 */
	@GetMapping("/inactive")
	public ResponseEntity<List<Object>> getInactiveModuleFiles(
			@RequestParam(name = "inactivemodulesfile") String inactivemodulesfile) throws CPException {
		List<Object> modulefiles = null;
		try {

			if (inactivemodulesfile.equalsIgnoreCase("all")) {

				modulefiles = modulefileService.getAllInactiveModuleFiles();
				logger.info("Fetched all ModuleFile :" + modulefiles);

				return ResponseHandler.generateListResponse(modulefiles, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all Inactive modulefiles : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

	/**
	 * @description Api to update inactive status to active status
	 */

	@PatchMapping(path = "/modulefile/activate/{id}")
	public ResponseEntity<Object> activateModuleFileByModuleFileId(@PathVariable("id") int id) throws CPException {
		logger.debug("Entering activateModuleFileByModuleFileId");
		logger.info("entered activateModuleFileByModuleFileId  :" + id);
		// TODO - implement the business logic

		int count = 0;

		try {
			count = modulefileService.activateModuleFileBymoduleFileId(id);
			if (count >= 1) {
				logger.info("activated activateModuleFileByModuleFileId : Id = " + id);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err006"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err006");
			}

		} catch (Exception ex) {
			logger.error("Failed to activate Course :" + ex.getMessage());
			throw new CPException("err006", resourceBunde.getString("err006"));
		}
	}
}
