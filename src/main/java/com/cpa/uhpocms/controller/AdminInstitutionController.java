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
	public ResponseEntity<Object> addAdminInstitution(@RequestBody AdminInstitution adminInstitution) {
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
	@GetMapping("/allinstitution")
	public List<AdminInstitution> getAllAdminInstitution() {
		return adminInstitutionService.getAllAdminInstitution();

	}

	/**
	 * @author: Akash
	 * @param: String adminInstitutionName
	 * @description :get mapping that retrieves the institution details by Name
	 */
	@GetMapping("/institution/{name}")
	public ResponseEntity<Object> getInstitutionByName(@RequestParam(name = "name") String adminInstitutionName) {
		return new ResponseEntity<Object>(adminInstitutionService.findByAdminInstitutionName(adminInstitutionName),
				HttpStatus.OK);
	}

	/**
	 * @author: Akash
	 * @param: String adminInstitutionName
	 * @description :deleting a specific record by using the method
	 *              deleteAdminInstitutionByName()
	 */
	@DeleteMapping("/institution/{name}")
	public String deleteAdminInstitutionByName(@PathVariable("name") String adminInstitutionName) {
		adminInstitutionService.deleteAdminInstitutionByName(adminInstitutionName);
		return "Record delete successfully";
	}

	/**
	 * @author: Akash
	 * @param: AdminInstitution adminInstitution, String adminInstitutionName
	 * @description : Updating a specific record by using the method
	 *              updateAdminInstitutionByName()
	 */
	@PutMapping("/institution/{name}")
	public ResponseEntity<Object> updateAdminInstitutionByName(@RequestBody AdminInstitution adminInstitution,
			@PathVariable("name") String adminInstitutionName) {
		return new ResponseEntity<Object>(
				adminInstitutionService.updateAdminInstitutionByName(adminInstitution, adminInstitutionName),
				HttpStatus.OK);

	}

}
