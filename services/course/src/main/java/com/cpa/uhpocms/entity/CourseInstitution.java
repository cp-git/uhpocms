package com.cpa.uhpocms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher_course_institutionid")
public class CourseInstitution {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int courseInstitutionId;

	@Column(name = "course_id")
	private int courseId;

	@Column(name = "institution_id")
	private int institutionId;

	public int getCourseInstitutionId() {
		return courseInstitutionId;
	}

	public void setCourseInstitutionId(int courseInstitutionId) {
		this.courseInstitutionId = courseInstitutionId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(int institutionId) {
		this.institutionId = institutionId;
	}

	public CourseInstitution(int courseInstitutionId, int courseId, int institutionId) {
		super();
		this.courseInstitutionId = courseInstitutionId;
		this.courseId = courseId;
		this.institutionId = institutionId;
	}

	public CourseInstitution() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CourseInstitution [courseInstitutionId=" + courseInstitutionId + ", courseId=" + courseId
				+ ", institutionId=" + institutionId + "]";
	}

}
