package com.cpa.uhpocms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	@PutMapping("/updateInstituteByName/{firstName}")
	public InstituteAdmin updateEmployee(@RequestBody InstituteAdmin instituteAdmin,@PathVariable("firstName")
    String  firstName)
	{
		return instituteAdminService.updateInstituteAdmin(instituteAdmin, firstName);
	}
	
	
   @GetMapping("/GetAllInstitute")
	
	public ResponseEntity<List<InstituteAdmin>> getAllAuthUsers(@RequestParam(name = "firstName") String firstName) {

		if (firstName.equals("all")) {
			List<InstituteAdmin> adminInstitute = instituteAdminService.getAllInstitute();
			
			if (adminInstitute != null) {
				return new ResponseEntity<List<InstituteAdmin>>(adminInstitute, HttpStatus.OK);
			}
		}

		return new ResponseEntity<List<InstituteAdmin>>(HttpStatus.NOT_FOUND);
	}
	
	
   @DeleteMapping("/DeleteDepartmentByName/{firstName}")
	 
   public String deleteDepartmentById(@PathVariable("firstName")
                                      String firstName)
   {
	   
	   instituteAdminService.deleteDepartmentById(firstName);
       return "Deleted";
   }
	
	
	

}
