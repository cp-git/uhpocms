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

	
	//FIND MODULE BY NAME
	public Module findByModuleName(String name);

	
	//FIND BY MODULE ID
	public Module findById(int moduleId);



	
	//DELETE MOUDLE BY MODULE NAME
	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_module SET isactive=false WHERE name = ?1", nativeQuery = true)
	public int deleteModuleByName(String name);

	
	//DELETE MODULE BY MODULE ID
	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_module SET isactive=false WHERE moduleid = ?1", nativeQuery = true)
	public int deleteModuleById(int moduleId);

	
	//GET LIST FIND COURSE ID AND MODULE IS ACTIVE
	public List<Object> findByCourseIdAndModuleIsActiveOrderByModuleOrderNo(int courseId, boolean isActive);


	//GET INACTIVE MODULES
	public List<Object> findByModuleIsActiveFalse();
	
	

	//FIND Module by active courses and department
		@Query(value = "SELECT teacher_module FROM teacher_module,teacher_course,admin_department WHERE  teacher_module.courseid_id = teacher_course.courseid AND teacher_course.instid = admin_department.institutionid AND teacher_course.isactive = true AND admin_department.isactive = true", nativeQuery = true)
		public List<Module> findModuleByCourseAndDepartment();


	
	
	//FIND COURSE BY COURSE ID
	@Query(value = "Select dp.name from teacher_course dp JOIN teacher_module tc  ON tc.courseid_id = dp.courseid where tc.moduleid=?1", nativeQuery = true)
	public String finByCourseByCourseId(int moduleId);

	

	//FIND ADMIN INSTITUTION ID
	@Query(value = "Select dp.name from admin_department dp JOIN teacher_course_departmentid tc  ON tc.department_id = dp.departmentid where tc.course_id=?1", nativeQuery = true)
	public String finByAdminInstitutionId(int courseId);

	
	// FIND INSTITUTE NAME
	@Query(value = "Select dp.name from admin_institution dp JOIN teacher_course tc  ON tc.instid = dp.institutionid where tc.courseid=?1", nativeQuery = true)
	public String finByAdminInstitutionNameAndId(int courseId);

	
	//FIND INSTITUTE ID
	@Query(value = "Select dp.institutionid from admin_institution dp JOIN teacher_course tc  ON tc.instid = dp.institutionid where tc.courseid=?1", nativeQuery = true)
	public int finByAdminInstitutionsId(int courseId);

	//GET ACTIVE MODULE 
	public List<Object> findByModuleIsActiveTrue();

	//FIND MODULES
	@Query(value = "Select * from teacher_module where courseid_id=?1", nativeQuery = true)
	List<Module> findModules(int courseId);

	//GET MODULES ASSIGN COURSES AND PROFILE ID
	@Query(value = "SELECT * FROM teacher_module, teacher_course, admin_department,teacher_course_assigntoteacher WHERE  teacher_module.courseid_id = teacher_course.courseid AND teacher_course.instid = admin_department.institutionid AND teacher_course.isactive = true AND admin_department.isactive = true AND teacher_course.courseid = teacher_course_assigntoteacher.course_id AND teacher_course_assigntoteacher.profile_id=?1", nativeQuery = true)
	List<Module> getModulesOfAssignedCoursesByProfileId(int ProfileId);

	
	
	//GET MODULE ENROLLED COURSES AND PROFILE ID
	@Query(value = "SELECT m.* FROM teacher_module AS m JOIN teacher_course AS c ON m.courseid_id = c.courseid JOIN teacher_course_enrolltostudent AS a ON c.courseid = a.course_id WHERE a.profile_id =?1", nativeQuery = true)
	List<Module> getModulesOfEnrolledCoursesByProfileId(int ProfileId);
	
	//ACTIVATE MODULE BY ID
	@Query(value="UPDATE public.teacher_module AS tm SET isactive =CASE WHEN EXISTS (SELECT 1 FROM public.teacher_modulefile AS tmf WHERE tmf.id IN (SELECT id FROM public.teacher_modulefile WHERE moduleid_id = (SELECT moduleid_id FROM public.teacher_modulefile WHERE id = ?1 ) AND isactive = true))THEN true ELSE false END WHERE tm.moduleid = (SELECT tmf.moduleid_id FROM public.teacher_modulefile AS tmf WHERE tmf.id = ?1)",nativeQuery=true)
	int updateIsActiveInTeacherModule(int id);

}
