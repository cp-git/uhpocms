/**
 * @author  - Code Generator
 * @createdOn -  03-04-2023
 * @Description Entity class for Teacher_studentquizprogress
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
	private boolean completed;

	@Column(name = "numattempts")
	private int numberOfAttempts;
	
	@Column(name = "quizid")
	private int quizid;
	
	@Column(name = "studentid")
	private int studentId;

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
	 * @return the completed
	 */
	public boolean isCompleted() {
		return completed;
	}

	/**
	 * @param completed the completed to set
	 */
	public void setCompleted(boolean completed) {
		this.completed = completed;
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
	 * @return the quizid
	 */
	public int getQuizid() {
		return quizid;
	}

	/**
	 * @param quizid the quizid to set
	 */
	public void setQuizid(int quizid) {
		this.quizid = quizid;
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
	 * @param score
	 * @param completed
	 * @param numberOfAttempts
	 * @param quizid
	 * @param studentId
	 */
	public Quizprogress(int id, int score, boolean completed, int numberOfAttempts, int quizid, int studentId) {
		super();
		this.id = id;
		this.score = score;
		this.completed = completed;
		this.numberOfAttempts = numberOfAttempts;
		this.quizid = quizid;
		this.studentId = studentId;
	}

	/**
	 * 
	 */
	public Quizprogress() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Quizprogress [id=" + id + ", score=" + score + ", completed=" + completed + ", numberOfAttempts="
				+ numberOfAttempts + ", quizid=" + quizid + ", studentId=" + studentId + "]";
	}

	
}
