/**
 * @author  - Code Generator
 * @createdOn -  06-12-2022
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

	public Answer findByAnswerId(String id);

	public List<Object> findByAnswerIsActiveTrue();

	@Transactional
	@Modifying
	@Query(value = "UPDATE Teacher_answer SET is_active=false WHERE id = ?1", nativeQuery = true)
	public int deleteAnswerById(String id);

}
