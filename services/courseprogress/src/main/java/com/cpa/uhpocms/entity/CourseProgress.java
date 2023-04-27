/**
 * @author  - Code Generator
 * @createdOn -  05-04-2023
 * @Description Entity class for teacher_studentcourseprogress
 * 
 */

package com.cpa.uhpocms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "teacher_studentcourseprogress")
public class CourseProgress {

//TODO - add attributed and genrate setters and getters

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "grade", nullable = false)
	private float grade ;

	@Column(name = "currentmoduleno", nullable = false)
	private int currentModuleNo;

	@Column(name = "currentunitno", nullable = false)
	private int currentUnitNo;

	@Column(name = "currentassignno", nullable = false)
	private int currentAssignNo;

	@Column(name = "courseid_id", nullable = false)
	private int courseId;

	@Column(name = "studentid_id", nullable = false)
	private int studentId;

	@Column(name = "progress", nullable = false)
	private int progress;

	/**
	 * @return the progress
	 */
	public int getProgress() {
		return progress;
	}

	/**
	 * @param progress the progress to set
	 */
	public void setProgress(int progress) {
		this.progress = progress;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the grade
	 */
	public float getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(float grade) {
		this.grade = grade;
	}

	/**
	 * @return the currentModuleNo
	 */
	public int getCurrentModuleNo() {
		return currentModuleNo;
	}

	/**
	 * @param currentModuleNo the currentModuleNo to set
	 */
	public void setCurrentModuleNo(int currentModuleNo) {
		this.currentModuleNo = currentModuleNo;
	}

	/**
	 * @return the currentUnitNo
	 */
	public int getCurrentUnitNo() {
		return currentUnitNo;
	}

	/**
	 * @param currentUnitNo the currentUnitNo to set
	 */
	public void setCurrentUnitNo(int currentUnitNo) {
		this.currentUnitNo = currentUnitNo;
	}

	/**
	 * @return the currentAssignNo
	 */
	public int getCurrentAssignNo() {
		return currentAssignNo;
	}

	/**
	 * @param currentAssignNo the currentAssignNo to set
	 */
	public void setCurrentAssignNo(int currentAssignNo) {
		this.currentAssignNo = currentAssignNo;
	}

	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * @param id
	 * @param grade
	 * @param currentModuleNo
	 * @param currentUnitNo
	 * @param currentAssignNo
	 * @param courseId
	 * @param studentId
	 * @param progress
	 */
	public CourseProgress(int id, float grade, int currentModuleNo, int currentUnitNo, int currentAssignNo,
			int courseId, int studentId, int progress) {
		super();
		this.id = id;
		this.grade = grade;
		this.currentModuleNo = currentModuleNo;
		this.currentUnitNo = currentUnitNo;
		this.currentAssignNo = currentAssignNo;
		this.courseId = courseId;
		this.studentId = studentId;
		this.progress = progress;
	}

	/**
	 * 
	 */
	public CourseProgress() {
		super();
	}

	@Override
	public String toString() {
		return "CourseProgress [id=" + id + ", grade=" + grade + ", currentModuleNo=" + currentModuleNo
				+ ", currentUnitNo=" + currentUnitNo + ", currentAssignNo=" + currentAssignNo + ", courseId=" + courseId
				+ ", studentId=" + studentId + ", progress=" + progress + "]";
	}

	
	
}
