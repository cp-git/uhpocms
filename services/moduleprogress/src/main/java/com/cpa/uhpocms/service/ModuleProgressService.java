/**
 * @author  - Code Generator
 * @createdOn -  04-04-2023
 * @Description Entity class for ModuleProgress Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.ModuleProgress;

public interface ModuleProgressService {

	ModuleProgress createModuleProgress(ModuleProgress moduleprogress);

	ModuleProgress getModuleProgressByid(int id);

	List<Object> getAllModuleProgresss();

	ModuleProgress updateModuleProgressByid(ModuleProgress moduleprogress, int id);

	int deleteModuleProgressByid(int id);

}