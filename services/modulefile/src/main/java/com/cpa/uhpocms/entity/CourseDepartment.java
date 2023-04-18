package com.cpa.uhpocms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "teacher_course_departmentid")
public class CourseDepartment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int courseDepartmentId;

	
	
	@Column(name = "course_id")
	private int courseId;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name="department_id",insertable=false,updatable=false)
	private AdminDepartment dept;

	
	private int department_id;

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

	

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	

	public CourseDepartment(int courseDepartmentId, int courseId, int department_id) {
		super();
		this.courseDepartmentId = courseDepartmentId;
		this.courseId = courseId;
		this.department_id = department_id;
	}

	public CourseDepartment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CourseDepartment [courseDepartmentId=" + courseDepartmentId + ", courseId=" + courseId
				+ ", departmentId=" + department_id + "]";
	}

}
