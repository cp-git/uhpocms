/**
 * @author - Code Generator
 * @createdOn 13-02-2023
 * @Description Controller class for modulefile
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cpa.uhpocms.controller.ModuleFileController;
import com.cpa.uhpocms.entity.ModuleFile;
import com.cpa.uhpocms.repository.ModuleFileRepo;
import com.cpa.uhpocms.service.ModuleFileService;

@Service
public class ModuleFileServiceImpl implements ModuleFileService {

	@Autowired
	private ModuleFileRepo modulefileRepo;
	private static Logger logger;

	public ModuleFileServiceImpl() {
		logger = Logger.getLogger(ModuleFileServiceImpl.class);
	}

	/**
	 * @param : ModuleFile modulefile
	 * @return : ModuleFile createdModuleFile
	 * @description : For creating/inserting entry in teacher_modulefile table
	 */
	@Override
	public ModuleFile createModuleFile(ModuleFile modulefile) {
		logger.debug("Entering createModuleFile");
		ModuleFile createdModuleFile = null;

		modulefile.setModuleFileCreatedBy("admin");
		modulefile.setModuleFileUpdatedBy("admin");

		createdModuleFile = modulefileRepo.save(modulefile);
		logger.info("created ModuleFile :" + createdModuleFile);
		return createdModuleFile;
	}

	/**
	 * @param : String file
	 * @return : ModuleFile modulefile
	 * @description : For get entry in teacher_modulefile table
	 */
	@Override
	public ModuleFile getModuleFileByFile(String file) {
		logger.debug("Entering getModuleFileByFile");

		ModuleFile modulefile = modulefileRepo.findByModuleFile(file);
		logger.info("Founded modulefile :" + modulefile);

		return modulefile;
	}

	/**
	 * @return : List<Object> modulefile
	 * @description : For fetching all modulefile which are active state from
	 *              teacher_modulefile table
	 */
	@Override
	public List<Object> getAllModuleFiles() {
		logger.debug("Entering getAllModuleFiles");

		List<Object> modulefiles = modulefileRepo.findByModuleFileIsActiveTrue();
		logger.info("Fetched all active modulefile :" + modulefiles);
		return modulefiles;
	}

	/**
	 * @param : ModuleFile to update
	 * @return : modulefile
	 * @description : For updating modulefile of teacher_modulefile table
	 */
	@Override
	public ModuleFile updateModuleFileByFile(ModuleFile modulefile, String file) {
		logger.debug("Entering updateModuleFile");

		ModuleFile toUpdatedModuleFile = null;
		ModuleFile updatedModuleFile = null;

		toUpdatedModuleFile = modulefileRepo.findByModuleFile(file);
		logger.info("exisitng ModuleFile :: " + toUpdatedModuleFile);

		if (toUpdatedModuleFile != null) {
			logger.debug("setting new data of ModuleFile to exisitng ModuleFile");

			toUpdatedModuleFile.setModuleFile(modulefile.getModuleFile());
			toUpdatedModuleFile.setModuleFileOrderNo(modulefile.getModuleFileOrderNo());
			toUpdatedModuleFile.setModuleFileIsActive(modulefile.isModuleFileIsActive());
			toUpdatedModuleFile.setModuleId(modulefile.getModuleId());

			updatedModuleFile = modulefileRepo.save(toUpdatedModuleFile);

			logger.info("updated ModuleFile :" + updatedModuleFile);
		}

		return updatedModuleFile;
	}

	/**
	 * @param : String file
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of
	 *              ModuleFile
	 * 
	 */
	@Override
	public int deleteModuleFileByFile(String file) {
		logger.debug("Entering deleteModuleFileByFile");

		int count = modulefileRepo.deleteModuleFileByFile(file);
		logger.info("deleted ModuleFile count : " + count);
		return count;
	}

}