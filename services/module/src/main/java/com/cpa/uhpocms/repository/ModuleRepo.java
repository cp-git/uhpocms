/**
 * @author  - Code Generator
 * @createdOn -  08-12-2022
 * @Description- Repository interface for Module
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.Module;

@Repository
public interface ModuleRepo extends JpaRepository<Module, Integer> {

	public Module findByModuleName(String name);
	
	public Module findById(int moduleId);

	public List<Object> findByModuleIsActiveTrue();

	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_module SET isactive=false WHERE name = ?1", nativeQuery = true)
	public int deleteModuleByName(String name);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_module SET isactive=false WHERE moduleid = ?1", nativeQuery = true)
	public int deleteModuleById(int moduleId);

	public List<Object> findByCourseIdAndModuleIsActive(int courseId,boolean isActive);

	
	/*
	 * @author:Shradha
	 * @createdOn: 10 Feb 2023
	 * 
	 */
	public List<Object> findByModuleIsActiveFalse();
	
	
	
	

}
