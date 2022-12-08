/**
 * @author  - Code Generator
 * @createdOn -  06-12-2022
 * @Description Entity class for teacher_question
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

@Entity
@Table(name = "teacher_question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int questionId;

	@Column(name = "figure", nullable = false, unique = true)
	private String questionFigure;

	@Column(name = "content", nullable = false)
	private String questionContent;

	@Column(name = "explanation", nullable = false)
	private String questionExplanation;

	@Column(name = "questionorderno", nullable = false)
	private int questionOrderNo;

	@Column(name = "ismcq", nullable = false)
	private boolean questionIsMCQ;

	@Column(name = "quizid_id", nullable = false)
	private int questionQuizId;

	@Column(name = "category_id", nullable = false)
	private int questionCategoryId;

	@Column(name = "is_active", nullable = false)
	private boolean questionIsActive;

	@Column(name = "created_by", nullable = false)
	private String questionCreatedBy;

	@CreationTimestamp
	@Column(name = "created_on", nullable = false)
	private Date questionCreatedOn;

	@Column(name = "modified_by", nullable = false)
	private String questionModifiedBy;

	@UpdateTimestamp
	@Column(name = "modified_on", nullable = false)
	private Date questionModifiedOn;

	/**
	 * 
	 */
	public Question() {
		super();
	}

	/**
	 * @param questionFigure
	 * @param questionContent
	 * @param questionExplanation
	 * @param questionOrderNo
	 * @param questionIsMCQ
	 * @param questionQuizId
	 * @param questionCategoryId
	 * @param questionIsActive
	 */
	public Question(String questionFigure, String questionContent, String questionExplanation, int questionOrderNo,
			boolean questionIsMCQ, int questionQuizId, int questionCategoryId, boolean questionIsActive) {
		super();
		this.questionFigure = questionFigure;
		this.questionContent = questionContent;
		this.questionExplanation = questionExplanation;
		this.questionOrderNo = questionOrderNo;
		this.questionIsMCQ = questionIsMCQ;
		this.questionQuizId = questionQuizId;
		this.questionCategoryId = questionCategoryId;
		this.questionIsActive = questionIsActive;
	}

	/**
	 * @param questionId
	 * @param questionFigure
	 * @param questionContent
	 * @param questionExplanation
	 * @param questionOrderNo
	 * @param questionIsMCQ
	 * @param questionQuizId
	 * @param questionCategoryId
	 * @param questionIsActive
	 * @param questionCreatedBy
	 * @param questionCreatedOn
	 * @param questionModifiedBy
	 * @param questionModifiedOn
	 */
	public Question(int questionId, String questionFigure, String questionContent, String questionExplanation,
			int questionOrderNo, boolean questionIsMCQ, int questionQuizId, int questionCategoryId,
			boolean questionIsActive, String questionCreatedBy, Date questionCreatedOn, String questionModifiedBy,
			Date questionModifiedOn) {
		super();
		this.questionId = questionId;
		this.questionFigure = questionFigure;
		this.questionContent = questionContent;
		this.questionExplanation = questionExplanation;
		this.questionOrderNo = questionOrderNo;
		this.questionIsMCQ = questionIsMCQ;
		this.questionQuizId = questionQuizId;
		this.questionCategoryId = questionCategoryId;
		this.questionIsActive = questionIsActive;
		this.questionCreatedBy = questionCreatedBy;
		this.questionCreatedOn = questionCreatedOn;
		this.questionModifiedBy = questionModifiedBy;
		this.questionModifiedOn = questionModifiedOn;
	}

	/**
	 * @return the questionId
	 */
	public int getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	/**
	 * @return the questionFigure
	 */
	public String getQuestionFigure() {
		return questionFigure;
	}

	/**
	 * @param questionFigure the questionFigure to set
	 */
	public void setQuestionFigure(String questionFigure) {
		this.questionFigure = questionFigure;
	}

	/**
	 * @return the questionContent
	 */
	public String getQuestionContent() {
		return questionContent;
	}

	/**
	 * @param questionContent the questionContent to set
	 */
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	/**
	 * @return the questionExplanation
	 */
	public String getQuestionExplanation() {
		return questionExplanation;
	}

	/**
	 * @param questionExplanation the questionExplanation to set
	 */
	public void setQuestionExplanation(String questionExplanation) {
		this.questionExplanation = questionExplanation;
	}

	/**
	 * @return the questionOrderNo
	 */
	public int getQuestionOrderNo() {
		return questionOrderNo;
	}

	/**
	 * @param questionOrderNo the questionOrderNo to set
	 */
	public void setQuestionOrderNo(int questionOrderNo) {
		this.questionOrderNo = questionOrderNo;
	}

	/**
	 * @return the questionIsMCQ
	 */
	public boolean isQuestionIsMCQ() {
		return questionIsMCQ;
	}

	/**
	 * @param questionIsMCQ the questionIsMCQ to set
	 */
	public void setQuestionIsMCQ(boolean questionIsMCQ) {
		this.questionIsMCQ = questionIsMCQ;
	}

	/**
	 * @return the questionQuizId
	 */
	public int getQuestionQuizId() {
		return questionQuizId;
	}

	/**
	 * @param questionQuizId the questionQuizId to set
	 */
	public void setQuestionQuizId(int questionQuizId) {
		this.questionQuizId = questionQuizId;
	}

	/**
	 * @return the questionCategoryId
	 */
	public int getQuestionCategoryId() {
		return questionCategoryId;
	}

	/**
	 * @param questionCategoryId the questionCategoryId to set
	 */
	public void setQuestionCategoryId(int questionCategoryId) {
		this.questionCategoryId = questionCategoryId;
	}

	/**
	 * @return the questionIsActive
	 */
	public boolean isQuestionIsActive() {
		return questionIsActive;
	}

	/**
	 * @param questionIsActive the questionIsActive to set
	 */
	public void setQuestionIsActive(boolean questionIsActive) {
		this.questionIsActive = questionIsActive;
	}

	/**
	 * @return the questionCreatedBy
	 */
	public String getQuestionCreatedBy() {
		return questionCreatedBy;
	}

	/**
	 * @param questionCreatedBy the questionCreatedBy to set
	 */
	public void setQuestionCreatedBy(String questionCreatedBy) {
		this.questionCreatedBy = questionCreatedBy;
	}

	/**
	 * @return the questionCreatedOn
	 */
	public Date getQuestionCreatedOn() {
		return questionCreatedOn;
	}

	/**
	 * @param questionCreatedOn the questionCreatedOn to set
	 */
	public void setQuestionCreatedOn(Date questionCreatedOn) {
		this.questionCreatedOn = questionCreatedOn;
	}

	/**
	 * @return the questionModifiedBy
	 */
	public String getQuestionModifiedBy() {
		return questionModifiedBy;
	}

	/**
	 * @param questionModifiedBy the questionModifiedBy to set
	 */
	public void setQuestionModifiedBy(String questionModifiedBy) {
		this.questionModifiedBy = questionModifiedBy;
	}

	/**
	 * @return the questionModifiedOn
	 */
	public Date getQuestionModifiedOn() {
		return questionModifiedOn;
	}

	/**
	 * @param questionModifiedOn the questionModifiedOn to set
	 */
	public void setQuestionModifiedOn(Date questionModifiedOn) {
		this.questionModifiedOn = questionModifiedOn;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionFigure=" + questionFigure + ", questionContent="
				+ questionContent + ", questionExplanation=" + questionExplanation + ", questionOrderNo="
				+ questionOrderNo + ", questionIsMCQ=" + questionIsMCQ + ", questionQuizId=" + questionQuizId
				+ ", questionCategoryId=" + questionCategoryId + ", questionIsActive=" + questionIsActive
				+ ", questionCreatedBy=" + questionCreatedBy + ", questionCreatedOn=" + questionCreatedOn
				+ ", questionModifiedBy=" + questionModifiedBy + ", questionModifiedOn=" + questionModifiedOn + "]";
	}

}
