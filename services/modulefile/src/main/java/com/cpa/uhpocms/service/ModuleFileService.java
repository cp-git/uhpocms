/**
 * @author  - Code Generator
 * @createdOn -  13-02-2023
 * @Description Entity class for ModuleFile Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.ModuleFile;

public interface ModuleFileService {

	ModuleFile createModuleFile(ModuleFile modulefile);

	
	//GET ALL MODULE FILE
	List<Object> getAllModuleFiles();

	
	// GET LIST OF MODULE FILE USING STUDENT ID
	List<Object> getModuleFileByStudentId(int studentId);

	//GET LIST OF MODULE FILE BY MODULE ID
	public List<Object> getModuleFileByModuleId(int id);

	//UPDATE MODULE FILE BY ID
	ModuleFile updateModuleFileBymoduleFileId(ModuleFile modulefile, int id);

	//GET ALL INACTIVE MODULE FILE
	List<Object> getAllInactiveModuleFiles();

	//ACTIVATE MOFIULE FILE BY ID
	int activateModuleFileBymoduleFileId(int id);

	//GET MODULE FILE BY ID
	ModuleFile getModuleFileById(int id);

	//GET MODULE FILE BY TEACHER ID
	List<Object> getModuleFilesByTeacherId(int teacherId);

	//DELETE MODULE FILE BY ID
	int deleteTeacherModuleFileAndModule(int id);

}