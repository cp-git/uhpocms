/**
 * @author - Code Generator
 * @createdOn 08-12-2022
 * @Description-ServiceImpl class for module
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.ModuleController;
import com.cpa.uhpocms.entity.Module;
import com.cpa.uhpocms.repository.ModuleRepo;
import com.cpa.uhpocms.service.ModuleService;

@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleRepo moduleRepo;
	private static Logger logger;

	public ModuleServiceImpl() {
		logger = Logger.getLogger(ModuleServiceImpl.class);
	}

	/**
	 * @param : Module module
	 * @return : Module createdModule
	 * @description : For creating/inserting entry in teacher_module table
	 */
	@Override
	public Module createModule(Module module) {
		logger.debug("Entering createModule");
		Module createdModule = null;

		module.setModuleCreatedBy("admin");
		module.setModuleUpdatedBy("admin");

		createdModule = moduleRepo.save(module);
		logger.info("created Module :" + createdModule);
		return createdModule;
	}

	/**
	 * @param : String name
	 * @return : Module module
	 * @description : For get entry in teacher_module table
	 */
	@Override
	public Module getModuleByName(String name) {
		logger.debug("Entering getModuleByName");

		Module module = moduleRepo.findByModuleName(name);
		logger.info("Founded module :" + module);

		return module;
	}

	/**
	 * @return : List<Object> module
	 * @description : For fetching all module which are active state from
	 *              teacher_module table
	 */
	@Override
	public List<Object> getAllModules() {
		logger.debug("Entering getAllModules");

		List<Object> modules = moduleRepo.findByModuleIsActiveTrue();
		logger.info("Fetched all active module :" + modules);
		return modules;
	}

	/**
	 * @param : Module to update
	 * @return : module
	 * @description : For updating module of teacher_module table
	 */
	@Override
	public Module updateModuleByName(Module module, String name) {
		logger.debug("Entering updateModule");

		Module toUpdatedModule = null;
		Module updatedModule = null;

		toUpdatedModule = moduleRepo.findByModuleName(name);
		logger.info("exisitng Module :: " + toUpdatedModule);

		if (toUpdatedModule != null) {
			logger.debug("setting new data of Module to exisitng Module");

			toUpdatedModule.setModuleName(module.getModuleName());
			toUpdatedModule.setModuleDescription(module.getModuleDescription());
			toUpdatedModule.setModuleIsActive(module.isModuleIsActive());

			toUpdatedModule.setModuleStartDate(module.getModuleStartDate());
			toUpdatedModule.setModuleEndDate(module.getModuleEndDate());
			toUpdatedModule.setModuleCourse(module.getModuleCourse());
			toUpdatedModule.setModuleOrderNo(module.getModuleOrderNo());
			toUpdatedModule.setCourseId_id(module.getCourseId_id());

			updatedModule = moduleRepo.save(toUpdatedModule);

			logger.info("updated Module :" + updatedModule);
		}

		return updatedModule;
	}

	/**
	 * @param : String name
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of Module
	 * 
	 */
	@Override
	public int deleteModuleByName(String name) {
		logger.debug("Entering deleteModuleByName");

		int count = moduleRepo.deleteModuleByName(name);
		logger.info("deleted Module count : " + count);
		return count;
	}

}
