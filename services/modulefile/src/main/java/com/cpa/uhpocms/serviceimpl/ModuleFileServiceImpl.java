/**
 * @author - Code Generator
 * @createdOn 13-02-2023
 * @Description Controller class for modulefile
 * 
 */

package com.cpa.uhpocms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

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
	 * @author shradha
	 * 
	 */
	@Override
	public List<Object> getModuleFileByModuleId(int id) {
		logger.debug("Entering getModuleFileByModuleId");

		List<Object> modulesfiles = null;

		List<Object> files = modulefileRepo.findByModuleId(id);

		modulesfiles = new ArrayList<Object>(files);

		logger.info("Fetched all module files :" + modulesfiles);
		return modulesfiles;
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
	// @Override
	// public ModuleFile updateModuleFileByFile(ModuleFile modulefile, String file)
	// {
	// logger.debug("Entering updateModuleFile");
	//
	// ModuleFile toUpdatedModuleFile = null;
	// ModuleFile updatedModuleFile = null;
	//
	// toUpdatedModuleFile = modulefileRepo.findByModuleFile(file);
	// logger.info("exisitng ModuleFile :: " + toUpdatedModuleFile);
	//
	// if (toUpdatedModuleFile != null) {
	// logger.debug("setting new data of ModuleFile to exisitng ModuleFile");
	//
	// toUpdatedModuleFile.setModuleFile(modulefile.getModuleFile());
	// toUpdatedModuleFile.setModuleFileOrderNo(modulefile.getModuleFileOrderNo());
	// toUpdatedModuleFile.setModuleFileIsActive(modulefile.isModuleFileIsActive());
	// toUpdatedModuleFile.setModuleId(modulefile.getModuleId());
	//
	// updatedModuleFile = modulefileRepo.save(toUpdatedModuleFile);
	//
	// logger.info("updated ModuleFile :" + updatedModuleFile);
	// }
	//
	// return updatedModuleFile;
	// }

	/**
	 * @param : String file
	 * @return : int (count of record updated)
	 * @description : This is function is used to soft delete the record of
	 *              ModuleFile
	 * 
	 */
	// @Override
	// public int deleteModuleFileByFile(String file) {
	// logger.debug("Entering deleteModuleFileByFile");
	//
	// int count = modulefileRepo.deleteModuleFileByFile(file);
	// logger.info("deleted ModuleFile count : " + count);
	// return count;
	// }

	@Override
	public List<Object> getModuleFileByStudentId(int studentId) {

		logger.debug("Entering getModuleFileByStudentId");
		List<ModuleFile> moduleFiles = modulefileRepo.findModuleFileByStudentId(studentId);
		List<Object> objectModulefiles = new ArrayList<>(moduleFiles);
		logger.info("Fetched all modulefile of student id " + studentId + " : " + objectModulefiles);
		return objectModulefiles;
	}

//	@Override
//	public int deleteModuleFileBymoduleFileId(int id) {
//		// TODO Auto-generated method stub
//
//		logger.debug("Entering deleteModuleFileByModuleFileId");
//
//		int count = modulefileRepo.deleteModuleFileByModuleFileId(id);
//		logger.info("deleted ModuleFile count : " + count);
//		return count;
//	}

	@Override
	public ModuleFile updateModuleFileBymoduleFileId(ModuleFile modulefile, int moduleFileId) {
		// TODO Auto-generated method stub
		logger.debug("InSaveInstituteAdmin...");
		ModuleFile moduleFile = modulefileRepo.findByModuleFileId(moduleFileId);
		logger.info("The Update Method is..." + moduleFile);
		moduleFile.setModuleFile(modulefile.getModuleFile());
		moduleFile.setModuleFileOrderNo(modulefile.getModuleFileOrderNo());
		moduleFile.setModuleFileIsActive(modulefile.isModuleFileIsActive());
		moduleFile.setModuleId(modulefile.getModuleId());

		modulefileRepo.save(moduleFile);

		System.out.println(modulefile);
		return moduleFile;

	}

	@Override
	public List<Object> getAllInactiveModuleFiles() {
		// TODO Auto-generated method stub
		logger.debug("Entering getAllModuleFiles");

		List<Object> modulefiles = modulefileRepo.findByModuleFileIsActiveFalse();
		logger.info("Fetched all active modulefile :" + modulefiles);
		return modulefiles;
	}

	 @Transactional
	public int activateModuleFileBymoduleFileId(int id) {
		// TODO Auto-generated method stub
		logger.debug("Entering activate ModuleFile By moduleFileId");

		int count = modulefileRepo.activateModuleFileByModuleFileId(id);
		 modulefileRepo.updateIsActiveInTeacherModule(id);
		logger.info("activated module file count : " + count);
		return count;
	}

	@Override
	public List<Object> getModuleFilesByTeacherId(int teacherId) {

		logger.debug("Entering getModuleFileByTeacherId");
		List<ModuleFile> moduleFiles = modulefileRepo.findModuleFilesByTeacherId(teacherId);
		List<Object> objectModulefiles = new ArrayList<>(moduleFiles);
		logger.info("Fetched all modulefile of teacher id " + teacherId + " : " + objectModulefiles);
		return objectModulefiles;
	}

	public ModuleFile getModuleFileById(int id) {
		// TODO Auto-generated method stub
		return modulefileRepo.findByModuleFileId(id);
	}

	 @Transactional
	    public int deleteTeacherModuleFileAndModule(int id) {
		int count= modulefileRepo.deleteModuleFileByModuleFileId(id);
		 modulefileRepo.updateIsActiveInTeacherModule(id);
		 return count;
	    }

}