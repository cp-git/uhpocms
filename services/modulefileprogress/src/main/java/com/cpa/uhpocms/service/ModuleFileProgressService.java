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

	ModuleFileProgress createModuleFileProgress(ModuleFileProgress modulefileprogress);

	ModuleFileProgress getModuleFileProgressByid(int id);

	List<Object> getAllModuleFileProgresss();

	ModuleFileProgress updateModuleFileProgressByid(ModuleFileProgress modulefileprogress, int id);

	int deleteModuleFileProgressByid(int id);

	public List<Object> getModuleFileProgressByModStudProg(int modId, int studId);

	public List<Object> getModuleFileProgressByModStudId(int modId, int studId);

	ModuleFileProgress updateFileProgressByFileIdAndStudentId(int moduleFileId, int studentId,
			ModuleFileProgress modulefileprogress);

}