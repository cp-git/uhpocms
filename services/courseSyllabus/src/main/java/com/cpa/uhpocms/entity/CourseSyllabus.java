/**
 * @author  - Code Generator
 * @createdOn -  27-02-2023
 * @Description Entity class for teacher_coursesyllabus
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
@Table(name = "teacher_coursesyllabus")
public class CourseSyllabus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int courseSyllabusId;

	@Column(name = "syllabusfile", nullable = false)
	private String syllabusFile;

	@Column(name = "courseid_id", nullable = false)
	private int courseId;

	@Column(name = "isactive", nullable = false)
	private boolean courseSyllabusIsActive;

	@Column(name = "createdBy")
	private String createdBy;

	@Column(name = "modifiedBy")
	private String modifiedBy;

	@CreationTimestamp
	@Column(name = "createdOn")
	private Date createdOn;

	@UpdateTimestamp
	@Column(name = "modifiedOn")
	private Date modifiedOn;

	/**
	 * @return the courseSyllabusId
	 */
	public int getCourseSyllabusId() {
		return courseSyllabusId;
	}

	/**
	 * @param courseSyllabusId the courseSyllabusId to set
	 */
	public void setCourseSyllabusId(int courseSyllabusId) {
		this.courseSyllabusId = courseSyllabusId;
	}

	/**
	 * @return the syllabusFile
	 */
	public String getSyllabusFile() {
		return syllabusFile;
	}

	/**
	 * @param syllabusFile the syllabusFile to set
	 */
	public void setSyllabusFile(String syllabusFile) {
		this.syllabusFile = syllabusFile;
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
	 * @return the courseSyllabusIsActive
	 */
	public boolean isCourseSyllabusIsActive() {
		return courseSyllabusIsActive;
	}

	/**
	 * @param courseSyllabusIsActive the courseSyllabusIsActive to set
	 */
	public void setCourseSyllabusIsActive(boolean courseSyllabusIsActive) {
		this.courseSyllabusIsActive = courseSyllabusIsActive;
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

	/**
	 * 
	 */
	public CourseSyllabus() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CourseSyllabus [courseSyllabusId=" + courseSyllabusId + ", syllabusFile=" + syllabusFile + ", courseId="
				+ courseId + ", courseSyllabusIsActive=" + courseSyllabusIsActive + ", createdBy=" + createdBy
				+ ", modifiedBy=" + modifiedBy + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + "]";
	}

	/**
	 * @param courseSyllabusId
	 * @param syllabusFile
	 * @param courseId
	 * @param courseSyllabusIsActive
	 * @param createdBy
	 * @param modifiedBy
	 * @param createdOn
	 * @param modifiedOn
	 */
	public CourseSyllabus(int courseSyllabusId, String syllabusFile, int courseId, boolean courseSyllabusIsActive,
			String createdBy, String modifiedBy, Date createdOn, Date modifiedOn) {
		super();
		this.courseSyllabusId = courseSyllabusId;
		this.syllabusFile = syllabusFile;
		this.courseId = courseId;
		this.courseSyllabusIsActive = courseSyllabusIsActive;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
	}

}
