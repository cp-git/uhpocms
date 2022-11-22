/**
 * @author : Akash
 * @created on : 21 - Nov - 2022
 * @Description : This class is a controller for AdminInstitution
 * Last modified : None 
 */

package com.cpa.uhpocms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.uhpocms.entity.AdminInstitution;
import com.cpa.uhpocms.service.AdminInstitutionService;

@RequestMapping("/uhpocms")

@RestController
public class AdminInstitutionController {
	// autowire the AdminInstitutionService
	@Autowired
	private AdminInstitutionService adminInstitutionService;

	// creating/inserting entry in AdminInstitution
	@PostMapping("/institution")
	public AdminInstitution addAdminInstitution(@RequestBody AdminInstitution adminInstitution) {
		return adminInstitutionService.saveAdminInstitution(adminInstitution);
	}

	// get mapping that retrieves all the institution details from the db
	@GetMapping("/allinstitution")
	public List<AdminInstitution> getAllAdminInstitution() {
		return adminInstitutionService.getAllAdminInstitution();

	}

	// get mapping that retrieves the institution details by Name

	@GetMapping("/institution/{name}")

	public ResponseEntity<List<AdminInstitution>> getInstitutionByName(
			@RequestParam(name = "name") String adminInstitutionName) {
		// System.out.println("hey" + adminInstitutionName);
		return new ResponseEntity<List<AdminInstitution>>(
				adminInstitutionService.findByAdminInstitutionName(adminInstitutionName), HttpStatus.OK);
	}

	// deleting a specific record by using the method deleteAdminInstitutionByName()

	@DeleteMapping("/institution/{name}")
	public String deleteAdminInstitutionByName(@PathVariable("name") String adminInstitutionName) {
		adminInstitutionService.deleteAdminInstitutionByName(adminInstitutionName);
		return "Record delete successfully";
	}

	// bgudysbckbik
}
