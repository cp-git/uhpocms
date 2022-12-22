package com.cpa.uhpocms.controller;

/**
 * @author Anmesh
 * @createdOn 30 Nov 2022
 * @Description Controller class for InstituteAdmin
 * 
 */

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

import com.cpa.uhpocms.entity.InstituteAdmin;
import com.cpa.uhpocms.exception.CPException;
import com.cpa.uhpocms.exception.ResponseHandler;
import com.cpa.uhpocms.service.InstituteAdminService;

@CrossOrigin
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

	/**
	 * @author : Anmesh
	 * @param : InstituteAdmin
	 * @return : InstituteAdmin
	 * @description : For Saving All the data
	 */

	@PostMapping("/profile")

	public ResponseEntity<Object> saveInstituteAdmin(@RequestBody InstituteAdmin instituteAdmin) throws CPException {
		InstituteAdmin institueAdminProfile = null;
		loggger.info("In Post Method...");
		try {
			InstituteAdmin institutionAdmin = instituteAdminService.findByUserId(instituteAdmin.getUserId());
			System.out.println("Value" + institutionAdmin);
			if (institutionAdmin == null) {
				institueAdminProfile = instituteAdminService.saveInstituteAdmin(instituteAdmin);
				loggger.info("Post Values" + institueAdminProfile);
				return ResponseHandler.generateResponse(institueAdminProfile, HttpStatus.CREATED);
			} else {
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err003");

			}
		} catch (Exception ee) {
			System.err.println("er003");
			loggger.error("User Creation failed in post method..");
			throw new CPException("err013", resourceBundle.getString("err003"));

		}

	}

	/**
	 * @author : Anmesh
	 * @param : getInstituteByName
	 * @return : ResponseEntity<Object>
	 * @description : For Getting Data using firstName
	 */

	@GetMapping("/profile/{firstName}")
	public ResponseEntity<Object> getIntituteByName(@PathVariable("firstName") String firstName) throws CPException {

		loggger.info("in getByName");
		InstituteAdmin instituteAdmin = null;
		try {
			instituteAdmin = instituteAdminService.getInstituteByName(firstName);
			loggger.info("GetInstituteByName Values" + instituteAdmin);

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

	/**
	 * @author : Anmesh
	 * @param : updateInstituteAdmin
	 * @return : ResponseEntity<Object>
	 * @description : For Updating Data using firstName
	 */

	@PutMapping("/profile/{firstName}")
	public ResponseEntity<Object> updateInstituteAdmin(@RequestBody InstituteAdmin instituteAdmin,
			@PathVariable("firstName") String firstName) throws CPException {

		loggger.info("inside the put method..");
		InstituteAdmin adminProfileFirstName = null;
		try {
			adminProfileFirstName = instituteAdminService.getInstituteByName(firstName);
			loggger.info("updateInstituteAdmin Values" + adminProfileFirstName);

			if (adminProfileFirstName == null) {
				loggger.info("Update Operation is failed...");
				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err004");
			} else {
				adminProfileFirstName = instituteAdminService.updateInstituteAdmin(instituteAdmin, firstName);
				return ResponseHandler.generateResponse(adminProfileFirstName, HttpStatus.CREATED);

			}

		} catch (Exception ee) {

			loggger.error(ee.toString());
			throw new CPException("err004", resourceBundle.getString("err004"));

		}

	}

	/**
	 * @author : Anmesh
	 * @param : getAllInstituteAdmin
	 * @return : ResponseEntity<List<object>>
	 * @description : For Getting All Data using firstName
	 */

	@GetMapping("/profile")
	public ResponseEntity<List<Object>> getAllInstituteAdmin(@RequestParam(name = "firstName") String firstName)
			throws CPException {

		loggger.info("in GetAllIntituteAdminProfile...");
		List<Object> adminInstitute = null;
		try {
			if (firstName.equals("all")) {
				System.out.println("inside");
				adminInstitute = instituteAdminService.getAllInstitute();
				loggger.info("GetAllIntituteAdminProfile Values" + adminInstitute);
				return ResponseHandler.generateListResponse(adminInstitute, HttpStatus.OK);
			} else {
				return ResponseHandler.generateListResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err002");
			}
		} catch (Exception ee) {
			ee.printStackTrace();
			throw new CPException("err002", resourceBundle.getString("err002"));

		}

	}

	/**
	 * @author : Anmesh
	 * @param : ResponseEntity<Object>
	 * @return : int
	 * @description : For Deleting Data using firstName
	 */

	@DeleteMapping("/profile/{firstName}")

	public ResponseEntity<Object> deleteDepartmentByName(@PathVariable("firstName") String firstName)
			throws CPException {
		loggger.info("inside the delete method...");
		int status = 0;

		status = instituteAdminService.deleteDepartmentByName(firstName);
		loggger.info("DeleteIntituteAdminProfile Values" + status);

		try {
			if (status == 1) {
				return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT);
			} else {
				loggger.error("User Deletion Failed...");

				return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err005");

			}
		} catch (Exception ee) {
			ee.printStackTrace();
			throw new CPException("err002", resourceBundle.getString("err005"));
		}

	}

}
