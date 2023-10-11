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

	//FIND MODULE FILE
	public ModuleFile findByModuleFile(String file);

	//FIND BY MODULE ID
	public List<Object> findByModuleId(int module_id);

	//ACTIVE MODULE FILE
	public List<Object> findByModuleFileIsActiveTrue();

	//FIND MODULE FILE ID
	public ModuleFile findByModuleFileId(int id);

	//FIND INACTIVE MODULE FILE
	public List<Object> findByModuleFileIsActiveFalse();

	//FIND MODULE FILE BY STUDENT ID
	@Query(value = "SELECT tmf.* FROM teacher_modulefile tmf JOIN teacher_module tm ON tmf.moduleid_id=tm.moduleid JOIN teacher_course_enrolltostudent enroll ON tm.courseid_id=enroll.course_id where enroll.profile_id=?1 ORDER BY tmf.fileorderno ", nativeQuery = true)
	public List<ModuleFile> findModuleFileByStudentId(int studentId);

	
	//DELETE MODULE FILE BY ID
	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_modulefile SET isactive=false WHERE id= ?1", nativeQuery = true)
	public int deleteModuleFileByModuleFileId(int id);

	
	//ACTIAVATE MODULE FILE BY ID
	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_modulefile SET isactive=true WHERE id = ?1", nativeQuery = true)
	public int activateModuleFileByModuleFileId(int id);

	// Find Module Name by Using ModuleFielId
	@Query(value = "Select dp.name from teacher_module dp JOIN teacher_modulefile tc  ON tc.moduleid_id = dp.moduleid where tc.id=?1", nativeQuery = true)
	public String finByModuleByModuleId(int moduleFileId);

	// Find Course Name By ModuleId
	@Query(value = "Select dp.name from teacher_course dp JOIN teacher_module tc  ON tc.courseid_id = dp.courseid where tc.moduleid=?1", nativeQuery = true)
	public String finByCourseByModuleId(int moduleId);

	// Find Department Name using Teacher_course_department
	@Query(value = "Select  admin_department.name FROM teacher_course,teacher_module,admin_institution,admin_department,teacher_course_departmentid,teacher_modulefile  WHERE admin_department.departmentid = teacher_course_departmentid.department_id AND 	teacher_course_Departmentid.course_id = teacher_course.courseid AND admin_institution.institutionid = teacher_course.instid AND teacher_course.courseid = teacher_module.courseid_id AND teacher_module.moduleid = teacher_modulefile.moduleid_id AND teacher_modulefile.id=?1", nativeQuery = true)
	public String finByAdminDepartmentByCourseDepartmentId(int moduleFileId);

	// Find Institute Name

	@Query(value = "Select  admin_institution.name FROM teacher_course,teacher_module,admin_institution,admin_department,teacher_course_departmentid,teacher_modulefile  WHERE admin_department.departmentid = teacher_course_departmentid.department_id AND 	teacher_course_Departmentid.course_id = teacher_course.courseid AND admin_institution.institutionid = teacher_course.instid AND teacher_course.courseid = teacher_module.courseid_id AND teacher_module.moduleid = teacher_modulefile.moduleid_id AND teacher_modulefile.id=?1", nativeQuery = true)
	public String finByAdminInstitutionByCourseDepartmentId(int moduleFileId);

	//FIND INSTITUTE ID
	@Query(value = "Select  admin_institution.institutionid FROM teacher_course,teacher_module,admin_institution,admin_department,teacher_course_departmentid,teacher_modulefile  WHERE admin_department.departmentid = teacher_course_departmentid.department_id AND 	teacher_course_Departmentid.course_id = teacher_course.courseid AND admin_institution.institutionid = teacher_course.instid AND teacher_course.courseid = teacher_module.courseid_id AND teacher_module.moduleid = teacher_modulefile.moduleid_id AND teacher_modulefile.id=?1", nativeQuery = true)
	public int finByAdminInstitutionById(int moduleFileId);

	//GET ALL MODULE FILE
	@Query(value = "Select * from teacher_modulefile WHERE moduleid_id= ?1", nativeQuery = true)
	public List<ModuleFile> getAllModuleFiles(int moduleId);

	
	@Query(value = "Select file from teacher_modulefile WHERE moduleid_id= ?1", nativeQuery = true)
	public List<String> getAllModuleFilesName(int moduleId);

	@Query(value = "Select * from teacher_modulefile", nativeQuery = true)
	public List<ModuleFile> getAllModuleFile();

	@Query(value = "SELECT tmf.* FROM teacher_modulefile tmf JOIN teacher_module tm ON tmf.moduleid_id=tm.moduleid JOIN teacher_course_assigntoteacher enroll ON tm.courseid_id=enroll.course_id where enroll.profile_id=?1 ORDER BY tmf.fileorderno", nativeQuery = true)
	public List<ModuleFile> findModuleFilesByTeacherId(int teacherId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE public.teacher_module AS tm SET isactive =CASE WHEN EXISTS (SELECT 1 FROM public.teacher_modulefile AS tmf WHERE tmf.id IN (SELECT id FROM public.teacher_modulefile WHERE moduleid_id = (SELECT moduleid_id FROM public.teacher_modulefile WHERE id = ?1 ) AND isactive = true))THEN true ELSE false END WHERE tm.moduleid = (SELECT tmf.moduleid_id FROM public.teacher_modulefile AS tmf WHERE tmf.id = ?1)",nativeQuery=true)
	int updateIsActiveInTeacherModule(int id);
	

	//FETCH MODULE FILES BASED ON ACTIVE MODULE
	@Query(value = "SELECT * FROM teacher_modulefile T WHERE  EXISTS( SELECT 1 FROM teacher_module U  WHERE U.moduleid = T.moduleid_id AND U.isactive=true);", nativeQuery = true)
	public List<ModuleFile> getAllModuleFileByActiveModule();
	
	

	
	
	@Query(value = "Select dp.* from teacher_modulefile dp JOIN teacher_module tc  ON tc.moduleid = dp.moduleid_id where dp.moduleid_id=?1 and tc.review=true", nativeQuery = true)
	public List<Object> getAllModuleFilesbyModuleid(int moduleId);


}
