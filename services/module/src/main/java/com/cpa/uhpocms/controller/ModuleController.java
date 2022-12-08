/**
 * @author - Code Generator
 * @createdOn 08-12-2022
 * @Description Controller class for module
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.uhpocms.entity.Module;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.ModuleService;

@RestController
@RequestMapping("/uhpocms")
public class ModuleController {

	@Autowired
	private ModuleService moduleService;;

	private ResourceBundle resourceBunde;
	private static Logger logger;

	ModuleController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
		logger = Logger.getLogger(ModuleController.class);
	}

	@PostMapping("/module")
	public ResponseEntity<Object> createModule(@RequestBody Module module) throws CPException {
		logger.debug("Entering createModule");
		logger.info("data of creating Module  :" + module.toString());

		Module createdModule = null;
		try {

			Module toCheckModule = moduleService.getModuleByName(module.getModuleName());
			logger.debug("existing module :" + toCheckModule);

			if (toCheckModule == null) {

				// TODO: Uncomment below 2 lines and change the method name as per your Entity
				// class
				module.setModuleCreatedBy("admin");
				module.setModuleUpdatedBy("admin");

				createdModule = moduleService.createModule(module);
				logger.info("Module created :" + createdModule);

				return ResponseHandler.generateResponse(createdModule, HttpStatus.CREATED);

			} else {

				logger.error(resourceBunde.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed Module creation : " + ex.getMessage());
			throw new CPException("err003", resourceBunde.getString("err003"));
		}
	}

	@GetMapping("/module/{name}")
	public ResponseEntity<Object> getModuleByName(@PathVariable("name") String name) throws CPException {
		logger.debug("Entering getModuleByname");
		logger.info("entered user name :" + name);

		Module module = null;

		try {

			module = moduleService.getModuleByName(name);
			logger.info("fetched Module :" + module);

			if (module != null) {
				logger.debug("Module fetched generating response");
				return ResponseHandler.generateResponse(module, HttpStatus.OK);
			} else {
				logger.debug("Module not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting module : " + ex.getMessage());
			throw new CPException("err001", resourceBunde.getString("err001"));
		}

	}

	@GetMapping("/module")
	public ResponseEntity<List<Object>> getAllModules(@RequestParam(name = "name") String name) throws CPException {
		logger.debug("Entering getAllModule");
		logger.info("Parameter  :" + name);

		List<Object> modules = null;

		try {

			if (name.equalsIgnoreCase("all")) {

				modules = moduleService.getAllModules();
				logger.info("Fetched all Module :" + modules);

				return ResponseHandler.generateListResponse(modules, HttpStatus.OK);
			} else {

				logger.info(resourceBunde.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all modules : " + ex.getMessage());
			throw new CPException("err002", resourceBunde.getString("err002"));

		}
	}

	@DeleteMapping("/module/{name}")
	public ResponseEntity<Object> deleteModuleByName(@PathVariable("name") String name) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteModule  :" + name);
		// TODO - implement the business logic

		int count = 0;

		try {
			count = moduleService.deleteModuleByName(name);
			if (count >= 1) {
				logger.info("deleted Module : Name = " + name);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBunde.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete Module :" + ex.getMessage());
			throw new CPException("err005", resourceBunde.getString("err005"));
		}

	}

	@PutMapping("/module/{name}")
	public ResponseEntity<Object> updateModuleByName(@RequestBody Module module, @PathVariable("name") String name)
			throws CPException {
		logger.debug("Entering updateModule");
		logger.info("entered  updateModule :" + module);

		Module updatedModule = null;

		try {
			updatedModule = moduleService.updateModule(module, name);

			if (updatedModule == null) {
				logger.info(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated module : " + updatedModule);
				return ResponseHandler.generateResponse(updatedModule, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update Module : " + ex.getMessage());
			throw new CPException("err004", resourceBunde.getString("err004"));

		}

	}

}
