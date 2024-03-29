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

	Module createModule(Module module);

	Module getModuleByName(String name);

	Module getModuleById(int moduleId);

	List<Object> getAllModules();

	Module updateModuleByName(Module module, String name);

	int deleteModuleByName(String name);

	List<Object> findByCourseId(int courseId);

	List<Object> getAllInactiveModules();

	Object updateActiveStatus(String name);
	
	Object updateActiveStatusByModuleId (int moduleid);

	int deleteModuleBymoduleId(int moduleid);

//
	Module updateModuleBymoduleId(Module module, int moduleId);
//
//	int activateModuleBymoduleId(int moduleid);

	List<Object> getModulesOfAssignedCoursesByProfileId(int profileId);

	List<Object> getModulesOfEnrolledCoursesByProfileId(int profileId);
}