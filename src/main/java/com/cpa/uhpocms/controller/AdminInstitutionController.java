package com.cpa.uhpocms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.uhpocms.entity.AdminInstitution;
import com.cpa.uhpocms.service.AdminInstitutionService;

@RequestMapping("/uhpocms")
//mark class as Controller
@RestController
public class AdminInstitutionController {
	// autowire the AdminInstitutionService
	@Autowired
	private AdminInstitutionService adminInstitutionService;

	// add AdminInstitution
	@PostMapping("/institution")
	public AdminInstitution addAdminInstitution(@RequestBody AdminInstitution adminInstitution) {
		return adminInstitutionService.saveAdminInstitution(adminInstitution);
	}

	//// get mapping that retrieves all the institution details from the db
	@GetMapping("/allinstitution")
	public List<AdminInstitution> getAllAdminInstitution() {
		return adminInstitutionService.getAllAdminInstitution();

	}

}
