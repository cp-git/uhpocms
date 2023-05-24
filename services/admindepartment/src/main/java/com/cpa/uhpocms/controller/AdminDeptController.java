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
			throw new CPException("err005", resourceBundle.getString("err005"));

		}
		logger.error(resourceBundle.getString("err005"));
		return ResponseHandler.generateResponse("err005", HttpStatus.INTERNAL_SERVER_ERROR);

	}

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
	 * @description: Method that provides mapping for getting department in
	 *               AdminDepartment Entity by providing department name
	 * @createdOn : 24 Nov 2022
	 */

	@GetMapping(value = "/getdept/{name}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getDepartmentByName(@PathVariable("name") String name) throws CPException {

		try {
			System.out.println("in controller...");
			AdminDepartment adminDept = adminDeptService.getDeptByName(name);
			System.out.println(adminDept);
			if (adminDept != null) {

				logger.info("Getting AdminDepartment by " + name + " performed successfully");
				logger.info(adminDept);
				return new ResponseEntity<>(adminDept, HttpStatus.OK);
			}
		}

		catch (Exception e) {

			logger.error(resourceBundle.getString("err021"));
			throw new CPException("err021", resourceBundle.getString("err021"));

		}
		logger.info("Unable to fetch data belonging to name" + name + "due to exception occurence");
		return ResponseHandler.generateResponse("err021", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/department/deptId/{id}")
	public ResponseEntity<Object> getDepartmentById(@PathVariable("id") int departmentid) throws CPException {
		logger.debug("Entering getDepartmentById");

		AdminDepartment adminDepartment = null;

		try {

			adminDepartment = adminDeptService.getDepartmentById(departmentid);
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
 				//System.out.println(instituteName);
 				
 				int instituteId=adminDeptrepo.finByAdminInstitutionsId(adminDepartment.getId());
 				//System.out.println(instituteId);
				
 				
 				String instituteNameAndId=instituteName+"_"+instituteId;
 				//System.out.println(instituteNameAndId);
 				
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

	@PostMapping("/dept")
	public ResponseEntity<Object> createDepartment(@RequestBody AdminDepartment adminDepartment) throws CPException {
		logger.debug("Entering createDepartment");
		logger.info("data of creating Department  :" + adminDepartment.toString());

		AdminDepartment createdDepartment = null;
		try {

			AdminDepartment toCheckDepartment = adminDeptService
					.getDepartmentByInstitutionIdAndName(adminDepartment.getInstitutionId(), adminDepartment.getName());

			logger.debug("existing admindepartment :" + toCheckDepartment);

			if (toCheckDepartment == null) {

				// TODO: Uncomment below 2 lines and change the method name as per your Entity
				// class
				adminDepartment.setModifiedBy("admin");
				adminDepartment.setCreatedBy("admin");

				createdDepartment = adminDeptService.createDepartment(adminDepartment);

				logger.info("Department created :" + createdDepartment);

				return ResponseHandler.generateResponse(createdDepartment, HttpStatus.CREATED);

			} else {

				logger.error(resourceBundle.getString("err003"));
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
			}

		} catch (Exception ex) {
			logger.error("Failed Course creation : " + ex.getMessage());
			throw new CPException("err003", resourceBundle.getString("err003"));
		}
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
			throw new CPException("err004", resourceBundle.getString("err004"));

		}
		logger.error(resourceBundle.getString("err004"));
		return ResponseHandler.generateResponse("err004", HttpStatus.INTERNAL_SERVER_ERROR);
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
	
//	@GetMapping("data/{id}")
//	
//	public List<String> getDepartmets(@PathVariable("id")int id) {
//		
//		List<String> dept;
//		
//		dept=adminDeptrepo.finByAdminInstitutionId(id);
//		System.out.println(dept);
//		
//		
//		return dept;
//	}

	@GetMapping("/department/profile/{id}")
	public ResponseEntity<Object> getDepartmentByprofileId(@PathVariable("id") int profileid) throws CPException {
		logger.debug("Entering getDepartmentByprofileId");

		List<Object> adminDepartment = null;

		try {

			adminDepartment = adminDeptService.getDepartmentByProfileId(profileid);
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

}
