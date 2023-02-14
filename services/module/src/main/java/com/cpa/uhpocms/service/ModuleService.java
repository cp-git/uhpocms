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

	List<Object> getAllModules();

	Module updateModuleByName(Module module, String name);

	int deleteModuleByName(String name);

	/*
	 * @author:Shradha
	 * @createdOn:10 Feb 2023
	 */
	List<Object> getAllInactiveModules();
	
	/**
	 * @author Shradha
	 * @createdOn:10 Feb 2023
	 */
	Object updateActiveStatus(String name);
}