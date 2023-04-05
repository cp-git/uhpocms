/**
 * @author  - Code Generator
 * @createdOn -  07-12-2022
 * @Description Entity class for Question
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {

	public Question findByQuestionFigure(String figure);
	
	public Question findByQuestionId(int questionId);

	public List<Object> findByQuestionIsActiveTrue();

	@Transactional
	@Modifying
	@Query(value = "UPDATE teacher_question SET is_active=false WHERE figure = ?1", nativeQuery = true)
	public int deleteQuestionByFigure(String figure);
	
	@Query(value = "UPDATE teacher_question SET is_active=false WHERE id = ?1", nativeQuery = true)
	public int deleteQuestionByQuestionId(int questionId);
	
	public List<Object> findByQuestionIsActiveFalse();

	 

}