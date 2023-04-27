/**
 * @author  - Code Generator
 * @createdOn -  06-12-2022
 * @Description Entity class for Quiz
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer> {

	public Quiz findBytitle(String title);

	public List<Object> findByIsActiveTrue();

	@Transactional
	@Modifying
	@Query(value = "UPDATE  Teacher_quiz SET isactive=false WHERE title = ?1", nativeQuery = true)
	public int deleteBytitle(String title);

	public List<Object> findByIsActiveFalse();

	@Query(value = "SELECT quiz.* FROM public.teacher_quiz quiz JOIN public.teacher_course_enrolltostudent enrollcourses ON quiz.courseid_id=enrollcourses.course_id WHERE enrollcourses.profile_id=?1 AND quiz.isactive=true", nativeQuery = true)
	public List<Quiz> getAllQuizzesByStudentId(int studentId);
}
