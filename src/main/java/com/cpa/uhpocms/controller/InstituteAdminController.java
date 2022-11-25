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

import com.cpa.uhpocms.InstituteadminApplication;
import com.cpa.uhpocms.entity.InstituteAdmin;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.exception.ResponseHandler;
import com.cpa.uhpocms.service.InstituteAdminService;

@RestController
@RequestMapping("/uhpocms")
public class InstituteAdminController {
	@Autowired
	private InstituteAdminService instituteAdminService;

	private ResourceBundle resourceBundle;
	
	 private static final Logger loggger = Logger.getLogger(InstituteAdminController.class);

	InstituteAdminController() {
		resourceBundle = ResourceBundle.getBundle("ErrorMessage", Locale.US);
	}

	@PostMapping("/profile")

	public ResponseEntity<Object> saveInstituteAdmin(@RequestBody InstituteAdmin instituteAdmin) {
		InstituteAdmin insAdmin;
			loggger.info("In Post Method...");
		try {
			insAdmin = instituteAdminService.saveInstituteAdmin(instituteAdmin);
		} catch (Exception ee) {
			System.err.println("er003");
			loggger.error("User Creation failed in post method..");
			return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
		}
		return ResponseHandler.generateResponse(insAdmin, HttpStatus.CREATED);

	}

	@GetMapping("/profile/{firstName}")
	public ResponseEntity<Object> getNameIntitute(@PathVariable("firstName") String firstName) throws CPException {

		loggger.info("in getByName");
		InstituteAdmin instituteAdmin = null;
		try {
			instituteAdmin = instituteAdminService.getInstitutebyName(firstName);

			if (instituteAdmin != null) {
				return ResponseHandler.generateResponse(instituteAdmin, HttpStatus.OK);
			} else {
				loggger.debug("Not Found");
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err001");

			}

		} catch (Exception ee) {
			ee.printStackTrace();
			loggger.error("Exception Occured in getNameInstitute Method");
			throw new CPException("err001", resourceBundle.getString("err001"));
		}

	}

	@PutMapping("/profile/{firstName}")
	public ResponseEntity<Object> updateEmployee(@RequestBody InstituteAdmin instituteAdmin,
			@PathVariable("firstName") String firstName) throws CPException {
		
		loggger.info("inside the put method..");
		InstituteAdmin toFirstName = null;
		try {
			toFirstName = instituteAdminService.getInstitutebyName(firstName);
			if (toFirstName == null) {
				loggger.info("Update Operation is failed...");
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				toFirstName = instituteAdminService.updateInstituteAdmin(instituteAdmin, firstName);
				return ResponseHandler.generateResponse(toFirstName, HttpStatus.CREATED);

			}

		} catch (Exception ee) {
			System.err.println(ee.toString());
			loggger.error(ee.toString());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}

	}

	@GetMapping("/profile")
	public ResponseEntity<List<Object>> getAllAuthUsers(@RequestParam(name = "firstName") String firstName) {

		loggger.info("in GetAllIntituteAdminProfile...");
		if (firstName.equals("all")) {
			System.out.println("inside");
			List<Object> adminInstitute = instituteAdminService.getAllInstitute();

			if (adminInstitute != null) {
				return new ResponseEntity<List<Object>>(adminInstitute, HttpStatus.OK);
			}

		}

		System.out.println(firstName + " outside");
		loggger.error("Not found ALL Data");
		return ResponseHandler.generateListResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err002");

	}

	@DeleteMapping("/profile/{firstName}")

	public ResponseEntity<Object> deleteDepartmentById(@PathVariable("firstName") String firstName) {
		loggger.info("inside the delete method...");
		int status = 0;

		status = instituteAdminService.deleteDepartmentById(firstName);

		if (status == 1) {
			return ResponseHandler.generateResponse(HttpStatus.ACCEPTED);
		} else {
			loggger.error("User Deletion Failed...");
			System.err.println(resourceBundle.getString("err005"));
			return ResponseHandler.generateResponse(HttpStatus.GONE, "err005");

		}

	}

}
