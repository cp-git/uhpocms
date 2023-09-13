/**
 * @author  - Code Generator
 * @createdOn -  02-03-2023
 * @Description Entity class for AssignToTeacher
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.AssignToTeacher;


@Repository
public interface AssignToTeacherRepo extends JpaRepository<AssignToTeacher, Integer> {

	
	//GET LIST ALL COURSE ID
	public List<Object> findAllByCourseId(int courseid);
	
	
	//GET ASSIGN TEACHER BY COURSE ID
	public AssignToTeacher findByCourseId (int courseid);

	//public List<Object> findByAssignToTeacherIsActiveTrue();

	
	//DELETE ASSIGN TEACHER BY COURSE ID
	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_course_assigntoteacher SET is_active=false WHERE course_id = ?1", nativeQuery = true)
	public int deleteAssignToTeacherBycourseId(int courseid);

	
	//GET LIST OF PROFILES BASED ON INSTITUTE ID AND COURSE ID
	@Transactional
	@Modifying
	@Query(value = "SELECT DISTINCT te.* FROM teacher_course_assigntoteacher te  JOIN teacher_course tc ON te.course_id = tc.courseid WHERE tc.instid = ?1 and te.course_id=?2 and tc.isactive = 'true'", nativeQuery = true)
	List<AssignToTeacher> findProfilesByInstIDandCourseId(int instId,int courId);
	
	
	//DELETE THE ASSIGN TEACHER BY COURSE ID AND PROFILE ID
		@Transactional
		 @Modifying
	    @Query(value = "DELETE FROM teacher_course_assigntoteacher WHERE course_id = ?1 AND profile_id = ?2", nativeQuery = true)
	    int deleteAssignToTeacherByCourseIdAndProfileId(int courseId, int profileId);
}
