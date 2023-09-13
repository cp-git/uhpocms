/**
 * @author Shradha
 * @description:Controller Class that maps requests to tomcat server and provides mapping functions to perform crud operation on  AdminDepartment entity class
 * @createdOn : 24 Nov 2022
 */

package com.cpa.uhpocms.controller;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.cpa.uhpocms.entity.AdminDepartment;
import com.cpa.uhpocms.entity.AdminInstitution;
import com.cpa.uhpocms.entity.AuthenticationBean;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.repository.AdminDeptRepo;
import com.cpa.uhpocms.service.AdminDeptService;

/*
 @author
 *
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/uhpocms")
public class AdminDeptController {

	private static final Logger logger = LogManager.getLogger(AdminDeptController.class);

	@Autowired
	AdminDeptService adminDeptService;
	
	
	@Autowired
	AdminDeptRepo adminDeptrepo;
	
	@Value("${file.base-path}")
	private String basePath;

	private ResourceBundle resourceBundle;

	AdminDeptController() {
		resourceBundle = ResourceBundle.getBundle("ErrorMessage", Locale.US);
	}

	

	
	//API for delete the Department by Id
	@DeleteMapping("/department/deptId/{id}")
	public ResponseEntity<Object> deleteDepartmentById(@PathVariable("id") int departmentid) throws CPException {

		int count = 0;

		try {

			count = adminDeptService.deleteDeptById(departmentid);
			if (count >= 1) {

				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBundle.getString("err005"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");
			}

		} catch (Exception ex) {
			logger.error("Failed to delete Course :" + ex.getMessage());
			throw new CPException("err005", resourceBundle.getString("err005"));
		}
	}

	/**
	 * @author Shradha
	 * @description: Method that provides mapping for getting all departments in
	 *               AdminDepartment Entity
	 * @createdOn : 24 Nov 2022
	 */

	
	
	
	//API For Getting All Departments
	@GetMapping(value = "/getdept", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Object>> getDepartment(@RequestParam("name") String name) throws CPException {

		try {
			List<Object> adminDept = null;

			if (name.equalsIgnoreCase("all")) {
				adminDept = adminDeptService.getAdminDepartments();
				if (adminDept.isEmpty() == false) {

					logger.info("getting all AdminDepartment entries performed successfully!");
					logger.info(adminDept);
					return ResponseHandler.generateListResponse(adminDept, HttpStatus.OK);
				}
			} else if (name.equalsIgnoreCase("inactive")) {
				adminDept = adminDeptService.getAllInactiveDepartments();
				return ResponseHandler.generateListResponse(adminDept, HttpStatus.OK);
			}
		} catch (Exception e) {

			logger.info("Unable to fetch all data due to exception occurence");

			throw new CPException("err022", resourceBundle.getString("err022"));

		}

		logger.error(resourceBundle.getString("err022"));
		return ResponseHandler.generateListResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err022");

	}

	

	



	/**
	 * @author Shradha
	 * @throws CPException
	 * @description: Method that provides mapping for insert a department in
	 *               AdminDepartment Entity
	 * @createdOn : 24 Nov 2022
	 */

	@PostMapping(value = "/department", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<Object> insertDepartment(@RequestBody AdminDepartment adminDepartment,
			HttpServletResponse response) throws CPException {
		logger.info("Entered insertDepartment() ");
		try {
			
			List<AdminDepartment> listDepartment=adminDeptrepo.findDepartmentByAdminInstitutionId(adminDepartment.getInstitutionId());

			for(AdminDepartment dept:listDepartment)
			{
				if(dept.getInstitutionId() == adminDepartment.getInstitutionId()) {
				   if (dept.getName().equalsIgnoreCase(adminDepartment.getName())) {
		                // Data already exists, handle accordingly (e.g., throw an exception or return an error message)
					   throw new CPException("err001", resourceBundle.getString("err001"));
		            }
				}
			}
			AdminDepartment refAdminDepartment = null;
			
			
			refAdminDepartment = adminDeptService.insertDept(adminDepartment);
			if (refAdminDepartment != null) {
				logger.info("Inserting AdminDepartment performed successfully");
				logger.info(refAdminDepartment);
				
				
				String instituteName=adminDeptrepo.finByAdminInstitutionId(adminDepartment.getId());
 				
 				
 				int instituteId=adminDeptrepo.finByAdminInstitutionsId(adminDepartment.getId());
 				
				
 				
 				String instituteNameAndId=instituteName+"_"+instituteId;
 				
 				
 				File theDir = new File(basePath+"/institute/"+instituteNameAndId+"/"+adminDepartment.getName());
				if (!theDir.exists()){
				    theDir.mkdirs();
				}
				
				return new ResponseEntity<>(refAdminDepartment, HttpStatus.CREATED);
			}
			
		
		} catch (Exception e) {

			logger.info("Unable to create entry due to exception occurence");
			throw new CPException("err013", resourceBundle.getString("err013"));

		}
		logger.error(resourceBundle.getString("err013"));
		return ResponseHandler.generateResponse("err013", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	

	

	@PutMapping("/department/departmentID/{id}")
	public ResponseEntity<Object> updateDepartmentById(@RequestBody AdminDepartment adminDepartment,
			@PathVariable("id") int departmentid) throws CPException {
		logger.debug("Entering updateDepartment");
		logger.info("entered  updateDepartment :" + adminDepartment);

		AdminDepartment updateDepartment = null;

		try {
			updateDepartment = adminDeptService.updateDepartmentById(adminDepartment, departmentid);

			if (updateDepartment == null) {
				logger.info(resourceBundle.getString("err004"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				logger.info("updated adminDepartment : " + updateDepartment);
				return ResponseHandler.generateResponse(updateDepartment, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			logger.error("Failed update Department : " + ex.getMessage());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}

	}

	@GetMapping(path = "/basicauth")
	public AuthenticationBean basicauth() {
		return new AuthenticationBean("You are authenticated");
	}

	//API for getting inactive department by institute id
	@GetMapping(path = "department/institutionId/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Object>> getInactiveDepartmentByInstitutionId(@PathVariable("id") int institutionId)
			throws CPException {

		try {
			List<Object> adminDept = adminDeptService.findByInstitutionId(institutionId);
			if (adminDept != null) {

				logger.info("Getting AdminDepartment by " + institutionId + " performed successfully");
				logger.info(adminDept);
				return new ResponseEntity<List<Object>>(adminDept, HttpStatus.OK);
			}
		}

		catch (Exception e) {

			logger.error(resourceBundle.getString("err021"));
			throw new CPException("err021", resourceBundle.getString("err021"));

		}

		return ResponseHandler.generateListResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err022");
	}

	/**
	 * @description: for activating deactivated department by using department id
	 *
	 */
	
	//Activate the department by id
	@PatchMapping(path = "/department/activate/{id}")
	public ResponseEntity<Object> ActivateAdminDepartmentById(@PathVariable("id") int departmentId) throws CPException {
		logger.debug("activate institution by id " + departmentId);
		int count = 0;

		try {
			count = adminDeptService.activateDepartment(departmentId);

			if (count >= 1) {
				logger.info("activated admin deaprtment : adminDepartmentId = " + departmentId);
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				logger.info(resourceBundle.getString("err016"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err006");
			}

		} catch (Exception ex) {
			logger.error("Failed to activate admin department :" + ex.getMessage());
			throw new CPException("err006", resourceBundle.getString("err006"));
		}

	}
	


	
	//API for getting Department by profile id
	@GetMapping("/department/profile/{id}")
	public ResponseEntity<Object> getDepartmentByprofileId(@PathVariable("id") int profileid) throws CPException {
		logger.debug("Entering getDepartmentByprofileId");

		List<Object> adminDepartment = null;

		try {

			adminDepartment = adminDeptService.findActiveDepartmentOfAssignCoursesByProfileId(profileid);
			logger.info("fetched Department :" + adminDepartment);

			if (adminDepartment != null) {
				logger.debug("Department fetched generating response");
				return ResponseHandler.generateResponse(adminDepartment, HttpStatus.OK);
			} else {
				logger.debug("Department not found");
				return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting course : " + ex.getMessage());
			throw new CPException("err001", resourceBundle.getString("err001"));
		}

	}
	
	
	//API for getting inactive Department by institute 
	@GetMapping("/department/inactive/instid/{id}")
	public ResponseEntity<List<Object>> getInactiveDepartmentsByInstitutionId(@PathVariable("id") int institutionId) throws CPException {
		logger.debug("Entering getInactiveDepartmentsByInstitutionId");

		List<Object> adminDepartments = null;

		try {

			adminDepartments = adminDeptService.getInactiveDepartmentsByInstituionId(institutionId);
			logger.info("fetched Department :" + adminDepartments);

			if (adminDepartments != null) {
				logger.debug("Department fetched generating response");
				return ResponseHandler.generateListResponse(adminDepartments, HttpStatus.OK);
			} else {
				logger.debug("Department not found");
				return ResponseHandler.generateListResponse(HttpStatus.NOT_FOUND, "err001");
			}

		} catch (Exception ex) {

			logger.error("Failed getting course : " + ex.getMessage());
			throw new CPException("err001", resourceBundle.getString("err001"));
		}

	}
	



}
