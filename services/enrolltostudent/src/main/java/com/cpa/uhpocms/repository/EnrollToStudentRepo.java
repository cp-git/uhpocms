/**
 * @author  - Code Generator
 * @createdOn -  23-02-2023
 * @Description Entity class for EnrollToStudent
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.EnrollToStudent;

@Repository
public interface EnrollToStudentRepo extends JpaRepository<EnrollToStudent, Integer> {

	public EnrollToStudent findByCourseId(int courseid);

//	public List<Object> findByEnrollToStudentIsActiveTrue();

	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_course_enrollToStudent SET is_active=false WHERE courseid = ?1", nativeQuery = true)
	public int deleteEnrollToStudentBycourseId(int courseid);

	
	@Query(value = "INSERT INTO teacher_course_enrolltostudent(course_id, profile_id) VALUES (?1,?2)", nativeQuery = true)
	public void insertCourseAndProfile(int courseId, int profileId);
}
