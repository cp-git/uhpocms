/**
 * @author - Code Generator
 * @createdOn 04-04-2023
 * @Description Controller class for modulefileprogress
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.ModuleFileProgressController;
import com.cpa.uhpocms.entity.ModuleFileProgress;
import com.cpa.uhpocms.repository.ModuleFileProgressRepo;
import com.cpa.uhpocms.service.ModuleFileProgressService;

@Service
public class ModuleFileProgressServiceImpl implements ModuleFileProgressService {

	@Autowired
	private ModuleFileProgressRepo modulefileprogressRepo;
	private static Logger logger;

	public ModuleFileProgressServiceImpl() {
		logger = Logger.getLogger(ModuleFileProgressServiceImpl.class);
	}

	
	//CREATE THE MODULE FILE PROGRESS
	@Override
	public ModuleFileProgress createModuleFileProgress(ModuleFileProgress modulefileprogress) {
		logger.debug("Entering createModuleFileProgress");
		ModuleFileProgress createdModuleFileProgress = null;

		ModuleFileProgress newmodulefileprogress = modulefileprogressRepo
				.findByFileId_StudId(modulefileprogress.getFileId(), modulefileprogress.getStudentId());

		System.out.println(newmodulefileprogress);
		if (newmodulefileprogress == null) {
			System.out.println("Entered if loop in create method");
			createdModuleFileProgress = modulefileprogressRepo.save(modulefileprogress);
			logger.info("created ModuleProgress :" + createdModuleFileProgress);
			return createdModuleFileProgress;

		}

		return null;

	}

	
	//GET MODULE FILE PROGRESS BY ID 
	@Override
	public ModuleFileProgress getModuleFileProgressByid(int id) {
		logger.debug("Entering getModuleFileProgressByid");

		ModuleFileProgress modulefileprogress = modulefileprogressRepo.findById(id);
		logger.info("Founded modulefileprogress :" + modulefileprogress);

		return modulefileprogress;
	}

	
	//GET LIST OF MODULE FILES USING MODULE ID AND STUDENT ID
	@Override
	public List<Object> getModuleFileProgressByModStudProg(int modId, int studId) {
		logger.debug("Entering getModuleFileProgressByModStudProg");

		List<Object> objectModuleFileProgresss = null;
		List<ModuleFileProgress> modulefileprogresss = modulefileprogressRepo.findByModId_StudId_Prog(modId, studId);
		logger.info("Fetched all active modulefileprogress :" + modulefileprogresss);
		objectModuleFileProgresss = new ArrayList<Object>(modulefileprogresss);
		return objectModuleFileProgresss;
	}

	
	//GET MODULE FILE PROGRESS MODULE ID AND STUDENT ID
	@Override
	public List<Object> getModuleFileProgressByModStudId(int modId, int studId) {
		logger.debug("Entering getModuleFileProgressByModStudProg");

		List<Object> objectModuleFileProgresss = null;
		List<ModuleFileProgress> modulefileprogresss = modulefileprogressRepo.findByModId_StudId(modId, studId);
		logger.info("Fetched all active modulefileprogress :" + modulefileprogresss);
		objectModuleFileProgresss = new ArrayList<Object>(modulefileprogresss);
		return objectModuleFileProgresss;
	}

	
	//GET ALL MODULE FILE PROGRESS
	@Override
	public List<Object> getAllModuleFileProgresss() {
		logger.debug("Entering getAllModuleFileProgresss");

		List<Object> objectModuleFileProgresss = null;
		List<ModuleFileProgress> modulefileprogresss = modulefileprogressRepo.findAll();
		logger.info("Fetched all active modulefileprogress :" + modulefileprogresss);
		objectModuleFileProgresss = new ArrayList<Object>(modulefileprogresss);
		return objectModuleFileProgresss;
	}


	//UPDATE THE MODULE FILE PROGRESS BY ID
	@Override
	public ModuleFileProgress updateModuleFileProgressByid(ModuleFileProgress modulefileprogress, int id) {
		logger.debug("Entering updateModuleFileProgress");

		ModuleFileProgress toUpdatedModuleFileProgress = null;
		ModuleFileProgress updatedModuleFileProgress = null;

		toUpdatedModuleFileProgress = modulefileprogressRepo.findById(id);
		logger.info("exisitng ModuleFileProgress :: " + toUpdatedModuleFileProgress);

		if (toUpdatedModuleFileProgress != null) {
			logger.debug("setting new data of ModuleFileProgress to exisitng ModuleFileProgress");

//			modulefileprogress.setModifiedBy("admin");

			toUpdatedModuleFileProgress.setCurrentFilePageNo(modulefileprogress.getCurrentFilePageNo());

			toUpdatedModuleFileProgress.setProgress(modulefileprogress.getProgress());

			updatedModuleFileProgress = modulefileprogressRepo.save(toUpdatedModuleFileProgress);

			logger.info("updated ModuleFileProgress :" + updatedModuleFileProgress);
		}

		return updatedModuleFileProgress;
	}


	
	//UPDATE MODULE FILE PROGRESS BY FILE AND STUDENT ID
	@Override
	public ModuleFileProgress updateFileProgressByFileIdAndStudentId(int moduleFileId, int studentId,
			ModuleFileProgress modulefileprogress) {
		logger.debug("Entering updateFileProgressByFileIdAndStudentId");
		ModuleFileProgress toUpdatedModuleFileProgress = null;
		ModuleFileProgress updatedModuleFileProgress = null;
		toUpdatedModuleFileProgress = modulefileprogressRepo.findByFileIdAndStudentId(moduleFileId, studentId);
		logger.info("exisitng ModuleFileProgress :: " + toUpdatedModuleFileProgress);
		if (toUpdatedModuleFileProgress != null) {
			logger.debug("setting new data of ModuleFileProgress to exisitng ModuleFileProgress");
//			modulefileprogress.setModifiedBy("admin");
			toUpdatedModuleFileProgress.setCurrentFilePageNo(modulefileprogress.getCurrentFilePageNo());
			if (modulefileprogress.getProgress() > toUpdatedModuleFileProgress.getProgress()) {
				toUpdatedModuleFileProgress.setProgress(modulefileprogress.getProgress());
			}

			if (modulefileprogress.getCurrentFilePageNo() > toUpdatedModuleFileProgress.getCurrentFilePageNo()) {
				toUpdatedModuleFileProgress.setCurrentFilePageNo(modulefileprogress.getCurrentFilePageNo());
			}

			updatedModuleFileProgress = modulefileprogressRepo.save(toUpdatedModuleFileProgress);
			logger.info("updated ModuleFileProgress :" + updatedModuleFileProgress);
		} else {
			updatedModuleFileProgress = modulefileprogressRepo.save(modulefileprogress);
		}
		return updatedModuleFileProgress;
	}


	//UPDATE MODULE FILE PROGRESS BY FILE AND STUDENT ID
	@Override
	public ModuleFileProgress getFileProgressByFileIdAndStudentId(int moduleFileId, int studentId) {
		logger.debug("Entering getFileProgressByFileIdAndStudentId");

		ModuleFileProgress moduleFileProgress = null;
		moduleFileProgress = modulefileprogressRepo.findByFileIdAndStudentId(moduleFileId, studentId);
		logger.info("Fetched modulefileprogress :" + moduleFileProgress);

		return moduleFileProgress;
	}
}
