/**
 * @author  - Code Generator
 * @createdOn -  01-06-2023
 * @Description Entity class for teacher_studentquizresult
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
@Table(name = "teacher_studentquizresult")
public class Studentquizresult {

//TODO - add attributed and genrate setters and getters

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int Id;

	@Column(name = "studentid")
	private int studentId;

	@Column(name = "quizid", nullable = false)
	private int quizId;

	@Column(name = "questionid", nullable = false)
	private int questionId;

	@Column(name = "content", nullable = false)
	private String questionContent;

	@Column(name = "selectedOption", nullable = false)
	private boolean selectedOption;

	@Column(name = "answerid", nullable = false)
	private int answerId;

	@Column(name = "teacher_remark", nullable = true)
	private String teacherRemark;

	@Column(name = "marks", nullable = false)
	private int marks;
	/**
	 * @param id
	 * @param studentId
	 * @param quizId
	 * @param questionId
	 * @param questionContent
	 * @param selectedOption
	 * @param answerId
	 * @param teacherRemark
	 * @param marks
	 */
	public Studentquizresult(int id, int studentId, int quizId, int questionId, String questionContent,
			boolean selectedOption, int answerId, String teacherRemark, int marks) {
		super();
		Id = id;
		this.studentId = studentId;
		this.quizId = quizId;
		this.questionId = questionId;
		this.questionContent = questionContent;
		this.selectedOption = selectedOption;
		this.answerId = answerId;
		this.teacherRemark = teacherRemark;
		this.marks = marks;
	}

	/**
	 * @return the teacherRemark
	 */
	public String getTeacherRemark() {
		return teacherRemark;
	}

	/**
	 * @param teacherRemark the teacherRemark to set
	 */
	public void setTeacherRemark(String teacherRemark) {
		this.teacherRemark = teacherRemark;
	}

	/**
	 * @return the marks
	 */
	public int getMarks() {
		return marks;
	}

	/**
	 * @param marks the marks to set
	 */
	public void setMarks(int marks) {
		this.marks = marks;
	}

	/**
	 * @param id
	 * @param studentId
	 * @param quizId
	 * @param questionId
	 * @param questionContent
	 * @param selectedOption
	 * @param answerId
	 */
	public Studentquizresult(int id, int studentId, int quizId, int questionId, String questionContent,
			boolean selectedOption, int answerId) {
		super();
		Id = id;
		this.studentId = studentId;
		this.quizId = quizId;
		this.questionId = questionId;
		this.questionContent = questionContent;
		this.selectedOption = selectedOption;
		this.answerId = answerId;
	}

	/**
	 * @return the answerId
	 */
	public int getAnswerId() {
		return answerId;
	}

	/**
	 * @param answerId the answerId to set
	 */
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
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
	 * @return the selectedOption
	 */
	public boolean isSelectedOption() {
		return selectedOption;
	}

	/**
	 * @param selectedOption the selectedOption to set
	 */
	public void setSelectedOption(boolean selectedOption) {
		this.selectedOption = selectedOption;
	}

	/**
	 * @param id
	 * @param studentId
	 * @param quizId
	 * @param questionId
	 * @param questionContent
	 * @param selectedOption
	 */
	public Studentquizresult(int id, int studentId, int quizId, int questionId, String questionContent,
			boolean selectedOption) {
		super();
		Id = id;
		this.studentId = studentId;
		this.quizId = quizId;
		this.questionId = questionId;
		this.questionContent = questionContent;
		this.selectedOption = selectedOption;
	}

	/**
	 * 
	 */
	public Studentquizresult() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Studentquizresult [Id=" + Id + ", studentId=" + studentId + ", quizId=" + quizId + ", questionId="
				+ questionId + ", questionContent=" + questionContent + ", selectedOption=" + selectedOption
				+ ", answerId=" + answerId + ", teacherRemark=" + teacherRemark + ", marks=" + marks + "]";
	}

}
