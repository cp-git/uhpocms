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

	@Transactional
	@Modifying
	public int deleteQuizprogressByStudentIdAndQuizId(int studentId, int quizId);

	public Quizprogress getQuizprogressByStudentIdAndQuizId(int studentId, int quizId);
	
	public Quizprogress getQuizprogressByStudentIdAndQuizIdAndIsCompletedTrue(int studentId, int quizId);

	@Query(value = "SELECT qp.* FROM teacher_studentquizprogress qp JOIN teacher_quiz tq ON qp.quizid_id.= tq.quizid  where tq.courseid_id=?1 and tq.module_id=?2", nativeQuery = true)
	List<Quizprogress> findquizprogressBycourseIdandModId(int courseId,int modId);

	
}
