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

	/**
	 * @param : ModuleFileProgress modulefileprogress
	 * @return : ModuleFileProgress createdModuleFileProgress
	 * @description : For creating/inserting entry in teacher_studentmodulefileprogress table
	 */
	@Override
	public ModuleFileProgress createModuleFileProgress(ModuleFileProgress modulefileprogress) {
		logger.debug("Entering createModuleFileProgress");
		ModuleFileProgress createdModuleFileProgress = null;

	//	modulefileprogress.setModuleFileProgressCreatedBy("admin");
	//	modulefileprogress.setModuleFileProgressModifiedBy("admin");

		createdModuleFileProgress = modulefileprogressRepo.save(modulefileprogress);
		logger.info("created ModuleFileProgress :" + createdModuleFileProgress);
		return createdModuleFileProgress;
	}

	/**
	 * @param : String id
	 * @return : ModuleFileProgress modulefileprogress
	 * @description : For get entry in teacher_studentmodulefileprogress table
	 */
	@Override
	public ModuleFileProgress getModuleFileProgressByid(int id) {
		logger.debug("Entering getModuleFileProgressByid");

		ModuleFileProgress modulefileprogress = modulefileprogressRepo.findById(id);
		logger.info("Founded modulefileprogress :" + modulefileprogress);

		return modulefileprogress;
	}

	/**
	 * @return : List<Object> modulefileprogress
	 * @description : For fetching all modulefileprogress which are active state from teacher_studentmodulefileprogress table
	 */
	@Override
	public List<Object> getAllModuleFileProgresss() {
		logger.debug("Entering getAllModuleFileProgresss");

		List<Object> objectModuleFileProgresss = null;
		List<ModuleFileProgress> modulefileprogresss = modulefileprogressRepo.findAll();
		logger.info("Fetched all active modulefileprogress :" + modulefileprogresss);
		objectModuleFileProgresss = new ArrayList<Object>(modulefileprogresss);
		return objectModuleFileProgresss;
	}

	/**
	 * @param : ModuleFileProgress to update
	 * @return : modulefileprogress
	 * @description : For updating modulefileprogress of teacher_studentmodulefileprogress table
	 */
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
			toUpdatedModuleFileProgress.setFileId(modulefileprogress.getFileId());
			toUpdatedModuleFileProgress.setFileCompleted(modulefileprogress.isFileCompleted());
			toUpdatedModuleFileProgress.setModuleId(modulefileprogress.getModuleId());
			toUpdatedModuleFileProgress.setStudentId(modulefileprogress.getStudentId());
			
			
			updatedModuleFileProgress = modulefileprogressRepo.save(toUpdatedModuleFileProgress);

			logger.info("updated ModuleFileProgress :" + updatedModuleFileProgress);
		}

		return updatedModuleFileProgress;
	}

	/**
	 * @param : String id
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of ModuleFileProgress
	 * 
	 */
	@Override
	public int deleteModuleFileProgressByid(int id) {
		logger.debug("Entering deleteModuleFileProgressByid");

		int count =  modulefileprogressRepo.deleteById(id);
		logger.info("deleted ModuleFileProgress count : " + count);
		return count;
	}

}
