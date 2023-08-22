package com.cpa.uhpocms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_progress")
public class StudentProgress {
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@Column(name = "max_marks")
	private int maxMarks;
	
	
	@Column(name = "obtain_marks")
	private int obtainMarks;
	
	@Column(name = "studentid_id")
	private int studentId;
	
	
	@Column(name = "course_id")
	private int courseId;
	
	@Column(name = "percentage")
	private int percentAge;
	
	
	@Column(name = "grade")
	private int studentGrade;
	


	public StudentProgress() {
		super();
		this.maxMarks = maxMarks;
		this.obtainMarks = obtainMarks;
		this.studentId = studentId;
		this.courseId = courseId;
		this.percentAge = percentAge;
		this.studentGrade = studentGrade;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getMaxMarks() {
		return maxMarks;
	}


	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}


	public int getObtainMarks() {
		return obtainMarks;
	}


	public void setObtainMarks(int obtainMarks) {
		this.obtainMarks = obtainMarks;
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public int getPercentAge() {
		return percentAge;
	}


	public void setPercentAge(int percentAge) {
		this.percentAge = percentAge;
	}


	public int getStudentGrade() {
		return studentGrade;
	}


	public void setStudentGrade(int studentGrade) {
		this.studentGrade = studentGrade;
	}
	
	
	
	
	
	
	

}
