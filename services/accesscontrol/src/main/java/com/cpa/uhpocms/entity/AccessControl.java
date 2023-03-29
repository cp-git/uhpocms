/**
 * @author  - Code Generator
 * @createdOn -  29-03-2023
 * @Description Entity class for accesscontrol
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
@Table(name = "accesscontrol")
public class AccessControl {

//TODO - add attributed and genrate setters and getters


	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name = "userid")
	private int userId;
	
	
	@Column(name = "authuser")
	private boolean authUser;
	

	@Column(name = "admininstitute")
	private boolean adminInstitute;
	

	@Column(name = "role")
	private boolean role;
	

	@Column(name = "department")
	private boolean department;
	

	@Column(name = "announcement")
	private boolean announcement;
	

	@Column(name = "assigncourse")
	private boolean assignCourse;
	

	@Column(name = "category")
	private boolean category;
	

	@Column(name = "course")
	private boolean course;
	

	@Column(name = "email")
	private boolean email;
	

	@Column(name = "enrollment")
	private boolean enrollment;
	

	@Column(name = "module")
	private boolean module;
	

	@Column(name = "question")
	private boolean question;
	

	@Column(name = "quiz")
	private boolean quiz;


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
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}


	/**
	 * @return the authUser
	 */
	public boolean isAuthUser() {
		return authUser;
	}


	/**
	 * @param authUser the authUser to set
	 */
	public void setAuthUser(boolean authUser) {
		this.authUser = authUser;
	}


	/**
	 * @return the adminInstitute
	 */
	public boolean isAdminInstitute() {
		return adminInstitute;
	}


	/**
	 * @param adminInstitute the adminInstitute to set
	 */
	public void setAdminInstitute(boolean adminInstitute) {
		this.adminInstitute = adminInstitute;
	}


	/**
	 * @return the role
	 */
	public boolean isRole() {
		return role;
	}


	/**
	 * @param role the role to set
	 */
	public void setRole(boolean role) {
		this.role = role;
	}


	/**
	 * @return the department
	 */
	public boolean isDepartment() {
		return department;
	}


	/**
	 * @param department the department to set
	 */
	public void setDepartment(boolean department) {
		this.department = department;
	}


	/**
	 * @return the announcement
	 */
	public boolean isAnnouncement() {
		return announcement;
	}


	/**
	 * @param announcement the announcement to set
	 */
	public void setAnnouncement(boolean announcement) {
		this.announcement = announcement;
	}


	/**
	 * @return the assignCourse
	 */
	public boolean isAssignCourse() {
		return assignCourse;
	}


	/**
	 * @param assignCourse the assignCourse to set
	 */
	public void setAssignCourse(boolean assignCourse) {
		this.assignCourse = assignCourse;
	}


	/**
	 * @return the category
	 */
	public boolean isCategory() {
		return category;
	}


	/**
	 * @param category the category to set
	 */
	public void setCategory(boolean category) {
		this.category = category;
	}


	/**
	 * @return the course
	 */
	public boolean isCourse() {
		return course;
	}


	/**
	 * @param course the course to set
	 */
	public void setCourse(boolean course) {
		this.course = course;
	}


	/**
	 * @return the email
	 */
	public boolean isEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(boolean email) {
		this.email = email;
	}


	/**
	 * @return the enrollment
	 */
	public boolean isEnrollment() {
		return enrollment;
	}


	/**
	 * @param enrollment the enrollment to set
	 */
	public void setEnrollment(boolean enrollment) {
		this.enrollment = enrollment;
	}


	/**
	 * @return the module
	 */
	public boolean isModule() {
		return module;
	}


	/**
	 * @param module the module to set
	 */
	public void setModule(boolean module) {
		this.module = module;
	}


	/**
	 * @return the question
	 */
	public boolean isQuestion() {
		return question;
	}


	/**
	 * @param question the question to set
	 */
	public void setQuestion(boolean question) {
		this.question = question;
	}


	/**
	 * @return the quiz
	 */
	public boolean isQuiz() {
		return quiz;
	}


	/**
	 * @param quiz the quiz to set
	 */
	public void setQuiz(boolean quiz) {
		this.quiz = quiz;
	}


	/**
	 * @param id
	 * @param userId
	 * @param authUser
	 * @param adminInstitute
	 * @param role
	 * @param department
	 * @param announcement
	 * @param assignCourse
	 * @param category
	 * @param course
	 * @param email
	 * @param enrollment
	 * @param module
	 * @param question
	 * @param quiz
	 */
	public AccessControl(int id, int userId, boolean authUser, boolean adminInstitute, boolean role, boolean department,
			boolean announcement, boolean assignCourse, boolean category, boolean course, boolean email,
			boolean enrollment, boolean module, boolean question, boolean quiz) {
		super();
		this.id = id;
		this.userId = userId;
		this.authUser = authUser;
		this.adminInstitute = adminInstitute;
		this.role = role;
		this.department = department;
		this.announcement = announcement;
		this.assignCourse = assignCourse;
		this.category = category;
		this.course = course;
		this.email = email;
		this.enrollment = enrollment;
		this.module = module;
		this.question = question;
		this.quiz = quiz;
	}


	/**
	 * 
	 */
	public AccessControl() {
		super();
	}


	@Override
	public String toString() {
		return "AccessControl [id=" + id + ", userId=" + userId + ", authUser=" + authUser + ", adminInstitute="
				+ adminInstitute + ", role=" + role + ", department=" + department + ", announcement=" + announcement
				+ ", assignCourse=" + assignCourse + ", category=" + category + ", course=" + course + ", email="
				+ email + ", enrollment=" + enrollment + ", module=" + module + ", question=" + question + ", quiz="
				+ quiz + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
