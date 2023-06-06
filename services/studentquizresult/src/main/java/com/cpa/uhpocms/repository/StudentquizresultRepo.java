/**
 * @author  - Code Generator
 * @createdOn -  01-06-2023
 * @Description Entity class for Studentquizresult
 * 
 */

package com.cpa.uhpocms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpa.uhpocms.entity.Studentquizresult;

@Repository
public interface StudentquizresultRepo extends JpaRepository<Studentquizresult, Integer> {

	public List<Studentquizresult> findAllByQuizId(int quizid);

	public Studentquizresult findByStudentIdAndQuestionId(int studentId, int questionId);

	public List<Studentquizresult> findByStudentIdAndQuizId(int studentId, int quizId);

//	@Transactional
//	@Modifying
//	@Query(value = "UPDATE teacher_studentquizresult SET is_active=false WHERE questionid = ?1", nativeQuery = true)
//	public int deleteQuizResultByquestionid(int questionid);

}
