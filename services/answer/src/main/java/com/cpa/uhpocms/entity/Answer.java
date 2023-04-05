/**
 * @author  - Code Generator
 * @createdOn -  30-03-2023
 * @Description Entity class for Teacher_answer
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
@Table(name = "teacher_answer")
public class Answer {

//TODO - add attributed and genrate setters and getters
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "content")
	private String content;

	@Column(name = "correct")
	private boolean correct;

	@Column(name = "questionOrderNo")
	private int questionorderno;
	
	
	@Column(name = "questionid")
	private int questionid;

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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the correct
	 */
	public boolean isCorrect() {
		return correct;
	}

	/**
	 * @param correct the correct to set
	 */
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	/**
	 * @return the questionorderno
	 */
	public int getQuestionorderno() {
		return questionorderno;
	}

	/**
	 * @param questionorderno the questionorderno to set
	 */
	public void setQuestionorderno(int questionorderno) {
		this.questionorderno = questionorderno;
	}

	/**
	 * @return the quizid
	 */


	/**
	 * @return the questionid
	 */
	public int getQuestionid() {
		return questionid;
	}

	/**
	 * @param questionid the questionid to set
	 */
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	/**
	 * @param id
	 * @param content
	 * @param correct
	 * @param questionorderno
	 * @param quizid
	 * @param questionid
	 */
	public Answer(int id, String content, boolean correct, int questionorderno, int quizid, int questionid) {
		super();
		this.id = id;
		this.content = content;
		this.correct = correct;
		this.questionorderno = questionorderno;
		this.questionid = questionid;
	}

	/**
	 * 
	 */
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", content=" + content + ", correct=" + correct + ", questionorderno="
				+ questionorderno + ", quizid=" + ", questionid=" + questionid + "]";
	}

	

}
