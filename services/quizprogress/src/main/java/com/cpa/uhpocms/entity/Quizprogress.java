/**
 * @author  - Code Generator
 * @createdOn -  03-04-2023
 * @Description Entity class for Teacher_studentquizprogress
 * 
 */

package com.cpa.uhpocms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher_studentquizprogress")
public class Quizprogress {

//TODO - add attributed and genrate setters and getters

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "score")
	private int score;

	@Column(name = "completed")
	private boolean isCompleted;

	@Column(name = "num_attempts")
	private int numberOfAttempts;

	@Column(name = "quizid_id")
	private int quizId;

	@Column(name = "studentid_id")
	private int studentId;
	
	@Column(name = "courseid_id")
	private int courseId;
	/**
	 * 
	 */
	public Quizprogress() {
		super();
	}
	
	
	public Quizprogress(int id, int score, boolean isCompleted, int numberOfAttempts, int quizId, int studentId,
			int courseId) {
		super();
		this.id = id;
		this.score = score;
		this.isCompleted = isCompleted;
		this.numberOfAttempts = numberOfAttempts;
		this.quizId = quizId;
		this.studentId = studentId;
		this.courseId = courseId;
	}

	/**
	 * @param id
	 * @param score
	 * @param isCompleted
	 * @param numberOfAttempts
	 * @param quizId
	 * @param studentId
	 */
	
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
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the isCompleted
	 */
	public boolean isCompleted() {
		return isCompleted;
	}

	/**
	 * @param isCompleted the isCompleted to set
	 */
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	/**
	 * @return the numberOfAttempts
	 */
	public int getNumberOfAttempts() {
		return numberOfAttempts;
	}

	/**
	 * @param numberOfAttempts the numberOfAttempts to set
	 */
	public void setNumberOfAttempts(int numberOfAttempts) {
		this.numberOfAttempts = numberOfAttempts;
	}

	/**
	 * @return the quizId
	 */
	public int getQuizId() {
		return quizId;
	}

	/**
	 * @param quizId the quizId to set
	 */
	public void setQuizId(int quizId) {
		this.quizId = quizId;
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
	
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

}
