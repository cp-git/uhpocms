package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.Course;
import com.cpa.uhpocms.entity.CourseDepartment;

@Repository
public interface CourseDepartmentRepo extends JpaRepository<CourseDepartment, Integer> {
	@Transactional
	public int deleteByCourseId(int course_id);

	List<CourseDepartment> findAll();

	@Query(value = "SELECT distinct dp.name from admin_department dp JOIN teacher_course_departmentid tc  ON tc.department_id = dp.departmentid where tc.department_id=?1", nativeQuery = true)
	public String finByAdminInstitutionId(int department_id);

	// To find instituteName
	@Query(value = "Select dp.name from admin_institution dp JOIN teacher_course tc  ON tc.instid = dp.institutionid where tc.courseid=?1", nativeQuery = true)
	public String finByAdminInstitutionByCourseId(int courseId);

	// To Find Institute Id
	@Query(value = "Select dp.institutionid from admin_institution dp JOIN teacher_course tc  ON tc.instid = dp.institutionid where tc.courseid=?1", nativeQuery = true)
	public int finByAdminInstitutionsByCourseId(int courseId);

	@Query(value = "Select distinct dp.name from teacher_course dp JOIN teacher_course_departmentid tc  ON tc.course_id = dp.courseid where tc.course_id=?1", nativeQuery = true)
	public String finByCourseByCourseId(int courseId);

	@Query(value = "SELECT admin_department.name FROM teacher_course,teacher_module,admin_institution,admin_department,teacher_course_departmentid WHERE admin_department.departmentid = teacher_course_departmentid.department_id AND teacher_course_Departmentid.course_id =teacher_course.courseid AND admin_institution.institutionid = teacher_course.instid AND teacher_course.courseid =?1", nativeQuery = true)
	public String finByDepartmentInstitutionId(int courseId);

	@Query(value = "SELECT distinct dp.name from teacher_course dp JOIN teacher_course_departmentid tc  ON tc.course_id = dp.courseid where tc.department_id=?1", nativeQuery = true)
	public Course finByCoursesOnDepartment(int department_id);

	@Transactional
	@Query(value = "SELECT dp.departmentid from admin_department dp JOIN teacher_course_departmentid tc  ON tc.department_id = dp.departmentid where tc.department_id=?1", nativeQuery = true)
	public int finByAdminDepartmentId(int department_id);

	//

}
