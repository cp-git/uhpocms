/**
 * @author  - Code Generator
 * @createdOn -  04-04-2023
 * @Description Entity class for ModuleFileProgress Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.ModuleFileProgress;

public interface ModuleFileProgressService {

	//INSERT MODULE FILE PROGRESS
	ModuleFileProgress createModuleFileProgress(ModuleFileProgress modulefileprogress);

	//GET MODULE FILE PROGRESS BY ID
	ModuleFileProgress getModuleFileProgressByid(int id);

	//GET ALL ACTIVE MODULE FILE
	List<Object> getAllModuleFileProgresss();

	//UPDATE THE MODULE FILE PROGRESS BY ID
	ModuleFileProgress updateModuleFileProgressByid(ModuleFileProgress modulefileprogress, int id);


	//GET LIST OF MODULE FILE PROGRESS BY MODULE ID AND STUDENT ID
	public List<Object> getModuleFileProgressByModStudProg(int modId, int studId);

	//GET LIST GET MODULE FILE PROGRESS  MODULE ID AND STUDENT ID
	public List<Object> getModuleFileProgressByModStudId(int modId, int studId);

	//UPDATE MODULE FILE PROGRESS BY FILE ID AND STUDENT ID
	ModuleFileProgress updateFileProgressByFileIdAndStudentId(int moduleFileId, int studentId,
			ModuleFileProgress modulefileprogress);
	//UPDATE MODULE FILE PROGRESS BY FILE ID AND STUDENT ID
	ModuleFileProgress getFileProgressByFileIdAndStudentId(int moduleFileId, int studentId);

}