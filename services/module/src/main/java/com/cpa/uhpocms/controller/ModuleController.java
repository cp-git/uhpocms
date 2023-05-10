/**
 * @author - Code Generator
 * @createdOn 08-12-2022
 * @Description Controller class for module
 * 
 */

package com.cpa.uhpocms.controller;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.cpa.uhpocms.entity.Module;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.repository.ModuleRepo;
import com.cpa.uhpocms.service.ModuleService;

@CrossOrigin
@RestController
@RequestMapping("/uhpocms")
public class ModuleController {

	@Autowired
	private ModuleService moduleService;
	
	
	@Autowired
	private ModuleRepo moduleRepo;
	
	
	@Value("${file.base-path}")
	private String basePath;

	private ResourceBundle resourceBundle;
	private static Logger logger;

	ModuleController() {
		resourceBundle = ResourceBundle.getBundle("ErrorMessage", Locale.US);
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
				

				String courseName=moduleRepo.finByCourseByCourseId(module.getModuleId());
				System.out.println(courseName);

				
				String departmentName=moduleRepo.finByAdminInstitutionId(module.getCourseId_id());
				System.out.println(departmentName);
				
				
				String instituteName=moduleRepo.finByAdminInstitutionNameAndId(module.getCourseId_id());
				System.out.println(instituteName);
				
				File theDir = new File(basePath+"/institute/"+instituteName+"/"+departmentName+"/"+courseName+"/"+module.getModuleName());
				System.out.println(theDir);
				if (!theDir.exists()){
				    theDir.mkdirs();
				}
	
				return ResponseHandler.generateResponse(createdModule, HttpStatus.CREATED);

			} else {

				logger.error(resourceBundle.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Failed Module creation : " + ex.getMessage());
			throw new CPException("err003", resourceBundle.getString("err003"));
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
			throw new CPException("err001", resourceBundle.getString("err001"));
		}

	}
	
	@GetMapping("/module/{id}")
	public ResponseEntity<Object> getModuleById(@PathVariable("id") int moduleId) throws CPException {
		logger.debug("Entering getModuleById");
		logger.info("entered user name :" + moduleId);

		Module module = null;

		try {

			module = moduleService.getModuleById(moduleId);
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
			throw new CPException("err001", resourceBundle.getString("err001"));
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

				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all modules : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));

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
				logger.info(resourceBundle.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete Module :" + ex.getMessage());
			throw new CPException("err005", resourceBundle.getString("err005"));
		}

	}
	
	@DeleteMapping("/module/moduleId/{id}")
	public ResponseEntity<Object> deleteModuleById(@PathVariable("id") int moduleId) throws CPException {
		logger.debug("Entering deleteAuthUser");
		logger.info("entered deleteModule  :" + moduleId);
		// TODO - implement the business logic

		int count = 0;

		try {
			count = moduleService.deleteModuleBymoduleId(moduleId);
			if (count >= 1) {
				logger.info("deleted Module : Name = " + moduleId);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBundle.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete Module :" + ex.getMessage());
			throw new CPException("err005", resourceBundle.getString("err005"));
		}
	}

	@PutMapping("/module/{name}")
	public ResponseEntity<Object> updateModuleByName(@RequestBody Module module, @PathVariable("name") String name)
			throws CPException {
		logger.debug("Entering updateModule");
		logger.info("entered  updateModule :" + module);

		Module updatedModule = null;

		try {
			updatedModule = moduleService.updateModuleByName(module, name);

			if (updatedModule == null) {
				logger.info(resourceBundle.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated module : " + updatedModule);
				return ResponseHandler.generateResponse(updatedModule, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update Module : " + ex.getMessage());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}

	}
	
	@PutMapping("/module/moduleId/{id}")
	public ResponseEntity<Object> updateModuleById(@RequestBody Module module, @PathVariable("id") int moduleId)
			throws CPException {
		logger.debug("Entering updateModule");
		logger.info("entered  updateModule :" + module);

		Module updatedModule = null;

		try {
			updatedModule = moduleService.updateModuleBymoduleId(module, moduleId);

			if (updatedModule == null) {
				logger.info(resourceBundle.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated module : " + updatedModule);
				return ResponseHandler.generateResponse(updatedModule, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update Module : " + ex.getMessage());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}

	}
	
	/**
	 * @author Shradha
	 * @description api to get all inactive modules 
	 * @throws CPException
	 * @createdOn 10 Feb 2023
	 */
	@GetMapping("/module/inactive")
	public  ResponseEntity<List<Object>> getInactiveModules(@RequestParam(name = "inactivemodules") String inactivemodules) throws CPException 
	{
		List<Object> modules = null;
		try {

			if (inactivemodules.equalsIgnoreCase("all")) {

				modules = moduleService.getAllInactiveModules();
				logger.info("Fetched all Inactive  :" + modules);

				return ResponseHandler.generateListResponse(modules, HttpStatus.OK);
			} else {

				logger.info(resourceBundle.getString("err002"));
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err002");
			}

		} catch (Exception ex) {

			logger.error("Failed getting all modules : " + ex.getMessage());
			throw new CPException("err002", resourceBundle.getString("err002"));

		}
	}
	
	/**
	 * @author Shradha
	 * @description Api to update inactive status to active status
	 * @return
	 * @throws CPException
	 */
	@PatchMapping("/module/{name}")
	public ResponseEntity<Object> updateActiveStatus(@PathVariable("name") String name) throws CPException{
		
		logger.debug("Entering updateActiveStatus");
		

		Object obj = null;

		try { 
			obj = moduleService.updateActiveStatus(name);

			if (obj == null) {
				logger.info(resourceBundle.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated module : " + obj);
				return ResponseHandler.generateResponse(obj, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update module : " + ex.getMessage());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}
	}
	
    @GetMapping(path = "/basicauth")
    public AuthenticationBean basicauth() {
        return new AuthenticationBean("You are authenticated");
    }
    
    //get module by courseid
    @GetMapping(path = "module/courseId/{id}", produces = { "application/json", "application/xml" })
   	public ResponseEntity<List<Object>> getModuleByCourseId(@PathVariable("id") int courseId)
   			throws CPException {
   		try {
   			List<Object> moduleCourse = moduleService.findByCourseId(courseId);
   			if (moduleCourse != null) {
   				logger.info("Getting Module by " + courseId + " performed successfully");
   				logger.info(moduleCourse);
   				return new ResponseEntity<List<Object>>(moduleCourse, HttpStatus.OK);
   			}
   		}
   		catch (Exception e) {
   			logger.error(resourceBundle.getString("err021"));
   			throw new CPException("err021", resourceBundle.getString("err021"));
   		}
   		return ResponseHandler.generateListResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err022");
   	}
}
