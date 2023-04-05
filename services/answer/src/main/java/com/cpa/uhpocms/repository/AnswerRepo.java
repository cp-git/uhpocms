/**
 * @author  - Code Generator
 * @createdOn -  30-03-2023
 * @Description Entity class for Answer
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.Answer;

@Repository
public interface AnswerRepo extends JpaRepository<Answer, Integer> {

	public Answer findById(int id);

//	public void findAll();

	@Transactional
	@Modifying
	//@Query(value = "UPDATE Teacher_answer SET is_active=false WHERE id = ?1", nativeQuery = true)
	public int deleteAnswerByid(int id);

	@Query(value = "SELECT* FROM teacher_answer WHERE teacher_answer.questionid = ?1", nativeQuery = true)
	public List<Answer> findAnswerByQuestionId(int questionid);
}
