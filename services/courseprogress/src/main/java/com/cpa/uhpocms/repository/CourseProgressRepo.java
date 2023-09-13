/**
 * @author  - Code Generator
 * @createdOn -  05-04-2023
 * @Description Entity class for CourseProgress
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.CourseProgress;

@Repository
public interface CourseProgressRepo extends JpaRepository<CourseProgress, Integer> {

	//FIND COURSE PROGRESS BY ID
	public CourseProgress findById(int id);

	
	//DELETE COURSE PROGRESS BY ID
	@Transactional
	@Modifying
	@Query(value = "DELETE from teacher_studentcourseprogress WHERE id = ?1", nativeQuery = true)
	public int deleteById(int id);

	//GET LIST OF COURSE PROGRESS BY COURSE ID
	public List<CourseProgress> findByCourseId(int courseId);

	
	//GET COURSE PROGRESS BY COURSE ID AND STUDENT ID
	@Query(value = " SELECT * from teacher_studentcourseprogress as p WHERE p.courseid_id= ?1 and p.studentid_id = ?2", nativeQuery = true)
	public CourseProgress findByCourseId_StudId(int courseId, int studId);

	
	//DELETE COURSE PROGRESS BY COURSE ID AND STUDENT ID
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM teacher_studentcourseprogress WHERE courseid_id = ?1 AND studentid_id = ?2", nativeQuery = true)
	int deleteCourseProgressByCourseIdAndStudentId(int courseId, int studId);
}
