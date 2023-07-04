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

	public List<Object> findAllByCourseId(int courseid);
	
	public AssignToTeacher findByCourseId (int courseid);

	//public List<Object> findByAssignToTeacherIsActiveTrue();

	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_course_assigntoteacher SET is_active=false WHERE course_id = ?1", nativeQuery = true)
	public int deleteAssignToTeacherBycourseId(int courseid);

	
	@Transactional
	@Modifying
	@Query(value = "SELECT DISTINCT te.* FROM teacher_course_assigntoteacher te  JOIN teacher_course tc ON te.course_id = tc.courseid WHERE tc.instid = ?1 and te.course_id=?2 and tc.isactive = 'true'", nativeQuery = true)
	List<AssignToTeacher> findProfilesByInstIDandCourseId(int instId,int courId);
	
	@Transactional
	 @Modifying
	    @Query(value = "DELETE FROM teacher_course_assigntoteacher WHERE course_id = ?1 AND profile_id = ?2", nativeQuery = true)
	    int deleteAssignToTeacherByCourseIdAndProfileId(int courseId, int profileId);
}
