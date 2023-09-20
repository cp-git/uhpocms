/**
 * @author  - Code Generator
 * @createdOn -  23-02-2023
 * @Description Entity class for teacher_course_enrollToStudent
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
@Table(name = "teacher_course_enrollToStudent")
public class EnrollToStudent {

//TODO - add attributed and genrate setters and getters
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "course_id", nullable = false)
	private int courseId;
	
	@Column(name = "profile_id", nullable = false)
	private int profileId;

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
	 * @return the profileId
	 */
	public int getProfileId() {
		return profileId;
	}

	/**
	 * @param profileId the profileId to set
	 */
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	/**
	 * 
	 */
	public EnrollToStudent() {
		super();
	}

	/**
	 * @param id
	 * @param courseId
	 * @param profileId
	 */
	public EnrollToStudent(int id, int courseId, int profileId) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.profileId = profileId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EnrollToStudent [id=" + id + ", courseId=" + courseId + ", profileId=" + profileId + "]";
	}
	
	
	
	
	
	
}
