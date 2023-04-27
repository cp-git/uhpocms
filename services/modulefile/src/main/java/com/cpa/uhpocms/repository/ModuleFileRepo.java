/**
 * @author  - Code Generator
 * @createdOn -  13-02-2023
 * @Description Entity class for ModuleFile
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.ModuleFile;

@Repository
public interface ModuleFileRepo extends JpaRepository<ModuleFile, Integer> {

	public ModuleFile findByModuleFile(String file);
	
	public List<Object>  findByModuleId(int module_id);

	public List<Object> findByModuleFileIsActiveTrue();

	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_modulefile SET isactive=false WHERE file = ?1", nativeQuery = true)
	public int deleteModuleFileByFile(String file);

	@Query(value = "SELECT tmf.* FROM teacher_modulefile tmf JOIN teacher_module tm ON tmf.moduleid_id=tm.moduleid JOIN teacher_course_enrolltostudent enroll ON tm.courseid_id=enroll.course_id where enroll.profile_id=?1", nativeQuery = true)
	public List<ModuleFile> findModuleFileByStudentId(int studentId);
}
