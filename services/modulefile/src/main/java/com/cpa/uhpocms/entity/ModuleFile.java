/**
 * @author  - Code Generator
 * @createdOn -  13-02-2023
 * @Description Entity class for teacher_modulefile
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
@Table(name = "teacher_modulefile")
public class ModuleFile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int moduleFileId;

	@Column(name = "file", unique = true, nullable = false)
	private String moduleFile;

	@Column(name = "fileorderno")
	private int moduleFileOrderNo;

	@Column(name = "isactive")
	private boolean moduleFileIsActive;

	@Column(name = "moduleid_id")
	private int moduleId;

	@Column(name = "createdby")
	private String moduleFileCreatedBy;

	@CreationTimestamp
	@Column(name = "createddate", nullable = false)
	private Date moduleFileCreatedDate;

	@Column(name = "updatedby")
	private String moduleFileUpdatedBy;

	@UpdateTimestamp
	@Column(name = "updateddate", nullable = false)
	private Date moduleFileUpdatedDate;

	/**
	 * @return the moduleFileId
	 */
	public int getModuleFileId() {
		return moduleFileId;
	}

	/**
	 * @param moduleFileId the moduleFileId to set
	 */
	public void setModuleFileId(int moduleFileId) {
		this.moduleFileId = moduleFileId;
	}

	/**
	 * @return the moduleFile
	 */
	public String getModuleFile() {
		return moduleFile;
	}

	/**
	 * @param moduleFile the moduleFile to set
	 */
	public void setModuleFile(String moduleFile) {
		this.moduleFile = moduleFile;
	}

	/**
	 * @return the moduleFileOrderNo
	 */
	public int getModuleFileOrderNo() {
		return moduleFileOrderNo;
	}

	/**
	 * @param moduleFileOrderNo the moduleFileOrderNo to set
	 */
	public void setModuleFileOrderNo(int moduleFileOrderNo) {
		this.moduleFileOrderNo = moduleFileOrderNo;
	}

	/**
	 * @return the moduleFileIsActive
	 */
	public boolean isModuleFileIsActive() {
		return moduleFileIsActive;
	}

	/**
	 * @param moduleFileIsActive the moduleFileIsActive to set
	 */
	public void setModuleFileIsActive(boolean moduleFileIsActive) {
		this.moduleFileIsActive = moduleFileIsActive;
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
	 * @return the moduleFileCreatedBy
	 */
	public String getModuleFileCreatedBy() {
		return moduleFileCreatedBy;
	}

	/**
	 * @param moduleFileCreatedBy the moduleFileCreatedBy to set
	 */
	public void setModuleFileCreatedBy(String moduleFileCreatedBy) {
		this.moduleFileCreatedBy = moduleFileCreatedBy;
	}

	/**
	 * @return the moduleFileCreatedDate
	 */
	public Date getModuleFileCreatedDate() {
		return moduleFileCreatedDate;
	}

	/**
	 * @param moduleFileCreatedDate the moduleFileCreatedDate to set
	 */
	public void setModuleFileCreatedDate(Date moduleFileCreatedDate) {
		this.moduleFileCreatedDate = moduleFileCreatedDate;
	}

	/**
	 * @return the moduleFileUpdatedBy
	 */
	public String getModuleFileUpdatedBy() {
		return moduleFileUpdatedBy;
	}

	/**
	 * @param moduleFileUpdatedBy the moduleFileUpdatedBy to set
	 */
	public void setModuleFileUpdatedBy(String moduleFileUpdatedBy) {
		this.moduleFileUpdatedBy = moduleFileUpdatedBy;
	}

	/**
	 * @return the moduleFileUpdatedDate
	 */
	public Date getModuleFileUpdatedDate() {
		return moduleFileUpdatedDate;
	}

	/**
	 * @param moduleFileUpdatedDate the moduleFileUpdatedDate to set
	 */
	public void setModuleFileUpdatedDate(Date moduleFileUpdatedDate) {
		this.moduleFileUpdatedDate = moduleFileUpdatedDate;
	}

	/**
	 * @param moduleFileId
	 * @param moduleFile
	 * @param moduleFileOrderNo
	 * @param moduleFileIsActive
	 * @param moduleId_id
	 * @param moduleFileCreatedBy
	 * @param moduleFileCreatedDate
	 * @param moduleFileUpdatedBy
	 * @param moduleFileUpdatedDate
	 */
	public ModuleFile(int moduleFileId, String moduleFile, int moduleFileOrderNo, boolean moduleFileIsActive,
			int moduleId, String moduleFileCreatedBy, Date moduleFileCreatedDate, String moduleFileUpdatedBy,
			Date moduleFileUpdatedDate) {
		super();
		this.moduleFileId = moduleFileId;
		this.moduleFile = moduleFile;
		this.moduleFileOrderNo = moduleFileOrderNo;
		this.moduleFileIsActive = moduleFileIsActive;
		this.moduleId = moduleId;
		this.moduleFileCreatedBy = moduleFileCreatedBy;
		this.moduleFileCreatedDate = moduleFileCreatedDate;
		this.moduleFileUpdatedBy = moduleFileUpdatedBy;
		this.moduleFileUpdatedDate = moduleFileUpdatedDate;
	}

	/**
	 * 
	 */
	public ModuleFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ModuleFile [moduleFileId=" + moduleFileId + ", moduleFile=" + moduleFile + ", moduleFileOrderNo="
				+ moduleFileOrderNo + ", moduleFileIsActive=" + moduleFileIsActive + ", moduleId_id=" + moduleId
				+ ", moduleFileCreatedBy=" + moduleFileCreatedBy + ", moduleFileCreatedDate=" + moduleFileCreatedDate
				+ ", moduleFileUpdatedBy=" + moduleFileUpdatedBy + ", moduleFileUpdatedDate=" + moduleFileUpdatedDate
				+ "]";
	}

}
