/**
 * @author - Code Generator
 * @createdOn 08-12-2022
 * @Description-ServiceImpl class for module
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;
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
	private static final boolean ISACTIVE = true;
	private static Logger logger;

	public ModuleServiceImpl() {
		logger = Logger.getLogger(ModuleServiceImpl.class);
	}

	//CREATE MODULE
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



	//GET LIST OF MOUDLE
	@Override
	public List<Object> getAllModules() {
		logger.debug("Entering getAllModules");

		List<Object> modules = moduleRepo.findByModuleIsActiveTrue();

		logger.info("Fetched all active module :" + modules);
		return modules;
	}

	//UPDATE THE MODULE NAME BY MOUDLE NAME
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
			toUpdatedModule.setModuleReview(module.getModuleReview());
		

			updatedModule = moduleRepo.save(toUpdatedModule);

			logger.info("updated Module :" + updatedModule);
		}

		return updatedModule;
	}

	//DELETE MODULE BY NAME
	@Override
	public int deleteModuleByName(String name) {
		logger.debug("Entering deleteModuleByName");

		int count = moduleRepo.deleteModuleByName(name);
		logger.info("deleted Module count : " + count);
		return count;
	}

	//GET LIST OF MODULES BASED ON COURSE ID
	@Override
	public List<Object> findByCourseId(int courseId) {
		// TODO Auto-generated method stub
		List<Object> moduleCourse = moduleRepo.findByCourseIdAndModuleIsActiveOrderByModuleOrderNo(courseId, ISACTIVE);
		return moduleCourse;

	}

	//GET ALL INACTIVE MODULE LIST
	public List<Object> getAllInactiveModules() {
		// TODO Auto-generated method stub
		logger.debug("Entering getAllInActiveQuestions ");
		List<Object> modules = moduleRepo.findByModuleIsActiveFalse();

		logger.info("In active modules : " + modules);
		return modules;
	}

	//GET UPDATE DELETE MODULE BY ID
	@Override
	public int deleteModuleBymoduleId(int moduleId) {
		// TODO Auto-generated method stub
		logger.debug("Entering deleteModuleByName");

		int count = moduleRepo.deleteModuleById(moduleId);
		logger.info("deleted Module count : " + count);
		return count;
	}

	
	//UPDATE MODULE BY MODULE ID
	@Override
	public Module updateModuleBymoduleId(Module module, int moduleId) {
		// TODO Auto-generated method stub
		logger.debug("Entering updateModule");

		Module toUpdatedModule = null;
		Module updatedModule = null;

		toUpdatedModule = moduleRepo.findById(moduleId);
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
			toUpdatedModule.setModuleReview(module.getModuleReview());
			

			updatedModule = moduleRepo.save(toUpdatedModule);

			logger.info("updated Module :" + updatedModule);
		}

		return updatedModule;
	}



	//GET MODULE ASSIGN COURSES BY PROFILE ID
	@Override
	public List<Object> getModulesOfAssignedCoursesByProfileId(int profileId) {
		logger.debug("Entering getAllModules");

		List<Module> modules = moduleRepo.getModulesOfAssignedCoursesByProfileId(profileId);
		List<Object> objectModules = new ArrayList<>(modules);
		logger.info("Fetched all active module :" + modules);
		return objectModules;
	}

	// GET MODULES ENROLLED COURSES BY PROFILE ID
	@Override
	public List<Object> getModulesOfEnrolledCoursesByProfileId(int profileId) {
		logger.debug("Entering getAllModules");

		List<Module> modules = moduleRepo.getModulesOfEnrolledCoursesByProfileId(profileId);
		List<Object> objectModules = new ArrayList<>(modules);
		logger.info("Fetched all active module :" + modules);
		return objectModules;
	}

	
	//ACTIVATE MOUDLE BY ID
	@Override
	public Object updateActiveStatusByModuleId(int moduleid) {
		// TODO Auto-generated method stub
				System.out.println(moduleid);
				logger.debug("Entering getInActiveQuestions ");
				List<Object> modules = getAllInactiveModules();

				if (modules.size() >= 1) {
					Object object = moduleRepo.findById(moduleid);

					System.out.println("Entered  instanceof loop");
					Module module = (Module) object;

					module.setModuleIsActive(true);

					logger.info("question object" + object);
					return moduleRepo.save(module);
				}

				return null;
	}

}
