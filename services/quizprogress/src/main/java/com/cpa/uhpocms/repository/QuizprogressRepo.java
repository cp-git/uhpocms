/**
 * @author  - Code Generator
 * @createdOn -  03-04-2023
 * @Description Entity class for Quizprogress
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.cpa.uhpocms.entity.Quizprogress;

@Repository
public interface QuizprogressRepo extends JpaRepository<Quizprogress, Integer> {

	public List<Object> findAllByStudentId(int studentId);



	public Quizprogress getQuizprogressByStudentIdAndQuizId(int studentId, int quizId);
	
	

	@Query(value = "SELECT qp.* FROM teacher_studentquizprogress qp JOIN teacher_quiz tq ON qp.quizid_id "
			+ "= tq.quizid  where tq.courseid_id=?1 and tq.module_id=?2", nativeQuery = true)
	List<Quizprogress> findquizprogressBycourseIdandModId(int courseId,int modId);
	
	
	@Query(value = "SELECT quiz.courseid_id FROM teacher_quiz quiz JOIN teacher_studentquizprogress student ON quiz.quizid= student.quizid_id where student.quizid_id=?1", nativeQuery = true)
	Integer getCourseByid(int quizId);
	
	@Query(value = "SELECT quiz.max_marks FROM teacher_quiz quiz JOIN teacher_studentquizprogress student ON quiz.quizid= student.quizid_id where student.courseid_id=?1", nativeQuery = true)
	List<Integer> getMarksByid(int courseId);
	
	
	@Query(value = "SELECT score from teacher_studentquizprogress quiz where quiz.studentid_id=?1", nativeQuery = true)
	List<Integer> getStudentMarksid(int studentId);
	
	

	
}
