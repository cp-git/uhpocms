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
	
	public List<Quiz> findByModuleId(int moduleId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE  Teacher_quiz SET isactive=false WHERE title = ?1", nativeQuery = true)
	public int deleteBytitle(String title);

	public List<Object> findByIsActiveFalse();

	@Query(value = "SELECT quiz.* FROM public.teacher_quiz quiz JOIN public.teacher_course_enrolltostudent enrollcourses ON quiz.courseid_id=enrollcourses.course_id WHERE enrollcourses.profile_id=?1 AND quiz.isactive=true", nativeQuery = true)
	public List<Quiz> getAllQuizzesByStudentId(int studentId);
	
	@Query(value = "SELECT tq.quizid, tm.name AS module_name, tc.name AS course_name, ad.name AS department_name, ai.name AS institution_name, tq.pass_mark, tc.coursecode FROM teacher_quiz tq JOIN public.teacher_module tm ON tq.module_id = tm.moduleid JOIN public.teacher_course tc ON tm.courseid_id = tc.courseid JOIN public.admin_department ad ON tc.instid = ad.institutionid JOIN public.admin_institution ai ON ad.institutionid = ai.institutionid WHERE  tq.quizid = ?1", nativeQuery = true)
	List<Object[]> getQuizInfoByQuizId(int quizId);

}
