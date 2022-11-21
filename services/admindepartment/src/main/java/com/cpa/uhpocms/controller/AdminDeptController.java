package com.cpa.uhpocms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.cpa.uhpocms.entity.AdminDepartment;

import com.cpa.uhpocms.service.AdminDeptService;


/*
 @author
 * 
 * 
 */
@RestController
@RequestMapping("/uhpocms")
public class AdminDeptController {

	@Autowired
	AdminDeptService adminDeptService;
	
	@GetMapping(value="/getdept")
	public ResponseEntity<List<AdminDepartment>> getDepartmentById( HttpServletResponse response) {

		List<AdminDepartment> adminDepartment = new ArrayList<>();
		 adminDepartment = adminDeptService.getAdminDepartments();
		

		if (adminDepartment != null) {
			// set status code to 200
			response.setStatus(200);
			// get status code
			int status = response.getStatus();

			return new ResponseEntity<>(adminDepartment, HttpStatus.valueOf(status));
		}

		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value="/department",
	        consumes = { "application/json" ,"application/xml"}, 
	        produces = {"application/json", "application/xml" }
	)
	public ResponseEntity<AdminDepartment> insertDepartment(@RequestBody AdminDepartment adminDepartment,HttpServletResponse response) {
		// set status code to 200
		response.setStatus(201);
		// get status code
		
		int status = response.getStatus();
		System.out.println("Department id :: " + adminDepartment.getId());
		AdminDepartment refAdminDepartment = adminDeptService.insertDept(adminDepartment);
		return new ResponseEntity<>(refAdminDepartment, HttpStatus.valueOf(status));

	}
	
	
	@PutMapping(value="/department/{name}",
	        consumes = { "application/json" ,"application/xml"}, 
	        produces = {"application/json", "application/xml" }
	)
	public ResponseEntity<AdminDepartment> updateDepartment(@PathVariable("name") String name , @RequestBody AdminDepartment adminDepartment,HttpServletResponse response) {
		// set status code to 200
		response.setStatus(201);
		// get status code
		
		int status = response.getStatus();
		adminDepartment = adminDeptService.updateDept(adminDepartment,name);
		return new ResponseEntity<>(adminDepartment, HttpStatus.valueOf(status));

	}
	
}
