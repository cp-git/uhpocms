/**
 * @author  - Code Generator
 * @createdOn -  27-02-2023
 * @Description Entity class for CourseSyllabus
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.CourseSyllabus;

@Repository
public interface CourseSyllabusRepo extends JpaRepository<CourseSyllabus, Integer> {

	public CourseSyllabus findByCourseSyllabusId(int courseSyllabusId);

	public List<Object> findByCourseSyllabusIsActiveTrue();

	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_coursesyllabus SET isactive=false WHERE id = ?1", nativeQuery = true)
	public int deleteCourseSyllabusById(int courseSyllabusId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_coursesyllabus SET isactive=false WHERE courseid_id = ?1", nativeQuery = true)
	public int deleteCourseSyllabusByCourseId(int courseId);
}
