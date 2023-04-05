/**
 * @author  - Code Generator
 * @createdOn -  03-04-2023
 * @Description Entity class for Quizprogress
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.Quizprogress;

@Repository
public interface QuizprogressRepo extends JpaRepository<Quizprogress, Integer> {

	public Quizprogress findByStudentId(int studentId);

	//public List<Object> findByQuizProgressIsActiveTrue();

	@Transactional
	@Modifying
	//@Query(value = "UPDATE Teacher_studentquizprogress SET is_active=false WHERE studentid = ?1", nativeQuery = true)
	public int deleteQuizProgressBystudentId(int studentId);

}
