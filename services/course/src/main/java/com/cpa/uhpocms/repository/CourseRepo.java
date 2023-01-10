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

}
