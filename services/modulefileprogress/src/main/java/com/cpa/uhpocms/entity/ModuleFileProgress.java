/**
 * @author  - Code Generator
 * @createdOn -  04-04-2023
 * @Description Entity class for teacher_studentmodulefileprogress
 * 
 */

package com.cpa.uhpocms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher_studentmodulefileprogress")
public class ModuleFileProgress {

//TODO - add attributed and genrate setters and getters

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "progress", nullable = false)
	private float progress;

	@Column(name = "currentfilepageno", nullable = false)
	private int currentFilePageNo;

	@Column(name = "fileid_id", nullable = false)
	private int fileId;

	@Column(name = "moduleid_id", nullable = false)
	private int moduleId;

	@Column(name = "studentid_id", nullable = false)
	private int studentId;
	

	@Column(name = "courseid_id", nullable = false)
	private int courseId;


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
	 * @return the progress
	 */
	public float getProgress() {
		return progress;
	}


	/**
	 * @param progress the progress to set
	 */
	public void setProgress(float progress) {
		this.progress = progress;
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
	 * @param id
	 * @param progress
	 * @param currentFilePageNo
	 * @param fileId
	 * @param moduleId
	 * @param studentId
	 * @param courseId
	 */
	public ModuleFileProgress(int id, float progress, int currentFilePageNo, int fileId, int moduleId, int studentId,
			int courseId) {
		super();
		this.id = id;
		this.progress = progress;
		this.currentFilePageNo = currentFilePageNo;
		this.fileId = fileId;
		this.moduleId = moduleId;
		this.studentId = studentId;
		this.courseId = courseId;
	}


	/**
	 * 
	 */
	public ModuleFileProgress() {
		super();
	}


	@Override
	public String toString() {
		return "ModuleFileProgress [id=" + id + ", progress=" + progress + ", currentFilePageNo=" + currentFilePageNo
				+ ", fileId=" + fileId + ", moduleId=" + moduleId + ", studentId=" + studentId + ", courseId="
				+ courseId + "]";
	}



}
