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
import org.springframework.data.repository.query.Param;
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

	@Query(value = "SELECT quiz.* FROM teacher_quiz quiz JOIN teacher_question question ON quiz.quizid = question.quizid_id WHERE quiz.quizid = ?1", nativeQuery = true)
	public List<Question> findQuestionsByQuizId(int questionQuizId);
	
	
	@Query(value = "SELECT * FROM teacher_question WHERE quizid_id = ?1 ORDER BY CASE WHEN (SELECT random_order FROM teacher_quiz WHERE quizid = ?1) = true THEN random() ELSE questionOrderNo END", nativeQuery = true)
	List<Question> shuffleQuestionsByQuizId(int quizId);


	

	public List<Object> findAllByQuestionQuizIdAndQuestionIsActiveOrderByQuestionOrderNo(int quizId, boolean isActive);

	@Query(value = "CALL add_question_with_answers_mcq(CAST(:question AS json),CAST(:option1 AS json),CAST(:option2 AS json),CAST(:option3 AS json),CAST(:option4 AS json), :generatedId)", nativeQuery = true)
	Integer addQuestionWithAnswers(@Param("question") String question, @Param("option1") String answer1,
			@Param("option2") String answer2, @Param("option3") String answer3, @Param("option4") String answer4,
			@Param("generatedId") Integer questionId);

}