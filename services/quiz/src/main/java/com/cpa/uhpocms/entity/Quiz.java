/**
 * @author  - Code Generator
 * @createdOn -  06-12-2022
 * @Description Entity class for Teacher_quiz
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
@Table(name = "teacher_quiz")
public class Quiz {

//TODO - add attributed and genrate setters and getters

	@Column(name = "quizid")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quizId;

	@Column(name = "title", unique=true)
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "url")
	private String url;

	@Column(name = "random_order")
	private boolean randomOrder;

	@Column(name = "max_questions")
	private int maxQuestions;

	@Column(name = "answers_at_end")
	private boolean answersAtEnd;

	@Column(name = "exam_paper")
	private boolean examPaper;

	@Column(name = "single_attempt")
	private boolean singleAttempt;

	@Column(name = "pass_mark")
	private int passMark;

	@Column(name = "success_text")
	private String successText;

	@Column(name = "fail_text")
	private String failText;

	@Column(name = "draft")
	private boolean draft;

	@Column(name = "quizorderno")
	private int quizOrderNo;

	@Column(name = "courseid_id")
	private int courseId;

	@Column(name = "module_id")
	private int moduleId;

	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "set_timer")
	private Integer setTimer;


	@Column(name = "isactive")
	private boolean isActive;

	@Column(name = "modifiedby")
	private String modifiedBy;

	@Column(name = "createdby")
	private String createdBy;

	@CreationTimestamp
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", timezone = "Asia/Kolkata")
	@Column(name = "createdon", nullable = false)
	private Date createdOn;

	@UpdateTimestamp
	@Column(name = "modifiedon")
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", timezone = "Asia/Kolkata")
	private Date modifiedOn;

	/**
	 * 
	 */
	public Quiz() {
		super();
	}

	/**
	 * @param quizId
	 * @param title
	 * @param description
	 * @param url
	 * @param randomOrder
	 * @param maxQuestions
	 * @param answersAtEnd
	 * @param examPaper
	 * @param singleAttempt
	 * @param passMark
	 * @param successText
	 * @param failText
	 * @param draft
	 * @param quizOrderNo
	 * @param courseidId
	 * @param moduleId
	 * @param categoryId
	 * @param isActive
	 * @param modifiedBy
	 * @param createdBy
	 * @param createdOn
	 * @param modifiedOn
	 */
	public Quiz(int quizId, String title, String description, String url, Boolean randomOrder, int maxQuestions,
			boolean answersAtEnd, boolean examPaper, boolean singleAttempt, int passMark, String successText,
			String failText, boolean draft, int quizOrderNo, int courseId, int moduleId, int categoryId,
			boolean isActive, String modifiedBy, String createdBy, Date createdOn, Date modifiedOn,int setTimer) {
		super();
		this.quizId = quizId;
		this.title = title;
		this.description = description;
		this.url = url;
		this.randomOrder = randomOrder;
		this.maxQuestions = maxQuestions;
		this.answersAtEnd = answersAtEnd;
		this.examPaper = examPaper;
		this.singleAttempt = singleAttempt;
		this.passMark = passMark;
		this.successText = successText;
		this.failText = failText;
		this.draft = draft;
		this.quizOrderNo = quizOrderNo;
		this.courseId = courseId;
		this.moduleId = moduleId;
		this.categoryId = categoryId;
		this.isActive = isActive;
		this.modifiedBy = modifiedBy;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
		 this.setTimer = setTimer;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the randomOrder
	 */
	public Boolean getRandomOrder() {
		return randomOrder;
	}

	/**
	 * @param randomOrder the randomOrder to set
	 */
	public void setRandomOrder(Boolean randomOrder) {
		this.randomOrder = randomOrder;
	}

	/**
	 * @return the maxQuestions
	 */
	public int getMaxQuestions() {
		return maxQuestions;
	}

	/**
	 * @param maxQuestions the maxQuestions to set
	 */
	public void setMaxQuestions(int maxQuestions) {
		this.maxQuestions = maxQuestions;
	}

	/**
	 * @return the answersAtEnd
	 */
	public boolean isAnswersAtEnd() {
		return answersAtEnd;
	}

	/**
	 * @param answersAtEnd the answersAtEnd to set
	 */
	public void setAnswersAtEnd(boolean answersAtEnd) {
		this.answersAtEnd = answersAtEnd;
	}

	/**
	 * @return the examPaper
	 */
	public boolean isExamPaper() {
		return examPaper;
	}

	/**
	 * @param examPaper the examPaper to set
	 */
	public void setExamPaper(boolean examPaper) {
		this.examPaper = examPaper;
	}

	/**
	 * @return the singleAttempt
	 */
	public boolean isSingleAttempt() {
		return singleAttempt;
	}

	/**
	 * @param singleAttempt the singleAttempt to set
	 */
	public void setSingleAttempt(boolean singleAttempt) {
		this.singleAttempt = singleAttempt;
	}

	/**
	 * @return the passMark
	 */
	public int getPassMark() {
		return passMark;
	}

	/**
	 * @param passMark the passMark to set
	 */
	public void setPassMark(int passMark) {
		this.passMark = passMark;
	}

	/**
	 * @return the successText
	 */
	public String getSuccessText() {
		return successText;
	}

	/**
	 * @param successText the successText to set
	 */
	public void setSuccessText(String successText) {
		this.successText = successText;
	}

	/**
	 * @return the failText
	 */
	public String getFailText() {
		return failText;
	}

	/**
	 * @param failText the failText to set
	 */
	public void setFailText(String failText) {
		this.failText = failText;
	}

	/**
	 * @return the draft
	 */
	public boolean isDraft() {
		return draft;
	}

	/**
	 * @param draft the draft to set
	 */
	public void setDraft(boolean draft) {
		this.draft = draft;
	}

	/**
	 * @return the quizOrderNo
	 */
	public int getQuizOrderNo() {
		return quizOrderNo;
	}

	/**
	 * @param quizOrderNo the quizOrderNo to set
	 */
	public void setQuizOrderNo(int quizOrderNo) {
		this.quizOrderNo = quizOrderNo;
	}

	/**
	 * @return the courseidId
	 */
	public int getCourseId() {
		return courseId;
	}

	/**
	 * @param courseidId the courseidId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the moduleId
	 */
	public int getModuleId() {
		return moduleId;
	}

	/**
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the modifiedOn
	 */
	public Date getModifiedOn() {
		return modifiedOn;
	}

	/**
	 * @param modifiedOn the modifiedOn to set
	 */
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	public Integer getSetTimer() {
	    return setTimer;
	}

	public void setSetTimer(int setTimer) {
	    this.setTimer = setTimer;
	}
	

	/**
	 * @param quizId
	 * @param title
	 * @param description
	 * @param url
	 * @param randomOrder
	 * @param maxQuestions
	 * @param answersAtEnd
	 * @param examPaper
	 * @param singleAttempt
	 * @param passMark
	 * @param successText
	 * @param failText
	 * @param draft
	 * @param quizOrderNo
	 * @param courseId
	 * @param moduleId
	 * @param categoryId
	 * @param isActive
	 * @param modifiedBy
	 * @param createdBy
	 * @param createdOn
	 * @param modifiedOn
	 */
	public Quiz(int quizId, String title, String description, String url, boolean randomOrder, int maxQuestions,
			boolean answersAtEnd, boolean examPaper, boolean singleAttempt, int passMark, String successText,
			String failText, boolean draft, int quizOrderNo, int courseId, int moduleId, int categoryId,
			boolean isActive, String modifiedBy, String createdBy, Date createdOn, Date modifiedOn,int setTimer) {
		super();
		this.quizId = quizId;
		this.title = title;
		this.description = description;
		this.url = url;
		this.randomOrder = randomOrder;
		this.maxQuestions = maxQuestions;
		this.answersAtEnd = answersAtEnd;
		this.examPaper = examPaper;
		this.singleAttempt = singleAttempt;
		this.passMark = passMark;
		this.successText = successText;
		this.failText = failText;
		this.draft = draft;
		this.quizOrderNo = quizOrderNo;
		this.courseId = courseId;
		this.moduleId = moduleId;
		this.categoryId = categoryId;
		this.isActive = isActive;
		this.modifiedBy = modifiedBy;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
		 this.setTimer = setTimer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", title=" + title + ", description=" + description + ", url=" + url
				+ ", randomOrder=" + randomOrder + ", maxQuestions=" + maxQuestions + ", answersAtEnd=" + answersAtEnd
				+ ", examPaper=" + examPaper + ", singleAttempt=" + singleAttempt + ", passMark=" + passMark
				+ ", successText=" + successText + ", failText=" + failText + ", draft=" + draft + ", quizOrderNo="
				+ quizOrderNo + ", courseidId=" + courseId + ", moduleId=" + moduleId + ", categoryId=" + categoryId
				+ ", isActive=" + isActive + ", modifiedBy=" + modifiedBy + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", modifiedOn=" + modifiedOn + ",setTimer=" + setTimer+"]";
	}

}
