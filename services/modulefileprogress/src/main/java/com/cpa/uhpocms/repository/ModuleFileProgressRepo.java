/**
 * @author  - Code Generator
 * @createdOn -  04-04-2023
 * @Description Entity class for ModuleFileProgress
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.ModuleFileProgress;

@Repository
public interface ModuleFileProgressRepo extends JpaRepository<ModuleFileProgress, Integer> {

	public ModuleFileProgress findById(int id);


	@Transactional
	@Modifying
	@Query(value = "DELETE from teacher_studentmodulefileprogress WHERE id = ?1", nativeQuery = true)
	public int deleteById(int id);

}