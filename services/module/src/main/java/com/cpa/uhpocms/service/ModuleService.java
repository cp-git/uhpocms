/**
 * @author  - Code Generator
 * @createdOn -  08-12-2022
 * @Description- Service interface for Module Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.Module;

public interface ModuleService {

	//CREATE MODULE
	Module createModule(Module module);

	//GET LIST OF MOUDLE
	List<Object> getAllModules();

	//UPDATE THE MODULE NAME BY MOUDLE NAME
	Module updateModuleByName(Module module, String name);

	//DELETE MODULE BY NAME
	int deleteModuleByName(String name);

	//GET LIST OF MODULES BASED ON COURSE ID
	List<Object> findByCourseId(int courseId);

	//GET ALL INACTIVE MODULE LIST
	List<Object> getAllInactiveModules();
	
	//GET UPDATE ACTIVATE MODULE BY ID
	Object updateActiveStatusByModuleId (int moduleid);

	// DELETE MODULE BY MODULE ID
	int deleteModuleBymoduleId(int moduleid);

	//UPDATE MODULE BY MODULE ID
	Module updateModuleBymoduleId(Module module, int moduleId);
//
//	int activateModuleBymoduleId(int moduleid);

	//GET MODULE ASSIGN COURSES BY PROFILE ID
	List<Object> getModulesOfAssignedCoursesByProfileId(int profileId);

	// GET MODULES ENROLLED COURSES BY PROFILE ID
	List<Object> getModulesOfEnrolledCoursesByProfileId(int profileId);
}