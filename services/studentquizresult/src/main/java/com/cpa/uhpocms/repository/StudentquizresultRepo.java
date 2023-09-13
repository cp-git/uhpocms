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

	// GET LIST OF STUDENT QUIZ RESULT USING QUIZ ID
	public List<Studentquizresult> findAllByQuizId(int quizid);

	//GET STUDENT QUIZ RESULT USING STUDENT ID AND QUESTION ID
	public Studentquizresult findByStudentIdAndQuestionId(int studentId, int questionId);

	// GET STUDENT QUIZ RESULT USING STUDENT ID AND QUIZ ID
	public List<Studentquizresult> findByStudentIdAndQuizId(int studentId, int quizId);

	
}
