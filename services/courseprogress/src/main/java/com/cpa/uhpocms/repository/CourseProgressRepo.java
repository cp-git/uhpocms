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

}
