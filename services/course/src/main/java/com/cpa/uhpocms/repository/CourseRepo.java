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

	public Course findByCourseId(int courseid);

	public List<Object> findByCourseIsActiveTrue();

	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_course SET isactive=false WHERE name = ?1", nativeQuery = true)
	public int deleteCourseByName(String name);

	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_course SET isactive=false WHERE courseid= ?1", nativeQuery = true)
	public int deleteCourseByCourseId(int courseid);

	
	
	//Finding Courses of student by profile id
		@Query(value="SELECT tc.* FROM teacher_course tc JOIN teacher_course_enrolltostudent enroll ON tc.courseid = enroll.course_id WHERE tc.isactive = true AND enroll.profile_id = ?1", nativeQuery =true)
		public List<Course> findCourseByProfileId(int profileid);	
	
	
	//Finding Courses of department by id
	@Query(value="SELECT tc.* FROM teacher_course tc JOIN teacher_course_departmentid deptCourse ON  tc.courseid = deptCourse.course_id WHERE deptCourse.department_id = ?1", nativeQuery =true)
	public List<Course> findCourseByDepartmentId(int department_id);
	
	//finding assign courses to teacher
	@Query(value="SELECT tc.* FROM teacher_course tc JOIN teacher_course_assigntoteacher tca ON tc.courseid = tca.course_id WHERE tc.isactive = true AND tca.profile_id= ?1", nativeQuery =true)
	public List<Course> findCourseAssigntoTeacherByProfileId(int profileid);
	
	//finding assign courses to teacher
		@Query(value="SELECT tc.* FROM teacher_course tc JOIN teacher_course_assigntoteacher tca ON tc.courseid = tca.course_id WHERE tc.isactive = false AND tca.profile_id= ?1", nativeQuery =true)
		public List<Course> findInactiveCourseAssigntoTeacherByProfileId(int profileid);
	
	


	// Finding Courses of student by profile id
	@Query(value = "SELECT tc.* FROM teacher_course tc JOIN teacher_course_enrolltostudent enroll ON tc.courseid = enroll.course_id WHERE enroll.profile_id = ?1", nativeQuery = true)
	public List<Course> findTeacherProfileId(int profileid);

	// Finding Courses of department by id
	//@Query(value = "SELECT tc.* FROM teacher_course tc JOIN teacher_course_departmentid deptCourse ON  tc.courseid = deptCourse.course_id WHERE deptCourse.department_id = ?1", nativeQuery = true)
	//public List<Course> findCourseByDepartmentId(int department_id);



	@Query(value = "SELECT * FROM teacher_course JOIN public.teacher_course_institutionid ON teacher_course.courseid = public.teacher_course_institutionid.course_id WHERE public.teacher_course_institutionid.institution_id= ?1", nativeQuery = true)

	public List<Course> findTeacherCourseByInstitutionId(int institutionid);

	@Query(value = "SELECT tc.* FROM teacher_course tc JOIN teacher_course_institutionid tci ON tc.courseid = tci.course_id JOIN admin_institution inst ON tci.institution_id = inst.institutionid WHERE inst.isactive = true AND tc.isactive = false", nativeQuery = true)
	public List<Course> findInactiveCoursesOfActiveInstitutions();

	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_course SET isactive=true WHERE courseid = ?1", nativeQuery = true)
	public int activateCourseById(int courseId);
	
	

	
	@Query(value = "INSERT INTO teacher_course_enrolltostudent(course_id, profile_id) VALUES (?1,?2)", nativeQuery = true)
	public void insertCourseAndProfile(int courseId, int profileId);
	
	@Query(value = "SELECT tc.* FROM teacher_course tc JOIN teacher_course_institutionid tci ON tc.courseid = tci.course_id JOIN admin_institution inst ON tci.institution_id = inst.institutionid WHERE inst.isactive = true AND tc.isactive = true", nativeQuery = true)
	public List<Course> findActiveCoursesOfActiveInstitutions();
	
}
