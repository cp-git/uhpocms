/**
 * @author  - Code Generator
 * @createdOn -  10-01-2023
 * @Description Entity class for teacher_course
 * 
 */

package com.cpa.uhpocms.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "teacher_course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courseid", nullable = false)
	private int courseId;

	@Column(name = "name", nullable = false)
	private String courseName;

	@Column(name = "description", nullable = false)
	private String courseDescription;

	@Column(name = "isactive")
	private boolean courseIsActive;

	@Column(name = "coursecode")
	private String courseCode;

	@Column(name = "coursetype")
	private String courseType;

	@Column(name = "passingscore")
	private String passingScore;

	
	

	@Column(name = "createdby")
	private String courseCreatedBy;

	@CreationTimestamp
	@Column(name = "createddate", nullable = false)
	private Date courseCreatedDate;

	@Column(name = "updatedby")
	private String courseUpdatedBy;

	@UpdateTimestamp
	@Column(name = "updateddate", nullable = false)
	private Date courseUpdatedDate;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name="instid",insertable=false,updatable=false)
	private Course course;
	
	
	
	private int instId;
	
	
	
	@OneToMany(targetEntity=Module.class, mappedBy="course",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Module> module;
	
	
	
	
	
	
	
	
	
	

	/**
	 * @param courseId
	 * @param courseName
	 * @param courseDescription
	 * @param courseIsActive
	 * @param courseCode
	 * @param courseType
	 * @param passingScore
	 * @param instId
	 * @param courseCreatedBy
	 * @param courseCreatedDate
	 * @param courseUpdatedBy
	 * @param courseUpdatedDate
	 */
	public Course(int courseId, String courseName, String courseDescription, boolean courseIsActive, String courseCode,
			String courseType, String passingScore, int instId, String courseCreatedBy, Date courseCreatedDate,
			String courseUpdatedBy, Date courseUpdatedDate) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseIsActive = courseIsActive;
		this.courseCode = courseCode;
		this.courseType = courseType;
		this.passingScore = passingScore;
		this.instId = instId;
		this.courseCreatedBy = courseCreatedBy;
		this.courseCreatedDate = courseCreatedDate;
		this.courseUpdatedBy = courseUpdatedBy;
		this.courseUpdatedDate = courseUpdatedDate;
	}

	/**
	 * 
	 */
	public Course() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the courseDescription
	 */
	public String getCourseDescription() {
		return courseDescription;
	}

	/**
	 * @param courseDescription the courseDescription to set
	 */
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	/**
	 * @return the courseIsActive
	 */
	public boolean isCourseIsActive() {
		return courseIsActive;
	}

	/**
	 * @param courseIsActive the courseIsActive to set
	 */
	public void setCourseIsActive(boolean courseIsActive) {
		this.courseIsActive = courseIsActive;
	}

	/**
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}

	/**
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * @return the courseType
	 */
	public String getCourseType() {
		return courseType;
	}

	/**
	 * @param courseType the courseType to set
	 */
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	/**
	 * @return the passingScore
	 */
	public String getPassingScore() {
		return passingScore;
	}

	/**
	 * @param passingScore the passingScore to set
	 */
	public void setPassingScore(String passingScore) {
		this.passingScore = passingScore;
	}

	/**
	 * @return the instId
	 */
	public int getInstId() {
		return instId;
	}

	/**
	 * @param instId the instId to set
	 */
	public void setInstId(int instId) {
		this.instId = instId;
	}

	/**
	 * @return the courseCreatedBy
	 */
	public String getCourseCreatedBy() {
		return courseCreatedBy;
	}

	/**
	 * @param courseCreatedBy the courseCreatedBy to set
	 */
	public void setCourseCreatedBy(String courseCreatedBy) {
		this.courseCreatedBy = courseCreatedBy;
	}

	/**
	 * @return the courseCreatedDate
	 */
	public Date getCourseCreatedDate() {
		return courseCreatedDate;
	}

	/**
	 * @param courseCreatedDate the courseCreatedDate to set
	 */
	public void setCourseCreatedDate(Date courseCreatedDate) {
		this.courseCreatedDate = courseCreatedDate;
	}

	/**
	 * @return the courseUpdatedBy
	 */
	public String getCourseUpdatedBy() {
		return courseUpdatedBy;
	}

	/**
	 * @param courseUpdatedBy the courseUpdatedBy to set
	 */
	public void setCourseUpdatedBy(String courseUpdatedBy) {
		this.courseUpdatedBy = courseUpdatedBy;
	}

	/**
	 * @return the courseUpdatedDate
	 */
	public Date getCourseUpdatedDate() {
		return courseUpdatedDate;
	}

	/**
	 * @param courseUpdatedDate the courseUpdatedDate to set
	 */
	public void setCourseUpdatedDate(Date courseUpdatedDate) {
		this.courseUpdatedDate = courseUpdatedDate;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDescription="
				+ courseDescription + ", courseIsActive=" + courseIsActive + ", courseCode=" + courseCode
				+ ", courseType=" + courseType + ", passingScore=" + passingScore + ", instId=" + instId
				+ ", courseCreatedBy=" + courseCreatedBy + ", courseCreatedDate=" + courseCreatedDate
				+ ", courseUpdatedBy=" + courseUpdatedBy + ", courseUpdatedDate=" + courseUpdatedDate + "]";
	}

}
