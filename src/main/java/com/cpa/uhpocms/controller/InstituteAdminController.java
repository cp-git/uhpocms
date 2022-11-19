package com.cpa.uhpocms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.uhpocms.entity.InstituteAdmin;
import com.cpa.uhpocms.service.InstituteAdminService;

@RestController
public class InstituteAdminController {
	@Autowired
	private InstituteAdminService instituteAdminService;
	
	@PostMapping("/saveInstitituteAdmin")
	
	public ResponseEntity<InstituteAdmin>saveInstituteAdmin(@RequestBody InstituteAdmin instituteAdmin)
	{	
		
		
		instituteAdminService.saveInstituteAdmin(instituteAdmin);
		return new ResponseEntity<>(instituteAdmin, HttpStatus.CREATED);
				
	}
	
	@GetMapping("/getInstituteByname/{firstName}")
	public InstituteAdmin getNameIntitute(@PathVariable("firstName")String firstName)
	{
	
		return instituteAdminService.getInstitutebyName(firstName);
	}
	
	
	
	
	
	

}
