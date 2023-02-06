/**
 * @author Shradha
 * @description:Controller Class that maps requests to tomcat server and provides mapping functions to perform crud operation on  AdminDepartment entity class
 * @createdOn : 24 Nov 2022
 */

package com.cpa.uhpocms.controller;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.cpa.uhpocms.entity.AdminDepartment;
import com.cpa.uhpocms.entity.AuthenticationBean;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
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

	private ResourceBundle resourceBunde;

	AdminDeptController() {
		resourceBunde = ResourceBundle.getBundle("ErrorMessage", Locale.US);
	}

	/**
	 * @author Shradha
	 * @throws CPException
	 * @description: Method that provides mapping to soft delete the entry in
	 *               AdminDepartment by providing department name
	 * @createdOn : 24 Nov 2022
	 */

	@DeleteMapping(value = "/department/{name}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> deleteDepartment(@PathVariable("name") String name) throws CPException {

		logger.debug("Entered deleteDepartment() ");
		Object adminDept = null;
		try {
			adminDept = adminDeptService.getDeptByName(name);
			if (adminDept != null) {
				adminDeptService.deleteDept(name);

				logger.info("AdminDepartment soft delete performed successfully");
				logger.info(adminDept);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			logger.info("Unable to perform delete operation due to exception occurence");
			throw new CPException("err005", resourceBunde.getString("err005"));

		}
		logger.error(resourceBunde.getString("err005"));
		return ResponseHandler.generateResponse("err005", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	/**
	 * @author Shradha
	 * @description: Method that provides mapping for getting all departments in
	 *               AdminDepartment Entity
	 * @createdOn : 24 Nov 2022
	 */

	@GetMapping(value = "/getdept", produces = { "application/json", "application/xml" })

	public ResponseEntity<List<Object>> getDepartment(@RequestParam("name") String name) throws CPException {

		try {
			List<Object> adminDept = adminDeptService.getAdminDepartments();

			if (name.equalsIgnoreCase("all")) {
				if (adminDept.isEmpty() == false) {

					logger.info("getting all AdminDepartment entries performed successfully!");
					logger.info(adminDept);
					return ResponseHandler.generateListResponse(adminDept, HttpStatus.OK);
				}
			}
		} catch (Exception e) {

			logger.info("Unable to fetch all data due to exception occurence");

			throw new CPException("err022", resourceBunde.getString("err022"));

		}

		logger.error(resourceBunde.getString("err022"));
		return ResponseHandler.generateListResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err022");

	}

	/**
	 * @author Shradha
	 * @description: Method that provides mapping for getting department in
	 *               AdminDepartment Entity by providing department name
	 * @createdOn : 24 Nov 2022
	 */

	@GetMapping(value = "/getdept/{name}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getDepartmentByName(@PathVariable("name") String name) throws CPException {

		try {
			Object adminDept = adminDeptService.getDeptByName(name);
			if (adminDept != null) {

				logger.info("Getting AdminDepartment by " + name + " performed successfully");
				logger.info(adminDept);
				return new ResponseEntity<>(adminDept, HttpStatus.OK);
			}
		}

		catch (Exception e) {

			logger.error(resourceBunde.getString("err021"));
			throw new CPException("err021", resourceBunde.getString("err021"));

		}
		logger.info("Unable to fetch data belonging to name" + name + "due to exception occurence");
		return ResponseHandler.generateResponse("err021", HttpStatus.INTERNAL_SERVER_ERROR);
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
			AdminDepartment refAdminDepartment = null;
			int status;

			refAdminDepartment = adminDeptService.insertDept(adminDepartment);
			if (refAdminDepartment != null) {
				logger.info("Inserting AdminDepartment performed successfully");
				logger.info(refAdminDepartment);
				return new ResponseEntity<>(refAdminDepartment, HttpStatus.CREATED);
			}
		} catch (Exception e) {

			logger.info("Unable to create entry due to exception occurence");
			throw new CPException("err013", resourceBunde.getString("err013"));

		}
		logger.error(resourceBunde.getString("err013"));
		return ResponseHandler.generateResponse("err013", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * @author Shradha
	 * @description: Method that provides mapping for updating a departments in
	 *               AdminDepartment Entity by providing department name
	 * @createdOn : 24 Nov 2022
	 *
	 */

	@PutMapping(value = "department/{name}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> updateDepartment(@PathVariable("name") String name,
			@RequestBody AdminDepartment adminDepartment, HttpServletResponse response) throws CPException {
		try {
			AdminDepartment refAdminDepartment;
			Object adminDept = adminDeptService.getDeptByName(name);
			if (adminDept != null) {
				refAdminDepartment = (AdminDepartment) adminDeptService.updateDept(adminDepartment, name);
				logger.info("Updating admin department for " + name + " performed successfully");
				logger.info(refAdminDepartment);
				return new ResponseEntity<>(refAdminDepartment, HttpStatus.CREATED);
			}
		} catch (Exception e) {

			logger.info("Unable to update entry in Admin_Department table due to exception occurence");
			throw new CPException("err004", resourceBunde.getString("err004"));

		}
		logger.error(resourceBunde.getString("err004"));
		return ResponseHandler.generateResponse("err004", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(path = "/basicauth")
	public AuthenticationBean basicauth() {
		return new AuthenticationBean("You are authenticated");
	}

	@GetMapping(path = "department/institutionId/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Object>> getDepartmentByInstitutionId(@PathVariable("id") int institutionId)
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

			logger.error(resourceBunde.getString("err021"));
			throw new CPException("err021", resourceBunde.getString("err021"));

		}

		return ResponseHandler.generateListResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err022");
	}

}
