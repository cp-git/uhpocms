/**
 * @author  - Code Generator
 * @createdOn -  07-12-2022
 * @Description Entity class for teacher_module
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
@Table(name = "teacher_module")
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "moduleid", nullable = false)
	private int moduleId;

	@Column(name = "name", nullable = false)
	private String moduleName;

	@Column(name = "description", nullable = false)
	private String moduleDescription;

	@Column(name = "isactive")
	private boolean moduleIsActive;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "startdate")
	private Date moduleStartDate;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "enddate")
	private Date moduleEndDate;

	@Column(name = "course")
	private int moduleCourse;

	@Column(name = "moduleorderno")
	private int moduleOrderNo;

	@Column(name = "courseid_id")
	private int courseId;

	@Column(name = "createdby")
	private String moduleCreatedBy;

	@CreationTimestamp
	@Column(name = "createddate", nullable = false)
	private Date moduleCreatedDate;

	@Column(name = "updatedby")
	private String moduleUpdatedBy;

	@UpdateTimestamp
	@Column(name = "updateddate", nullable = false)
	private Date moduleUpdatedDate;

	/**
	 * @param moduleId
	 * @param moduleName
	 * @param moduleDescription
	 * @param moduleIsActive
	 * @param moduleStartDate
	 * @param moduleEndDate
	 * @param moduleCourse
	 * @param moduleOrderNo
	 * @param courseId_id
	 * @param moduleCreatedBy
	 * @param moduleCreatedDate
	 * @param moduleUpdatedBy
	 * @param moduleUpdatedDate
	 */
	public Module(int moduleId, String moduleName, String moduleDescription, boolean moduleIsActive,
			Date moduleStartDate, Date moduleEndDate, int moduleCourse, int moduleOrderNo, int courseId_id,
			String moduleCreatedBy, Date moduleCreatedDate, String moduleUpdatedBy, Date moduleUpdatedDate) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.moduleDescription = moduleDescription;
		this.moduleIsActive = moduleIsActive;
		this.moduleStartDate = moduleStartDate;
		this.moduleEndDate = moduleEndDate;
		this.moduleCourse = moduleCourse;
		this.moduleOrderNo = moduleOrderNo;
		this.courseId = courseId_id;
		this.moduleCreatedBy = moduleCreatedBy;
		this.moduleCreatedDate = moduleCreatedDate;
		this.moduleUpdatedBy = moduleUpdatedBy;
		this.moduleUpdatedDate = moduleUpdatedDate;
	}

	/**
	 * 
	 */
	public Module() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Module(String moduleName, String moduleDescription, boolean moduleIsActive, Date moduleStartDate,
			Date moduleEndDate, int moduleCourse, int moduleOrderNo, int courseId_id) {
		// TODO Auto-generated constructor stub
		super();
		this.moduleName = moduleName;
		this.moduleDescription = moduleDescription;
		this.moduleIsActive = moduleIsActive;
		this.moduleStartDate = moduleStartDate;
		this.moduleEndDate = moduleEndDate;
		this.moduleCourse = moduleCourse;
		this.moduleOrderNo = moduleOrderNo;
		this.courseId = courseId_id;
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
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * @param moduleName the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/**
	 * @return the moduleDescription
	 */
	public String getModuleDescription() {
		return moduleDescription;
	}

	/**
	 * @param moduleDescription the moduleDescription to set
	 */
	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}

	/**
	 * @return the moduleIsActive
	 */
	public boolean isModuleIsActive() {
		return moduleIsActive;
	}

	/**
	 * @param moduleIsActive the moduleIsActive to set
	 */
	public void setModuleIsActive(boolean moduleIsActive) {
		this.moduleIsActive = moduleIsActive;
	}

	/**
	 * @return the moduleStartDate
	 */
	public Date getModuleStartDate() {
		return moduleStartDate;
	}

	/**
	 * @param moduleStartDate the moduleStartDate to set
	 */
	public void setModuleStartDate(Date moduleStartDate) {
		this.moduleStartDate = moduleStartDate;
	}

	/**
	 * @return the moduleEndDate
	 */
	public Date getModuleEndDate() {
		return moduleEndDate;
	}

	/**
	 * @param moduleEndDate the moduleEndDate to set
	 */
	public void setModuleEndDate(Date moduleEndDate) {
		this.moduleEndDate = moduleEndDate;
	}

	/**
	 * @return the moduleCourse
	 */
	public int getModuleCourse() {
		return moduleCourse;
	}

	/**
	 * @param moduleCourse the moduleCourse to set
	 */
	public void setModuleCourse(int moduleCourse) {
		this.moduleCourse = moduleCourse;
	}

	/**
	 * @return the moduleOrderNo
	 */
	public int getModuleOrderNo() {
		return moduleOrderNo;
	}

	/**
	 * @param moduleOrderNo the moduleOrderNo to set
	 */
	public void setModuleOrderNo(int moduleOrderNo) {
		this.moduleOrderNo = moduleOrderNo;
	}

	/**
	 * @return the courseId_id
	 */
	public int getCourseId_id() {
		return courseId;
	}

	/**
	 * @param courseId_id the courseId_id to set
	 */
	public void setCourseId_id(int courseId_id) {
		this.courseId = courseId_id;
	}

	/**
	 * @return the moduleCreatedBy
	 */
	public String getModuleCreatedBy() {
		return moduleCreatedBy;
	}

	/**
	 * @param moduleCreatedBy the moduleCreatedBy to set
	 */
	public void setModuleCreatedBy(String moduleCreatedBy) {
		this.moduleCreatedBy = moduleCreatedBy;
	}

	/**
	 * @return the moduleCreatedDate
	 */
	public Date getModuleCreatedDate() {
		return moduleCreatedDate;
	}

	/**
	 * @param moduleCreatedDate the moduleCreatedDate to set
	 */
	public void setModuleCreatedDate(Date moduleCreatedDate) {
		this.moduleCreatedDate = moduleCreatedDate;
	}

	/**
	 * @return the moduleUpdatedBy
	 */
	public String getModuleUpdatedBy() {
		return moduleUpdatedBy;
	}

	/**
	 * @param moduleUpdatedBy the moduleUpdatedBy to set
	 */
	public void setModuleUpdatedBy(String moduleUpdatedBy) {
		this.moduleUpdatedBy = moduleUpdatedBy;
	}

	/**
	 * @return the moduleUpdatedDate
	 */
	public Date getModuleUpdatedDate() {
		return moduleUpdatedDate;
	}

	/**
	 * @param moduleUpdatedDate the moduleUpdatedDate to set
	 */
	public void setModuleUpdatedDate(Date moduleUpdatedDate) {
		this.moduleUpdatedDate = moduleUpdatedDate;
	}

	@Override
	public String toString() {
		return "Module [moduleId=" + moduleId + ", moduleName=" + moduleName + ", moduleDescription="
				+ moduleDescription + ", moduleIsActive=" + moduleIsActive + ", moduleStartDate=" + moduleStartDate
				+ ", moduleEndDate=" + moduleEndDate + ", moduleCourse=" + moduleCourse + ", moduleOrderNo="
				+ moduleOrderNo + ", courseId_id=" + courseId + ", moduleCreatedBy=" + moduleCreatedBy
				+ ", moduleCreatedDate=" + moduleCreatedDate + ", moduleUpdatedBy=" + moduleUpdatedBy
				+ ", moduleUpdatedDate=" + moduleUpdatedDate + "]";
	}

}
