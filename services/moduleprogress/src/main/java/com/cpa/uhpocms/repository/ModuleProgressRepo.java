/**
 * @author  - Code Generator
 * @createdOn -  04-04-2023
 * @Description Entity class for ModuleProgress
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.ModuleProgress;

@Repository
public interface ModuleProgressRepo extends JpaRepository<ModuleProgress, Integer> {

	public ModuleProgress findById(int id);
	
	public ModuleProgress findByModuleId(int moduleId);

	public List<ModuleProgress> findByCourseId(int courseId);

//	@Query(value = "UPDATE Teacher_studentmoduleprogress SET is_active=false WHERE id = ?1", nativeQuery = true)
//	public int deleteModuleProgressByid(String id);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE from teacher_studentmoduleprogress WHERE id= ?1", nativeQuery = true)
	public int deleteById(int id);
	
	
	/**
	 * @author shradha
	 * @param modId
	 * @param studId
	 * @return
	 */
	@Query(value = " SELECT * from teacher_studentmoduleprogress as p WHERE p.moduleid_id= ?1 and p.studentid_id = ?2", nativeQuery = true)
	public ModuleProgress  findByModuleId_StudId(int modId,int studId);
	
	public List<ModuleProgress> findByCourseIdAndStudentId(int courseId, int studentId);
	
	
}
