/**
 * @author - Code Generator
 * @createdOn 04-04-2023
 * @Description Controller class for moduleprogress
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.ModuleProgressController;
import com.cpa.uhpocms.entity.ModuleProgress;
import com.cpa.uhpocms.repository.ModuleProgressRepo;
import com.cpa.uhpocms.service.ModuleProgressService;

@Service
public class ModuleProgressServiceImpl implements ModuleProgressService {

	@Autowired
	private ModuleProgressRepo moduleprogressRepo;
	private static Logger logger;

	public ModuleProgressServiceImpl() {
		logger = Logger.getLogger(ModuleProgressServiceImpl.class);
	}

	/**
	 * @param : ModuleProgress moduleprogress
	 * @return : ModuleProgress createdModuleProgress
	 * @description : For creating/inserting entry in Teacher_studentmoduleprogress table
	 */
	@Override
	public ModuleProgress createModuleProgress(ModuleProgress moduleprogress) {
		logger.debug("Entering createModuleProgress");
		ModuleProgress createdModuleProgress = null;

	//	moduleprogress.setModuleProgressCreatedBy("admin");
	//	moduleprogress.setModuleProgressModifiedBy("admin");

		createdModuleProgress = moduleprogressRepo.save(moduleprogress);
		logger.info("created ModuleProgress :" + createdModuleProgress);
		return createdModuleProgress;
	}

	/**
	 * @param : String id
	 * @return : ModuleProgress moduleprogress
	 * @description : For get entry in Teacher_studentmoduleprogress table
	 */
	@Override
	public ModuleProgress getModuleProgressByid(int id) {
		logger.debug("Entering getModuleProgressByid");

		ModuleProgress moduleprogress = moduleprogressRepo.findById(id);
		logger.info("Founded moduleprogress :" + moduleprogress);

		return moduleprogress;
	}

	/**
	 * @return : List<Object> moduleprogress
	 * @description : For fetching all moduleprogress which are active state from Teacher_studentmoduleprogress table
	 */
	@Override
	public List<Object> getAllModuleProgresss() {
		logger.debug("Entering getAllModuleProgresss");

		List<Object> objectModuleProgresss = null;
		List<ModuleProgress> moduleProgresses  = moduleprogressRepo.findAll();
		logger.info("Fetched all active moduleprogress :" + moduleProgresses);
		objectModuleProgresss = new ArrayList<Object>(moduleProgresses);
		return objectModuleProgresss;
	}

	/**
	 * @param : ModuleProgress to update
	 * @return : moduleprogress
	 * @description : For updating moduleprogress of Teacher_studentmoduleprogress table
	 */
	@Override
	public ModuleProgress updateModuleProgressByid(ModuleProgress moduleprogress, int id) {
		logger.debug("Entering updateModuleProgress");

		ModuleProgress toUpdatedModuleProgress = null;
		ModuleProgress updatedModuleProgress = null;

		updatedModuleProgress = moduleprogressRepo.findById(id);
		logger.info("exisitng ModuleProgress :: " + toUpdatedModuleProgress);

		if (updatedModuleProgress != null) {
			logger.debug("setting new data of ModuleProgress to exisitng ModuleProgress");

//			moduleprogress.setModifiedBy("admin");
			updatedModuleProgress.setCurrentFileNo(moduleprogress.getCurrentFileNo());	
			updatedModuleProgress.setCurrentquizno(moduleprogress.getCurrentquizno());
			updatedModuleProgress.setModuleId(moduleprogress.getModuleId());
			updatedModuleProgress.setStudentId(moduleprogress.getStudentId());
			
			
			toUpdatedModuleProgress = moduleprogressRepo.save(updatedModuleProgress);

			logger.info("updated ModuleProgress :" + updatedModuleProgress);
		}

		return toUpdatedModuleProgress;
	}

	/**
	 * @param : String id
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of ModuleProgress
	 * 
	 */
	@Override
	public int deleteModuleProgressByid(int id) {
		logger.debug("Entering deleteModuleProgressByid");

		int count =  moduleprogressRepo.deleteById(id);
		logger.info("deleted ModuleProgress count : " + count);
		return count;
	}

}
