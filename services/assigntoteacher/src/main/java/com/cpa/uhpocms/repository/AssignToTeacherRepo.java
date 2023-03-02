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

	public AssignToTeacher findByAssignToTeachercourseId(int courseid);

	//public List<Object> findByAssignToTeacherIsActiveTrue();

	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_course_assigntoteacher SET is_active=false WHERE course_id = ?1", nativeQuery = true)
	public int deleteAssignToTeacherBycourseId(int courseid);

}
