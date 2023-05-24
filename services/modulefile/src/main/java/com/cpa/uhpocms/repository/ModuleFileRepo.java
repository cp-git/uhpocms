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

	public ModuleFile findByModuleFileId(int id);

	public List<Object> findByModuleFileIsActiveFalse();

//	@Transactional
//	@Modifying
//	@Query(value = "UPDATE teacher_modulefile SET isactive=false WHERE file = ?1", nativeQuery = true)
//	public int deleteModuleFileByFile(String file);

	@Query(value = "SELECT tmf.* FROM teacher_modulefile tmf JOIN teacher_module tm ON tmf.moduleid_id=tm.moduleid JOIN teacher_course_enrolltostudent enroll ON tm.courseid_id=enroll.course_id where enroll.profile_id=?1 ORDER BY tmf.fileorderno ", nativeQuery = true)
	public List<ModuleFile> findModuleFileByStudentId(int studentId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_modulefile SET isactive=false WHERE id= ?1", nativeQuery = true)
	public int deleteModuleFileByModuleFileId(int id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_modulefile SET isactive=true WHERE id = ?1", nativeQuery = true)
	public int activateModuleFileByModuleFileId(int id);
	
	
	
	//Find Module Name by Using ModuleFielId
	@Query(value="Select dp.name from teacher_module dp JOIN teacher_modulefile tc  ON tc.moduleid_id = dp.moduleid where tc.id=?1",nativeQuery=true)
	public String finByModuleByModuleId(int moduleFileId);
	
	
	//Find Course Name By ModuleId
	@Query(value="Select dp.name from teacher_course dp JOIN teacher_module tc  ON tc.courseid_id = dp.courseid where tc.moduleid=?1",nativeQuery=true)
	public String finByCourseByModuleId(int moduleId);
	
	
	//Find Department Name using Teacher_course_department
	@Query(value="Select  admin_department.name FROM teacher_course,teacher_module,admin_institution,admin_department,teacher_course_departmentid,teacher_modulefile  WHERE admin_department.departmentid = teacher_course_departmentid.department_id AND 	teacher_course_Departmentid.course_id = teacher_course.courseid AND admin_institution.institutionid = teacher_course.instid AND teacher_course.courseid = teacher_module.courseid_id AND teacher_module.moduleid = teacher_modulefile.moduleid_id AND teacher_modulefile.id=?1",nativeQuery=true)
	public String finByAdminDepartmentByCourseDepartmentId(int moduleFileId);
	
	
	//Find Institute Name
	
	@Query(value="Select  admin_institution.name FROM teacher_course,teacher_module,admin_institution,admin_department,teacher_course_departmentid,teacher_modulefile  WHERE admin_department.departmentid = teacher_course_departmentid.department_id AND 	teacher_course_Departmentid.course_id = teacher_course.courseid AND admin_institution.institutionid = teacher_course.instid AND teacher_course.courseid = teacher_module.courseid_id AND teacher_module.moduleid = teacher_modulefile.moduleid_id AND teacher_modulefile.id=?1",nativeQuery=true)
	public String finByAdminInstitutionByCourseDepartmentId(int moduleFileId);
	
	@Query(value="Select  admin_institution.institutionid FROM teacher_course,teacher_module,admin_institution,admin_department,teacher_course_departmentid,teacher_modulefile  WHERE admin_department.departmentid = teacher_course_departmentid.department_id AND 	teacher_course_Departmentid.course_id = teacher_course.courseid AND admin_institution.institutionid = teacher_course.instid AND teacher_course.courseid = teacher_module.courseid_id AND teacher_module.moduleid = teacher_modulefile.moduleid_id AND teacher_modulefile.id=?1",nativeQuery=true)
	public int finByAdminInstitutionById(int moduleFileId);
	
	
	@Query(value = "Select * from teacher_modulefile WHERE moduleid_id= ?1", nativeQuery = true)
	public List<ModuleFile> getAllModuleFiles(int moduleId);
	
	
	@Query(value = "Select file from teacher_modulefile WHERE moduleid_id= ?1", nativeQuery = true)
	public List<String> getAllModuleFilesName(int moduleId);
	
	
}


