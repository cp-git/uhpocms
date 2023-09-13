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

	//CREATE  MODULE FILE
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

	

	//GET LIST OF MODULE FILE BY MODULE ID
	@Override
	public List<Object> getModuleFileByModuleId(int id) {
		logger.debug("Entering getModuleFileByModuleId");

		List<Object> modulesfiles = null;

		List<Object> files = modulefileRepo.findByModuleId(id);

		modulesfiles = new ArrayList<Object>(files);

		logger.info("Fetched all module files :" + modulesfiles);
		return modulesfiles;
	}

	
	//GET ALL MODULE FILE
	@Override
	public List<Object> getAllModuleFiles() {
		logger.debug("Entering getAllModuleFiles");

		List<Object> modulefiles = modulefileRepo.findByModuleFileIsActiveTrue();
		logger.info("Fetched all active modulefile :" + modulefiles);
		return modulefiles;
	}

	
	
	// GET LIST OF MODULE FILE USING STUDENT ID
	@Override
	public List<Object> getModuleFileByStudentId(int studentId) {

		logger.debug("Entering getModuleFileByStudentId");
		List<ModuleFile> moduleFiles = modulefileRepo.findModuleFileByStudentId(studentId);
		List<Object> objectModulefiles = new ArrayList<>(moduleFiles);
		logger.info("Fetched all modulefile of student id " + studentId + " : " + objectModulefiles);
		return objectModulefiles;
	}


	// UPDATE THE MODULE BY ID
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

	//INACTIVE MODUILE FILE
	@Override
	public List<Object> getAllInactiveModuleFiles() {
		// TODO Auto-generated method stub
		logger.debug("Entering getAllModuleFiles");

		List<Object> modulefiles = modulefileRepo.findByModuleFileIsActiveFalse();
		logger.info("Fetched all active modulefile :" + modulefiles);
		return modulefiles;
	}

	
	//ACTIVATE MODULE FILE BY ID
	 @Transactional
	public int activateModuleFileBymoduleFileId(int id) {
		// TODO Auto-generated method stub
		logger.debug("Entering activate ModuleFile By moduleFileId");

		int count = modulefileRepo.activateModuleFileByModuleFileId(id);
		 modulefileRepo.updateIsActiveInTeacherModule(id);
		logger.info("activated module file count : " + count);
		return count;
	}

	 //GET MODULE FILE BY TEACHER ID
	@Override
	public List<Object> getModuleFilesByTeacherId(int teacherId) {

		logger.debug("Entering getModuleFileByTeacherId");
		List<ModuleFile> moduleFiles = modulefileRepo.findModuleFilesByTeacherId(teacherId);
		List<Object> objectModulefiles = new ArrayList<>(moduleFiles);
		logger.info("Fetched all modulefile of teacher id " + teacherId + " : " + objectModulefiles);
		return objectModulefiles;
	}

	//GET MODULE FILE BY ID
	public ModuleFile getModuleFileById(int id) {
		// TODO Auto-generated method stub
		return modulefileRepo.findByModuleFileId(id);
	}

	//DELETE MODULE FILE BY ID
	 @Transactional
	    public int deleteTeacherModuleFileAndModule(int id) {
		int count= modulefileRepo.deleteModuleFileByModuleFileId(id);
		 modulefileRepo.updateIsActiveInTeacherModule(id);
		 return count;
	    }

}