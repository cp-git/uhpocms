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

	public CourseProgress findById(int id);

	@Transactional
	@Modifying
	@Query(value = "DELETE from teacher_studentcourseprogress WHERE id = ?1", nativeQuery = true)
	public int deleteById(int id);

	public List<CourseProgress> findByCourseId(int courseId);

	/**
	 * @author shradha
	 * @param courseId
	 * @param studId
	 * @return
	 */
	@Query(value = " SELECT * from teacher_studentcourseprogress as p WHERE p.courseid_id= ?1 and p.studentid_id = ?2", nativeQuery = true)
	public CourseProgress findByCourseId_StudId(int courseId, int studId);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM teacher_studentcourseprogress WHERE courseid_id = ?1 AND studentid_id = ?2", nativeQuery = true)
	int deleteCourseProgressByCourseIdAndStudentId(int courseId, int studId);
}
