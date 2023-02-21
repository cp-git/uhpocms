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

	ModuleFile getModuleFileByFile(String file);

	List<Object> getAllModuleFiles();

	ModuleFile updateModuleFileByFile(ModuleFile modulefile, String file);

	int deleteModuleFileByFile(String file);

}