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
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.exception.ResponseHandler;
import com.cpa.uhpocms.service.AdminDeptService;

/*
 @author
 *
 *
 */
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
	 * @description: Method that provides mapping to soft delete the entry in
	 *               AdminDepartment by providing department name
	 * @createdOn : 24 Nov 2022
	 */

	@DeleteMapping(value = "/department/{name}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> deleteDepartment(@PathVariable("name") String name, HttpServletResponse response) {
		try {
			adminDeptService.deleteDept(name);
			response.setStatus(204);
			int status = response.getStatus();
			HttpStatus.valueOf(status);
			Object adminDept = adminDeptService.getDeptByName(name);
			logger.info("AdminDepartment soft delete performed successfully");
			logger.info(adminDept);
			return new ResponseEntity<>(HttpStatus.valueOf(status));
		} catch (Exception e) {

			try {
				throw new CPException("err005", resourceBunde.getString("err005"));
			} catch (CPException cp) {
				logger.error(resourceBunde.getString("err005"));
				return ResponseHandler.generateResponse("err005", HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}

	}

	/**
	 * @author Shradha
	 * @description: Method that provides mapping for getting all departments in
	 *               AdminDepartment Entity
	 * @createdOn : 24 Nov 2022
	 */

	@GetMapping(value = "/getdept", produces = { "application/json", "application/xml" })

	public ResponseEntity<List<Object>> getDepartment(HttpServletResponse response, @RequestParam("name") String name)
			throws CPException {

		try {
			List<Object> adminDept = adminDeptService.getAdminDepartments();

			if (name.equalsIgnoreCase("all")) {
				if (adminDept.isEmpty() == false) {

					// set status code to 200
					response.setStatus(200);
					// get status code
					int status = response.getStatus();
					logger.info("getting all AdminDepartment entries performed successfully!");
					logger.info(adminDept);
					return new ResponseEntity<>(adminDept, HttpStatus.valueOf(status));
				}
			}
		} catch (Exception e) {
			response.setStatus(500);
			int status = response.getStatus();
			HttpStatus.valueOf(status);

			logger.error(resourceBunde.getString("err022"));
			try {
				throw new CPException("err022", resourceBunde.getString("err022"));
			} catch (CPException cp) {

			}

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
	public ResponseEntity<Object> getDepartmentByName(@PathVariable("name") String name, HttpServletResponse response)
			throws CPException {

		try {
			Object adminDept = adminDeptService.getDeptByName(name);
			if (adminDept != null) {
				// set status code to 200
				response.setStatus(200);
				// get status code
				int status = response.getStatus();
				logger.info("Getting AdminDepartment by " + name + " performed successfully");
				logger.info(adminDept);
				return new ResponseEntity<>(adminDept, HttpStatus.valueOf(status));
			}
		}

		catch (Exception e) {
			response.setStatus(500);
			int status = response.getStatus();
			HttpStatus.valueOf(status);
//			System.err.println(resourceBunde.getString("err021"));

			logger.error(resourceBunde.getString("err021"));
			return ResponseHandler.generateResponse("err021", HttpStatus.INTERNAL_SERVER_ERROR);

		}
		logger.error(resourceBunde.getString("err021"));
		return ResponseHandler.generateResponse("err021", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * @author Shradha
	 * @description: Method that provides mapping for insert a department in
	 *               AdminDepartment Entity
	 * @createdOn : 24 Nov 2022
	 */

	@PostMapping(value = "/department", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<Object> insertDepartment(@RequestBody AdminDepartment adminDepartment,
			HttpServletResponse response) {

		try {
			AdminDepartment refAdminDepartment = null;
			int status;

			refAdminDepartment = adminDeptService.insertDept(adminDepartment);
			// set status code to 200
			response.setStatus(201);
			// get status code
			status = response.getStatus();
			logger.info("Inserting AdminDepartment performed successfully");
			logger.info(refAdminDepartment);
			return new ResponseEntity<>(refAdminDepartment, HttpStatus.valueOf(status));
		} catch (Exception e) {

			try {

				throw new CPException("err013", resourceBunde.getString("err013"));
			} catch (CPException cp) {
				logger.error(resourceBunde.getString("err013"));
				return ResponseHandler.generateResponse("err013", HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}

	}

	/**
	 * @author Shradha
	 * @description: Method that provides mapping for updating a departments in
	 *               AdminDepartment Entity by providing department name
	 * @createdOn : 24 Nov 2022
	 */

	@PutMapping(value = "/department/{name}", produces = { "application/json", "application/xml" })

	public ResponseEntity<Object> updateDepartment(@PathVariable("name") String name,
			@RequestBody AdminDepartment adminDepartment, HttpServletResponse response) throws CPException {
		try {
			AdminDepartment refAdminDepartment;
			response.setStatus(201);

			int status = response.getStatus();

			refAdminDepartment = (AdminDepartment) adminDeptService.updateDept(adminDepartment, name);
			logger.info("Updating admin department for " + name + " performed successfully");
			logger.info(refAdminDepartment);
			return new ResponseEntity<>(refAdminDepartment, HttpStatus.valueOf(status));
		} catch (Exception e) {

			try {
				throw new CPException("err004", resourceBunde.getString("err004"));
			} catch (CPException cp) {
				logger.error(resourceBunde.getString("err004"));
				return ResponseHandler.generateResponse("err004", HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}

	}

}
