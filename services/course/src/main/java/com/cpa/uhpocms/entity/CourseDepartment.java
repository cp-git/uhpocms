package com.cpa.uhpocms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher_course_departmentid")
public class CourseDepartment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int courseDepartmentId;

	@Column(name = "course_id")
	private int courseId;

	@Column(name = "department_id")
	private int departmentId;

	public int getCourseDepartmentId() {
		return courseDepartmentId;
	}

	public void setCourseDepartmentId(int courseDepartmentId) {
		this.courseDepartmentId = courseDepartmentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public CourseDepartment(int courseDepartmentId, int courseId, int departmentId) {
		super();
		this.courseDepartmentId = courseDepartmentId;
		this.courseId = courseId;
		this.departmentId = departmentId;
	}

	public CourseDepartment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CourseDepartment [courseDepartmentId=" + courseDepartmentId + ", courseId=" + courseId
				+ ", departmentId=" + departmentId + "]";
	}

}
