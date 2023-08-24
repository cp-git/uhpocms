package com.cpa.uhpocms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cpa.uhpocms.entity.Quizprogress;
import com.cpa.uhpocms.entity.StudentProgress;

public interface studentRepo  extends JpaRepository<StudentProgress, Integer> {
	
	
	public StudentProgress getStudentprogressByStudentId(int studentId);
	
	@Query(value = "SELECT grade from student_course_grade student where student.studentid_id=?1", nativeQuery = true)
	List<Object> getStudentMarksid(int studentId);

}
