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

	//CREATE MODULE PROGRESS
	@Override
	public ModuleProgress createModuleProgress(ModuleProgress moduleprogress) {
		logger.debug("Entering createModuleProgress");
		System.out.println(moduleprogress);
		ModuleProgress createdModuleProgress = null;

	//	moduleprogress.setModuleProgressCreatedBy("admin");
	//	moduleprogress.setModuleProgressModifiedBy("admin");

	
		
		
		ModuleProgress newmoduleprogress = moduleprogressRepo.findByModuleId_StudId(moduleprogress.getModuleId(), moduleprogress.getStudentId());
		
		System.out.println(newmoduleprogress);
		if(newmoduleprogress == null)
		{
			System.out.println("Entered if loop in create method");
			createdModuleProgress = moduleprogressRepo.save(moduleprogress);
			logger.info("created ModuleProgress :" + createdModuleProgress);
			return createdModuleProgress;
					
		}
		
		
		return null;
		
		
		
	}

	
	//GET MODULE PROGRESS BY MODULE ID AND STUDENT ID
	@Override
	public ModuleProgress getModuleProgressBymodstudId(int modId, int studId) {
		logger.debug("Entering getModuleProgressBymodstudId");

		ModuleProgress moduleprogress = moduleprogressRepo.findByModuleId_StudId(modId, studId);
		logger.info("Founded moduleprogress :" + moduleprogress);

		return moduleprogress;
	}

	
	
	//GET MODULE PROGRESS BY ID
	@Override
	public ModuleProgress getModuleProgressByid(int id) {
		logger.debug("Entering getModuleProgressByid");

		ModuleProgress moduleprogress = moduleprogressRepo.findById(id);
		logger.info("Founded moduleprogress :" + moduleprogress);

		return moduleprogress;
	}


	
	//UDPATE MODULE PROGRESS BY ID
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
			updatedModuleProgress.setCourseId(moduleprogress.getCourseId());
			updatedModuleProgress.setModuleId(moduleprogress.getModuleId());
			updatedModuleProgress.setStudentId(moduleprogress.getStudentId());
			updatedModuleProgress.setProgress(moduleprogress.getProgress());;
			
			toUpdatedModuleProgress = moduleprogressRepo.save(updatedModuleProgress);

			logger.info("updated ModuleProgress :" + updatedModuleProgress);
		}

		return toUpdatedModuleProgress;
	}

	
	
	//GET ALL MODULE PROGRESS
	@Override
	public List<Object> getAllModuleProgresssByCourseIdAndStudentId(int courseId, int studentId) {
		logger.debug("Entering getAllModuleProgresssByCourseIdAndProfileId");

		List<Object> objectModuleProgresss = null;
		List<ModuleProgress> moduleProgresses = moduleprogressRepo.findByCourseIdAndStudentId(courseId, studentId);
		logger.info("Fetched all moduleprogress :" + moduleProgresses);
		objectModuleProgresss = new ArrayList<Object>(moduleProgresses);
		return objectModuleProgresss;
	}

}
