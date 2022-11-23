package com.cpa.uhpocms.controller;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

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

	InstituteAdminController() {
		resourceBundle = ResourceBundle.getBundle("ErrorMessage", Locale.US);
	}

	@PostMapping("/saveInstitituteAdmin")

	public ResponseEntity<Object> saveInstituteAdmin(@RequestBody InstituteAdmin instituteAdmin) {
		InstituteAdmin insAdmin;

		try {
			insAdmin = instituteAdminService.saveInstituteAdmin(instituteAdmin);
		} catch (Exception ee) {
			System.err.println("er003");
			return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");
		}
		return ResponseHandler.generateResponse(insAdmin, HttpStatus.CREATED);

	}

	@GetMapping("/getInstituteByname/{firstName}")
	public ResponseEntity<Object> getNameIntitute(@PathVariable("firstName") String firstName) throws CPException {

		InstituteAdmin instituteAdmin = null;
		try {
			instituteAdmin = instituteAdminService.getInstitutebyName(firstName);

			if (instituteAdmin != null) {
				return ResponseHandler.generateResponse(instituteAdmin, HttpStatus.OK);
			} else {
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err001");

			}

		} catch (Exception ee) {
			ee.printStackTrace();
			throw new CPException("err001", resourceBundle.getString("err001"));
		}

	}

	@PutMapping("/updateInstituteByName/{firstName}")
	public ResponseEntity<Object> updateEmployee(@RequestBody InstituteAdmin instituteAdmin,
			@PathVariable("firstName") String firstName) throws CPException {
		InstituteAdmin toFirstName = null;
		try {
			toFirstName = instituteAdminService.getInstitutebyName(firstName);
			if (toFirstName == null) {
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				toFirstName = instituteAdminService.updateInstituteAdmin(instituteAdmin, firstName);
				return ResponseHandler.generateResponse(toFirstName, HttpStatus.CREATED);

			}

		} catch (Exception ee) {
			System.err.println(ee.toString());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}

	}

	@GetMapping("/GetAllInstitute")
	public ResponseEntity<List<Object>> getAllAuthUsers(@RequestParam(name = "firstName") String firstName) {

		if (firstName.equals("all")) {
			System.out.println("inside");
			List<Object> adminInstitute = instituteAdminService.getAllInstitute();

			if (adminInstitute != null) {
				return new ResponseEntity<List<Object>>(adminInstitute, HttpStatus.OK);
			}

		}

		System.out.println(firstName + " outside");
		return ResponseHandler.generateListResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err002");

	}

	@DeleteMapping("/DeleteDepartmentByName/{firstName}")

	public ResponseEntity<Object> deleteDepartmentById(@PathVariable("firstName") String firstName) {
		int status = 0;

		status = instituteAdminService.deleteDepartmentById(firstName);

		if (status == 1) {
			return ResponseHandler.generateResponse(HttpStatus.ACCEPTED);
		} else {
			System.err.println(resourceBundle.getString("err005"));
			return ResponseHandler.generateResponse(HttpStatus.GONE, "err005");

		}

	}

}
