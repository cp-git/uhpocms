/**
 * @author : Akash
 * @created on : 21 - Nov - 2022
 * @Description : This class is a controller for AdminInstitution
 * Last modified : None 
 */

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

import com.cpa.uhpocms.entity.AdminInstitution;
import com.cpa.uhpocms.helper.CPException;
import com.cpa.uhpocms.helper.ResponseHandler;
import com.cpa.uhpocms.service.AdminInstitutionService;

@RequestMapping("/uhpocms")

@RestController
public class AdminInstitutionController {
	// autowire the AdminInstitutionService
	@Autowired
	private AdminInstitutionService adminInstitutionService;

	private ResourceBundle resourceBundle;

	AdminInstitutionController() {
		resourceBundle = ResourceBundle.getBundle("ErrorMessage", Locale.US);
	}

	/**
	 * @author: Akash
	 * @param: AdminInstitution adminInstitution
	 * @description : For creating/inserting entry in AdminInstitution.
	 */
	@PostMapping("/institution")
	public ResponseEntity<Object> addAdminInstitution(@RequestBody AdminInstitution adminInstitution)
			throws CPException {
		AdminInstitution addInstitution = null;
		try {
			addInstitution = adminInstitutionService.saveAdminInstitution(adminInstitution);
		} catch (Exception e) {
			System.err.println(resourceBundle.getString("err013"));
			return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err013");
		}
		return ResponseHandler.generateResponse(addInstitution, HttpStatus.CREATED);
	}

	/**
	 * @author: Akash
	 * @param: List<AdminInstitution>
	 * @description : get mapping that retrieves all the institution details from
	 *              the db
	 */
	@GetMapping("/institution")
	public ResponseEntity<List<Object>> getAllAdminInstitution(
			@RequestParam(name = "name") String adminInstitutionName) {

		try {
			if (adminInstitutionName.equals("all")) {
				// adminInstitutionService.getAllAdminInstitution();
				return ResponseHandler.generateListResponse(adminInstitutionService.getAllAdminInstitution(),
						HttpStatus.OK);
			} else {
				return ResponseHandler.generateListResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err012");
			}
		} catch (Exception e) {
			System.err.println(resourceBundle.getString("err012"));

		}
		return ResponseHandler.generateListResponse(adminInstitutionService.getAllAdminInstitution(), HttpStatus.OK);

	}

	/**
	 * @author: Akash
	 * @param: String adminInstitutionName
	 * @description :get mapping that retrieves the institution details by Name
	 */
	@GetMapping("/institution/{name}")
	public ResponseEntity<Object> getInstitutionByName(@PathVariable("name") String adminInstitutionName) {
		AdminInstitution admin = null;
		admin = adminInstitutionService.findByAdminInstitutionName(adminInstitutionName);

		if (admin != null) {

			return ResponseHandler.generateResponse(admin, HttpStatus.OK);
		} else {
			System.err.println(resourceBundle.getString("err011"));
			return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err011");
		}

	}

	/**
	 * @author: Akash
	 * @param: String adminInstitutionName
	 * @description :deleting a specific record by using the method
	 *              deleteAdminInstitutionByName()
	 */
	@DeleteMapping("/institution/{name}")
	public ResponseEntity<Object> deleteAdminInstitutionByName(@PathVariable("name") String adminInstitutionName) {
		AdminInstitution admin = null;

		admin = adminInstitutionService.findByAdminInstitutionName(adminInstitutionName);
		if (admin != null) {
			return ResponseHandler.generateResponse(
					adminInstitutionService.deleteAdminInstitutionByName(adminInstitutionName), HttpStatus.NO_CONTENT);
		} else {
			System.err.println(resourceBundle.getString("err015"));
			return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err015");
		}

	}

	/**
	 * @author: Akash
	 * @param: AdminInstitution adminInstitution, String adminInstitutionName
	 * @description : Updating a specific record by using the method
	 *              updateAdminInstitutionByName()
	 */
	@PutMapping("/institution/{name}")
	public ResponseEntity<Object> updateAdminInstitutionByName(@RequestBody AdminInstitution adminInstitution,
			@PathVariable("name") String adminInstitutionName) throws CPException {
		try {
			adminInstitutionService.updateAdminInstitutionByName(adminInstitution, adminInstitutionName);
		} catch (Exception e) {
			System.err.println(resourceBundle.getString("err014"));
			return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "err014");
		}
		return ResponseHandler.generateResponse(
				adminInstitutionService.updateAdminInstitutionByName(adminInstitution, adminInstitutionName),
				HttpStatus.CREATED);

	}

}
