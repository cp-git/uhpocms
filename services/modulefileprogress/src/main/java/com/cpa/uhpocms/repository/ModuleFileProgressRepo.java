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

	//FIND MODULE FILE  PROGRESS BY ID
	public ModuleFileProgress findById(int id);

	//GET MODULE FILE PROGRESS BY FILE ID
	public ModuleFileProgress findByFileId(int fileId);

	//GET MODULE FILE STUDENT ID
	public List<ModuleFileProgress> findByStudentId(int studId);

	
	//DELETE MODULE FILE PROGRESS BY ID
	@Transactional
	@Modifying
	@Query(value = "DELETE from teacher_studentmodulefileprogress WHERE id = ?1", nativeQuery = true)
	public int deleteById(int id);

	
	//GET MODULE FILE PROGRESS BY FILE ID AND STUDENT ID
	@Query(value = " SELECT * from teacher_studentmodulefileprogress as p WHERE p.fileid_id= ?1 and p.studentid_id = ?2", nativeQuery = true)
	public ModuleFileProgress findByFileId_StudId(int fileId, int studId);

	//GET MODULE FILE PROGRESS BY MODULE ID AND STUDENT ID
	@Query(value = " SELECT * from teacher_studentmodulefileprogress as p WHERE p.moduleid_id= ?1 and p.studentid_id = ?2 and p.progress = 100 ", nativeQuery = true)
	public List<ModuleFileProgress> findByModId_StudId_Prog(int modId, int studId);

	
	//GET LIST MODULE FILE PROGRESS MODULE ID AND STUDENT ID
	@Query(value = " SELECT * from teacher_studentmodulefileprogress as p WHERE p.moduleid_id= ?1 and p.studentid_id = ?2", nativeQuery = true)
	public List<ModuleFileProgress> findByModId_StudId(int modId, int studId);

	//GET MODULE FILE PROGRESS BY FILE UD AND STUDENT ID
	public ModuleFileProgress findByFileIdAndStudentId(int moduleFileId, int studentId);
}
