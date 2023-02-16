/**
 * @author  - Code Generator
 * @createdOn -  10-01-2023
 * @Description Entity class for Course
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

	public Course findByCourseName(String name);

	public List<Object> findByCourseIsActiveTrue();

	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_course SET isactive=false WHERE name = ?1", nativeQuery = true)
	public int deleteCourseByName(String name);

	@Query(value = "SELECT * FROM teacher_course JOIN public.\"teacher_course_institutionId\" ON teacher_course.courseid = public.\"teacher_course_institutionId\".courseid WHERE public.\"teacher_course_institutionId\".institutionid = ?1", nativeQuery = true)
	public List<Course> findTeacherCourseByInstitutionId(int institutionid);

	@Query(value = "SELECT tc.* FROM teacher_course tc JOIN teacher_course_institutionid tci ON tc.courseid = tci.course_id JOIN admin_institution inst ON tci.institution_id = inst.institutionid WHERE inst.isactive = true AND tc.isactive = false", nativeQuery = true)
	public List<Course> findInactiveCoursesOfActiveInstitutions();

	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_course SET isactive=true WHERE courseid = ?1", nativeQuery = true)
	public int activateCourseById(int courseId);

}
