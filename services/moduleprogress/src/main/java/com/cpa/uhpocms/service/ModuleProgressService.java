/**
 * @author  - Code Generator
 * @createdOn -  04-04-2023
 * @Description Entity class for ModuleProgress Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.ModuleProgress;

public interface ModuleProgressService {

	//INSERT MODULE PROGRESS
	ModuleProgress createModuleProgress(ModuleProgress moduleprogress);

	//GET MODULE PROGRESS BY ID
	ModuleProgress getModuleProgressByid(int id);
	
	//GET MODULE PROGRESS MODULE ID AND STUDENT ID
    ModuleProgress getModuleProgressBymodstudId(int modId, int studId);

	
    // UPDATE MODULE PROGRESS ID 
	ModuleProgress updateModuleProgressByid(ModuleProgress moduleprogress, int id);

	
	
	//GET ALL MODULE PROGRESS
	List<Object> getAllModuleProgresssByCourseIdAndStudentId(int courseId, int studentId);
	
}