/**
 * @author  - Code Generator
 * @createdOn -  04-04-2023
 * @Description Entity class for teacher_studentmodulefileprogress
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
@Table(name = "teacher_studentmodulefileprogress")
public class ModuleFileProgress {

//TODO - add attributed and genrate setters and getters


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "filecompleted", nullable = false)
	private boolean fileCompleted ;

	@Column(name = "currentfilepageno", nullable = false)
	private int currentFilePageNo;

	@Column(name = "fileid_id", nullable = false)
	private int fileId;
	
	@Column(name = "moduleid_id", nullable = false)
	private int moduleId;

	@Column(name = "studentid_id", nullable = false)
	private int studentId;

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
	 * @return the fileCompleted
	 */
	public boolean isFileCompleted() {
		return fileCompleted;
	}

	/**
	 * @param fileCompleted the fileCompleted to set
	 */
	public void setFileCompleted(boolean fileCompleted) {
		this.fileCompleted = fileCompleted;
	}

	/**
	 * @return the currentFilePageNo
	 */
	public int getCurrentFilePageNo() {
		return currentFilePageNo;
	}

	/**
	 * @param currentFilePageNo the currentFilePageNo to set
	 */
	public void setCurrentFilePageNo(int currentFilePageNo) {
		this.currentFilePageNo = currentFilePageNo;
	}

	

	
	/**
	 * @return the fileId
	 */
	public int getFileId() {
		return fileId;
	}

	/**
	 * @param fileId the fileId to set
	 */
	public void setFileId(int fileId) {
		this.fileId = fileId;
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
	 * @param id
	 * @param fileCompleted
	 * @param currentFilePageNo
	 * @param fieldId
	 * @param moduleId
	 * @param studentId
	 */
	public ModuleFileProgress(int id, boolean fileCompleted, int currentFilePageNo, int fieldId, int moduleId,
			int studentId) {
		super();
		this.id = id;
		this.fileCompleted = fileCompleted;
		this.currentFilePageNo = currentFilePageNo;
		this.fileId = fieldId;
		this.moduleId = moduleId;
		this.studentId = studentId;
	}

	/**
	 * 
	 */
	public ModuleFileProgress() {
		super();
	}

	@Override
	public String toString() {
		return "ModuleFileProgress [id=" + id + ", fileCompleted=" + fileCompleted + ", currentFilePageNo="
				+ currentFilePageNo + ", fieldId=" + fileId + ", moduleId=" + moduleId + ", studentId=" + studentId
				+ "]";
	}


	
}
